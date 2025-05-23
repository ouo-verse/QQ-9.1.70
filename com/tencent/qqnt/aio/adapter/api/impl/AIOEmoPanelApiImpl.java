package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi;
import com.tencent.qqnt.aio.adapter.emoticon.NTEmoticonPanelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoPanelApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoPanelApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/api/e;", "getPanelProvider", "", "emoticon", "Lcom/tencent/mobileqq/data/Emoticon;", "convertToNtEmoticon", "markFaceMessage", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "convertToNtMarkFaceMessage", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "source", "", "emoType", "", "openAIOEmoPanel", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOEmoPanelApiImpl implements IAIOEmoPanelApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi
    public Emoticon convertToNtEmoticon(Object emoticon) {
        boolean z16 = emoticon instanceof Emoticon;
        if (z16) {
            return (Emoticon) emoticon;
        }
        if (!z16) {
            return null;
        }
        Emoticon emoticon2 = new Emoticon();
        Emoticon emoticon3 = (Emoticon) emoticon;
        emoticon2.eId = emoticon3.eId;
        emoticon2.epId = emoticon3.epId;
        emoticon2.name = emoticon3.name;
        emoticon2.encryptKey = emoticon3.encryptKey;
        emoticon2.isSound = emoticon3.isSound;
        emoticon2.width = emoticon3.width;
        emoticon2.height = emoticon3.height;
        emoticon2.value = emoticon3.value;
        emoticon2.magicValue = emoticon3.magicValue;
        emoticon2.jobType = emoticon3.jobType;
        emoticon2.keyword = emoticon3.keyword;
        emoticon2.keywords = emoticon3.keywords;
        emoticon2.character = emoticon3.character;
        emoticon2.extensionWidth = emoticon3.extensionWidth;
        emoticon2.extensionHeight = emoticon3.extensionHeight;
        emoticon2.businessExtra = emoticon3.businessExtra;
        emoticon2.isAPNG = emoticon3.isAPNG;
        emoticon2.ipsiteUrl = emoticon3.ipsiteUrl;
        emoticon2.ipsiteName = emoticon3.ipsiteName;
        emoticon2.exposeNum = emoticon3.exposeNum;
        emoticon2.clickNum = emoticon3.clickNum;
        emoticon2.voicePrint = emoticon3.voicePrint;
        emoticon2.backColor = emoticon3.backColor;
        emoticon2.volumeColor = emoticon3.volumeColor;
        emoticon2.voicePrintItems = emoticon3.voicePrintItems;
        return emoticon2;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi
    public MarkFaceMessage convertToNtMarkFaceMessage(Object markFaceMessage) {
        boolean z16 = markFaceMessage instanceof MarkFaceMessage;
        if (z16) {
            return (MarkFaceMessage) markFaceMessage;
        }
        if (!z16) {
            return null;
        }
        MarkFaceMessage markFaceMessage2 = new MarkFaceMessage();
        MarkFaceMessage markFaceMessage3 = (MarkFaceMessage) markFaceMessage;
        markFaceMessage2.index = markFaceMessage3.index;
        markFaceMessage2.faceName = markFaceMessage3.faceName;
        markFaceMessage2.dwMSGItemType = markFaceMessage3.dwMSGItemType;
        markFaceMessage2.cFaceInfo = markFaceMessage3.cFaceInfo;
        markFaceMessage2.wSize = markFaceMessage3.wSize;
        markFaceMessage2.sbufID = markFaceMessage3.sbufID;
        markFaceMessage2.dwTabID = markFaceMessage3.dwTabID;
        markFaceMessage2.cSubType = markFaceMessage3.cSubType;
        markFaceMessage2.sbfKey = markFaceMessage3.sbfKey;
        markFaceMessage2.mediaType = markFaceMessage3.mediaType;
        markFaceMessage2.imageWidth = markFaceMessage3.imageWidth;
        markFaceMessage2.imageHeight = markFaceMessage3.imageHeight;
        markFaceMessage2.mobileparam = markFaceMessage3.mobileparam;
        markFaceMessage2.resvAttr = markFaceMessage3.resvAttr;
        markFaceMessage2.isReword = markFaceMessage3.isReword;
        markFaceMessage2.copywritingType = markFaceMessage3.copywritingType;
        markFaceMessage2.copywritingContent = markFaceMessage3.copywritingContent;
        markFaceMessage2.jumpUrl = markFaceMessage3.jumpUrl;
        markFaceMessage2.shouldDisplay = markFaceMessage3.shouldDisplay;
        markFaceMessage2.beginTime = markFaceMessage3.beginTime;
        markFaceMessage2.endTime = markFaceMessage3.endTime;
        markFaceMessage2.from = markFaceMessage3.from;
        markFaceMessage2.isAPNG = markFaceMessage3.isAPNG;
        markFaceMessage2.hasIpProduct = markFaceMessage3.hasIpProduct;
        markFaceMessage2.showIpProduct = markFaceMessage3.showIpProduct;
        markFaceMessage2.voicePrintItems = markFaceMessage3.voicePrintItems;
        markFaceMessage2.backColor = markFaceMessage3.backColor;
        markFaceMessage2.volumeColor = markFaceMessage3.volumeColor;
        markFaceMessage2.supportSize = markFaceMessage3.supportSize;
        markFaceMessage2.apngSupportSize = markFaceMessage3.apngSupportSize;
        return markFaceMessage2;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi
    public com.tencent.qqnt.aio.api.e getPanelProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new NTEmoticonPanelProvider(context);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi
    public void openAIOEmoPanel(com.tencent.aio.api.runtime.a aioContext, String source, int emoType) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(source, "source");
        com.tencent.mvi.base.route.j e16 = aioContext.e();
        if (e16 != null) {
            e16.h(new EmotionPanelMsgIntent.SetEmotionPanelDefaultType(emoType));
        }
        com.tencent.mvi.base.route.j e17 = aioContext.e();
        if (e17 != null) {
            e17.h(new PanelContainerMsgIntent.ShowPanelMsgIntent(source, 1001, false, 0, 12, null));
        }
    }
}
