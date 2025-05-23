package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0005\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0006H\u0016R\u0017\u0010\u000b\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/AIOIntent;", "Landroid/content/Intent;", "", "name", "value", "putExtra", "", "d", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", "e", "a", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOIntent extends Intent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Intent intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOIntent(@NotNull Intent intent) {
        super(intent);
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.intent = intent;
        try {
            if (intent.hasExtra("key_peerId")) {
                BaseAIOUtils.d(intent.getStringExtra("key_peerId"));
            }
            if (intent.hasExtra("key_peerUin")) {
                BaseAIOUtils.e(String.valueOf(intent.getLongExtra("key_peerUin", 0L)));
            }
            if (intent.hasExtra("uin")) {
                BaseAIOUtils.e(intent.getStringExtra("uin"));
            }
        } catch (Exception e16) {
            QLog.i("AIOIntent", 1, "[init]: ", e16);
        }
    }

    @Override // android.content.Intent
    @NotNull
    public Intent putExtra(@NotNull String name, @Nullable String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name.equals("key_peerId")) {
            BaseAIOUtils.d(value);
        }
        if (name.equals("uin")) {
            BaseAIOUtils.e(value);
        }
        Intent putExtra = super.putExtra(name, value);
        Intrinsics.checkNotNullExpressionValue(putExtra, "super.putExtra(name, value)");
        return putExtra;
    }

    @Override // android.content.Intent
    @NotNull
    public Intent putExtra(@Nullable String name, long value) {
        boolean equals$default;
        equals$default = StringsKt__StringsJVMKt.equals$default(name, "key_peerUin", false, 2, null);
        if (equals$default) {
            BaseAIOUtils.e(String.valueOf(value));
        }
        Intent putExtra = super.putExtra(name, value);
        Intrinsics.checkNotNullExpressionValue(putExtra, "super.putExtra(name, value)");
        return putExtra;
    }
}
