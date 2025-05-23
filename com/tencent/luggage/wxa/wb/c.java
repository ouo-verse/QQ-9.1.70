package com.tencent.luggage.wxa.wb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a */
    public static final c f144167a = new c();

    public static /* synthetic */ View a(c cVar, Context context, ArrayList arrayList, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        return cVar.a(context, arrayList, i3);
    }

    public final View a(Context context, ArrayList keyWordList, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyWordList, "keyWordList");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int i16 = 0;
        for (Object obj : keyWordList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            linearLayout.addView(f144167a.a(context, i16, keyWordList.size(), (String) pair.getFirst(), (String) pair.getSecond(), i3));
            i16 = i17;
        }
        return linearLayout;
    }

    public final View a(Context context, int i3, int i16, String str, String str2, int i17) {
        View templateItem = LayoutInflater.from(context).inflate(R.layout.hrg, (ViewGroup) null, false);
        templateItem.setContentDescription(str + TokenParser.SP + str2);
        ((TextView) templateItem.findViewById(R.id.ybd)).setText(str);
        ((TextView) templateItem.findViewById(R.id.f167085kn2)).setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (i3 != i16 - 1) {
            layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.bkj);
        }
        if (i3 == 0) {
            layoutParams.topMargin = i17;
        }
        templateItem.setLayoutParams(layoutParams);
        Intrinsics.checkNotNullExpressionValue(templateItem, "templateItem");
        return templateItem;
    }
}
