package com.tencent.mobileqq.matchfriend.reborn.publish;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.matchfriend.reborn.activity.QQStrangerPublicFragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f245245a = new a();

    a() {
    }

    public final void a(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QQStrangerPublicFragmentActivity.INSTANCE.a(context, intent, QQStrangerSquarePublishFragment.class);
    }

    public static /* synthetic */ void b(a aVar, Context context, Intent intent, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            intent = new Intent();
        }
        aVar.a(context, intent);
    }
}
