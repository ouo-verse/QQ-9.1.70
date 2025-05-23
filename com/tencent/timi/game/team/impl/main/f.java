package com.tencent.timi.game.team.impl.main;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f379603a = "f";

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f379604d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f379605e;

        a(long j3, Activity activity) {
            this.f379604d = j3;
            this.f379605e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            f.b(this.f379604d, this.f379605e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f379606d;

        c(Activity activity) {
            this.f379606d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.timi.game.utils.g.g(this.f379606d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f379607d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f379608e;

        d(long j3, Activity activity) {
            this.f379607d = j3;
            this.f379608e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            f.b(this.f379607d, this.f379608e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f379609a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener f379610b;

        e(Activity activity, IResultListener iResultListener) {
            this.f379609a = activity;
            this.f379610b = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp) {
            wf4.a.f445618a.a(this.f379609a);
            l.i(f.f379603a, "leave room success");
            IResultListener iResultListener = this.f379610b;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomLeaveRsp);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            wf4.a.f445618a.a(this.f379609a);
            l.e(f.f379603a, "leave room failed : errorCode == " + i3 + ",errorMessage == " + str);
            IResultListener iResultListener = this.f379610b;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    public static void b(long j3, Activity activity) {
        c(j3, activity, null);
    }

    public static void c(long j3, Activity activity, IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> iResultListener) {
        wf4.a.f445618a.c(activity);
        ((fm4.g) mm4.b.b(fm4.g.class)).T2(j3, false, 0, new e(activity, iResultListener), true);
    }

    public static ConcurrentHashMap<String, String> d(long j3) {
        return ((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).e();
    }

    public static void e(Activity activity, long j3) {
        String str;
        String str2 = "\u786e\u5b9a\u79bb\u5f00\u8f66\u961f\u5417\uff1f";
        if (((fm4.g) mm4.b.b(fm4.g.class)).z1() != null && ((sm4.a) mm4.b.b(sm4.a.class)).n1()) {
            if (((sm4.a) mm4.b.b(sm4.a.class)).a2(j3)) {
                str = "\u79bb\u5f00\u540e\u5c06\u89e3\u6563\u8f66\u961f\uff0c\u4e0a\u8f66\u7528\u6237\u9884\u4ed8\u7684\u91d1\u5e01\u5c06\u9000\u8fd8";
            } else {
                str2 = "\u786e\u8ba4\u8981\u4e0b\u8f66\u5417\uff1f";
                str = "\u4e0b\u8f66\u540e\u9884\u4ed8\u7684\u91d1\u5e01\u5c06\u4f1a\u9000\u56de\u5e10\u6237";
            }
        } else {
            if (((sm4.a) mm4.b.b(sm4.a.class)).y3() && ((sm4.a) mm4.b.b(sm4.a.class)).a2(j3)) {
                str2 = "\u9000\u51fa\u540e\u8f66\u961f\u81ea\u52a8\u89e3\u6563\uff0c\u5e76\u5173\u95ed\u6e38\u620f\u7ec4\u961f\u529f\u80fd\uff0c\u65e0\u6cd5\u5e26\u7c89\u4e0a\u8f66";
            }
            str = str2;
            str2 = "";
        }
        com.tencent.timi.game.ui.widget.e c16 = new e.a(activity).q(str2).j(str).k(17).o(new a(j3, activity)).n("\u53d6\u6d88").m(new b()).c();
        c16.show();
        ((ug4.b) mm4.b.b(ug4.b.class)).G2(c16.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "pg_yes_smoba_team");
        YoloRoomOuterClass$YoloRoomInfo roomInfo = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).getRoomInfo();
        ((ug4.b) mm4.b.b(ug4.b.class)).a(c16.getNegativeButton(), true, null, "em_yes_leaveteam_win_close", YoloRoomUtil.L(roomInfo));
        ((ug4.b) mm4.b.b(ug4.b.class)).a(c16.getPositiveButton(), true, null, "em_yes_leaveteam_win_confirm", YoloRoomUtil.L(roomInfo));
    }

    public static void f(Activity activity, long j3) {
        com.tencent.timi.game.ui.widget.e c16 = new e.a(activity).j("\u6536\u8d77\u8f66\u961f\u9700\u5f00\u542f\u60ac\u6d6e\u7403\u6743\u9650\uff0c\u5426\u5219\u5c06\u9000\u51fa\u8f66\u961f").p("\u53bb\u5f00\u542f").o(new c(activity)).n("\u9000\u51fa\u8f66\u961f").m(new d(j3, activity)).c();
        ConcurrentHashMap<String, String> d16 = d(j3);
        ((ug4.b) mm4.b.b(ug4.b.class)).G2(c16, "pg_yes_smoba_team");
        ((ug4.b) mm4.b.b(ug4.b.class)).a(c16.getPositiveButton(), false, "", "em_yes_floating_authorize_win_open", d16);
        ((ug4.b) mm4.b.b(ug4.b.class)).a(c16.getNegativeButton(), false, "", "em_yes_floating_authorize_win_leave", d16);
        c16.show();
        ((ug4.b) mm4.b.b(ug4.b.class)).G2(c16, "pg_yes_smoba_team");
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
