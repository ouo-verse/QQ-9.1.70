package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.activity.aio.intimate.view.ElegantGiftView;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J4\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u001a\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/a;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/IntimateCompatBaseItemDelegate;", "Landroid/content/Context;", "context", "Landroid/view/View;", "d", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lj61/a;", "sections", "", "initSection", "model", "", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends IntimateCompatBaseItemDelegate {
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h
    public boolean b(@NotNull IntimateBaseModel model) {
        boolean z16;
        IntimateInfo.FriendGiftInfo copyFrom;
        Intrinsics.checkNotNullParameter(model, "model");
        if (!((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
            return false;
        }
        List<IntimateInfo.CommonBody> list = model.getIntimateInfo().commonBodyList;
        List<IntimateInfo.CommonBody> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        for (IntimateInfo.CommonBody commonBody : list) {
            if (commonBody.cmd == 3436 && (copyFrom = IntimateInfo.FriendGiftInfo.copyFrom(commonBody)) != null && copyFrom.str_send_times > 0 && copyFrom.str_gift_url != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @NotNull
    public View d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ElegantGiftView(context);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<IntimateBaseModel>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(k61.a.class);
    }
}
