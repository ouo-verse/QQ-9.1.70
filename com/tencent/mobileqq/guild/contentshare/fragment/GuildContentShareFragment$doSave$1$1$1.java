package com.tencent.mobileqq.guild.contentshare.fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "filePath", "", "isSuccess", "", "errMsg", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildContentShareFragment$doSave$1$1$1 extends Lambda implements Function3<String, Boolean, String, Unit> {
    final /* synthetic */ View $view;
    final /* synthetic */ GuildContentShareFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContentShareFragment$doSave$1$1$1(GuildContentShareFragment guildContentShareFragment, View view) {
        super(3);
        this.this$0 = guildContentShareFragment;
        this.$view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildContentShareFragment this$0, View view, boolean z16, String errMsg, String filePath) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        this$0.zh(view, z16, errMsg);
        if (!z16 || TextUtils.isEmpty(filePath)) {
            if (this$0.getActivity() == null) {
                QLog.w("GuildContentShareFragment", 1, "[doSave] activity is null!");
                return;
            }
            FragmentActivity activity = this$0.getActivity();
            boolean z17 = false;
            if (activity != null && activity.isFinishing()) {
                z17 = true;
            }
            if (z17) {
                QLog.w("GuildContentShareFragment", 1, "[doSave] activity is finishing!");
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

    public final void invoke(@NotNull final String filePath, final boolean z16, @NotNull final String errMsg) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final GuildContentShareFragment guildContentShareFragment = this.this$0;
        final View view = this.$view;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.contentshare.fragment.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildContentShareFragment$doSave$1$1$1.b(GuildContentShareFragment.this, view, z16, errMsg, filePath);
            }
        });
    }
}
