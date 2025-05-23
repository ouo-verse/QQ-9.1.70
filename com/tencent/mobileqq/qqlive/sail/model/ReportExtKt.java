package com.tencent.mobileqq.qqlive.sail.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a=\u0010\t\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\t\u0010\n\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\r\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\r\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/e;", "", "f", "", "desc", "", QCircleWeakNetReporter.KEY_COST, "retCode", "msg", "a", "(Lcom/tencent/mobileqq/qqlive/sail/room/e;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "e", "c", "", "errCode", "errMsg", h.F, "definition", "g", "i", "d", "qq-live-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ReportExtKt {
    public static final void a(@NotNull final com.tencent.mobileqq.qqlive.sail.room.e eVar, @NotNull final String desc, @Nullable final Long l3, @Nullable final Long l16, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Intrinsics.checkNotNullParameter(desc, "desc");
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>(l3, l16, desc, str) { // from class: com.tencent.mobileqq.qqlive.sail.model.ReportExtKt$reportEnterRoomStep$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Long $cost;
            final /* synthetic */ String $desc;
            final /* synthetic */ String $msg;
            final /* synthetic */ Long $retCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$cost = l3;
                this.$retCode = l16;
                this.$desc = desc;
                this.$msg = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, com.tencent.mobileqq.qqlive.sail.room.e.this, l3, l16, desc, str);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.sail.model.player.a playerQuality = com.tencent.mobileqq.qqlive.sail.room.e.this.getPlayerQuality();
                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.f271167d);
                QQLiveQualityReportData.Builder uid = builder.traceId(c16 != null ? c16.n() : null).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_STEP).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType())).uid(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
                Long l17 = this.$cost;
                QQLiveQualityReportData.Builder cost = uid.cost(l17 != null ? l17.toString() : null);
                Long l18 = this.$retCode;
                return cost.retCode(l18 != null ? l18.toString() : null).desc(this.$desc).ext6(com.tencent.mobileqq.qqlive.sail.room.e.this.b().v().toString()).ext7(com.tencent.mobileqq.qqlive.sail.room.e.this.b().w()).ext8(String.valueOf(System.currentTimeMillis())).ext9(this.$msg).ext10(String.valueOf(ct3.a.e("can_play_in_mobile_network", false))).ext19(playerQuality != null ? playerQuality.f() : null);
            }
        });
    }

    public static /* synthetic */ void b(com.tencent.mobileqq.qqlive.sail.room.e eVar, String str, Long l3, Long l16, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            l3 = null;
        }
        if ((i3 & 4) != 0) {
            l16 = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        a(eVar, str, l3, l16, str2);
    }

    public static final void c(@NotNull final com.tencent.mobileqq.qqlive.sail.room.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>() { // from class: com.tencent.mobileqq.qqlive.sail.model.ReportExtKt$reportFirstFrameRendered$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqlive.sail.room.e.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.sail.model.player.a playerQuality = com.tencent.mobileqq.qqlive.sail.room.e.this.getPlayerQuality();
                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.f271167d);
                return builder.traceId(c16 != null ? c16.n() : null).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_FIRST_FRAME_PULLED).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType())).uid(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())).cost(playerQuality != null ? Long.valueOf(playerQuality.d()).toString() : null).ext6(playerQuality != null ? Long.valueOf(playerQuality.e()).toString() : null).ext7(playerQuality != null ? playerQuality.n() : null).ext8(playerQuality != null ? Long.valueOf(playerQuality.d()).toString() : null).ext9(playerQuality != null ? Long.valueOf(playerQuality.h()).toString() : null).ext10(playerQuality != null ? playerQuality.l() : null).ext19(playerQuality != null ? playerQuality.f() : null);
            }
        });
    }

    public static final void d(@NotNull final com.tencent.mobileqq.qqlive.sail.room.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>() { // from class: com.tencent.mobileqq.qqlive.sail.model.ReportExtKt$reportOnBackground$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqlive.sail.room.e.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.sail.model.player.a playerQuality = com.tencent.mobileqq.qqlive.sail.room.e.this.getPlayerQuality();
                QQLiveQualityReportData.Builder eventId = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).eventId(QQLiveReportConstants.Event.E_AUDIENCE_ON_BACKGROUND);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.f271167d);
                return eventId.traceId(c16 != null ? c16.n() : null).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType())).uid(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())).ext6(com.tencent.mobileqq.qqlive.sail.room.e.this.b().v().toString()).ext7(com.tencent.mobileqq.qqlive.sail.room.e.this.b().w()).ext8(String.valueOf(System.currentTimeMillis())).ext9(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.isPlaying())).ext10(playerQuality != null ? playerQuality.f() : null);
            }
        });
    }

    public static final void e(@NotNull final com.tencent.mobileqq.qqlive.sail.room.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>() { // from class: com.tencent.mobileqq.qqlive.sail.model.ReportExtKt$reportOnVideoPrepared$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqlive.sail.room.e.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.sail.model.player.a playerQuality = com.tencent.mobileqq.qqlive.sail.room.e.this.getPlayerQuality();
                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.f271167d);
                return builder.traceId(c16 != null ? c16.n() : null).eventId(QQLiveReportConstants.Event.E_AUDIENCE_PLAYER_PREPARE).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType())).uid(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())).ext6(playerQuality != null ? playerQuality.l() : null).ext7(playerQuality != null ? playerQuality.n() : null).ext8(String.valueOf(System.currentTimeMillis()));
            }
        });
    }

    public static final void f(@NotNull final com.tencent.mobileqq.qqlive.sail.room.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>() { // from class: com.tencent.mobileqq.qqlive.sail.model.ReportExtKt$reportPageIn$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqlive.sail.room.e.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                QQLiveQualityReportData.Builder eventId = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_PAGE_IN);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.f271167d);
                return eventId.traceId(c16 != null ? c16.n() : null).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType()));
            }
        });
    }

    public static final void g(@NotNull final com.tencent.mobileqq.qqlive.sail.room.e eVar, final int i3) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>(i3) { // from class: com.tencent.mobileqq.qqlive.sail.model.ReportExtKt$reportPlayerEndBuffer$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $definition;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$definition = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqlive.sail.room.e.this, i3);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.sail.model.player.a playerQuality = com.tencent.mobileqq.qqlive.sail.room.e.this.getPlayerQuality();
                if ((playerQuality != null ? playerQuality.e() : -1L) <= 0) {
                    return null;
                }
                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.f271167d);
                QQLiveQualityReportData.Builder ext6 = builder.traceId(c16 != null ? c16.n() : null).eventId(QQLiveReportConstants.Event.E_QQ_LIVE_END_BUFFER).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType())).uid(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())).ext6(playerQuality != null ? Long.valueOf(playerQuality.d()).toString() : null);
                UserInfo j3 = com.tencent.mobileqq.qqlive.sail.room.e.this.b().j();
                QQLiveQualityReportData.Builder ext7 = ext6.ext7(j3 != null ? Long.valueOf(j3.f()).toString() : null);
                UserInfo j16 = com.tencent.mobileqq.qqlive.sail.room.e.this.b().j();
                QQLiveQualityReportData.Builder ext15 = ext7.ext8(j16 != null ? j16.b() : null).ext9(playerQuality != null ? Integer.valueOf(playerQuality.a()).toString() : null).ext10(playerQuality != null ? Long.valueOf(playerQuality.b()).toString() : null).ext11(playerQuality != null ? String.valueOf(System.currentTimeMillis() - playerQuality.e()) : null).ext12(playerQuality != null ? Float.valueOf(playerQuality.j()).toString() : null).ext13(playerQuality != null ? String.valueOf(playerQuality.k() - playerQuality.e()) : null).ext14(String.valueOf(this.$definition)).ext15(null);
                if (playerQuality != null) {
                    str = playerQuality.q() + HippyTKDListViewAdapter.X + playerQuality.p() + "-" + playerQuality.n();
                } else {
                    str = null;
                }
                return ext15.ext16(str).ext17(playerQuality != null ? Float.valueOf(playerQuality.j()).toString() : null).ext18(playerQuality != null ? playerQuality.l() : null).ext19(playerQuality != null ? playerQuality.f() : null);
            }
        });
    }

    public static final void h(@NotNull final com.tencent.mobileqq.qqlive.sail.room.e eVar, final int i3, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>(i3, str) { // from class: com.tencent.mobileqq.qqlive.sail.model.ReportExtKt$reportPlayerError$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$errCode = i3;
                this.$errMsg = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, com.tencent.mobileqq.qqlive.sail.room.e.this, Integer.valueOf(i3), str);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.f271167d);
                QQLiveQualityReportData.Builder desc = builder.traceId(c16 != null ? c16.n() : null).eventId(QQLiveReportConstants.Event.E_AUDIENCE_PLAYER_ERROR).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType())).uid(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())).retCode(String.valueOf(this.$errCode)).desc(this.$errMsg);
                com.tencent.mobileqq.qqlive.sail.model.player.a playerQuality = com.tencent.mobileqq.qqlive.sail.room.e.this.getPlayerQuality();
                return desc.ext19(playerQuality != null ? playerQuality.f() : null);
            }
        });
    }

    public static final void i(@NotNull final com.tencent.mobileqq.qqlive.sail.room.e eVar, final int i3) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>(i3) { // from class: com.tencent.mobileqq.qqlive.sail.model.ReportExtKt$reportPlayerStop$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $definition;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$definition = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqlive.sail.room.e.this, i3);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.sail.model.player.a playerQuality = com.tencent.mobileqq.qqlive.sail.room.e.this.getPlayerQuality();
                if ((playerQuality != null ? playerQuality.e() : -1L) <= 0) {
                    return null;
                }
                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.f271167d);
                QQLiveQualityReportData.Builder ext6 = builder.traceId(c16 != null ? c16.n() : null).eventId(QQLiveReportConstants.Event.E_QQ_LIVE_END_PLAY).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType())).uid(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())).ext6(playerQuality != null ? Long.valueOf(playerQuality.e()).toString() : null);
                UserInfo j3 = com.tencent.mobileqq.qqlive.sail.room.e.this.b().j();
                QQLiveQualityReportData.Builder ext7 = ext6.ext7(j3 != null ? Long.valueOf(j3.f()).toString() : null);
                UserInfo j16 = com.tencent.mobileqq.qqlive.sail.room.e.this.b().j();
                QQLiveQualityReportData.Builder ext10 = ext7.ext8(j16 != null ? j16.b() : null).ext9(playerQuality != null ? Integer.valueOf(playerQuality.a()).toString() : null).ext10(playerQuality != null ? Long.valueOf(playerQuality.b()).toString() : null);
                String str2 = "";
                if (playerQuality == null || (str = String.valueOf(System.currentTimeMillis() - playerQuality.e())) == null) {
                    str = "";
                }
                QQLiveQualityReportData.Builder ext15 = ext10.ext11(str).ext12(playerQuality != null ? Float.valueOf(playerQuality.j()).toString() : null).ext13("0").ext14(String.valueOf(this.$definition)).ext15(null);
                if (playerQuality != null) {
                    String str3 = playerQuality.q() + HippyTKDListViewAdapter.X + playerQuality.p() + "-" + playerQuality.n();
                    if (str3 != null) {
                        str2 = str3;
                    }
                }
                return ext15.ext16(str2).ext17(playerQuality != null ? Float.valueOf(playerQuality.j()).toString() : null).ext18(playerQuality != null ? playerQuality.l() : null).ext19(playerQuality != null ? playerQuality.f() : null);
            }
        });
    }
}
