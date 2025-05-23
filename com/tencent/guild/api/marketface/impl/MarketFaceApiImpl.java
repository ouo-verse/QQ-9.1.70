package com.tencent.guild.api.marketface.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.marketface.IMarketFaceApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.NTOperateUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J#\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J3\u0010%\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J5\u0010*\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J+\u0010,\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u001fJ#\u0010-\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u001cH\u0002J#\u00101\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102J#\u00103\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00104J&\u00108\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u00109\u001a\u00020\u0011H\u0002J\b\u0010:\u001a\u00020\u0011H\u0002J \u0010;\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u0015H\u0002J\u0018\u0010<\u001a\u0002072\u0006\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u0010=\u001a\u00020\u0019H\u0002J!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010\u000e\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010@J3\u0010C\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010B\u001a\u00020A2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010DJ#\u0010F\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010\u001bJ+\u00101\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010GR\u0014\u0010H\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010I\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006O"}, d2 = {"Lcom/tencent/guild/api/marketface/impl/MarketFaceApiImpl;", "Lcom/tencent/guild/api/marketface/IMarketFaceApi;", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "emoticonInfo", "Lmr0/a;", "createEmoInfo", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "msgId", "", "checkIsLastMsg", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "markFaceMessage", "queryEmoticonInfoFromDB", "Lkotlin/Pair;", "", "calculateMarketFaceViewSize", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getAppRuntime", "", "getCurThreadName", "Landroid/content/Context;", "context", "", "handleEmoAdd", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/data/EmoticonPackage;", "emoPackage", "processEmoAuth", "(Landroid/content/Context;Lcom/tencent/mobileqq/data/EmoticonPackage;Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNeedDownloadEmoticonInfoJson", "authCode", "Lcom/tencent/mobileqq/data/Emoticon;", "emoticon", "tips", "handleAuthResult", "(ILandroid/content/Context;Lcom/tencent/mobileqq/data/Emoticon;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "title", "msg", "showCustomMarketFaceTips", "(Landroid/content/Context;Lcom/tencent/mobileqq/data/Emoticon;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEmoAuthIfNeed", "handleEmoAuth", "(Landroid/content/Context;Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emoPkg", "parseEmotionType", "addEmotionToFavoriteAndTip", "(Landroid/content/Context;Lcom/tencent/mobileqq/data/Emoticon;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showTip", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", EmojiManagerServiceProxy.EPID, "eId", "Lcom/tencent/mobileqq/data/CustomEmotionData;", "queryEmoFromFavPanel", "queryMaxEmoIdFromFavPanel", "calculateAlreadyFavEmoCount", "syncEmoUpload", "createCustomEmoInfo", "saveDownloadTime", "Lcom/tencent/qqnt/msg/api/c;", "fetchMarketFaceInfoSuspend", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/widget/ImageView;", "bubbleIv", "bindMagicMarketFaceToView", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Landroid/widget/ImageView;JLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "addToFavEmo", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sDensity", "I", "tDensity", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl implements IMarketFaceApi {

    @NotNull
    private static final String TAG = "MarketFaceApiImpl";
    private final int sDensity = 320;
    private final int tDensity = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;

    /* JADX INFO: Access modifiers changed from: private */
    public final Object addEmotionToFavoriteAndTip(Context context, Emoticon emoticon, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        QLog.i("MarketFaceApiImpl", 2, "addEmotionToFavorite");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) (appInterface != null ? appInterface.getRuntimeService(IFavroamingDBManagerService.class, "") : null);
        if (iFavroamingDBManagerService == null) {
            return Unit.INSTANCE;
        }
        int calculateAlreadyFavEmoCount = calculateAlreadyFavEmoCount();
        if (calculateAlreadyFavEmoCount >= FavEmoConstant.getAddFavEmoOverLimit()) {
            QLog.d("MarketFaceApiImpl", 1, "[addEmotionToFavoriteAndTip] add fav emo over count limit. currentCount=", Boxing.boxInt(calculateAlreadyFavEmoCount), ", limitCount=", Boxing.boxInt(FavEmoConstant.getAddFavEmoOverLimit()));
            String addFavEmoOverLimitTips = FavEmoConstant.getAddFavEmoOverLimitTips();
            Intrinsics.checkNotNullExpressionValue(addFavEmoOverLimitTips, "getAddFavEmoOverLimitTips()");
            Object showTip = showTip(context, addFavEmoOverLimitTips, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return showTip == coroutine_suspended2 ? showTip : Unit.INSTANCE;
        }
        String str = emoticon.epId;
        Intrinsics.checkNotNullExpressionValue(str, "emoticon.epId");
        String str2 = emoticon.eId;
        Intrinsics.checkNotNullExpressionValue(str2, "emoticon.eId");
        Pair<CustomEmotionData, Integer> queryEmoFromFavPanel = queryEmoFromFavPanel(str, str2);
        if (queryEmoFromFavPanel != null) {
            if (!iFavroamingDBManagerService.updateDeletedEmoticon(queryEmoFromFavPanel.getFirst(), queryEmoFromFavPanel.getSecond().intValue())) {
                Object showTip2 = showTip(context, "\u5df2\u6dfb\u52a0\u8fc7\u8be5\u8868\u60c5", continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (showTip2 == coroutine_suspended) {
                    return showTip2;
                }
            }
            return Unit.INSTANCE;
        }
        String str3 = emoticon.epId;
        Intrinsics.checkNotNullExpressionValue(str3, "emoticon.epId");
        String str4 = emoticon.eId;
        Intrinsics.checkNotNullExpressionValue(str4, "emoticon.eId");
        syncEmoUpload(context, str3, str4);
        return Unit.INSTANCE;
    }

    private final int calculateAlreadyFavEmoCount() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IFavroamingDBManagerService.class, "");
        }
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) iRuntimeService;
        int i3 = 0;
        if (iFavroamingDBManagerService == null) {
            return 0;
        }
        List<CustomEmotionData> list = iFavroamingDBManagerService.getEmoticonDataList();
        Intrinsics.checkNotNullExpressionValue(list, "list");
        for (CustomEmotionData customEmotionData : list) {
            if (TextUtils.isEmpty(customEmotionData.RomaingType) || !Intrinsics.areEqual("needDel", customEmotionData.RomaingType)) {
                i3++;
            }
        }
        return i3;
    }

    private final Pair<Integer, Integer> calculateMarketFaceViewSize(IPicEmoticonInfo emoticonInfo) {
        int emoWidth;
        if (emoticonInfo == null) {
            return new Pair<>(0, 0);
        }
        int i3 = 200;
        if (emoticonInfo.emoWidth() == 0) {
            emoWidth = 200;
        } else {
            emoWidth = emoticonInfo.emoWidth();
        }
        if (emoticonInfo.emoHeight() != 0) {
            i3 = emoticonInfo.emoHeight();
        }
        if (emoticonInfo.emoExtWidth() != 0 && emoticonInfo.emoExtHeight() != 0) {
            emoWidth = emoticonInfo.emoExtWidth();
            i3 = emoticonInfo.emoExtHeight();
        }
        if (emoWidth != i3) {
            emoWidth = i3;
        }
        int i16 = this.tDensity;
        int i17 = this.sDensity;
        int i18 = ((emoWidth * i16) + (i17 >> 1)) / i17;
        int i19 = ((i3 * i16) + (i17 >> 1)) / i17;
        QLog.i("MarketFaceApiImpl", 4, "calculateMarketFaceViewSize width=" + i18 + " height=" + i19);
        return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkIsLastMsg(Contact contact, long j3, Continuation<? super Boolean> continuation) {
        MarketFaceApiImpl$checkIsLastMsg$1 marketFaceApiImpl$checkIsLastMsg$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof MarketFaceApiImpl$checkIsLastMsg$1) {
            marketFaceApiImpl$checkIsLastMsg$1 = (MarketFaceApiImpl$checkIsLastMsg$1) continuation;
            int i16 = marketFaceApiImpl$checkIsLastMsg$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                marketFaceApiImpl$checkIsLastMsg$1.label = i16 - Integer.MIN_VALUE;
                obj = marketFaceApiImpl$checkIsLastMsg$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = marketFaceApiImpl$checkIsLastMsg$1.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        j3 = marketFaceApiImpl$checkIsLastMsg$1.J$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    NTOperateUtils nTOperateUtils = NTOperateUtils.f359554a;
                    marketFaceApiImpl$checkIsLastMsg$1.J$0 = j3;
                    marketFaceApiImpl$checkIsLastMsg$1.label = 1;
                    obj = nTOperateUtils.g(contact, marketFaceApiImpl$checkIsLastMsg$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (j3 < ((MsgRecord) obj).msgId) {
                    z16 = false;
                }
                return Boxing.boxBoolean(z16);
            }
        }
        marketFaceApiImpl$checkIsLastMsg$1 = new MarketFaceApiImpl$checkIsLastMsg$1(this, continuation);
        obj = marketFaceApiImpl$checkIsLastMsg$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = marketFaceApiImpl$checkIsLastMsg$1.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        if (j3 < ((MsgRecord) obj).msgId) {
        }
        return Boxing.boxBoolean(z162);
    }

    private final CustomEmotionData createCustomEmoInfo(String epId, String eId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16;
        CustomEmotionData customEmotionData = new CustomEmotionData();
        customEmotionData.uin = getAppRuntime().getCurrentAccountUin();
        customEmotionData.emoId = queryMaxEmoIdFromFavPanel() + 1;
        customEmotionData.isMarkFace = true;
        customEmotionData.emoPath = epId;
        customEmotionData.eId = eId;
        customEmotionData.checkMarketFace("addEmotionToFavorite");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        EmoticonPackage emoticonPackage = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IEmoticonManagerService.class, "");
        } else {
            iRuntimeService = null;
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) iRuntimeService;
        if (iEmoticonManagerService != null) {
            emoticonPackage = iEmoticonManagerService.syncFindEmoticonPackageById(epId);
        }
        if (emoticonPackage != null) {
            if (emoticonPackage.isAPNG == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            customEmotionData.isAPNG = z16;
        }
        QLog.i("MarketFaceApiImpl", 1, "createCustomEmoInfo " + customEmotionData);
        return customEmotionData;
    }

    private final mr0.a createEmoInfo(IPicEmoticonInfo emoticonInfo) {
        URLDrawable uRLDrawable;
        int i3;
        if (emoticonInfo != null) {
            uRLDrawable = emoticonInfo.getLoadingDrawable(EmotionConstants.FROM_AIO);
        } else {
            uRLDrawable = null;
        }
        Pair<Integer, Integer> calculateMarketFaceViewSize = calculateMarketFaceViewSize(emoticonInfo);
        int intValue = calculateMarketFaceViewSize.component1().intValue();
        int intValue2 = calculateMarketFaceViewSize.component2().intValue();
        if (emoticonInfo != null) {
            i3 = emoticonInfo.getImageJobType();
        } else {
            i3 = 0;
        }
        return new mr0.a(uRLDrawable, i3, new Pair(Integer.valueOf(intValue), Integer.valueOf(intValue2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseQQAppInterface getAppRuntime() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        return (BaseQQAppInterface) peekAppRuntime;
    }

    private final String getCurThreadName() {
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "currentThread().name");
        return name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleAuthResult(int i3, Context context, Emoticon emoticon, String str, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        QLog.i("MarketFaceApiImpl", 1, "handleAuthResult authCode=" + i3 + " tips=" + str);
        if (i3 == 0) {
            Object addEmotionToFavoriteAndTip = addEmotionToFavoriteAndTip(context, emoticon, continuation);
            coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (addEmotionToFavoriteAndTip == coroutine_suspended3) {
                return addEmotionToFavoriteAndTip;
            }
            return Unit.INSTANCE;
        }
        if (i3 < 0) {
            Object showTip = showTip(context, str, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (showTip == coroutine_suspended2) {
                return showTip;
            }
            return Unit.INSTANCE;
        }
        Object showCustomMarketFaceTips = showCustomMarketFaceTips(context, emoticon, "\u6e29\u99a8\u63d0\u793a", str, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (showCustomMarketFaceTips == coroutine_suspended) {
            return showCustomMarketFaceTips;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleEmoAdd(Context context, MarketFaceElement marketFaceElement, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new MarketFaceApiImpl$handleEmoAdd$2(this, marketFaceElement, new Ref.ObjectRef(), context, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleEmoAuth(Context context, IPicEmoticonInfo iPicEmoticonInfo, Continuation<? super Unit> continuation) {
        MarketFaceApiImpl$handleEmoAuth$1 marketFaceApiImpl$handleEmoAuth$1;
        Object coroutine_suspended;
        int i3;
        MarketFaceApiImpl marketFaceApiImpl;
        com.tencent.qqnt.msg.api.c cVar;
        String str;
        if (continuation instanceof MarketFaceApiImpl$handleEmoAuth$1) {
            marketFaceApiImpl$handleEmoAuth$1 = (MarketFaceApiImpl$handleEmoAuth$1) continuation;
            int i16 = marketFaceApiImpl$handleEmoAuth$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                marketFaceApiImpl$handleEmoAuth$1.label = i16 - Integer.MIN_VALUE;
                MarketFaceApiImpl$handleEmoAuth$1 marketFaceApiImpl$handleEmoAuth$12 = marketFaceApiImpl$handleEmoAuth$1;
                Object obj = marketFaceApiImpl$handleEmoAuth$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = marketFaceApiImpl$handleEmoAuth$12.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    iPicEmoticonInfo = (IPicEmoticonInfo) marketFaceApiImpl$handleEmoAuth$12.L$2;
                    context = (Context) marketFaceApiImpl$handleEmoAuth$12.L$1;
                    marketFaceApiImpl = (MarketFaceApiImpl) marketFaceApiImpl$handleEmoAuth$12.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    FavEmoServerApi favEmoServerApi = FavEmoServerApi.f112580a;
                    Emoticon emoticon = iPicEmoticonInfo.getEmoticon();
                    Intrinsics.checkNotNullExpressionValue(emoticon, "emoticonInfo.emoticon");
                    marketFaceApiImpl$handleEmoAuth$12.L$0 = this;
                    marketFaceApiImpl$handleEmoAuth$12.L$1 = context;
                    marketFaceApiImpl$handleEmoAuth$12.L$2 = iPicEmoticonInfo;
                    marketFaceApiImpl$handleEmoAuth$12.label = 1;
                    obj = favEmoServerApi.f(emoticon, marketFaceApiImpl$handleEmoAuth$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    marketFaceApiImpl = this;
                }
                cVar = (com.tencent.qqnt.msg.api.c) obj;
                QLog.i("MarketFaceApiImpl", 1, "handleEmoAuth threadName=" + marketFaceApiImpl.getCurThreadName() + " authResult=" + cVar);
                if (!cVar.d()) {
                    int i17 = ((EmoticonResp) cVar.a()).delEpId;
                    String str2 = ((EmoticonResp) cVar.a()).keySeq;
                    if (str2 != null && str2.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        str = "\u4f60\u6682\u65f6\u6ca1\u6709\u6b64\u8868\u60c5\u7684\u6743\u9650\u3002";
                    } else {
                        str = ((EmoticonResp) cVar.a()).keySeq;
                    }
                    String message = str;
                    Emoticon emoticon2 = iPicEmoticonInfo.getEmoticon();
                    Intrinsics.checkNotNullExpressionValue(emoticon2, "emoticonInfo.emoticon");
                    Intrinsics.checkNotNullExpressionValue(message, "message");
                    marketFaceApiImpl$handleEmoAuth$12.L$0 = null;
                    marketFaceApiImpl$handleEmoAuth$12.L$1 = null;
                    marketFaceApiImpl$handleEmoAuth$12.L$2 = null;
                    marketFaceApiImpl$handleEmoAuth$12.label = 2;
                    if (marketFaceApiImpl.handleAuthResult(i17, context, emoticon2, message, marketFaceApiImpl$handleEmoAuth$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                String b16 = cVar.b();
                marketFaceApiImpl$handleEmoAuth$12.L$0 = null;
                marketFaceApiImpl$handleEmoAuth$12.L$1 = null;
                marketFaceApiImpl$handleEmoAuth$12.L$2 = null;
                marketFaceApiImpl$handleEmoAuth$12.label = 3;
                if (marketFaceApiImpl.showTip(context, b16, marketFaceApiImpl$handleEmoAuth$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        marketFaceApiImpl$handleEmoAuth$1 = new MarketFaceApiImpl$handleEmoAuth$1(this, continuation);
        MarketFaceApiImpl$handleEmoAuth$1 marketFaceApiImpl$handleEmoAuth$122 = marketFaceApiImpl$handleEmoAuth$1;
        Object obj2 = marketFaceApiImpl$handleEmoAuth$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = marketFaceApiImpl$handleEmoAuth$122.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        cVar = (com.tencent.qqnt.msg.api.c) obj2;
        QLog.i("MarketFaceApiImpl", 1, "handleEmoAuth threadName=" + marketFaceApiImpl.getCurThreadName() + " authResult=" + cVar);
        if (!cVar.d()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleEmoAuthIfNeed(Context context, EmoticonPackage emoticonPackage, IPicEmoticonInfo iPicEmoticonInfo, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        QLog.i("MarketFaceApiImpl", 1, "handleEmoAuthIfNeed PayType=" + emoticonPackage.mobileFeetype);
        if (emoticonPackage.mobileFeetype == 1) {
            Emoticon emoticon = iPicEmoticonInfo.getEmoticon();
            Intrinsics.checkNotNullExpressionValue(emoticon, "emoticonInfo.emoticon");
            Object addEmotionToFavoriteAndTip = addEmotionToFavoriteAndTip(context, emoticon, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (addEmotionToFavoriteAndTip == coroutine_suspended2) {
                return addEmotionToFavoriteAndTip;
            }
            return Unit.INSTANCE;
        }
        Object handleEmoAuth = handleEmoAuth(context, iPicEmoticonInfo, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (handleEmoAuth == coroutine_suspended) {
            return handleEmoAuth;
        }
        return Unit.INSTANCE;
    }

    private final boolean isNeedDownloadEmoticonInfoJson(EmoticonPackage emoPackage) {
        if (emoPackage != null && !TextUtils.isEmpty(emoPackage.name) && emoPackage.mobileFeetype != 0 && emoPackage.downloadCount != 0) {
            SharedPreferences preferences = getAppRuntime().getPreferences();
            Intrinsics.checkNotNullExpressionValue(preferences, "getAppRuntime().preferences");
            int i3 = preferences.getInt("emosm_json_last_download_timestamp", 0);
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis - i3 <= 86400 && currentTimeMillis >= i3) {
                return false;
            }
            QLog.i("MarketFaceApiImpl", 1, "EmoticonPackage expire");
            return true;
        }
        QLog.i("MarketFaceApiImpl", 1, "EmoticonPackage invalid");
        return true;
    }

    private final int parseEmotionType(EmoticonPackage emoPkg) {
        if (emoPkg != null) {
            int i3 = emoPkg.jobType;
            if (3 != i3 && 5 != i3) {
                return 1;
            }
            return 2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processEmoAuth(Context context, EmoticonPackage emoticonPackage, IPicEmoticonInfo iPicEmoticonInfo, Continuation<? super Unit> continuation) {
        MarketFaceApiImpl$processEmoAuth$1 marketFaceApiImpl$processEmoAuth$1;
        Object coroutine_suspended;
        int i3;
        MarketFaceApiImpl marketFaceApiImpl;
        com.tencent.qqnt.msg.api.c cVar;
        if (continuation instanceof MarketFaceApiImpl$processEmoAuth$1) {
            marketFaceApiImpl$processEmoAuth$1 = (MarketFaceApiImpl$processEmoAuth$1) continuation;
            int i16 = marketFaceApiImpl$processEmoAuth$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                marketFaceApiImpl$processEmoAuth$1.label = i16 - Integer.MIN_VALUE;
                Object obj = marketFaceApiImpl$processEmoAuth$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = marketFaceApiImpl$processEmoAuth$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    iPicEmoticonInfo = (IPicEmoticonInfo) marketFaceApiImpl$processEmoAuth$1.L$2;
                    context = (Context) marketFaceApiImpl$processEmoAuth$1.L$1;
                    marketFaceApiImpl = (MarketFaceApiImpl) marketFaceApiImpl$processEmoAuth$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    cVar = (com.tencent.qqnt.msg.api.c) obj;
                    QLog.i("MarketFaceApiImpl", 2, "DownloadEmoticonJson result=" + cVar);
                    if (cVar.c() != 0) {
                        marketFaceApiImpl.saveDownloadTime();
                        EmoticonPackage emoticonPackage2 = (EmoticonPackage) cVar.a();
                        marketFaceApiImpl$processEmoAuth$1.L$0 = null;
                        marketFaceApiImpl$processEmoAuth$1.L$1 = null;
                        marketFaceApiImpl$processEmoAuth$1.L$2 = null;
                        marketFaceApiImpl$processEmoAuth$1.label = 2;
                        if (marketFaceApiImpl.handleEmoAuthIfNeed(context, emoticonPackage2, iPicEmoticonInfo, marketFaceApiImpl$processEmoAuth$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    marketFaceApiImpl$processEmoAuth$1.L$0 = null;
                    marketFaceApiImpl$processEmoAuth$1.L$1 = null;
                    marketFaceApiImpl$processEmoAuth$1.L$2 = null;
                    marketFaceApiImpl$processEmoAuth$1.label = 3;
                    if (marketFaceApiImpl.showTip(context, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", marketFaceApiImpl$processEmoAuth$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                boolean isNeedDownloadEmoticonInfoJson = isNeedDownloadEmoticonInfoJson(emoticonPackage);
                QLog.i("MarketFaceApiImpl", 1, "processEmoAuth isNeedDownload=" + isNeedDownloadEmoticonInfoJson);
                if (isNeedDownloadEmoticonInfoJson) {
                    FavEmoServerApi favEmoServerApi = FavEmoServerApi.f112580a;
                    String epid = iPicEmoticonInfo.getEpid();
                    Intrinsics.checkNotNullExpressionValue(epid, "emoticonInfo.epid");
                    marketFaceApiImpl$processEmoAuth$1.L$0 = this;
                    marketFaceApiImpl$processEmoAuth$1.L$1 = context;
                    marketFaceApiImpl$processEmoAuth$1.L$2 = iPicEmoticonInfo;
                    marketFaceApiImpl$processEmoAuth$1.label = 1;
                    obj = favEmoServerApi.g(epid, marketFaceApiImpl$processEmoAuth$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    marketFaceApiImpl = this;
                    cVar = (com.tencent.qqnt.msg.api.c) obj;
                    QLog.i("MarketFaceApiImpl", 2, "DownloadEmoticonJson result=" + cVar);
                    if (cVar.c() != 0) {
                    }
                } else {
                    marketFaceApiImpl$processEmoAuth$1.label = 4;
                    if (handleEmoAuthIfNeed(context, emoticonPackage, iPicEmoticonInfo, marketFaceApiImpl$processEmoAuth$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
        }
        marketFaceApiImpl$processEmoAuth$1 = new MarketFaceApiImpl$processEmoAuth$1(this, continuation);
        Object obj2 = marketFaceApiImpl$processEmoAuth$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = marketFaceApiImpl$processEmoAuth$1.label;
        if (i3 == 0) {
        }
    }

    private final Pair<CustomEmotionData, Integer> queryEmoFromFavPanel(String epId, String eId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IFavroamingDBManagerService.class, "");
        } else {
            iRuntimeService = null;
        }
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) iRuntimeService;
        if (iFavroamingDBManagerService == null) {
            return null;
        }
        List<CustomEmotionData> list = iFavroamingDBManagerService.getEmoticonDataList();
        Intrinsics.checkNotNullExpressionValue(list, "list");
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CustomEmotionData customEmotionData = (CustomEmotionData) obj;
            if (customEmotionData.isMarkFace && Intrinsics.areEqual(customEmotionData.emoPath, epId) && Intrinsics.areEqual(customEmotionData.eId, eId)) {
                QLog.i("MarketFaceApiImpl", 1, "queryEmoFromFavPanel emoName=" + customEmotionData.eId + " index=" + i3);
                return new Pair<>(customEmotionData, Integer.valueOf(i3));
            }
            i3 = i16;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPicEmoticonInfo queryEmoticonInfoFromDB(MarketFaceElement markFaceMessage) {
        IRuntimeService runtimeService = getAppRuntime().getRuntimeService(IEmoticonManagerService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppRuntime().getRunti\u2026nagerService::class.java)");
        return (IPicEmoticonInfo) ((IEmoticonManagerService) runtimeService).syncGetEmoticonInfo(c.f112587a.d(markFaceMessage));
    }

    private final int queryMaxEmoIdFromFavPanel() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IFavroamingDBManagerService.class, "");
        }
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) iRuntimeService;
        int i3 = 1;
        if (iFavroamingDBManagerService == null) {
            return 1;
        }
        List<CustomEmotionData> list = iFavroamingDBManagerService.getEmoticonDataList();
        Intrinsics.checkNotNullExpressionValue(list, "list");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int i16 = ((CustomEmotionData) it.next()).emoId;
            if (i3 < i16) {
                i3 = i16;
            }
        }
        return i3;
    }

    private final void saveDownloadTime() {
        SharedPreferences preferences = getAppRuntime().getPreferences();
        Intrinsics.checkNotNullExpressionValue(preferences, "getAppRuntime().preferences");
        preferences.edit().putInt("emosm_json_last_download_timestamp", (int) (System.currentTimeMillis() / 1000)).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showCustomMarketFaceTips(Context context, Emoticon emoticon, String str, String str2, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new MarketFaceApiImpl$showCustomMarketFaceTips$2(context, str, str2, emoticon, this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showTip(Context context, String str, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new MarketFaceApiImpl$showTip$2(str, context, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    private final void syncEmoUpload(Context context, String epId, String eId) {
        QLog.i("MarketFaceApiImpl", 1, "syncEmoUpload epId=" + epId + " eId=" + eId);
        ((IMarketFaceDiffApi) QRoute.api(IMarketFaceDiffApi.class)).syncUpload(context, createCustomEmoInfo(epId, eId));
    }

    @Override // com.tencent.guild.api.marketface.IMarketFaceApi
    @Nullable
    public Object addToFavEmo(@NotNull Context context, @NotNull MarketFaceElement marketFaceElement, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (!NetworkUtil.isNetworkAvailable(context)) {
            Object showTip = showTip(context, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (showTip == coroutine_suspended2) {
                return showTip;
            }
            return Unit.INSTANCE;
        }
        Object handleEmoAdd = handleEmoAdd(context, marketFaceElement, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (handleEmoAdd == coroutine_suspended) {
            return handleEmoAdd;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.tencent.guild.api.marketface.IMarketFaceApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object bindMagicMarketFaceToView(@NotNull MarketFaceElement marketFaceElement, @NotNull ImageView imageView, long j3, @NotNull Contact contact, @NotNull Continuation<? super Unit> continuation) {
        MarketFaceApiImpl$bindMagicMarketFaceToView$1 marketFaceApiImpl$bindMagicMarketFaceToView$1;
        Object coroutine_suspended;
        int i3;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef objectRef;
        MarketFaceElement marketFaceElement2;
        ImageView imageView2;
        long j16;
        byte[] bArr;
        T t16;
        Emoticon emoticon;
        if (continuation instanceof MarketFaceApiImpl$bindMagicMarketFaceToView$1) {
            marketFaceApiImpl$bindMagicMarketFaceToView$1 = (MarketFaceApiImpl$bindMagicMarketFaceToView$1) continuation;
            int i16 = marketFaceApiImpl$bindMagicMarketFaceToView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                marketFaceApiImpl$bindMagicMarketFaceToView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = marketFaceApiImpl$bindMagicMarketFaceToView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = marketFaceApiImpl$bindMagicMarketFaceToView$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        long j17 = marketFaceApiImpl$bindMagicMarketFaceToView$1.J$0;
                        Ref.ObjectRef objectRef2 = (Ref.ObjectRef) marketFaceApiImpl$bindMagicMarketFaceToView$1.L$3;
                        Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) marketFaceApiImpl$bindMagicMarketFaceToView$1.L$2;
                        ImageView imageView3 = (ImageView) marketFaceApiImpl$bindMagicMarketFaceToView$1.L$1;
                        marketFaceElement2 = (MarketFaceElement) marketFaceApiImpl$bindMagicMarketFaceToView$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        objectRef = objectRef2;
                        booleanRef = booleanRef2;
                        imageView2 = imageView3;
                        j16 = j17;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    booleanRef = new Ref.BooleanRef();
                    objectRef = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    MarketFaceApiImpl$bindMagicMarketFaceToView$2 marketFaceApiImpl$bindMagicMarketFaceToView$2 = new MarketFaceApiImpl$bindMagicMarketFaceToView$2(objectRef, this, marketFaceElement, booleanRef, contact, j3, null);
                    marketFaceApiImpl$bindMagicMarketFaceToView$1.L$0 = marketFaceElement;
                    marketFaceApiImpl$bindMagicMarketFaceToView$1.L$1 = imageView;
                    marketFaceApiImpl$bindMagicMarketFaceToView$1.L$2 = booleanRef;
                    marketFaceApiImpl$bindMagicMarketFaceToView$1.L$3 = objectRef;
                    marketFaceApiImpl$bindMagicMarketFaceToView$1.J$0 = j3;
                    marketFaceApiImpl$bindMagicMarketFaceToView$1.label = 1;
                    if (BuildersKt.withContext(io5, marketFaceApiImpl$bindMagicMarketFaceToView$2, marketFaceApiImpl$bindMagicMarketFaceToView$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    marketFaceElement2 = marketFaceElement;
                    imageView2 = imageView;
                    j16 = j3;
                }
                bArr = marketFaceElement2.mobileParam;
                if (bArr == null) {
                    bArr = new byte[0];
                }
                String str = new String(bArr, Charsets.UTF_8);
                t16 = objectRef.element;
                if (t16 != 0) {
                    IPicEmoticonInfo iPicEmoticonInfo = (IPicEmoticonInfo) t16;
                    if (iPicEmoticonInfo != null) {
                        emoticon = iPicEmoticonInfo.getEmoticon();
                    } else {
                        emoticon = null;
                    }
                    if (emoticon != null) {
                        ((IMarketFaceDiffApi) QRoute.api(IMarketFaceDiffApi.class)).bindView(j16, imageView2, str, (IPicEmoticonInfo) objectRef.element, booleanRef.element);
                        return Unit.INSTANCE;
                    }
                }
                QLog.i("MarketFaceApiImpl", 1, "Emoticon empty");
                return Unit.INSTANCE;
            }
        }
        marketFaceApiImpl$bindMagicMarketFaceToView$1 = new MarketFaceApiImpl$bindMagicMarketFaceToView$1(this, continuation);
        Object obj2 = marketFaceApiImpl$bindMagicMarketFaceToView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = marketFaceApiImpl$bindMagicMarketFaceToView$1.label;
        if (i3 == 0) {
        }
        bArr = marketFaceElement2.mobileParam;
        if (bArr == null) {
        }
        String str2 = new String(bArr, Charsets.UTF_8);
        t16 = objectRef.element;
        if (t16 != 0) {
        }
        QLog.i("MarketFaceApiImpl", 1, "Emoticon empty");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.guild.api.marketface.IMarketFaceApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchMarketFaceInfoSuspend(@NotNull MarketFaceElement marketFaceElement, @NotNull Continuation<? super com.tencent.qqnt.msg.api.c<mr0.a>> continuation) {
        MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1 marketFaceApiImpl$fetchMarketFaceInfoSuspend$1;
        Object coroutine_suspended;
        int i3;
        MarketFaceApiImpl marketFaceApiImpl;
        Ref.ObjectRef objectRef;
        T t16;
        String str;
        if (continuation instanceof MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1) {
            marketFaceApiImpl$fetchMarketFaceInfoSuspend$1 = (MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1) continuation;
            int i16 = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label = i16 - Integer.MIN_VALUE;
                Object obj = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label;
                int i17 = 1;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.L$1;
                        marketFaceApiImpl = (MarketFaceApiImpl) marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2 marketFaceApiImpl$fetchMarketFaceInfoSuspend$2 = new MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2(objectRef2, this, marketFaceElement, null);
                    marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.L$0 = this;
                    marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.L$1 = objectRef2;
                    marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label = 1;
                    if (BuildersKt.withContext(io5, marketFaceApiImpl$fetchMarketFaceInfoSuspend$2, marketFaceApiImpl$fetchMarketFaceInfoSuspend$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    marketFaceApiImpl = this;
                    objectRef = objectRef2;
                }
                mr0.a createEmoInfo = marketFaceApiImpl.createEmoInfo((IPicEmoticonInfo) objectRef.element);
                t16 = objectRef.element;
                if (t16 != 0) {
                    i17 = 0;
                }
                if (t16 != 0) {
                    str = "emoticonInfo is Empty";
                } else {
                    str = "";
                }
                return new com.tencent.qqnt.msg.api.c(createEmoInfo, i17, str);
            }
        }
        marketFaceApiImpl$fetchMarketFaceInfoSuspend$1 = new MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1(this, continuation);
        Object obj2 = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label;
        int i172 = 1;
        if (i3 == 0) {
        }
        mr0.a createEmoInfo2 = marketFaceApiImpl.createEmoInfo((IPicEmoticonInfo) objectRef.element);
        t16 = objectRef.element;
        if (t16 != 0) {
        }
        if (t16 != 0) {
        }
        return new com.tencent.qqnt.msg.api.c(createEmoInfo2, i172, str);
    }

    @Override // com.tencent.guild.api.marketface.IMarketFaceApi
    @Nullable
    public Object addEmotionToFavoriteAndTip(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        QLog.i("MarketFaceApiImpl", 2, "addEmotionToFavorite");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) (appInterface != null ? appInterface.getRuntimeService(IFavroamingDBManagerService.class, "") : null);
        if (iFavroamingDBManagerService == null) {
            return Unit.INSTANCE;
        }
        int calculateAlreadyFavEmoCount = calculateAlreadyFavEmoCount();
        if (calculateAlreadyFavEmoCount >= FavEmoConstant.getAddFavEmoOverLimit()) {
            QLog.d("MarketFaceApiImpl", 1, "[addEmotionToFavoriteAndTip] add fav emo over count limit. currentCount=", Boxing.boxInt(calculateAlreadyFavEmoCount), ", limitCount=", Boxing.boxInt(FavEmoConstant.getAddFavEmoOverLimit()));
            String addFavEmoOverLimitTips = FavEmoConstant.getAddFavEmoOverLimitTips();
            Intrinsics.checkNotNullExpressionValue(addFavEmoOverLimitTips, "getAddFavEmoOverLimitTips()");
            Object showTip = showTip(context, addFavEmoOverLimitTips, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return showTip == coroutine_suspended2 ? showTip : Unit.INSTANCE;
        }
        Pair<CustomEmotionData, Integer> queryEmoFromFavPanel = queryEmoFromFavPanel(str, str2);
        if (queryEmoFromFavPanel != null) {
            if (!iFavroamingDBManagerService.updateDeletedEmoticon(queryEmoFromFavPanel.getFirst(), queryEmoFromFavPanel.getSecond().intValue())) {
                Object showTip2 = showTip(context, "\u5df2\u6dfb\u52a0\u8fc7\u8be5\u8868\u60c5", continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (showTip2 == coroutine_suspended) {
                    return showTip2;
                }
            }
            return Unit.INSTANCE;
        }
        syncEmoUpload(context, str, str2);
        return Unit.INSTANCE;
    }
}
