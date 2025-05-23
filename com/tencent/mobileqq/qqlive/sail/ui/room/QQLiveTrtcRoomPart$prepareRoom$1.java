package com.tencent.mobileqq.qqlive.sail.ui.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/l;", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "it", "", "invoke", "(Lcom/tencent/mobileqq/qqlive/sail/room/l;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveTrtcRoomPart$prepareRoom$1 extends Lambda implements Function1<com.tencent.mobileqq.qqlive.sail.room.l<AnchorRoomInfo>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.mobileqq.qqlive.sail.room.d $this_prepareRoom;
    final /* synthetic */ QQLiveTrtcRoomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveTrtcRoomPart$prepareRoom$1(QQLiveTrtcRoomPart qQLiveTrtcRoomPart, com.tencent.mobileqq.qqlive.sail.room.d dVar) {
        super(1);
        this.this$0 = qQLiveTrtcRoomPart;
        this.$this_prepareRoom = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveTrtcRoomPart, (Object) dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QQLiveTrtcRoomPart this$0, com.tencent.mobileqq.qqlive.sail.room.l it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.eb(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QQLiveTrtcRoomPart this$0, com.tencent.mobileqq.qqlive.sail.room.d this_prepareRoom) {
        String q16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_prepareRoom, "$this_prepareRoom");
        this$0.gb();
        AnchorRoomInfo anchorRoomInfo = null;
        this$0.broadcastMessage("onRoomPrepared", null);
        AnchorRoomInfo b16 = this_prepareRoom.b();
        if (b16 instanceof AnchorRoomInfo) {
            anchorRoomInfo = b16;
        }
        if (anchorRoomInfo != null && (q16 = anchorRoomInfo.q()) != null) {
            AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "prepareRoom", "popupDialogUrl=" + q16);
            kl4.s.INSTANCE.i(this$0.getActivity(), q16);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.sail.room.l<AnchorRoomInfo> lVar) {
        invoke2(lVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final com.tencent.mobileqq.qqlive.sail.room.l<AnchorRoomInfo> it) {
        SettingInfo r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.b() == 0) {
            this.this$0.ub();
            this.this$0.Ua().Z1(0, it.d());
            final QQLiveTrtcRoomPart qQLiveTrtcRoomPart = this.this$0;
            final com.tencent.mobileqq.qqlive.sail.room.d dVar = this.$this_prepareRoom;
            qQLiveTrtcRoomPart.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.p
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveTrtcRoomPart$prepareRoom$1.d(QQLiveTrtcRoomPart.this, dVar);
                }
            });
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            AnchorRoomInfo d16 = it.d();
            companion.i("Open_Live|QQLiveTrtcRoomPart", "prepareRoom", "roomName=" + ((d16 == null || (r16 = d16.r()) == null) ? null : r16.j()));
            IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
            QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            iQQLiveReportApi.qualityReport(builder.traceId(c16 != null ? c16.n() : null).eventId(QQLiveReportConstants.Event.E_ANCHOR_LIVE_ROOM_PREPARED));
            this.this$0.tb(this.$this_prepareRoom);
            return;
        }
        final QQLiveTrtcRoomPart qQLiveTrtcRoomPart2 = this.this$0;
        qQLiveTrtcRoomPart2.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.o
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveTrtcRoomPart$prepareRoom$1.c(QQLiveTrtcRoomPart.this, it);
            }
        });
    }
}
