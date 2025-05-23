package com.tencent.biz.qqcircle.immersive.request;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.picker.qcircle.business.request.QueryAdvJobInfoRequest;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0015B2\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\u001b\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J*\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u000f\u001a\u00020\rJ\u001e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR=\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/request/b;", "", "", "param", "url", "b", "", "isSuccess", "", "retCode", "errMsg", "Lqqcircle/QQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp;", "rsp", "", "c", "d", "jobId", "", "jobType", "bizId", "e", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "getHandleUrl", "()Lkotlin/jvm/functions/Function1;", "setHandleUrl", "(Lkotlin/jvm/functions/Function1;)V", "handleUrl", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static final String f89839d = Reflection.getOrCreateKotlinClass(b.class).getSimpleName();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super String, Unit> handleUrl;

    public b(@NotNull String url, @NotNull Function1<? super String, Unit> handleUrl) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(handleUrl, "handleUrl");
        this.url = url;
        this.handleUrl = handleUrl;
    }

    private final String b(String param, String url) {
        int indexOf$default;
        int indexOf$default2;
        int indexOf$default3;
        int length;
        try {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url, param, 0, false, 6, (Object) null);
            if (indexOf$default >= 0) {
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) url, param, 0, false, 6, (Object) null);
                int length2 = indexOf$default2 + param.length() + 1;
                String substring = url.substring(length2, url.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                indexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) substring, ContainerUtils.FIELD_DELIMITER, 0, false, 6, (Object) null);
                if (indexOf$default3 > 0) {
                    length = indexOf$default3 + length2;
                } else {
                    length = url.length();
                }
                String substring2 = url.substring(length2, length);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring2;
            }
            QLog.w(f89839d, 1, "no param:" + param);
            return "";
        } catch (Exception e16) {
            QLog.e(f89839d, 1, e16, new Object[0]);
            return "";
        }
    }

    private final void c(boolean isSuccess, long retCode, String errMsg, QQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp rsp) {
        QLog.d(f89839d, 1, "handle QueryAdvJobInfoRequest Response isSuccess:" + isSuccess + " retCode:" + retCode + "errMsg:" + errMsg);
        if (rsp != null && isSuccess) {
            if (retCode == 0) {
                String str = rsp.detail.get().title.get();
                String str2 = this.url + "&advertise_job_title=" + str + ContainerUtils.FIELD_DELIMITER;
                this.url = str2;
                this.handleUrl.invoke(str2);
                return;
            }
            if (retCode == 10023) {
                QQToast.makeText(QCircleApplication.APP, 1, R.string.f240527pe, 0).show();
            } else if (retCode == 10014) {
                QQToast.makeText(QCircleApplication.APP, 1, R.string.f240547pg, 0).show();
            } else {
                QQToast.makeText(QCircleApplication.APP, 1, R.string.f240537pf, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b this$0, BaseRequest request1, boolean z16, long j3, String errMsg, QQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp qQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request1, "request1");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.c(z16, j3, errMsg, qQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp);
        QLog.d(f89839d, 1, "requestData onReceive: dispatch Success:" + z16 + " | TraceId:" + request1.getTraceId() + " | SeqId:" + request1.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + errMsg + " | isCache:" + VSNetworkHelper.isProtocolCache(errMsg));
    }

    public final void d() {
        boolean z16;
        String b16 = b(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_ID, this.url);
        String b17 = b(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_TYPE, this.url);
        String b18 = b(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, this.url);
        boolean z17 = true;
        if (b16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            b16 = "0";
        }
        if (b17.length() != 0) {
            z17 = false;
        }
        if (z17) {
            b17 = "0";
        }
        e(Long.parseLong(b16), Integer.parseInt(b17), b18);
        QQToast.makeText(QCircleApplication.APP, -1, R.string.f240517pd, 0).show();
    }

    public final void e(long jobId, int jobType, @NotNull String bizId) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        QueryAdvJobInfoRequest queryAdvJobInfoRequest = new QueryAdvJobInfoRequest();
        queryAdvJobInfoRequest.setEnableCache(false);
        queryAdvJobInfoRequest.getMRequest().jobID.set(jobId);
        queryAdvJobInfoRequest.getMRequest().jobType.set(jobType);
        queryAdvJobInfoRequest.getMRequest().bizID.set(bizId);
        VSNetworkHelper.getInstance().sendRequest(queryAdvJobInfoRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.request.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                b.f(b.this, baseRequest, z16, j3, str, (QQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp) obj);
            }
        });
    }
}
