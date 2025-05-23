package com.tencent.gamematrix.gmcg.sdk.service;

import android.content.Context;
import android.graphics.Point;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.volley.NoConnectionError;
import com.android.volley.VolleyError;
import com.android.volley.h;
import com.google.gson.Gson;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocDeviceLabel;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocatorCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameLoginInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgHardwareInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgSessionCfg;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.network.CGGsonBodyRequest;
import com.tencent.gamematrix.gmcg.base.network.CGGsonRequest;
import com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager;
import com.tencent.gamematrix.gmcg.base.utils.CGDisplayUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGMD5Util;
import com.tencent.gamematrix.gmcg.base.utils.CGRandomUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.config.CGUserDeviceInfo;
import com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGFaceRecognitionResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGFaceRecognitionResult;
import com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest;
import com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService;
import com.tencent.gamematrix.gmcg.sdk.service.CGMergeLaunchCloudGameReqBody;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGBizHttpService {
    private String mReqTag = "CGBizHttpService@" + System.currentTimeMillis();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ResultListener<T> {
        void onResult(@NonNull GmCgError gmCgError, T t16);
    }

    private Point getPortraitScreenSize() {
        Point point = new Point();
        Context appContext = CGGlbConfig.getAppContext();
        if (appContext.getResources().getConfiguration().orientation == 1) {
            point.x = CGDisplayUtil.getScreenWidth(appContext);
            point.y = CGDisplayUtil.getScreenHeight(appContext);
        } else {
            point.x = CGDisplayUtil.getScreenHeight(appContext);
            point.y = CGDisplayUtil.getScreenWidth(appContext);
        }
        return point;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$collectLog$80(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$collectLog$81(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchLog$82(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchLog$83(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$querySaturationResp$84(ResultListener resultListener, CGQuerySaturationResp cGQuerySaturationResp) {
        int i3 = cGQuerySaturationResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGQuerySaturationResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGQuerySaturationResp.f107905msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$querySaturationResp$85(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportEvent$86(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
                return;
            }
            return;
        }
        resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportEvent$87(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAllocDeviceByShareCode$50(ResultListener resultListener, CGAllocDeviceResp cGAllocDeviceResp) {
        int i3 = cGAllocDeviceResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGAllocDeviceResp);
            }
        } else if (resultListener != null) {
            if (i3 == 400) {
                resultListener.onResult(GmCgError.ErrorShareCodeIsInvalid, null);
            } else {
                resultListener.onResult(parseRequestBizError(i3, cGAllocDeviceResp.f107887msg), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAllocDeviceByShareCode$51(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAllocateDevice$4(ResultListener resultListener, CGAllocDeviceResp cGAllocDeviceResp) {
        int i3 = cGAllocDeviceResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGAllocDeviceResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGAllocDeviceResp.f107887msg, Boolean.valueOf(cGAllocDeviceResp.isMainland)), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAllocateDevice$5(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAutoLoginGame$10(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), null);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAutoLoginGame$11(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAutoLoginGameWithNoResolution$12(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), null);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAutoLoginGameWithNoResolution$13(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCancelQueryWaitingQueue$8(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), null);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCancelQueryWaitingQueue$9(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCheckAuthValid$2(ResultListener resultListener, CGInitAuthResp cGInitAuthResp) {
        int i3 = cGInitAuthResp.errCode;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGInitAuthResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGInitAuthResp.f107897msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCheckAuthValid$3(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCloudGameLogin$44(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCloudGameLogin$45(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDeleteUserArchive$66(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDeleteUserArchive$67(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            CGCommonResp cGCommonResp = new CGCommonResp();
            cGCommonResp.ret = -1;
            cGCommonResp.f107888msg = volleyError.getMessage();
            resultListener.onResult(parseRequestError(volleyError), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDetectionNet$32(ResultListener resultListener, CGDetectNetResp cGDetectNetResp) {
        int i3 = cGDetectNetResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGDetectNetResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGDetectNetResp.f107889msg), cGDetectNetResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDetectionNet$33(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFreeDeviceForSubAccount$52(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFreeDeviceForSubAccount$53(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFreeMyDevice$20(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFreeMyDevice$21(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            CGCommonResp cGCommonResp = new CGCommonResp();
            cGCommonResp.ret = -1;
            cGCommonResp.f107888msg = volleyError.getMessage();
            resultListener.onResult(parseRequestError(volleyError), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGateWayIpAddress$30(ResultListener resultListener, CGGetIpAddressResp cGGetIpAddressResp) {
        int i3 = cGGetIpAddressResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGGetIpAddressResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGGetIpAddressResp.f107893msg), cGGetIpAddressResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGateWayIpAddress$31(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGenerateDeviceShareCode$76(ResultListener resultListener, CGDeviceShareCodeResp cGDeviceShareCodeResp) {
        int i3 = cGDeviceShareCodeResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGDeviceShareCodeResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGDeviceShareCodeResp.f107890msg), cGDeviceShareCodeResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGenerateDeviceShareCode$77(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGetGameConfig$38(ResultListener resultListener, CGGameConfigResp cGGameConfigResp) {
        int i3 = cGGameConfigResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGGameConfigResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGGameConfigResp.f107891msg), cGGameConfigResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGetGameConfig$39(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGetMyDeviceById$18(ResultListener resultListener, CGHoldDeviceResp cGHoldDeviceResp) {
        int i3 = cGHoldDeviceResp.retCode;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGHoldDeviceResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGHoldDeviceResp.retMsg), cGHoldDeviceResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGetMyDeviceById$19(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            CGHoldDeviceResp cGHoldDeviceResp = new CGHoldDeviceResp();
            cGHoldDeviceResp.retCode = -1;
            cGHoldDeviceResp.retMsg = volleyError.getMessage();
            cGHoldDeviceResp.devices = new ArrayList();
            resultListener.onResult(parseRequestError(volleyError), cGHoldDeviceResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGetMyDevices$16(ResultListener resultListener, CGHoldDeviceResp cGHoldDeviceResp) {
        int i3 = cGHoldDeviceResp.retCode;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGHoldDeviceResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGHoldDeviceResp.retMsg), cGHoldDeviceResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestGetMyDevices$17(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            CGHoldDeviceResp cGHoldDeviceResp = new CGHoldDeviceResp();
            cGHoldDeviceResp.retCode = -1;
            cGHoldDeviceResp.retMsg = volleyError.getMessage();
            cGHoldDeviceResp.devices = new ArrayList();
            resultListener.onResult(parseRequestError(volleyError), cGHoldDeviceResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestHardwareInfo$72(ResultListener resultListener, CGHardwareInfoResp cGHardwareInfoResp) {
        int i3 = cGHardwareInfoResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGHardwareInfoResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGHardwareInfoResp.f107896msg), cGHardwareInfoResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestHardwareInfo$73(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            CGHardwareInfoResp cGHardwareInfoResp = new CGHardwareInfoResp();
            cGHardwareInfoResp.ret = -1;
            cGHardwareInfoResp.f107896msg = volleyError.getMessage();
            resultListener.onResult(parseRequestError(volleyError), cGHardwareInfoResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestInitAndAuth$0(ResultListener resultListener, CGInitAuthResp cGInitAuthResp) {
        if (cGInitAuthResp.errCode == 0 && cGInitAuthResp.srcErrCode == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGInitAuthResp);
            }
        } else if (cGInitAuthResp.srcErrCode != 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.ErrorInvalidToken, null);
            }
        } else if (resultListener != null) {
            resultListener.onResult(GmCgError.ErrorInvalidToken, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestInitAndAuth$1(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestLoadArchive$36(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestLoadArchive$37(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            CGCommonResp cGCommonResp = new CGCommonResp();
            cGCommonResp.ret = -1;
            cGCommonResp.f107888msg = volleyError.getMessage();
            resultListener.onResult(parseRequestError(volleyError), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMergeLaunchCloudGame$78(ResultListener resultListener, CGMergeLaunchCloudGameResp cGMergeLaunchCloudGameResp) {
        int i3 = cGMergeLaunchCloudGameResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGMergeLaunchCloudGameResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGMergeLaunchCloudGameResp.f107898msg), cGMergeLaunchCloudGameResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMergeLaunchCloudGame$79(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMyRecommendGame$24(ResultListener resultListener, CGRecommendGameResp cGRecommendGameResp) {
        int i3 = cGRecommendGameResp.retCode;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGRecommendGameResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGRecommendGameResp.retMsg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMyRecommendGame$25(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMyWaitQueue$34(ResultListener resultListener, CGGetMyWaitQueueResp cGGetMyWaitQueueResp) {
        int i3 = cGGetMyWaitQueueResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGGetMyWaitQueueResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGGetMyWaitQueueResp.f107895msg), cGGetMyWaitQueueResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMyWaitQueue$35(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryCgDeviceState$48(ResultListener resultListener, CGQueryDeviceStateResp cGQueryDeviceStateResp) {
        int i3 = cGQueryDeviceStateResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGQueryDeviceStateResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGQueryDeviceStateResp.f107900msg), cGQueryDeviceStateResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryCgDeviceState$49(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryColdStartDevice$54(ResultListener resultListener, CGAllocDeviceResp cGAllocDeviceResp) {
        int i3 = cGAllocDeviceResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGAllocDeviceResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGAllocDeviceResp.f107887msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryColdStartDevice$55(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryLiveStreaming$60(ResultListener resultListener, CGQueryLiveStreamingResp cGQueryLiveStreamingResp) {
        int i3 = cGQueryLiveStreamingResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGQueryLiveStreamingResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGQueryLiveStreamingResp.f107901msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryLiveStreaming$61(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryMobileConfig$26(ResultListener resultListener, CGQueryMobileConfigResp cGQueryMobileConfigResp) {
        int i3 = cGQueryMobileConfigResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGQueryMobileConfigResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGQueryMobileConfigResp.f107903msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryMobileConfig$27(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryNetworkQuality$70(ResultListener resultListener, CGQueryNetworkQualityResp cGQueryNetworkQualityResp) {
        int i3 = cGQueryNetworkQualityResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGQueryNetworkQualityResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGQueryNetworkQualityResp.f107904msg), cGQueryNetworkQualityResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryNetworkQuality$71(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            CGQueryNetworkQualityResp cGQueryNetworkQualityResp = new CGQueryNetworkQualityResp();
            cGQueryNetworkQualityResp.ret = -1;
            cGQueryNetworkQualityResp.f107904msg = volleyError.getMessage();
            cGQueryNetworkQualityResp.score = -1;
            resultListener.onResult(parseRequestError(volleyError), cGQueryNetworkQualityResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryWaitingQueue$6(ResultListener resultListener, CGAllocDeviceResp cGAllocDeviceResp) {
        int i3 = cGAllocDeviceResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGAllocDeviceResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGAllocDeviceResp.f107887msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryWaitingQueue$7(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestRemoveDeviceForSubAccount$74(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestRemoveDeviceForSubAccount$75(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestSendDataChannel$68(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestSendDataChannel$69(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestSetMidasProp$28(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestSetMidasProp$29(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestStartLiveStreaming$56(ResultListener resultListener, CGStartLiveStreamingResp cGStartLiveStreamingResp) {
        int i3 = cGStartLiveStreamingResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGStartLiveStreamingResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGStartLiveStreamingResp.f107906msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestStartLiveStreaming$57(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestStartLiveStreamingPod$62(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestStartLiveStreamingPod$63(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestStopLiveStreaming$58(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestStopLiveStreaming$59(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestVirtualGamepadToken$64(ResultListener resultListener, CGVirtualGamepadTokenResp cGVirtualGamepadTokenResp) {
        int i3 = cGVirtualGamepadTokenResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGVirtualGamepadTokenResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGVirtualGamepadTokenResp.f107908msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestVirtualGamepadToken$65(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestYybCloudGameLogin$14(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), null);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestYybCloudGameLogin$15(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMidasPayResult$40(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMidasPayResult$41(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBotDeviceMode$22(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBotDeviceMode$23(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            CGCommonResp cGCommonResp = new CGCommonResp();
            cGCommonResp.ret = -1;
            cGCommonResp.f107888msg = volleyError.getMessage();
            resultListener.onResult(parseRequestError(volleyError), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCloudGameResolution$46(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCloudGameResolution$47(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserDeviceInfo$42(ResultListener resultListener, CGCommonResp cGCommonResp) {
        int i3 = cGCommonResp.ret;
        if (i3 == 0) {
            if (resultListener != null) {
                resultListener.onResult(GmCgError.OK(), cGCommonResp);
            }
        } else if (resultListener != null) {
            resultListener.onResult(parseRequestBizError(i3, cGCommonResp.f107888msg), cGCommonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserDeviceInfo$43(ResultListener resultListener, VolleyError volleyError) {
        if (resultListener != null) {
            resultListener.onResult(parseRequestError(volleyError), null);
        }
    }

    private GmCgError parseRequestBizError(int i3, String str) {
        return switchServerErrorCode(i3, str, null);
    }

    private GmCgError parseRequestError(VolleyError volleyError) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGBizHttpService parseRequestError: ");
        if (volleyError != null) {
            str = volleyError.getMessage();
        } else {
            str = "volleyError";
        }
        sb5.append(str);
        CGLog.e(sb5.toString());
        GmCgError gmCgError = GmCgError.ErrorRequestFail;
        if (volleyError != null && volleyError.networkResponse != null) {
            CGLog.e("request http error: " + volleyError.networkResponse.f31331a + "|" + new String(volleyError.networkResponse.f31332b));
            int i3 = volleyError.networkResponse.f31331a;
            if (401 == i3 || 403 == i3) {
                return GmCgError.ErrorInvalidToken;
            }
            return gmCgError;
        }
        if (volleyError instanceof NoConnectionError) {
            CGLog.e("request http error, no network!");
            return GmCgError.ErrorNetworkNotAvailable;
        }
        return gmCgError;
    }

    private GmCgError switchServerErrorCode(int i3, String str, Object obj) {
        CGLog.e("CGBizHttpService switchServerErrorCode: " + i3 + "|" + str);
        if (i3 != 400) {
            if (i3 != 500) {
                switch (i3) {
                    case 1001:
                        if (obj instanceof Boolean) {
                            if (((Boolean) obj).booleanValue()) {
                                return GmCgError.ErrorPoorNetworkToAllocDevice;
                            }
                            return GmCgError.ErrorPoorNetworkToAllocDeviceOverSeas;
                        }
                        return GmCgError.ErrorPoorNetworkToAllocDevice;
                    case 1002:
                        if (obj instanceof Boolean) {
                            if (((Boolean) obj).booleanValue()) {
                                return GmCgError.ErrorNoDeviceInAreaToAllocDevice;
                            }
                            return GmCgError.ErrorNoDeviceInAreaToAllocDeviceOverSeas;
                        }
                        return GmCgError.ErrorNoDeviceInAreaToAllocDevice;
                    case 1003:
                        return GmCgError.ErrorUserIsNotVip;
                    case 1004:
                        return GmCgError.ErrorQueueCountExceedLimit;
                    case 1005:
                        return GmCgError.ErrorServiceSessionExpire;
                    case 1006:
                        return GmCgError.ErrorNotAllowedToAllocBySecureReason;
                    case 1007:
                        return GmCgError.ErrorShareCodeAlreadyBeUsed;
                    case 1008:
                        return GmCgError.ErrorSubAccountIsBanned;
                    case 1009:
                        return GmCgError.ErrorCannotFindSpecialZoneToAlloc;
                    case 1010:
                        return GmCgError.ErrorCannotAllocDeviceToMatchOperator;
                    case 1011:
                        return GmCgError.ErrorColdLaunchFailedWhenMirrorSync;
                    case 1012:
                        return GmCgError.ErrorLiveStreamingError;
                    case 1013:
                        return GmCgError.ErrorLiveStreamingServiceLaunchTimeout;
                    default:
                        return GmCgError.ErrorRequestFail;
                }
            }
            return GmCgError.ErrorServerWrong;
        }
        return GmCgError.ErrorParamsWrong;
    }

    public void cancel() {
        CGHttpReqManager.get().cancelReqByTag(this.mReqTag);
    }

    public void collectLog(String str, boolean z16, final ResultListener<CGCommonResp> resultListener) {
        CGCollectLogReqBody cGCollectLogReqBody = new CGCollectLogReqBody();
        cGCollectLogReqBody.deviceid = str;
        cGCollectLogReqBody.needLog = z16;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfCollectLog(CGGlbConfig.getGmCgToken()), CGCommonResp.class, CGJsonUtil.toJson(cGCollectLogReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.aq
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$collectLog$80(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ar
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$collectLog$81(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void fetchLog(String str, final ResultListener<CGCommonResp> resultListener) {
        CGFetchLogReqBody cGFetchLogReqBody = new CGFetchLogReqBody();
        cGFetchLogReqBody.deviceid = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfFetchLog(CGGlbConfig.getGmCgToken()), CGCommonResp.class, CGJsonUtil.toJson(cGFetchLogReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bv
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$fetchLog$82(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bw
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$fetchLog$83(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void querySaturationResp(String str, String str2, boolean z16, List<GmCgAllocDeviceLabel> list, final ResultListener<CGQuerySaturationResp> resultListener) {
        CGQuerySaturationReqBody cGQuerySaturationReqBody = new CGQuerySaturationReqBody();
        cGQuerySaturationReqBody.tag = str;
        cGQuerySaturationReqBody.identity = str2;
        cGQuerySaturationReqBody.vip = z16;
        cGQuerySaturationReqBody.supportInstIp = true;
        cGQuerySaturationReqBody.labels = list;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfQuerySaturation(CGGlbConfig.getGmCgToken()), CGQuerySaturationResp.class, new Gson().toJson(cGQuerySaturationReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.av
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$querySaturationResp$84(resultListener, (CGQuerySaturationResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.aw
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$querySaturationResp$85(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void reportEvent(@NonNull CGReportEventReqBody cGReportEventReqBody, final ResultListener<CGCommonResp> resultListener) {
        String str;
        HashMap hashMap = new HashMap();
        String json = CGJsonUtil.toJson(cGReportEventReqBody);
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        String HMACSHA256 = CGSystemUtil.HMACSHA256(json, valueOf, "47ffc4970929");
        hashMap.put("timestamp", valueOf);
        hashMap.put("sign", HMACSHA256);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(CGServerProvider.getServerScheme());
        int i3 = cGReportEventReqBody.pServerEnv;
        if (i3 != 0 && i3 != 3) {
            str = "reportpre.gamematrix.qq.com";
        } else {
            str = "report.gamematrix.qq.com";
        }
        sb5.append(str);
        sb5.append("/sdk/report_event");
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, sb5.toString(), CGCommonResp.class, hashMap, null, json, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.at
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$reportEvent$86(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.au
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$reportEvent$87(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestAllocDeviceByShareCode(String str, final ResultListener<CGAllocDeviceResp> resultListener) {
        CGAllocDeviceByCodeReqBody cGAllocDeviceByCodeReqBody = new CGAllocDeviceByCodeReqBody();
        cGAllocDeviceByCodeReqBody.identity = CGGlbConfig.getUserId();
        cGAllocDeviceByCodeReqBody.share_code = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSdkAllocateDeviceByShareCode(CGGlbConfig.getGmCgToken()), CGAllocDeviceResp.class, new Gson().toJson(cGAllocDeviceByCodeReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.b
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestAllocDeviceByShareCode$50(resultListener, (CGAllocDeviceResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.c
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestAllocDeviceByShareCode$51(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestAllocateDevice(GmCgAllocatorCfg gmCgAllocatorCfg, List<GmCgNetDetectionInfo> list, final ResultListener<CGAllocDeviceResp> resultListener) {
        ArrayList arrayList;
        long j3;
        boolean z16;
        String urlOfSdkAllocateDeviceV2;
        CGAllocDeviceReqBody cGAllocDeviceReqBody = new CGAllocDeviceReqBody();
        cGAllocDeviceReqBody.bussid = CGGlbConfig.getBizId();
        if (list != null) {
            arrayList = new ArrayList(list);
        } else {
            arrayList = null;
        }
        cGAllocDeviceReqBody.speedTest = arrayList;
        CGUserDeviceInfo create = CGUserDeviceInfo.create(gmCgAllocatorCfg.pScreenType);
        CGCloudAppBizInfo cGCloudAppBizInfo = new CGCloudAppBizInfo();
        cGCloudAppBizInfo.enableCloudApp1016ExitCode = true;
        cGCloudAppBizInfo.enableCloudAppAssistScreen = gmCgAllocatorCfg.pEnableCloudAppAssistScreen;
        cGCloudAppBizInfo.enableCloudAppOuterWebJump = gmCgAllocatorCfg.pEnableCloudAppOuterWebJump;
        cGCloudAppBizInfo.enableCloudAppPowerSaveModeNotify = gmCgAllocatorCfg.pEnableCloudAppPowerSaveModeNotify;
        cGCloudAppBizInfo.enableCloudAppSendDownLoadRequest = gmCgAllocatorCfg.pEnableCloudAppSendDownLoadRequest;
        create.setCloudAppBizInfo(new Gson().toJson(cGCloudAppBizInfo));
        cGAllocDeviceReqBody.userDeviceInfo = create;
        CGNotchScreenCfg from = CGNotchScreenCfg.from(gmCgAllocatorCfg.pScreenWidth, gmCgAllocatorCfg.pScreenHeight, gmCgAllocatorCfg.pRotation, gmCgAllocatorCfg.pSafeInsetLeft, gmCgAllocatorCfg.pSafeInsetTop, gmCgAllocatorCfg.pSafeInsetRight, gmCgAllocatorCfg.pSafeInsetBottom, gmCgAllocatorCfg.pBoundingRects);
        if (from != null) {
            cGAllocDeviceReqBody.userDeviceInfo.full_screen = from.flattenToJson();
        }
        cGAllocDeviceReqBody.tag = gmCgAllocatorCfg.pCgGameId;
        cGAllocDeviceReqBody.identity = CGGlbConfig.getUserId();
        cGAllocDeviceReqBody.width = CGDisplayUtil.getScreenWidth(CGGlbConfig.getAppContext());
        cGAllocDeviceReqBody.height = CGDisplayUtil.getScreenHeight(CGGlbConfig.getAppContext());
        cGAllocDeviceReqBody.canWait = gmCgAllocatorCfg.pCanWaitIfQueue;
        int i3 = gmCgAllocatorCfg.pGamePlayType;
        if (1 == i3) {
            j3 = 0;
        } else {
            j3 = gmCgAllocatorCfg.pPlayLimitTime;
        }
        cGAllocDeviceReqBody.maxUseTime = j3;
        cGAllocDeviceReqBody.type = i3;
        cGAllocDeviceReqBody.bizInfo = gmCgAllocatorCfg.pBizExtraInfo;
        cGAllocDeviceReqBody.queuePriority = gmCgAllocatorCfg.pQueuePriority;
        cGAllocDeviceReqBody.newDevice = gmCgAllocatorCfg.pNeedNewDevice;
        cGAllocDeviceReqBody.replaceDevice = gmCgAllocatorCfg.pNeedReplaceDevice;
        int i16 = gmCgAllocatorCfg.pIdentityProfileType;
        boolean z17 = false;
        if (i16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        cGAllocDeviceReqBody.vip = z16;
        if (i16 == 2) {
            z17 = true;
        }
        cGAllocDeviceReqBody.tiyanVip = z17;
        cGAllocDeviceReqBody.localSession = CGNetDetectionManager.get().getTransceiverSessionId();
        cGAllocDeviceReqBody.labels = gmCgAllocatorCfg.pAllocDeviceLabels;
        cGAllocDeviceReqBody.roi = gmCgAllocatorCfg.pRoi;
        cGAllocDeviceReqBody.pcLoginType = gmCgAllocatorCfg.pcLoginType;
        cGAllocDeviceReqBody.superResolution = gmCgAllocatorCfg.pSuperResolutionType;
        cGAllocDeviceReqBody.supportInstIp = true;
        if (CGStringUtil.notEmpty(gmCgAllocatorCfg.pMidGameId)) {
            cGAllocDeviceReqBody.midGame = gmCgAllocatorCfg.pMidGameId;
            urlOfSdkAllocateDeviceV2 = CGServerProvider.get().urlOfSdkAllocateDeviceEndGame(CGGlbConfig.getGmCgToken());
        } else {
            urlOfSdkAllocateDeviceV2 = CGServerProvider.get().urlOfSdkAllocateDeviceV2(CGGlbConfig.getGmCgToken());
        }
        if (CGGlbConfig.sUseDebugAlloc) {
            urlOfSdkAllocateDeviceV2 = CGServerProvider.get().urlOfSdkAllocateDeviceForDebug(CGGlbConfig.getGmCgToken());
        }
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, urlOfSdkAllocateDeviceV2, CGAllocDeviceResp.class, new Gson().toJson(cGAllocDeviceReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.u
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestAllocateDevice$4(resultListener, (CGAllocDeviceResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.v
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestAllocateDevice$5(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestAutoLoginGame(GmCgSessionCfg gmCgSessionCfg, String str, String str2, int i3, int i16, int i17, final ResultListener<Void> resultListener) {
        int i18;
        CGAutoLoginReqBody cGAutoLoginReqBody = new CGAutoLoginReqBody();
        cGAutoLoginReqBody.bussid = CGGlbConfig.getBizId();
        cGAutoLoginReqBody.deviceid = str2;
        cGAutoLoginReqBody.tag = str;
        int i19 = gmCgSessionCfg.pAutoLoginIdType;
        cGAutoLoginReqBody.login_type = i19;
        cGAutoLoginReqBody.src_channel = gmCgSessionCfg.pAutoLoginChannelType;
        cGAutoLoginReqBody.src_appid = gmCgSessionCfg.pAutoLoginChannelAppId;
        cGAutoLoginReqBody.game_payload = gmCgSessionCfg.pGameLoginPayLoad;
        if (i19 != 0) {
            if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 != 3) {
                        if (i19 != 5) {
                            if (i19 != 6) {
                                cGAutoLoginReqBody.src_openid = gmCgSessionCfg.pAutoLoginChannelOpenId;
                                cGAutoLoginReqBody.src_access_token = gmCgSessionCfg.pAutoLoginChannelAccessToken;
                            } else {
                                cGAutoLoginReqBody.src_openid = gmCgSessionCfg.pAutoLoginChannelOpenId;
                                cGAutoLoginReqBody.src_access_token = gmCgSessionCfg.pAutoLoginChannelAccessToken;
                                cGAutoLoginReqBody.param1 = gmCgSessionCfg.pAutoLoginChannelParam1;
                            }
                        } else {
                            String randomString = CGRandomUtil.getRandomString(5);
                            String str3 = gmCgSessionCfg.pAutoLoginChannelParam1;
                            cGAutoLoginReqBody.src_openid = str3;
                            cGAutoLoginReqBody.param1 = str3;
                            cGAutoLoginReqBody.param2 = gmCgSessionCfg.pAutoLoginChannelParam2;
                            cGAutoLoginReqBody.param3 = CGGlbConfig.getUserId();
                            cGAutoLoginReqBody.param4 = CGMD5Util.stringMD5(cGAutoLoginReqBody.param1 + randomString + "gamematrix_auto_login_type5");
                            cGAutoLoginReqBody.param5 = randomString;
                            cGAutoLoginReqBody.param6 = gmCgSessionCfg.pAutoLoginChannelParam6;
                            cGAutoLoginReqBody.src_access_token = gmCgSessionCfg.pAutoLoginChannelAccessToken;
                        }
                    } else {
                        cGAutoLoginReqBody.param1 = gmCgSessionCfg.pAutoLoginChannelParam1;
                        cGAutoLoginReqBody.param2 = gmCgSessionCfg.pAutoLoginChannelParam2;
                    }
                } else {
                    cGAutoLoginReqBody.param1 = gmCgSessionCfg.pAutoLoginChannelParam1;
                    cGAutoLoginReqBody.param2 = gmCgSessionCfg.pAutoLoginChannelParam2;
                    cGAutoLoginReqBody.param3 = gmCgSessionCfg.pAutoLoginChannelParam3;
                }
            } else {
                cGAutoLoginReqBody.src_qq = gmCgSessionCfg.pAutoLoginChannelQQUin;
                cGAutoLoginReqBody.src_skey = gmCgSessionCfg.pAutoLoginChannelQQSkey;
            }
        }
        int i26 = gmCgSessionCfg.pViewWidth;
        if (i26 != 0 && (i18 = gmCgSessionCfg.pViewHeight) != 0) {
            cGAutoLoginReqBody.width = i26;
            cGAutoLoginReqBody.height = i18;
        } else {
            Point portraitScreenSize = getPortraitScreenSize();
            cGAutoLoginReqBody.width = portraitScreenSize.x;
            cGAutoLoginReqBody.height = portraitScreenSize.y;
        }
        cGAutoLoginReqBody.target_width = i3;
        cGAutoLoginReqBody.target_height = i16;
        cGAutoLoginReqBody.target_fps = i17;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSdkAutoLogin(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGAutoLoginReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bm
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestAutoLoginGame$10(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bn
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestAutoLoginGame$11(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestAutoLoginGameWithNoResolution(GmCgGameLoginInfo gmCgGameLoginInfo, String str, String str2, String str3, final ResultListener<Void> resultListener) {
        CGAutoLoginReqBody cGAutoLoginReqBody = new CGAutoLoginReqBody();
        cGAutoLoginReqBody.bussid = CGGlbConfig.getBizId();
        cGAutoLoginReqBody.deviceid = str2;
        cGAutoLoginReqBody.tag = str;
        int i3 = gmCgGameLoginInfo.pIdType;
        cGAutoLoginReqBody.login_type = i3;
        cGAutoLoginReqBody.src_channel = gmCgGameLoginInfo.autoLoginChannelType;
        cGAutoLoginReqBody.src_appid = gmCgGameLoginInfo.pAutoLoginChannelAppId;
        cGAutoLoginReqBody.src_access_token = gmCgGameLoginInfo.pSrcAccessToken;
        cGAutoLoginReqBody.src_openid = gmCgGameLoginInfo.pSrcOpenId;
        cGAutoLoginReqBody.game_payload = str3;
        if (i3 == 5) {
            String randomString = CGRandomUtil.getRandomString(5);
            cGAutoLoginReqBody.param1 = gmCgGameLoginInfo.pGameOpenId;
            cGAutoLoginReqBody.param2 = gmCgGameLoginInfo.pSrcAccessToken;
            cGAutoLoginReqBody.param3 = CGGlbConfig.getUserId();
            cGAutoLoginReqBody.param4 = CGMD5Util.stringMD5(cGAutoLoginReqBody.param1 + randomString + "gamematrix_auto_login_type5");
            cGAutoLoginReqBody.param5 = randomString;
            cGAutoLoginReqBody.param6 = gmCgGameLoginInfo.pPayToken;
        }
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSdkAutoLogin(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGAutoLoginReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bg
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestAutoLoginGameWithNoResolution$12(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bh
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestAutoLoginGameWithNoResolution$13(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestCancelQueryWaitingQueue(String str, final ResultListener<Void> resultListener) {
        CGLog.i("requestCancelQueryWaitingQueue: " + str);
        CGGsonRequest cGGsonRequest = new CGGsonRequest(0, CGServerProvider.get().urlOfSdkCancelWaitingQueue(CGGlbConfig.getGmCgToken(), str), CGCommonResp.class, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.cd
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestCancelQueryWaitingQueue$8(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ce
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestCancelQueryWaitingQueue$9(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestCheckAuthValid(final ResultListener<CGInitAuthResp> resultListener) {
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSdkCheckAuthValid(CGGlbConfig.getGmCgToken()), CGInitAuthResp.class, Collections.emptyMap().toString(), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.d
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestCheckAuthValid$2(resultListener, (CGInitAuthResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.e
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestCheckAuthValid$3(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestCloudGameLogin(String str, String str2, int i3, String str3, String str4, GmCgGameLoginInfo gmCgGameLoginInfo, ResultListener<CGCommonResp> resultListener) {
        requestCloudGameLogin(str, str2, i3, str3, null, str4, gmCgGameLoginInfo, resultListener);
    }

    public void requestDeleteUserArchive(String str, final ResultListener<CGCommonResp> resultListener) {
        CGDeleteUserArchiveReqBody cGDeleteUserArchiveReqBody = new CGDeleteUserArchiveReqBody();
        cGDeleteUserArchiveReqBody.bussid = CGGlbConfig.getBizId();
        cGDeleteUserArchiveReqBody.identity = CGGlbConfig.getUserId();
        cGDeleteUserArchiveReqBody.gameId = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfDeleteUserArchive(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGDeleteUserArchiveReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.af
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestDeleteUserArchive$66(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ag
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestDeleteUserArchive$67(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestDetectionNet(String str, List<GmCgNetDetectionInfo> list, final ResultListener<CGDetectNetResp> resultListener) {
        ArrayList arrayList;
        CGDetectNetReqBody cGDetectNetReqBody = new CGDetectNetReqBody();
        cGDetectNetReqBody.bussid = CGGlbConfig.getBizId();
        cGDetectNetReqBody.tag = str;
        if (list != null) {
            arrayList = new ArrayList(list);
        } else {
            arrayList = null;
        }
        cGDetectNetReqBody.speedTest = arrayList;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfDetectionNet(CGGlbConfig.getGmCgToken()), CGDetectNetResp.class, new Gson().toJson(cGDetectNetReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bp
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestDetectionNet$32(resultListener, (CGDetectNetResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bq
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestDetectionNet$33(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestFaceRecognitionOpenLink(String str, final ResultListener<CGFaceRecognitionResult> resultListener) {
        CGNonAgeProtectRequest.getFaceRecognitionOpenLink(str, new CGNonAgeProtectRequest.IRequestCallback<CGFaceRecognitionResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.1
            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onError(GmCgError gmCgError) {
                ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    resultListener2.onResult(gmCgError, null);
                }
            }

            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onSuccess(CGFaceRecognitionResp cGFaceRecognitionResp) {
                ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    if (cGFaceRecognitionResp != null && cGFaceRecognitionResp.errCode == 0) {
                        resultListener2.onResult(GmCgError.OK(), cGFaceRecognitionResp.result);
                    } else {
                        CGLog.e("requestFaceRecognitionOpenLink failed");
                    }
                }
            }
        });
    }

    public void requestFreeDeviceForSubAccount(String str, String str2, final ResultListener<CGCommonResp> resultListener) {
        CGFreeDeviceReqBody cGFreeDeviceReqBody = new CGFreeDeviceReqBody();
        cGFreeDeviceReqBody.bussid = CGGlbConfig.getBizId();
        cGFreeDeviceReqBody.identity = str;
        cGFreeDeviceReqBody.deviceid = str2;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfFreeDeviceForSubAccount(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGFreeDeviceReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bx
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestFreeDeviceForSubAccount$52(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bz
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestFreeDeviceForSubAccount$53(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestFreeMyDevice(String str, boolean z16, final ResultListener<CGCommonResp> resultListener) {
        CGFreeDeviceReqBody cGFreeDeviceReqBody = new CGFreeDeviceReqBody();
        cGFreeDeviceReqBody.bussid = CGGlbConfig.getBizId();
        cGFreeDeviceReqBody.identity = CGGlbConfig.getUserId();
        cGFreeDeviceReqBody.deviceid = str;
        cGFreeDeviceReqBody.deleteArchive = z16;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfFreeMyDevice(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGFreeDeviceReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bo
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestFreeMyDevice$20(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ca
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestFreeMyDevice$21(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestGateWayIpAddress(final ResultListener<CGGetIpAddressResp> resultListener) {
        CGLog.i("requestGateWayIpAddress!");
        CGGsonRequest cGGsonRequest = new CGGsonRequest(0, CGServerProvider.get().urlOfSdkGatewayAddressV2(CGGlbConfig.getGmCgToken()), CGGetIpAddressResp.class, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ad
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestGateWayIpAddress$30(resultListener, (CGGetIpAddressResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ae
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestGateWayIpAddress$31(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestGenerateDeviceShareCode(String str, String str2, boolean z16, final ResultListener<CGDeviceShareCodeResp> resultListener) {
        CGDeviceShareCodeReqBody cGDeviceShareCodeReqBody = new CGDeviceShareCodeReqBody();
        cGDeviceShareCodeReqBody.bussid = CGGlbConfig.getBizId();
        cGDeviceShareCodeReqBody.identity = str;
        cGDeviceShareCodeReqBody.deviceid = str2;
        cGDeviceShareCodeReqBody.newCode = z16;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfFreeDeviceForSubAccount(CGGlbConfig.getGmCgToken()), CGDeviceShareCodeResp.class, new Gson().toJson(cGDeviceShareCodeReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ch
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestGenerateDeviceShareCode$76(resultListener, (CGDeviceShareCodeResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ci
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestGenerateDeviceShareCode$77(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestGetGameConfig(String str, final ResultListener<CGGameConfigResp> resultListener) {
        CGGameConfigReqBody cGGameConfigReqBody = new CGGameConfigReqBody();
        cGGameConfigReqBody.bussid = CGGlbConfig.getBizId();
        cGGameConfigReqBody.tag = str;
        cGGameConfigReqBody.modelInfo = CGQueryFsrReqBody.create();
        cGGameConfigReqBody.modelInfoV2 = CGQueryMobileConfigReqV2Body.create();
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfGetGameConfig(CGGlbConfig.getGmCgToken()), CGGameConfigResp.class, new Gson().toJson(cGGameConfigReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.be
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestGetGameConfig$38(resultListener, (CGGameConfigResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bf
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestGetGameConfig$39(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestGetMyDeviceById(String str, final ResultListener<CGHoldDeviceResp> resultListener) {
        String urlOfGetMyDevices;
        if (CGStringUtil.notEmpty(str)) {
            urlOfGetMyDevices = CGServerProvider.get().urlOfGetMyDeviceById(CGGlbConfig.getGmCgToken(), CGGlbConfig.getBizId(), CGGlbConfig.getUserId(), str);
        } else {
            urlOfGetMyDevices = CGServerProvider.get().urlOfGetMyDevices(CGGlbConfig.getGmCgToken(), CGGlbConfig.getBizId(), CGGlbConfig.getUserId());
        }
        CGGsonRequest cGGsonRequest = new CGGsonRequest(0, urlOfGetMyDevices, CGHoldDeviceResp.class, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.cb
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestGetMyDeviceById$18(resultListener, (CGHoldDeviceResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.cc
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestGetMyDeviceById$19(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestGetMyDevices(final ResultListener<CGHoldDeviceResp> resultListener) {
        CGGsonRequest cGGsonRequest = new CGGsonRequest(0, CGServerProvider.get().urlOfGetMyDevices(CGGlbConfig.getGmCgToken(), CGGlbConfig.getBizId(), CGGlbConfig.getUserId()), CGHoldDeviceResp.class, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bi
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestGetMyDevices$16(resultListener, (CGHoldDeviceResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bj
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestGetMyDevices$17(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestHardwareInfo(String str, String str2, GmCgHardwareInfo gmCgHardwareInfo, double d16, final ResultListener<CGHardwareInfoResp> resultListener) {
        CGHardwareInfoReqBody cGHardwareInfoReqBody = new CGHardwareInfoReqBody();
        cGHardwareInfoReqBody.brand = str;
        cGHardwareInfoReqBody.soc = str2;
        cGHardwareInfoReqBody.config = gmCgHardwareInfo;
        cGHardwareInfoReqBody.avgDecodeTime = d16;
        HashMap hashMap = new HashMap();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        String valueOf = String.valueOf(calendar.getTimeInMillis() / 1000);
        String json = new Gson().toJson(cGHardwareInfoReqBody);
        String HMACSHA256 = CGSystemUtil.HMACSHA256(json, valueOf, "52aa0cce-230f-480e-9974-c99ff18ba638");
        hashMap.put("timestamp", valueOf);
        hashMap.put("sign", HMACSHA256);
        CGLog.d("requestHardwareInfo: timestamp = " + valueOf + " sign:" + HMACSHA256);
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfGetLiteInfo(), CGHardwareInfoResp.class, hashMap, null, json, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.o
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestHardwareInfo$72(resultListener, (CGHardwareInfoResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.p
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestHardwareInfo$73(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestInitAndAuth(final ResultListener<CGInitAuthResp> resultListener, String str) {
        CGLog.e("CGBizHttpService requestInitAndAuth: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("secretkey", "");
        hashMap.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, CGGlbConfig.getBizId());
        hashMap.put("openid", CGGlbConfig.getUserId());
        hashMap.put("openkey", CGGlbConfig.getUserKey());
        hashMap.put("sdkver", "3.0.0.241111110.3.9-SNAPSHOT");
        hashMap.put(AdParam.SDK_TYPE, "android");
        hashMap.put(ReportDataBuilder.KEY_BUNDLE_ID, CGSystemUtil.getAppPackageName(CGGlbConfig.getAppContext()));
        hashMap.put("sign_md5", CGSystemUtil.getAppSignMd5(CGGlbConfig.getAppContext()));
        hashMap.put("modelInfo", new Gson().toJson(CGQueryMobileConfigReqBody.create()));
        hashMap.put("appChannel", CGGlbConfig.getAppChannel());
        hashMap.put(PublicAccountMessageUtilImpl.META_NAME, CGGlbConfig.geAppBizInfo());
        CGGsonRequest cGGsonRequest = new CGGsonRequest(1, CGServerProvider.get().urlOfSdkInitAndAuth(), CGInitAuthResp.class, hashMap, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.m
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.lambda$requestInitAndAuth$0(CGBizHttpService.ResultListener.this, (CGInitAuthResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.n
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestInitAndAuth$1(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestLoadArchive(String str, String str2, final ResultListener<CGCommonResp> resultListener) {
        CGLoadArchiveReqBody cGLoadArchiveReqBody = new CGLoadArchiveReqBody();
        cGLoadArchiveReqBody.identity = CGGlbConfig.getUserId();
        cGLoadArchiveReqBody.deviceid = str;
        cGLoadArchiveReqBody.session = str2;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfLoadArchive(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGLoadArchiveReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.br
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestLoadArchive$36(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bs
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestLoadArchive$37(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestMergeLaunchCloudGame(String str, List<CGMergeLaunchCloudGameReqBody.BodyBean> list, final ResultListener<CGMergeLaunchCloudGameResp> resultListener) {
        CGMergeLaunchCloudGameReqBody cGMergeLaunchCloudGameReqBody = new CGMergeLaunchCloudGameReqBody();
        cGMergeLaunchCloudGameReqBody.deviceid = str;
        cGMergeLaunchCloudGameReqBody.body = list;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfStartLaunchCloudGameInMerge(CGGlbConfig.getGmCgToken()), CGMergeLaunchCloudGameResp.class, new Gson().toJson(cGMergeLaunchCloudGameReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bk
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestMergeLaunchCloudGame$78(resultListener, (CGMergeLaunchCloudGameResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bl
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestMergeLaunchCloudGame$79(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestMyRecommendGame(List<GmCgNetDetectionInfo> list, List<String> list2, final ResultListener<CGRecommendGameResp> resultListener) {
        CGRecommendGameReqBody cGRecommendGameReqBody = new CGRecommendGameReqBody();
        cGRecommendGameReqBody.bussid = CGGlbConfig.getBizId();
        cGRecommendGameReqBody.speedTest = list;
        cGRecommendGameReqBody.tags = list2;
        cGRecommendGameReqBody.width = CGDisplayUtil.getScreenWidth(CGGlbConfig.getAppContext());
        cGRecommendGameReqBody.height = CGDisplayUtil.getScreenHeight(CGGlbConfig.getAppContext());
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfGetRecommendGame(CGGlbConfig.getGmCgToken()), CGRecommendGameResp.class, new Gson().toJson(cGRecommendGameReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.cf
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestMyRecommendGame$24(resultListener, (CGRecommendGameResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.cg
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestMyRecommendGame$25(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestMyWaitQueue(final ResultListener<CGGetMyWaitQueueResp> resultListener) {
        CGLog.i("requestMyWaitQueue!");
        CGGsonRequest cGGsonRequest = new CGGsonRequest(0, CGServerProvider.get().urlOfGetMyWaitQueue(CGGlbConfig.getGmCgToken(), CGGlbConfig.getUserId()), CGGetMyWaitQueueResp.class, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.x
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestMyWaitQueue$34(resultListener, (CGGetMyWaitQueueResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.y
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestMyWaitQueue$35(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestQueryCgDeviceState(String str, final ResultListener<CGQueryDeviceStateResp> resultListener) {
        CGGsonRequest cGGsonRequest = new CGGsonRequest(0, CGServerProvider.get().urlOfQueryDeviceState(CGGlbConfig.getGmCgToken(), CGGlbConfig.getBizId(), str, CGGlbConfig.getUserId()), CGQueryDeviceStateResp.class, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bt
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestQueryCgDeviceState$48(resultListener, (CGQueryDeviceStateResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bu
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestQueryCgDeviceState$49(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestQueryColdStartDevice(String str, final ResultListener<CGAllocDeviceResp> resultListener) {
        CGDeviceColdStartReqBody cGDeviceColdStartReqBody = new CGDeviceColdStartReqBody();
        cGDeviceColdStartReqBody.deviceid = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSdkQueryColdStartDeviceV2(CGGlbConfig.getGmCgToken()), CGAllocDeviceResp.class, new Gson().toJson(cGDeviceColdStartReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.s
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestQueryColdStartDevice$54(resultListener, (CGAllocDeviceResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.t
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestQueryColdStartDevice$55(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestQueryLiveStreaming(String str, final ResultListener<CGQueryLiveStreamingResp> resultListener) {
        CGLiveStreamingReqBody cGLiveStreamingReqBody = new CGLiveStreamingReqBody();
        cGLiveStreamingReqBody.taskId = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfQueryLiveStreaming(CGGlbConfig.getGmCgToken()), CGQueryLiveStreamingResp.class, new Gson().toJson(cGLiveStreamingReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.j
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestQueryLiveStreaming$60(resultListener, (CGQueryLiveStreamingResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.k
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestQueryLiveStreaming$61(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestQueryMobileConfig(final ResultListener<CGQueryMobileConfigResp> resultListener) {
        CGQueryMobileConfigReqBody cGQueryMobileConfigReqBody = new CGQueryMobileConfigReqBody();
        cGQueryMobileConfigReqBody.brand = CGGlbConfig.getBuildBrand();
        cGQueryMobileConfigReqBody.model = CGGlbConfig.getBuildModel();
        cGQueryMobileConfigReqBody.soc = CGGlbConfig.getSoc();
        cGQueryMobileConfigReqBody.cpu = CGSystemUtil.getCpuCores();
        cGQueryMobileConfigReqBody.memory = CGSystemUtil.getTotalMemoryInGb(CGGlbConfig.getAppContext());
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfQueryMobileConfig(CGGlbConfig.getGmCgToken()), CGQueryMobileConfigResp.class, new Gson().toJson(cGQueryMobileConfigReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ab
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestQueryMobileConfig$26(resultListener, (CGQueryMobileConfigResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ac
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestQueryMobileConfig$27(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestQueryNetworkQuality(String str, float f16, float f17, float f18, int i3, final ResultListener<CGQueryNetworkQualityResp> resultListener) {
        CGGsonRequest cGGsonRequest = new CGGsonRequest(0, CGServerProvider.get().urlOfQueryNetworkQuality(CGGlbConfig.getGmCgToken(), str, String.valueOf(f16), String.valueOf(f17), String.valueOf(f18), String.valueOf(i3)), CGQueryNetworkQualityResp.class, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ax
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestQueryNetworkQuality$70(resultListener, (CGQueryNetworkQualityResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ay
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestQueryNetworkQuality$71(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestQueryWaitingQueue(String str, final ResultListener<CGAllocDeviceResp> resultListener) {
        CGGsonRequest cGGsonRequest = new CGGsonRequest(0, CGServerProvider.get().urlOfSdkQueryWaitingQueue(CGGlbConfig.getGmCgToken(), str), CGAllocDeviceResp.class, new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.f
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestQueryWaitingQueue$6(resultListener, (CGAllocDeviceResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.g
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestQueryWaitingQueue$7(resultListener, volleyError);
            }
        });
        cGGsonRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonRequest);
    }

    public void requestRemoveDeviceForSubAccount(String str, String str2, String str3, final ResultListener<CGCommonResp> resultListener) {
        CGFreeDeviceReqBody cGFreeDeviceReqBody = new CGFreeDeviceReqBody();
        cGFreeDeviceReqBody.bussid = CGGlbConfig.getBizId();
        cGFreeDeviceReqBody.identity = str;
        cGFreeDeviceReqBody.deviceid = str2;
        cGFreeDeviceReqBody.message = str3;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfRemoveDeviceForSubAccount(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGFreeDeviceReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.q
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestRemoveDeviceForSubAccount$74(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.r
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestRemoveDeviceForSubAccount$75(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestSendDataChannel(String str, String str2, final ResultListener<CGCommonResp> resultListener) {
        CGSendDataChannelReqBody cGSendDataChannelReqBody = new CGSendDataChannelReqBody();
        cGSendDataChannelReqBody.deviceid = str;
        cGSendDataChannelReqBody.data = str2;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSendDataChannel(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGSendDataChannelReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.w
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestSendDataChannel$68(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ah
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestSendDataChannel$69(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestSetMidasProp(GmCgSessionCfg gmCgSessionCfg, String str, final ResultListener<CGCommonResp> resultListener) {
        CGSetMidasPropReqBody cGSetMidasPropReqBody = new CGSetMidasPropReqBody();
        cGSetMidasPropReqBody.linkid = gmCgSessionCfg.pMidasPayLinkId;
        cGSetMidasPropReqBody.client_offerid = gmCgSessionCfg.pMidasPayClientOfferId;
        cGSetMidasPropReqBody.client_openid = gmCgSessionCfg.pMidasPayClientOpenId;
        cGSetMidasPropReqBody.platform_id = gmCgSessionCfg.pMidasPayPlatformId;
        cGSetMidasPropReqBody.platform_type = gmCgSessionCfg.pMidasPayPlatformType;
        cGSetMidasPropReqBody.deviceid = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSetMidasProp(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGSetMidasPropReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.az
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestSetMidasProp$28(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ba
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestSetMidasProp$29(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestStartLiveStreaming(String str, String str2, String str3, final ResultListener<CGStartLiveStreamingResp> resultListener) {
        CGStartLiveStreamingReqBody cGStartLiveStreamingReqBody = new CGStartLiveStreamingReqBody();
        cGStartLiveStreamingReqBody.deviceid = str;
        cGStartLiveStreamingReqBody.rtmpAddr = str2;
        cGStartLiveStreamingReqBody.codecParams = str3;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfStartLiveStreaming(CGGlbConfig.getGmCgToken()), CGStartLiveStreamingResp.class, new Gson().toJson(cGStartLiveStreamingReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.z
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestStartLiveStreaming$56(resultListener, (CGStartLiveStreamingResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.aa
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestStartLiveStreaming$57(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestStartLiveStreamingPod(String str, final ResultListener<CGCommonResp> resultListener) {
        CGLiveStreamingReqBody cGLiveStreamingReqBody = new CGLiveStreamingReqBody();
        cGLiveStreamingReqBody.deviceid = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfStartLiveStreamingPod(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGLiveStreamingReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.am
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestStartLiveStreamingPod$62(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.an
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestStartLiveStreamingPod$63(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestStopLiveStreaming(String str, final ResultListener<CGCommonResp> resultListener) {
        CGLiveStreamingReqBody cGLiveStreamingReqBody = new CGLiveStreamingReqBody();
        cGLiveStreamingReqBody.taskId = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfStopLiveStreaming(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGLiveStreamingReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bb
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestStopLiveStreaming$58(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bc
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestStopLiveStreaming$59(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestVirtualGamepadToken(String str, final ResultListener<CGVirtualGamepadTokenResp> resultListener) {
        CGVirtualGamepadTokenReqBody cGVirtualGamepadTokenReqBody = new CGVirtualGamepadTokenReqBody();
        cGVirtualGamepadTokenReqBody.deviceid = str;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfQueryVirtualGamepadToken(CGGlbConfig.getGmCgToken()), CGVirtualGamepadTokenResp.class, new Gson().toJson(cGVirtualGamepadTokenReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.cj
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestVirtualGamepadToken$64(resultListener, (CGVirtualGamepadTokenResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ck
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestVirtualGamepadToken$65(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestYybCloudGameLogin(GmCgSessionCfg gmCgSessionCfg, String str, ResultListener<Void> resultListener) {
        CGYybCloudGameLoginReqBody cGYybCloudGameLoginReqBody = new CGYybCloudGameLoginReqBody();
        cGYybCloudGameLoginReqBody.deviceid = str;
        cGYybCloudGameLoginReqBody.src_appid = gmCgSessionCfg.pYybLoginSrcAppId;
        cGYybCloudGameLoginReqBody.channel = gmCgSessionCfg.pYybLoginChannel;
        cGYybCloudGameLoginReqBody.openid = gmCgSessionCfg.pYybLoginOpenId;
        cGYybCloudGameLoginReqBody.access_token = gmCgSessionCfg.pYybLoginAccessToken;
        cGYybCloudGameLoginReqBody.login_type = gmCgSessionCfg.pYybLoginLoginType;
        cGYybCloudGameLoginReqBody.sdk_type = gmCgSessionCfg.pYybLoginSdkType;
        cGYybCloudGameLoginReqBody.param1 = gmCgSessionCfg.pYybLoginParam1;
        cGYybCloudGameLoginReqBody.param2 = gmCgSessionCfg.pYybLoginParam2;
        cGYybCloudGameLoginReqBody.param3 = gmCgSessionCfg.pYybLoginParam3;
        requestYybCloudGameLogin(cGYybCloudGameLoginReqBody, resultListener);
    }

    public void sendMidasPayResult(String str, String str2, String str3, String str4, final ResultListener<CGCommonResp> resultListener) {
        CGSendMidasResultReqBody cGSendMidasResultReqBody = new CGSendMidasResultReqBody();
        cGSendMidasResultReqBody.device_id = str;
        cGSendMidasResultReqBody.game_tag = str2;
        cGSendMidasResultReqBody.identity = str3;
        cGSendMidasResultReqBody.data = str4;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSendMidasPayResult(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGSendMidasResultReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ao
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$sendMidasPayResult$40(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ap
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$sendMidasPayResult$41(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void setBotDeviceMode(String str, boolean z16, ResultListener<CGCommonResp> resultListener) {
        setBotDeviceMode(str, z16, null, resultListener);
    }

    public void setCloudGameResolution(String str, int i3, int i16, int i17, int i18, final ResultListener<CGCommonResp> resultListener) {
        CGSetCloudGameResolutionReqBody cGSetCloudGameResolutionReqBody = new CGSetCloudGameResolutionReqBody();
        cGSetCloudGameResolutionReqBody.bussid = CGGlbConfig.getBizId();
        cGSetCloudGameResolutionReqBody.identity = CGGlbConfig.getUserId();
        cGSetCloudGameResolutionReqBody.deviceid = str;
        cGSetCloudGameResolutionReqBody.width = i3;
        cGSetCloudGameResolutionReqBody.height = i16;
        cGSetCloudGameResolutionReqBody.target_width = i17;
        cGSetCloudGameResolutionReqBody.target_height = i18;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSetCloudGameResolution(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGSetCloudGameResolutionReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.a
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$setCloudGameResolution$46(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.l
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$setCloudGameResolution$47(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void setUserDeviceInfo(String str, final ResultListener<CGCommonResp> resultListener) {
        CGSetUserDeviceInfoReqBody cGSetUserDeviceInfoReqBody = new CGSetUserDeviceInfoReqBody();
        cGSetUserDeviceInfoReqBody.bussid = CGGlbConfig.getBizId();
        cGSetUserDeviceInfoReqBody.identity = CGGlbConfig.getUserId();
        if (CGStringUtil.notEmpty(str)) {
            cGSetUserDeviceInfoReqBody.deviceid = str;
        }
        cGSetUserDeviceInfoReqBody.iiid = CGGlbConfig.getIMEI();
        cGSetUserDeviceInfoReqBody.qiiid = CGGlbConfig.getQIMEI();
        cGSetUserDeviceInfoReqBody.anid = CGGlbConfig.getAndroidId();
        cGSetUserDeviceInfoReqBody.source = "android_app";
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSetUserDeviceInfo(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGSetUserDeviceInfoReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.as
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$setUserDeviceInfo$42(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.bd
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$setUserDeviceInfo$43(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    private GmCgError parseRequestBizError(int i3, String str, @Nullable Object obj) {
        return switchServerErrorCode(i3, str, obj);
    }

    public void requestCloudGameLogin(String str, String str2, int i3, String str3, @Nullable String str4, String str5, GmCgGameLoginInfo gmCgGameLoginInfo, final ResultListener<CGCommonResp> resultListener) {
        CGCloudGameLoginReqBody cGCloudGameLoginReqBody = new CGCloudGameLoginReqBody();
        cGCloudGameLoginReqBody.bussid = CGGlbConfig.getBizId();
        cGCloudGameLoginReqBody.deviceid = str;
        cGCloudGameLoginReqBody.gameid = str2;
        cGCloudGameLoginReqBody.game_payload = str5;
        cGCloudGameLoginReqBody.identity = CGGlbConfig.getUserId();
        cGCloudGameLoginReqBody.channel = i3;
        cGCloudGameLoginReqBody.code = str3;
        cGCloudGameLoginReqBody.type = 3;
        cGCloudGameLoginReqBody.os_type = str4;
        cGCloudGameLoginReqBody.game_payload = str5;
        if (CGStringUtil.notEmpty(str3)) {
            cGCloudGameLoginReqBody.code = str3;
            cGCloudGameLoginReqBody.type = 3;
        } else if (gmCgGameLoginInfo != null) {
            int i16 = gmCgGameLoginInfo.pIdType;
            if (i16 == 3) {
                cGCloudGameLoginReqBody.code = gmCgGameLoginInfo.pGameDelegateCode;
                cGCloudGameLoginReqBody.type = 3;
            } else if (i16 == 7) {
                cGCloudGameLoginReqBody.dst_openid = gmCgGameLoginInfo.pQQUserOpenId;
                cGCloudGameLoginReqBody.dst_access_token = gmCgGameLoginInfo.pQQUserToken;
                cGCloudGameLoginReqBody.param1 = gmCgGameLoginInfo.pQQUserPayToken;
                cGCloudGameLoginReqBody.code = gmCgGameLoginInfo.pWeChatFinalCode;
                cGCloudGameLoginReqBody.type = 7;
            }
        }
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfCloudGameLogin(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGCloudGameLoginReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.h
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestCloudGameLogin$44(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.i
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestCloudGameLogin$45(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void setBotDeviceMode(String str, boolean z16, Integer num, final ResultListener<CGCommonResp> resultListener) {
        CGSetBotDeviceModeReqBody cGSetBotDeviceModeReqBody = new CGSetBotDeviceModeReqBody();
        cGSetBotDeviceModeReqBody.bussid = CGGlbConfig.getBizId();
        cGSetBotDeviceModeReqBody.identity = CGGlbConfig.getUserId();
        cGSetBotDeviceModeReqBody.deviceid = str;
        cGSetBotDeviceModeReqBody.bot = z16;
        cGSetBotDeviceModeReqBody.botTime = num;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfSetBotDeviceMode(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGSetBotDeviceModeReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ai
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$setBotDeviceMode$22(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.aj
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$setBotDeviceMode$23(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    public void requestYybCloudGameLogin(CGYybCloudGameLoginReqBody cGYybCloudGameLoginReqBody, final ResultListener<Void> resultListener) {
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, CGServerProvider.get().urlOfYybCloudGameLogin(CGGlbConfig.getGmCgToken()), CGCommonResp.class, new Gson().toJson(cGYybCloudGameLoginReqBody), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.service.ak
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBizHttpService.this.lambda$requestYybCloudGameLogin$14(resultListener, (CGCommonResp) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.service.al
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBizHttpService.this.lambda$requestYybCloudGameLogin$15(resultListener, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }
}
