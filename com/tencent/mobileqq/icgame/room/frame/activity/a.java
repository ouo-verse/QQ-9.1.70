package com.tencent.mobileqq.icgame.room.frame.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"Landroid/content/Intent;", "intent", "Landroid/content/Context;", "context", "", "b", "a", "", "J", "enterTime", "ic-game-impl_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "RoomActivityUtil")
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f237582a;

    private static final void a(Intent intent) {
        boolean z16;
        boolean contains$default;
        Bundle bundleExtra = intent.getBundleExtra("biz_ext_data");
        if (bundleExtra != null) {
            String string = bundleExtra.getString("mqqschema", "");
            Intrinsics.checkNotNullExpressionValue(string, "extData.getString(EnterR\u2026nts.PARAM_MQQ_SCHEMA, \"\")");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) "nocleartop=1", false, 2, (Object) null);
            z16 = !contains$default;
        } else {
            z16 = true;
        }
        QLog.i("ICGameRoomActivityUtil", 1, "processClearTop clearTop = " + z16);
        if (z16) {
            intent.setFlags(335544320);
        } else {
            intent.setFlags(268435456);
        }
    }

    public static final void b(@NotNull Intent intent, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(context, "context");
        if (System.currentTimeMillis() - f237582a <= 1000) {
            return;
        }
        f237582a = System.currentTimeMillis();
        a(intent);
        intent.putExtra("status_bar_transparent", true);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("public_fragment_class", QQLiveRoomContainerFragment.class.getName());
        intent.setClass(context, ICGameLiveActivity.class);
        context.startActivity(intent);
    }
}
