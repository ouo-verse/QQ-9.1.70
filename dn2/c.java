package dn2;

import android.content.Context;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Ldn2/c;", "", "Landroid/content/Context;", "context", "", "result", "", "c", "", "mediaPath", "showResultToast", "useOriginName", "e", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f394314a = new c();

    c() {
    }

    private final void c(final Context context, boolean result) {
        final int i3;
        final int i16;
        if (result) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (result) {
            i16 = R.string.f173075h42;
        } else {
            i16 = R.string.cwi;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: dn2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(context, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, int i3, int i16) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, i3, i16, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(boolean z16, Context context, RFWSaveMediaResultBean result) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d("", 1, "newSaveAlbumApi, result:" + result.isSuccess);
        if (z16) {
            f394314a.c(context, result.isSuccess);
        }
    }

    public final void e(@NotNull final Context context, @NotNull String mediaPath, final boolean showResultToast, boolean useOriginName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        RFWSaveUtil.insertMedia(context, mediaPath, useOriginName, new Consumer() { // from class: dn2.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                c.f(showResultToast, context, (RFWSaveMediaResultBean) obj);
            }
        });
    }
}
