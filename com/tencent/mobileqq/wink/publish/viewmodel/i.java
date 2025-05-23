package com.tencent.mobileqq.wink.publish.viewmodel;

import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.model.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/i;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "N1", "Lcom/tencent/mobileqq/winkpublish/model/Friend;", GuildMsgItem.NICK_FRIEND, "", "L1", "", "friends", "O1", "getLogTag", "", "i", "Ljava/util/List;", "_atFriends", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M1", "()Ljava/util/List;", "atFriends", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Friend> _atFriends;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Friend> atFriends;

    public i() {
        ArrayList arrayList = new ArrayList();
        this._atFriends = arrayList;
        this.atFriends = arrayList;
    }

    public final void L1(@NotNull Friend friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        this._atFriends.add(friend);
    }

    @NotNull
    public final List<Friend> M1() {
        return this.atFriends;
    }

    @NotNull
    public final ArrayList<String> N1() {
        int collectionSizeOrDefault;
        List<Friend> list = this.atFriends;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Friend) it.next()).mUin));
        }
        return new ArrayList<>(arrayList);
    }

    public final void O1(@NotNull List<? extends Friend> friends) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        this._atFriends.removeAll(friends);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "PublishAtFriendsViewModel";
    }
}
