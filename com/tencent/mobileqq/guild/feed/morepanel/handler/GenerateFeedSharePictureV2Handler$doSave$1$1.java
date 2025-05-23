package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "filePath", "", "isSuccess", "", "errMsg", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GenerateFeedSharePictureV2Handler$doSave$1$1 extends Lambda implements Function3<String, Boolean, String, Unit> {
    final /* synthetic */ Activity $activity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenerateFeedSharePictureV2Handler$doSave$1$1(Activity activity) {
        super(3);
        this.$activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z16, String filePath, Activity activity) {
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (!z16 || TextUtils.isEmpty(filePath)) {
            if (activity.isFinishing()) {
                QLog.w("SPic.GenerateFeedSharePictureV2Handler", 1, "[doSave] activity is finishing!");
            } else {
                QQToastUtil.showQQToast(1, R.string.f142770k_);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool, String str2) {
        invoke(str, bool.booleanValue(), str2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final String filePath, final boolean z16, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Activity activity = this.$activity;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.r
            @Override // java.lang.Runnable
            public final void run() {
                GenerateFeedSharePictureV2Handler$doSave$1$1.b(z16, filePath, activity);
            }
        });
    }
}
