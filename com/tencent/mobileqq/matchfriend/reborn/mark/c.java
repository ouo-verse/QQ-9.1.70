package com.tencent.mobileqq.matchfriend.reborn.mark;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0000\u001a\f\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "", "d", "a", "e", "b", "Lcom/tencent/mobileqq/mutualmark/model/MutualMarkModel;", "g", "c", "", "f", "Lcom/tencent/aio/stranger/api/a;", h.F, "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {
    public static final String a(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        return com.tencent.mobileqq.matchfriend.reborn.mark.config.b.f245190a.b(qQStrangerInteractiveMarkModel.getResBaseUrl(), qQStrangerInteractiveMarkModel.subtype, qQStrangerInteractiveMarkModel.level);
    }

    public static final String b(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        return qQStrangerInteractiveMarkModel.getResBaseUrl() + "/icon/" + qQStrangerInteractiveMarkModel.subtype + "_{level}_{size}.png";
    }

    public static final String c(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        int i3 = ((int) qQStrangerInteractiveMarkModel.level) - 1;
        if (i3 >= 0 && i3 < qQStrangerInteractiveMarkModel.getMarkConfigList().size()) {
            return qQStrangerInteractiveMarkModel.getMarkConfigList().get(i3).a();
        }
        return "";
    }

    public static final String d(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        return com.tencent.mobileqq.matchfriend.reborn.mark.config.b.f245190a.d(qQStrangerInteractiveMarkModel.getResBaseUrl(), qQStrangerInteractiveMarkModel.subtype, qQStrangerInteractiveMarkModel.count);
    }

    public static final String e(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        return com.tencent.mobileqq.matchfriend.reborn.mark.config.b.f245190a.e(qQStrangerInteractiveMarkModel.getResBaseUrl(), qQStrangerInteractiveMarkModel.subtype, qQStrangerInteractiveMarkModel.level);
    }

    public static final boolean f(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        return qQStrangerInteractiveMarkModel.level == 1;
    }

    public static final MutualMarkModel g(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        MutualMarkModel mutualMarkModel = new MutualMarkModel();
        mutualMarkModel.F = 1;
        mutualMarkModel.f252159h = a(qQStrangerInteractiveMarkModel);
        mutualMarkModel.N = true;
        mutualMarkModel.H = qQStrangerInteractiveMarkModel.level;
        mutualMarkModel.L = (float) qQStrangerInteractiveMarkModel.count;
        mutualMarkModel.U = b(qQStrangerInteractiveMarkModel);
        ArrayList arrayList = new ArrayList();
        String str = "";
        int i3 = 0;
        for (Object obj : qQStrangerInteractiveMarkModel.getMarkConfigList()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.matchfriend.reborn.couple.model.a aVar = (com.tencent.mobileqq.matchfriend.reborn.couple.model.a) obj;
            MutualMarkModel.Graded graded = new MutualMarkModel.Graded();
            graded.f252168d = i16;
            graded.f252170f = aVar.b();
            graded.f252169e = aVar.a();
            graded.f252171h = aVar.c();
            arrayList.add(graded);
            if (qQStrangerInteractiveMarkModel.count >= aVar.b()) {
                str = aVar.a();
            }
            i3 = i16;
        }
        mutualMarkModel.Y = arrayList;
        mutualMarkModel.E = str;
        ArrayList arrayList2 = new ArrayList();
        MutualMarkModel.Button button = new MutualMarkModel.Button();
        button.f252163e = MobileQQ.sMobileQQ.getString(R.string.x0b);
        arrayList2.add(button);
        mutualMarkModel.Z = arrayList2;
        return mutualMarkModel;
    }

    public static final com.tencent.aio.stranger.api.a h(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        long j3 = qQStrangerInteractiveMarkModel.count;
        if (((((j3 > 1L ? 1 : (j3 == 1L ? 0 : -1)) == 0 || (j3 > 2L ? 1 : (j3 == 2L ? 0 : -1)) == 0) || (j3 > 3L ? 1 : (j3 == 3L ? 0 : -1)) == 0) || (j3 > 4L ? 1 : (j3 == 4L ? 0 : -1)) == 0) || j3 == 5) {
            return new com.tencent.aio.stranger.api.a(j3, qQStrangerInteractiveMarkModel.level, d(qQStrangerInteractiveMarkModel), qQStrangerInteractiveMarkModel);
        }
        return null;
    }
}
