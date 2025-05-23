package com.tencent.mobileqq.troop.troopaiobanner;

import com.tencent.mobileqq.aio.notification.IAIONotificationApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$QueryTopBannerInfoReq;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$QueryTopBannerInfoRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JX\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000628\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopaiobanner/g;", "", "Lcom/tencent/trpcprotocol/iqun/group_top_banner_notify/group_top_banner_notify/GroupTopBannerNotifyPB$QueryTopBannerInfoRsp;", "resp", "", "b", "", "troopUin", "", "bizType", "msgId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "bannerInfo", "", "callback", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f299293a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopaiobanner/g$a", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "successResponse", "", "b", "errorResponse", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, Unit> f299294a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super Boolean, ? super GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, Unit> function2) {
            this.f299294a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse errorResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorResponse);
            } else {
                Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
                this.f299294a.invoke(Boolean.FALSE, null);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            Function2<Boolean, GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, Unit> function2 = this.f299294a;
            GroupTopBannerNotifyPB$QueryTopBannerInfoRsp groupTopBannerNotifyPB$QueryTopBannerInfoRsp = new GroupTopBannerNotifyPB$QueryTopBannerInfoRsp();
            try {
                byte[] bArr = successResponse.data;
                Intrinsics.checkNotNull(bArr, "null cannot be cast to non-null type kotlin.ByteArray");
                groupTopBannerNotifyPB$QueryTopBannerInfoRsp.mergeFrom(bArr);
                if (g.f299293a.b(groupTopBannerNotifyPB$QueryTopBannerInfoRsp)) {
                    function2.invoke(Boolean.TRUE, groupTopBannerNotifyPB$QueryTopBannerInfoRsp);
                } else {
                    function2.invoke(Boolean.FALSE, null);
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                function2.invoke(Boolean.FALSE, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62396);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f299293a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp resp) {
        if (resp.is_disappear.get()) {
            return true;
        }
        if (resp.biz_type.get() != 4 && resp.biz_type.get() != 5) {
            if (resp.biz_type.get() == 6) {
                if (resp.interaction_banner.get() != null) {
                    return true;
                }
                return false;
            }
            if (resp.biz_type.get() != 7 && resp.biz_type.get() != 8) {
                if (resp.banner_type.get() != 1 || resp.team_up_banner.get() != null) {
                    return true;
                }
                return false;
            }
            if (resp.notify_banner.get() != null) {
                return true;
            }
            return false;
        }
        boolean isNotificationEnable = ((IAIONotificationApi) QRoute.api(IAIONotificationApi.class)).isNotificationEnable();
        if (!isNotificationEnable) {
            QLog.i("TroopAIONotifyBannerRepo", 1, "[checkRespValidity] newNotificationEnable is false.");
        }
        if (isNotificationEnable && resp.to_do_banner.get() != null) {
            return true;
        }
        return false;
    }

    public final void c(@NotNull String troopUin, int bizType, @NotNull String msgId, @NotNull Function2<? super Boolean, ? super GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, Unit> callback) {
        Long longOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, Integer.valueOf(bizType), msgId, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        GroupTopBannerNotifyPB$QueryTopBannerInfoReq groupTopBannerNotifyPB$QueryTopBannerInfoReq = new GroupTopBannerNotifyPB$QueryTopBannerInfoReq();
        groupTopBannerNotifyPB$QueryTopBannerInfoReq.biz_type.set(bizType);
        PBUInt64Field pBUInt64Field = groupTopBannerNotifyPB$QueryTopBannerInfoReq.group_id;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        pBUInt64Field.set(j3);
        groupTopBannerNotifyPB$QueryTopBannerInfoReq.msg_id.set(ByteStringMicro.copyFromUtf8(msgId));
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.group_top_banner_notify.GroupTopBanner", "/trpc.iqun.group_top_banner_notify.GroupTopBanner/QueryTopBannerInfo", groupTopBannerNotifyPB$QueryTopBannerInfoReq.toByteArray(), 1, null, new a(callback));
    }
}
