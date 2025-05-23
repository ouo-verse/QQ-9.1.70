package com.tencent.gamematrix.gmcg.api;

import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgError {
    ErrorNone(0, "", "\u65e0"),
    ErrorInvalidToken(4097, "\u767b\u5f55\u6001\u8fc7\u671f\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55", "\u9274\u6743\u5931\u8d25\uff0ctoken\u8fc7\u671f\uff0c\u6ca1\u6709token\u7b49"),
    ErrorRequestFail(4098, "\u7f51\u7edc\u8fde\u63a5\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\u6216\u8005\u8d85\u65f6"),
    ErrorNoIdleService(4099, "\u8bbe\u5907\u6b63\u5728\u8c03\u6574\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u4e0d\u5141\u8bb8\u6392\u961f\u65f6\uff0c \u6ca1\u6709\u53ef\u7528\u7684\u4e91\u6e38\u620f\u670d\u52a1"),
    ErrorServiceBroken(4100, "\u8bbe\u5907\u6b63\u5728\u8c03\u6574\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620f\u670d\u52a1\uff08\u8bbe\u5907\uff09\u6545\u969c"),
    ErrorServiceSessionExpire(4101, "\u94fe\u63a5\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620f\u670d\u52a1\u8fc7\u671f"),
    ErrorServiceTryTimeNoLeft(4102, "\u65f6\u957f\u4e0d\u8db3\uff0c\u8bf7\u8865\u5145\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620f\u6ca1\u6709\u5269\u4f59\u53ef\u73a9\u65f6\u957f"),
    ErrorLongConnNetworkFail(4103, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620f\u957f\u8fde\u63a5\u7f51\u7edc\u51fa\u9519\uff08SocketIO\uff09"),
    ErrorRTCConnTimeOut(GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_OPENFILE_ERR, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620fWebRTC\u8fde\u63a5\u5931\u8d25"),
    ErrorStreamingException(4105, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u97f3\u89c6\u9891\u6d41\u5f02\u5e38"),
    ErrorAutoLoginGame(4106, "\u8bf7\u91cd\u65b0\u767b\u5f55", "\u81ea\u52a8\u767b\u5f55\u6e38\u620f\u5931\u8d25"),
    ErrorNetworkNotAvailable(GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_POLL_MSG_PARSE_ERR, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u65e0\u53ef\u7528\u7f51\u7edc"),
    ErrorServiceNotUse(GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_POLL_MSG_NO, "\u7531\u4e8e\u60a8\u957f\u65f6\u95f4\u672a\u4f7f\u7528\uff0c\u4e91\u7aef\u8d44\u6e90\u5df2\u81ea\u52a8\u91ca\u653e", "\u5206\u914d\u7684\u4e91\u6e38\u620f\u8bbe\u5907\u4e00\u76f4\u6ca1\u6709\u4f7f\u7528"),
    ErrorServiceOnLineTimeNoLeft(4109, "\u65f6\u957f\u4e0d\u8db3\uff0c\u8bf7\u8865\u5145\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620f\u6ca1\u6709\u5269\u4f59\u7545\u73a9\u65f6\u957f"),
    ErrorRTCConnFailBegin(4110, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620fWebRTC\u8fde\u63a5\u5931\u8d25"),
    ErrorRTCConnFailAfterOfferAnswered(4111, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620fWebRTC\u8fde\u63a5\u5931\u8d25"),
    ErrorRTCConnFailAfterIceReceived(4112, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620fWebRTC\u8fde\u63a5\u5931\u8d25"),
    ErrorRTCConnFailAfterIceCompleted(4113, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620fWebRTC\u8fde\u63a5\u5931\u8d25"),
    ErrorRTCFirstFrameTimeOut(4114, "\u8fde\u63a5\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620fWebRTC\u9996\u5e27\u8d85\u65f6"),
    ErrorRTCFailAfterFirstFrame(4115, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u4e91\u6e38\u620fWebRTC\u9996\u5e27\u4e4b\u540e\u53d1\u751f\u9519\u8bef"),
    ErrorServerClosedAfterUserRelease(4116, "", "\u7528\u6237\u4e3b\u52a8\u91ca\u653e\u8bbe\u5907"),
    ErrorServerClosedByOtherReason(4117, "\u8fde\u63a5\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u5176\u4ed6\u539f\u56e0\u5bfc\u81f4\u7684\u670d\u52a1\u5668\u5173\u95ed"),
    ErrorServerSessionError(4118, "\u8fde\u63a5\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u670d\u52a1\u5668\u4f1a\u8bdd\u9519\u8bef"),
    ErrorPoorMobileDevicePerformance(4119, "\u5f53\u524d\u7ec8\u7aef\u6027\u80fd\u65e0\u6cd5\u652f\u6301\u8fd0\u884c\u4e91\u6e38\u620f", "\u8bbe\u5907\u6027\u80fd\u592a\u5dee\uff0c\u65e0\u6cd5\u8fd0\u884c\u4e91\u6e38\u620f"),
    ErrorServerClosedByPassiveRelease(4120, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u8bbe\u5907\u4f7f\u7528\u8fc7\u7a0b\u4e2d\u79bb\u7ebf"),
    ErrorNetDetectionTimeOut(4121, "\u8fde\u63a5\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u7f51\u7edc\u6d4b\u901f\u8d85\u65f6"),
    ErrorPoorNetworkToAllocDevice(4122, "\u7f51\u7edc\u8fde\u63a5\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u7f51\u7edc\u592a\u5dee\u5bfc\u81f4\u6ca1\u6cd5\u5206\u914d\u5230\u8bbe\u5907"),
    ErrorNoDeviceInAreaToAllocDevice(4123, "\u60a8\u6240\u5728\u7684\u5730\u57df\u4e2d\u6682\u65f6\u6ca1\u6709\u53ef\u7528\u8bbe\u5907\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u533a\u57df\u5185\u6ca1\u6709\u4e91\u6e38\u620f\u8bbe\u5907\u8fdb\u884c\u5206\u914d"),
    ErrorUserIsNotVip(4124, "vip\u5df2\u8fc7\u671f\uff0c\u8bf7\u5f00\u901avip\u540e\u91cd\u8bd5", "\u8be5\u7528\u6237\u4e0d\u662fVIP"),
    ErrorFailOrInvalidGameConfig(4125, "\u6e38\u620f\u8fde\u63a5\u5931\u8d25", "\u83b7\u53d6\u6e38\u620f\u914d\u7f6e\u4fe1\u606f\u5931\u8d25\u6216\u65e0\u6548"),
    ErrorParamsWrong(4126, "\u7f51\u7edc\u8fde\u63a5\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u7f51\u7edc\u53c2\u6570\u9519\u8bef"),
    ErrorServerWrong(4127, "\u6e38\u620f\u8fde\u63a5\u5931\u8d25", "\u4e2d\u53f0\u7cfb\u7edf\u9519\u8bef"),
    ErrorQueueCountExceedLimit(4128, "\u5f53\u524d\u6392\u961f\u4eba\u6570\u8fc7\u591a\uff0c\u8bf7\u8bd5\u8bd5\u5176\u4ed6\u6e38\u620f\u5427", "\u6392\u961f\u4eba\u6570\u8d85\u8fc7\u6700\u5927\u9650\u5236"),
    ErrorNotAllowedToRunOnMultiDevice(4129, "\u5f53\u524d\u8d26\u53f7\u6b63\u5728\u4f7f\u7528\u4e91\u6e38\u620f", "\u4e0d\u5141\u8bb8\u5728\u591a\u7aef\u540c\u65f6\u4f7f\u7528\u4e91\u6e38\u620f"),
    ErrorKickByRepeatConnectToSameDevice(4130, "\u5f53\u524d\u8d26\u53f7\u5728\u53e6\u4e00\u8bbe\u5907\u767b\u5f55\uff0c\u60a8\u5df2\u88ab\u8e22\u51fa", "\u88ab\u53e6\u4e00\u4e2a\u5f80\u540c\u4e00\u4e2a\u8bbe\u5907\u7684\u8fde\u63a5\u8e22\u6389"),
    ErrorShareCodeAlreadyBeUsed(4131, "\u5206\u4eab\u7801\u5df2\u88ab\u4f7f\u7528", "\u5206\u4eab\u7801\u5df2\u88ab\u4f7f\u7528"),
    ErrorShareCodeIsInvalid(4132, "\u5206\u4eab\u7801\u65e0\u6548", "\u5206\u4eab\u7801\u65e0\u6548"),
    ErrorSubAccountSessionExpire(4133, "\u6b64\u8d26\u53f7\u5df2\u4e0b\u7ebf", "\u5b50\u8d26\u53f7\u8d85\u8fc7\u4fdd\u6d3b\u65f6\u95f4"),
    ErrorDomainAccountKickSubAccount(4134, "\u6b64\u8d26\u53f7\u5df2\u4e0b\u7ebf", "\u4e3b\u8d26\u53f7\u6216\u7ba1\u7406\u5458\u8e22\u5b50\u8d26\u53f7\u4e0b\u7ebf"),
    ErrorServerClosedAfterSubAccountRelease(4135, "\u6b64\u8d26\u53f7\u5df2\u4e3b\u52a8\u91ca\u653e", "\u5b50\u8d26\u53f7\u91ca\u653e\u4f7f\u7528\u6743"),
    ErrorSubAccountIsBanned(4136, "\u8d26\u53f7\u6682\u65f6\u88ab\u62c9\u9ed1", "\u5b50\u8d26\u53f7\u6682\u65f6\u88ab\u62c9\u9ed1"),
    ErrorDomainAccountUseShareCodeNotAllowed(4137, "\u6b64\u8d26\u53f7\u7981\u6b62\u4f7f\u7528\u5206\u4eab\u7801", "\u4e0d\u5141\u8bb8\u7528\u4e3b\u8d26\u53f7\u4f7f\u7528\u5206\u4eab\u7801"),
    ErrorNotAllowedToAllocBySecureReason(4138, "\u7531\u4e8e\u5b89\u5168\u539f\u56e0\uff0c\u60a8\u5df2\u88ab\u7981\u6b62\u8bbf\u95ee", "\u7528\u6237\u56e0\u4e3a\u5b89\u5168\u539f\u56e0\u88ab\u7981\u6b62\u8bbf\u95ee"),
    ErrorCannotFindSpecialZoneToAlloc(4139, "\u8bbe\u5907\u6b63\u5728\u8c03\u6574\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u65e0\u6cd5\u627e\u5230\u7279\u5b9a\u7684\u96c6\u7fa4\u6765\u5206\u914d\u8bbe\u5907(\u6bd4\u5982IPTV\u4e13\u7528\u5ba2\u6237\u7aef)"),
    ErrorCannotAllocDeviceToMatchOperator(4140, "\u8bbe\u5907\u6b63\u5728\u8c03\u6574\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", "\u65e0\u6cd5\u627e\u5230\u6ee1\u8db3\u5f53\u524d\u8fd0\u8425\u5546\u7684\u8bbe\u5907"),
    ErrorColdLaunchFailedWhenMirrorSync(4141, "\u6e38\u620f\u8fde\u63a5\u5931\u8d25", "\u955c\u50cf\u672a\u540c\u6b65\u5bfc\u81f4\u51b7\u542f\u52a8\u5931\u8d25"),
    ErrorLiveStreamingError(4142, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u76f4\u64ad\u63a8\u6d41\u51fa\u9519"),
    ErrorLiveStreamingServiceLaunchTimeout(4143, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u8c03\u6574\u540e\u91cd\u8bd5", "\u542f\u52a8\u4e91\u6e38\u620f\u76f4\u64ad\u670d\u52a1\u8d85\u65f6"),
    ErrorNonAgeCheckFailure(4144, "\u672a\u6210\u5e74\u6821\u9a8c\u5931\u8d25", "\u672a\u6210\u5e74\u68c0\u9a8c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5"),
    ErrorNonAgeCheckTooFrequent(4145, "\u672a\u6210\u5e74\u6821\u9a8c\u592a\u8fc7\u9891\u7e41", "\u672a\u6210\u5e74\u6821\u9a8c\u592a\u8fc7\u9891\u7e41\uff0c\u8bf7\u4e24\u79d2\u540e\u518d\u8bd5"),
    ErrorDeviceInsufficientStorage(4146, "\u8bbe\u5907\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3", "\u8bbe\u5907\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3\uff0c\u65e0\u6cd5\u8fd0\u884c\u4e91\u6e38\u620f"),
    ErrorNewVideoDecoderError(4147, "\u65b0\u89e3\u7801\u5668\u5f02\u5e38", "\u65b0\u89e3\u7801\u5668\u5f02\u5e38\uff0c\u4e91\u6e38\u620f\u753b\u9762\u53ef\u80fd\u5f02\u5e38"),
    ErrorDefaultVideoDecoderError(4148, "\u89e3\u7801\u5668\u5f02\u5e38", "\u89e3\u7801\u5668\u5f02\u5e38\uff0c\u4e91\u6e38\u620f\u753b\u9762\u53ef\u80fd\u5f02\u5e38"),
    ErrorPoorNetworkToAllocDeviceOverSeas(4149, "\u62b1\u6b49\uff0c\u60a8\u6240\u5728\u7684\u5730\u533a\u6682\u4e0d\u652f\u6301\u4e91\u6e38\u620f\u670d\u52a1", "\u7f51\u7edc\u592a\u5dee\u5bfc\u81f4\u6ca1\u6cd5\u5206\u914d\u5230\u8bbe\u5907"),
    ErrorNoDeviceInAreaToAllocDeviceOverSeas(4150, "\u62b1\u6b49\uff0c\u60a8\u6240\u5728\u7684\u5730\u533a\u6682\u4e0d\u652f\u6301\u4e91\u6e38\u620f\u670d\u52a1", "\u533a\u57df\u5185\u6ca1\u6709\u4e91\u6e38\u620f\u8bbe\u5907\u8fdb\u884c\u5206\u914d"),
    ErrorOther(4249, "", "\u5176\u5b83\u5f02\u5e38");

    private final String mDetailErrorMsg;
    private final int mErrorCode;
    private final String mErrorMsg;
    private int mSubErrorCode;
    private String mSubErrorMsg;

    GmCgError(int i3, String str, String str2) {
        this.mErrorCode = i3;
        this.mErrorMsg = str;
        this.mDetailErrorMsg = str2;
    }

    public static GmCgError OK() {
        return ErrorNone;
    }

    public static boolean isOK(GmCgError gmCgError) {
        if (gmCgError != null && gmCgError.mErrorCode == ErrorNone.mErrorCode) {
            return true;
        }
        return false;
    }

    public boolean canRetry() {
        if (!isError(ErrorRTCConnTimeOut) && !isError(ErrorRTCConnFailBegin) && !isError(ErrorRTCConnFailAfterOfferAnswered) && !isError(ErrorRTCConnFailAfterIceReceived) && !isError(ErrorRTCConnFailAfterIceCompleted) && !isError(ErrorRTCFirstFrameTimeOut) && !isError(ErrorRTCFailAfterFirstFrame) && !isError(ErrorLongConnNetworkFail)) {
            return false;
        }
        return true;
    }

    public String getDetailErrorMsg() {
        return this.mDetailErrorMsg + "(" + this.mErrorCode + "-" + this.mSubErrorCode + ")";
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg + "(" + this.mErrorCode + ")";
    }

    public int getSubErrorCode() {
        return this.mSubErrorCode;
    }

    public String getSubErrorMsg() {
        return this.mSubErrorMsg + "(" + this.mSubErrorCode + ")";
    }

    public boolean isError(GmCgError gmCgError) {
        if (gmCgError != null && gmCgError.mErrorCode == this.mErrorCode) {
            return true;
        }
        return false;
    }

    public boolean isWarning() {
        if (!isError(ErrorNewVideoDecoderError) && !isError(ErrorDefaultVideoDecoderError)) {
            return false;
        }
        return true;
    }

    public void setSubErrorMsg(int i3, String str) {
        this.mSubErrorCode = i3;
        this.mSubErrorMsg = str;
    }
}
