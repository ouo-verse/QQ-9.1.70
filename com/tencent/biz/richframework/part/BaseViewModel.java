package com.tencent.biz.richframework.part;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.interfaces.IContextOwner;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseViewModel extends ViewModel implements IContextOwner {
    protected int contextHashCode = -1;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class PreloadListener implements OnTaskListener {
        private WeakReference<BaseViewModel> mViewModel;

        PreloadListener(BaseViewModel baseViewModel) {
            this.mViewModel = new WeakReference<>(baseViewModel);
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object[] objArr) {
            BaseViewModel baseViewModel;
            WeakReference<BaseViewModel> weakReference = this.mViewModel;
            if (weakReference != null && (baseViewModel = weakReference.get()) != null) {
                baseViewModel.onPreloadComplete(objArr);
            }
        }
    }

    public abstract String getLogTag();

    public void loadPreloadResult(String str) {
        RFWLog.d(getLogTag(), RFWLog.USR, "loadPreloadResult:" + str);
        PreLoader.addListener(str, new PreloadListener(this));
    }

    public void sendRequest(BaseRequest baseRequest, VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
        sendRequest(this.contextHashCode, baseRequest, onVSRspCallBack);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IContextOwner
    public void setContextHashCode(int i3) {
        this.contextHashCode = i3;
    }

    public void sendRequest(Context context, BaseRequest baseRequest, VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
        sendRequest(context.hashCode(), baseRequest, onVSRspCallBack);
    }

    public void sendRequest(int i3, BaseRequest baseRequest, VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
        VSNetworkHelper.getInstance().sendRequest(i3, baseRequest, (VSDispatchObserver.OnVSRspCallBack<?>) onVSRspCallBack);
        if (baseRequest != null) {
            RFWLog.d(getLogTag(), RFWLog.USR, getLogTag() + "->sendQCircleRequest: CmdName:" + baseRequest.getCmdName() + "| TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPreloadComplete(Object[] objArr) {
    }
}
