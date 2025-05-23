package com.qzone.reborn.groupalbum.selectmedia.util;

import android.graphics.drawable.Animatable;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a(\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0000\u001aG\u0010\u0010\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nH\u0000\u00a8\u0006\u0011"}, d2 = {"Landroid/widget/ImageView;", "", "path", "", "decodeWith", "decodeHeight", "", "c", "Lkotlin/Function0;", "noExit", "Lkotlin/Function1;", "Ljava/io/File;", "Lkotlin/ParameterName;", "name", "file", "exit", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e {
    public static final void b(String str, Function0<Unit> function0, Function1<? super File, Unit> exit) {
        Intrinsics.checkNotNullParameter(exit, "exit");
        if (str == null || str.length() == 0) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            exit.invoke(file);
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void c(ImageView imageView, String path, int i3, int i16) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        Option obtain = Option.obtain();
        obtain.setLocalPath(path);
        obtain.setTargetView(imageView);
        obtain.setNeedShowLoadingDrawable(false);
        obtain.setNeedShowFailedDrawable(false);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026iledDrawable(false)\n    }");
        iPicAIOApi.loadPic(obtain, new IPicLoadStateListener() { // from class: com.qzone.reborn.groupalbum.selectmedia.util.d
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                e.d(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LoadState loadState, Option option) {
        Animatable animatable;
        if (loadState.isFinish() && loadState.isFinishSuccess() && (animatable = option.getAnimatable()) != null) {
            animatable.start();
        }
    }
}
