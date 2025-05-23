package com.tencent.timi.game.room.impl.util;

import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class YoloRoomFloatViewUtil {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f379268a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<Integer, uh4.e> f379269b = new HashMap<Integer, uh4.e>() { // from class: com.tencent.timi.game.room.impl.util.YoloRoomFloatViewUtil.1
        {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(YoloRoomUtil.J());
            arrayList.add(5);
            for (Integer num : arrayList) {
                uh4.e d16 = YoloRoomFloatViewUtil.d(num.intValue());
                if (d16 != null) {
                    put(num, d16);
                } else {
                    l.e("YoloRoomUtil", "ATTENTION: sFloatViewCreatorMap error - " + num);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements uh4.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f379270a;

        a(int i3) {
            this.f379270a = i3;
        }

        @Override // uh4.e
        public uh4.d a(String str) {
            uh4.d p16;
            if (YoloRoomUtil.c0(this.f379270a)) {
                p16 = ((sm4.a) mm4.b.b(sm4.a.class)).p(Long.parseLong(str));
            } else if (this.f379270a != 5) {
                com.tencent.timi.game.ui.widget.f.c("\u5f85\u5f00\u53d1\uff1a\u60ac\u6d6e\u7403");
                p16 = null;
            } else {
                p16 = ((gh4.f) mm4.b.b(gh4.f.class)).p(Long.parseLong(str));
            }
            if (p16 != null) {
                p16.setLaunchParam(YoloRoomFloatViewUtil.f379268a.get(str));
            }
            l.i("YoloRoomUtil", "FloatViewCreator#create - " + str + "_" + this.f379270a + ", " + p16);
            return p16;
        }
    }

    public static void c(long j3, int i3) {
        l.i("YoloRoomUtil", "exitFloatingView - " + j3 + "_" + i3);
        uh4.a a16 = uh4.a.INSTANCE.a();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        sb5.append("");
        a16.e(sb5.toString());
        f379268a.remove(j3 + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static uh4.e d(int i3) {
        return new a(i3);
    }

    public static void e(long j3, int i3) {
        l.i("YoloRoomUtil", "hideFloatingView - " + j3 + "_" + i3);
        uh4.a a16 = uh4.a.INSTANCE.a();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        sb5.append("");
        a16.d(sb5.toString());
    }

    public static void f(long j3, Object obj) {
        f379268a.put(j3 + "", obj);
    }

    public static void g(long j3, int i3, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        l.i("YoloRoomUtil", "showFloatingView - " + j3 + "_" + i3);
        uh4.a a16 = uh4.a.INSTANCE.a();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        sb5.append("");
        a16.g(sb5.toString(), f379269b.get(Integer.valueOf(i3)));
    }
}
