package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J;\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J7\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005j\u0002`\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/am;", "", "", "params", "c", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "b", "d", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class am {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/am$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadFail", "onLoadSuccess", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309788a;

        b(Function1<Object, Unit> function1) {
            this.f309788a = function1;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            Function1<Object, Unit> function1 = this.f309788a;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", "1"));
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            Function1<Object, Unit> function1 = this.f309788a;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", "0"));
                function1.invoke(mapOf);
            }
        }
    }

    public final void a(@NotNull String params, @Nullable Function1<Object, Unit> callback) {
        List split$default;
        Intrinsics.checkNotNullParameter(params, "params");
        split$default = StringsKt__StringsKt.split$default((CharSequence) params, new String[]{"|"}, false, 0, 6, (Object) null);
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(Long.parseLong((String) split$default.get(0))));
        businessInstance.addDownLoadListener((String) split$default.get(1), new b(callback));
        businessInstance.startDownload((String) split$default.get(1));
    }

    @NotNull
    public final String b(@NotNull String params) {
        List split$default;
        Intrinsics.checkNotNullParameter(params, "params");
        split$default = StringsKt__StringsKt.split$default((CharSequence) params, new String[]{"|"}, false, 0, 6, (Object) null);
        return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(Long.parseLong((String) split$default.get(0)))).getSavePath((String) split$default.get(1)).toString();
    }

    @NotNull
    public final String c(@NotNull String params) {
        List split$default;
        Intrinsics.checkNotNullParameter(params, "params");
        split$default = StringsKt__StringsKt.split$default((CharSequence) params, new String[]{"|"}, false, 0, 6, (Object) null);
        return String.valueOf(((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(Long.parseLong((String) split$default.get(0)))).isFileExist((String) split$default.get(1)));
    }

    public final void d(@NotNull String params, @NotNull Function1<Object, Unit> callback) {
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TextUtils.isEmpty(params)) {
            try {
                str = FilesKt__FileReadWriteKt.readText$default(new File(params), null, 1, null);
            } catch (FileNotFoundException e16) {
                QLog.e("UpdateSystem", 1, "readUpdateSystemFile FileNotFoundException: " + e16.getMessage());
            } catch (IOException e17) {
                QLog.e("UpdateSystem", 1, "readUpdateSystemFile IOException: " + e17.getMessage());
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("data", str));
            callback.invoke(mapOf);
        }
        str = "";
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("data", str));
        callback.invoke(mapOf);
    }
}
