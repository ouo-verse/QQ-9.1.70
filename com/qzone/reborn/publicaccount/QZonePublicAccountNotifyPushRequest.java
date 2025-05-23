package com.qzone.reborn.publicaccount;

import android.util.Log;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzone.pb.QZoneBase$Entry;
import com.tencent.qzone.pb.QZoneOfficialAccount$PushMessageReq;
import com.tencent.qzone.pb.QZoneOfficialAccount$PushMessageRsp;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001d\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/publicaccount/QZonePublicAccountNotifyPushRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "Lcom/tencent/qzone/pb/QZoneOfficialAccount$PushMessageReq;", "mRequest", "Lcom/tencent/qzone/pb/QZoneOfficialAccount$PushMessageReq;", "", "hasPhoto", "<init>", "(Z)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublicAccountNotifyPushRequest extends QZoneBaseRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final QZoneOfficialAccount$PushMessageReq mRequest;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/publicaccount/QZonePublicAccountNotifyPushRequest$a;", "", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.publicaccount.QZonePublicAccountNotifyPushRequest$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/publicaccount/QZonePublicAccountNotifyPushRequest$a$a", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lcom/tencent/qzone/pb/QZoneOfficialAccount$PushMessageRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "baseRequest", "", "isSuccess", "", "retCode", "", "errorMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.qzone.reborn.publicaccount.QZonePublicAccountNotifyPushRequest$a$a, reason: collision with other inner class name */
        /* loaded from: classes37.dex */
        public static final class C0492a implements VSDispatchObserver.OnVSRspCallBack<QZoneOfficialAccount$PushMessageRsp> {
            C0492a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean isSuccess, long retCode, String errorMsg, QZoneOfficialAccount$PushMessageRsp rsp) {
                Intrinsics.checkNotNullParameter(baseRequest, "baseRequest");
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                QLog.d("QZonePublicAccountNotifyPushRequest", 1, hashCode() + " | requestPushMessage onReceive: dispatch Success:" + isSuccess + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + retCode + " | retMessage:" + errorMsg);
                if (isSuccess && retCode == 0) {
                    if (rsp == null) {
                        QLog.e("QZonePublicAccountNotifyPushRequest", 1, "onReceive error!rsp == null");
                        return;
                    }
                    QLog.d("QZonePublicAccountNotifyPushRequest", 1, "onReceive: record next push time:" + rsp.next_push_time_sec.get() + ReportConstant.COSTREPORT_PREFIX);
                    u5.c.N(rsp.next_push_time_sec.get(), LoginData.getInstance().getUin());
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a() {
            if (!QzoneConfig.getInstance().isNewStylePublicAccountPage()) {
                QLog.d("QZonePublicAccountNotifyPushRequest", 1, "requestPushMessage not hit new style exp,direct return");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long r16 = u5.c.r(LoginData.getInstance().getUin());
            long w3 = u5.c.w(LoginData.getInstance().getUin());
            if (currentTimeMillis < w3 && currentTimeMillis < r16) {
                QLog.d("QZonePublicAccountNotifyPushRequest", 1, "requestPushMessage not reach nextPushTime,remain:" + (Math.min(w3 - currentTimeMillis, r16 - currentTimeMillis) / 1000) + ReportConstant.COSTREPORT_PREFIX);
                return;
            }
            VSNetworkHelper.getInstance().sendRequest(new QZonePublicAccountNotifyPushRequest(false), new C0492a());
        }

        Companion() {
        }
    }

    public QZonePublicAccountNotifyPushRequest(boolean z16) {
        String str;
        QZoneOfficialAccount$PushMessageReq qZoneOfficialAccount$PushMessageReq = new QZoneOfficialAccount$PushMessageReq();
        this.mRequest = qZoneOfficialAccount$PushMessageReq;
        QZoneBase$Entry qZoneBase$Entry = new QZoneBase$Entry();
        qZoneBase$Entry.key.set("has_photo");
        PBStringField pBStringField = qZoneBase$Entry.value;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        pBStringField.set(str);
        qZoneOfficialAccount$PushMessageReq.ext_info.map_info.add(qZoneBase$Entry);
    }

    @JvmStatic
    public static final void requestPushMessage() {
        INSTANCE.a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.pb.MessageMicro, com.tencent.qzone.pb.QZoneOfficialAccount$PushMessageRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] responseData) {
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        ?? r06 = (T) new QZoneOfficialAccount$PushMessageRsp();
        try {
            r06.mergeFrom(responseData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZonePublicAccountNotifyPushRequest", 1, "decode error: ", Log.getStackTraceString(e16));
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qzone.official_account.QzoneOfficialAccountService.PushMessage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.mRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mRequest.toByteArray()");
        return byteArray;
    }
}
