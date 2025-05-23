package com.tencent.mobileqq.ai;

import android.app.Activity;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/ai/AIAvatarKuiklyPagePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "z9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "isVisibleToUser", "setUserVisibleHint", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "d", "I", "appId", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "f", "Z", "loaded", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", tl.h.F, "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", "bindLogic", "<init>", "(I)V", "i", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIAvatarKuiklyPagePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean loaded;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IVasKuiklyNestPageFrame.b bindLogic;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/ai/AIAvatarKuiklyPagePart$a;", "", "", "APP_ID_AVATAR", "I", "APP_ID_PENDANT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.AIAvatarKuiklyPagePart$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21367);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIAvatarKuiklyPagePart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.appId = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(AIAvatarKuiklyPagePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IVasKuiklyNestPageFrame.b bVar = this$0.bindLogic;
        if (bVar != null) {
            ViewGroup viewGroup = this$0.container;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                viewGroup = null;
            }
            bVar.h0(viewGroup);
        }
    }

    private final void z9() {
        String str;
        int i3;
        long j3;
        if (this.bindLogic == null) {
            AppRuntime f16 = bg.f();
            ViewGroup viewGroup = null;
            if (f16 != null) {
                str = f16.getCurrentUid();
            } else {
                str = null;
            }
            if (str == null) {
                return;
            }
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(str, "AvatarPendantViewImpl");
            if (vasSimpleInfoWithUid != null) {
                i3 = vasSimpleInfoWithUid.faceId;
            } else {
                i3 = -1;
            }
            if (vasSimpleInfoWithUid != null) {
                j3 = vasSimpleInfoWithUid.pendantId;
            } else {
                j3 = -1;
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(KuiklyLaunchParams.PARAM_MODAL_MODE, "1");
            arrayMap.put("gxh_appId", String.valueOf(this.appId));
            arrayMap.put("avatar", String.valueOf(i3));
            arrayMap.put("pendent", String.valueOf(j3));
            final String buildVasKuiklySchema = ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).buildVasKuiklySchema("vas_avatar_panel", "vas_avatar_panel", arrayMap);
            this.bindLogic = ((IVasKuiklyNestPageFrame) QRoute.api(IVasKuiklyNestPageFrame.class)).newFrame("vas_avatar_panel", new Function0<String>(buildVasKuiklySchema) { // from class: com.tencent.mobileqq.ai.AIAvatarKuiklyPagePart$loadView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $schemaBuilder;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$schemaBuilder = buildVasKuiklySchema;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) buildVasKuiklySchema);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.$schemaBuilder : (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
            });
            ViewGroup viewGroup2 = this.container;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.ai.d
                @Override // java.lang.Runnable
                public final void run() {
                    AIAvatarKuiklyPagePart.A9(AIAvatarKuiklyPagePart.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        this.container = (ViewGroup) rootView;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        IVasKuiklyNestPageFrame.b bVar = this.bindLogic;
        if (bVar != null) {
            bVar.detachView();
        }
        this.bindLogic = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void setUserVisibleHint(boolean isVisibleToUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isVisibleToUser);
            return;
        }
        super.setUserVisibleHint(isVisibleToUser);
        if (QLog.isColorLevel()) {
            QLog.d("AIAvatarKuiklyPagePart", 2, "setUserVisibleHint: appId=" + this.appId + ", isVisibleToUser=" + isVisibleToUser);
        }
        if (isVisibleToUser && !this.loaded) {
            this.loaded = true;
            z9();
        }
        if (isVisibleToUser) {
            if (this.appId == 23) {
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onAvatarButtonAction(102);
            } else {
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantButtonAction(102);
            }
        }
    }
}
