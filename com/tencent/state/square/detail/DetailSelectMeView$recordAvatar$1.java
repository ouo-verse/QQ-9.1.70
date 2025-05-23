package com.tencent.state.square.detail;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.RecordRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/state/square/detail/DetailSelectMeView$recordAvatar$1", "Lcom/tencent/state/square/resource/IResourceCallback;", "onRecordError", "", "type", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/RecordRequest;", "errorCode", "onRecordStart", "resource", "Lcom/tencent/state/square/data/Resource;", "isStarted", "", "onRecordSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailSelectMeView$recordAvatar$1 implements IResourceCallback {
    final /* synthetic */ boolean $isBuyTheSame;
    final /* synthetic */ Function3 $onRecordStart;
    final /* synthetic */ OnlineStatus $status;
    final /* synthetic */ DetailSelectMeView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetailSelectMeView$recordAvatar$1(DetailSelectMeView detailSelectMeView, Function3 function3, OnlineStatus onlineStatus, boolean z16) {
        this.this$0 = detailSelectMeView;
        this.$onRecordStart = function3;
        this.$status = onlineStatus;
        this.$isBuyTheSame = z16;
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onFirstFrame() {
        IResourceCallback.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayEnd() {
        IResourceCallback.DefaultImpls.onPlayEnd(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayError(int i3) {
        IResourceCallback.DefaultImpls.onPlayError(this, i3);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayStart() {
        IResourceCallback.DefaultImpls.onPlayStart(this);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordError(final int type, final RecordRequest request, final int errorCode) {
        int statusId;
        Intrinsics.checkNotNullParameter(request, "request");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRecordError ");
        Resource resource = request.getResource();
        sb5.append(resource != null ? Integer.valueOf(resource.getActionId()) : null);
        sb5.append(", errorCode: ");
        sb5.append(errorCode);
        SquareLogger.DefaultImpls.e$default(squareLog, "DetailSelectMeView", sb5.toString(), null, 4, null);
        DetailSelectMeView detailSelectMeView = this.this$0;
        statusId = detailSelectMeView.getStatusId(request);
        if (DetailSelectMeView.isCurStatus$default(detailSelectMeView, Integer.valueOf(statusId), null, 2, null)) {
            Square.INSTANCE.getConfig().getThreadManager().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$recordAvatar$1$onRecordError$1
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
                    String str;
                    OnlineStatus status;
                    Square square = Square.INSTANCE;
                    if (square.getConfig().isDebug()) {
                        StringBuilder sb6 = new StringBuilder();
                        Object extra = request.getExtra();
                        if (!(extra instanceof RecordExtra)) {
                            extra = null;
                        }
                        RecordExtra recordExtra = (RecordExtra) extra;
                        sb6.append((recordExtra == null || (status = recordExtra.getStatus()) == null) ? null : status.getTitle());
                        sb6.append("-");
                        Resource resource2 = request.getResource();
                        sb6.append(resource2 != null ? Integer.valueOf(resource2.getActionId()) : null);
                        sb6.append("-");
                        if (type == 1) {
                            str = "\u5c01\u9762\u9519\u8bef";
                        } else {
                            str = "\u89c6\u9891\u9519\u8bef\uff1a" + errorCode;
                        }
                        sb6.append(str);
                        String sb7 = sb6.toString();
                        ICommonUtils commonUtils = square.getConfig().getCommonUtils();
                        Context context = DetailSelectMeView$recordAvatar$1.this.this$0.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        commonUtils.showToast(context, sb7, 1);
                        return;
                    }
                    ICommonUtils commonUtils2 = square.getConfig().getCommonUtils();
                    Context context2 = DetailSelectMeView$recordAvatar$1.this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    commonUtils2.showToast(context2, R.string.xec, 1);
                }
            });
        }
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordStart(final Resource resource, final boolean isStarted) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        SquareBaseKt.getSquareLog().i("DetailSelectMeView", "onRecordStart " + resource.getActionId() + ", isStarted: " + isStarted);
        final Function3 function3 = this.$onRecordStart;
        if (function3 != null) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$recordAvatar$1$onRecordStart$$inlined$let$lambda$1
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
                    Function3.this.invoke(this.$status, resource, Boolean.valueOf(isStarted));
                }
            });
        }
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordSuccess(RecordRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRecordSuccess ");
        Resource resource = request.getResource();
        sb5.append(resource != null ? Integer.valueOf(resource.getActionId()) : null);
        squareLog.i("DetailSelectMeView", sb5.toString());
        this.this$0.doRecordSuccess(request, this.$isBuyTheSame);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onRemovedListener() {
        IResourceCallback.DefaultImpls.onRemovedListener(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticFailed() {
        IResourceCallback.DefaultImpls.onStaticFailed(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticSuccess() {
        IResourceCallback.DefaultImpls.onStaticSuccess(this);
    }
}
