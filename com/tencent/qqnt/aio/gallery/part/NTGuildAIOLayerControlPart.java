package com.tencent.qqnt.aio.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.temp.api.impl.GuildGalleryApiImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.MsgRevokeEvent;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.aio.adapter.richmedia.provider.i;
import com.tencent.qqnt.aio.gallery.part.NTGuildAIOLayerControlPart;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.event.RFWLayerFileStateChangeEvent;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 g2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002hiB\u0007\u00a2\u0006\u0004\be\u0010fJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0002JJ\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0018H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\tJ\u001a\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0016J\u0018\u0010-\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010/\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u00100\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020#H\u0014J\u0012\u00104\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004050\u0017H\u0016R$\u0010=\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R*\u0010E\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR2\u0010L\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0017j\b\u0012\u0004\u0012\u00020\t`\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR>\u0010U\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130Mj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013`N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR>\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130Mj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013`N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010P\u001a\u0004\bW\u0010R\"\u0004\bX\u0010TR'\u0010`\u001a\u0012\u0012\u0004\u0012\u00020\u00130Zj\b\u0012\u0004\u0012\u00020\u0013`[8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006j"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTGuildAIOLayerControlPart;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "I9", "", "elementId", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;", "state", "", "percent", "totalSize", "G9", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "", "vid", "playUrl", "localPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "cookie", "H2", "B9", "path", "H9", "msgId", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "C9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$PicType;", "picSize", "", "downloadPic", "saveToAlbum", "E9", "getVideoUrl", "bundle", "initIntentData", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "d", "Ljava/lang/String;", "getMsgRecordDataStoreKey", "()Ljava/lang/String;", "setMsgRecordDataStoreKey", "(Ljava/lang/String;)V", "msgRecordDataStoreKey", "Lcom/tencent/richframework/data/idata/IDataStore;", "e", "Lcom/tencent/richframework/data/idata/IDataStore;", "getMsgRecordDataStore", "()Lcom/tencent/richframework/data/idata/IDataStore;", "setMsgRecordDataStore", "(Lcom/tencent/richframework/data/idata/IDataStore;)V", "msgRecordDataStore", "f", "Ljava/util/ArrayList;", "getSaveList", "()Ljava/util/ArrayList;", "setSaveList", "(Ljava/util/ArrayList;)V", "saveList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "getElementIdToMediaId", "()Ljava/util/HashMap;", "setElementIdToMediaId", "(Ljava/util/HashMap;)V", "elementIdToMediaId", "i", "getMMediaIdToContextId", "setMMediaIdToContextId", "mMediaIdToContextId", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashSet;", "getDownloadSuccessVideoElementIds", "()Ljava/util/HashSet;", "downloadSuccessVideoElementIds", "Lcom/tencent/qqnt/msg/i;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/msg/i;", "mKernelMsgListener", "<init>", "()V", "D", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NTGuildAIOLayerControlPart extends NTAIOLayerBasePart implements IMediaProvider, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String msgRecordDataStoreKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IDataStore<AIOMsgItem> msgRecordDataStore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Long> saveList = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private HashMap<Long, String> elementIdToMediaId = new HashMap<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> mMediaIdToContextId = new HashMap<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final HashSet<String> downloadSuccessVideoElementIds = new HashSet<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.qqnt.msg.i mKernelMsgListener = new c();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTGuildAIOLayerControlPart$b;", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "", "path", "", CoverDBCacheData.URLS, "domain", "", "b", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/aio/gallery/part/NTGuildAIOLayerControlPart;", "a", "Ljava/lang/ref/WeakReference;", "mWrfPart", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mMediaInfo", "part", "mediaInfo", "<init>", "(Lcom/tencent/qqnt/aio/gallery/part/NTGuildAIOLayerControlPart;Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.qqnt.aio.adapter.richmedia.provider.i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<NTGuildAIOLayerControlPart> mWrfPart;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final RFWLayerItemMediaInfo mMediaInfo;

        public b(NTGuildAIOLayerControlPart part, RFWLayerItemMediaInfo mediaInfo) {
            Intrinsics.checkNotNullParameter(part, "part");
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            this.mWrfPart = new WeakReference<>(part);
            this.mMediaInfo = mediaInfo;
        }

        @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.i
        public void a(int i3, String str) {
            i.a.a(this, i3, str);
        }

        @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.i
        public void b(String path, String[] urls, String domain) {
            String joinToString$default;
            String str;
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(urls, "urls");
            Intrinsics.checkNotNullParameter(domain, "domain");
            NTGuildAIOLayerControlPart nTGuildAIOLayerControlPart = this.mWrfPart.get();
            if ((nTGuildAIOLayerControlPart != null ? nTGuildAIOLayerControlPart.getMLayerViewModel() : null) == null) {
                return;
            }
            int i3 = RFWLog.USR;
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(urls, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            RFWLog.i("NTGuildAIOLayerControlPart", i3, "[downloadMedia] onGetVideoUrl: path:" + path + " urls:" + joinToString$default);
            if (!(urls.length == 0)) {
                RFWLayerVideoInfo layerVideoInfo = this.mMediaInfo.getLayerVideoInfo();
                if (layerVideoInfo != null) {
                    layerVideoInfo.setVideoOriginUrl(urls[0]);
                }
                RFWLayerVideoInfo layerVideoInfo2 = this.mMediaInfo.getLayerVideoInfo();
                if (layerVideoInfo2 != null) {
                    RFWLayerVideoInfo layerVideoInfo3 = this.mMediaInfo.getLayerVideoInfo();
                    if (layerVideoInfo3 == null || (str = layerVideoInfo3.getVideoOriginUrl()) == null) {
                        str = "";
                    }
                    layerVideoInfo2.setCurrentVideoUrl(str);
                }
                UIStateData<RFWLayerState> value = nTGuildAIOLayerControlPart.getMLayerViewModel().mRichMediaInfo.getValue();
                if (value != null) {
                    value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
                }
                nTGuildAIOLayerControlPart.getMLayerViewModel().mRichMediaInfo.postValue(nTGuildAIOLayerControlPart.getMLayerViewModel().mRichMediaInfo.getValue());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/gallery/part/NTGuildAIOLayerControlPart$c", "Lcom/tencent/qqnt/msg/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.qqnt.msg.i {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(FileTransNotifyInfo fileTransNotifyInfo, NTGuildAIOLayerControlPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (fileTransNotifyInfo != null) {
                this$0.I9(fileTransNotifyInfo);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(FileTransNotifyInfo fileTransNotifyInfo, NTGuildAIOLayerControlPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (fileTransNotifyInfo != null) {
                this$0.I9(fileTransNotifyInfo);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(final FileTransNotifyInfo notifyInfo) {
            Handler mainHandler = NTGuildAIOLayerControlPart.this.getMainHandler();
            final NTGuildAIOLayerControlPart nTGuildAIOLayerControlPart = NTGuildAIOLayerControlPart.this;
            mainHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.y
                @Override // java.lang.Runnable
                public final void run() {
                    NTGuildAIOLayerControlPart.c.c(FileTransNotifyInfo.this, nTGuildAIOLayerControlPart);
                }
            });
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(final FileTransNotifyInfo notifyInfo) {
            Handler mainHandler = NTGuildAIOLayerControlPart.this.getMainHandler();
            final NTGuildAIOLayerControlPart nTGuildAIOLayerControlPart = NTGuildAIOLayerControlPart.this;
            mainHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.z
                @Override // java.lang.Runnable
                public final void run() {
                    NTGuildAIOLayerControlPart.c.d(FileTransNotifyInfo.this, nTGuildAIOLayerControlPart);
                }
            });
        }
    }

    private final RFWLayerItemMediaInfo B9(long elementId) {
        UIStateData<RFWLayerState> value;
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        String str = this.elementIdToMediaId.get(Long.valueOf(elementId));
        Object obj = null;
        if (str == null || (value = getMLayerViewModel().mRichMediaInfo.getValue()) == null || (data = value.getData()) == null || (richMediaDataList = data.getRichMediaDataList()) == null) {
            return null;
        }
        Iterator<T> it = richMediaDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((RFWLayerItemMediaInfo) next).getMediaId(), str)) {
                obj = next;
                break;
            }
        }
        return (RFWLayerItemMediaInfo) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(com.tencent.qqnt.aio.adapter.richmedia.provider.h hVar, Pair mainAndSubId, int i3, MsgRecord targetMsgRecord, NTGuildAIOLayerControlPart this$0, RFWLayerItemMediaInfo mediaInfo, AIOMsgItem targetMsgItem, int i16, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(mainAndSubId, "$mainAndSubId");
        Intrinsics.checkNotNullParameter(targetMsgRecord, "$targetMsgRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(targetMsgItem, "$targetMsgItem");
        RFWLog.d("NTGuildAIOLayerControlPart", RFWLog.USR, "forwardMsg getMsgsByMsgId result=" + i16 + ", errMsg=" + str);
        if (arrayList != null && (!arrayList.isEmpty())) {
            Object obj = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "msgList[0]");
            hVar.g((MsgRecord) obj, ((Number) mainAndSubId.getSecond()).intValue(), i3, qu3.i.f429570a.m(targetMsgRecord), new b(this$0, mediaInfo));
        } else {
            RFWLog.e("NTGuildAIOLayerControlPart", RFWLog.USR, "getKernelMsgService can't find msg by msgId: " + targetMsgItem.q0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(NTGuildAIOLayerControlPart this$0, RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        FileManagerUtil.saveToAlbum(this$0.getContext(), mediaInfo.getExistSaveOrEditPath());
    }

    private final void G9(long elementId, RFWLayerFileDownloadState.FileState state, float percent, long totalSize) {
        String str = this.elementIdToMediaId.get(Long.valueOf(elementId));
        if (str == null) {
            return;
        }
        RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
        RFWLayerFileDownloadState rFWLayerFileDownloadState = new RFWLayerFileDownloadState(str);
        rFWLayerFileDownloadState.setFileState(state);
        rFWLayerFileDownloadState.setProgressPercent(percent);
        rFWLayerFileDownloadState.setFileSize(totalSize);
        rFWLayerDataCenter.updateFileState(rFWLayerFileDownloadState);
    }

    private final void H2(RFWLayerItemMediaInfo mediaInfo, String vid, String playUrl, String localPath, ArrayList<String> cookie) {
        String videoOriginUrl;
        RFWLayerVideoInfo layerVideoInfo;
        RFWLayerVideoInfo layerVideoInfo2;
        String localPath2;
        RFWLayerVideoInfo layerVideoInfo3;
        RFWLayerVideoInfo layerVideoInfo4;
        RFWLog.i(getTAG(), RFWLog.USR, "updateVideoInfo update:" + mediaInfo.getMediaId());
        if (playUrl != null && (layerVideoInfo4 = mediaInfo.getLayerVideoInfo()) != null) {
            layerVideoInfo4.setVideoOriginUrl(playUrl);
        }
        if (localPath != null && (layerVideoInfo3 = mediaInfo.getLayerVideoInfo()) != null) {
            layerVideoInfo3.setLocalPath(localPath);
        }
        boolean fileExists = RFWFileUtils.fileExists(localPath);
        String str = "";
        if (fileExists) {
            RFWLayerVideoInfo layerVideoInfo5 = mediaInfo.getLayerVideoInfo();
            if (layerVideoInfo5 != null) {
                RFWLayerVideoInfo layerVideoInfo6 = mediaInfo.getLayerVideoInfo();
                if (layerVideoInfo6 != null && (localPath2 = layerVideoInfo6.getLocalPath()) != null) {
                    str = localPath2;
                }
                layerVideoInfo5.setCurrentVideoUrl(str);
            }
        } else {
            RFWLayerVideoInfo layerVideoInfo7 = mediaInfo.getLayerVideoInfo();
            if (layerVideoInfo7 != null) {
                RFWLayerVideoInfo layerVideoInfo8 = mediaInfo.getLayerVideoInfo();
                if (layerVideoInfo8 != null && (videoOriginUrl = layerVideoInfo8.getVideoOriginUrl()) != null) {
                    str = videoOriginUrl;
                }
                layerVideoInfo7.setCurrentVideoUrl(str);
            }
        }
        if (cookie != null && (layerVideoInfo2 = mediaInfo.getLayerVideoInfo()) != null) {
            layerVideoInfo2.setCookies(cookie);
        }
        if (vid != null && (layerVideoInfo = mediaInfo.getLayerVideoInfo()) != null) {
            layerVideoInfo.setFileId(vid);
        }
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        if (value != null) {
            value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
        }
        getMLayerViewModel().mRichMediaInfo.postValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    private final void H9(long elementId, String path) {
        RFWLayerItemMediaInfo B9 = B9(elementId);
        if (B9 == null) {
            return;
        }
        RFWLayerPicInfo layerPicInfo = B9.getLayerPicInfo();
        if ((layerPicInfo != null ? layerPicInfo.getOriginPicInfo() : null) != null) {
            RFWLayerPicInfo layerPicInfo2 = B9.getLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo2 != null ? layerPicInfo2.getOriginPicInfo() : null;
            if (originPicInfo != null) {
                originPicInfo.setUrl(path);
            }
            RFWLayerPicInfo layerPicInfo3 = B9.getLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo3 != null ? layerPicInfo3.getOriginPicInfo() : null;
            if (originPicInfo2 != null) {
                originPicInfo2.setLocalPath(path);
            }
            RFWLog.i(getTAG(), RFWLog.USR, "onFileTransferEnd update:" + B9.getMediaId() + " path:" + path);
            UIStateData.ModifyListRecord obtainNotifyItemRangeChange = UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(this.mSelectedPosition, 1);
            Intrinsics.checkNotNullExpressionValue(obtainNotifyItemRangeChange, "obtainNotifyItemRangeChange(mSelectedPosition, 1)");
            updateRichMediaList(obtainNotifyItemRangeChange);
            if (B9.getExtraData() instanceof AIOMsgItem) {
                Object extraData = B9.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                MsgElement firstTypeElement = ((AIOMsgItem) extraData).getFirstTypeElement(3);
                if (firstTypeElement != null) {
                    firstTypeElement.fileElement.filePath = path;
                }
            }
        }
    }

    public final AIOMsgItem C9(long msgId) {
        IDataStore<AIOMsgItem> iDataStore = this.msgRecordDataStore;
        AIOMsgItem data = iDataStore != null ? iDataStore.getData(String.valueOf(msgId)) : null;
        if (data != null) {
            return data;
        }
        return null;
    }

    public final void E9(final RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (TextUtils.isEmpty(mediaInfo.getExistSaveOrEditPath()) && (mediaInfo.getExtraData() instanceof AIOMsgItem)) {
            IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class);
            Activity activity = getActivity();
            Object extraData = mediaInfo.getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            iAIOFileManagerApi.downloadFile(activity, (AIOMsgItem) extraData, new Function0<Unit>() { // from class: com.tencent.qqnt.aio.gallery.part.NTGuildAIOLayerControlPart$saveToAlbumInner$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.w
            @Override // java.lang.Runnable
            public final void run() {
                NTGuildAIOLayerControlPart.F9(NTGuildAIOLayerControlPart.this, mediaInfo);
            }
        });
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public boolean downloadPic(RFWLayerItemMediaInfo mediaInfo, RFWLayerPicInfo.PicType picSize) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        if (!(mediaInfo.getExtraData() instanceof AIOMsgItem)) {
            return false;
        }
        Object extraData = mediaInfo.getExtraData();
        Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        MsgRecord msgRecord = ((AIOMsgItem) extraData).getMsgRecord();
        Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.h.f350002a.a(mediaInfo);
        if (a16 == null || com.tencent.qqnt.aio.gallery.e.a(msgRecord, a16.getSecond().intValue()) != 2 || picSize != RFWLayerPicInfo.PicType.ORIGIN) {
            return false;
        }
        com.tencent.qqnt.aio.adapter.richmedia.provider.h e16 = ru3.c.e(ru3.c.f432503a, msgRecord, null, 2, null);
        if (e16 == null) {
            return true;
        }
        e16.g(msgRecord, a16.getSecond().intValue(), 4, null, new b(this, mediaInfo));
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(RFWLayerFileStateChangeEvent.class);
        arrayList.add(MsgRevokeEvent.class);
        arrayList.add(RFWMediaFocusChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart
    protected void initIntentData(Bundle bundle) {
        AIOMsgItem C9;
        RFWLayerPicInfo layerPicInfo;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        com.tencent.mobileqq.richmediabrowser.h.a().n(getActivity().getIntent());
        String string = bundle.getString(GuildGalleryApiImpl.MSG_RECORD_STORE_KEY);
        this.msgRecordDataStoreKey = string;
        if (string != null) {
            this.msgRecordDataStore = RFWLayerDataCenter.INSTANCE.getAllDataStore().get(this.msgRecordDataStoreKey);
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        RFWLayerInitBean rFWLayerInitBean = (RFWLayerInitBean) ((Activity) context).getIntent().getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
        List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerInitBean != null ? rFWLayerInitBean.getRichMediaDataList() : null;
        if (richMediaDataList != null) {
            for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
                Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.h.f350002a.a(rFWLayerItemMediaInfo);
                if (a16 == null || (C9 = C9(a16.getFirst().longValue())) == null) {
                    return;
                }
                MsgRecord msgRecord = C9.getMsgRecord();
                if (msgRecord.elements.size() > a16.getSecond().intValue() && a16.getSecond().intValue() >= 0) {
                    MsgElement msgElement = msgRecord.elements.get(a16.getSecond().intValue());
                    if (rFWLayerItemMediaInfo.getLayerPicInfo() != null && (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) != null) {
                        layerPicInfo.setPicId(String.valueOf(msgElement.elementId));
                    }
                    HashMap<Long, String> hashMap = this.elementIdToMediaId;
                    Long valueOf = Long.valueOf(msgElement.elementId);
                    String mediaId = rFWLayerItemMediaInfo.getMediaId();
                    Intrinsics.checkNotNull(mediaId);
                    hashMap.put(valueOf, mediaId);
                }
                rFWLayerItemMediaInfo.setExtraData(C9);
            }
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerPicLoader(rootView, new com.tencent.qqnt.aio.gallery.pic.a(((IPicAIOApi) QRoute.api(IPicAIOApi.class)).getPicLoader()));
        RFWLayerIOCUtil.registerMediaProvider(rootView, this);
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService != null) {
            msgService.addMsgListener(this.mKernelMsgListener);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.w msgService;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        if (this.msgRecordDataStoreKey != null) {
            RFWLayerDataCenter.INSTANCE.getAllDataStore().remove(this.msgRecordDataStoreKey);
        }
        RFWLayerDataCenter.INSTANCE.clearAllData();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (msgService = iKernelService.getMsgService()) != null) {
            msgService.removeMsgListener(this.mKernelMsgListener);
        }
        Iterator<T> it = this.downloadSuccessVideoElementIds.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.filemanager.core.g.k((String) it.next(), true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        IVideoPlayerProvider mLayerVideoControlProvider;
        if (event instanceof RFWLayerFileStateChangeEvent) {
            RFWLayerFileStateChangeEvent rFWLayerFileStateChangeEvent = (RFWLayerFileStateChangeEvent) event;
            RFWLayerFileDownloadState rFWLayerFileDownloadState = rFWLayerFileStateChangeEvent.mState;
            if ((rFWLayerFileDownloadState != null ? rFWLayerFileDownloadState.getFileState() : null) == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                RFWLog.i("NTGuildAIOLayerControlPart", RFWLog.USR, "downloadSuccess");
                String str = this.mMediaIdToContextId.get(rFWLayerFileStateChangeEvent.mState.getMediaId());
                if (str == null || TextUtils.isEmpty(str)) {
                    return;
                }
                com.tencent.mobileqq.filemanager.core.g.g(str);
                return;
            }
            return;
        }
        if (event instanceof RFWMediaFocusChangeEvent) {
            RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent = (RFWMediaFocusChangeEvent) event;
            if (TextUtils.equals(Constants.Business.QQ_LAYER, rFWMediaFocusChangeEvent.getConflictBusinessName()) && rFWMediaFocusChangeEvent.hasFocusConflict()) {
                IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
                boolean z16 = false;
                if (mLayerVideoControlProvider2 != null && mLayerVideoControlProvider2.isPlaying()) {
                    z16 = true;
                }
                if (z16) {
                    RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
                    Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
                    if (!rFWLayerItemMediaInfo.isVideo() || (mLayerVideoControlProvider = getMLayerVideoControlProvider()) == null) {
                        return;
                    }
                    mLayerVideoControlProvider.stop();
                }
            }
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public void saveToAlbum(RFWLayerItemMediaInfo mediaInfo) {
        boolean contains;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String str = this.mMediaIdToContextId.get(mediaInfo.getMediaId());
        contains = CollectionsKt___CollectionsKt.contains(this.downloadSuccessVideoElementIds, str);
        if (contains) {
            com.tencent.mobileqq.filemanager.core.g.k(str, true);
        }
        E9(mediaInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(FileTransNotifyInfo notifyInfo) {
        RFWLayerFileDownloadState.FileState fileState;
        RFWLayerItemMediaInfo B9;
        boolean z16 = false;
        if (notifyInfo != null && notifyInfo.fileDownType == 1) {
            z16 = true;
        }
        if (z16) {
            int i3 = notifyInfo.trasferStatus;
            if (i3 == 3) {
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOADING;
            } else if (i3 == 4) {
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS;
            } else {
                if (i3 != 5 && i3 != 6) {
                    RFWLayerFileDownloadState.FileState fileState2 = RFWLayerFileDownloadState.FileState.UNKNOWN;
                    return;
                }
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED;
            }
            long j3 = notifyInfo.msgElementId;
            float f16 = (float) notifyInfo.fileProgress;
            long j16 = notifyInfo.totalSize;
            G9(j3, fileState, f16 / ((float) j16), j16);
            if (fileState != RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS || (B9 = B9(notifyInfo.msgElementId)) == null) {
                return;
            }
            if (B9.getLayerVideoInfo() != null) {
                H2(B9, null, null, notifyInfo.filePath, null);
            } else if (B9.getLayerPicInfo() != null) {
                long j17 = notifyInfo.msgElementId;
                String str = notifyInfo.filePath;
                Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.filePath");
                H9(j17, str);
            }
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public boolean getVideoUrl(final RFWLayerItemMediaInfo mediaInfo) {
        final AIOMsgItem C9;
        ArrayList<Long> arrayListOf;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        RFWLog.d(getTAG(), RFWLog.USR, "downloadMedia:" + mediaInfo);
        final Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.h.f350002a.a(mediaInfo);
        if (a16 == null || (C9 = C9(a16.getFirst().longValue())) == null) {
            return false;
        }
        final MsgRecord msgRecord = C9.getMsgRecord();
        final com.tencent.qqnt.aio.adapter.richmedia.provider.h e16 = ru3.c.e(ru3.c.f432503a, msgRecord, null, 2, null);
        RFWLog.i(getTAG(), RFWLog.USR, "[downloadMedia] msgSeq: " + msgRecord.msgSeq + ", type: " + msgRecord.msgType + ", msgId: " + msgRecord.msgId + ", subType: " + msgRecord.subMsgType);
        if (e16 == null) {
            return false;
        }
        final int a17 = com.tencent.qqnt.aio.gallery.e.a(msgRecord, a16.getSecond().intValue());
        if (a17 != 3 && a17 != 4) {
            return false;
        }
        RFWLog.i(getTAG(), RFWLog.USR, "download video:" + mediaInfo.getMediaId());
        if (C9.s0() == null && C9.k0() == null) {
            e16.g(msgRecord, a16.getSecond().intValue(), a17, null, new b(this, mediaInfo));
            return true;
        }
        com.tencent.qqnt.kernel.api.w e17 = com.tencent.qqnt.msg.f.e();
        if (e17 == null) {
            return true;
        }
        Contact contact = new Contact(C9.p0(), C9.r0(), "");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(C9.q0()));
        e17.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.qqnt.aio.gallery.part.x
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                NTGuildAIOLayerControlPart.D9(com.tencent.qqnt.aio.adapter.richmedia.provider.h.this, a16, a17, msgRecord, this, mediaInfo, C9, i3, str, arrayList);
            }
        });
        return true;
    }
}
