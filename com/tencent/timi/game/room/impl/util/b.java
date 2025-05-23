package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/room/impl/util/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "", "b", "c", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f379321a = new b();

    b() {
    }

    private final void b(Activity activity, String url) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("ishiderefresh", true);
        intent.putExtra("ishidebackforward", true);
        intent.putExtra("title", "\u5b9e\u540d\u8ba4\u8bc1");
        activity.startActivity(intent.putExtra("url", url));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Activity activity, String url, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(url, "$url");
        f379321a.b(activity, url);
    }

    public final void c(@NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        final QBaseActivity b16 = vf4.a.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getTopQActivity()");
        if (b16.isFinishing()) {
            l.e("DialogUtil", "showSpeakingAuthDialog activity error " + b16);
            return;
        }
        new e.a(b16).j("\u5f53\u524d\u5e10\u6237\u672a\u5b9e\u540d\u8ba4\u8bc1\uff0c\u8ba4\u8bc1\u540e\u5373\u53ef\u7533\u8bf7\u4e0a\u9ea6").p("\u53bb\u5b9e\u540d").n("\u53d6\u6d88\u7533\u8bf7").o(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.room.impl.util.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                b.d(b16, url, dialogInterface, i3);
            }
        }).f(false).c().show();
    }
}
