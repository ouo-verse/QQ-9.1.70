package com.tencent.mobileqq.guild.safety;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmData;
import com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a&\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u001a(\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00002\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0002\u001a(\u0010\r\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "onExit", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "guildInfo", "Lkotlin/Function1;", "", "onResult", "j", "g", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ExitGuildUtilKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(IGProGuildInfo iGProGuildInfo, final Function1<? super Integer, Unit> function1) {
        if (iGProGuildInfo != null) {
            ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).destroyGuild(iGProGuildInfo.getGuildID(), new dv() { // from class: com.tencent.mobileqq.guild.safety.d
                @Override // wh2.dv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                    ExitGuildUtilKt.h(Function1.this, i3, str, iGProSecurityResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 onResult, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(onResult, "$onResult");
        if (i3 == 0) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.safety.f
                @Override // java.lang.Runnable
                public final void run() {
                    ExitGuildUtilKt.i();
                }
            }, 100L);
            onResult.invoke(Integer.valueOf(i3));
        } else {
            SecurityTipHelperKt.F(QBaseActivity.sTopActivity, i3, str, iGProSecurityResult, null, null, 48, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        ch.e1(2, BaseApplication.getContext().getString(R.string.f143140l_));
    }

    private static final void j(IGProGuildInfo iGProGuildInfo, final Function1<? super Integer, Unit> function1) {
        if (iGProGuildInfo != null) {
            ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).removeGuild(iGProGuildInfo.getGuildID(), new dv() { // from class: com.tencent.mobileqq.guild.safety.c
                @Override // wh2.dv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                    ExitGuildUtilKt.k(Function1.this, i3, str, iGProSecurityResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 onResult, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(onResult, "$onResult");
        if (i3 == 0) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.safety.e
                @Override // java.lang.Runnable
                public final void run() {
                    ExitGuildUtilKt.l();
                }
            }, 100L);
        } else {
            SecurityTipHelperKt.F(QBaseActivity.sTopActivity, i3, str, iGProSecurityResult, BaseApplication.getContext().getString(R.string.f143580mg), null, 32, null);
        }
        onResult.invoke(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        ch.e1(2, BaseApplication.getContext().getString(R.string.f143590mh));
    }

    public static final void m(@NotNull final IGProGuildInfo mGuildInfo, @NotNull Context context, @NotNull final Function0<Unit> onExit) {
        final boolean z16;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onExit, "onExit");
        if (mGuildInfo.getUserType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (context instanceof FragmentActivity)) {
            GuildAgainConfirmData guildAgainConfirmData = new GuildAgainConfirmData("\u89e3\u6563\u201c" + mGuildInfo.getGuildName() + "\u201d", "\u89e3\u6563\u540e\u5c06\u79fb\u9664\u6240\u6709\u6210\u5458\u3001\u6e05\u7a7a\u76f8\u5173\u5185\u5bb9\u4e0e\u8bbe\u7f6e\u3001\u89e3\u9664\u5e7f\u544a\u7b7e\u7ea6\u72b6\u6001\uff0c\u4e14\u65e0\u6cd5\u6062\u590d\u3002\u8bf7\u8c28\u614e\u64cd\u4f5c\uff01", "\u89e3\u6563\u9891\u9053", "\u89e3\u6563\u5e76\u6e05\u7a7a\u9891\u9053", 1, "\u53d6\u6d88");
            GuildAgainConfirmDialog.Companion companion = GuildAgainConfirmDialog.INSTANCE;
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.supportFragmentManager");
            companion.a(supportFragmentManager, guildAgainConfirmData, new GuildAgainConfirmDialog.b() { // from class: com.tencent.mobileqq.guild.safety.ExitGuildUtilKt$handleGuildExitClick$2
                @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
                public void a(@NotNull View view) {
                    GuildAgainConfirmDialog.b.a.c(this, view);
                }

                @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
                public void b(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    IGProGuildInfo iGProGuildInfo = IGProGuildInfo.this;
                    final Function0<Unit> function0 = onExit;
                    ExitGuildUtilKt.g(iGProGuildInfo, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.safety.ExitGuildUtilKt$handleGuildExitClick$2$onConfirmClick$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i17) {
                            function0.invoke();
                        }
                    });
                }

                @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
                public void c(@NotNull View view, @NotNull View view2) {
                    GuildAgainConfirmDialog.b.a.b(this, view, view2);
                }

                @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
                public void d(@NotNull View view) {
                    GuildAgainConfirmDialog.b.a.a(this, view);
                }
            });
            return;
        }
        if (z16) {
            i3 = R.string.f143150la;
        } else {
            i3 = R.string.f143600mi;
        }
        if (z16) {
            i16 = R.string.f143310lq;
        } else {
            i16 = R.string.f142540jn;
        }
        final ActionSheet create = ActionSheet.create(context);
        create.setMainTitle(i3);
        create.addButton(i16, 3, R.id.wzx);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.safety.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i17) {
                ExitGuildUtilKt.n(z16, mGuildInfo, create, onExit, view, i17);
            }
        });
        create.addCancelButton(context.getResources().getString(R.string.f140850f3));
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(boolean z16, IGProGuildInfo mGuildInfo, ActionSheet actionSheet, final Function0 onExit, View view, int i3) {
        boolean z17;
        Intrinsics.checkNotNullParameter(mGuildInfo, "$mGuildInfo");
        Intrinsics.checkNotNullParameter(onExit, "$onExit");
        if (i3 == R.id.wzx) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (z16) {
                g(mGuildInfo, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.safety.ExitGuildUtilKt$handleGuildExitClick$3$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i16) {
                        onExit.invoke();
                    }
                });
            } else {
                j(mGuildInfo, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.safety.ExitGuildUtilKt$handleGuildExitClick$3$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i16) {
                        onExit.invoke();
                    }
                });
            }
            actionSheet.dismiss();
        }
    }
}
