package com.tencent.mobileqq.qqexpand.manager.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandConverListResponse;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandConversation;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.a;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandConversationManager;
import com.tencent.mobileqq.qqexpand.manager.impl.ExpandConversationManagerImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/manager/impl/ExpandConversationManagerImpl;", "Lcom/tencent/mobileqq/qqexpand/manager/IExpandConversationManager;", "", "cursor", "", "pageCount", "Lcom/tencent/mobileqq/qqexpand/manager/IExpandConversationManager$a;", "callback", "", "getConversationList", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandConversationManagerImpl implements IExpandConversationManager {
    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandConversationManager
    public void getConversationList(String cursor, int pageCount, final IExpandConversationManager.a callback) {
        Manager manager = BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.ExpandManager");
        ((ExpandManager) manager).r0().k(cursor, pageCount, new ExpandChatRepository.a() { // from class: bh2.a
            @Override // com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.a
            public final void a(int i3, String str, ExpandConverListResponse expandConverListResponse) {
                ExpandConversationManagerImpl.getConversationList$lambda$1(IExpandConversationManager.a.this, i3, str, expandConverListResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getConversationList$lambda$1(IExpandConversationManager.a aVar, int i3, String str, ExpandConverListResponse expandConverListResponse) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        if (i3 != 0) {
            if (aVar != null) {
                aVar.onFail(i3, str);
                return;
            }
            return;
        }
        if (aVar != null) {
            boolean z16 = expandConverListResponse.finishFlag;
            String str2 = expandConverListResponse.cursor;
            List<ExpandConversation> list = expandConverListResponse.conversations;
            if (list != null) {
                List<ExpandConversation> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                arrayList = new ArrayList(collectionSizeOrDefault);
                for (ExpandConversation it : list2) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(new a(it));
                }
            } else {
                arrayList = null;
            }
            aVar.a(z16, str2, arrayList);
        }
    }
}
