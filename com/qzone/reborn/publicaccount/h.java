package com.qzone.reborn.publicaccount;

import android.content.Context;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004R$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/publicaccount/h;", "", "Lmm/a;", "message", "", "a", "Landroid/content/Context;", "context", "messageItemType", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sMessageTypeList", "c", "()I", "messageViewTypeCount", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f58778a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<Integer> sMessageTypeList;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        sMessageTypeList = arrayList;
        arrayList.add(0);
        arrayList.add(10001);
    }

    h() {
    }

    public final QZoneBaseWidgetView<mm.a> b(Context context, int messageItemType) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (messageItemType == 10001) {
            return new QZonePublicAccountAdvItemView(context);
        }
        return new QZonePublicAccountItemView(context, messageItemType);
    }

    public final int c() {
        return sMessageTypeList.size();
    }

    public final int a(mm.a message) {
        if (message == null) {
            return 0;
        }
        if (message.e() == 0) {
            return message.c().size();
        }
        return message.e() + 10000;
    }
}
