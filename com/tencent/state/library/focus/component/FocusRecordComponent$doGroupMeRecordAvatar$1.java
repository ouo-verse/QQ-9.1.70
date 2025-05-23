package com.tencent.state.library.focus.component;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusGroupItem;
import com.tencent.state.library.focus.view.FocusGroupView;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/state/library/focus/component/FocusRecordComponent$doGroupMeRecordAvatar$1", "Lcom/tencent/state/square/resource/IResourceCallback;", "onRecordError", "", "type", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/RecordRequest;", "errorCode", "onRecordStart", "resource", "Lcom/tencent/state/square/data/Resource;", "isStarted", "", "onRecordSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusRecordComponent$doGroupMeRecordAvatar$1 implements IResourceCallback {
    final /* synthetic */ FocusGroupItem $data;
    final /* synthetic */ FocusGroupView $mainView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FocusRecordComponent$doGroupMeRecordAvatar$1(FocusGroupItem focusGroupItem, FocusGroupView focusGroupView) {
        this.$data = focusGroupItem;
        this.$mainView = focusGroupView;
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
    public void onRecordError(int type, RecordRequest request, int errorCode) {
        Intrinsics.checkNotNullParameter(request, "request");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRecordError ");
        Resource resource = request.getResource();
        sb5.append(resource != null ? Integer.valueOf(resource.getActionId()) : null);
        sb5.append(", errorCode: ");
        sb5.append(errorCode);
        SquareLogger.DefaultImpls.e$default(squareLog, "FocusRecordComponent", sb5.toString(), null, 4, null);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordStart(Resource resource, boolean isStarted) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        SquareBaseKt.getSquareLog().i("FocusRecordComponent", "onRecordStart " + resource.getActionId() + ", isStarted: " + isStarted);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordSuccess(final RecordRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRecordSuccess ");
        Resource resource = request.getResource();
        sb5.append(resource != null ? Integer.valueOf(resource.getActionId()) : null);
        squareLog.i("FocusRecordComponent", sb5.toString());
        if (FocusDataKt.hasMe(this.$data)) {
            Square.INSTANCE.getConfig().getThreadManager().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.library.focus.component.FocusRecordComponent$doGroupMeRecordAvatar$1$onRecordSuccess$1
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
                    SitDownInfo sitDown;
                    SitDownInfo sitDown2;
                    User user = FocusRecordComponent$doGroupMeRecordAvatar$1.this.$data.getItem().getUser();
                    if (user != null && user.isMe()) {
                        User user2 = FocusRecordComponent$doGroupMeRecordAvatar$1.this.$data.getItem().getUser();
                        if (user2 != null && (sitDown2 = user2.getSitDown()) != null) {
                            sitDown2.setResource(request.getResource());
                        }
                        Resource resource2 = request.getResource();
                        if (resource2 != null) {
                            FocusRecordComponent$doGroupMeRecordAvatar$1.this.$mainView.updateAvatar(true, resource2);
                            return;
                        }
                        return;
                    }
                    User user3 = FocusRecordComponent$doGroupMeRecordAvatar$1.this.$data.getRightItem().getUser();
                    if (user3 == null || !user3.isMe()) {
                        return;
                    }
                    User user4 = FocusRecordComponent$doGroupMeRecordAvatar$1.this.$data.getRightItem().getUser();
                    if (user4 != null && (sitDown = user4.getSitDown()) != null) {
                        sitDown.setResource(request.getResource());
                    }
                    Resource resource3 = request.getResource();
                    if (resource3 != null) {
                        FocusRecordComponent$doGroupMeRecordAvatar$1.this.$mainView.updateAvatar(false, resource3);
                    }
                }
            });
        }
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
