package com.tencent.state.square;

import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.zplan.meme.action.MemeAction;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0016J5\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J5\u0010\r\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JH\u0010\u0019\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t26\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00030\u001aH&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007H'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/IZPlanRecorder;", "", "addRecordDoneCallback", "", "callback", "Lcom/tencent/state/square/api/RecordSuccessListener;", "canCodecReUse", "", "getCacheUserDressKey", "", "uin", "isMp4FileValid", "localPath", "recordAvatarActions", "action", "Lcom/tencent/state/square/data/AvatarAction;", "recordIdentifier", "Lcom/tencent/state/square/record/RecordIdentifier;", "forceCallback", "needAddToHead", "(Lcom/tencent/state/square/data/AvatarAction;Lcom/tencent/state/square/record/RecordIdentifier;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resource", "Lcom/tencent/state/square/data/Resource;", "(Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/record/RecordIdentifier;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeRecordDoneCallback", "requestUserDressKey", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "dressKey", "simpleRecordAction", "Lcom/tencent/zplan/meme/action/MemeAction;", "useSticker", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IZPlanRecorder {
    void addRecordDoneCallback(@NotNull RecordSuccessListener callback);

    boolean canCodecReUse();

    @NotNull
    String getCacheUserDressKey(@NotNull String uin);

    boolean isMp4FileValid(@NotNull String localPath);

    @Nullable
    Object recordAvatarActions(@NotNull AvatarAction avatarAction, @NotNull RecordIdentifier recordIdentifier, boolean z16, boolean z17, @NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object recordAvatarActions(@NotNull Resource resource, @NotNull RecordIdentifier recordIdentifier, boolean z16, boolean z17, @NotNull Continuation<? super Boolean> continuation);

    void removeRecordDoneCallback(@NotNull RecordSuccessListener callback);

    void requestUserDressKey(@NotNull String uin, @NotNull Function2<? super Boolean, ? super String, Unit> callback);

    @Deprecated(message = "just for test")
    void simpleRecordAction(@NotNull MemeAction action, boolean useSticker);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static boolean canCodecReUse(@NotNull IZPlanRecorder iZPlanRecorder) {
            return false;
        }

        public static boolean isMp4FileValid(@NotNull IZPlanRecorder iZPlanRecorder, @NotNull String localPath) {
            Intrinsics.checkNotNullParameter(localPath, "localPath");
            return true;
        }

        public static /* synthetic */ Object recordAvatarActions$default(IZPlanRecorder iZPlanRecorder, AvatarAction avatarAction, RecordIdentifier recordIdentifier, boolean z16, boolean z17, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                boolean z18 = z16;
                if ((i3 & 8) != 0) {
                    z17 = true;
                }
                return iZPlanRecorder.recordAvatarActions(avatarAction, recordIdentifier, z18, z17, (Continuation<? super Boolean>) continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordAvatarActions");
        }

        public static /* synthetic */ Object recordAvatarActions$default(IZPlanRecorder iZPlanRecorder, Resource resource, RecordIdentifier recordIdentifier, boolean z16, boolean z17, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                boolean z18 = z16;
                if ((i3 & 8) != 0) {
                    z17 = true;
                }
                return iZPlanRecorder.recordAvatarActions(resource, recordIdentifier, z18, z17, (Continuation<? super Boolean>) continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordAvatarActions");
        }
    }
}
