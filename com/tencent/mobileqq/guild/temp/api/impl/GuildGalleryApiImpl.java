package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.common.galleryactivity.j;
import com.tencent.guild.api.emoji.IGuildEmoPreviewApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.image.URLDrawable;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.drawable.LibraBitmapDrawable;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.chatpie.GuildFeedImageProviderService;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.temp.api.IGuildGalleryApi;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqnt.videoplay.api.view.NTAIOBubbleVideoView;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gallery.api.INTGalleryApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerFragment;
import com.tencent.richframework.gallery.RFWLayerImageLoader;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import lu1.k;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J0\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010 \u001a\u00020\u001f*\u00020\u0010H\u0002J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002J\u0014\u0010%\u001a\u00020\u0012*\u00020\u00162\u0006\u0010$\u001a\u00020#H\u0002J\u0014\u0010'\u001a\u00020\u0012*\u00020\u00162\u0006\u0010$\u001a\u00020&H\u0002J\u0014\u0010)\u001a\u00020\u0012*\u00020\u00162\u0006\u0010$\u001a\u00020(H\u0002J\u0014\u0010+\u001a\u00020\u0012*\u00020\u00162\u0006\u0010$\u001a\u00020*H\u0002J\u0012\u0010.\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J$\u00101\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u000102H\u0002J\u0010\u00106\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020,H\u0002J\\\u0010?\u001a\u00020\u00122\u0006\u00108\u001a\u0002072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u001f2\b\u0010=\u001a\u0004\u0018\u00010\u00102\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016JX\u0010A\u001a\u00020\u00122\u0006\u00108\u001a\u0002072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010@\u001a\u00020\u001f2\b\u0010=\u001a\u0004\u0018\u00010\u00102\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J \u0010C\u001a\u00020\u00122\u0006\u0010B\u001a\u0002072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010E\u001a\u00020\u00122\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J8\u0010K\u001a\u00020\u00122\u0006\u00108\u001a\u0002072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020,2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020G2\u0006\u0010J\u001a\u000209H\u0017R\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/GuildGalleryApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IGuildGalleryApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "aioMsgRecordList", "Landroid/view/View;", "view", "Lrw1/b;", "aioImageProviderService", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "Lkotlin/collections/ArrayList;", "data", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "extras", "", "enterToGallery", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemMediaInfo", "preDownloadLargePic", "aioMsgItemList", "Ljava/lang/Class;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "getLayerFragmentClass", "Landroid/widget/ImageView;", "findClickImageView", "", "checkGroupEmo", "richMediaInfo", "generateMediaInfo", "Lcom/tencent/mobileqq/activity/aio/photo/AIOFilePicData;", QAdVrReportParams.ParamKey.MEDIA, "generateFromFilePic", "Lcom/tencent/mobileqq/activity/aio/photo/AIOShortVideoData;", "generateFromShortVideo", "Lcom/tencent/mobileqq/activity/aio/photo/AIOFileVideoData;", "generateFromFileVideo", "Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;", "generateFromImageData", "", "filePath", "isFilePathValidate", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "checkIsFavPicAndShowPreview", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "convertFileMsgToEntity", "canSetFilePath", "Lmqq/app/AppRuntime;", "app", "", "playPosition", "isMute", "isOneItemOnly", "extraInfo", "aioRichMediaList", "enterVideoPreview", "isOnePic", "enterImagePreview", "appRuntime", "enterFileBrowser", "msgRecordList", "onMsgRevoke", "url", "", "w", h.F, "id", "openImagePreview", "Lcom/tencent/mobileqq/guild/chatpie/GuildFeedImageProviderService;", "feedImageProviderService$delegate", "Lkotlin/Lazy;", "getFeedImageProviderService", "()Lcom/tencent/mobileqq/guild/chatpie/GuildFeedImageProviderService;", "feedImageProviderService", "<init>", "()V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildGalleryApiImpl implements IGuildGalleryApi {
    public static final String AIO_RICH_MEDIA_DATA_KEY = "AIO_RICH_MEDIA_DATA_KEY";
    public static final String MSG_RECORD_STORE_KEY = "MSG_RECORD_STORE_KEY";
    public static final String TAG = "GuildGalleryApiImpl";
    public static final String UNKNOWN = "unknown";

    /* renamed from: feedImageProviderService$delegate, reason: from kotlin metadata */
    private final Lazy feedImageProviderService;

    public GuildGalleryApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedImageProviderService>() { // from class: com.tencent.mobileqq.guild.temp.api.impl.GuildGalleryApiImpl$feedImageProviderService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildFeedImageProviderService invoke() {
                return new GuildFeedImageProviderService();
            }
        });
        this.feedImageProviderService = lazy;
    }

    private final boolean checkGroupEmo(Bundle bundle) {
        return bundle.getBoolean("extra.IS_FROM_GROUP_EMO", false);
    }

    private final FileManagerEntity convertFileMsgToEntity(MsgRecord msgRecord, MsgElement msgElement) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        if (msgElement == null) {
            return fileManagerEntity;
        }
        FileElement fileElement = msgElement.fileElement;
        fileManagerEntity.Uuid = fileElement.fileUuid;
        fileManagerEntity.fileSize = fileElement.fileSize;
        fileManagerEntity.fileName = fileElement.fileName;
        String str = fileElement.filePath;
        Intrinsics.checkNotNullExpressionValue(str, "msgElement.fileElement.filePath");
        if (canSetFilePath(str)) {
            fileManagerEntity.setFilePath(msgElement.fileElement.filePath);
        }
        FileElement fileElement2 = msgElement.fileElement;
        fileManagerEntity.strFileSHA = fileElement2.fileSha;
        fileManagerEntity.nSessionId = msgElement.elementId;
        fileManagerEntity.nFileType = ah.o0(fileElement2.fileName);
        fileManagerEntity.uniseq = msgRecord.msgId;
        fileManagerEntity.guildId = msgRecord.guildId;
        fileManagerEntity.channelId = msgRecord.channelId;
        fileManagerEntity.channelName = msgRecord.channelName;
        fileManagerEntity.peerType = 10014;
        fileManagerEntity.srvTime = 0L;
        fileManagerEntity.nOpType = msgRecord.sendType == 1 ? 52 : 53;
        fileManagerEntity.setCloudType(12);
        fileManagerEntity.status = 1;
        fileManagerEntity.msgSeq = msgRecord.msgSeq;
        fileManagerEntity.msgUid = msgRecord.msgId;
        fileManagerEntity.msgTime = msgRecord.msgTime;
        return fileManagerEntity;
    }

    private final void enterToGallery(MsgRecord msgRecord, List<MsgRecord> aioMsgRecordList, View view, rw1.b aioImageProviderService, ArrayList<AIORichMediaData> data, Context context, Bundle extras) {
        ImageView findClickImageView;
        int i3;
        List<? extends AIORichMediaData> listOf;
        List<RFWLayerItemMediaInfo> generateMediaInfo;
        int coerceAtLeast;
        int coerceAtLeast2;
        int collectionSizeOrDefault;
        if (view instanceof ImageView) {
            findClickImageView = (ImageView) view;
        } else {
            findClickImageView = view instanceof ViewGroup ? findClickImageView(view) : null;
        }
        if (!((findClickImageView != null ? findClickImageView.getDrawable() : null) instanceof LibraBitmapDrawable)) {
            if (!((findClickImageView != null ? findClickImageView.getDrawable() : null) instanceof URLDrawable)) {
                findClickImageView = null;
            }
        }
        List<AIORichMediaData> y55 = aioImageProviderService.y5();
        Intrinsics.checkNotNullExpressionValue(y55, "aioImageProviderService.richMediaList");
        Iterator<AIORichMediaData> it = y55.iterator();
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            AIORichMediaData next = it.next();
            int i17 = i16;
            if (next.f179628d == data.get(data.size() - 1).f179628d && next.f179629e == data.get(data.size() - 1).f179629e) {
                i3 = i17;
                break;
            }
            i16 = i17 + 1;
        }
        if (i3 == -1) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(data.get(data.size() - 1));
            generateMediaInfo = generateMediaInfo(listOf);
        } else {
            List<AIORichMediaData> y56 = aioImageProviderService.y5();
            Intrinsics.checkNotNullExpressionValue(y56, "aioImageProviderService.richMediaList");
            generateMediaInfo = generateMediaInfo(y56);
        }
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        preDownloadLargePic(aIOMsgItem, generateMediaInfo.get(coerceAtLeast));
        com.tencent.qqnt.aio.gallery.d dVar = new com.tencent.qqnt.aio.gallery.d();
        if (aioMsgRecordList != null) {
            List<MsgRecord> list = aioMsgRecordList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList.add(new AIOMsgItem((MsgRecord) it5.next()));
            }
            dVar.addDataList(arrayList);
        }
        dVar.addData(aIOMsgItem);
        RFWLayerDataCenter.INSTANCE.addDataStore(String.valueOf(dVar.getStoreTag()), dVar);
        extras.putString(MSG_RECORD_STORE_KEY, String.valueOf(dVar.getStoreTag()));
        extras.putInt(RichMediaBrowserConstants.INTERNAL_EXTRA_ENTRANCE, 1);
        extras.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
        if (aioImageProviderService.y5() != null) {
            INTGalleryApi iNTGalleryApi = (INTGalleryApi) QRoute.api(INTGalleryApi.class);
            List<AIORichMediaData> y57 = aioImageProviderService.y5();
            Intrinsics.checkNotNullExpressionValue(y57, "aioImageProviderService.richMediaList");
            iNTGalleryApi.addDataList(y57);
        }
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        RFWLayerLaunchUtil.jumpToGallery$default(context, findClickImageView, generateMediaInfo, coerceAtLeast2, QQGalleryActivity.class, getLayerFragmentClass(msgRecord, aioMsgRecordList, extras), extras, 0, 128, null);
    }

    private final ImageView findClickImageView(View view) {
        if (view instanceof NTAIOBubbleVideoView) {
            return ((NTAIOBubbleVideoView) view).c();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(i)");
                ImageView findClickImageView = findClickImageView(childAt);
                if (findClickImageView != null) {
                    return findClickImageView;
                }
            }
            return null;
        }
        if (view instanceof RoundBubbleImageView) {
            return (ImageView) view;
        }
        return null;
    }

    private final void generateFromFilePic(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, AIOFilePicData aIOFilePicData) {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(aIOFilePicData.W);
        if (!TextUtils.isEmpty(aIOFilePicData.H)) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(aIOFilePicData.H);
            rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setBigPicInfo(rFWLayerPicInfo.getSmallPicInfo());
            RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerPicInfo.getSmallPicInfo();
            Intrinsics.checkNotNull(smallPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(smallPicInfo);
        }
        if (!TextUtils.isEmpty(aIOFilePicData.J)) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo2.setLocalPath(aIOFilePicData.J);
            rFWPicInfo2.setSize(aIOFilePicData.f179631h);
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo2);
            if (RFWFileUtils.fileExists(aIOFilePicData.J)) {
                RFWLayerPicInfo.RFWPicInfo originPicInfo = rFWLayerPicInfo.getOriginPicInfo();
                Intrinsics.checkNotNull(originPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
                rFWLayerPicInfo.setCurrentPicInfo(originPicInfo);
            }
        }
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
    }

    private final void generateFromFileVideo(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, AIOFileVideoData aIOFileVideoData) {
        String str;
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        if (TextUtils.isEmpty(aIOFileVideoData.G)) {
            str = "";
        } else {
            str = aIOFileVideoData.G;
        }
        rFWPicInfo.setLocalPath(str);
        rFWPicInfo.setUrl(str);
        rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        rFWLayerVideoInfo.setFileId(aIOFileVideoData.F);
        rFWLayerVideoInfo.setVideoOriginUrl(aIOFileVideoData.H);
        String videoOriginUrl = rFWLayerVideoInfo.getVideoOriginUrl();
        rFWLayerVideoInfo.setCurrentVideoUrl(videoOriginUrl != null ? videoOriginUrl : "");
        rFWLayerVideoInfo.setLocalPath(aIOFileVideoData.H);
        rFWLayerVideoInfo.setVideoHeight(aIOFileVideoData.K);
        rFWLayerVideoInfo.setVideoWidth(aIOFileVideoData.J);
        rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
    }

    private final void generateFromImageData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, AIOImageData aIOImageData) {
        rFWLayerItemMediaInfo.setInvalid(aIOImageData.M);
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(aIOImageData.f179572c0);
        if (isFilePathValidate(aIOImageData.F)) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(aIOImageData.F);
            rFWPicInfo.setUrl(aIOImageData.F);
            rFWPicInfo.setHeight((int) aIOImageData.T);
            rFWPicInfo.setWidth((int) aIOImageData.S);
            rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
            RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerPicInfo.getSmallPicInfo();
            Intrinsics.checkNotNull(smallPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(smallPicInfo);
        }
        if (isFilePathValidate(aIOImageData.G)) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo2.setLocalPath(aIOImageData.G);
            rFWPicInfo2.setUrl(aIOImageData.G);
            rFWPicInfo2.setHeight((int) aIOImageData.T);
            rFWPicInfo2.setWidth((int) aIOImageData.S);
            rFWLayerPicInfo.setBigPicInfo(rFWPicInfo2);
            RFWLayerPicInfo.RFWPicInfo bigPicInfo = rFWLayerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(bigPicInfo);
        }
        if (isFilePathValidate(aIOImageData.H)) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo3 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo3.setLocalPath(aIOImageData.H);
            rFWPicInfo3.setUrl(aIOImageData.H);
            rFWPicInfo3.setSize(aIOImageData.f179631h);
            rFWPicInfo3.setHeight((int) aIOImageData.T);
            rFWPicInfo3.setWidth((int) aIOImageData.S);
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo3);
            if (RFWFileUtils.fileExists(aIOImageData.H)) {
                RFWLayerPicInfo.RFWPicInfo originPicInfo = rFWLayerPicInfo.getOriginPicInfo();
                Intrinsics.checkNotNull(originPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
                rFWLayerPicInfo.setCurrentPicInfo(originPicInfo);
            }
        }
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
    }

    private final void generateFromShortVideo(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, AIOShortVideoData aIOShortVideoData) {
        rFWLayerItemMediaInfo.setInvalid(aIOShortVideoData.V != 0);
        if (!TextUtils.isEmpty(aIOShortVideoData.F)) {
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(aIOShortVideoData.F);
            rFWPicInfo.setUrl(aIOShortVideoData.F);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        }
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        rFWLayerVideoInfo.setFileId(aIOShortVideoData.Q);
        rFWLayerVideoInfo.setVideoOriginUrl(aIOShortVideoData.G);
        String videoOriginUrl = rFWLayerVideoInfo.getVideoOriginUrl();
        if (videoOriginUrl == null) {
            videoOriginUrl = "";
        }
        rFWLayerVideoInfo.setCurrentVideoUrl(videoOriginUrl);
        rFWLayerVideoInfo.setLocalPath(aIOShortVideoData.G);
        rFWLayerVideoInfo.setVideoDurationSec(aIOShortVideoData.H);
        rFWLayerVideoInfo.setVideoHeight(aIOShortVideoData.M);
        rFWLayerVideoInfo.setVideoWidth(aIOShortVideoData.L);
        rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
    }

    private final List<RFWLayerItemMediaInfo> generateMediaInfo(List<? extends AIORichMediaData> richMediaInfo) {
        int collectionSizeOrDefault;
        List<? extends AIORichMediaData> list = richMediaInfo;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (AIORichMediaData aIORichMediaData : list) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            rFWLayerItemMediaInfo.setMediaId(aIORichMediaData.f179628d + "_" + aIORichMediaData.f179629e);
            if (aIORichMediaData instanceof AIOImageData) {
                generateFromImageData(rFWLayerItemMediaInfo, (AIOImageData) aIORichMediaData);
            } else if (aIORichMediaData instanceof AIOShortVideoData) {
                generateFromShortVideo(rFWLayerItemMediaInfo, (AIOShortVideoData) aIORichMediaData);
            } else if (aIORichMediaData instanceof AIOFilePicData) {
                generateFromFilePic(rFWLayerItemMediaInfo, (AIOFilePicData) aIORichMediaData);
            } else if (aIORichMediaData instanceof AIOFileVideoData) {
                generateFromFileVideo(rFWLayerItemMediaInfo, (AIOFileVideoData) aIORichMediaData);
            }
            arrayList.add(rFWLayerItemMediaInfo);
        }
        return arrayList;
    }

    private final GuildFeedImageProviderService getFeedImageProviderService() {
        return (GuildFeedImageProviderService) this.feedImageProviderService.getValue();
    }

    private final Class<? extends RFWLayerFragment> getLayerFragmentClass(MsgRecord msgRecord, List<MsgRecord> aioMsgItemList, Bundle extras) {
        if (checkGroupEmo(extras)) {
            return ((INTGalleryApi) QRoute.api(INTGalleryApi.class)).getNTAIOLayerGroupEmoticonFragment();
        }
        return ((INTGalleryApi) QRoute.api(INTGalleryApi.class)).getNTGuildAIOLayerFragment();
    }

    private final boolean isFilePathValidate(String filePath) {
        return (TextUtils.isEmpty(filePath) || TextUtils.equals(filePath, AIOBrowserBaseData.MEDIA_FILE_NONE)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMsgRevoke$lambda$20(List msgRecordList) {
        Intrinsics.checkNotNullParameter(msgRecordList, "$msgRecordList");
        QLog.i(TAG, 1, "[onMsgRevoke] msgRecordList size: " + msgRecordList.size());
        AppRuntime appRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Iterator it = msgRecordList.iterator();
        while (it.hasNext()) {
            MsgRecord msgRecord = (MsgRecord) it.next();
            Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
            com.tencent.mobileqq.activity.aio.photo.b.g(k.a(appRuntime, msgRecord));
        }
    }

    private final void preDownloadLargePic(AIOMsgItem msgItem, RFWLayerItemMediaInfo itemMediaInfo) {
        itemMediaInfo.setExtraData(msgItem);
        if (itemMediaInfo.isVideo()) {
            return;
        }
        IPicLoader picLoader = ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).getPicLoader();
        Option obtain = Option.obtain();
        obtain.setUrl("unknown");
        obtain.setLocalPath("unknown");
        obtain.setExtraData(RFWLayerImageLoader.getExtraData(itemMediaInfo, RFWLayerPicInfo.PicType.LARGE));
        picLoader.loadImage(obtain.setPredecode(false), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.guild.temp.api.impl.d
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                GuildGalleryApiImpl.preDownloadLargePic$lambda$4(loadState, option);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildGalleryApi
    public void enterFileBrowser(AppRuntime appRuntime, Context context, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "[enterFileBrowser] appRuntime is not QQAppInterface!");
            return;
        }
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        MsgElement msgElement = null;
        boolean z16 = true;
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 3) {
                Integer num = next.fileElement.invalidState;
                if (num == null || num.intValue() != 0) {
                    z16 = false;
                }
                msgElement = next;
            }
        }
        if (!z16) {
            String string = context.getString(R.string.f145820si);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026tring.guild_file_invalid)");
            QQToast.makeText(context, 1, string, 1).show();
            return;
        }
        FileManagerEntity convertFileMsgToEntity = convertFileMsgToEntity(msgRecord, msgElement);
        Bundle bundle = new Bundle();
        bundle.putString("file_browser_extra_params_uin", msgRecord.peerUid);
        com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d((QQAppInterface) appRuntime, convertFileMsgToEntity);
        dVar.S(bundle);
        com.tencent.mobileqq.filemanager.openbrowser.c d16 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(13);
        Intrinsics.checkNotNullExpressionValue(d16, "FileBrowserParam().setEntranceType(entranceType)");
        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, dVar, d16);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildGalleryApi
    public void enterImagePreview(AppRuntime app, Context context, View view, MsgRecord msgRecord, PicElement picElement, boolean isOnePic, Bundle extraInfo, List<MsgRecord> aioRichMediaList) {
        int i3;
        ArrayList<MsgElement> arrayList;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (checkIsFavPicAndShowPreview(msgRecord, picElement, view)) {
            QLog.i(TAG, 1, "[enterImagePreview] msgRecordSeq: " + msgRecord.msgSeq + ", msgRecordId: " + msgRecord.msgId + ". isGif.");
            return;
        }
        QLog.i(TAG, 1, "[enterImagePreview] msgRecordSeq: " + msgRecord.msgSeq + ", msgRecordId: " + msgRecord.msgId);
        Bundle bundle = new Bundle();
        if (extraInfo != null) {
            bundle.putAll(extraInfo);
        }
        if (view != null) {
            bundle.putParcelable("KEY_THUMBNAL_BOUND", j.d(view));
        }
        bundle.putInt(RichMediaBrowserConstants.EXTRA_AIO_CURRENT_PANEL_STATE, 0);
        bundle.putBoolean(ShortVideoConstants.IS_ONE_ITEM, isOnePic);
        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, 10014);
        bundle.putString("uin", msgRecord.peerUid);
        bundle.putString(IGuildForwardUtilsApi.EXTRA_GUILD_ID, msgRecord.guildId);
        bundle.putString("extra.GROUP_UIN", msgRecord.guildId);
        bundle.putString(IGuildForwardUtilsApi.EXTRA_GUILD_CHANNEL_ID, msgRecord.peerUid);
        bundle.putInt(IGuildForwardUtilsApi.EXTRA_GUILD_CHAT_TYPE, msgRecord.chatType);
        bundle.putString(PeakConstants.KEY_TROOP_GROUP_NAME, msgRecord.guildName);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 1);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_MOBILE_QQ_PROCESS_ID, Process.myPid());
        bundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bundle.putBoolean("extra.GUILD_NEED_REPORT", true);
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, MsgExtKt.t(msgRecord) ? (byte) 1 : (byte) 0);
        bundle.putInt("extra.GUILD_CHANNEL_PAGE_SOURCE_TYPE", ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).getChannelPageSourceType());
        IRuntimeService runtimeService = app.getRuntimeService(IOCRService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026va, ProcessConstant.MAIN)");
        IOCRService iOCRService = (IOCRService) runtimeService;
        boolean isSupportOcr = iOCRService.isSupportOcr(app.getCurrentAccountUin(), 1);
        bundle.putBoolean(RichMediaBrowserConstants.EXTRA_OCR, isSupportOcr);
        if (isSupportOcr) {
            String aIOText = iOCRService.getAIOText(app.getCurrentAccountUin());
            if (!TextUtils.isEmpty(aIOText)) {
                bundle.putString("extra.OCR_TEXT", aIOText);
            }
        }
        bundle.putString("extra.GUILD_AUTHOR_UIN", msgRecord.senderUid);
        IRuntimeService runtimeService2 = app.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGProGuildInfo guildInfo = ((IGPSService) runtimeService2).getGuildInfo(msgRecord.guildId);
        if (guildInfo != null) {
            bundle.putString("extra.GUILD_USER_TYPE", String.valueOf(v.b(guildInfo.getUserType())));
        }
        String currentAccountUin = app.getCurrentAccountUin();
        Integer num = null;
        if (picElement != null && (((i3 = msgRecord.msgType) == 2 || i3 == 9) && (arrayList = msgRecord.elements) != null && arrayList.size() > 0)) {
            int size = msgRecord.elements.size();
            for (int i16 = 0; i16 < size; i16++) {
                if (msgRecord.elements.get(i16).picElement != null && Intrinsics.areEqual(msgRecord.elements.get(i16).picElement.fileName, picElement.fileName)) {
                    num = Integer.valueOf(i16);
                }
            }
            QLog.i(TAG, 1, "handle mixMsg index. elementSize: " + msgRecord.elements.size() + ", filename: " + picElement.fileName + ", elementIndex: " + num);
        }
        Integer num2 = num;
        rw1.b bVar = new rw1.b(currentAccountUin, msgRecord.peerUid, 10014, msgRecord, aioRichMediaList);
        if (currentAccountUin != null && msgRecord.peerUid != null) {
            List<AIORichMediaData> b16 = rw1.e.f432610a.b(app, msgRecord, num2);
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.activity.aio.photo.AIORichMediaData>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.activity.aio.photo.AIORichMediaData> }");
            ArrayList<AIORichMediaData> arrayList2 = (ArrayList) b16;
            if (!arrayList2.isEmpty() && context != null) {
                enterToGallery(msgRecord, aioRichMediaList, view, bVar, arrayList2, context, bundle);
                return;
            } else {
                QLog.e(TAG, 1, "enterImagePreview data is empty!");
                return;
            }
        }
        QLog.e(TAG, 1, "enterImagePreview selfUin || msgRecord.peerUid is null");
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildGalleryApi
    public void enterVideoPreview(AppRuntime app, Context context, MsgRecord msgRecord, View view, long playPosition, boolean isMute, boolean isOneItemOnly, Bundle extraInfo, List<MsgRecord> aioRichMediaList) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QLog.i(TAG, 1, "[enterVideoPreview] msgRecordSeq: " + msgRecord.msgSeq + ", msgRecordId: " + msgRecord.msgId);
        if (MediaPlayerManager.q(app).t()) {
            MediaPlayerManager.q(app).D(true);
        }
        Bundle bundle = new Bundle();
        if (extraInfo != null) {
            bundle.putAll(extraInfo);
        }
        if (view != null) {
            bundle.putParcelable("KEY_THUMBNAL_BOUND", j.d(view));
        }
        bundle.putLong("extra.SEEK_POSITION", playPosition);
        bundle.putString(IGuildForwardUtilsApi.EXTRA_GUILD_ID, msgRecord.guildId);
        bundle.putString("extra.GROUP_UIN", msgRecord.guildId);
        bundle.putString(IGuildForwardUtilsApi.EXTRA_GUILD_CHANNEL_ID, msgRecord.peerUid);
        bundle.putInt(IGuildForwardUtilsApi.EXTRA_GUILD_CHAT_TYPE, msgRecord.chatType);
        bundle.putString(PeakConstants.KEY_TROOP_GROUP_NAME, msgRecord.guildName);
        bundle.putBoolean(ShortVideoConstants.MUTE_PLAY, isMute);
        bundle.putBoolean(RFWLaunchKey.KEY_IS_VIDEO_MUTE, isMute);
        bundle.putBoolean(ShortVideoConstants.IS_ONE_ITEM, isOneItemOnly);
        bundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 1);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_AIO_CURRENT_PANEL_STATE, 0);
        bundle.putLong(ShortVideoConstants.CLICK_VIDEO_BUBBLE_TIME, System.currentTimeMillis());
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, MsgExtKt.t(msgRecord) ? (byte) 1 : (byte) 0);
        bundle.putInt("extra.GUILD_CHANNEL_PAGE_SOURCE_TYPE", ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).getChannelPageSourceType());
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            String str = next.processName;
            Intrinsics.checkNotNullExpressionValue(str, "process.processName");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, MimeHelper.MIME_TYPE_MOBILEQQ, false, 2, null);
            if (endsWith$default) {
                bundle.putInt(RichMediaBrowserConstants.EXTRA_MOBILE_QQ_PROCESS_ID, next.pid);
                break;
            }
        }
        String currentAccountUin = app.getCurrentAccountUin();
        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, 10014);
        bundle.putString("uin", msgRecord.peerUid);
        bundle.putString("extra.GUILD_AUTHOR_UIN", msgRecord.senderUid);
        IRuntimeService runtimeService = app.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGProGuildInfo guildInfo = ((IGPSService) runtimeService).getGuildInfo(msgRecord.guildId);
        if (guildInfo != null) {
            bundle.putString("extra.GUILD_USER_TYPE", String.valueOf(v.b(guildInfo.getUserType())));
        }
        List c16 = rw1.e.c(rw1.e.f432610a, app, msgRecord, null, 4, null);
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.activity.aio.photo.AIORichMediaData>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.activity.aio.photo.AIORichMediaData> }");
        ArrayList<AIORichMediaData> arrayList = (ArrayList) c16;
        if (!arrayList.isEmpty()) {
            enterToGallery(msgRecord, aioRichMediaList, view, new rw1.b(currentAccountUin, msgRecord.peerUid, 10014, msgRecord, aioRichMediaList), arrayList, context, bundle);
        } else {
            QLog.e(TAG, 1, "enterVideoPreview data is empty!");
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildGalleryApi
    public void onMsgRevoke(final List<MsgRecord> msgRecordList) {
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.temp.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildGalleryApiImpl.onMsgRevoke$lambda$20(msgRecordList);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildGalleryApi
    @Deprecated(message = "The image preview API called by this function is not implemented.")
    public void openImagePreview(AppRuntime app, Context context, String url, int w3, int h16, long id5) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            return;
        }
        QLog.i(TAG, 1, "[openImagePreview] id:" + id5 + ", w:" + w3 + ", h:" + h16 + ", url:" + url.hashCode());
    }

    private final boolean canSetFilePath(String filePath) {
        boolean startsWith$default;
        try {
            String nTKernelDBPath = ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).getNTKernelDBPath();
            if (!TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(nTKernelDBPath)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(filePath, nTKernelDBPath, false, 2, null);
                if (startsWith$default) {
                    return false;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[canSetFilePath] exception: " + e16);
        }
        return true;
    }

    private final boolean checkIsFavPicAndShowPreview(MsgRecord msgRecord, PicElement picElement, View view) {
        if (!(picElement != null && MsgExtKt.u(picElement)) || view == null) {
            return false;
        }
        ((IGuildEmoPreviewApi) QRoute.api(IGuildEmoPreviewApi.class)).showHotPicPreview(view, picElement, msgRecord);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preDownloadLargePic$lambda$4(LoadState loadState, Option option) {
    }
}
