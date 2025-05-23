package com.tencent.qqnt.emotion.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.temp.transfile.AbsDownloader;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi;
import com.tencent.qqnt.aio.api.IAIOMarketFaceSender;
import com.tencent.qqnt.emotion.api.ICommercialDrainageManagerService;
import com.tencent.qqnt.emotion.api.IEmosmService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.protocol.MarketFaceExtPb$ResvAttr;
import com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import com.tencent.qqnt.msg.data.g;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes24.dex */
public class EmosmServiceImpl implements IEmosmService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "EmosmServiceImpl";

    public EmosmServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String getOriginalMd5(Intent intent) {
        if (intent == null) {
            return "";
        }
        return intent.getStringExtra(IPicBus.ORIGINAL_MD5);
    }

    private g getPicExtBizInfo(Intent intent) {
        if (intent == null) {
            return null;
        }
        int intExtra = intent.getIntExtra(PeakConstants.KEY_EMOTION_SOURCE_EPID, 0);
        QLog.d(TAG, 1, "getPicExtBizInfo epid:", Integer.valueOf(intExtra));
        EmojiMall emojiMall = new EmojiMall(intExtra, 0);
        g gVar = new g();
        gVar.h(emojiMall);
        return gVar;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmosmService
    public void addToCustomEmotionForPic(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) str);
            return;
        }
        File file = AbsDownloader.getFile(str);
        if (file != null && file.exists()) {
            ((IAIOEmotionAddApi) com.tencent.qqnt.aio.adapter.a.b(IAIOEmotionAddApi.class)).addEmotion(context, file.getAbsolutePath(), null);
        } else if (QLog.isDevelopLevel()) {
            QLog.e(TAG, 4, " add custom fail file no exist");
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmosmService
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (File) iPatchRedirector.redirect((short) 5, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        return new com.tencent.mobileqq.temp.transfile.b().downloadImage(outputStream, downloadParams, uRLDrawableHandler);
    }

    @Override // com.tencent.qqnt.emotion.api.IEmosmService
    public void sendEmoticon(AppRuntime appRuntime, com.tencent.aio.api.runtime.a aVar, MarketFaceElement marketFaceElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, aVar, marketFaceElement);
            return;
        }
        if (marketFaceElement == null) {
            QLog.e(TAG, 1, "sendEmosmMsg error, marketFaceElement is null!");
            return;
        }
        Emoticon emoticon = new Emoticon();
        emoticon.epId = String.valueOf(marketFaceElement.getEmojiPackageId());
        emoticon.eId = marketFaceElement.getEmojiId();
        emoticon.encryptKey = marketFaceElement.getKey();
        emoticon.name = marketFaceElement.getFaceName();
        sendEmoticon(appRuntime, aVar, emoticon, false);
    }

    @Override // com.tencent.qqnt.emotion.api.IEmosmService
    public void sendRecEmoPic(AppInterface appInterface, com.tencent.aio.api.runtime.a aVar, CharSequence charSequence, Intent intent, ArrayList<String> arrayList) {
        String charSequence2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInterface, aVar, charSequence, intent, arrayList);
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            if (aVar == null) {
                QLog.e(TAG, 1, "sendRecEmoPic error, aioContext is null!");
                return;
            }
            if (charSequence == null) {
                QLog.e(TAG, 1, "sendRecEmoPic error, inputEditable is null!");
                return;
            }
            boolean z16 = charSequence instanceof QQTextBuilder;
            if (z16) {
                charSequence2 = ((QQTextBuilder) charSequence).toPlainText();
            } else if (z16) {
                charSequence2 = ((QQTextBuilder) charSequence).toPlainText();
            } else {
                charSequence2 = charSequence.toString();
            }
            aVar.e().h(new StickerRecommendEvent.SendSticker(arrayList.get(0), charSequence2, getPicExtBizInfo(intent), getOriginalMd5(intent)));
            return;
        }
        QLog.e(TAG, 1, "sendRecEmoPic error, no file need to send!");
    }

    @Override // com.tencent.qqnt.emotion.api.IEmosmService
    public void sendEmoticon(AppRuntime appRuntime, com.tencent.aio.api.runtime.a aVar, Emoticon emoticon, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, aVar, emoticon, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            ((IEmoticonManagerService) appRuntime.getRuntimeService(IEmoticonManagerService.class, "all")).asyncIncreaseEmotionClickNum(emoticon);
        }
        if (emoticon == null) {
            QLog.e(TAG, 1, "sendEmosmMsg emoticon is null:");
            return;
        }
        int i3 = emoticon.jobType;
        if ((i3 == 0 || i3 == 2 || i3 == 4) && !emoticon.hasEncryptKey()) {
            Context context = aVar.c().getContext();
            QQToast.makeText(context, context.getString(R.string.zuz), 0).show();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sendEmosmMsg emoticon Encrypt Key is null.name:");
            String str = emoticon.name;
            if (str == null) {
                str = "~";
            }
            sb5.append(str);
            sb5.append(", epid_eid:");
            String str2 = emoticon.epId;
            if (str2 == null) {
                str2 = "~";
            }
            sb5.append(str2);
            sb5.append("_");
            String str3 = emoticon.eId;
            sb5.append(str3 != null ? str3 : "~");
            QLog.e(TAG, 1, sb5.toString());
            return;
        }
        ThreadManagerV2.post(new Runnable(appRuntime, emoticon, aVar) { // from class: com.tencent.qqnt.emotion.api.impl.EmosmServiceImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f356151d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Emoticon f356152e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.tencent.aio.api.runtime.a f356153f;

            {
                this.f356151d = appRuntime;
                this.f356152e = emoticon;
                this.f356153f = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, EmosmServiceImpl.this, appRuntime, emoticon, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                int i16;
                String str4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) this.f356151d.getRuntimeService(IEmoticonManagerService.class, "")).syncFindEmoticonPackageById(this.f356152e.epId);
                if (syncFindEmoticonPackageById == null) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("sendEmosmMsg ePackage == null name:");
                    String str5 = this.f356152e.name;
                    String str6 = "~";
                    if (str5 == null) {
                        str5 = "~";
                    }
                    sb6.append(str5);
                    sb6.append(", epid_eid:");
                    String str7 = this.f356152e.epId;
                    if (str7 == null) {
                        str7 = "~";
                    }
                    sb6.append(str7);
                    sb6.append("_");
                    String str8 = this.f356152e.eId;
                    if (str8 != null) {
                        str6 = str8;
                    }
                    sb6.append(str6);
                    QLog.e(EmosmServiceImpl.TAG, 1, sb6.toString());
                    return;
                }
                MarkFaceMessage markFaceMessage = new MarkFaceMessage();
                markFaceMessage.cSubType = syncFindEmoticonPackageById.type;
                Emoticon emoticon2 = this.f356152e;
                markFaceMessage.sbufID = com.tencent.qqnt.emotion.emosm.b.k(emoticon2.eId, emoticon2.jobType);
                markFaceMessage.dwTabID = Integer.valueOf(this.f356152e.epId).intValue();
                markFaceMessage.sbfKey = this.f356152e.encryptKey.getBytes();
                Emoticon emoticon3 = this.f356152e;
                markFaceMessage.imageWidth = emoticon3.width;
                markFaceMessage.imageHeight = emoticon3.height;
                markFaceMessage.faceName = emoticon3.name;
                if (syncFindEmoticonPackageById.isAPNG == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                markFaceMessage.isAPNG = z17;
                if (emoticon3.isSound) {
                    markFaceMessage.mediaType = 1;
                }
                int i17 = emoticon3.jobType;
                if (i17 == 1) {
                    markFaceMessage.mediaType = 2;
                } else if (i17 == 4) {
                    markFaceMessage.mediaType = 3;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(EmosmServiceImpl.TAG, 2, "sendEmosmMsg epid = :" + this.f356152e.epId + ",eid = :" + this.f356152e.eId + ";type = " + syncFindEmoticonPackageById.type + ";jobtype = " + this.f356152e.jobType + ";mfm.mediatype = " + markFaceMessage.mediaType);
                }
                int i18 = syncFindEmoticonPackageById.type;
                if (1 == i18 || 4 == i18) {
                    markFaceMessage.cSubType = 3;
                }
                Emoticon emoticon4 = this.f356152e;
                if (emoticon4.jobType == 2 && (str4 = emoticon4.magicValue) != null) {
                    markFaceMessage.mobileparam = str4.getBytes();
                }
                markFaceMessage.voicePrintItems = this.f356152e.parseSoundPrintString();
                Emoticon emoticon5 = this.f356152e;
                markFaceMessage.backColor = emoticon5.backColor;
                markFaceMessage.volumeColor = emoticon5.volumeColor;
                ICommercialDrainageManagerService iCommercialDrainageManagerService = (ICommercialDrainageManagerService) this.f356151d.getRuntimeService(ICommercialDrainageManagerService.class, "");
                MarketFaceExtPb$ResvAttr marketFaceExtPb$ResvAttr = new MarketFaceExtPb$ResvAttr();
                PBUInt32Field pBUInt32Field = marketFaceExtPb$ResvAttr.uint32_emoji_type;
                if (markFaceMessage.isAPNG) {
                    i16 = 2;
                } else {
                    i16 = 1;
                }
                pBUInt32Field.set(i16);
                if (syncFindEmoticonPackageById.endTime == 0 && syncFindEmoticonPackageById.beginTime == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.i(EmosmServiceImpl.TAG, 2, "sendEmosmMsg, endTime and beginTime = 0, set tiem = " + currentTimeMillis);
                    }
                    syncFindEmoticonPackageById.beginTime = currentTimeMillis;
                    syncFindEmoticonPackageById.endTime = currentTimeMillis;
                }
                boolean isIPSite = iCommercialDrainageManagerService.isIPSite(syncFindEmoticonPackageById);
                boolean isIPSite2 = iCommercialDrainageManagerService.isIPSite(this.f356152e);
                if (syncFindEmoticonPackageById.copywritingType != com.tencent.qqnt.emotion.constant.a.f356189b || isIPSite || isIPSite2) {
                    if (isIPSite) {
                        markFaceMessage.copywritingType = com.tencent.qqnt.emotion.constant.a.f356194g;
                        markFaceMessage.copywritingContent = syncFindEmoticonPackageById.ipName;
                        markFaceMessage.jumpUrl = syncFindEmoticonPackageById.ipJumpUrl;
                        markFaceMessage.beginTime = syncFindEmoticonPackageById.beginTime;
                        markFaceMessage.endTime = syncFindEmoticonPackageById.endTime;
                        markFaceMessage.from = HardCodeUtil.qqStr(R.string.f170885zv1);
                    } else if (isIPSite2) {
                        markFaceMessage.copywritingType = com.tencent.qqnt.emotion.constant.a.f356194g;
                        Emoticon emoticon6 = this.f356152e;
                        markFaceMessage.copywritingContent = emoticon6.ipsiteName;
                        markFaceMessage.jumpUrl = emoticon6.ipsiteUrl;
                        markFaceMessage.beginTime = syncFindEmoticonPackageById.beginTime;
                        markFaceMessage.endTime = syncFindEmoticonPackageById.endTime;
                        markFaceMessage.from = HardCodeUtil.qqStr(R.string.f170885zv1);
                    } else if (!iCommercialDrainageManagerService.shouldHiden(syncFindEmoticonPackageById)) {
                        markFaceMessage.copywritingType = syncFindEmoticonPackageById.copywritingType;
                        markFaceMessage.copywritingContent = syncFindEmoticonPackageById.diversionName;
                        markFaceMessage.jumpUrl = syncFindEmoticonPackageById.jumpUrl;
                        markFaceMessage.beginTime = syncFindEmoticonPackageById.beginTime;
                        markFaceMessage.endTime = syncFindEmoticonPackageById.endTime;
                        markFaceMessage.from = syncFindEmoticonPackageById.comeFom;
                    }
                    boolean z18 = syncFindEmoticonPackageById.hasIpProduct;
                    markFaceMessage.hasIpProduct = z18;
                    marketFaceExtPb$ResvAttr.uint32_has_ip_product.set(z18 ? 1 : 0);
                    marketFaceExtPb$ResvAttr.uint32_source_type.set(markFaceMessage.copywritingType);
                    marketFaceExtPb$ResvAttr.uint32_start_time.set((int) markFaceMessage.beginTime);
                    marketFaceExtPb$ResvAttr.uint32_end_time.set((int) markFaceMessage.endTime);
                    if (!TextUtils.isEmpty(markFaceMessage.from)) {
                        marketFaceExtPb$ResvAttr.str_source_type_name.set(markFaceMessage.from);
                    }
                    if (!TextUtils.isEmpty(markFaceMessage.copywritingContent)) {
                        marketFaceExtPb$ResvAttr.str_source_name.set(markFaceMessage.copywritingContent);
                    }
                    if (!TextUtils.isEmpty(markFaceMessage.jumpUrl)) {
                        marketFaceExtPb$ResvAttr.str_source_jump_url.set(markFaceMessage.jumpUrl);
                    }
                }
                List<Integer> list = markFaceMessage.voicePrintItems;
                if (list != null && !list.isEmpty()) {
                    marketFaceExtPb$ResvAttr.uint32_voice_item_height_arr.set(markFaceMessage.voicePrintItems);
                }
                if (!TextUtils.isEmpty(markFaceMessage.backColor)) {
                    marketFaceExtPb$ResvAttr.str_back_color.set(markFaceMessage.backColor);
                }
                if (!TextUtils.isEmpty(markFaceMessage.volumeColor)) {
                    marketFaceExtPb$ResvAttr.str_volume_color.set(markFaceMessage.volumeColor);
                }
                ArrayList<MarketFaceSupportSize> e16 = com.tencent.qqnt.emotion.utils.a.e(syncFindEmoticonPackageById.supportSize);
                markFaceMessage.supportSize = e16;
                markFaceMessage.apngSupportSize = e16;
                markFaceMessage.resvAttr = marketFaceExtPb$ResvAttr.toByteArray();
                if (markFaceMessage.copywritingType != com.tencent.qqnt.emotion.constant.a.f356189b) {
                    int showCount = iCommercialDrainageManagerService.getShowCount((int) NetConnInfoCenter.getServerTime(), syncFindEmoticonPackageById.epId, markFaceMessage.copywritingContent, markFaceMessage.copywritingType);
                    if (showCount == 0) {
                        markFaceMessage.shouldDisplay = true;
                    } else if (showCount == 1 && markFaceMessage.hasIpProduct) {
                        markFaceMessage.shouldDisplay = true;
                        markFaceMessage.showIpProduct = true;
                        markFaceMessage.from = com.tencent.qqnt.emotion.constant.a.f356196i;
                        markFaceMessage.copywritingContent = com.tencent.qqnt.emotion.constant.a.f356197j;
                    } else {
                        markFaceMessage.shouldDisplay = false;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(EmosmServiceImpl.TAG, 2, "diversionRunnable, epId = " + syncFindEmoticonPackageById.epId + " ePackage.copywritingType = " + syncFindEmoticonPackageById.copywritingType + " currentTime = " + System.currentTimeMillis());
                }
                ThreadManager.getUIHandler().post(new Runnable(markFaceMessage) { // from class: com.tencent.qqnt.emotion.api.impl.EmosmServiceImpl.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ MarkFaceMessage f356154d;

                    {
                        this.f356154d = markFaceMessage;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) markFaceMessage);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            ((IAIOMarketFaceSender) QRoute.api(IAIOMarketFaceSender.class)).sendMarketFace(AnonymousClass1.this.f356153f, this.f356154d);
                        }
                    }
                });
            }
        }, 5, null, false);
    }
}
