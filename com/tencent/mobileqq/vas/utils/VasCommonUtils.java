package com.tencent.mobileqq.vas.utils;

import android.content.Context;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.vas.updatesystem.entity.VasUpdateParcelableParams;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J*\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\fJ2\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/utils/VasCommonUtils;", "", "()V", "convertToBusinessParams", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "parcelableParams", "Lcom/tencent/mobileqq/vas/updatesystem/entity/VasUpdateParcelableParams;", "copyData", "", "to", "", "toIndex", "", "from", "size", "fromOffset", "dWord2Byte", "", "getApp", "Lmqq/app/AppRuntime;", "getNetWorkType", "context", "Landroid/content/Context;", "isMainProcess", "", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasCommonUtils {

    @NotNull
    public static final VasCommonUtils INSTANCE = new VasCommonUtils();

    VasCommonUtils() {
    }

    @Nullable
    public final UpdateListenerParams convertToBusinessParams(@Nullable VasUpdateParcelableParams parcelableParams) {
        if (parcelableParams == null) {
            return new UpdateListenerParams();
        }
        UpdateListenerParams updateListenerParams = new UpdateListenerParams();
        updateListenerParams.mBusinessUpdateParams = new BusinessUpdateParams(parcelableParams.mBid, parcelableParams.mScid, parcelableParams.mFrom);
        updateListenerParams.mErrorCode = parcelableParams.mErrorCode;
        updateListenerParams.mHttpCode = parcelableParams.mHttpCode;
        updateListenerParams.mProgress = parcelableParams.mProgress;
        updateListenerParams.mProgressMax = parcelableParams.mProgressMax;
        updateListenerParams.mProgressRate = parcelableParams.mProgressRate;
        updateListenerParams.mErrorMessage = parcelableParams.mErrorMessage;
        return updateListenerParams;
    }

    public final void copyData(@Nullable byte[] to5, int toIndex, @Nullable byte[] from, int size) {
        copyData(to5, toIndex, from, 0, size);
    }

    public final void dWord2Byte(@NotNull byte[] to5, int toIndex, long from) {
        Intrinsics.checkNotNullParameter(to5, "to");
        to5[toIndex] = (byte) (from >> 24);
        to5[toIndex + 1] = (byte) (from >> 16);
        to5[toIndex + 2] = (byte) (from >> 8);
        to5[toIndex + 3] = (byte) from;
    }

    @NotNull
    public final AppRuntime getApp() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        return waitAppRuntime;
    }

    public final int getNetWorkType() {
        int mobileInfo;
        if (!AppNetConnInfo.isNetSupport()) {
            return 0;
        }
        int i3 = 1;
        if (!AppNetConnInfo.isWifiConn()) {
            if (!AppNetConnInfo.isMobileConn() || (mobileInfo = AppNetConnInfo.getMobileInfo()) == -1) {
                return 0;
            }
            if (mobileInfo == 0 || mobileInfo == 1) {
                return 2;
            }
            i3 = 3;
            if (mobileInfo != 2) {
                return (mobileInfo == 3 || mobileInfo == 4) ? 4 : -1;
            }
        }
        return i3;
    }

    public final boolean isMainProcess() {
        AppRuntime peekAppRuntime;
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            context = BaseApplication.context;
        }
        if (context == null) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                context = peekAppRuntime.getApp();
            } else {
                context = null;
            }
        }
        if (context == null) {
            context = getApp().getApplication();
        }
        return Intrinsics.areEqual(context.getPackageName(), MobileQQ.processName);
    }

    public final void copyData(@Nullable byte[] to5, int toIndex, @Nullable byte[] from, int fromOffset, int size) {
        System.arraycopy(from, fromOffset, to5, toIndex, size);
    }

    public final int getNetWorkType(@Nullable Context context) {
        NetworkInfo recentNetworkInfo;
        if (!AppNetConnInfo.isNetSupport() || (recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo()) == null) {
            return -1;
        }
        return NetworkMonitor.getType(recentNetworkInfo);
    }
}
