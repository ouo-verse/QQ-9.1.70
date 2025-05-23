package com.tencent.mobileqq.qqlive.sail.ui.report;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.sail.base.c;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.StyleInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qqlive.sail.model.d;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.ui.close.CloseViewModel;
import com.tencent.mobileqq.qqlive.sail.util.RoomHeartBeatReporter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt3.z;
import st3.b;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/report/QQLiveRoomReportPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "roomInfo", "", "", LocaleUtils.L_JAPANESE, "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "la", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "onPartDestroy", "Landroid/view/View;", "root", "onInitView", "Y9", "U9", "V9", "Lcom/tencent/mobileqq/qqlive/sail/util/RoomHeartBeatReporter;", "e", "Lcom/tencent/mobileqq/qqlive/sail/util/RoomHeartBeatReporter;", "heartBeatReporter", "<init>", "()V", "f", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRoomReportPart extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoomHeartBeatReporter heartBeatReporter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/report/QQLiveRoomReportPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.report.QQLiveRoomReportPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveRoomReportPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Map<String, String> ja(AnchorRoomInfo roomInfo) {
        String str;
        QQLiveDaTongParams g16 = com.tencent.mobileqq.qqlive.sail.report.a.f272382a.g(roomInfo.getRoomId());
        g16.e(IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID);
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        g16.f(String.valueOf(cVar.G()));
        g16.r(String.valueOf(roomInfo.e()));
        g16.K(String.valueOf(cVar.G()));
        g16.A(String.valueOf(roomInfo.getRoomId()));
        UserInfo j3 = roomInfo.j();
        if (j3 == null || (str = Long.valueOf(j3.f()).toString()) == null) {
            str = "";
        }
        g16.j(str);
        g16.z(roomInfo.getProgramId());
        g16.Q("1");
        g16.P(String.valueOf(roomInfo.r().n().b()));
        g16.n("");
        g16.q(roomInfo.getRoomId() + "_" + roomInfo.getProgramId());
        g16.G(QQLiveBusinessConfig.QQLIVE_APP_ID);
        g16.i("");
        String str2 = "0";
        g16.H("0");
        if (roomInfo.r().m() == 2) {
            str2 = "2";
        }
        g16.I(str2);
        g16.F(roomInfo.r().l());
        return g16.a();
    }

    private final Map<String, String> la(AudienceRoomInfo roomInfo) {
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4;
        String num;
        HashMap<String, String> l3;
        HashMap<String, String> l16;
        QQLiveDaTongParams g16 = com.tencent.mobileqq.qqlive.sail.report.a.f272382a.g(roomInfo.getRoomId());
        g16.e(IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID);
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        g16.f(String.valueOf(cVar.G()));
        g16.r(String.valueOf(roomInfo.e()));
        g16.K(String.valueOf(cVar.G()));
        g16.A(String.valueOf(roomInfo.getRoomId()));
        UserInfo j3 = roomInfo.j();
        String str5 = "";
        if (j3 == null || (str = Long.valueOf(j3.f()).toString()) == null) {
            str = "";
        }
        g16.j(str);
        g16.z(roomInfo.getProgramId());
        g16.S("");
        g16.q(cVar.G() + "_" + roomInfo.getProgramId() + "_" + roomInfo.n());
        g16.Q("1");
        z m3 = roomInfo.m();
        boolean z17 = true;
        if (m3 != null && m3.f432386a) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            str2 = "";
        } else {
            str2 = "2";
        }
        g16.P(str2);
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        String str6 = QQLiveBusinessConfig.QQLIVE_APP_ID;
        QQLiveContext c16 = companion.c(str6);
        if (c16 == null || (str3 = c16.j()) == null) {
            str3 = "";
        }
        g16.n(str3);
        QQLiveContext c17 = companion.c(str6);
        String str7 = null;
        if (c17 != null && (l16 = c17.l()) != null) {
            str4 = l16.get("video_source");
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "QQLiveContext.current(QQ\u2026get(\"video_source\") ?: \"\"");
        }
        g16.G(str4);
        QQLiveContext c18 = companion.c(str6);
        if (c18 != null && (l3 = c18.l()) != null) {
            str7 = l3.get("rcmd_context");
        }
        if (str7 == null) {
            str7 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str7, "QQLiveContext.current(QQ\u2026get(\"rcmd_context\") ?: \"\"");
        }
        g16.i(str7);
        g16.y(String.valueOf(roomInfo.r().e()));
        UserInfo j16 = roomInfo.j();
        if (j16 == null || cVar.G() != j16.f()) {
            z17 = false;
        }
        if (z17) {
            g16.H("0");
            g16.I("1");
            g16.F("1");
            StyleInfo f16 = roomInfo.r().f();
            if (f16 != null && (num = Integer.valueOf(f16.b()).toString()) != null) {
                str5 = num;
            }
            g16.D(str5);
        }
        return g16.a();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        f F9 = F9();
        if (F9 != null) {
            d b16 = F9.b();
            if (b16.c()) {
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo");
                Map<String, String> ja5 = ja((AnchorRoomInfo) b16);
                com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                View rootView = getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                aVar.e(activity, rootView, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, ja5);
                aVar.i("ev_qqlive_enterroom", ja5);
            } else {
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo");
                Map<String, String> la5 = la((AudienceRoomInfo) b16);
                com.tencent.mobileqq.qqlive.sail.report.a aVar2 = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
                Activity activity2 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                View rootView2 = getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView2, "rootView");
                aVar2.e(activity2, rootView2, IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID, la5);
                aVar2.i("ev_qqlive_enterroom", la5);
            }
            RoomHeartBeatReporter roomHeartBeatReporter = new RoomHeartBeatReporter();
            this.heartBeatReporter = roomHeartBeatReporter;
            roomHeartBeatReporter.a(F9);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("unknown|QQLiveRoomReportPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.V9();
        f F9 = F9();
        if (F9 != null) {
            com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
            QQLiveDaTongParams f16 = aVar.f(F9.getRoomId());
            f16.C("0");
            aVar.i("ev_qqlive_quitroom", f16.a());
        }
        RoomHeartBeatReporter roomHeartBeatReporter = this.heartBeatReporter;
        if (roomHeartBeatReporter != null) {
            roomHeartBeatReporter.stop();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void Y9() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
        QQLiveDaTongParams g16 = aVar.g(H9());
        g16.e("pg_qqlive_gamelive_start");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        g16.f(String.valueOf(cVar.G()));
        g16.K(String.valueOf(cVar.G()));
        g16.A(String.valueOf(H9()));
        g16.j(String.valueOf(C9()));
        g16.Q("1");
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 == null || (str = c16.m()) == null) {
            str = "";
        }
        g16.x(str);
        HashMap<String, String> a16 = g16.a();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        aVar.e(activity, rootView, "pg_qqlive_gamelive_start", a16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View root) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) root);
            return;
        }
        super.onInitView(root);
        LiveData<b> O1 = ((CloseViewModel) getViewModel(CloseViewModel.class)).O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<b, Unit> function1 = new Function1<b, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.report.QQLiveRoomReportPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveRoomReportPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable b bVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
                QQLiveDaTongParams g16 = aVar.g(QQLiveRoomReportPart.this.H9());
                g16.e("pg_qqlive_liveend_audience");
                HashMap<String, String> a16 = g16.a();
                Activity activity = QQLiveRoomReportPart.this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                View rootView = QQLiveRoomReportPart.this.getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                aVar.e(activity, rootView, "pg_qqlive_liveend_audience", a16);
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.report.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveRoomReportPart.ia(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        RoomHeartBeatReporter roomHeartBeatReporter = this.heartBeatReporter;
        if (roomHeartBeatReporter != null) {
            roomHeartBeatReporter.stop();
        }
    }
}
