package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.net.Uri;
import android.view.Surface;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes5.dex */
public class RFWPlayerUrlBeanInterceptor extends RFWPlayerBaseInterceptor {
    public RFWPlayerUrlBeanInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    private List<RFWVideoUrlBean> getAllUrlBeans() {
        if (this.mPlayerOptions.getVecUrlBean() != null) {
            return this.mPlayerOptions.getVecUrlBean();
        }
        List<RFWVideoUrlBean> urlBeans = RFWVideoUrlBean.getUrlBeans(this.mPlayerOptions.getStVideo().getVecVideoUrl());
        this.mPlayerOptions.setVecUrlBean(urlBeans);
        return urlBeans;
    }

    private static RFWVideoUrlBean getRealPlayVideoUrl(List<RFWVideoUrlBean> list, int i3) {
        for (RFWVideoUrlBean rFWVideoUrlBean : list) {
            if (i3 == rFWVideoUrlBean.mFormatId) {
                return rFWVideoUrlBean;
            }
        }
        return null;
    }

    @Nullable
    private RFWVideoUrlBean getRealPlayerUrlBean(RFWVideoUrlBean rFWVideoUrlBean, List<RFWVideoUrlBean> list) {
        if (this.mPlayerOptions.getRealPlayBean() != null) {
            return this.mPlayerOptions.getRealPlayBean();
        }
        int formatIdFromUri = RFWVideoUrlBean.getFormatIdFromUri(Uri.parse(this.mPlayer.getRFWPlayerOptions().getRealPlayUrl()));
        if (rFWVideoUrlBean.mFormatId != formatIdFromUri) {
            rFWVideoUrlBean = getRealPlayVideoUrl(list, formatIdFromUri);
        }
        this.mPlayerOptions.setRealPlayBean(rFWVideoUrlBean);
        return rFWVideoUrlBean;
    }

    private RFWVideoUrlBean getServerUrlBean() {
        if (this.mPlayerOptions.getServerPlayBean() != null) {
            return this.mPlayerOptions.getServerPlayBean();
        }
        RFWVideoUrlBean rFWVideoUrlBean = new RFWVideoUrlBean(this.mPlayerOptions.getStVideo());
        this.mPlayerOptions.setServerPlayBean(rFWVideoUrlBean);
        return rFWVideoUrlBean;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public Surface beforeCreateView() {
        if (!this.mPlayerOptions.isLocalVideo() && this.mPlayerOptions.isVideo()) {
            if (this.mPlayerOptions.getStVideo() == null) {
                return super.beforeCreateView();
            }
            if (getRealPlayerUrlBean(getServerUrlBean(), getAllUrlBeans()) == null) {
                RFWLog.w(getTag(), RFWLog.USR, "getRealPlayVideoUrlBean error");
            }
            return super.beforeCreateView();
        }
        return super.beforeCreateView();
    }
}
