package com.tencent.ttpic.openapi.initializer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.tbs.reader.IReaderConstants;
import com.tencent.tbs.reader.ITbsReader;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTCommonInitializer extends Feature {
    private static final String TAG = "YTCommonInitializer";
    private int authMode = 0;
    private static final SharedLibraryInfo[] sharedLibraries = {new SharedLibraryInfo(SoLoadConstants.SONAME_YTCOMMON)};
    private static final SharedLibraryInfo YT_COMMON = new SharedLibraryInfo(SoLoadConstants.SONAME_YTCOMMON);

    private String getErrorMessage(int i3) {
        String str;
        if (i3 != -1407) {
            if (i3 != -1405) {
                if (i3 != -1301) {
                    if (i3 != -1005) {
                        if (i3 != -1001) {
                            if (i3 != 0) {
                                if (i3 != 3013) {
                                    if (i3 != 4001) {
                                        if (i3 != 4003) {
                                            if (i3 != -1402) {
                                                if (i3 != -1401) {
                                                    if (i3 != 1002) {
                                                        if (i3 != 1003) {
                                                            if (i3 != 3003) {
                                                                if (i3 != 3004) {
                                                                    switch (i3) {
                                                                        case 2002:
                                                                            str = "\u8bc1\u4e66\u4e0b\u8f7d\u5931\u8d25";
                                                                            break;
                                                                        case 2003:
                                                                            str = "\u8bc1\u4e66\u4fdd\u5b58\u5931\u8d25";
                                                                            break;
                                                                        case 2004:
                                                                            str = "\u6ca1\u6709\u5199\u6743\u9650";
                                                                            break;
                                                                        default:
                                                                            switch (i3) {
                                                                                case 3015:
                                                                                    str = "package name\u4e0d\u5339\u914d";
                                                                                    break;
                                                                                case 3016:
                                                                                    str = "package name\u4e3a\u7a7a";
                                                                                    break;
                                                                                case 3017:
                                                                                    str = "\u8bc1\u4e66\u5df2\u7ecf\u8fc7\u671f(\u7d2f\u8ba1\u65f6\u95f4)";
                                                                                    break;
                                                                                case ITbsReader.READER_EVENT_NIGHT_MODE_CHANGED /* 3018 */:
                                                                                    str = "\u8bc1\u4e66\u5df2\u8fc7\u671f";
                                                                                    break;
                                                                                case IReaderConstants.READER_CB_FEATURE_FLAG /* 3019 */:
                                                                                    str = "license\u7248\u672c\u4e0d\u5339\u914d";
                                                                                    break;
                                                                                default:
                                                                                    str = MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR;
                                                                                    break;
                                                                            }
                                                                    }
                                                                } else {
                                                                    str = "\u6388\u6743\u6587\u4ef6\u89e3\u6790\u5931\u8d25.";
                                                                }
                                                            } else {
                                                                str = "\u8bc1\u4e66\u6587\u4ef6\u4e3a\u7a7a";
                                                            }
                                                        } else {
                                                            str = "\u7f51\u7edc\u521d\u59cb\u5316\u9519\u8bef";
                                                        }
                                                    } else {
                                                        str = "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25";
                                                    }
                                                } else {
                                                    str = "\u8be5\u8bbe\u5907\u7eed\u671f\u6b21\u6570\u8d85\u8fc7\u9650\u5236";
                                                }
                                            } else {
                                                str = "\u6388\u6743\u65f6\u95f4\u65e0\u6548";
                                            }
                                        } else {
                                            str = "\u6ca1\u6709\u6743\u9650\u83b7\u53d6\u5e8f\u5217\u53f7.";
                                        }
                                    } else {
                                        str = "\u8bbe\u5907\u5e8f\u5217\u53f7\u65e0\u6548";
                                    }
                                } else {
                                    str = "\u8bbe\u5907\u4fe1\u606f\u4e0d\u5339\u914d";
                                }
                            } else {
                                str = "\u6388\u6743\u6210\u529f";
                            }
                        } else {
                            str = "\u8bf7\u6c42\u5b57\u6bb5\u4e2d\u53c2\u6570\u9519\u8bef";
                        }
                    } else {
                        str = "\u8bbe\u5907\u65f6\u95f4\u548c\u670d\u52a1\u5668\u4e0d\u7b26";
                    }
                } else {
                    str = "\u5e8f\u5217\u53f7\u4fe1\u606f\u4e3a\u7a7a";
                }
            } else {
                str = "appid\u6ca1\u6709\u5339\u914d\u5230\u8bbe\u5907";
            }
        } else {
            str = "\u6388\u6743\u5df2\u8fc7\u671f";
        }
        return "[" + i3 + "]" + str;
    }

    private boolean initAuth() {
        int initAuthForQQ;
        boolean z16;
        if (this.authMode == 0) {
            if (TextUtils.isEmpty(AEModule.getLicense())) {
                logForInitAuth(AEModule.getContext(), AEModule.DEFAULT_LICENSE_NAME, 0);
                initAuthForQQ = YTCommonInterface.initAuth(AEModule.getContext(), AEModule.DEFAULT_LICENSE_NAME, 0);
            } else {
                logForInitAuth(AEModule.getContext(), AEModule.getLicense(), AEModule.getLicenseInitType());
                initAuthForQQ = YTCommonInterface.initAuth(AEModule.getContext(), AEModule.getLicense(), AEModule.getLicenseInitType());
            }
        } else {
            initAuthForQQ = YTCommonInterface.initAuthForQQ(AEModule.getContext());
        }
        String errorMessage = getErrorMessage(initAuthForQQ);
        LogUtils.i("AEKitFeature", errorMessage);
        if (initAuthForQQ == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        AEOpenRenderConfig.checkStrictMode(z16, errorMessage);
        if (initAuthForQQ != 0) {
            return false;
        }
        return true;
    }

    private boolean initCommonSoInAssets() {
        this.isInited = systemLoadLibrarySafely(YT_COMMON.fileName);
        LogUtils.i(TAG, "YTCommon so init result: " + this.isInited);
        return this.isInited;
    }

    private void logForInitAuth(Context context, String str, int i3) {
        boolean z16;
        String str2 = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isContextNull::");
        if (context == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(",license::");
        sb5.append(str);
        sb5.append(",licenseInitType::");
        sb5.append(i3);
        LogUtils.i(str2, sb5.toString());
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature
    protected boolean destroyImpl() {
        return false;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public List<ModelInfo> getModelInfos() {
        return new ArrayList();
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public String getName() {
        return SoLoadConstants.SONAME_YTCOMMON;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public List<SharedLibraryInfo> getSharedLibraries() {
        return Arrays.asList(sharedLibraries);
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature
    protected boolean initImpl() {
        if (initCommonSoInAssets() && initAuth()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public boolean isResourceReady() {
        return true;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature
    public boolean isSoReadyInDirectory(String str) {
        return true;
    }

    public void setAuthMode(int i3) {
        this.authMode = i3;
    }
}
