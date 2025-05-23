package com.tencent.mobileqq.onlinestatus.view.zplan;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\b\u0010\u0003\u001a\u00020\u0002H&JX\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\nH&J\b\u0010\u0013\u001a\u00020\u0010H&R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/j;", "", "Landroid/view/View;", "getView", "", "uin", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "", DKWebViewController.DKHippyWebviewFunction.RELOAD, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "", "error", "", "callback", "a", "release", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;", "getListener", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;", "b", "(Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;)V", "listener", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface j {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;", "", "", "uin", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(@NotNull String uin, @NotNull com.tencent.mobileqq.onlinestatus.model.b res, @Nullable Bitmap bitmap);
    }

    void a(@NotNull String uin, @NotNull com.tencent.mobileqq.onlinestatus.model.b res, boolean reload, @NotNull Function2<? super Boolean, ? super Integer, Unit> callback);

    void b(@Nullable a aVar);

    @NotNull
    View getView();

    void release();
}
