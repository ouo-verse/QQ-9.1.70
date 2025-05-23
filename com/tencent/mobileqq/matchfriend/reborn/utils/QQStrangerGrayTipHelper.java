package com.tencent.mobileqq.matchfriend.reborn.utils;

import com.tencent.mobileqq.nearbypro.api.INearbyProAioUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.trpcprotocol.kuolie.interactivemsg.system_msg_content.SystemMsgContentPB$InteractiveGrayTipPushMsgContent;
import com.tencent.trpcprotocol.qqstranger.common.common_gray_tips.CommonGrayTipsPB$GrayTipMsgBody;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.nt_msg_common$Msg;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001e\u0010\u0018\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/QQStrangerGrayTipHelper;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "buff", "", "f", "", "type", "", "peerId", "", "grayTipContent", tl.h.F, "Lmqq/app/AppRuntime;", "app", "b", "d", "a", "c", "Lcom/tencent/trpcprotocol/qqstranger/common/common_gray_tips/CommonGrayTipsPB$GrayTipMsgBody;", "msg", "e", "g", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerGrayTipHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerGrayTipHelper f245465a = new QQStrangerGrayTipHelper();

    QQStrangerGrayTipHelper() {
    }

    private final void a(AppRuntime app, long peerId, String grayTipContent) {
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        INtGrayTipApi.a.a((INtGrayTipApi) api, app, new LocalGrayTip.LocalGrayTipBuilder(String.valueOf(peerId), 104, 1007L, 1, false, false, null, 112, null).g(grayTipContent, 1).m(), null, 4, null);
    }

    private final void d(AppRuntime app, long peerId, String grayTipContent) {
        if (h.k(String.valueOf(peerId))) {
            QLog.i("QQStrangerGrayTipHelper", 1, "hasShowBiInteractGrayTips, return");
        } else {
            a(app, peerId, grayTipContent);
            h.r(String.valueOf(peerId));
        }
    }

    @JvmStatic
    public static final void f(ArrayList<Byte> buff) {
        byte[] byteArray;
        Intrinsics.checkNotNullParameter(buff, "buff");
        try {
            nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
            byteArray = CollectionsKt___CollectionsKt.toByteArray(buff);
            nt_msg_common_msg.mergeFrom(byteArray);
            byte[] byteArray2 = nt_msg_common_msg.body.msg_content.get().toByteArray();
            SystemMsgContentPB$InteractiveGrayTipPushMsgContent systemMsgContentPB$InteractiveGrayTipPushMsgContent = new SystemMsgContentPB$InteractiveGrayTipPushMsgContent();
            systemMsgContentPB$InteractiveGrayTipPushMsgContent.mergeFrom(byteArray2);
            long j3 = systemMsgContentPB$InteractiveGrayTipPushMsgContent.peer_tinyid.get();
            if (j3 == 0) {
                QLog.e("QQStrangerGrayTipHelper", 1, "peerId = 0L");
                return;
            }
            int i3 = systemMsgContentPB$InteractiveGrayTipPushMsgContent.gray_tip_type.get();
            String grayTipContent = systemMsgContentPB$InteractiveGrayTipPushMsgContent.gray_tip_content.get();
            if (QLog.isColorLevel()) {
                QLog.i("QQStrangerGrayTipHelper", 2, "handleNT0x167MsgPush,type=" + i3 + ",peer_id=" + j3 + ",content=" + grayTipContent);
            }
            QQStrangerGrayTipHelper qQStrangerGrayTipHelper = f245465a;
            Intrinsics.checkNotNullExpressionValue(grayTipContent, "grayTipContent");
            qQStrangerGrayTipHelper.h(i3, j3, grayTipContent);
        } catch (Exception e16) {
            QLog.e("QQStrangerGrayTipHelper", 1, e16, new Object[0]);
        }
    }

    private final void h(int type, long peerId, String grayTipContent) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (type == 1) {
            d(peekAppRuntime, peerId, grayTipContent);
        } else if (type == 2) {
            c(peekAppRuntime, peerId, grayTipContent);
        } else {
            if (type != 3) {
                return;
            }
            b(peekAppRuntime, peerId, grayTipContent);
        }
    }

    public final void g(ArrayList<Byte> buff) {
        byte[] byteArray;
        Intrinsics.checkNotNullParameter(buff, "buff");
        try {
            nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
            byteArray = CollectionsKt___CollectionsKt.toByteArray(buff);
            nt_msg_common_msg.mergeFrom(byteArray);
            byte[] byteArray2 = nt_msg_common_msg.body.msg_content.get().toByteArray();
            CommonGrayTipsPB$GrayTipMsgBody commonGrayTipsPB$GrayTipMsgBody = new CommonGrayTipsPB$GrayTipMsgBody();
            commonGrayTipsPB$GrayTipMsgBody.mergeFrom(byteArray2);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            int i3 = commonGrayTipsPB$GrayTipMsgBody.appid.get();
            long j3 = commonGrayTipsPB$GrayTipMsgBody.peer_tinyid.get();
            QLog.i("QQStrangerGrayTipHelper", 1, "[handleNT0x16fMsgPush] appId=" + i3 + ", peerUid=" + j3);
            int i16 = commonGrayTipsPB$GrayTipMsgBody.gray_tip_type.get();
            if (i16 == 1) {
                e(peekAppRuntime, commonGrayTipsPB$GrayTipMsgBody);
            } else if (i16 != 2) {
                if (i16 == 3 && i3 == 2) {
                    INearbyProAioUtil iNearbyProAioUtil = (INearbyProAioUtil) QRoute.api(INearbyProAioUtil.class);
                    String str = commonGrayTipsPB$GrayTipMsgBody.gray_tip_content.get();
                    Intrinsics.checkNotNullExpressionValue(str, "msg.gray_tip_content.get()");
                    iNearbyProAioUtil.handleMutualFollow(j3, str);
                }
            } else if (i3 == 2) {
                INearbyProAioUtil iNearbyProAioUtil2 = (INearbyProAioUtil) QRoute.api(INearbyProAioUtil.class);
                String str2 = commonGrayTipsPB$GrayTipMsgBody.gray_tip_content.get();
                Intrinsics.checkNotNullExpressionValue(str2, "msg.gray_tip_content.get()");
                iNearbyProAioUtil2.handleGrayTipTacitAnswerInvite(j3, str2);
            }
        } catch (Exception e16) {
            QLog.e("QQStrangerGrayTipHelper", 1, e16, new Object[0]);
        }
    }

    private final void b(AppRuntime app, long peerId, String grayTipContent) {
        boolean contains$default;
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder;
        int indexOf$default;
        int indexOf$default2;
        String str;
        String str2;
        CharSequence removeRange;
        String uin = app.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        if (h.l(uin, String.valueOf(peerId))) {
            return;
        }
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder2 = new LocalGrayTip.LocalGrayTipBuilder(String.valueOf(peerId), 104, 10365L, 1, false, false, null, 112, null);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) grayTipContent, (CharSequence) "#highlight{", false, 2, (Object) null);
        if (contains$default) {
            localGrayTipBuilder = localGrayTipBuilder2;
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) grayTipContent, "#highlight{", 0, false, 6, (Object) null);
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) grayTipContent, "}", indexOf$default, false, 4, (Object) null);
            if (indexOf$default != -1 && indexOf$default2 != -1 && indexOf$default2 > indexOf$default) {
                str = grayTipContent.substring(indexOf$default + 11, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                str = "";
            }
            String str3 = str;
            if (indexOf$default == -1 || indexOf$default2 == -1) {
                str2 = grayTipContent;
            } else {
                removeRange = StringsKt__StringsKt.removeRange((CharSequence) grayTipContent, indexOf$default, indexOf$default2 + 1);
                str2 = removeRange.toString();
            }
            LocalGrayTip.LocalGrayTipBuilder.d(localGrayTipBuilder, "qui_jieban_brand", null, null, 6, null);
            localGrayTipBuilder.g(str2, 1);
            localGrayTipBuilder.h(str3, new com.tencent.mobileqq.matchfriend.graytips.action.d(), 3);
        } else {
            localGrayTipBuilder = localGrayTipBuilder2;
            localGrayTipBuilder.g(grayTipContent, 1);
        }
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        INtGrayTipApi.a.a((INtGrayTipApi) api, app, localGrayTipBuilder.m(), null, 4, null);
        h.s(uin, String.valueOf(peerId));
    }

    private final void c(AppRuntime app, long peerId, String grayTipContent) {
        boolean contains$default;
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder;
        int indexOf$default;
        int indexOf$default2;
        String str;
        String str2;
        CharSequence removeRange;
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder2 = new LocalGrayTip.LocalGrayTipBuilder(String.valueOf(peerId), 104, 10364L, 1, false, false, null, 112, null);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) grayTipContent, (CharSequence) "#highlight{", false, 2, (Object) null);
        if (contains$default) {
            localGrayTipBuilder = localGrayTipBuilder2;
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) grayTipContent, "#highlight{", 0, false, 6, (Object) null);
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) grayTipContent, "}", indexOf$default, false, 4, (Object) null);
            if (indexOf$default != -1 && indexOf$default2 != -1 && indexOf$default2 > indexOf$default) {
                str = grayTipContent.substring(indexOf$default + 11, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                str = "";
            }
            if (indexOf$default == -1 || indexOf$default2 == -1) {
                str2 = grayTipContent;
            } else {
                removeRange = StringsKt__StringsKt.removeRange((CharSequence) grayTipContent, indexOf$default, indexOf$default2 + 1);
                str2 = removeRange.toString();
            }
            localGrayTipBuilder.g(str2, 1);
            localGrayTipBuilder.h(str, new com.tencent.mobileqq.matchfriend.graytips.action.c(), 3);
        } else {
            localGrayTipBuilder = localGrayTipBuilder2;
            localGrayTipBuilder.g(grayTipContent, 1);
        }
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        INtGrayTipApi.a.a((INtGrayTipApi) api, app, localGrayTipBuilder.m(), null, 4, null);
    }

    private final void e(final AppRuntime app, CommonGrayTipsPB$GrayTipMsgBody msg2) {
        boolean contains$default;
        final int indexOf$default;
        final int indexOf$default2;
        if (msg2.appid.has() && msg2.peer_tinyid.has() && msg2.gray_tip_content.has() && msg2.marker_ext.has()) {
            final String uin = app.getCurrentUin();
            final int a16 = c.f245468a.a(msg2.appid.get());
            final long j3 = msg2.peer_tinyid.get();
            final String grayTipContent = msg2.gray_tip_content.get();
            final int i3 = msg2.marker_ext.get().marker_id.get();
            final long j16 = msg2.marker_ext.get().level.get();
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            if (h.f(uin, a16, j3, 10395L) == j16) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(grayTipContent, "grayTipContent");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) grayTipContent, (CharSequence) "#highlight{", false, 2, (Object) null);
            if (contains$default) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) grayTipContent, "#highlight{", 0, false, 6, (Object) null);
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) grayTipContent, "}", indexOf$default, false, 4, (Object) null);
                if (indexOf$default == -1 || indexOf$default2 == -1) {
                    return;
                }
                com.tencent.mobileqq.matchfriend.reborn.mark.config.b.f245190a.f(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerGrayTipHelper$handleInteractiveMarkGrayTip$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        if (!z16) {
                            QLog.i("QQStrangerGrayTipHelper", 1, "[handleInteractiveMarkGrayTip] initConfig failed.");
                        }
                        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(String.valueOf(j3), a16, 10395L, 1, false, false, null, 112, null);
                        String grayTipContent2 = grayTipContent;
                        int i16 = indexOf$default;
                        int i17 = indexOf$default2;
                        int i18 = i3;
                        long j17 = j16;
                        Intrinsics.checkNotNullExpressionValue(grayTipContent2, "grayTipContent");
                        String substring = grayTipContent2.substring(i16 + 11, i17);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        String substring2 = grayTipContent2.substring(0, i16);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        String substring3 = grayTipContent2.substring(i17 + 1);
                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                        com.tencent.mobileqq.matchfriend.reborn.mark.config.b bVar = com.tencent.mobileqq.matchfriend.reborn.mark.config.b.f245190a;
                        if (bVar.c().getResBaseUrl().length() > 0) {
                            LocalGrayTip.LocalGrayTipBuilder.d(localGrayTipBuilder, bVar.e(bVar.c().getResBaseUrl(), String.valueOf(i18), j17), null, null, 6, null);
                        }
                        localGrayTipBuilder.g(substring2, 1);
                        localGrayTipBuilder.h(substring, new com.tencent.mobileqq.matchfriend.graytips.action.a(new com.tencent.mobileqq.matchfriend.graytips.action.b(i18, j17)), 3);
                        localGrayTipBuilder.g(substring3, 1);
                        QRouteApi api = QRoute.api(INtGrayTipApi.class);
                        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
                        INtGrayTipApi.a.a((INtGrayTipApi) api, app, localGrayTipBuilder.m(), null, 4, null);
                        String uin2 = uin;
                        Intrinsics.checkNotNullExpressionValue(uin2, "uin");
                        h.n(uin2, a16, j3, 10395L, j16);
                    }
                });
                return;
            }
            return;
        }
        QLog.i("QQStrangerGrayTipHelper", 1, "handleInteractiveMarkGrayTip invalid pb.");
    }
}
