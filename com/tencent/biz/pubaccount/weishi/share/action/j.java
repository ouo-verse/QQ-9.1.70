package com.tencent.biz.pubaccount.weishi.share.action;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/share/action/j;", "Lcom/tencent/biz/pubaccount/weishi/share/action/a;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "Lj10/a;", "shareParam", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class j implements a {
    @Override // com.tencent.biz.pubaccount.weishi.share.action.a
    public boolean a(Context context, ShareActionSheetBuilder.ActionSheetItem sheetItem, j10.a shareParam) {
        stSimpleMetaFeed stsimplemetafeed = shareParam != null ? shareParam.f409063a : null;
        if (stsimplemetafeed == null) {
            x.f("WSSharePromotionAction", "[doAction] feed is null!");
            return false;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.a.g(context, 131072, stsimplemetafeed, shareParam.f409066d);
        return true;
    }
}
