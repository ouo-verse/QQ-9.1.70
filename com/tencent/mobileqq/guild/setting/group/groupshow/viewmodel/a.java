package com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel;

import az1.GroupChatShowData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/a;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/a$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "Lkotlin/collections/ArrayList;", "groupList", "", "isCreator", "", "Laz1/c;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final List<GroupChatShowData> a(@NotNull ArrayList<IGProBindingGroup> groupList, boolean isCreator) {
            int collectionSizeOrDefault;
            boolean z16;
            Intrinsics.checkNotNullParameter(groupList, "groupList");
            Logger.f235387a.d().i("Guild.NewHome.GroupChatShowDataTransformer", 1, "transformCardDataList size:" + groupList.size() + ", isCreator:" + isCreator);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(groupList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            int i3 = 0;
            for (Object obj : groupList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                IGProBindingGroup iGProBindingGroup = (IGProBindingGroup) obj;
                String groupName = iGProBindingGroup.getGroupName();
                Intrinsics.checkNotNullExpressionValue(groupName, "bindingGroup.groupName");
                long groupCode = iGProBindingGroup.getGroupCode();
                String signature = iGProBindingGroup.getSignature();
                Intrinsics.checkNotNullExpressionValue(signature, "bindingGroup.signature");
                if ((iGProBindingGroup.getGroupFlag() & 128) > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                long groupMemberSize = iGProBindingGroup.getGroupMemberSize();
                String onlineMemberSize = iGProBindingGroup.getOnlineMemberSize();
                Intrinsics.checkNotNullExpressionValue(onlineMemberSize, "bindingGroup.onlineMemberSize");
                arrayList.add(new GroupChatShowData(groupName, groupCode, signature, z16, groupMemberSize, onlineMemberSize, iGProBindingGroup.getIsGroupMember()));
                i3 = i16;
            }
            return arrayList;
        }

        Companion() {
        }
    }
}
