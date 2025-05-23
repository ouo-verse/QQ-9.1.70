package com.tencent.state.library.components;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.library.tag.IEditTagListener;
import com.tencent.state.library.tag.LibraryEditDeskMateTagPanel;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasLibraryRoomService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import com.tencent.state.template.event.RefreshDeskMateTagEvent;
import com.tencent.state.template.event.SwitchTableEvent;
import com.tencent.state.template.fragment.TemplateCommonOperateComponent;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016JJ\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/library/components/LibraryGroupOperateComponent;", "Lcom/tencent/state/template/fragment/TemplateCommonOperateComponent;", "()V", "showEditDeskMateTagPanel", "", "context", "Landroid/content/Context;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "roomId", "", "tableId", "callback", "Lcom/tencent/state/library/tag/IEditTagListener;", "switchTable", "uin", "", "tableTagId", "fromFocusFragment", "", "Lcom/tencent/state/service/ResultCallback;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryGroupOperateComponent extends TemplateCommonOperateComponent {
    private static final String TAG = "LibraryCommonOperateComponent";

    @Override // com.tencent.state.template.fragment.TemplateCommonOperateComponent
    public void switchTable(final Context context, final String uin, final long roomId, final long tableId, String tableTagId, final boolean fromFocusFragment, final ResultCallback<User> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        FocusDialogTips.showSwitchTableDialog$default(FocusDialogTips.INSTANCE, context, new Function0<Unit>() { // from class: com.tencent.state.library.components.LibraryGroupOperateComponent$switchTable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VasLibraryRoomService.INSTANCE.switchTable(uin, roomId, tableId, null, new ResultCallback<User>() { // from class: com.tencent.state.library.components.LibraryGroupOperateComponent$switchTable$1.1
                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int i3, String str, String str2) {
                        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int error, String message) {
                        SquareBaseKt.getSquareLog().d("LibraryCommonOperateComponent", "switchTable failed, " + error + ", " + message);
                        ResultCallback resultCallback = callback;
                        if (resultCallback != null) {
                            resultCallback.onResultFailure(error, message);
                        }
                        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                        Context context2 = context;
                        ICommonUtils.DefaultImpls.showToast$default(squareCommon, context2, context2.getString(R.string.xhg), 0, 4, (Object) null);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultSuccess(User result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        SquareBaseKt.getSquareLog().d("LibraryCommonOperateComponent", "switchTable success, " + result.getInfo());
                        ResultCallback resultCallback = callback;
                        if (resultCallback != null) {
                            resultCallback.onResultSuccess(result);
                        }
                        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                        LibraryGroupOperateComponent$switchTable$1 libraryGroupOperateComponent$switchTable$1 = LibraryGroupOperateComponent$switchTable$1.this;
                        simpleEventBus.dispatchEvent(new SwitchTableEvent(result, roomId, tableId, fromFocusFragment));
                    }
                });
            }
        }, null, 4, null);
    }

    @Override // com.tencent.state.template.fragment.TemplateCommonOperateComponent
    public void showEditDeskMateTagPanel(final Context context, final User user, long roomId, long tableId, final IEditTagListener callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(user, "user");
        new LibraryEditDeskMateTagPanel(context, user.getUin(), roomId, tableId, new IEditTagListener() { // from class: com.tencent.state.library.components.LibraryGroupOperateComponent$showEditDeskMateTagPanel$1
            @Override // com.tencent.state.library.tag.IEditTagListener
            public void onEditTagFailed(int errCode, String errMsg) {
                boolean isBlank;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                SquareBaseKt.getSquareLog().d("LibraryCommonOperateComponent", "onEditTagFailed, " + errCode + ", " + errMsg);
                IEditTagListener iEditTagListener = IEditTagListener.this;
                if (iEditTagListener != null) {
                    iEditTagListener.onEditTagFailed(errCode, errMsg);
                }
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                Context context2 = context;
                isBlank = StringsKt__StringsJVMKt.isBlank(errMsg);
                if (isBlank) {
                    errMsg = context.getString(R.string.xde);
                    Intrinsics.checkNotNullExpressionValue(errMsg, "context.getString(R.stri\u2026are_troop_error_msg_tips)");
                }
                ICommonUtils.DefaultImpls.showToast$default(squareCommon, context2, errMsg, 0, 4, (Object) null);
            }

            @Override // com.tencent.state.library.tag.IEditTagListener
            public void onEditTagSuccess(String uin, CommonTagInfo deskMateTag) {
                Intrinsics.checkNotNullParameter(uin, "uin");
                Intrinsics.checkNotNullParameter(deskMateTag, "deskMateTag");
                SquareBaseKt.getSquareLog().d("LibraryCommonOperateComponent", "onEditTagSuccess, " + deskMateTag.getText());
                IEditTagListener iEditTagListener = IEditTagListener.this;
                if (iEditTagListener != null) {
                    iEditTagListener.onEditTagSuccess(uin, deskMateTag);
                }
                if (!Intrinsics.areEqual(user.getUin(), uin)) {
                    return;
                }
                SitDownInfo sitDown = user.getSitDown();
                if (sitDown != null) {
                    sitDown.setSubTag(deskMateTag);
                }
                SimpleEventBus.getInstance().dispatchEvent(new RefreshDeskMateTagEvent(uin, deskMateTag));
            }
        }).show();
    }
}
