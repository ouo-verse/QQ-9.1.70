package com.tencent.state.template.fragment;

import android.content.Context;
import com.tencent.state.library.tag.IEditTagListener;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&JL\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/template/fragment/TemplateCommonOperateComponent;", "Lcom/tencent/state/template/fragment/TemplateBaseComponent;", "()V", "showEditDeskMateTagPanel", "", "context", "Landroid/content/Context;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "roomId", "", "tableId", "callback", "Lcom/tencent/state/library/tag/IEditTagListener;", "switchTable", "uin", "", "tableTagId", "fromFocusFragment", "", "Lcom/tencent/state/service/ResultCallback;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateCommonOperateComponent extends TemplateBaseComponent {
    public abstract void showEditDeskMateTagPanel(Context context, User user, long roomId, long tableId, IEditTagListener callback);

    public abstract void switchTable(Context context, String uin, long roomId, long tableId, String tableTagId, boolean fromFocusFragment, ResultCallback<User> callback);

    public static /* synthetic */ void showEditDeskMateTagPanel$default(TemplateCommonOperateComponent templateCommonOperateComponent, Context context, User user, long j3, long j16, IEditTagListener iEditTagListener, int i3, Object obj) {
        if (obj == null) {
            templateCommonOperateComponent.showEditDeskMateTagPanel(context, user, j3, j16, (i3 & 16) != 0 ? null : iEditTagListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEditDeskMateTagPanel");
    }

    public static /* synthetic */ void switchTable$default(TemplateCommonOperateComponent templateCommonOperateComponent, Context context, String str, long j3, long j16, String str2, boolean z16, ResultCallback resultCallback, int i3, Object obj) {
        if (obj == null) {
            templateCommonOperateComponent.switchTable(context, str, j3, j16, str2, z16, (i3 & 64) != 0 ? null : resultCallback);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchTable");
    }
}
