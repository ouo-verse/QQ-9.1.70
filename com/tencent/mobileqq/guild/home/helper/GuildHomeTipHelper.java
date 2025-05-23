package com.tencent.mobileqq.guild.home.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u000b2\u00020\u0001:\u0001\rB'\u0012\u0006\u0010#\u001a\u00020\u0013\u0012\u0006\u0010$\u001a\u00020\u0018\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\"\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00180\u00180\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u001b\u0010\u001f\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/home/helper/GuildHomeTipHelper;", "", "Ljava/lang/Runnable;", tl.h.F, "", "showText", "j", "", "pageIn", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "p", "a", "Ljava/lang/String;", "guildId", "b", "dialogTips", "Lmqq/util/WeakReference;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "c", "Lmqq/util/WeakReference;", "viewWeakRef", "Landroid/app/Activity;", "d", "activityWeakRef", "e", "Lkotlin/Lazy;", "o", "()Ljava/lang/Runnable;", "checkShowTipTask", "f", "Ljava/lang/Runnable;", "showTextDialogTask", "view", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeTipHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String dialogTips;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<View> viewWeakRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Activity> activityWeakRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy checkShowTipTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable showTextDialogTask;

    public GuildHomeTipHelper(@NotNull View view, @NotNull Activity activity, @NotNull String guildId, @NotNull String dialogTips) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(dialogTips, "dialogTips");
        this.guildId = guildId;
        this.dialogTips = dialogTips;
        this.viewWeakRef = new WeakReference<>(view);
        this.activityWeakRef = new WeakReference<>(activity);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Runnable>() { // from class: com.tencent.mobileqq.guild.home.helper.GuildHomeTipHelper$checkShowTipTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Runnable invoke() {
                Runnable h16;
                h16 = GuildHomeTipHelper.this.h();
                return h16;
            }
        });
        this.checkShowTipTask = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable h() {
        return new Runnable() { // from class: com.tencent.mobileqq.guild.home.helper.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeTipHelper.i(GuildHomeTipHelper.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildHomeTipHelper this$0) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.activityWeakRef.get() != null) {
            Activity activity = this$0.activityWeakRef.get();
            boolean z17 = true;
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String str = this$0.dialogTips;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z17 = false;
                    }
                }
                if (z17) {
                    return;
                }
                this$0.showTextDialogTask = this$0.j(str);
                View view = this$0.viewWeakRef.get();
                if (view != null) {
                    view.postDelayed(this$0.showTextDialogTask, 250L);
                }
            }
        }
    }

    private final Runnable j(final String showText) {
        return new Runnable() { // from class: com.tencent.mobileqq.guild.home.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeTipHelper.k(GuildHomeTipHelper.this, showText);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final GuildHomeTipHelper this$0, String showText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(showText, "$showText");
        Activity activity = this$0.activityWeakRef.get();
        if (activity != null && !activity.isFinishing()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 0, showText, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.helper.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildHomeTipHelper.l(GuildHomeTipHelper.this, dialogInterface, i3);
                }
            }, null);
            createCustomDialog.setTitleMutiLine();
            createCustomDialog.adjustTitle();
            createCustomDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.guild.home.helper.d
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    GuildHomeTipHelper.m(GuildHomeTipHelper.this, dialogInterface);
                }
            });
            createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.home.helper.e
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GuildHomeTipHelper.n(GuildHomeTipHelper.this, dialogInterface);
                }
            });
            createCustomDialog.show();
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("createTextDialogTask activity is finishing");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.NewHome.GuildHomeTipHelper", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GuildHomeTipHelper this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildHomeTipHelper this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildHomeTipHelper this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q(false);
    }

    private final Runnable o() {
        return (Runnable) this.checkShowTipTask.getValue();
    }

    private final void q(boolean pageIn) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_sgrp_sub_channel_not_seen_popup");
        hashMap.put("sgrp_channel_id", this.guildId);
        if (pageIn) {
            str = "pgin";
        } else {
            str = "pgout";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    public final void g() {
        View view = this.viewWeakRef.get();
        if (view != null) {
            view.postDelayed(o(), 250L);
        }
    }

    public final void p() {
        View view;
        View view2 = this.viewWeakRef.get();
        if (view2 != null) {
            view2.removeCallbacks(o());
        }
        Runnable runnable = this.showTextDialogTask;
        if (runnable != null && (view = this.viewWeakRef.get()) != null) {
            view.removeCallbacks(runnable);
        }
    }
}
