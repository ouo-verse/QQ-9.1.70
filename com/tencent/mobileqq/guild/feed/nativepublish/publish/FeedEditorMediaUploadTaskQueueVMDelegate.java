package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import cm1.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskOperationCreatedEvent;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018`\u0019H\u0016J\"\u0010!\u001a\u00020\u00062\u0010\u0010\u001e\u001a\f\u0012\u0004\u0012\u00020\u001c0\u001bj\u0002`\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016R\u001a\u0010(\u001a\u00020#8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R7\u0010/\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020*0)j\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020*`+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010,\u001a\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/FeedEditorMediaUploadTaskQueueVMDelegate;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/publish/event/GuildTaskOperationCreatedEvent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasRestore;", "event", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasUpload;", "o", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasCancelUpload;", "l", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasModify;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", h.F, "Ljava/lang/String;", "i", "()Ljava/lang/String;", "logTag", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/HashMap;", "Lkotlin/Lazy;", "j", "()Ljava/util/HashMap;", "mediaUploadTaskMap", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "retrieveFileSizeJob", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorMediaUploadTaskQueueVMDelegate extends com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a implements SimpleEventReceiver<GuildTaskOperationCreatedEvent> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaUploadTaskMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job retrieveFileSizeJob;

    public FeedEditorMediaUploadTaskQueueVMDelegate() {
        super(null, 1, null);
        Lazy lazy;
        this.logTag = "FeedEditor.MediaUploadTaskQueue";
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<HashMap<String, LocalMediaInfo>>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.publish.FeedEditorMediaUploadTaskQueueVMDelegate$mediaUploadTaskMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, LocalMediaInfo> invoke() {
                return new HashMap<>();
            }
        });
        this.mediaUploadTaskMap = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, LocalMediaInfo> j() {
        return (HashMap) this.mediaUploadTaskMap.getValue();
    }

    private final void k() {
        if (j().size() > 0) {
            QLog.d(getLogTag(), 4, "[handleOnTriggerUploadMediaEvent], upload existed media count: " + j().size());
            p();
        }
    }

    private final void l(FeedEditorContentMsgIntent.TriggerMediasCancelUpload event) {
        Iterator<T> it = event.a().iterator();
        while (it.hasNext()) {
            j().remove((String) it.next());
        }
        p();
    }

    private final void m(FeedEditorContentMsgIntent.TriggerMediasModify event) {
        Iterator<T> it = event.b().iterator();
        while (it.hasNext()) {
            j().remove((String) it.next());
        }
        j().putAll(event.a());
        p();
        q();
    }

    private final void n(FeedEditorContentMsgIntent.TriggerMediasRestore event) {
        LifecycleOwner d16 = c().d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), ae.a().c(), null, new FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1(this, event, null), 2, null);
    }

    private final void o(FeedEditorContentMsgIntent.TriggerMediasUpload event) {
        j().putAll(event.a());
        p();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        in1.c uploadTaskApi;
        in1.d b16 = com.tencent.mobileqq.guild.feed.nativepublish.utils.a.b(c());
        if (b16 != null && (uploadTaskApi = b16.getUploadTaskApi()) != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(j());
            Unit unit = Unit.INSTANCE;
            uploadTaskApi.h("FeedEditor", hashMap);
        }
    }

    private final void q() {
        Job launch$default;
        boolean z16;
        Job job = this.retrieveFileSizeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        HashMap<String, LocalMediaInfo> j3 = j();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, LocalMediaInfo> entry : j3.entrySet()) {
            if (entry.getValue().fileSize <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        LifecycleOwner d16 = c().d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), ae.a().a(), null, new FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1(linkedHashMap, this, null), 2, null);
        this.retrieveFileSizeJob = launch$default;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedEditorContentMsgIntent.TriggerMediasUpload) {
            o((FeedEditorContentMsgIntent.TriggerMediasUpload) event);
            return;
        }
        if (event instanceof FeedEditorContentMsgIntent.TriggerMediasCancelUpload) {
            l((FeedEditorContentMsgIntent.TriggerMediasCancelUpload) event);
        } else if (event instanceof FeedEditorContentMsgIntent.TriggerMediasModify) {
            m((FeedEditorContentMsgIntent.TriggerMediasModify) event);
        } else if (event instanceof FeedEditorContentMsgIntent.TriggerMediasRestore) {
            n((FeedEditorContentMsgIntent.TriggerMediasRestore) event);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    @NotNull
    public k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, FeedEditorContentMsgIntent.FetchMediaUploadTasks.f221790d)) {
            return new a.FetchMediasUploadTaskMsgResult(j());
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    /* renamed from: e */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.b(context, reuse);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildTaskOperationCreatedEvent>> getEventClass() {
        ArrayList<Class<GuildTaskOperationCreatedEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildTaskOperationCreatedEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.TriggerMediasUpload");
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.TriggerMediasModify");
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.TriggerMediasCancelUpload");
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.TriggerMediasRestore");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.FetchMediaUploadTasks");
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: i, reason: from getter */
    public String getLogTag() {
        return this.logTag;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildTaskOperationCreatedEvent) {
            k();
        }
    }
}
