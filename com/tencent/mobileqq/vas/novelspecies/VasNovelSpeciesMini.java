package com.tencent.mobileqq.vas.novelspecies;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/novelspecies/VasNovelSpeciesMini;", "Lcom/tencent/mobileqq/vas/novelspecies/VasNovelSpeciesBase;", "Landroid/content/Context;", "context", "", "from", "", "e", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasNovelSpeciesMini extends VasNovelSpeciesBase {
    @Override // com.tencent.mobileqq.vas.novelspecies.VasNovelSpeciesBase
    public void e(@NotNull Context context, @NotNull String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("VasNovelSpeciesMini", 1, "[updateAppWidget] from:" + from + ",process:" + MobileQQ.sMobileQQ.getQQProcessName());
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (appWidgetManager == null) {
            return;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.f169174i35);
        f(remoteViews, context, false);
        appWidgetManager.updateAppWidget(new ComponentName(context, (Class<?>) VasNovelSpeciesMini.class), remoteViews);
    }
}
