package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.utils.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.model.AppTheme;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J(\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/e;", "", "", "dressKeyLeft", "dressKeyRight", "", WadlProxyConsts.SCENE_ID, "Lcom/tencent/zplan/common/model/AppTheme;", "appTheme", "b", "srcPath", "", "d", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f331005a = new e();

    e() {
    }

    private final String b(String dressKeyLeft, String dressKeyRight, int sceneId, AppTheme appTheme) {
        String str = com.tencent.sqshow.zootopia.avatar.filament.a.f369963a.a() + "/" + dressKeyLeft + "_" + dressKeyRight + "_" + sceneId + "_" + appTheme + ".png";
        QLog.i("CoupleAvatarLoadingRecordManager_", 1, "getFrameSavePath, savePath=" + str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String srcPath, String savePath) {
        Intrinsics.checkNotNullParameter(srcPath, "$srcPath");
        Intrinsics.checkNotNullParameter(savePath, "$savePath");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            l.f335829a.b(srcPath, savePath);
            FileUtils.deleteFile(srcPath);
            QLog.i("CoupleAvatarLoadingRecordManager_", 1, "saveFirstFrameStaticImage success, cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", savePath=" + savePath);
        } catch (Throwable th5) {
            QLog.i("CoupleAvatarLoadingRecordManager_", 1, "saveFirstFrameStaticImage error", th5);
        }
    }

    public final synchronized String c(String dressKeyLeft, String dressKeyRight, int sceneId, AppTheme appTheme) {
        String b16;
        Intrinsics.checkNotNullParameter(dressKeyLeft, "dressKeyLeft");
        Intrinsics.checkNotNullParameter(dressKeyRight, "dressKeyRight");
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        b16 = b(dressKeyLeft, dressKeyRight, sceneId, appTheme);
        if (!new File(b16).exists()) {
            b16 = null;
        }
        return b16;
    }

    public final synchronized void d(final String srcPath, String dressKeyLeft, String dressKeyRight, int sceneId, AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Intrinsics.checkNotNullParameter(dressKeyLeft, "dressKeyLeft");
        Intrinsics.checkNotNullParameter(dressKeyRight, "dressKeyRight");
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        final String b16 = b(dressKeyLeft, dressKeyRight, sceneId, appTheme);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.couple.d
            @Override // java.lang.Runnable
            public final void run() {
                e.e(srcPath, b16);
            }
        }, 64, null, true);
    }
}
