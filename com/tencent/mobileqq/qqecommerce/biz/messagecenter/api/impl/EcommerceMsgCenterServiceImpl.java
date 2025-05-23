package com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenterService;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/impl/EcommerceMsgCenterServiceImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/IEcommerceMsgCenterService;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "", "tryClearRedDotIfNeeded", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "callback", "fetchRedDotMessage", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "<init>", "()V", "Companion", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class EcommerceMsgCenterServiceImpl implements IEcommerceMsgCenterService {
    public static final String KEY_LAST_CONSUMED_MESSAGE_ID = "key_last_consumed_message_id";
    public static final String TAG = "EcommerceMsgCenterService";
    private volatile BaseQQAppInterface app;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchRedDotMessage$lambda$3(Function1 callback, int i3, String str, ArrayList msgList) {
        Object firstOrNull;
        String e16;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgList);
        MsgRecord msgRecord = (MsgRecord) firstOrNull;
        e16 = c.e(msgRecord);
        QLog.i(TAG, 1, "msgItem=" + e16);
        MessageItem g16 = msgRecord != null ? c.g(msgRecord) : null;
        if (Intrinsics.areEqual(g16 != null ? g16.getId() : null, k.a().h(KEY_LAST_CONSUMED_MESSAGE_ID, ""))) {
            callback.invoke(null);
        } else {
            callback.invoke(g16);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenterService
    public void fetchRedDotMessage(final Function1<? super MessageItem, Unit> callback) {
        RecentContactInfo recentContactInfo;
        String f16;
        ArrayList<Long> arrayListOf;
        RecentContactInfo recentContactInfo2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            callback.invoke(null);
            return;
        }
        aa recentContactService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        w msgService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")).getMsgService();
        if (recentContactService != null && msgService != null) {
            List<RecentContactInfo> a16 = recentContactService.a();
            if (a16 != null) {
                ListIterator<RecentContactInfo> listIterator = a16.listIterator(a16.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        recentContactInfo2 = null;
                        break;
                    }
                    recentContactInfo2 = listIterator.previous();
                    RecentContactInfo recentContactInfo3 = recentContactInfo2;
                    if (recentContactInfo3.peerUin == AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN_LONGVALUE && recentContactInfo3.chatType == 103) {
                        break;
                    }
                }
                recentContactInfo = recentContactInfo2;
            } else {
                recentContactInfo = null;
            }
            f16 = c.f(recentContactInfo);
            QLog.i(TAG, 1, "recentContactInfo=" + f16);
            String str = recentContactInfo != null ? recentContactInfo.peerUid : null;
            if (str == null) {
                str = "";
            }
            Contact contact = new Contact(103, str, "");
            Long[] lArr = new Long[1];
            lArr[0] = Long.valueOf(recentContactInfo != null ? recentContactInfo.msgId : -1L);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(lArr);
            msgService.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str2, ArrayList arrayList) {
                    EcommerceMsgCenterServiceImpl.fetchRedDotMessage$lambda$3(Function1.this, i3, str2, arrayList);
                }
            });
            return;
        }
        callback.invoke(null);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof BaseQQAppInterface) {
            this.app = (BaseQQAppInterface) appRuntime;
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenterService
    public void tryClearRedDotIfNeeded(BaseQQAppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).markRead4PA(AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UID, new IOperateCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                EcommerceMsgCenterServiceImpl.tryClearRedDotIfNeeded$lambda$0(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryClearRedDotIfNeeded$lambda$0(int i3, String str) {
        if (i3 != 0) {
            QLog.d(TAG, 1, "mark read fail: " + str);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
