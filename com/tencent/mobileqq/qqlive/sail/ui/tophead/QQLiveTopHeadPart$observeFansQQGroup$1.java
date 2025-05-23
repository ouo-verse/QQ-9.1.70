package com.tencent.mobileqq.qqlive.sail.ui.tophead;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ug4.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lrr4/e;", "kotlin.jvm.PlatformType", "groupInfo", "", "invoke", "(Lrr4/e;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveTopHeadPart$observeFansQQGroup$1 extends Lambda implements Function1<rr4.e, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQLiveTopHeadPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveTopHeadPart$observeFansQQGroup$1(QQLiveTopHeadPart qQLiveTopHeadPart) {
        super(1);
        this.this$0 = qQLiveTopHeadPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveTopHeadPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQLiveTopHeadPart this$0, rr4.e eVar, long j3, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.timi.game.liveroom.impl.room.fansqqgroup.a aVar = com.tencent.timi.game.liveroom.impl.room.fansqqgroup.a.f377629a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = eVar.f432117b;
        Intrinsics.checkNotNullExpressionValue(str, "groupInfo.url");
        aVar.a(context, str, j3);
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        a.C11346a.a((ug4.a) b16, v3, false, null, "em_qqlive_fansgroup_room", null, 22, null);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(rr4.e eVar) {
        invoke2(eVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final rr4.e eVar) {
        View view;
        boolean z16;
        View view2;
        View view3;
        View view4;
        ViewStub viewStub;
        View view5;
        View view6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("room_info|QQLiveTopHeadPart", "observeFansQQGroup", "hasQQGroup=" + eVar.f432116a);
        }
        if (!eVar.f432116a) {
            view6 = this.this$0.fansQQGroupButton;
            if (view6 == null) {
                return;
            }
            view6.setVisibility(8);
            return;
        }
        final long H9 = this.this$0.H9();
        if (H9 > 0) {
            view = this.this$0.fansQQGroupButton;
            if (view == null) {
                QQLiveTopHeadPart qQLiveTopHeadPart = this.this$0;
                viewStub = qQLiveTopHeadPart.fansQQGroupViewStub;
                qQLiveTopHeadPart.fansQQGroupButton = viewStub != null ? viewStub.inflate() : null;
            }
            z16 = this.this$0.com.tencent.mobileqq.activity.miniaio.MiniChatConstants.MINI_APP_LANDSCAPE java.lang.String;
            if (z16) {
                view4 = this.this$0.fansQQGroupButton;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            } else {
                view2 = this.this$0.fansQQGroupButton;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
            view3 = this.this$0.fansQQGroupButton;
            if (view3 != null) {
                final QQLiveTopHeadPart qQLiveTopHeadPart2 = this.this$0;
                view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.tophead.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view7) {
                        QQLiveTopHeadPart$observeFansQQGroup$1.b(QQLiveTopHeadPart.this, eVar, H9, view7);
                    }
                });
                return;
            }
            return;
        }
        companion.i("room_info|QQLiveTopHeadPart", "observeFansQQGroup", "invalid roomId");
        view5 = this.this$0.fansQQGroupButton;
        if (view5 == null) {
            return;
        }
        view5.setVisibility(8);
    }
}
