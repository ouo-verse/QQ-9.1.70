package com.tencent.state.publicchat.view;

import android.content.Context;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.template.data.RoomThemeData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "context", "Landroid/content/Context;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "themeData", "Lcom/tencent/state/template/data/RoomThemeData;", "templateId", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IMessageItemViewFactory {
    AbstractMessageItemView create(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData themeData);

    /* renamed from: templateId */
    String getTEMPLATE_ID();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ AbstractMessageItemView create$default(IMessageItemViewFactory iMessageItemViewFactory, Context context, MsgConfInfo msgConfInfo, MsgInfo msgInfo, Function1 function1, RoomThemeData roomThemeData, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    roomThemeData = null;
                }
                return iMessageItemViewFactory.create(context, msgConfInfo, msgInfo, function1, roomThemeData);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }
    }
}
