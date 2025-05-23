package com.tencent.sqshow.zootopia.nativeui.view.customerface;

import android.content.Context;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014JE\u0010\u000f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bH\u0002J;\u0010\u0012\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00102!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/MakeFaceExitHelper;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Landroid/view/View;", "view", "", "type", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSaved", "", "backHandler", "b", "Landroid/content/Context;", "context", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MakeFaceExitHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final MakeFaceExitHelper f371595a = new MakeFaceExitHelper();

    MakeFaceExitHelper() {
    }

    public final void c(final com.tencent.sqshow.zootopia.nativeui.data.j channel, Context context, final Function1<? super Boolean, Unit> backHandler) {
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        boolean z16 = false;
        if (channel != null && (avatarFaceController = channel.getAvatarFaceController()) != null && avatarFaceController.f()) {
            z16 = true;
        }
        if (z16) {
            NativeUiDialogUtils.f371177a.n(channel, context, new Function2<View, Integer, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceExitHelper$handleExit$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                    invoke(view, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(View view, int i3) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    MakeFaceExitHelper.f371595a.b(com.tencent.sqshow.zootopia.nativeui.data.j.this, view, i3, backHandler);
                }
            });
        } else {
            backHandler.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(com.tencent.sqshow.zootopia.nativeui.data.j channel, View view, int type, Function1<? super Boolean, Unit> backHandler) {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        y94.a reporter2;
        ZplanViewReportHelper mReporter2;
        y94.a reporter3;
        ZplanViewReportHelper mReporter3;
        y94.a reporter4;
        ZplanViewReportHelper mReporter4;
        if (type == 1) {
            if (channel == null || (reporter = channel.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
                return;
            }
            mReporter.g(view, "em_zplan_exit_notice_save", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            return;
        }
        if (type == 2) {
            if (channel == null || (reporter2 = channel.getReporter()) == null || (mReporter2 = reporter2.getMReporter()) == null) {
                return;
            }
            mReporter2.g(view, "em_zplan_exit_notice_exit", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            return;
        }
        if (type == 3) {
            if (channel != null && (reporter3 = channel.getReporter()) != null && (mReporter3 = reporter3.getMReporter()) != null) {
                ZplanViewReportHelper.f(mReporter3, view, "em_zplan_exit_notice_save", null, 4, null);
            }
            backHandler.invoke(Boolean.TRUE);
            return;
        }
        if (type != 4) {
            return;
        }
        if (channel != null && (reporter4 = channel.getReporter()) != null && (mReporter4 = reporter4.getMReporter()) != null) {
            ZplanViewReportHelper.f(mReporter4, view, "em_zplan_exit_notice_exit", null, 4, null);
        }
        backHandler.invoke(Boolean.FALSE);
    }
}
