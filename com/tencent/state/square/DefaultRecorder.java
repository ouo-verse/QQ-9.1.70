package com.tencent.state.square;

import com.tencent.state.square.IZPlanRecorder;
import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.zplan.meme.action.MemeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J1\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J1\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016JH\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b26\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/DefaultRecorder;", "Lcom/tencent/state/square/IZPlanRecorder;", "()V", "addRecordDoneCallback", "", "callback", "Lcom/tencent/state/square/api/RecordSuccessListener;", "getCacheUserDressKey", "", "uin", "recordAvatarActions", "", "action", "Lcom/tencent/state/square/data/AvatarAction;", "recordIdentifier", "Lcom/tencent/state/square/record/RecordIdentifier;", "forceCallback", "needAddToHead", "(Lcom/tencent/state/square/data/AvatarAction;Lcom/tencent/state/square/record/RecordIdentifier;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resource", "Lcom/tencent/state/square/data/Resource;", "(Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/record/RecordIdentifier;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeRecordDoneCallback", "requestUserDressKey", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "dressKey", "simpleRecordAction", "Lcom/tencent/zplan/meme/action/MemeAction;", "useSticker", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultRecorder implements IZPlanRecorder {
    private static final String TAG = "DefaultRecorder";

    @Override // com.tencent.state.square.IZPlanRecorder
    public void addRecordDoneCallback(@NotNull RecordSuccessListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().d(TAG, "addRecordDoneCallback callback:" + callback);
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public boolean canCodecReUse() {
        return IZPlanRecorder.DefaultImpls.canCodecReUse(this);
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    @NotNull
    public String getCacheUserDressKey(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return "shell_dresskey";
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public boolean isMp4FileValid(@NotNull String localPath) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        return IZPlanRecorder.DefaultImpls.isMp4FileValid(this, localPath);
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    @Nullable
    public Object recordAvatarActions(@NotNull AvatarAction avatarAction, @NotNull RecordIdentifier recordIdentifier, boolean z16, boolean z17, @NotNull Continuation<? super Boolean> continuation) {
        SquareBaseKt.getSquareLog().d(TAG, "recordAvatarActions action:" + avatarAction + " forceCallback:" + z16);
        return Boxing.boxBoolean(false);
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public void removeRecordDoneCallback(@NotNull RecordSuccessListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().d(TAG, "removeRecordDoneCallback callback:" + callback);
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public void requestUserDressKey(@NotNull String uin, @NotNull Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    public void simpleRecordAction(@NotNull MemeAction action, boolean useSticker) {
        Intrinsics.checkNotNullParameter(action, "action");
    }

    @Override // com.tencent.state.square.IZPlanRecorder
    @Nullable
    public Object recordAvatarActions(@NotNull Resource resource, @NotNull RecordIdentifier recordIdentifier, boolean z16, boolean z17, @NotNull Continuation<? super Boolean> continuation) {
        SquareBaseKt.getSquareLog().d(TAG, "recordAvatarActions squareItem:" + resource + " forceCallback:" + z16);
        return Boxing.boxBoolean(false);
    }
}
