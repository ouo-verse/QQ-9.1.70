package com.tencent.state.template.service;

import android.graphics.Point;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RemainTimeInfo;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.User;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0016J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH&J/\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH&\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH&J\u001a\u0010\u0015\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH&J$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH&J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000eH&J(\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\r2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH&J\u0016\u0010\u001e\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH&J8\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000eH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/template/service/ITemplateRoomService;", "", "choose", "", "roomId", "", "optionNum", "", "callback", "Lkotlin/Function1;", "", "editTag", "tagId", "", "Lcom/tencent/state/service/ResultCallback;", "enterRoom", "uin", "Lcom/tencent/state/template/data/EnterRoomInfo;", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/state/service/ResultCallback;)V", "getRemainLifeTime", "Lcom/tencent/state/template/data/RemainTimeInfo;", "leaveRoom", "refreshUserInfo", "motionId", "sitDown", "params", "Lcom/tencent/state/template/data/SitDownTagParams;", "Lcom/tencent/state/template/data/User;", "standUp", "from", "switchRoom", "switchTable", "tableId", "sitLocation", "Landroid/graphics/Point;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ITemplateRoomService {
    void choose(long roomId, int optionNum, Function1<? super Boolean, Unit> callback);

    void editTag(String tagId, ResultCallback<Boolean> callback);

    void enterRoom(Long roomId, Long uin, ResultCallback<EnterRoomInfo> callback);

    void getRemainLifeTime(ResultCallback<RemainTimeInfo> callback);

    void leaveRoom(ResultCallback<Boolean> callback);

    void refreshUserInfo(int motionId, Function1<? super Boolean, Unit> callback);

    void sitDown(SitDownTagParams params, ResultCallback<User> callback);

    void standUp(String from, Function1<? super Boolean, Unit> callback);

    void switchRoom(ResultCallback<EnterRoomInfo> callback);

    void switchTable(String uin, long roomId, long tableId, Point sitLocation, ResultCallback<User> callback);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void choose(ITemplateRoomService iTemplateRoomService, long j3, int i3, Function1<? super Boolean, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void leaveRoom$default(ITemplateRoomService iTemplateRoomService, ResultCallback resultCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    resultCallback = null;
                }
                iTemplateRoomService.leaveRoom(resultCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: leaveRoom");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void standUp$default(ITemplateRoomService iTemplateRoomService, String str, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function1 = null;
                }
                iTemplateRoomService.standUp(str, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: standUp");
        }
    }
}
