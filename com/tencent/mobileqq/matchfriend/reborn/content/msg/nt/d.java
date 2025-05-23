package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatPartConvertProcessor;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/d;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "c", "d", "", "tinyId", "a", "b", "", QZoneImageUtils.KEY_MATCH, "update", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d extends com.tencent.qqnt.chats.data.converter.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<com.tencent.qqnt.chats.data.converter.g> mProcessorList;

    public d() {
        List<com.tencent.qqnt.chats.data.converter.g> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.chats.data.converter.g[]{(com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTitleConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createSummaryConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTimeConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createUnreadConvertProcessor()});
        this.mProcessorList = listOf;
    }

    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        ArrayList arrayList = new ArrayList();
        if (item.H()) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.d());
        } else {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.q());
        }
        arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.g());
        item.O(arrayList);
    }

    private final void c(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        if (Intrinsics.areEqual(item.v().f().toString(), HardCodeUtil.qqStr(R.string.f169688x20))) {
            g.e v3 = item.v();
            String qqStr = HardCodeUtil.qqStr(R.string.f169689x21);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_stranger_chatlist_edit_summary)");
            v3.o(qqStr);
        }
    }

    private final void d(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.e("QQStrangerChatConvertProcessor", 1, "updateNtMsgInfo is error! appRuntime is invalid!");
        } else {
            a(item, item.k());
        }
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.n() == 104;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        item.q().putBoolean("is_first_data", false);
        List<com.tencent.qqnt.chats.data.converter.g> list = this.mProcessorList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.chats.data.converter.g) it.next()).update(item, params);
            arrayList.add(Unit.INSTANCE);
        }
        c(item, params);
        b(item, params);
        d(item, params);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0093, code lost:
    
        if ((r5.length() > 0) == true) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, String tinyId) {
        String str;
        boolean z16;
        String str2;
        String str3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        boolean z17 = true;
        if (appInterface == null) {
            QLog.e("QQStrangerChatConvertProcessor", 1, "[processInfoInner] appInterface is null.");
            return;
        }
        try {
            String str4 = "";
            QQStrangerUserInfo userInfo = ((IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(item.n(), Long.parseLong(tinyId), ""));
            if (userInfo == null) {
                QLog.i("QQStrangerChatConvertProcessor", 1, "[processInfoInner] userInfo is null.");
            }
            item.K(new g.a(1, (userInfo == null || (str3 = userInfo.avatar) == null) ? "" : str3, null, null, 12, null));
            if (userInfo == null || (str = userInfo.nick) == null) {
                str = "";
            }
            g.f fVar = new g.f(str);
            if (userInfo != null && (str2 = userInfo.onlineStatus) != null) {
                if (str2.length() > 0) {
                    z16 = true;
                    if (z16) {
                        if (userInfo != null && (r5 = userInfo.matchText) != null) {
                        }
                        z17 = false;
                        if (z17) {
                            str4 = userInfo.matchText;
                        }
                    } else {
                        str4 = userInfo.onlineStatus;
                    }
                    fVar.f(str4);
                    item.S(fVar);
                }
            }
            z16 = false;
            if (z16) {
            }
            fVar.f(str4);
            item.S(fVar);
        } catch (Exception e16) {
            QLog.e("QQStrangerChatConvertProcessor", 1, e16, new Object[0]);
        }
    }
}
