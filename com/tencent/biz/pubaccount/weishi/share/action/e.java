package com.tencent.biz.pubaccount.weishi.share.action;

import NS_KING_SOCIALIZE_META.stShareBody;
import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/share/action/e;", "Lcom/tencent/biz/pubaccount/weishi/share/action/a;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "Lj10/a;", "shareParam", "", "d", "LNS_KING_SOCIALIZE_META/stShareBody;", "b", "", "c", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e implements a {
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean d(Context context, ShareActionSheetBuilder.ActionSheetItem sheetItem, j10.a shareParam) {
        boolean z16;
        boolean isBlank;
        stSimpleMetaFeed stsimplemetafeed;
        stShareInfo stshareinfo;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return false;
        }
        if (sheetItem == null) {
            x.f("WSShare2QQZoneAction", "[share2QZone] sheetItem is null!");
            return false;
        }
        stShareBody b16 = b(shareParam);
        if (b16 == null) {
            x.f("WSShare2QQZoneAction", "[shareToQZone] shareBody is null!");
            return false;
        }
        String str = (shareParam == null || (stsimplemetafeed = shareParam.f409063a) == null || (stshareinfo = stsimplemetafeed.share_info) == null) ? null : stshareinfo.jump_url;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    x.f("WSShare2QQZoneAction", "[shareToQZone] jumpUrl is null!");
                    return false;
                }
                QZoneShareData qZoneShareData = new QZoneShareData();
                qZoneShareData.mTitle = b16.title;
                qZoneShareData.mSummary = b16.desc;
                ArrayList<String> arrayList = new ArrayList<>();
                qZoneShareData.mImageUrls = arrayList;
                arrayList.add(b16.image_url);
                qZoneShareData.from = 0;
                qZoneShareData.targetUrl = str;
                String str2 = sheetItem.uin;
                qZoneShareData.shareUin = str2;
                try {
                    QZoneShareManager.shareToQzone(activity, str2, qZoneShareData, null, 0);
                    return true;
                } catch (Exception e16) {
                    x.f("WSShare2QQZoneAction", "[shareToQZone] error:" + e16.getMessage());
                    return false;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.share.action.a
    public boolean a(Context context, ShareActionSheetBuilder.ActionSheetItem sheetItem, j10.a shareParam) {
        boolean d16 = d(context, sheetItem, shareParam);
        if (d16) {
            c(shareParam);
        }
        return d16;
    }

    private final stShareBody b(j10.a shareParam) {
        stSimpleMetaFeed stsimplemetafeed;
        stShareInfo stshareinfo;
        Map<Integer, stShareBody> map;
        if (shareParam == null || (stsimplemetafeed = shareParam.f409063a) == null || (stshareinfo = stsimplemetafeed.share_info) == null || (map = stshareinfo.body_map) == null) {
            return null;
        }
        return map.get(0);
    }

    private final void c(j10.a shareParam) {
        if (shareParam != null) {
            WSPublicAccReport.getInstance().reportShareClick(shareParam.f409069g, 1003003, shareParam.f409067e, shareParam.f409068f, shareParam.f409063a, shareParam.f409071i);
        }
    }
}
