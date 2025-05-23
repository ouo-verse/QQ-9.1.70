package oc3;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mc3.InsExeExtParam;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J5\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J5\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u000f\u0010\rJ-\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0017"}, d2 = {"Loc3/i;", "Loc3/a;", "Lmc3/a;", "extParam", "Lkc3/a;", "judgeParams", "Lxu4/a;", "firstIns", "", "j", "", "remainIns", "r", "(Lmc3/a;[Lxu4/a;Lkc3/a;Lxu4/a;)V", "l", "o", "instructions", "a", "(Lmc3/a;Lkc3/a;[Lxu4/a;)V", "", "i", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends a {
    private final void j(final InsExeExtParam extParam, final GameJudgeParams judgeParams, final xu4.a firstIns) {
        if (judgeParams.getJudgeNotifier().a(1L, firstIns)) {
            QLog.i("Minors_LoginInstructionsExecutor_", 1, "handleLogOutIns firstIns:" + mc3.b.a(firstIns) + " handle by " + judgeParams.getJudgeNotifier());
            return;
        }
        r.f422495a.b(judgeParams.getActivityContext(), "\u6e29\u99a8\u63d0\u793a", "\u4e3a\u6839\u636e\u56fd\u5bb6\u9632\u6c89\u8ff7\u901a\u77e5\u7684\u76f8\u5173\u8981\u6c42\u3001\u8282\u5047\u65e5\u5b89\u6392\u4ee5\u53ca\u817e\u8baf\u6700\u65b0\u5f3a\u5316\u7684\u9632\u6c89\u8ff7\u7b56\u7565\uff0c\u7531\u4e8e\u4f60\u662f\u672a\u6210\u5e74\u4eba\uff0c\u5f53\u524d\u4e0d\u80fd\u7ee7\u7eed\u4f7f\u7528\u3002", "", null, "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: oc3.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                i.k(GameJudgeParams.this, this, extParam, firstIns, dialogInterface, i3);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GameJudgeParams judgeParams, i this$0, InsExeExtParam extParam, xu4.a firstIns, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(judgeParams, "$judgeParams");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extParam, "$extParam");
        Intrinsics.checkNotNullParameter(firstIns, "$firstIns");
        QLog.i("Minors_LoginInstructionsExecutor_", 4, " minorsProtectionSvr.LOGOUT dialog click");
        judgeParams.getJudgeNotifier().e(judgeParams.getMapId(), 1L, "FORCE_LOGOUT");
        this$0.b(extParam, firstIns, judgeParams);
    }

    private final void l(InsExeExtParam extParam, final GameJudgeParams judgeParams, final xu4.a firstIns) {
        String str;
        String str2;
        boolean z16 = true;
        if (judgeParams.getJudgeNotifier().a(1L, firstIns)) {
            QLog.i("Minors_LoginInstructionsExecutor_", 1, "handleModalOpeUrlIns firstIns:" + mc3.b.a(firstIns) + " handle by " + judgeParams.getJudgeNotifier());
            return;
        }
        r rVar = r.f422495a;
        Activity activityContext = judgeParams.getActivityContext();
        String str3 = firstIns.f448706b;
        if (str3 == null || str3.length() == 0) {
            str = "\u3010\u63d0\u793a\u3011";
        } else {
            str = firstIns.f448706b;
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (firstIns.title.isNul\u2026stIns.title\n            }");
        String str4 = firstIns.f448707c;
        if (str4 != null && str4.length() != 0) {
            z16 = false;
        }
        if (z16) {
            str2 = "\u4e3a\u5475\u62a4\u672a\u6210\u5e74\u4eba\u5065\u5eb7\u6210\u957f\uff0cQQ\u7279\u63a8\u51fa\u9752\u5c11\u5e74\u5b88\u62a4\u6a21\u5f0f\uff0c\u8bf7\u5148\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1\u3002";
        } else {
            str2 = firstIns.f448707c;
        }
        String str5 = str2;
        Intrinsics.checkNotNullExpressionValue(str5, "if (firstIns.msg.isNullO\u2026irstIns.msg\n            }");
        rVar.b(activityContext, str, str5, "\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: oc3.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                i.m(GameJudgeParams.this, dialogInterface, i3);
            }
        }, "\u5b9e\u540d\u8ba4\u8bc1", new DialogInterface.OnClickListener() { // from class: oc3.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                i.n(GameJudgeParams.this, firstIns, dialogInterface, i3);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GameJudgeParams judgeParams, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(judgeParams, "$judgeParams");
        QLog.i("Minors_LoginInstructionsExecutor_", 4, " minorsProtectionSvr.OPENURL dialog click");
        judgeParams.getJudgeNotifier().e(judgeParams.getMapId(), 2L, "MODAL_DIALOG_CANCEL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GameJudgeParams judgeParams, xu4.a firstIns, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(judgeParams, "$judgeParams");
        Intrinsics.checkNotNullParameter(firstIns, "$firstIns");
        QLog.i("Minors_LoginInstructionsExecutor_", 4, " minorsProtectionSvr.OPENURL dialog click");
        Intent intent = new Intent(judgeParams.getActivityContext(), (Class<?>) QQBrowserActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("url", firstIns.f448708d);
        judgeParams.getActivityContext().startActivity(intent);
        lc3.a judgeNotifier = judgeParams.getJudgeNotifier();
        int mapId = judgeParams.getMapId();
        String str = firstIns.f448708d;
        Intrinsics.checkNotNullExpressionValue(str, "firstIns.url");
        judgeNotifier.d(1L, mapId, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(i this$0, InsExeExtParam extParam, GameJudgeParams judgeParams, xu4.a[] remainIns, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extParam, "$extParam");
        Intrinsics.checkNotNullParameter(judgeParams, "$judgeParams");
        Intrinsics.checkNotNullParameter(remainIns, "$remainIns");
        QLog.i("Minors_LoginInstructionsExecutor_", 4, " minorsProtectionSvr.OPENURL dialog click");
        this$0.a(extParam, judgeParams, remainIns);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GameJudgeParams judgeParams, xu4.a firstIns, i this$0, InsExeExtParam extParam, xu4.a[] remainIns, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(judgeParams, "$judgeParams");
        Intrinsics.checkNotNullParameter(firstIns, "$firstIns");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extParam, "$extParam");
        Intrinsics.checkNotNullParameter(remainIns, "$remainIns");
        QLog.i("Minors_LoginInstructionsExecutor_", 4, " minorsProtectionSvr.OPENURL dialog click");
        Intent intent = new Intent(judgeParams.getActivityContext(), (Class<?>) QQBrowserActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("url", firstIns.f448708d);
        judgeParams.getActivityContext().startActivity(intent);
        lc3.a judgeNotifier = judgeParams.getJudgeNotifier();
        int mapId = judgeParams.getMapId();
        String str = firstIns.f448708d;
        Intrinsics.checkNotNullExpressionValue(str, "firstIns.url");
        judgeNotifier.d(1L, mapId, str);
        this$0.a(extParam, judgeParams, remainIns);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(i this$0, InsExeExtParam extParam, GameJudgeParams judgeParams, xu4.a[] remainIns, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extParam, "$extParam");
        Intrinsics.checkNotNullParameter(judgeParams, "$judgeParams");
        Intrinsics.checkNotNullParameter(remainIns, "$remainIns");
        QLog.i("Minors_LoginInstructionsExecutor_", 4, " minorsProtectionSvr.TIPS dialog click");
        this$0.a(extParam, judgeParams, remainIns);
    }

    @Override // oc3.a
    public void a(InsExeExtParam extParam, GameJudgeParams judgeParams, xu4.a[] instructions) {
        xu4.a[] aVarArr;
        IntRange until;
        Object[] sliceArray;
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        Intrinsics.checkNotNullParameter(judgeParams, "judgeParams");
        Intrinsics.checkNotNullParameter(instructions, "instructions");
        if (QLog.isColorLevel()) {
            QLog.i("Minors_LoginInstructionsExecutor_", 2, "executeLoginInstructions size:" + instructions.length);
        }
        if (instructions.length == 0) {
            return;
        }
        xu4.a aVar = instructions[0];
        if (instructions.length > 1) {
            until = RangesKt___RangesKt.until(1, instructions.length);
            sliceArray = ArraysKt___ArraysKt.sliceArray(instructions, until);
            aVarArr = (xu4.a[]) sliceArray;
        } else {
            aVarArr = new xu4.a[0];
        }
        QLog.i("Minors_LoginInstructionsExecutor_", 1, "executeLoginInstructions firstIns:" + mc3.b.a(aVar));
        int i3 = aVar.f448705a;
        if (i3 == 1) {
            r(extParam, aVarArr, judgeParams, aVar);
            return;
        }
        if (i3 == 2) {
            j(extParam, judgeParams, aVar);
            return;
        }
        if (i3 != 3) {
            a(extParam, judgeParams, aVarArr);
        } else if (aVar.f448709e == 1) {
            l(extParam, judgeParams, aVar);
        } else {
            o(extParam, aVarArr, judgeParams, aVar);
        }
    }

    public long i() {
        return 1L;
    }

    private final void o(final InsExeExtParam extParam, final xu4.a[] remainIns, final GameJudgeParams judgeParams, final xu4.a firstIns) {
        if (remainIns.length == 0) {
            judgeParams.getJudgeNotifier().c(judgeParams);
        }
        if (judgeParams.getJudgeNotifier().b(1L, firstIns)) {
            QLog.i("Minors_LoginInstructionsExecutor_", 1, "handleNormalOpenUrlIns firstIns:" + mc3.b.a(firstIns) + " handle by " + judgeParams.getJudgeNotifier());
            a(extParam, judgeParams, remainIns);
            return;
        }
        r rVar = r.f422495a;
        Activity activityContext = judgeParams.getActivityContext();
        String str = firstIns.f448706b;
        Intrinsics.checkNotNullExpressionValue(str, "firstIns.title");
        String str2 = firstIns.f448707c;
        Intrinsics.checkNotNullExpressionValue(str2, "firstIns.msg");
        rVar.b(activityContext, str, str2, (r21 & 8) != 0 ? "" : "\u53d6\u6d88", (r21 & 16) != 0 ? null : new DialogInterface.OnClickListener() { // from class: oc3.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                i.p(i.this, extParam, judgeParams, remainIns, dialogInterface, i3);
            }
        }, (r21 & 32) != 0 ? "" : "\u53bb\u770b\u770b", (r21 & 64) != 0 ? null : new DialogInterface.OnClickListener() { // from class: oc3.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                i.q(GameJudgeParams.this, firstIns, this, extParam, remainIns, dialogInterface, i3);
            }
        }, (r21 & 128) != 0);
    }

    private final void r(final InsExeExtParam extParam, final xu4.a[] remainIns, final GameJudgeParams judgeParams, xu4.a firstIns) {
        if (remainIns.length == 0) {
            judgeParams.getJudgeNotifier().c(judgeParams);
        }
        if (judgeParams.getJudgeNotifier().b(1L, firstIns)) {
            QLog.i("Minors_LoginInstructionsExecutor_", 1, "handleNormalTipsIns firstIns:" + mc3.b.a(firstIns) + " handle by " + judgeParams.getJudgeNotifier());
            a(extParam, judgeParams, remainIns);
            return;
        }
        r rVar = r.f422495a;
        Activity activityContext = judgeParams.getActivityContext();
        String str = firstIns.f448706b;
        Intrinsics.checkNotNullExpressionValue(str, "firstIns.title");
        String str2 = firstIns.f448707c;
        Intrinsics.checkNotNullExpressionValue(str2, "firstIns.msg");
        rVar.b(activityContext, str, str2, (r21 & 8) != 0 ? "" : "", (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? "" : "\u6211\u77e5\u9053\u4e86", (r21 & 64) != 0 ? null : new DialogInterface.OnClickListener() { // from class: oc3.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                i.s(i.this, extParam, judgeParams, remainIns, dialogInterface, i3);
            }
        }, (r21 & 128) != 0);
    }
}
