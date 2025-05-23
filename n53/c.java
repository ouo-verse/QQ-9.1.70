package n53;

import android.content.Context;
import android.widget.RelativeLayout;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.ai.i;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.wink.aiavatar.mainpage.view.WinkAIAvatarGroupLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarSubCategoryInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qshadow.QShadowMetaMaterial$CategoryInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0003H\u0016\u00a8\u0006\u0018"}, d2 = {"Ln53/c;", "Lcom/tencent/mobileqq/ai/i;", "Ln53/b;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;", "f", "category", "", h.F, "feedsInfo", "e", com.tencent.luggage.wxa.c8.c.G, "subCategory", "g", "Landroid/content/Context;", "context", "itemViewType", "j", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "i", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c implements i<b, MetaCategory> {
    private final MetaCategory f(AiAvatarSubCategoryInfo aiAvatarSubCategoryInfo) {
        MetaCategory metaCategory = new MetaCategory();
        if (aiAvatarSubCategoryInfo.subCategoryBody != null) {
            try {
                QShadowMetaMaterial$CategoryInfo qShadowMetaMaterial$CategoryInfo = new QShadowMetaMaterial$CategoryInfo();
                qShadowMetaMaterial$CategoryInfo.mergeFrom(aiAvatarSubCategoryInfo.subCategoryBody);
                return v53.a.d(qShadowMetaMaterial$CategoryInfo);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("WinkAIAvatarFeedsRenderAdapterImpl", 1, "decodeSubcategory: ", e16);
            }
        }
        return metaCategory;
    }

    private final int h(MetaCategory category) {
        ArrayList<MetaMaterial> arrayList;
        MetaMaterial metaMaterial;
        if (category == null || (arrayList = category.materials) == null || (metaMaterial = arrayList.get(0)) == null || !com.tencent.mobileqq.wink.editor.c.Z0(metaMaterial)) {
            return 3;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.ai.i
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MetaCategory a(@NotNull AiAvatarSubCategoryInfo feedsInfo) {
        Intrinsics.checkNotNullParameter(feedsInfo, "feedsInfo");
        return f(feedsInfo);
    }

    @Override // com.tencent.mobileqq.ai.i
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int c(int pos, @NotNull AiAvatarSubCategoryInfo feedsInfo, @NotNull MetaCategory subCategory) {
        Intrinsics.checkNotNullParameter(feedsInfo, "feedsInfo");
        Intrinsics.checkNotNullParameter(subCategory, "subCategory");
        String f16 = com.tencent.mobileqq.wink.editor.b.f(subCategory, NotifyMsgApiImpl.KEY_GROUP_TYPE);
        if (Intrinsics.areEqual(f16, "horizontalBanner")) {
            return 1;
        }
        if (Intrinsics.areEqual(f16, "horizontal")) {
            return 0;
        }
        return h(subCategory);
    }

    @Override // com.tencent.mobileqq.ai.i
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void d(@NotNull b item, int pos, @NotNull AiAvatarSubCategoryInfo feedsInfo, @NotNull MetaCategory subCategory) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(feedsInfo, "feedsInfo");
        Intrinsics.checkNotNullParameter(subCategory, "subCategory");
        item.o(feedsInfo.subCategoryInfoId, subCategory);
    }

    @Override // com.tencent.mobileqq.ai.i
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public b b(@NotNull Context context, int itemViewType) {
        Intrinsics.checkNotNullParameter(context, "context");
        WinkAIAvatarGroupLayout winkAIAvatarGroupLayout = new WinkAIAvatarGroupLayout(context, itemViewType);
        winkAIAvatarGroupLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        winkAIAvatarGroupLayout.g();
        return new b(winkAIAvatarGroupLayout);
    }
}
