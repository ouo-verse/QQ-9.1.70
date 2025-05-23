package com.tencent.mobileqq.tvideo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tvideo.TVideoChannelList$GetVideoChannelListResp;
import tvideo.TVideoChannelList$VideoChannelData;
import tvideo.TVideoChannelList$VideoChannelListData;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/tvideo/viewmodel/b;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/e;", "", "getLogTag", "", ICustomDataEditor.NUMBER_PARAM_2, "Landroidx/lifecycle/MutableLiveData;", "", "Ltvideo/TVideoChannelList$VideoChannelData;", "K", "Landroidx/lifecycle/MutableLiveData;", "mVideoData", "<init>", "()V", "L", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends com.tencent.biz.qqcircle.immersive.layer.base.e {

    /* renamed from: K, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MutableLiveData<List<TVideoChannelList$VideoChannelData>> mVideoData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(b this$0, BaseRequest baseRequest, boolean z16, long j3, String str, TVideoChannelList$GetVideoChannelListResp tVideoChannelList$GetVideoChannelListResp) {
        TVideoChannelList$VideoChannelListData tVideoChannelList$VideoChannelListData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSLayerTVideoChannelViewModel", 4, "isSuccess=" + z16 + " \uff1b retCode=" + j3 + " \uff1b errMsg=" + str + " \uff1b rsp=" + tVideoChannelList$GetVideoChannelListResp);
        if (z16 && tVideoChannelList$GetVideoChannelListResp != null && (tVideoChannelList$VideoChannelListData = tVideoChannelList$GetVideoChannelListResp.data) != null && j3 == 0) {
            this$0.mVideoData.setValue(tVideoChannelList$VideoChannelListData.channel_list.get());
        } else {
            this$0.mVideoData.setValue(null);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerTVideoChannelViewModel";
    }

    public final void n2() {
        QLog.d("QFSLayerTVideoChannelViewModel", 4, "requestChannelList");
        sendRequest(new QFSTVideoChannelListRequest(), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.viewmodel.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                b.o2(b.this, baseRequest, z16, j3, str, (TVideoChannelList$GetVideoChannelListResp) obj);
            }
        });
    }
}
