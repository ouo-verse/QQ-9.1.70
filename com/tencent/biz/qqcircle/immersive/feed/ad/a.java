package com.tencent.biz.qqcircle.immersive.feed.ad;

import NS_COMM.COMM;
import android.view.View;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Comm_errKt;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\r\u0010\u000bR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/a;", "", "Landroid/view/View;", "view", "", "isBigBannerVisible", "", "a", "(Landroid/view/View;Z)Ljava/lang/Integer;", "viewId", "c", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "b", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "AreaIdMap", "MotiveBigBannerAreaIdMap", "EndCardAreaIdMap", "e", "SpaceAreaIdMap", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f85437a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> AreaIdMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> MotiveBigBannerAreaIdMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> EndCardAreaIdMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> SpaceAreaIdMap;

    static {
        HashMap<Integer, Integer> hashMapOf;
        HashMap<Integer, Integer> hashMapOf2;
        HashMap<Integer, Integer> hashMapOf3;
        HashMap<Integer, Integer> hashMapOf4;
        Integer valueOf = Integer.valueOf(R.id.f3742178);
        Integer valueOf2 = Integer.valueOf(R.id.f374617b);
        Integer valueOf3 = Integer.valueOf(R.id.f376617v);
        Integer valueOf4 = Integer.valueOf(R.id.f374817d);
        Integer valueOf5 = Integer.valueOf(R.id.f375617l);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(R.id.f3740176), 3), TuplesKt.to(Integer.valueOf(R.id.f38601_e), 43), TuplesKt.to(Integer.valueOf(R.id.f38611_f), 44), TuplesKt.to(valueOf, 56), TuplesKt.to(valueOf2, 57), TuplesKt.to(valueOf3, 59), TuplesKt.to(valueOf4, 60), TuplesKt.to(valueOf5, 58), TuplesKt.to(Integer.valueOf(R.id.f38531_8), 67), TuplesKt.to(Integer.valueOf(R.id.f3743179), 74), TuplesKt.to(Integer.valueOf(R.id.f374717c), 75), TuplesKt.to(Integer.valueOf(R.id.f375717m), 76), TuplesKt.to(Integer.valueOf(R.id.f376817x), 77), TuplesKt.to(Integer.valueOf(R.id.f375017f), 78), TuplesKt.to(Integer.valueOf(R.id.f376417t), 79), TuplesKt.to(Integer.valueOf(R.id.f376317s), 79), TuplesKt.to(Integer.valueOf(R.id.v9j), 4), TuplesKt.to(Integer.valueOf(R.id.f38911a9), 10023), TuplesKt.to(Integer.valueOf(R.id.f38871a5), 10023), TuplesKt.to(Integer.valueOf(R.id.f38901a8), 10023), TuplesKt.to(Integer.valueOf(R.id.f38891a7), 10023), TuplesKt.to(Integer.valueOf(R.id.f38921a_), 10023), TuplesKt.to(Integer.valueOf(R.id.f38961ad), 10031), TuplesKt.to(Integer.valueOf(R.id.f38951ac), 10032), TuplesKt.to(Integer.valueOf(R.id.f378618e), 43), TuplesKt.to(Integer.valueOf(R.id.f379718p), 59), TuplesKt.to(Integer.valueOf(R.id.f33260vz), 60), TuplesKt.to(Integer.valueOf(R.id.f378718f), 10044), TuplesKt.to(Integer.valueOf(R.id.f378818g), 10043), TuplesKt.to(Integer.valueOf(R.id.f379218k), 10045), TuplesKt.to(Integer.valueOf(R.id.f378918h), 10045), TuplesKt.to(Integer.valueOf(R.id.f379018i), 10045), TuplesKt.to(Integer.valueOf(R.id.f379118j), 10045), TuplesKt.to(Integer.valueOf(R.id.f38491_4), 10046), TuplesKt.to(Integer.valueOf(R.id.f38501_5), 10047), TuplesKt.to(Integer.valueOf(R.id.f38481_3), 10048), TuplesKt.to(Integer.valueOf(R.id.f38471_2), 10049), TuplesKt.to(Integer.valueOf(R.id.f3772181), 10091), TuplesKt.to(Integer.valueOf(R.id.f377017z), 66), TuplesKt.to(Integer.valueOf(R.id.f375917o), Integer.valueOf(COMM.mini_app_info)));
        AreaIdMap = hashMapOf;
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(valueOf, 10036), TuplesKt.to(valueOf2, 10037), TuplesKt.to(valueOf3, Integer.valueOf(Comm_errKt.QZRetCode_QZ_VIDEO_TRANSCODING)), TuplesKt.to(valueOf4, 10040), TuplesKt.to(valueOf5, 10038), TuplesKt.to(Integer.valueOf(R.id.f38961ad), 10031), TuplesKt.to(Integer.valueOf(R.id.f38951ac), 10032), TuplesKt.to(Integer.valueOf(R.id.f378518d), 10034), TuplesKt.to(Integer.valueOf(R.id.f378318b), 10035), TuplesKt.to(Integer.valueOf(R.id.f378218a), 10033), TuplesKt.to(Integer.valueOf(R.id.f3810192), 10041));
        MotiveBigBannerAreaIdMap = hashMapOf2;
        hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(R.id.v_2), 69), TuplesKt.to(Integer.valueOf(R.id.v_3), 70), TuplesKt.to(Integer.valueOf(R.id.v_1), 71), TuplesKt.to(Integer.valueOf(R.id.v9z), 72), TuplesKt.to(Integer.valueOf(R.id.v9x), 73), TuplesKt.to(Integer.valueOf(R.id.v9w), 73), TuplesKt.to(Integer.valueOf(R.id.v_5), 81), TuplesKt.to(Integer.valueOf(R.id.f378718f), 10044), TuplesKt.to(Integer.valueOf(R.id.f378818g), 10043), TuplesKt.to(Integer.valueOf(R.id.f379218k), 10045), TuplesKt.to(Integer.valueOf(R.id.f378918h), 10045), TuplesKt.to(Integer.valueOf(R.id.f379018i), 10045), TuplesKt.to(Integer.valueOf(R.id.f379118j), 10045));
        EndCardAreaIdMap = hashMapOf3;
        hashMapOf4 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(R.id.f38851a3), 10094), TuplesKt.to(Integer.valueOf(R.id.f38801_y), 10095), TuplesKt.to(Integer.valueOf(R.id.f38841a2), 10096), TuplesKt.to(Integer.valueOf(R.id.f38821a0), 10097), TuplesKt.to(Integer.valueOf(R.id.f38811_z), 10098));
        SpaceAreaIdMap = hashMapOf4;
    }

    a() {
    }

    @Nullable
    public final Integer a(@NotNull View view, boolean isBigBannerVisible) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        int id5 = view.getId();
        HashMap<Integer, Integer> hashMap = AreaIdMap;
        if (hashMap.containsKey(Integer.valueOf(id5))) {
            return hashMap.get(Integer.valueOf(id5));
        }
        if (id5 != R.id.f38721_q && id5 != R.id.f384419z) {
            if (id5 == R.id.f165345vm4) {
                if (isBigBannerVisible) {
                    i3 = 68;
                } else {
                    i3 = 53;
                }
            } else {
                i3 = Integer.MIN_VALUE;
            }
        } else if (af.U()) {
            i3 = 66;
        } else {
            i3 = 65;
        }
        return Integer.valueOf(i3);
    }

    @Nullable
    public final Integer b(@Nullable Integer viewId) {
        HashMap<Integer, Integer> hashMap = EndCardAreaIdMap;
        if (hashMap.containsKey(viewId)) {
            return hashMap.get(viewId);
        }
        return Integer.MIN_VALUE;
    }

    @Nullable
    public final Integer c(@Nullable Integer viewId) {
        HashMap<Integer, Integer> hashMap = MotiveBigBannerAreaIdMap;
        if (hashMap.containsKey(viewId)) {
            return hashMap.get(viewId);
        }
        return Integer.MIN_VALUE;
    }

    @Nullable
    public final Integer d(@Nullable Integer viewId) {
        HashMap<Integer, Integer> hashMap = SpaceAreaIdMap;
        if (hashMap.containsKey(viewId)) {
            return hashMap.get(viewId);
        }
        return Integer.MIN_VALUE;
    }
}
