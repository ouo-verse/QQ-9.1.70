package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellBigTail;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0000\u00a8\u0006\u0006"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellBigTail;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellBigTail;", "toCommonNonNull", "toPb", "toPbNonNull", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellBigTailKt {
    public static final CommonCellBigTail toCommonNonNull(StCellBigTail stCellBigTail) {
        CommonCellBigTail commonCellBigTail = new CommonCellBigTail();
        commonCellBigTail.setType(stCellBigTail.type);
        commonCellBigTail.setDesc(stCellBigTail.desc);
        commonCellBigTail.setBrightIcon(stCellBigTail.brightIcon);
        commonCellBigTail.setDarkIcon(stCellBigTail.darkIcon);
        commonCellBigTail.setActionUrl(stCellBigTail.actionUrl);
        return commonCellBigTail;
    }

    public static final StCellBigTail toPbNonNull(CommonCellBigTail commonCellBigTail) {
        return new StCellBigTail(commonCellBigTail.getType(), commonCellBigTail.getDesc(), commonCellBigTail.getBrightIcon(), commonCellBigTail.getDarkIcon(), commonCellBigTail.getActionUrl());
    }

    public static final CommonCellBigTail toCommon(StCellBigTail stCellBigTail) {
        if (stCellBigTail == null) {
            return null;
        }
        CommonCellBigTail commonCellBigTail = new CommonCellBigTail();
        commonCellBigTail.setType(stCellBigTail.type);
        commonCellBigTail.setDesc(stCellBigTail.desc);
        commonCellBigTail.setBrightIcon(stCellBigTail.brightIcon);
        commonCellBigTail.setDarkIcon(stCellBigTail.darkIcon);
        commonCellBigTail.setActionUrl(stCellBigTail.actionUrl);
        return commonCellBigTail;
    }

    public static final StCellBigTail toPb(CommonCellBigTail commonCellBigTail) {
        if (commonCellBigTail != null) {
            return new StCellBigTail(commonCellBigTail.getType(), commonCellBigTail.getDesc(), commonCellBigTail.getBrightIcon(), commonCellBigTail.getDarkIcon(), commonCellBigTail.getActionUrl());
        }
        return null;
    }
}
