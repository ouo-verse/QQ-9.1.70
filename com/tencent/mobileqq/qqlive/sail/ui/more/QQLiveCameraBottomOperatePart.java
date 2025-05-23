package com.tencent.mobileqq.qqlive.sail.ui.more;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqlive.anchor.live.dialog.AnchorLiveMorePopWindow;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.ui.more.bottom.BottomButtonView;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.linkpkanchorplay.entrance.BottomOperatorButton;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0007\u00a2\u0006\u0004\bb\u0010cJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010%\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u001eH\u0016R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0018\u0010G\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010@R\u0018\u0010I\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010@R\u001e\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020O0N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR#\u0010a\u001a\n \\*\u0004\u0018\u00010[0[8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveCameraBottomOperatePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Luq4/c;", "rsp", "", "Ca", "ta", "ua", "Aa", "za", "", "buttonId", "sa", WadlProxyConsts.KEY_JUMP_URL, "", "webRatio", "", "webTrans", "xa", "Lar4/a;", "data", "Ba", "eventId", "qa", "bubble", "pa", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "U9", "V9", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "Lfp4/c;", "msgInfo", "onPush", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqlive/anchor/live/dialog/AnchorLiveMorePopWindow;", "e", "Lcom/tencent/mobileqq/qqlive/anchor/live/dialog/AnchorLiveMorePopWindow;", "moreWindow", "Lcom/tencent/mobileqq/qqlive/anchor/live/b;", "f", "Lcom/tencent/mobileqq/qqlive/anchor/live/b;", "sailAnchorHelper", tl.h.F, "Luq4/c;", "dynamicConfigRsp", "i", "Z", "hasReceiveConfig", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView;", "button1", BdhLogUtil.LogTag.Tag_Conn, "button2", "D", "button3", "E", "button4", UserInfo.SEX_FEMALE, "button5", "", "G", "Ljava/util/List;", "buttonList", "", "Luq4/e;", "H", "[Luq4/e;", "btnDataArray", "Lcom/tencent/mobileqq/widget/tip/a;", "I", "Lcom/tencent/mobileqq/widget/tip/a;", "bubbleTip", "Landroid/widget/FrameLayout;", "J", "Landroid/widget/FrameLayout;", "pkBtnContainer", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "kotlin.jvm.PlatformType", "K", "Lkotlin/Lazy;", "ra", "()Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "bottomViewModel", "<init>", "()V", "L", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveCameraBottomOperatePart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button2;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button3;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button4;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button5;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<BottomButtonView> buttonList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private uq4.e[] btnDataArray;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.tip.a bubbleTip;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private FrameLayout pkBtnContainer;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorLiveMorePopWindow moreWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.anchor.live.b sailAnchorHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private uq4.c dynamicConfigRsp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasReceiveConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BottomButtonView button1;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveCameraBottomOperatePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveCameraBottomOperatePart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/more/QQLiveCameraBottomOperatePart$b", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ar4.a f272876a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveCameraBottomOperatePart f272877b;

        b(ar4.a aVar, QQLiveCameraBottomOperatePart qQLiveCameraBottomOperatePart) {
            this.f272876a = aVar;
            this.f272877b = qQLiveCameraBottomOperatePart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) qQLiveCameraBottomOperatePart);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveBottomMorePart", "BubbleTip onDismiss", "bubbleTip=" + this.f272876a.f26812c);
            this.f272877b.ra().P1(this.f272876a);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveBottomMorePart", "BubbleTip onShow", "bubbleTip=" + this.f272876a.f26812c);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveCameraBottomOperatePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.buttonList = new ArrayList();
        this.btnDataArray = new uq4.e[0];
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.more.b>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveCameraBottomOperatePart$bottomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraBottomOperatePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (b) QQLiveCameraBottomOperatePart.this.getViewModel(b.class) : (b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.bottomViewModel = lazy;
    }

    private final void Aa() {
        if (ht3.a.e("qqlive_enable_anchor_pk_feature", true)) {
            FrameLayout frameLayout = this.pkBtnContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f159089ck0);
                int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.c5h);
                BottomOperatorButton bottomOperatorButton = new BottomOperatorButton(getContext());
                bottomOperatorButton.setSizeParams(new Size(dimensionPixelSize, dimensionPixelSize), new Size(dimensionPixelSize2, dimensionPixelSize2));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.gravity = 17;
                frameLayout.addView(bottomOperatorButton, layoutParams);
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.pkBtnContainer;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ba(ar4.a data) {
        com.tencent.mobileqq.qqlive.sail.ui.more.b ra5 = ra();
        String str = data.f26811b;
        Intrinsics.checkNotNullExpressionValue(str, "data.bttnId");
        BottomButtonView d26 = ra5.d2(str, this.buttonList);
        if (d26 == null) {
            return;
        }
        com.tencent.mobileqq.widget.tip.a a16 = c.f272913a.a(d26, data);
        a16.f(new b(data, this));
        a16.s0();
        this.bubbleTip = a16;
    }

    private final void Ca(uq4.c rsp) {
        uq4.e[] eVarArr;
        uq4.e[] a16;
        if (rsp != null) {
            eVarArr = rsp.f439829d;
        } else {
            eVarArr = null;
        }
        if (eVarArr != null) {
            a16 = rsp.f439829d;
            Intrinsics.checkNotNullExpressionValue(a16, "{\n            rsp.interactBttn\n        }");
        } else {
            a16 = com.tencent.mobileqq.qqlive.sail.ui.more.bottom.a.f272911a.a();
        }
        this.btnDataArray = a16;
        int length = a16.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            uq4.e eVar = a16[i3];
            int i17 = i16 + 1;
            BottomButtonView bottomButtonView = this.buttonList.get(i16);
            if (bottomButtonView != null) {
                bottomButtonView.l(i16, eVar);
            }
            String str = eVar.f439836a;
            Intrinsics.checkNotNullExpressionValue(str, "data.id");
            qa(str, "ev_qqlive_abnormal_imp");
            i3++;
            i16 = i17;
        }
        za();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa(ar4.a bubble) {
        com.tencent.mobileqq.qqlive.sail.ui.more.b ra5 = ra();
        String str = bubble.f26811b;
        Intrinsics.checkNotNullExpressionValue(str, "bubble.bttnId");
        BottomButtonView d26 = ra5.d2(str, this.buttonList);
        if (d26 != null) {
            com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
            QQLiveDaTongParams f16 = aVar.f(H9());
            f16.d("em_qqlive_bottom_guide_bubble");
            String str2 = bubble.f26812c;
            Intrinsics.checkNotNullExpressionValue(str2, "bubble.tips");
            f16.o(str2);
            String str3 = bubble.f26811b;
            Intrinsics.checkNotNullExpressionValue(str3, "bubble.bttnId");
            f16.k(str3);
            f16.l(String.valueOf(d26.o()));
            f16.B("0");
            aVar.i("ev_qqlive_abnormal_imp", f16.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(String buttonId, String eventId) {
        BottomButtonView d26 = ra().d2(buttonId, this.buttonList);
        if (d26 != null) {
            com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
            QQLiveDaTongParams f16 = aVar.f(H9());
            f16.d("em_qqlive_bottom_function_button");
            f16.k(buttonId);
            f16.l(String.valueOf(d26.o()));
            f16.B("0");
            aVar.i(eventId, f16.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.more.b ra() {
        return (com.tencent.mobileqq.qqlive.sail.ui.more.b) this.bottomViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(String buttonId) {
        boolean z16;
        uq4.e U1;
        switch (buttonId.hashCode()) {
            case 47653683:
                if (buttonId.equals("20001")) {
                    ta();
                    return;
                }
                break;
            case 47653684:
                if (buttonId.equals("20002")) {
                    ((com.tencent.mobileqq.qqlive.sail.ui.preview.a) getViewModel(com.tencent.mobileqq.qqlive.sail.ui.preview.a.class)).M1().setValue(Boolean.TRUE);
                    return;
                }
                break;
            case 47653685:
                if (buttonId.equals("20003")) {
                    com.tencent.mobileqq.qqlive.anchor.live.utils.a.g(getActivity(), H9());
                    return;
                }
                break;
            case 47653686:
                if (buttonId.equals("20004")) {
                    ua();
                    return;
                }
                break;
        }
        if (buttonId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (U1 = ra().U1(buttonId, this.dynamicConfigRsp)) != null) {
            String str = U1.f439839d;
            Intrinsics.checkNotNullExpressionValue(str, "it.jumpUrl");
            xa(str, U1.f439841f, U1.f439842g);
        }
    }

    private final void ta() {
        Bundle bundle = new Bundle();
        bundle.putLong("KEY_LIVE_ROOM_ID", H9());
        bundle.putString("KEY_LIVE_USER_ID", String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
        QIPCClientHelper.getInstance().callServer("EcommerceIPCModule", "ACTION_CLICK_LIVE_ENTRY_ONLINE", bundle, null);
    }

    private final void ua() {
        if (this.sailAnchorHelper == null) {
            RoomViewModel roomViewModel = (RoomViewModel) getViewModel(RoomViewModel.class);
            com.tencent.mobileqq.qqlive.sail.ui.preview.a beautyViewModel = (com.tencent.mobileqq.qqlive.sail.ui.preview.a) getViewModel(com.tencent.mobileqq.qqlive.sail.ui.preview.a.class);
            Intrinsics.checkNotNullExpressionValue(roomViewModel, "roomViewModel");
            Intrinsics.checkNotNullExpressionValue(beautyViewModel, "beautyViewModel");
            this.sailAnchorHelper = new ar(roomViewModel, beautyViewModel);
        }
        if (this.moreWindow == null) {
            this.moreWindow = new AnchorLiveMorePopWindow(this.sailAnchorHelper, H9());
        }
        AnchorLiveMorePopWindow anchorLiveMorePopWindow = this.moreWindow;
        if (anchorLiveMorePopWindow != null) {
            anchorLiveMorePopWindow.q(getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void xa(String jumpUrl, float webRatio, boolean webTrans) {
        boolean isBlank;
        int e16;
        isBlank = StringsKt__StringsJVMKt.isBlank(jumpUrl);
        if (!isBlank) {
            Uri.Builder buildUpon = Uri.parse(jumpUrl).buildUpon();
            buildUpon.appendQueryParameter("roomId", String.valueOf(H9()));
            buildUpon.appendQueryParameter("anchorId", String.valueOf(C9()));
            String uri = buildUpon.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
            Bundle bundle = new Bundle();
            int i3 = getContext().getResources().getDisplayMetrics().widthPixels;
            int i16 = getContext().getResources().getDisplayMetrics().heightPixels;
            if (i3 > i16) {
                e16 = wi2.c.e(i3 * webRatio);
            } else {
                e16 = wi2.c.e(i16 * webRatio);
            }
            bundle.putInt("height_web_dialog", e16);
            bundle.putBoolean("transparent_web_bg", webTrans);
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(getContext(), uri, bundle);
        }
    }

    private final void za() {
        if (!Q9()) {
            AegisLogger.INSTANCE.i("Open_Live|QQLiveBottomMorePart", "setupGoods", "no anchor room");
            return;
        }
        if (!N9()) {
            AegisLogger.INSTANCE.i("Open_Live|QQLiveBottomMorePart", "setupGoods", "no goods");
            return;
        }
        BottomButtonView d26 = ra().d2("20001", this.buttonList);
        if (d26 != null) {
            d26.setVisibility(0);
            HashMap hashMap = new HashMap();
            hashMap.put("qqlive_buttom_area_button", "4");
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(d26, true, null, IMultiAvChatReporter.ELEMENT_BOTTOM_FUNCTION, hashMap);
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", d26, hashMap);
            Bundle bundle = new Bundle();
            bundle.putString("qqlive_user_id", String.valueOf(M9()));
            bundle.putString("qqlive_anchor_id", String.valueOf(C9()));
            bundle.putString("qqlive_room_id", String.valueOf(H9()));
            bundle.putString("qqlive_zhibo_type", String.valueOf(J9()));
            bundle.putString("qqlive_program_id", E9());
            QIPCClientHelper.getInstance().callServer("EcommerceIPCModule", "ACTION_SETUP_LIVE_REPORT_INFO", bundle);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("bus_id", "2");
            hashMap2.put("live_type", "1");
            hashMap2.put("author_uin", String.valueOf(C9()));
            hashMap2.put(AudienceReportConst.ROOM_ID, String.valueOf(H9()));
            hashMap2.put("program_id", E9());
            hashMap2.put("room_title", I9());
            hashMap2.put("room_cover", G9());
            cj4.c.f31003a.n("ds_live_goods_info", hashMap2);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        super.S9(updater);
        this.hasReceiveConfig = true;
        this.dynamicConfigRsp = BusConfigHelper.f378723a.k(H9());
        if (R9() && this.hasReceiveConfig && (true ^ this.buttonList.isEmpty())) {
            Ca(this.dynamicConfigRsp);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            startInit();
            Aa();
            F9.p(285, this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLiveBottomMorePart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.V9();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLiveBottomMorePart", "onExitRoom", "no room");
        }
        this.sailAnchorHelper = null;
        this.moreWindow = null;
        com.tencent.mobileqq.widget.tip.a aVar = this.bubbleTip;
        if (aVar != null) {
            aVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f60312v3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            int id5 = v3.getId();
            String str = null;
            if (id5 == R.id.f59832ts) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b ra5 = ra();
                BottomButtonView bottomButtonView = this.button1;
                if (bottomButtonView != null) {
                    str = bottomButtonView.m();
                }
                ra5.h2(str);
            } else if (id5 == R.id.f59852tu) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b ra6 = ra();
                BottomButtonView bottomButtonView2 = this.button2;
                if (bottomButtonView2 != null) {
                    str = bottomButtonView2.m();
                }
                ra6.h2(str);
            } else if (id5 == R.id.f59872tw) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b ra7 = ra();
                BottomButtonView bottomButtonView3 = this.button3;
                if (bottomButtonView3 != null) {
                    str = bottomButtonView3.m();
                }
                ra7.h2(str);
            } else if (id5 == R.id.f59892ty) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b ra8 = ra();
                BottomButtonView bottomButtonView4 = this.button4;
                if (bottomButtonView4 != null) {
                    str = bottomButtonView4.m();
                }
                ra8.h2(str);
            } else if (id5 == R.id.f59912u0) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b ra9 = ra();
                BottomButtonView bottomButtonView5 = this.button5;
                if (bottomButtonView5 != null) {
                    str = bottomButtonView5.m();
                }
                ra9.h2(str);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        BottomButtonView bottomButtonView;
        BottomButtonView bottomButtonView2;
        BottomButtonView bottomButtonView3;
        BottomButtonView bottomButtonView4;
        BottomButtonView bottomButtonView5;
        List<BottomButtonView> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        FrameLayout frameLayout = null;
        if (rootView != null) {
            bottomButtonView = (BottomButtonView) rootView.findViewById(R.id.f59832ts);
        } else {
            bottomButtonView = null;
        }
        this.button1 = bottomButtonView;
        if (bottomButtonView != null) {
            bottomButtonView.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView2 = (BottomButtonView) rootView.findViewById(R.id.f59852tu);
        } else {
            bottomButtonView2 = null;
        }
        this.button2 = bottomButtonView2;
        if (bottomButtonView2 != null) {
            bottomButtonView2.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView3 = (BottomButtonView) rootView.findViewById(R.id.f59872tw);
        } else {
            bottomButtonView3 = null;
        }
        this.button3 = bottomButtonView3;
        if (bottomButtonView3 != null) {
            bottomButtonView3.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView4 = (BottomButtonView) rootView.findViewById(R.id.f59892ty);
        } else {
            bottomButtonView4 = null;
        }
        this.button4 = bottomButtonView4;
        if (bottomButtonView4 != null) {
            bottomButtonView4.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView5 = (BottomButtonView) rootView.findViewById(R.id.f59912u0);
        } else {
            bottomButtonView5 = null;
        }
        this.button5 = bottomButtonView5;
        if (bottomButtonView5 != null) {
            bottomButtonView5.setOnClickListener(this);
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.button1, this.button2, this.button3, this.button4, this.button5);
        this.buttonList = mutableListOf;
        if (R9() && this.hasReceiveConfig && (!this.buttonList.isEmpty())) {
            Ca(this.dynamicConfigRsp);
        }
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.ta5);
        }
        this.pkBtnContainer = frameLayout;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<String> a26 = ra().a2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveCameraBottomOperatePart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraBottomOperatePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLiveCameraBottomOperatePart qQLiveCameraBottomOperatePart = QQLiveCameraBottomOperatePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveCameraBottomOperatePart.sa(it);
                QQLiveCameraBottomOperatePart.this.qa(it, "ev_qqlive_abnormal_clck");
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveCameraBottomOperatePart.va(Function1.this, obj);
            }
        });
        LiveData<ar4.a> T1 = ra().T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<ar4.a, Unit> function12 = new Function1<ar4.a, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveCameraBottomOperatePart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveCameraBottomOperatePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ar4.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ar4.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLiveCameraBottomOperatePart qQLiveCameraBottomOperatePart = QQLiveCameraBottomOperatePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveCameraBottomOperatePart.Ba(it);
                QQLiveCameraBottomOperatePart.this.pa(it);
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveCameraBottomOperatePart.wa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        ar4.a n3 = com.tencent.mobileqq.qqlive.sail.push.a.n(msgInfo);
        if (n3 != null) {
            ra().O1(n3);
        }
    }
}
