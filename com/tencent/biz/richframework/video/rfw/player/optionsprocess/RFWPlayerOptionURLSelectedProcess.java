package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.RFWVideoConstants;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1Strategy;
import com.tencent.mobileqq.qcircle.api.data.QCircleExposeDataBean;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qcircle.cooperation.config.debug.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes5.dex */
public class RFWPlayerOptionURLSelectedProcess implements IRFWPlayerOptionsProcess {
    public static String DEFAULT_PROCESS_URL_SELECTED = "DEFAULT_PROCESS_URL_SELECTED";
    private boolean mIsWnsEnabledVideoSelectFilterF0 = false;

    private RFWVideoUrlBean findRateMaxBean(List<RFWVideoUrlBean> list) {
        if (list != null && list.size() != 0) {
            RFWVideoUrlBean rFWVideoUrlBean = list.get(0);
            for (RFWVideoUrlBean rFWVideoUrlBean2 : list) {
                if (rFWVideoUrlBean2.mRate > rFWVideoUrlBean.mRate) {
                    rFWVideoUrlBean = rFWVideoUrlBean2;
                }
            }
            return rFWVideoUrlBean;
        }
        return null;
    }

    private RFWVideoUrlBean findRateMinBean(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        int i3;
        RFWVideoUrlBean serverPlayBean = rFWPlayerOptions.getServerPlayBean();
        List<RFWVideoUrlBean> filterF0VecUrlBeanList = getFilterF0VecUrlBeanList(rFWPlayerOptions);
        if (RFWPlayerAV1Strategy.enableAV1() && isSupportH265()) {
            for (RFWVideoUrlBean rFWVideoUrlBean : filterF0VecUrlBeanList) {
                if (serverPlayBean.mRate > rFWVideoUrlBean.mRate) {
                    serverPlayBean = rFWVideoUrlBean;
                }
            }
        } else if (isSupportH265()) {
            for (RFWVideoUrlBean rFWVideoUrlBean2 : filterF0VecUrlBeanList) {
                if (serverPlayBean.mRate > rFWVideoUrlBean2.mRate && rFWVideoUrlBean2.mVideoEncode != 4) {
                    serverPlayBean = rFWVideoUrlBean2;
                }
            }
        } else {
            for (RFWVideoUrlBean rFWVideoUrlBean3 : filterF0VecUrlBeanList) {
                if (serverPlayBean.mRate > rFWVideoUrlBean3.mRate && (i3 = rFWVideoUrlBean3.mVideoEncode) != 2 && i3 != 4) {
                    serverPlayBean = rFWVideoUrlBean3;
                }
            }
        }
        return serverPlayBean;
    }

