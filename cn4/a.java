package cn4;

import ag4.h;
import ag4.i;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.l;
import fm4.g;
import java.util.HashMap;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomUserData;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f31157a;

    /* renamed from: b, reason: collision with root package name */
    private static Dialog f31158b;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<Integer, Boolean> f31159c = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f31160d;

        b(int i3) {
            this.f31160d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ((i) mm4.b.b(i.class)).Q2(this.f31160d);
        }
    }

    public static boolean a(Activity activity, long j3, int i3, boolean z16, String str) {
        YoloRoomOuterClass$YoloRoomUserData m3 = ((g) mm4.b.b(g.class)).K0(j3).m();
        if (m3 != null && m3.is_need_update_tips.get()) {
            l.i("GangupTeamUtil", "checkGameVersionUpdate - isFromEnterRoom = " + z16 + ", sHasShowGameVersionDialog = " + f31159c.get(Integer.valueOf(i3)) + " - " + j3 + "_" + i3);
            Boolean bool = f31159c.get(Integer.valueOf(i3));
            if (bool != null && bool.booleanValue() && z16) {
                l.i("GangupTeamUtil", "checkGameVersionUpdate ignore");
                return false;
            }
            f31159c.put(Integer.valueOf(i3), Boolean.TRUE);
            d(activity, j3, i3, "checkGameVersionUpdate-" + str, 2);
            return false;
        }
        l.i("GangupTeamUtil", "checkGameVersionUpdate, no new version - " + j3 + "_" + i3);
        return true;
    }

    public static void b() {
        l.e("GangupTeamUtil", "closeVersionDialogIfShowing - " + f31158b);
        Dialog dialog = f31158b;
        if (dialog != null && dialog.isShowing()) {
            f31158b.dismiss();
        }
        f31158b = null;
    }

    private static void c(Activity activity, int i3, String str) {
        Dialog dialog = f31158b;
        if (dialog != null && dialog.isShowing() && f31157a == i3) {
            l.e("GangupTeamUtil", "showGameVersionUpdateDialog already showing");
            return;
        }
        b();
        e c16 = new e.a(activity).q("\u63d0\u793a").j(str + "\u5ba2\u6237\u7aef\u5df2\u66f4\u65b0\uff0c\u5efa\u8bae\u63d0\u524d\u5347\u7ea7\u81f3\u6700\u65b0\u7248\u672c\uff0c\u5f00\u9ed1\u66f4\u6d41\u7545\u54e6").p("\u53bb\u66f4\u65b0").o(new b(i3)).n("\u53d6\u6d88").m(new DialogInterfaceOnClickListenerC0208a()).c();
        f31158b = c16;
        c16.show();
        f31157a = i3;
        l.i("GangupTeamUtil", "showGameVersionUpdateDialog - show");
    }

    public static void d(Activity activity, long j3, int i3, String str, int i16) {
        String str2;
        l.e("GangupTeamUtil", "showGameVersionUpdateDialog - " + str + " - " + j3 + "_" + i3);
        YesGameInfoOuterClass$GameConfigInfo l16 = ((h) mm4.b.b(h.class)).l1(i3);
        if (TextUtils.isEmpty(l16.game_name.get())) {
            str2 = "\u6e38\u620f";
        } else {
            str2 = l16.game_name.get();
        }
        String str3 = str2 + "\u5ba2\u6237\u7aef\u5df2\u66f4\u65b0\uff0c\u5efa\u8bae\u63d0\u524d\u5347\u7ea7\u81f3\u6700\u65b0\u7248\u672c\uff0c\u5f00\u9ed1\u66f4\u6d41\u7545\u54e6\n\u53bb\u66f4\u65b0 ";
        if (i16 == 1) {
            c(activity, i3, str2);
            return;
        }
        YoloRoomOuterClass$YoloRoomInfo z16 = ((g) mm4.b.b(g.class)).z1();
        if (z16 != null) {
            com.tencent.timi.game.room.impl.util.g.f379335a.c(z16.tim_group_id.get(), z16.room_id.get(), str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cn4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class DialogInterfaceOnClickListenerC0208a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0208a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
