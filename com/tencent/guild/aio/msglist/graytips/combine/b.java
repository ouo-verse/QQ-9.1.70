package com.tencent.guild.aio.msglist.graytips.combine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.EmojiReplyElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/combine/b;", "Lcom/tencent/guild/aio/msglist/graytips/combine/a;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", "grayTipElement", "", "l", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "", "k", "Lcom/tencent/guild/aio/msglist/graytips/combine/e;", "grayTipMsgData", "j", "preGrayTipMsgData", "curGrayTipMsgData", "i", "Lcom/tencent/guild/aio/msglist/graytips/combine/d;", "combineGrayTipData", "", "g", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends a {
    private final boolean k(List<? extends GuildMsgItem> msgList) {
        AppRuntime peekAppRuntime;
        GrayTipElement grayTipElement;
        EmojiReplyElement emojiReplyElement;
        String guildUserDisplayName;
        boolean z16;
        if (msgList.size() <= 1 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        Context applicationContext = peekAppRuntime.getApplicationContext();
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        List arrayList = new ArrayList(msgList);
        GuildMsgItem guildMsgItem = (GuildMsgItem) arrayList.get(0);
        int size = arrayList.size();
        if (size > 3) {
            arrayList = arrayList.subList(size - 3, size);
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        String selfTinyId = iGPSService.getSelfTinyId();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
            MsgRecord msgRecord = ((GuildMsgItem) arrayList.get(size2)).getMsgRecord();
            ArrayList<MsgElement> arrayList2 = msgRecord.elements;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator<MsgElement> it = msgRecord.elements.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MsgElement next = it.next();
                    if (next != null && (grayTipElement = next.grayTipElement) != null && (emojiReplyElement = grayTipElement.emojiReplyElement) != null) {
                        long j3 = emojiReplyElement.tinyId;
                        if (selfTinyId.equals(String.valueOf(j3))) {
                            guildUserDisplayName = applicationContext.getString(R.string.zmn);
                            Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "context.getString(R.string.combine_gray_tip_self)");
                        } else {
                            guildUserDisplayName = iGPSService.getGuildUserDisplayName(msgRecord.guildId, String.valueOf(j3));
                            Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "service.getGuildUserDisp\u2026                        )");
                        }
                        if (!TextUtils.isEmpty(guildUserDisplayName) && !linkedHashSet.contains(guildUserDisplayName)) {
                            if (sb5.length() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                sb5.append("\u3001");
                            }
                            linkedHashSet.add(guildUserDisplayName);
                            sb5.append(guildUserDisplayName);
                        }
                    }
                }
            }
        }
        if (linkedHashSet.size() == 1 || size > 3) {
            sb6.append(applicationContext.getString(R.string.zmm));
        }
        sb6.append(applicationContext.getString(R.string.zml));
        guildMsgItem.saveExtInfoToExtStr("guild_gray_tips_combine_status", "2");
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "stringBuilderName.toString()");
        guildMsgItem.saveExtInfoToExtStr("guild_gray_tips_combine_name", sb7);
        String sb8 = sb6.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "stringBuilderContent.toString()");
        guildMsgItem.saveExtInfoToExtStr("guild_gray_tips_combine_content", sb8);
        return true;
    }

    private final long l(GrayTipElement grayTipElement) {
        EmojiReplyElement emojiReplyElement = grayTipElement.emojiReplyElement;
        if (emojiReplyElement != null) {
            return emojiReplyElement.msgSeq;
        }
        return -1L;
    }

    @Override // com.tencent.guild.aio.msglist.graytips.combine.a
    public void g(@NotNull d combineGrayTipData) {
        Intrinsics.checkNotNullParameter(combineGrayTipData, "combineGrayTipData");
        List<GuildMsgItem> b16 = combineGrayTipData.b();
        List<GuildMsgItem> arrayList = new ArrayList<>();
        List<GuildMsgItem> arrayList2 = new ArrayList<>();
        if (b16.size() > 5) {
            arrayList = b16.subList(0, 5);
            arrayList2 = b16.subList(5, b16.size());
        }
        if (k(arrayList2)) {
            List<GuildMsgItem> subList = arrayList2.subList(1, arrayList2.size());
            e("1", arrayList);
            e("3", subList);
            return;
        }
        e("1", b16);
    }

    @Override // com.tencent.guild.aio.msglist.graytips.combine.a
    public boolean i(@NotNull e preGrayTipMsgData, @NotNull e curGrayTipMsgData) {
        Intrinsics.checkNotNullParameter(preGrayTipMsgData, "preGrayTipMsgData");
        Intrinsics.checkNotNullParameter(curGrayTipMsgData, "curGrayTipMsgData");
        if (preGrayTipMsgData.getMIndex() + 1 != curGrayTipMsgData.getMIndex()) {
            if (QLog.isColorLevel()) {
                QLog.i("CombineEmojiReplyGrayTipsProcessor", 1, "mIndex not equals. return preIndex = " + preGrayTipMsgData + ".mIndex curIndex = " + curGrayTipMsgData + ".mIndex");
            }
            return false;
        }
        long l3 = l(preGrayTipMsgData.getGrayTipElement());
        long l16 = l(curGrayTipMsgData.getGrayTipElement());
        if (QLog.isColorLevel()) {
            QLog.i("CombineEmojiReplyGrayTipsProcessor", 1, "isContinuousMsg preJumpTargetMsgSeq = " + l3 + " curJumpTargetMsgSeq = " + l16);
        }
        if (l3 != -1 && l3 == l16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.aio.msglist.graytips.combine.a
    public boolean j(@NotNull e grayTipMsgData) {
        Intrinsics.checkNotNullParameter(grayTipMsgData, "grayTipMsgData");
        if (grayTipMsgData.getGrayTipElement().subElementType == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.aio.msglist.graytips.combine.a, com.tencent.guild.aio.msglist.graytips.combine.f
    public void onDestroy() {
        super.onDestroy();
    }
}
