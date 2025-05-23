package com.tencent.state.template.fragment;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.invite.ISelectFriendCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/state/template/fragment/TemplateShareComponent$doShare$2", "Lcom/tencent/state/square/invite/ISelectFriendCallback;", "onSelectFriend", "", "uin", "", "isTroop", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class TemplateShareComponent$doShare$2 implements ISelectFriendCallback {
    final /* synthetic */ int $from;
    final /* synthetic */ int $sceneType;
    final /* synthetic */ IVasBaseServiceProvider $serviceProvider;
    final /* synthetic */ TemplateShareComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemplateShareComponent$doShare$2(TemplateShareComponent templateShareComponent, IVasBaseServiceProvider iVasBaseServiceProvider, int i3, int i16) {
        this.this$0 = templateShareComponent;
        this.$serviceProvider = iVasBaseServiceProvider;
        this.$from = i3;
        this.$sceneType = i16;
    }

    @Override // com.tencent.state.square.invite.ISelectFriendCallback
    public void onSelectFriend(String uin, boolean isTroop) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(uin, "uin");
        IVasBaseServiceProvider iVasBaseServiceProvider = this.$serviceProvider;
        if (iVasBaseServiceProvider != null) {
            iVasBaseServiceProvider.deleteSelectFriendCallback(this);
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            final long longValue = longOrNull.longValue();
            this.this$0.getShareService().doShare(longValue, longValue, isTroop ? 1 : 0, new Function1<Boolean, Unit>() { // from class: com.tencent.state.template.fragment.TemplateShareComponent$doShare$2$onSelectFriend$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    QBaseActivity activity;
                    QBaseActivity activity2;
                    if (z16) {
                        SquareBaseKt.getSquareLog().i("TemplateShareComponent", "Share to " + longValue + " success");
                        activity2 = TemplateShareComponent$doShare$2.this.this$0.getActivity();
                        if (activity2 != null) {
                            Square.INSTANCE.getConfig().getCommonUtils().showToast(activity2, activity2.getString(R.string.xd9), 2);
                            return;
                        }
                        return;
                    }
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "TemplateShareComponent", "Share to " + longValue + " fail", null, 4, null);
                    activity = TemplateShareComponent$doShare$2.this.this$0.getActivity();
                    if (activity != null) {
                        Square.INSTANCE.getConfig().getCommonUtils().showToast(activity, activity.getString(R.string.xd8), 1);
                    }
                }
            });
            this.this$0.reportShareEvent(uin, isTroop, this.$from, this.$sceneType);
        }
    }
}
