package com.tencent.qqnt.aio.adapter.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.pic.api.IPicConvertForNativeApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOAvifConvertApi;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeStep;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOAvifConvertApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOAvifConvertApi;", "", "srcPath", "", "picWidth", "picHeight", "convertAvif2Jpg", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOAvifConvertApiImpl implements IAIOAvifConvertApi {
    public static final String TAG = "AIOAvifConvertApiImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvifConvertApi
    public String convertAvif2Jpg(String srcPath, long picWidth, long picHeight) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        if (TextUtils.isEmpty(srcPath)) {
            QLog.i(TAG, 1, "convertAvif2Jpg srcPath is empty!");
            return "";
        }
        String a16 = com.tencent.hotpatch.c.a(new File(srcPath));
        String path = BaseApplication.getContext().getCacheDir().getPath();
        String str = File.separator;
        String str2 = path + str + "convert" + str + a16;
        if (new File(str2).exists()) {
            return str2;
        }
        return ((IPicConvertForNativeApi) QRoute.api(IPicConvertForNativeApi.class)).convertAvif2Jpg(90, new AvifTranscodeInfo(srcPath, str2, "", picWidth, picHeight)).transcodeStep == AvifTranscodeStep.KSUCFINISHED ? str2 : "";
    }
}
