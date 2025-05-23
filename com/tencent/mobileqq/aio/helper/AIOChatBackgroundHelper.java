package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.help.b;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.stranger.api.IStrangerBackgroundApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AvatarBgChangeEvent;
import com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi;
import com.tencent.qqnt.aio.api.b;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0003H\u0016J$\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#`$H\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010.R\u001b\u00103\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/AIOChatBackgroundHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/aio/api/help/b;", "", DomainData.DOMAIN_NAME, "o", "g", "", "e", "", "j", "Lcom/tencent/qqnt/aio/adapter/api/IAIOChatBackgroundApi;", "chatBackgroundApi", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "peerId", "toRemove", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, tl.h.F, "i", "state", "onMoveToState", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Lcom/tencent/aio/main/businesshelper/b;", "I", "mCurBackgroundViewType", "f", "Lcom/tencent/qqnt/aio/adapter/api/IAIOChatBackgroundApi;", "mChatBackgroundApi", "Landroid/os/Handler;", "Landroid/os/Handler;", "mUiHandler", "Lkotlin/Lazy;", "k", "()Z", "setOnCreateAsyncSwitch", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOChatBackgroundHelper implements com.tencent.aio.main.businesshelper.h, SimpleEventReceiver<SimpleBaseEvent>, com.tencent.aio.api.help.b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mCurBackgroundViewType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IAIOChatBackgroundApi mChatBackgroundApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mUiHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy setOnCreateAsyncSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/AIOChatBackgroundHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.AIOChatBackgroundHelper$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/helper/AIOChatBackgroundHelper$b", "Lcom/tencent/qqnt/aio/api/b$c;", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements b.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f188845a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOChatBackgroundHelper f188846b;

        b(View view, AIOChatBackgroundHelper aIOChatBackgroundHelper) {
            this.f188845a = view;
            this.f188846b = aIOChatBackgroundHelper;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) aIOChatBackgroundHelper);
            }
        }

        @Override // com.tencent.qqnt.aio.api.b.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ColorStateList bgTextColor = ((com.tencent.qqnt.aio.api.b) this.f188845a).getBgTextColor();
            QLog.i("NTAIOChatBackgroundHelper", 1, "OnBackgroundChanged! color " + bgTextColor);
            if (bgTextColor != null) {
                AIOChatBackgroundHelper aIOChatBackgroundHelper = this.f188846b;
                com.tencent.aio.main.businesshelper.b bVar = aIOChatBackgroundHelper.param;
                com.tencent.aio.main.businesshelper.b bVar2 = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar = null;
                }
                String j3 = bVar.a().g().r().c().j();
                com.tencent.aio.main.businesshelper.b bVar3 = aIOChatBackgroundHelper.param;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                } else {
                    bVar2 = bVar3;
                }
                bVar2.a().e().h(new AIOBackgroundMsgIntent.UpdateBgTextColor(bgTextColor, j3));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOChatBackgroundHelper() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mChatBackgroundApi = (IAIOChatBackgroundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOChatBackgroundApi.class);
        this.mUiHandler = new Handler(Looper.getMainLooper());
        lazy = LazyKt__LazyJVMKt.lazy(AIOChatBackgroundHelper$setOnCreateAsyncSwitch$2.INSTANCE);
        this.setOnCreateAsyncSwitch = lazy;
    }

    private final int e() {
        if (n()) {
            return 2;
        }
        if (o()) {
            return 4;
        }
        return 1;
    }

    private final boolean g() {
        int e16 = e();
        QLog.i("NTAIOChatBackgroundHelper", 1, "[checkBackgroundViewTypeChange]: mCurBackgroundViewType " + this.mCurBackgroundViewType + ", newBackgroundViewType " + e16);
        if (this.mCurBackgroundViewType != e16) {
            this.mCurBackgroundViewType = e16;
            return true;
        }
        return false;
    }

    private final void j() {
        com.tencent.qqnt.aio.adapter.background.a aVar;
        View view;
        int i3;
        Context context;
        boolean z16;
        IAIOChatBackgroundApi iAIOChatBackgroundApi = (IAIOChatBackgroundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOChatBackgroundApi.class);
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        Fragment c16 = bVar.a().c();
        if (c16 != null && (context = c16.getContext()) != null) {
            com.tencent.aio.main.businesshelper.b bVar3 = this.param;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar3 = null;
            }
            String j3 = bVar3.a().g().r().c().j();
            com.tencent.aio.main.businesshelper.b bVar4 = this.param;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar4 = null;
            }
            AIOParam g16 = bVar4.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            int c17 = su3.c.c(g16);
            com.tencent.aio.main.businesshelper.b bVar5 = this.param;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar5 = null;
            }
            if (!com.tencent.mobileqq.aio.a.c(bVar5.a())) {
                com.tencent.aio.main.businesshelper.b bVar6 = this.param;
                if (bVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar6 = null;
                }
                if (!com.tencent.mobileqq.aio.a.d(bVar6.a())) {
                    z16 = true;
                    aVar = iAIOChatBackgroundApi.aioCreate(context, j3, c17, z16);
                }
            }
            z16 = false;
            aVar = iAIOChatBackgroundApi.aioCreate(context, j3, c17, z16);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            view = aVar.b();
        } else {
            view = null;
        }
        if (aVar != null) {
            i3 = aVar.a();
        } else {
            i3 = 0;
        }
        this.mCurBackgroundViewType = i3;
        if (view != null) {
            QLog.i("NTAIOChatBackgroundHelper", 1, "create add the view: " + view);
            if (view instanceof com.tencent.qqnt.aio.api.b) {
                ((com.tencent.qqnt.aio.api.b) view).setOnBackgroundChangedListener(new b(view, this));
            }
            com.tencent.aio.main.businesshelper.b bVar7 = this.param;
            if (bVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                bVar2 = bVar7;
            }
            bVar2.a().e().h(new FullBackgroundMviIntent.UpdateAIOBackground(view, false));
        }
    }

    private final boolean k() {
        return ((Boolean) this.setOnCreateAsyncSwitch.getValue()).booleanValue();
    }

    private final void m(String peerId, boolean toRemove) {
        QLog.i("NTAIOChatBackgroundHelper", 1, "[handleAvatarBackgroundChange]: peerId is " + peerId + ", toRemove " + toRemove + ", mCurBackgroundViewType " + this.mCurBackgroundViewType);
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        if (!Intrinsics.areEqual(peerId, bVar.a().g().r().c().j())) {
            QLog.i("NTAIOChatBackgroundHelper", 1, "[handleAvatarBackgroundChange]: peerId invalid");
            return;
        }
        if (toRemove || this.mCurBackgroundViewType != 2) {
            j();
            QLog.i("NTAIOChatBackgroundHelper", 1, "[handleAvatarBackgroundChange]: mCurBackgroundViewType " + this.mCurBackgroundViewType);
        }
        if (!toRemove && this.mCurBackgroundViewType == 2) {
            com.tencent.aio.main.businesshelper.b bVar3 = this.param;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                bVar2 = bVar3;
            }
            bVar2.a().e().h(FullBackgroundMviIntent.NotifyBackgroundChange.f188190d);
        }
    }

    private final boolean n() {
        IAIOChatBackgroundApi iAIOChatBackgroundApi = this.mChatBackgroundApi;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        String j3 = bVar.a().g().r().c().j();
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar3;
        }
        AIOParam g16 = bVar2.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        return iAIOChatBackgroundApi.isAvatarBackground(j3, su3.c.c(g16));
    }

    private final boolean o() {
        IStrangerBackgroundApi iStrangerBackgroundApi = (IStrangerBackgroundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerBackgroundApi.class);
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        String b16 = su3.c.b(g16);
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar3;
        }
        return iStrangerBackgroundApi.useMatchFriendAIOBackground(b16, Integer.valueOf(bVar2.a().g().r().c().e()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AIOChatBackgroundHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
        QLog.i("NTAIOChatBackgroundHelper", 1, "[create]: mCurBackgroundViewType " + this$0.mCurBackgroundViewType);
    }

    private final void q(final IAIOChatBackgroundApi chatBackgroundApi) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                AIOChatBackgroundHelper.r(IAIOChatBackgroundApi.this, this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(IAIOChatBackgroundApi chatBackgroundApi, AIOChatBackgroundHelper this$0) {
        Intrinsics.checkNotNullParameter(chatBackgroundApi, "$chatBackgroundApi");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.main.businesshelper.b bVar = this$0.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        String j3 = bVar.a().g().r().c().j();
        com.tencent.aio.main.businesshelper.b bVar3 = this$0.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar3 = null;
        }
        AIOParam g16 = bVar3.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        Drawable currentChatBackgroundDrawable = chatBackgroundApi.getCurrentChatBackgroundDrawable(j3, su3.c.c(g16));
        QLog.i("NTAIOChatBackgroundHelper", 1, "refresh last drawable " + currentChatBackgroundDrawable);
        com.tencent.aio.main.businesshelper.b bVar4 = this$0.param;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar4 = null;
        }
        bVar4.a().e().h(new FullBackgroundMviIntent.AIOBackgroundDrawable(currentChatBackgroundDrawable));
        com.tencent.aio.main.businesshelper.b bVar5 = this$0.param;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar5 = null;
        }
        String j16 = bVar5.a().g().r().c().j();
        com.tencent.aio.main.businesshelper.b bVar6 = this$0.param;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar6;
        }
        AIOParam g17 = bVar2.a().g();
        Intrinsics.checkNotNullExpressionValue(g17, "param.aioContext.aioParam");
        ((IBubbleTextColorManager) QRoute.api(IBubbleTextColorManager.class)).saveNativeAllChatBgMainPixel(chatBackgroundApi.getCurrentChatBackgroundBg(j16, su3.c.c(g17)));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(AvatarBgChangeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 31;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "NTAIOChatBackgroundHelper";
    }

    @Override // com.tencent.aio.api.help.b
    public void h(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        b.a.a(this, param);
        if (k()) {
            this.param = param;
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOChatBackgroundHelper.p(AIOChatBackgroundHelper.this);
                }
            });
        }
    }

    @Override // com.tencent.aio.api.help.b
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            b.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 4, 3, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            h.a.b(this);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, state);
            return;
        }
        if (state != 0) {
            if (state != 8) {
                if (state != 12) {
                    if (state != 3) {
                        if (state == 4) {
                            IAIOChatBackgroundApi iAIOChatBackgroundApi = this.mChatBackgroundApi;
                            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            Intrinsics.checkNotNull(peekAppRuntime);
                            String account = peekAppRuntime.getAccount();
                            Intrinsics.checkNotNullExpressionValue(account, "sMobileQQ.peekAppRuntime()!!.account");
                            iAIOChatBackgroundApi.aioDelayLoad(account);
                            return;
                        }
                        return;
                    }
                    if (g()) {
                        j();
                    }
                    QLog.i("NTAIOChatBackgroundHelper", 1, "[resume]: mCurBackgroundViewType " + this.mCurBackgroundViewType);
                    q(this.mChatBackgroundApi);
                    this.mChatBackgroundApi.aioResume();
                    return;
                }
                this.mChatBackgroundApi.aioDestroy();
                return;
            }
            this.mChatBackgroundApi.aioPause();
            return;
        }
        if (!k()) {
            j();
            QLog.i("NTAIOChatBackgroundHelper", 1, "[create]: mCurBackgroundViewType " + this.mCurBackgroundViewType);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof AvatarBgChangeEvent) {
            AvatarBgChangeEvent avatarBgChangeEvent = (AvatarBgChangeEvent) event;
            m(avatarBgChangeEvent.getPeerId(), avatarBgChangeEvent.getToRemove());
        }
    }
}
