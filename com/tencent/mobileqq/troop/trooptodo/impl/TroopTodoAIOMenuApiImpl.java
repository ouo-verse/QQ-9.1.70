package com.tencent.mobileqq.troop.trooptodo.impl;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.trooptodo.ITroopTodoAIOMenuApi;
import com.tencent.mobileqq.troop.trooptodo.TodoInfoPresenter;
import com.tencent.mobileqq.troop.trooptodo.m;
import com.tencent.mobileqq.troop.trooptodo.n;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/trooptodo/impl/TroopTodoAIOMenuApiImpl;", "Lcom/tencent/mobileqq/troop/trooptodo/ITroopTodoAIOMenuApi;", "()V", "getTroopTodoType", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "onTroopTodoClicked", "", "context", "Landroid/content/Context;", "isCancel", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopTodoAIOMenuApiImpl implements ITroopTodoAIOMenuApi {
    static IPatchRedirector $redirector_;

    public TroopTodoAIOMenuApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTroopTodoClicked$lambda$0(AIOMsgItem msgItem, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        n.h(msgItem);
        m.d("0X800BC72", msgItem);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTroopTodoClicked$lambda$1(AIOMsgItem msgItem, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        n.a(msgItem);
        m.d("0X800BC71", msgItem);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTroopTodoClicked$lambda$2(AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        m.d("0X800BC73", msgItem);
    }

    @Override // com.tencent.mobileqq.troop.trooptodo.ITroopTodoAIOMenuApi
    public int getTroopTodoType(@NotNull AIOMsgItem msgItem) {
        int i3;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgRecord msgRecord = msgItem.getMsgRecord();
        if (msgRecord.chatType != 2 || (i3 = msgRecord.sendStatus) == 0 || i3 == 1 || d.b0(msgItem)) {
            return 0;
        }
        if (d.Y(msgRecord)) {
            com.tencent.mobileqq.aio.msg.template.d parseTemplateMsgInfo = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).parseTemplateMsgInfo(msgItem);
            if (parseTemplateMsgInfo == null || (str2 = parseTemplateMsgInfo.a()) == null) {
                str2 = "";
            }
            if (!n.f(str2)) {
                return 0;
            }
        } else if (d.u(msgRecord)) {
            com.tencent.qqnt.msg.data.a parseArkModel = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).parseArkModel(msgItem);
            if (parseArkModel == null || (str = parseArkModel.d()) == null) {
                str = "";
            }
            if (!n.f(str)) {
                return 0;
            }
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        TroopInfo findTroopInfo = ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(msgRecord.peerUid);
        if (findTroopInfo != null && (findTroopInfo.isTroopOwner(appInterface.getCurrentUin()) || findTroopInfo.isTroopAdmin(appInterface.getCurrentUin()))) {
            boolean y16 = TodoInfoPresenter.m().y(msgRecord.peerUin, msgRecord.msgSeq);
            boolean g16 = n.g(msgRecord);
            if (!y16 && !g16) {
                m.d("0X800BC6C", msgItem);
                return 1;
            }
            m.d("0X800BC6E", msgItem);
            return 2;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.trooptodo.ITroopTodoAIOMenuApi
    public void onTroopTodoClicked(@NotNull Context context, @NotNull final AIOMsgItem msgItem, boolean isCancel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, msgItem, Boolean.valueOf(isCancel));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        if (isCancel) {
            m.d("0X800BC6F", msgItem);
            actionSheet.setMainTitle(R.string.f236617eu);
            actionSheet.addButton(R.string.zj9, 5);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.trooptodo.impl.a
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    TroopTodoAIOMenuApiImpl.onTroopTodoClicked$lambda$0(AIOMsgItem.this, actionSheet, view, i3);
                }
            });
        } else {
            m.d("0X800BC6D", msgItem);
            if (n.c()) {
                actionSheet.setMainTitle(R.string.zln);
            } else {
                actionSheet.setMainTitle(R.string.zlm);
            }
            actionSheet.addButton(R.string.zll, 5);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.trooptodo.impl.b
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    TroopTodoAIOMenuApiImpl.onTroopTodoClicked$lambda$1(AIOMsgItem.this, actionSheet, view, i3);
                }
            });
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.troop.trooptodo.impl.c
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                TroopTodoAIOMenuApiImpl.onTroopTodoClicked$lambda$2(AIOMsgItem.this);
            }
        });
        actionSheet.show();
        m.d("0X800BC70", msgItem);
    }
}
