package com.tencent.qqnt.aio;

import android.content.Context;
import android.content.Intent;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/e;", "", "Landroid/content/Intent;", "getIntent", "Landroid/content/Context;", "getContext", "Landroid/view/Window;", "getWindow", "Landroidx/fragment/app/FragmentManager;", "getSupportFragmentManager", "Lcom/tencent/aio/data/AIOContact;", "getAIOContact", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "sendMessage", "", "isAttach", "isScale", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static boolean a(@NotNull e eVar) {
            return true;
        }

        public static boolean b(@NotNull e eVar) {
            return false;
        }

        public static void c(@NotNull e eVar, @NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
        }
    }

    @NotNull
    AIOContact getAIOContact();

    @NotNull
    Context getContext();

    @NotNull
    Intent getIntent();

    @NotNull
    FragmentManager getSupportFragmentManager();

    @NotNull
    Window getWindow();

    boolean isAttach();

    boolean isScale();

    void sendMessage(@NotNull MsgIntent msgIntent);
}
