package com.tencent.mobileqq.zplan.emoticon.panel.repository;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "code", "", "path", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class Emoticon2DRemoteRepository$query$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ Function3<Integer, String, String, Unit> $callback;
    final /* synthetic */ long $downloadStartTime;
    final /* synthetic */ ZPlanActionInfo $info;
    final /* synthetic */ String $url;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Emoticon2DRemoteRepository$query$1(Function3<? super Integer, ? super String, ? super String, Unit> function3, long j3, ZPlanActionInfo zPlanActionInfo, String str) {
        super(2);
        this.$callback = function3;
        this.$downloadStartTime = j3;
        this.$info = zPlanActionInfo;
        this.$url = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
        invoke(num.intValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(int i3, final String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (i3 == 0 && !TextUtils.isEmpty(path)) {
            final long currentTimeMillis = System.currentTimeMillis();
            final long j3 = currentTimeMillis - this.$downloadStartTime;
            final ZPlanActionInfo zPlanActionInfo = this.$info;
            final String str = this.$url;
            final Function3<Integer, String, String, Unit> function3 = this.$callback;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.repository.b
                @Override // java.lang.Runnable
                public final void run() {
                    Emoticon2DRemoteRepository$query$1.b(ZPlanActionInfo.this, currentTimeMillis, path, str, function3, j3);
                }
            }, 64, null, true);
            return;
        }
        this.$callback.invoke(Integer.valueOf(i3), path, path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZPlanActionInfo info, long j3, String path, String str, Function3 callback, long j16) {
        String l3;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("Emoticon2DRemoteRepository", 1, "start unZip info=" + info);
        long currentTimeMillis = System.currentTimeMillis() - j3;
        long currentTimeMillis2 = System.currentTimeMillis();
        Emoticon2DRemoteRepository emoticon2DRemoteRepository = Emoticon2DRemoteRepository.f333153b;
        l3 = emoticon2DRemoteRepository.l(path, emoticon2DRemoteRepository.a(str, info.getId()));
        if (TextUtils.isEmpty(l3)) {
            QLog.w("Emoticon2DRemoteRepository", 1, "upZipRes error, unZipPath is null");
        }
        File file = new File(emoticon2DRemoteRepository.a(str, info.getId()));
        if (file.exists() && file.isDirectory()) {
            QLog.i("Emoticon2DRemoteRepository", 1, "query match remote data, info=" + info);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "resFile.absolutePath");
            emoticon2DRemoteRepository.d(absolutePath, callback);
            mi3.a.f416857a.a(path);
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            QLog.i("Emoticon2DRemoteRepository", 1, "download cost time:" + j16 + ", unZipPrepareCostTime:" + currentTimeMillis + ", unZipSuccessCostTime:" + currentTimeMillis3);
            emoticon2DRemoteRepository.j(j16, currentTimeMillis, currentTimeMillis3);
            return;
        }
        callback.invoke(-1, "", "");
        QLog.w("Emoticon2DRemoteRepository", 1, "query remote failed");
    }
}
