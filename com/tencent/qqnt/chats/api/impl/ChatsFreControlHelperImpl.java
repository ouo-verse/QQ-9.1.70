package com.tencent.qqnt.chats.api.impl;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsFreControlHelper;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceBody;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItem;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItemListBody;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J+\u0010\f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a2\u0006\u0004\b\f\u0010\u000fJ\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsFreControlHelperImpl;", "Lcom/tencent/qqnt/chats/api/IChatsFreControlHelper;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", SessionDbHelper.SESSION_ID, "", TtmlNode.TAG_REGION, "", "Lcom/tencent/qqnt/chats/api/IChatsFreControlHelper$b;", "resItems", "", "innerNotifyRefresh", "notifyRefreshAll", "notifyRefresh", "", "regions", "([Ljava/lang/Integer;Ljava/util/List;)V", "", "uid", "chatType", "notifyRefreshItem", "notifyRefreshTitle", "notifyRefreshAvatar", "notifyRefreshSummary", "notifyRefreshUnread", "<init>", "()V", "Companion", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsFreControlHelperImpl implements IChatsFreControlHelper {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ChatsFreControlHelperImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsFreControlHelperImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.api.impl.ChatsFreControlHelperImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatsFreControlHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void innerNotifyRefresh(IQQNTWrapperSession session, int region, List<IChatsFreControlHelper.b> resItems) {
        if (resItems.isEmpty()) {
            return;
        }
        FrequencyControlField$ResourceItemListBody frequencyControlField$ResourceItemListBody = new FrequencyControlField$ResourceItemListBody();
        for (IChatsFreControlHelper.b bVar : resItems) {
            PBRepeatMessageField<FrequencyControlField$ResourceItem> pBRepeatMessageField = frequencyControlField$ResourceItemListBody.item_list;
            FrequencyControlField$ResourceItem frequencyControlField$ResourceItem = new FrequencyControlField$ResourceItem();
            frequencyControlField$ResourceItem.chat_type.set(bVar.a());
            frequencyControlField$ResourceItem.peer_uid.set(bVar.b());
            frequencyControlField$ResourceItem.scene_id.set(221801);
            frequencyControlField$ResourceItem.update_type.set(221902);
            frequencyControlField$ResourceItem.need_download.set(false);
            PBRepeatMessageField<FrequencyControlField$ResourceBody> pBRepeatMessageField2 = frequencyControlField$ResourceItem.resource_body_list;
            FrequencyControlField$ResourceBody frequencyControlField$ResourceBody = new FrequencyControlField$ResourceBody();
            frequencyControlField$ResourceBody.business_id.set(1000000 * region);
            pBRepeatMessageField2.add(frequencyControlField$ResourceBody);
            pBRepeatMessageField.add(frequencyControlField$ResourceItem);
        }
        byte[] byteArray = frequencyControlField$ResourceItemListBody.toByteArray();
        QLog.d(TAG, 1, "innerNotifyRefresh, push data={" + resItems.size() + "}");
        session.onDispatchPush(221010, byteArray);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsFreControlHelper
    public void notifyRefresh(int region, @NotNull List<IChatsFreControlHelper.b> resItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, region, (Object) resItems);
            return;
        }
        Intrinsics.checkNotNullParameter(resItems, "resItems");
        IQQNTWrapperSession k3 = com.tencent.qqnt.msg.f.k();
        if (k3 != null) {
            innerNotifyRefresh(k3, region, resItems);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsFreControlHelper
    public void notifyRefreshAll(int region) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, region);
            return;
        }
        IQQNTWrapperSession k3 = com.tencent.qqnt.msg.f.k();
        if (k3 != null) {
            FrequencyControlField$ResourceItemListBody frequencyControlField$ResourceItemListBody = new FrequencyControlField$ResourceItemListBody();
            PBRepeatMessageField<FrequencyControlField$ResourceItem> pBRepeatMessageField = frequencyControlField$ResourceItemListBody.item_list;
            FrequencyControlField$ResourceItem frequencyControlField$ResourceItem = new FrequencyControlField$ResourceItem();
            frequencyControlField$ResourceItem.scene_id.set(221801);
            frequencyControlField$ResourceItem.update_type.set(221902);
            frequencyControlField$ResourceItem.need_download.set(false);
            PBRepeatMessageField<FrequencyControlField$ResourceBody> pBRepeatMessageField2 = frequencyControlField$ResourceItem.resource_body_list;
            FrequencyControlField$ResourceBody frequencyControlField$ResourceBody = new FrequencyControlField$ResourceBody();
            frequencyControlField$ResourceBody.business_id.set(region * 1000000);
            frequencyControlField$ResourceItem.chat_type.set(-1);
            frequencyControlField$ResourceBody.update_scope_type.set(222003);
            pBRepeatMessageField2.add(frequencyControlField$ResourceBody);
            pBRepeatMessageField.add(frequencyControlField$ResourceItem);
            byte[] byteArray = frequencyControlField$ResourceItemListBody.toByteArray();
            QLog.d(TAG, 2, "notifyRefreshAll");
            k3.onDispatchPush(221010, byteArray);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsFreControlHelper
    public void notifyRefreshAvatar(@NotNull String uid, int chatType) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uid, chatType);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new IChatsFreControlHelper.b(uid, chatType));
        notifyRefresh(11, arrayListOf);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsFreControlHelper
    public void notifyRefreshItem(@NotNull String uid, int chatType) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uid, chatType);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new IChatsFreControlHelper.b(uid, chatType));
        notifyRefresh(10, arrayListOf);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsFreControlHelper
    public void notifyRefreshSummary(@NotNull String uid, int chatType) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) uid, chatType);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new IChatsFreControlHelper.b(uid, chatType));
        notifyRefresh(13, arrayListOf);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsFreControlHelper
    public void notifyRefreshTitle(@NotNull String uid, int chatType) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uid, chatType);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new IChatsFreControlHelper.b(uid, chatType));
        notifyRefresh(12, arrayListOf);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsFreControlHelper
    public void notifyRefreshUnread(@NotNull String uid, int chatType) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) uid, chatType);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new IChatsFreControlHelper.b(uid, chatType));
        notifyRefresh(18, arrayListOf);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsFreControlHelper
    public void notifyRefresh(@NotNull Integer[] regions, @NotNull List<IChatsFreControlHelper.b> resItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) regions, (Object) resItems);
            return;
        }
        Intrinsics.checkNotNullParameter(regions, "regions");
        Intrinsics.checkNotNullParameter(resItems, "resItems");
        IQQNTWrapperSession k3 = com.tencent.qqnt.msg.f.k();
        if (k3 != null) {
            for (Integer num : regions) {
                innerNotifyRefresh(k3, num.intValue(), resItems);
            }
        }
    }
}
