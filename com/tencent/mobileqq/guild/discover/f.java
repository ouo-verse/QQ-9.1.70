package com.tencent.mobileqq.guild.discover;

import android.content.Context;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.channel.joinchannel.h;
import com.tencent.mobileqq.guild.discover.f;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/f;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f216513b = "Guild.join.JoinGuildHelper";

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/f$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "joinParams", "", "needJumpToSuccessDialog", "jump2AIO", "Ljava/lang/Runnable;", "joinSuccess", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discover.f$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, Context context, JumpGuildParam jumpGuildParam, boolean z16, boolean z17, Runnable runnable, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z16 = true;
            }
            boolean z18 = z16;
            if ((i3 & 8) != 0) {
                z17 = false;
            }
            companion.b(context, jumpGuildParam, z18, z17, runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Context context, Runnable joinSuccess, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(joinSuccess, "$joinSuccess");
            QLog.d(f.f216513b, 1, "[joinGuild] getInnerHandlerErrorCode result = " + i3 + ", errMsg = " + str);
            if (!h.d(i3, iGProSecurityResult)) {
                QLog.d(f.f216513b, 1, "[joinGuild] not Success. result=" + i3 + " msg=" + str);
                ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).handleJoinGuildError(context, i3, str, iGProSecurityResult);
                return;
            }
            joinSuccess.run();
            QLog.d(f.f216513b, 1, "[joinGuild] Success");
        }

        @JvmStatic
        public final void b(@NotNull final Context context, @NotNull JumpGuildParam joinParams, boolean needJumpToSuccessDialog, boolean jump2AIO, @NotNull final Runnable joinSuccess) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(joinParams, "joinParams");
            Intrinsics.checkNotNullParameter(joinSuccess, "joinSuccess");
            JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
            jumpParam.d(needJumpToSuccessDialog);
            jumpParam.c(jump2AIO);
            Unit unit = Unit.INSTANCE;
            h.a(context, joinParams, jumpParam, f.f216513b, new bv() { // from class: com.tencent.mobileqq.guild.discover.e
                @Override // vh2.bv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    f.Companion.d(context, joinSuccess, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
        }

        Companion() {
        }
    }
}
