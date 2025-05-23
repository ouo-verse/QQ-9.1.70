package com.tencent.mobileqq.minigame.va.download;

import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.minigame.va.util.DiffPatchUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi;
import com.vivo.push.PushClientConstants;
import cs3.ApkInfo;
import cs3.MetaDreamAppExtraInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002JP\u0010\u0013\u001a\u00020\u00042F\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/download/MetaDreamDownloadRequest;", "Lcom/tencent/mobileqq/minigame/va/download/MiniGameVARequest;", "Lcs3/d;", "extraInfo", "", "handleDownloadInfo", "", "toast", "showToastOnDebug", "handleFailed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "data", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "listener", "setListener", "appId", PushClientConstants.TAG_PKG_NAME, "requestGameDownload", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MetaDreamDownloadRequest extends MiniGameVARequest {
    public static final String PACKAGE_NAME = "com.tencent.letsgo";
    public static final String TAG = "MiniGameVAMetaDownloadRequest";

    private final void handleDownloadInfo(MetaDreamAppExtraInfo extraInfo) {
        QLog.i(TAG, 1, "handleDownloadInfo extraInfo :" + extraInfo);
        MiniGameDownloadData miniGameDownloadData = new MiniGameDownloadData();
        ApkInfo apkInfo = extraInfo.getApkInfo();
        String gameId = apkInfo != null ? apkInfo.getGameId() : null;
        if (gameId == null) {
            gameId = "";
        }
        miniGameDownloadData.setGameId(gameId);
        ApkInfo apkInfo2 = extraInfo.getApkInfo();
        String gameIcon = apkInfo2 != null ? apkInfo2.getGameIcon() : null;
        if (gameIcon == null) {
            gameIcon = "";
        }
        miniGameDownloadData.setGameIcon(gameIcon);
        ApkInfo apkInfo3 = extraInfo.getApkInfo();
        String gameName = apkInfo3 != null ? apkInfo3.getGameName() : null;
        if (gameName == null) {
            gameName = "";
        }
        miniGameDownloadData.setGameName(gameName);
        miniGameDownloadData.setPkgName("com.tencent.letsgo");
        ApkInfo apkInfo4 = extraInfo.getApkInfo();
        String versionCode = apkInfo4 != null ? apkInfo4.getVersionCode() : null;
        if (versionCode == null) {
            versionCode = "";
        }
        miniGameDownloadData.setVersionCode(versionCode);
        ApkInfo apkInfo5 = extraInfo.getApkInfo();
        String downloadUrl = apkInfo5 != null ? apkInfo5.getDownloadUrl() : null;
        miniGameDownloadData.setDownloadUrl(downloadUrl != null ? downloadUrl : "");
        ApkInfo apkInfo6 = extraInfo.getApkInfo();
        miniGameDownloadData.setSize(apkInfo6 != null ? apkInfo6.getSize() : 0L);
        miniGameDownloadData.setDiffPatchInfo(DiffPatchUtil.INSTANCE.json2DiffPatchInfo(extraInfo.getDiffPatchInfo()));
        Function2<Boolean, MiniGameDownloadData, Unit> requestCallback = getRequestCallback();
        if (requestCallback != null) {
            requestCallback.invoke(Boolean.TRUE, miniGameDownloadData);
        }
    }

    private final void handleFailed() {
        Function2<Boolean, MiniGameDownloadData, Unit> requestCallback = getRequestCallback();
        if (requestCallback != null) {
            requestCallback.invoke(Boolean.FALSE, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestGameDownload$lambda$0(MetaDreamDownloadRequest this$0, MetaDreamAppExtraInfo extraInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((extraInfo != null ? extraInfo.getApkInfo() : null) != null) {
            Intrinsics.checkNotNullExpressionValue(extraInfo, "extraInfo");
            this$0.handleDownloadInfo(extraInfo);
        } else {
            Function2<Boolean, MiniGameDownloadData, Unit> requestCallback = this$0.getRequestCallback();
            if (requestCallback != null) {
                requestCallback.invoke(Boolean.FALSE, null);
            }
        }
    }

    private static final void showToastOnDebug$lambda$2(String toast) {
        Intrinsics.checkNotNullParameter(toast, "$toast");
        QQToast.makeText(BaseApplication.getContext(), toast, 0).show();
    }

    @Override // com.tencent.mobileqq.minigame.va.download.MiniGameVARequest
    public void requestGameDownload(String appId, String pkgName) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).getExtraInfo(new cs3.c() { // from class: com.tencent.mobileqq.minigame.va.download.a
            @Override // cs3.c
            public final void onExtraRsp(MetaDreamAppExtraInfo metaDreamAppExtraInfo) {
                MetaDreamDownloadRequest.requestGameDownload$lambda$0(MetaDreamDownloadRequest.this, metaDreamAppExtraInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.va.download.MiniGameVARequest
    public void setListener(Function2<? super Boolean, ? super MiniGameDownloadData, Unit> listener) {
        setRequestCallback(listener);
    }

    private final void showToastOnDebug(String toast) {
    }
}
