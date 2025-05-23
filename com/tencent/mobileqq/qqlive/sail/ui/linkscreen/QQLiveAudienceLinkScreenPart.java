package com.tencent.mobileqq.qqlive.sail.ui.linkscreen;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.now.pkgame.pkgame.sei.Pos;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qo3.SeiConfig;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/QQLiveAudienceLinkScreenPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lmi2/e;", "Lcom/tencent/mobileqq/qqlive/callback/room/VideoSeiInfo;", "seiInfo", "", "oa", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "U9", "V9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "pkGameContainer", "", "f", "J", "lastSeiInfoTimestamp", "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", h.F, "Lkotlin/Lazy;", "ma", "()Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "pkViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "na", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceLinkScreenPart extends com.tencent.mobileqq.qqlive.sail.base.c implements mi2.e {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout pkGameContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastSeiInfoTimestamp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pkViewModel;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/QQLiveAudienceLinkScreenPart$a;", "", "", "SEI_INFO_INTERVAL", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAudienceLinkScreenPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52405);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceLinkScreenPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAudienceLinkScreenPart$pkViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceLinkScreenPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final e invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (e) QQLiveAudienceLinkScreenPart.this.getViewModel(e.class) : (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.pkViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e ma() {
        Object value = this.pkViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pkViewModel>(...)");
        return (e) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.room.e na() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean oa(VideoSeiInfo seiInfo) {
        if (seiInfo == null) {
            AegisLogger.INSTANCE.w("Audience|QQLiveAudienceLinkScreenPart", "initUI", "roomId=" + H9() + ", invalid sei info");
            return false;
        }
        if (this.pkGameContainer == null) {
            SeiConfig a16 = qo3.b.a(seiInfo.seiData);
            List<Pos> c16 = a16.c();
            if (c16 == null) {
                c16 = CollectionsKt__CollectionsKt.emptyList();
            }
            if (a16.e() && (!c16.isEmpty())) {
                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceLinkScreenPart", "initUI", "roomId=" + H9());
                startInit();
            } else {
                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceLinkScreenPart", "initUI", "not link config, " + a16);
            }
        }
        if (this.pkGameContainer == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.U9();
        com.tencent.mobileqq.qqlive.sail.room.e na5 = na();
        if (na5 != null) {
            na5.registerSeiInfoListener(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceLinkScreenPart", "onExitRoom", "roomId=" + H9());
        super.V9();
        com.tencent.mobileqq.qqlive.sail.room.e na5 = na();
        if (na5 != null) {
            na5.A(this);
        }
        ma().R1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f61042x2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        e ma5 = ma();
        boolean z16 = false;
        if (configuration != null && configuration.orientation == 2) {
            z16 = true;
        }
        ma5.S1(z16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f61222xj);
        } else {
            frameLayout = null;
        }
        this.pkGameContainer = frameLayout;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.qqlive.sail.room.e na5 = na();
        if (na5 != null) {
            na5.A(this);
        }
        ma().R1();
    }

    @Override // mi2.e
    public void q(@Nullable VideoSeiInfo seiInfo) {
        String stackTraceToString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) seiInfo);
            return;
        }
        if (System.currentTimeMillis() - this.lastSeiInfoTimestamp < 500) {
            return;
        }
        this.lastSeiInfoTimestamp = System.currentTimeMillis();
        try {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new QQLiveAudienceLinkScreenPart$onSeiInfo$1(this, seiInfo, null), 3, null);
        } catch (Exception e16) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            companion.e("Audience|QQLiveAudienceLinkScreenPart", "onSeiInfo", stackTraceToString);
        }
    }
}
