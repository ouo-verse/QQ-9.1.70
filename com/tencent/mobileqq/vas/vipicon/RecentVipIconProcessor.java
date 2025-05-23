package com.tencent.mobileqq.vas.vipicon;

import android.content.res.Resources;
import android.os.Debug;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasFeature;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/RecentVipIconProcessor;", "Lcom/tencent/qqnt/chats/inject/title/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class RecentVipIconProcessor extends com.tencent.qqnt.chats.inject.title.a {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f311293b;

    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull final SingleLineTextView view) {
        final com.tencent.mobileqq.vas.image.c cVar;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (f311293b) {
            Debug.startMethodTracing("updateTitle");
        }
        VASPersonalElement vASPersonalElement = item.s().vasPersonalInfo;
        VASPersonalNamePlate namePlateInfo = vASPersonalElement.personalNamePlateInfo;
        Integer num = namePlateInfo.vipType;
        if (num != null && (num == null || num.intValue() != 0)) {
            Integer num2 = vASPersonalElement.personalNamePlateInfo.namePlateId;
            Intrinsics.checkNotNullExpressionValue(num2, "data.personalNamePlateInfo.namePlateId");
            if (num2.intValue() >= 0 && !VasFeature.INSTANCE.getVipIcon().isNotEnable() && !SimpleUIUtil.isNowSimpleMode()) {
                IVipIconFactory iVipIconFactory = (IVipIconFactory) QRoute.api(IVipIconFactory.class);
                Resources resources = view.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
                Intrinsics.checkNotNullExpressionValue(namePlateInfo, "namePlateInfo");
                final com.tencent.mobileqq.vas.image.c iconForRecent = iVipIconFactory.getIconForRecent(resources, namePlateInfo);
                Integer num3 = namePlateInfo.vipType;
                Intrinsics.checkNotNullExpressionValue(num3, "namePlateInfo.vipType");
                if (NamePlateVipType.convert(num3.intValue()).atLeastSuperVip()) {
                    IVipIconExFactory iVipIconExFactory = (IVipIconExFactory) QRoute.api(IVipIconExFactory.class);
                    Resources resources2 = view.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
                    cVar = iVipIconExFactory.getIconForRecent(resources2, namePlateInfo);
                } else {
                    cVar = null;
                }
                if (iconForRecent != null) {
                    iconForRecent.setLoadedListener(new Function1<com.tencent.mobileqq.vas.image.c, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.RecentVipIconProcessor$updateTitle$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.vas.image.c cVar2) {
                            invoke2(cVar2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull com.tencent.mobileqq.vas.image.c it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            SingleLineTextView.this.setCompoundDrawables(null, iconForRecent, cVar);
                        }
                    });
                }
                if (cVar != null) {
                    cVar.setLoadedListener(new Function1<com.tencent.mobileqq.vas.image.c, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.RecentVipIconProcessor$updateTitle$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.vas.image.c cVar2) {
                            invoke2(cVar2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull com.tencent.mobileqq.vas.image.c it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            SingleLineTextView.this.setCompoundDrawables(null, iconForRecent, cVar);
                        }
                    });
                }
                if (iconForRecent != null) {
                    iconForRecent.setBounds(0, 0, iconForRecent.getWidth(), iconForRecent.getHeight());
                }
                if (cVar != null) {
                    cVar.setBounds(0, 0, cVar.getWidth(), cVar.getHeight());
                }
                view.setCompoundDrawables(null, iconForRecent, cVar);
                if (f311293b) {
                    f311293b = false;
                    Debug.stopMethodTracing();
                    return;
                }
                return;
            }
        }
        view.setCompoundDrawables(null, null, null);
    }
}
