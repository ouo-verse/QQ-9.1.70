package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.LevelRoleViewAndSelectParam;
import com.tencent.mobileqq.guild.rolegroup.levelrole.PageLayoutType;
import com.tencent.mobileqq.guild.util.ch;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/ao;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "context", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ao extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@Nullable AbsIpcMethod.a context, @Nullable String method, @NotNull Object... arguments) {
        Unit unit;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Context context2 = QBaseActivity.sTopActivity;
        if (context2 == null) {
            context2 = ch.i();
        }
        Object obj = arguments[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        if (context2 != null) {
            GuildLevelRoleViewAndSelectFragment.Companion companion = GuildLevelRoleViewAndSelectFragment.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f154741fm);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_list_level_role)");
            companion.b(context2, new LevelRoleViewAndSelectParam(str, qqStr, PageLayoutType.VIEW_LEVEL_ROLES_ENTRANCE, null, null, false, 0, null, null, 504, null));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            EIPCResult createResult = EIPCResult.createResult(-102, BundleKt.bundleOf(new Pair[0]));
            Intrinsics.checkNotNullExpressionValue(createResult, "createResult(EIPCResult.CODE_ERR, bundleOf())");
            return createResult;
        }
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(new Bundle());
        Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(Bundle())");
        return createSuccessResult;
    }
}