    private void forceDownUrlLevel(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        RFWVideoUrlBean serverPlayBean = rFWPlayerOptions.getServerPlayBean();
        RFWVideoUrlBean realPlayBean = rFWPlayerOptions.getRealPlayBean();
        if (realPlayBean == null) {
            realPlayBean = tryGetRealPlayVideoUrlBean(rFWPlayerOptions, serverPlayBean);
        }
        if (realPlayBean == null) {
            RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "forceDownUrlLevel, failed no play url");
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            return;
        }
        for (RFWVideoUrlBean rFWVideoUrlBean : getFilterF0VecUrlBeanList(rFWPlayerOptions)) {
            if (rFWVideoUrlBean.mVideoEncode == serverPlayBean.mVideoEncode && rFWVideoUrlBean.mRate < realPlayBean.mRate) {
                RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "forceDownUrlLevel, findUrlBen:" + rFWVideoUrlBean);
                updateOptionsAndCallBack(rFWPlayerOptions, iProcessCallBack, rFWVideoUrlBean, true);
                return;
            }
        }
        RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "forceDownUrlLevel, not find lower url");
        updateOptionsAndCallBack(rFWPlayerOptions, iProcessCallBack, realPlayBean, !realPlayBean.mUrl.equals(serverPlayBean.mUrl));
    }

    private List<RFWVideoUrlBean> getFilterF0VecUrlBeanList(RFWPlayerOptions rFWPlayerOptions) {
        ArrayList arrayList = new ArrayList();
        if (rFWPlayerOptions == null) {
            return arrayList;
        }
        List<RFWVideoUrlBean> vecUrlBean = rFWPlayerOptions.getVecUrlBean();
        if (!this.mIsWnsEnabledVideoSelectFilterF0) {
            return vecUrlBean;
        }
        for (RFWVideoUrlBean rFWVideoUrlBean : vecUrlBean) {
            int i3 = rFWVideoUrlBean.mLevelType;
            if (i3 != 9 && i3 != 20) {
                arrayList.add(rFWVideoUrlBean);
            }
        }
        if (arrayList.isEmpty()) {
            return vecUrlBean;
        }
        QLog.d("QFSPlayerOptionURLSelectedNewProcess", 1, "[getFilterF0VecUrlBeanList] current filter f0 bean, list size: " + arrayList.size());
        return arrayList;
    }

    private RFWVideoUrlBean getRFWVideoUrlBeanFromFilterList(List<RFWVideoUrlBean> list, List<RFWVideoUrlBean> list2, List<RFWVideoUrlBean> list3) {
        RFWVideoUrlBean rFWVideoUrlBean;
        if (RFWPlayerAV1Strategy.enableAV1()) {
            rFWVideoUrlBean = findRateMaxBean(list3);
        } else {
            rFWVideoUrlBean = null;
        }
        if (rFWVideoUrlBean != null) {
            return rFWVideoUrlBean;
        }
        if (isSupportH265()) {
            rFWVideoUrlBean = findRateMaxBean(list2);
        }
        if (rFWVideoUrlBean != null) {
            return rFWVideoUrlBean;
        }
        return findRateMaxBean(list);
    }

    private RFWVideoUrlBean getRealPlayVideoUrl(List<RFWVideoUrlBean> list, int i3) {
        for (RFWVideoUrlBean rFWVideoUrlBean : list) {
            if (i3 == rFWVideoUrlBean.mFormatId) {
                return rFWVideoUrlBean;
            }
        }
        return null;
    }

    @Nullable
    private RFWVideoUrlBean getServerBeanResult(@NonNull RFWPlayerOptions rFWPlayerOptions, long j3) {
        if (rFWPlayerOptions.getServerPlayBean() == null) {
            return null;
        }
        RFWVideoUrlBean serverPlayBean = rFWPlayerOptions.getServerPlayBean();
        if (serverPlayBean.mRate / 8 < j3) {
            if (isLegalUrlBean(serverPlayBean)) {
                RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "getTargetBeanByPredictSpeed() use serverBean");
                return serverPlayBean;
            }
            RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "getTargetBeanByPredictSpeed() not use serverBean ,is illegal");
        }
        return null;
    }

    private RFWVideoUrlBean getTargetBeanByPredictSpeed(RFWPlayerOptions rFWPlayerOptions) {
        long predictSpeedWithOutDownGrade = RFWVideoUtils.getPredictSpeedWithOutDownGrade(rFWPlayerOptions.getSceneId());
        rFWPlayerOptions.setPredictSpeed((int) predictSpeedWithOutDownGrade);
        RFWVideoUrlBean serverBeanResult = getServerBeanResult(rFWPlayerOptions, predictSpeedWithOutDownGrade);
        if (serverBeanResult != null) {
            return serverBeanResult;
        }
        List<RFWVideoUrlBean> filterF0VecUrlBeanList = getFilterF0VecUrlBeanList(rFWPlayerOptions);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (RFWVideoUrlBean rFWVideoUrlBean : filterF0VecUrlBeanList) {
            if (rFWVideoUrlBean.mRate / 8 < predictSpeedWithOutDownGrade) {
                int i3 = rFWVideoUrlBean.mVideoEncode;
                if (i3 == 4) {
                    arrayList3.add(rFWVideoUrlBean);
                } else if (i3 == 2) {
                    arrayList2.add(rFWVideoUrlBean);
                } else if (i3 == 1) {
                    arrayList.add(rFWVideoUrlBean);
                }
            }
        }
        String str = ("|preDictSpeed:" + predictSpeedWithOutDownGrade + "KB/S") + "|mTargetBeanH265.size():" + arrayList2.size() + "|mTargetBeanH264.size():" + arrayList.size() + "|mTargetBeanAV1.size():" + arrayList3.size();
        RFWVideoUrlBean rFWVideoUrlBeanFromFilterList = getRFWVideoUrlBeanFromFilterList(arrayList, arrayList2, arrayList3);
        if (rFWVideoUrlBeanFromFilterList != null) {
            String str2 = str + "|resultBeanRate:" + (rFWVideoUrlBeanFromFilterList.mRate / 8) + "KB/S";
            RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "getTargetBeanByPredictSpeed() find int filter:" + str2);
            return rFWVideoUrlBeanFromFilterList;
        }
        RFWVideoUrlBean findRateMinBean = findRateMinBean(rFWPlayerOptions);
        String str3 = str + "|resultBeanRate:" + (findRateMinBean.mRate / 8) + "KB/S";
        RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "getTargetBeanByPredictSpeed() by all search :" + str3);
        return findRateMinBean;
    }

    private RFWVideoUrlBean getTargetBeanIfHasCache(RFWPlayerOptions rFWPlayerOptions) {
        RFWVideoUrlBean serverPlayBean = rFWPlayerOptions.getServerPlayBean();
        if (RFWVideoUtils.checkCacheExist(rFWPlayerOptions.getSceneId(), serverPlayBean.mUrl, rFWPlayerOptions.getFileId())) {
            RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "getTargetBeanIfHasCache() hit serverBean");
            return serverPlayBean;
        }
        for (RFWVideoUrlBean rFWVideoUrlBean : getFilterF0VecUrlBeanList(rFWPlayerOptions)) {
            if (RFWVideoUtils.checkCacheExist(rFWPlayerOptions.getSceneId(), rFWVideoUrlBean.mUrl, rFWPlayerOptions.getFileId())) {
                RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "getTargetBeanIfHasCache() hit vecBean");
                return rFWVideoUrlBean;
            }
        }
        return null;
    }

    private RFWVideoUrlBean getTargetUrlBean(int i3, RFWPlayerOptions rFWPlayerOptions) {
        List<RFWVideoUrlBean> vecUrlBean = rFWPlayerOptions.getVecUrlBean();
        if (i3 == RFWVideoConstants.CURRENT) {
            return rFWPlayerOptions.getRealPlayBean();
        }
        Collections.sort(vecUrlBean, new Comparator<RFWVideoUrlBean>() { // from class: com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionURLSelectedProcess.1
            @Override // java.util.Comparator
            public int compare(RFWVideoUrlBean rFWVideoUrlBean, RFWVideoUrlBean rFWVideoUrlBean2) {
                int min = Math.min(rFWVideoUrlBean2.mWidth, rFWVideoUrlBean2.mHeight) - Math.min(rFWVideoUrlBean.mWidth, rFWVideoUrlBean.mHeight);
                return min == 0 ? rFWVideoUrlBean2.mVideoEncode - rFWVideoUrlBean.mVideoEncode : min;
            }
        });
        RFWVideoUrlBean rFWVideoUrlBean = null;
        for (RFWVideoUrlBean rFWVideoUrlBean2 : vecUrlBean) {
            if (isTargetLevel(i3, rFWVideoUrlBean2)) {
                rFWVideoUrlBean = rFWVideoUrlBean2;
            }
        }
        if (rFWVideoUrlBean == null && vecUrlBean.size() > 0) {
            if (i3 == RFWVideoConstants.LOW) {
                return vecUrlBean.get(vecUrlBean.size() - 1);
            }
            return vecUrlBean.get(0);
        }
        return rFWVideoUrlBean;
    }

    private boolean isDebugOpen(RFWPlayerOptions rFWPlayerOptions) {
        boolean z16;
        boolean isPublicVersion = WinkHostConstants.AppSetting.isPublicVersion();
        if (c.d(QCircleDebugKey$SwitchStateKey.QCIRCLE_USE_SELECTED_URL, 0) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            String a16 = a(rFWPlayerOptions);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isDebugOpen():");
            sb5.append(z16);
            sb5.append("|");
            sb5.append(!isPublicVersion);
            QLog.d(a16, 2, sb5.toString());
        }
        if (!z16 || isPublicVersion) {
            return false;
        }
        return true;
    }

    private boolean isLegalUrlBean(RFWVideoUrlBean rFWVideoUrlBean) {
        if (!RFWPlayerAV1Strategy.enableAV1() && (RFWPlayerAV1Strategy.enableAV1() || RFWVideoUtils.isAV1(rFWVideoUrlBean))) {
            return false;
        }
        return true;
    }

    private boolean isSupportH265() {
        return !"".equals(QCircleExposeDataBean.sIsSupportHEVC);
    }

    private boolean isTargetLevel(int i3, RFWVideoUrlBean rFWVideoUrlBean) {
        int min = Math.min(rFWVideoUrlBean.mWidth, rFWVideoUrlBean.mHeight);
        if (i3 == RFWVideoConstants.ORIGINAL && rFWVideoUrlBean.mLevelType == 9) {
            return true;
        }
        if (i3 == RFWVideoConstants.LOW && min < 710) {
            return true;
        }
        if (i3 == RFWVideoConstants.MIDDLE && min >= 710 && min < 1000) {
            return true;
        }
        if (i3 == RFWVideoConstants.HIGH && min >= 1000 && min < 1200) {
            return true;
        }
        return false;
    }

    private void selectUrlByPredictSpeed(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (isDebugOpen(rFWPlayerOptions)) {
            RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "selectUrlByDownloadSpeed() by debug");
            tryToGetDebugLevel(rFWPlayerOptions, iProcessCallBack);
            return;
        }
        RFWVideoUrlBean serverPlayBean = rFWPlayerOptions.getServerPlayBean();
        if (uq3.c.p0() && !QCircleDeviceInfoUtils.isLowDevice()) {
            RFWVideoUrlBean targetBeanIfHasCache = getTargetBeanIfHasCache(rFWPlayerOptions);
            if (targetBeanIfHasCache != null) {
                RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "selectUrlByDownloadSpeed()| use cache url:" + targetBeanIfHasCache.mUrl);
                rFWPlayerOptions.setSelectHitUrlCache(true);
                updateOptionsAndCallBack(rFWPlayerOptions, iProcessCallBack, targetBeanIfHasCache, targetBeanIfHasCache.mUrl.equals(serverPlayBean.mUrl) ^ true);
                return;
            }
            RFWVideoUrlBean targetBeanByPredictSpeed = getTargetBeanByPredictSpeed(rFWPlayerOptions);
            RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "selectUrlByDownloadSpeed()| finTarget:" + targetBeanByPredictSpeed.mUrl);
            updateOptionsAndCallBack(rFWPlayerOptions, iProcessCallBack, targetBeanByPredictSpeed, targetBeanByPredictSpeed.mUrl.equals(serverPlayBean.mUrl) ^ true);
            return;
        }
        RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "selectUrlByDownloadSpeed()| not enable");
        updateOptionsAndCallBack(rFWPlayerOptions, iProcessCallBack, serverPlayBean, false);
    }

    private RFWVideoUrlBean tryGetRealPlayVideoUrlBean(RFWPlayerOptions rFWPlayerOptions, RFWVideoUrlBean rFWVideoUrlBean) {
        int formatIdFromUri = RFWVideoUrlBean.getFormatIdFromUri(Uri.parse(rFWPlayerOptions.getRealPlayUrl()));
        if (rFWVideoUrlBean.mFormatId == formatIdFromUri) {
            RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "tryGetRealPlayVideoUrlBean, current playing url is server url ");
            return rFWVideoUrlBean;
        }
        return getRealPlayVideoUrl(getFilterF0VecUrlBeanList(rFWPlayerOptions), formatIdFromUri);
    }

    private void tryToGetDebugLevel(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        int d16 = c.d(QCircleDebugKey$SwitchStateKey.QCIRCLE_USE_SELECTED_URL, RFWVideoConstants.CURRENT);
        RFWVideoUrlBean serverPlayBean = rFWPlayerOptions.getServerPlayBean();
        QLog.d(a(rFWPlayerOptions), 1, "tryToGetDebugLevel() :" + d16);
        RFWVideoUrlBean targetUrlBean = getTargetUrlBean(d16, rFWPlayerOptions);
        if (targetUrlBean == null) {
            QLog.d(a(rFWPlayerOptions), 1, "tryToGetDebugLevel() not find target video");
            targetUrlBean = serverPlayBean;
        } else {
            QLog.d(a(rFWPlayerOptions), 1, "tryToGetDebugLevel() find target video:" + targetUrlBean.mUrl);
        }
        updateOptionsAndCallBack(rFWPlayerOptions, iProcessCallBack, targetUrlBean, !targetUrlBean.mUrl.equals(serverPlayBean.mUrl));
    }

    private void updateOptionsAndCallBack(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack, RFWVideoUrlBean rFWVideoUrlBean, boolean z16) {
        rFWPlayerOptions.setRealPlayBean(rFWVideoUrlBean).setRealPlayUrl(rFWVideoUrlBean.mUrl).setHasDownLevel(z16);
        iProcessCallBack.onFinish(rFWPlayerOptions, true);
    }

    public /* synthetic */ String a(RFWPlayerOptions rFWPlayerOptions) {
        return a.a(this, rFWPlayerOptions);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public String getProcessKey() {
        return DEFAULT_PROCESS_URL_SELECTED;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public void onProcess(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (rFWPlayerOptions != null && iProcessCallBack != null) {
            this.mIsWnsEnabledVideoSelectFilterF0 = uq3.c.X5();
            if (rFWPlayerOptions.getStVideo() == null) {
                RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, "selectUrlByDownloadSpeed() null video");
                rFWPlayerOptions.setRealPlayUrl(rFWPlayerOptions.getPlayUrl()).setHasDownLevel(false);
                iProcessCallBack.onFinish(rFWPlayerOptions, true);
                return;
            }
            if (rFWPlayerOptions.getVecUrlBean() == null) {
                rFWPlayerOptions.setVecUrlBean(RFWVideoUrlBean.getUrlBeans(rFWPlayerOptions.getStVideo().getVecVideoUrl()));
            }
            if (rFWPlayerOptions.getServerPlayBean() == null) {
                rFWPlayerOptions.setServerPlayBean(new RFWVideoUrlBean(rFWPlayerOptions.getStVideo()));
            }
            if (rFWPlayerOptions.needDownLevelUrl()) {
                forceDownUrlLevel(rFWPlayerOptions, iProcessCallBack);
            } else {
                selectUrlByPredictSpeed(rFWPlayerOptions, iProcessCallBack);
            }
        }
    }
}
