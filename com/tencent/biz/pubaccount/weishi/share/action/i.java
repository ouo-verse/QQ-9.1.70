package com.tencent.biz.pubaccount.weishi.share.action;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqnt.kernel.nativeinterface.RichErrorCode;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/share/action/i;", "Lcom/tencent/biz/pubaccount/weishi/share/action/a;", "Lj10/a;", "shareParam", "", "b", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class i implements a {
    @Override // com.tencent.biz.pubaccount.weishi.share.action.a
    public boolean a(Context context, ShareActionSheetBuilder.ActionSheetItem sheetItem, j10.a shareParam) {
        b(shareParam);
        ToastUtil.a().b(R.string.f241797su);
        return true;
    }

    private final void b(j10.a shareParam) {
        if (shareParam != null) {
            WSPublicAccReport.getInstance().reportShareClick(shareParam.f409069g, RichErrorCode.KFILEIOFAIL, shareParam.f409067e, shareParam.f409068f, shareParam.f409063a, shareParam.f409071i);
        }
    }
}
