package j40;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.immersive.datacardcover.interceptor.QFSSetCoverFeedRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import feedcloud.FeedCloudDatacard$SetDataCardCoverRsp;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ>\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lj40/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/richframework/sender/call/Call$OnRspCallBack;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "N1", "M1", "", "getLogTag", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "yPercent", "P1", "", "isSuccess", "", "retCode", "errMsg", Const.BUNDLE_KEY_REQUEST, "", "rspObj", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "O1", "Landroidx/lifecycle/MutableLiveData;", "Lj40/e;", "i", "Landroidx/lifecycle/MutableLiveData;", "_setCoverResult", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "L1", "()Landroidx/lifecycle/LiveData;", "setCoverResult", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends BaseViewModel implements Call.OnRspCallBack<QCircleBaseRequest> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<SetCoverResult> _setCoverResult;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<SetCoverResult> setCoverResult;

    public a() {
        MutableLiveData<SetCoverResult> mutableLiveData = new MutableLiveData<>();
        this._setCoverResult = mutableLiveData;
        this.setCoverResult = mutableLiveData;
    }

    private final void M1() {
        MutableLiveData<SetCoverResult> mutableLiveData = this._setCoverResult;
        String c46 = uq3.c.c4();
        Intrinsics.checkNotNullExpressionValue(c46, "getQQCircleServerErrorText()");
        mutableLiveData.setValue(new SetCoverResult(3, c46));
    }

    private final void N1() {
        MutableLiveData<SetCoverResult> mutableLiveData = this._setCoverResult;
        String a16 = h.a(R.string.f189403za);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_cover\u2026select_set_cover_succeed)");
        mutableLiveData.setValue(new SetCoverResult(2, a16));
    }

    @NotNull
    public final LiveData<SetCoverResult> L1() {
        return this.setCoverResult;
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean isSuccess, long retCode, @Nullable String errMsg, @NotNull QCircleBaseRequest request, @Nullable Object rspObj, @Nullable Bundle extraData) {
        Intrinsics.checkNotNullParameter(request, "request");
        QLog.d("QFSPersonalCoverFeedSelectViewModel", 1, "onReceive, traceId: " + request.getTraceId() + ", isSuccess: " + isSuccess + ", retCode: " + retCode + ", errMsg: " + errMsg);
        if (rspObj instanceof FeedCloudDatacard$SetDataCardCoverRsp) {
            if (isSuccess && retCode == 0) {
                N1();
            } else {
                M1();
            }
        }
    }

    public final void P1(@NotNull FeedCloudMeta$StFeed feed, float yPercent) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this._setCoverResult.setValue(new SetCoverResult(1, null, 2, null));
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QLog.d("QFSPersonalCoverFeedSelectViewModel", 1, "requestSetCover, network not available ");
            M1();
        } else {
            String str = feed.f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str, "feed.id.get()");
            com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSSetCoverFeedRequest.a(str).f(yPercent).a()).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSPersonalCoverFeedSelectViewModel";
    }
}
