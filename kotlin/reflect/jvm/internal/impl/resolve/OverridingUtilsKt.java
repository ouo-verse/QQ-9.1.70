package kotlin.reflect.jvm.internal.impl.resolve;

import ADV_REPORT.mobile_adv_report_req;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(@NotNull Collection<? extends H> collection, @NotNull Function1<? super H, ? extends CallableDescriptor> descriptorByHandle) {
        Object first;
        Object single;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (!linkedList.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) linkedList);
            final SmartSet create2 = SmartSet.Companion.create();
            Collection<mobile_adv_report_req> extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(first, linkedList, descriptorByHandle, new Function1<H, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2((OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1<H>) obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(H it) {
                    SmartSet<H> smartSet = create2;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    smartSet.add(it);
                }
            });
            Intrinsics.checkNotNullExpressionValue(extractMembersOverridableInBothWays, "conflictedHandles = Smar\u2026nflictedHandles.add(it) }");
            if (extractMembersOverridableInBothWays.size() == 1 && create2.isEmpty()) {
                single = CollectionsKt___CollectionsKt.single(extractMembersOverridableInBothWays);
                Intrinsics.checkNotNullExpressionValue(single, "overridableGroup.single()");
                create.add(single);
            } else {
                mobile_adv_report_req mobile_adv_report_reqVar = (Object) OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, descriptorByHandle);
                Intrinsics.checkNotNullExpressionValue(mobile_adv_report_reqVar, "selectMostSpecificMember\u2026roup, descriptorByHandle)");
                CallableDescriptor invoke = descriptorByHandle.invoke(mobile_adv_report_reqVar);
                for (mobile_adv_report_req it : extractMembersOverridableInBothWays) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (!OverridingUtil.isMoreSpecific(invoke, descriptorByHandle.invoke(it))) {
                        create2.add(it);
                    }
                }
                if (!create2.isEmpty()) {
                    create.addAll(create2);
                }
                create.add(mobile_adv_report_reqVar);
            }
        }
        return create;
    }
}
