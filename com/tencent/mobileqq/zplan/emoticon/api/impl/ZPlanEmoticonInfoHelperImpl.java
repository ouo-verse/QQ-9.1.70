package com.tencent.mobileqq.zplan.emoticon.api.impl;

import com.tencent.mobileqq.data.ZPlanPicExtraData;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.zplan.emoticon.ZPlanEmoticonInfo;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import com.tencent.qqnt.kernel.nativeinterface.EmojiZPlan;
import com.tencent.qqnt.msg.data.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/impl/ZPlanEmoticonInfoHelperImpl;", "Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonInfoHelper;", "Lcom/tencent/mobileqq/data/ZPlanPicExtraData;", "data", "Lcom/tencent/qqnt/msg/data/g;", "parseZPlanPicExtraDataToPb", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoInfo", "", "isZPlanEmoticonType", "", "getZPlanEmoPath", "getZPlanPicExtBizInfo", "getZPlanEmoTextSummary", "pageName", "", "setEmoticonNextOpenPage", "getEmoticonNextOpenPage", "isShowing", "setIsShoppingCartShowing", "nextOpenPageName", "Ljava/lang/String;", "isShoppingCartShowing", "Z", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonInfoHelperImpl implements IZPlanEmoticonInfoHelper {
    private boolean isShoppingCartShowing;
    private String nextOpenPageName;

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper
    public String getEmoticonNextOpenPage() {
        if (this.isShoppingCartShowing) {
            return "\u52a8\u4f5c";
        }
        return this.nextOpenPageName;
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper
    public String getZPlanEmoPath(EmoticonInfo emoInfo) {
        if (emoInfo instanceof ZPlanEmoticonInfo) {
            return ((ZPlanEmoticonInfo) emoInfo).getPath();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper
    public String getZPlanEmoTextSummary(EmoticonInfo emoInfo) {
        if (!(emoInfo instanceof ZPlanEmoticonInfo)) {
            return null;
        }
        return "[" + ((ZPlanEmoticonInfo) emoInfo).getEmoticonOrActionName() + "]";
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper
    public g getZPlanPicExtBizInfo(EmoticonInfo emoInfo) {
        Intrinsics.checkNotNullParameter(emoInfo, "emoInfo");
        if (emoInfo instanceof ZPlanEmoticonInfo) {
            return parseZPlanPicExtraDataToPb(((ZPlanEmoticonInfo) emoInfo).getZPlanPicExtraData());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper
    public boolean isZPlanEmoticonType(EmoticonInfo emoInfo) {
        return emoInfo instanceof ZPlanEmoticonInfo;
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper
    public void setEmoticonNextOpenPage(String pageName) {
        this.nextOpenPageName = pageName;
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper
    public void setIsShoppingCartShowing(boolean isShowing) {
        this.isShoppingCartShowing = isShowing;
    }

    private final g parseZPlanPicExtraDataToPb(ZPlanPicExtraData data) {
        if (data == null) {
            return null;
        }
        g gVar = new g(null, null, null, null, null, null, 0, 127, null);
        int id5 = data.getId();
        String name = data.getName();
        int actionType = data.getActionType();
        int playNumber = data.getPlayNumber();
        long peerUin = data.getPeerUin();
        String reserveInfo = data.getReserveInfo();
        if (reserveInfo == null) {
            reserveInfo = "";
        }
        gVar.i(new EmojiZPlan(id5, name, actionType, playNumber, peerUin, reserveInfo));
        return gVar;
    }
}
