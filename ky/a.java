package ky;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsBaseCollector;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatServiceAssistantSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0011\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0096\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lky/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Landroid/view/View;", "view", "", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/a;", "context", "Landroid/os/Bundle;", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "mChatItem", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements com.tencent.qqnt.chats.main.vm.usecase.click.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private g mChatItem;

    private final Bundle a(g item, com.tencent.qqnt.chats.core.a context) {
        Integer num;
        String str;
        Bundle bundle = new Bundle();
        g.a g16 = item.g();
        Long l3 = null;
        String d16 = g16 != null ? g16.d() : null;
        RecentContactInfo s16 = item.s();
        ArrayList<RecentContactExtAttr> arrayList = s16 != null ? s16.extAttrs : null;
        if (arrayList != null && (!arrayList.isEmpty())) {
            Iterator<RecentContactExtAttr> it = arrayList.iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if ((next != null ? next.serviceAssistantSession : null) != null) {
                    l3 = Long.valueOf(next.serviceAssistantSession.appId);
                    num = Integer.valueOf(next.serviceAssistantSession.appType);
                    str = next.serviceAssistantSession.appTypeName;
                    break;
                }
            }
        }
        num = null;
        str = null;
        bundle.putBoolean("key_isblock", item.s().isBlock);
        bundle.putLong("key_peerUin", item.s().peerUin);
        bundle.putString("key_from", "0");
        bundle.putInt("key_from_chat_listtype", context.b());
        bundle.putLong("key_enter_unread_cnt", item.x().c() == 1 ? item.x().b() : 0L);
        if (l3 != null) {
            bundle.putLong("key_notify_app_id", l3.longValue());
        }
        if (num != null) {
            bundle.putInt("key_notify_app_type", num.intValue());
        }
        if (d16 != null) {
            bundle.putString("key_notify_avatar_path", d16);
        }
        if (str != null) {
            bundle.putString("key_notify_app_sub_title", str);
        }
        com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(item.o());
        if (chatsListReport != null) {
            b.d v3 = chatsListReport.v();
            bundle.putString(WSStatisticsBaseCollector.KEY_REF_PAGE_ID, v3.a());
            bundle.putInt("key_page_stp", v3.b());
        }
        return bundle;
    }

    private final void b(View view) {
        Object obj;
        ArrayList<RecentContactExtAttr> p16;
        RecentContactExtAttr recentContactExtAttr;
        TempChatServiceAssistantSession tempChatServiceAssistantSession;
        ArrayList<RecentContactExtAttr> p17;
        g gVar = this.mChatItem;
        if (gVar != null && gVar.n() == 201) {
            g gVar2 = this.mChatItem;
            if ((gVar2 != null ? gVar2.p() : null) != null) {
                g gVar3 = this.mChatItem;
                if ((gVar3 == null || (p17 = gVar3.p()) == null || !p17.isEmpty()) ? false : true) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("dt_pgid", "pg_bas_node_list");
                AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
                AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
                if (appInterface == null) {
                    return;
                }
                hashMap.put("home_uin", appInterface.getCurrentUin());
                hashMap.put("dt_eid", "em_bas_node_message_entry");
                g gVar4 = this.mChatItem;
                if (gVar4 != null && (p16 = gVar4.p()) != null && (recentContactExtAttr = p16.get(0)) != null && (tempChatServiceAssistantSession = recentContactExtAttr.serviceAssistantSession) != null) {
                    obj = Integer.valueOf(tempChatServiceAssistantSession.appType);
                } else {
                    obj = "";
                }
                hashMap.put("business_type", obj);
                VideoReport.reportEvent("dt_clck", view, hashMap);
                if (QLog.isDevelopLevel()) {
                    QLog.d("NotifyServiceClickUseCase", 4, "NotifyServiceDTReportUtils-[reportItemClick] params = " + hashMap);
                }
            }
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(params.b() instanceof g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
        g gVar = (g) b16;
        this.mChatItem = gVar;
        if (!(gVar != null && gVar.n() == 118)) {
            g gVar2 = this.mChatItem;
            if (!(gVar2 != null && gVar2.n() == 201)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        View c16 = params.c();
        if (!(b16 instanceof g)) {
            return false;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(c16.getContext(), RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        g gVar = (g) b16;
        activityURIRequest.extra().putInt("key_chat_type", gVar.n());
        activityURIRequest.extra().putString("key_peerId", gVar.k());
        activityURIRequest.extra().putString("key_chat_name", gVar.w().e());
        activityURIRequest.extra().putLong("key_peerUin", gVar.l());
        Bundle a16 = a(gVar, params.a());
        if (a16 != null) {
            activityURIRequest.extra().putAll(a16);
        }
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest);
        b(c16);
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
