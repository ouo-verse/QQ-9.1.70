package com.tencent.guild.aio.help;

import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.guild.api.IQQGuildVisitorApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/help/w;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "g", "e", "c", "a", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi$a;", "Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi$a;", "visitorTimer", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class w implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQGuildVisitorApi.a visitorTimer;

    private final void a() {
        IQQGuildVisitorApi.a aVar = this.visitorTimer;
        if (aVar != null) {
            aVar.a();
        }
        this.visitorTimer = null;
    }

    private final void b() {
        String str;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        if (bVar.a().g().l().getBoolean("needHideGuestStatus", false)) {
            return;
        }
        a();
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar3 = null;
        }
        AIOParam g16 = bVar3.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        com.tencent.aio.main.businesshelper.b bVar4 = this.param;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar4 = null;
        }
        AIOParam g17 = bVar4.a().g();
        Intrinsics.checkNotNullExpressionValue(g17, "param.aioContext.aioParam");
        if (iGuildChannelApi.isSelfGuest(b16, com.tencent.guild.aio.util.a.g(g17))) {
            com.tencent.aio.main.businesshelper.b bVar5 = this.param;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar5 = null;
            }
            JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) bVar5.a().g().l().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
            com.tencent.aio.main.businesshelper.b bVar6 = this.param;
            if (bVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar6 = null;
            }
            if (joinInfoParam != null) {
                str = joinInfoParam.getJoinSignature();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                com.tencent.aio.main.businesshelper.b bVar7 = this.param;
                if (bVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar7 = null;
                }
                AIOParam g18 = bVar7.a().g();
                Intrinsics.checkNotNullExpressionValue(g18, "param.aioContext.aioParam");
                if (!TextUtils.isEmpty(com.tencent.guild.aio.util.a.g(g18))) {
                    com.tencent.aio.main.businesshelper.b bVar8 = this.param;
                    if (bVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                        bVar8 = null;
                    }
                    AIOParam g19 = bVar8.a().g();
                    Intrinsics.checkNotNullExpressionValue(g19, "param.aioContext.aioParam");
                    String g26 = com.tencent.guild.aio.util.a.g(g19);
                    com.tencent.aio.main.businesshelper.b bVar9 = this.param;
                    if (bVar9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                    } else {
                        bVar2 = bVar9;
                    }
                    AIOParam g27 = bVar2.a().g();
                    Intrinsics.checkNotNullExpressionValue(g27, "param.aioContext.aioParam");
                    JumpGuildParam jumpGuildParam = new JumpGuildParam(g26, com.tencent.guild.aio.util.a.b(g27), joinInfoParam);
                    IQQGuildVisitorApi iQQGuildVisitorApi = (IQQGuildVisitorApi) QRoute.api(IQQGuildVisitorApi.class);
                    String simpleName = w.class.getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
                    this.visitorTimer = iQQGuildVisitorApi.getVisitorJoinGuildTimerTaskClass(simpleName, jumpGuildParam);
                    return;
                }
            }
            String tag = getTag();
            Object[] objArr = new Object[2];
            objArr[0] = "join Guild arg error! guildId = ";
            com.tencent.aio.main.businesshelper.b bVar10 = this.param;
            if (bVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                bVar2 = bVar10;
            }
            AIOParam g28 = bVar2.a().g();
            Intrinsics.checkNotNullExpressionValue(g28, "param.aioContext.aioParam");
            objArr[1] = com.tencent.guild.aio.util.a.g(g28);
            QLog.e(tag, 1, objArr);
        }
    }

    private final void c() {
        a();
    }

    private final void e() {
        IQQGuildVisitorApi.a aVar = this.visitorTimer;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void g() {
        IQQGuildVisitorApi.a aVar = this.visitorTimer;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 23;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        String simpleName = w.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 3) {
                if (state != 8) {
                    if (state == 12) {
                        c();
                        return;
                    }
                    return;
                }
                e();
                return;
            }
            g();
            return;
        }
        b();
    }
}
