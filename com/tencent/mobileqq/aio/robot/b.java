package com.tencent.mobileqq.aio.robot;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.ColorUtils;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0019\u001a\u00020\u000b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/b;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB;", "Lcom/tencent/mobileqq/aio/robot/RobotAIOMsgListVM;", "M3", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "T0", "", "moveType", "moveDistance", "", "totalDistance", "", "v3", "Landroid/content/Context;", "context", "Q2", "D0", "I", Constants.BASE_IN_PLUGIN_VERSION, "()I", "arrangeMode", "<init>", "()V", "E0", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends AIOMsgListVB {

    /* renamed from: D0, reason: from kotlin metadata */
    private final int arrangeMode = 2;

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB
    /* renamed from: D2, reason: from getter */
    public int getArrangeMode() {
        return this.arrangeMode;
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB, com.tencent.aio.api.list.j
    @NotNull
    /* renamed from: M3, reason: merged with bridge method [inline-methods] */
    public RobotAIOMsgListVM F0() {
        return new RobotAIOMsgListVM(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB
    public int Q2(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ColorUtils.setAlphaComponent(context.getColor(R.color.qui_common_brand_standard), 127);
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        View T0 = super.T0(createViewParams, childView, uiHelper);
        if (T0 instanceof ViewGroup) {
            viewGroup = (ViewGroup) T0;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setClipToPadding(false);
        }
        return T0;
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB
    protected void v3(int moveType, int moveDistance, float totalDistance) {
    }
}
