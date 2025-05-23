package com.tencent.mobileqq.util.conversationtitlebutton;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "tips", "", "avatars", "", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class TitleButtonProcessorManager$getCustomTips$1$1 extends Lambda implements Function2<String, List<? extends Drawable>, Unit> {
    final /* synthetic */ Function2<String, List<? extends Drawable>, Unit> $callback;
    final /* synthetic */ long $startTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TitleButtonProcessorManager$getCustomTips$1$1(long j3, Function2<? super String, ? super List<? extends Drawable>, Unit> function2) {
        super(2);
        this.$startTime = j3;
        this.$callback = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 callback, String tips, List avatars) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(tips, "$tips");
        Intrinsics.checkNotNullParameter(avatars, "$avatars");
        callback.invoke(tips, avatars);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends Drawable> list) {
        invoke2(str, list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final String tips, final List<? extends Drawable> avatars) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        Intrinsics.checkNotNullParameter(avatars, "avatars");
        long currentTimeMillis = System.currentTimeMillis() - this.$startTime;
        if (QLog.isColorLevel()) {
            QLog.i("TitleButtonProcessorManager", 1, "[getCustomTips] tips=" + tips + " avatars=" + avatars.size() + " time=" + currentTimeMillis);
        }
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final Function2<String, List<? extends Drawable>, Unit> function2 = this.$callback;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.k
            @Override // java.lang.Runnable
            public final void run() {
                TitleButtonProcessorManager$getCustomTips$1$1.b(Function2.this, tips, avatars);
            }
        });
    }
}
