package com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import r12.a;
import sz1.JoinTimeItem;
import sz1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "", "c", "", "id", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f234377a = new c();

    c() {
    }

    private final String b(int id5) {
        String string = BaseApplication.context.getString(id5);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(id)");
        return string;
    }

    @JvmStatic
    public static final boolean c(@NotNull final Activity activity, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        final IGuildSpeakableThresholdPermission f16 = d.f(guildId);
        int guildLimitType = f16.getGuildLimitType();
        if (guildLimitType != 2) {
            if (guildLimitType != 4) {
                return false;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(f234377a.b(R.string.f157271mg), Arrays.copyOf(new Object[]{JoinTimeItem.INSTANCE.b(f16.getGuildLimitTime())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ch.f1(format);
        } else {
            c cVar = f234377a;
            r12.a.a(activity, new a.C11105a(cVar.b(R.string.f157201m_), cVar.b(R.string.f157191m9), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.d(activity, f16, view);
                }
            })).b();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Activity activity, IGuildSpeakableThresholdPermission speakThresholdState, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(speakThresholdState, "$speakThresholdState");
        ch.i1(activity, speakThresholdState.getVerifyUrl());
        EventCollector.getInstance().onViewClicked(view);
    }
}
