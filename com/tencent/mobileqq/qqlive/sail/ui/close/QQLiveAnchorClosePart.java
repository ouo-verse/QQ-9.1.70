package com.tencent.mobileqq.qqlive.sail.ui.close;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.live.end.AnchorLiveEndFragment;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.sso.request.QQLiveGetEndPageDataRequest;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import nm3.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAnchorClosePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "ua", "", "reason", "Lcom/tencent/mobileqq/qqlive/anchor/live/end/AnchorLiveEndFragment$QlsLiveCloseType;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, "sa", "pa", "Lst3/b;", "rsp", "Lcom/tencent/mobileqq/qqlive/data/QQLiveEndPageInfo;", "ra", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getInitRelyViewStubId", "", "onBackEvent", "v", NodeProps.ON_CLICK, "Lfp4/c;", "msgInfo", "onPush", "U9", "V9", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "e", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "closeView", "<init>", "()V", "f", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAnchorClosePart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundCornerImageView closeView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAnchorClosePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAnchorClosePart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAnchorClosePart$b", "Lnm3/a;", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements nm3.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f272519b;

        b(long j3) {
            this.f272519b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQLiveAnchorClosePart.this, Long.valueOf(j3));
            }
        }

        @Override // nm3.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQLiveAnchorClosePart.this.sa("", AnchorLiveEndFragment.QlsLiveCloseType.CLOSE_BY_ANCHOR_SELF);
                QQLiveAnchorClosePart.this.broadcastMessage("onExitRoom", Long.valueOf(this.f272519b));
                QQLiveAnchorClosePart.this.pa();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51611);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAnchorClosePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa() {
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.e
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveAnchorClosePart.qa(QQLiveAnchorClosePart.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(QQLiveAnchorClosePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQLiveEndPageInfo ra(st3.b rsp) {
        String str;
        long j3;
        st3.d dVar;
        st3.f[] items;
        st3.e eVar;
        String str2;
        QQLiveEndPageInfo qQLiveEndPageInfo = new QQLiveEndPageInfo();
        qQLiveEndPageInfo.roomId = H9();
        qQLiveEndPageInfo.programId = E9();
        qQLiveEndPageInfo.liveType = J9();
        String str3 = "";
        qQLiveEndPageInfo.liveContent = "";
        qQLiveEndPageInfo.liveSource = QQLiveBusinessConfig.QQLIVE_APP_ID;
        qQLiveEndPageInfo.uid = C9();
        qQLiveEndPageInfo.anchorUid = C9();
        st3.g gVar = rsp.f434719b;
        if (gVar == null || (str = gVar.f434732a) == null) {
            str = "";
        }
        qQLiveEndPageInfo.headIcon = str;
        if (gVar != null && (str2 = gVar.f434733b) != null) {
            str3 = str2;
        }
        qQLiveEndPageInfo.nick = str3;
        st3.c cVar = rsp.f434718a;
        if (cVar != null && (eVar = cVar.f434723d) != null) {
            j3 = eVar.f434727c;
        } else {
            j3 = 0;
        }
        qQLiveEndPageInfo.time = j3;
        if (cVar != null && (dVar = cVar.f434722c) != null && (items = dVar.f434724a) != null) {
            Intrinsics.checkNotNullExpressionValue(items, "items");
            for (st3.f fVar : items) {
                switch (fVar.f434729a) {
                    case 1:
                        qQLiveEndPageInfo.giftValue = fVar.f434731c;
                        break;
                    case 2:
                        qQLiveEndPageInfo.newFans = fVar.f434731c;
                        break;
                    case 3:
                        qQLiveEndPageInfo.popularity = String.valueOf(fVar.f434731c);
                        break;
                    case 4:
                        qQLiveEndPageInfo.commentNum = fVar.f434731c;
                        break;
                    case 5:
                        qQLiveEndPageInfo.sendGiftPopularity = fVar.f434731c;
                        break;
                    case 6:
                        qQLiveEndPageInfo.praiseNum = fVar.f434731c;
                        break;
                }
            }
        }
        return qQLiveEndPageInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(final String reason, final AnchorLiveEndFragment.QlsLiveCloseType closeType) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetEndPageDataRequest(C9(), E9()), new Function1<QQLiveResponse<st3.b>, Unit>(reason, closeType) { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAnchorClosePart$gotoEndPage$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AnchorLiveEndFragment.QlsLiveCloseType $closeType;
            final /* synthetic */ String $reason;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$reason = reason;
                this.$closeType = closeType;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQLiveAnchorClosePart.this, reason, closeType);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<st3.b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<st3.b> response) {
                QQLiveEndPageInfo ra5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                    return;
                }
                Intrinsics.checkNotNullParameter(response, "response");
                st3.b rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    ra5 = QQLiveAnchorClosePart.this.ra(rsp);
                    AnchorLiveEndFragment.uh(QQLiveAnchorClosePart.this.getContext(), ra5, this.$reason, this.$closeType);
                    return;
                }
                AegisLogger.INSTANCE.i("Open_Live|QQLiveClosePart", "gotoEndPage", "failed, response=" + response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ta(QQLiveAnchorClosePart this$0, Ref.ObjectRef reason) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        this$0.sa((String) reason.element, AnchorLiveEndFragment.QlsLiveCloseType.CLOSE_BY_ADMIN);
        this$0.broadcastMessage("onExitRoom", Long.valueOf(this$0.H9()));
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void ua() {
        boolean z16;
        com.tencent.mobileqq.qqlive.sail.ui.linkscreen.c cVar = null;
        Object broadcastGetMessage = broadcastGetMessage("link_screen_state_msg", null);
        if (broadcastGetMessage instanceof com.tencent.mobileqq.qqlive.sail.ui.linkscreen.c) {
            cVar = (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.c) broadcastGetMessage;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveClosePart", "showCloseDialog", "link msg=" + cVar);
        final long H9 = H9();
        boolean z17 = true;
        if (cVar != null && cVar.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (cVar == null || !cVar.b()) {
                z17 = false;
            }
            if (!z17) {
                DialogUtil.createCustomDialog(getContext(), 230, null, "\u786e\u5b9a\u8981\u7ed3\u675f\u76f4\u64ad\u5417\uff1f", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        QQLiveAnchorClosePart.va(QQLiveAnchorClosePart.this, H9, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        QQLiveAnchorClosePart.wa(dialogInterface, i3);
                    }
                }).show();
                return;
            }
        }
        o oVar = o.f420511a;
        boolean b16 = cVar.b();
        boolean c16 = cVar.c();
        boolean a16 = cVar.a();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        oVar.a(b16, c16, a16, context, H9, new b(H9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(QQLiveAnchorClosePart this$0, long j3, DialogInterface dialog, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this$0.sa("", AnchorLiveEndFragment.QlsLiveCloseType.CLOSE_BY_ANCHOR_SELF);
        this$0.broadcastMessage("onExitRoom", Long.valueOf(j3));
        dialog.dismiss();
        this$0.pa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(DialogInterface dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|QQLiveClosePart", "onEnterRoom", "roomId=" + H9());
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            startInit();
            F9.p(75, this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            companion.e("Open_Live|QQLiveClosePart", "onEnterRoom", "room is null");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveClosePart", "onCloseRoom", "roomId=" + H9());
        super.V9();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f61582yi;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (H9() > 0 && R9()) {
            ua();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            boolean z16 = false;
            if (v3 != null && v3.getId() == R.id.f60462vh) {
                z16 = true;
            }
            if (z16) {
                ua();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RoundCornerImageView roundCornerImageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null) {
            roundCornerImageView = (RoundCornerImageView) rootView.findViewById(R.id.f60462vh);
        } else {
            roundCornerImageView = null;
        }
        this.closeView = roundCornerImageView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setOnClickListener(this);
        }
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.String] */
    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        qt3.a v3 = com.tencent.mobileqq.qqlive.sail.push.a.v(msgInfo);
        if (v3 != null) {
            long C9 = C9();
            AegisLogger.INSTANCE.i("Open_Live|QQLiveClosePart", "onPush", "operType=" + v3.f429496d + ", uin=" + v3.f429493a + ", anchorUid=" + C9);
            if (v3.f429496d == 0 && C9 == v3.f429493a) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                if (v3.f429500h == 10 && (bArr = v3.f429501i) != null) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(bArr, "it.closeDescription");
                        objectRef.element = new String(bArr, Charsets.UTF_8);
                    } catch (Exception e16) {
                        AegisLogger.INSTANCE.e("Open_Live|QQLiveClosePart", "onPush", "closeDescription decode error", e16);
                    }
                }
                AegisLogger.INSTANCE.i("Open_Live|QQLiveClosePart", "onPush", "close video, type=" + v3.f429500h + ", reason=" + objectRef.element);
                runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveAnchorClosePart.ta(QQLiveAnchorClosePart.this, objectRef);
                    }
                });
            }
        }
    }
}
