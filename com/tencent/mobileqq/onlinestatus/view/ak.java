package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH&J\u001c\u0010\u000e\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\fH&J\u001c\u0010\u000f\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/ak;", "", "", "r", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "doOnActivityResult", "Z", "Lkotlin/Function1;", "listener", "z1", "Dg", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface ak {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static void a(@NotNull ak akVar, int i3, int i16, @NotNull Intent data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    void Dg(@NotNull Function1<? super ak, Unit> listener);

    void Z();

    void doOnActivityResult(int requestCode, int resultCode, @NotNull Intent data);

    boolean r();

    void z1(@NotNull Function1<? super ak, Unit> listener);
}
