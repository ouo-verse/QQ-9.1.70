package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.relatedemo.RelatedEmotionMsgIntent;
import com.tencent.qqnt.emotion.relatedemo.api.IRelatedEmoPanelApi;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\b*\u0002$'\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/aio/helper/bc;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "g", "", "filePath", "j", tl.h.F, "Landroid/content/Context;", "context", "i", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "Lcom/tencent/qqnt/emotion/relatedemo/c;", "Lcom/tencent/qqnt/emotion/relatedemo/c;", "mVB", "Lcom/tencent/qqnt/emotion/relatedemo/d;", "f", "Lcom/tencent/qqnt/emotion/relatedemo/d;", "mVM", "com/tencent/mobileqq/aio/helper/bc$b", "Lcom/tencent/mobileqq/aio/helper/bc$b;", "action", "com/tencent/mobileqq/aio/helper/bc$c", "Lcom/tencent/mobileqq/aio/helper/bc$c;", "mConfigurationChangedCallback", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class bc implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.emotion.relatedemo.c mVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.emotion.relatedemo.d mVM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mConfigurationChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/bc$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.bc$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/bc$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bc.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                bc.this.g(i3);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/bc$c", "Lcom/tencent/aio/api/runtime/emitter/b;", "Landroid/content/res/Configuration;", "configuration", "", "onConfigurationChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.aio.api.runtime.emitter.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bc.this);
            }
        }

        @Override // com.tencent.aio.api.runtime.emitter.b
        public void onConfigurationChanged(@NotNull Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
                return;
            }
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            com.tencent.qqnt.emotion.relatedemo.d dVar = bc.this.mVM;
            if (dVar != null) {
                dVar.hidePanel();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52098);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.action = new b();
            this.mConfigurationChangedCallback = new c();
        }
    }

    private final void e() {
        if (QLog.isColorLevel()) {
            QLog.d("RelatedEmotionHelper", 2, "doOnCreate");
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(MsgIntent intent) {
        com.tencent.qqnt.emotion.relatedemo.d dVar;
        if (intent instanceof RelatedEmotionMsgIntent.SendPicEmotion) {
            j(((RelatedEmotionMsgIntent.SendPicEmotion) intent).a());
        } else if ((intent instanceof RelatedEmotionMsgIntent.ShowRelatedEmoPanel) && (dVar = this.mVM) != null) {
            dVar.a(((RelatedEmotionMsgIntent.ShowRelatedEmoPanel) intent).a());
        }
    }

    private final void h() {
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        Context context = bVar.a().c().getContext();
        if (context != null) {
            i(context);
        }
    }

    private final void i(Context context) {
        com.tencent.qqnt.emotion.relatedemo.d panelVM = ((IRelatedEmoPanelApi) QRoute.api(IRelatedEmoPanelApi.class)).getPanelVM();
        this.mVM = panelVM;
        if (panelVM != null) {
            com.tencent.qqnt.emotion.relatedemo.c panelVB = ((IRelatedEmoPanelApi) QRoute.api(IRelatedEmoPanelApi.class)).getPanelVB(context, panelVM);
            panelVB.a();
            com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar = null;
            }
            panelVB.b(bVar.a());
            this.mVB = panelVB;
        }
    }

    private final void j(final String filePath) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.bb
            @Override // java.lang.Runnable
            public final void run() {
                bc.k(filePath, this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String filePath, bc this$0) {
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List c16 = com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, filePath, null, true, 10, BaseApplication.context.getString(R.string.ypo), null, null, false, 224, null);
        AIOMsgService aIOMsgService = AIOMsgService.f190196a;
        com.tencent.aio.main.businesshelper.b bVar = this$0.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        aIOMsgService.z(new com.tencent.aio.msgservice.k(bVar.a().g().r(), c16));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 28;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.emotion.relatedemo.RelatedEmotionMsgIntent.SendPicEmotion");
        hashSet.add("com.tencent.qqnt.emotion.relatedemo.RelatedEmotionMsgIntent.ShowRelatedEmoPanel");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "RelatedEmotionHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (QLog.isColorLevel()) {
            QLog.d("RelatedEmotionHelper", 2, "onCreate");
        }
        this.helperParam = param;
        param.a().e().f(this, this.action);
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        bVar.a().b().a(com.tencent.aio.api.runtime.emitter.b.class).a(this.mConfigurationChangedCallback);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.action);
        com.tencent.aio.main.businesshelper.b bVar2 = this.helperParam;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar2 = null;
        }
        bVar2.a().b().a(com.tencent.aio.api.runtime.emitter.b.class).c(this.mConfigurationChangedCallback);
        com.tencent.qqnt.emotion.relatedemo.d dVar = this.mVM;
        if (dVar != null) {
            dVar.hidePanel();
        }
        this.mVM = null;
        this.mVB = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
        } else if (state == 0) {
            e();
        }
    }
}
