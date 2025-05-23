package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import cm1.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.input.base.mvicompat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.data.m;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishFeedTaskRebindInfoEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTriggerPublishOperationEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jm1.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import yl1.i;
import yl1.n;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u00012\u00020\u0005:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0013\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cH\u0016J\"\u0010 \u001a\u00020\u00062\u0010\u0010\u001e\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R \u0010'\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R(\u0010-\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00102\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/PublishFeedVMDelegate;", "Lcom/tencent/input/base/mvicompat/f;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/input/base/mvicompat/ex/a;", "", "k", "", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", DomainData.DOMAIN_NAME, "j", "p", "editorParam", "g", "Lcm1/a$b;", "feedJsonMsgResult", "i", "", "publishJsonFeed", "o", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/data/m;", "contact", h.F, "", "J2", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/base/api/runtime/a;", "editorContext", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "e", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messageHandlerSupport", "Lcom/tencent/input/base/mvicompat/f;", "patch", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "currentTriggerPostJob", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "pendingTriggerPostRunnable", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PublishFeedVMDelegate implements f<com.tencent.base.api.runtime.a<zl1.a>>, com.tencent.input.base.mvicompat.ex.a {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final a f222217m = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.base.api.runtime.a<zl1.a> editorContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport messageHandlerSupport = new VMMessengerProtocolSupport(this);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f<com.tencent.base.api.runtime.a<zl1.a>> patch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job currentTriggerPostJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable pendingTriggerPostRunnable;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/PublishFeedVMDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Integer) ((Pair) t16).getFirst(), (Integer) ((Pair) t17).getFirst());
            return compareValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x008f -> B:10:0x0092). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(Continuation<? super Boolean> continuation) {
        PublishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1 publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1;
        Object coroutine_suspended;
        int i3;
        List sortedWith;
        Iterator it;
        if (continuation instanceof PublishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1) {
            publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1 = (PublishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1) continuation;
            int i16 = publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.label = i16 - Integer.MIN_VALUE;
                Object obj = publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.label;
                boolean z16 = false;
                if (i3 == 0) {
                    if (i3 == 1) {
                        it = (Iterator) publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                            z16 = true;
                            return Boxing.boxBoolean(z16);
                        }
                        if (it.hasNext()) {
                            Function1 function1 = (Function1) ((Pair) it.next()).getSecond();
                            publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.L$0 = it;
                            publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.label = 1;
                            obj = function1.invoke(publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) obj).booleanValue()) {
                            }
                            if (it.hasNext()) {
                            }
                        }
                        return Boxing.boxBoolean(z16);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PublishFeedMsgIntent.FindPublishInterceptor findPublishInterceptor = new PublishFeedMsgIntent.FindPublishInterceptor();
                com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                    aVar = null;
                }
                aVar.e().h(findPublishInterceptor);
                sortedWith = CollectionsKt___CollectionsKt.sortedWith(findPublishInterceptor.b(), new b());
                List list = sortedWith;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    it = list.iterator();
                    if (it.hasNext()) {
                    }
                }
                return Boxing.boxBoolean(z16);
            }
        }
        publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1 = new PublishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1(this, continuation);
        Object obj2 = publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = publishFeedVMDelegate$checkContentRestrictionBeforeGenerateJson$1.label;
        boolean z162 = false;
        if (i3 == 0) {
        }
    }

    private final boolean g(zl1.a editorParam) {
        if (!zl1.b.k(editorParam) && TextUtils.isEmpty(editorParam.getContact().getGuildId())) {
            n.z(0, R.string.f144960q7);
            km1.a.f412694a.f(editorParam, 100007, "\u8bf7\u9009\u62e9\u53d1\u8868\u7684\u9891\u9053");
            return true;
        }
        if (zl1.b.i(editorParam) && i.f450608a.k(zl1.b.l(editorParam))) {
            QLog.e("FeedEditor.PublishFeedVMDelegate", 1, "triggerPublish|ForceChannelSelected and PartNotSelected.");
            km1.a.f412694a.f(editorParam, 100003, "\u53d1\u5e16\u5fc5\u987b\u9009\u677f\u5757");
            if (!zl1.b.h(editorParam)) {
                n.z(0, R.string.f144700ph);
                return true;
            }
            com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                aVar = null;
            }
            aVar.e().h(new GuildFeedPublishFunctionBarMsgIntent.OpenPartPanel());
            return true;
        }
        if (editorParam.getIsEdition() || zl1.b.m(editorParam) || h(editorParam.getContact())) {
            return false;
        }
        km1.a.f412694a.f(editorParam, 100008, "\u5b50\u9891\u9053\u4e0d\u5b58\u5728");
        return true;
    }

    private final boolean h(m contact) {
        int i3;
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isChannelExist(contact.getChannelId())) {
            return true;
        }
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isChannelGray(contact.getGuildId())) {
            i3 = R.string.f144900q1;
        } else {
            i3 = R.string.f144880pz;
        }
        n.z(1, i3);
        return false;
    }

    private final boolean i(a.MakeJsonMsgResult feedJsonMsgResult) {
        boolean z16;
        a.CheckPublishRestrictionResult checkPublishRestrictionResult;
        boolean z17;
        com.tencent.base.api.runtime.a<zl1.a> aVar = null;
        try {
            String it = feedJsonMsgResult.getFeedJSONObject().optString("jsonFeed");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                it = null;
            }
            if (it == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(it);
            com.tencent.base.api.runtime.a<zl1.a> aVar2 = this.editorContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                aVar2 = null;
            }
            k k3 = aVar2.e().k(new PublishFeedMsgIntent.CheckPublishRestriction(feedJsonMsgResult.getFeedJson(), jSONObject));
            if (k3 != null && (k3 instanceof a.CheckPublishRestrictionResult)) {
                checkPublishRestrictionResult = (a.CheckPublishRestrictionResult) k3;
            } else {
                checkPublishRestrictionResult = null;
            }
            if (checkPublishRestrictionResult != null && checkPublishRestrictionResult.getPass()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
            QLog.i("FeedEditor.PublishFeedVMDelegate", 1, "triggerPublish| content intercepted");
            return false;
        } catch (Exception e16) {
            QLog.e("FeedEditor.PublishFeedVMDelegate", 1, "triggerPublish|" + e16);
            km1.a aVar3 = km1.a.f412694a;
            com.tencent.base.api.runtime.a<zl1.a> aVar4 = this.editorContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            } else {
                aVar = aVar4;
            }
            zl1.a h16 = aVar.h();
            Intrinsics.checkNotNullExpressionValue(h16, "editorContext.baseParam");
            zl1.a aVar5 = h16;
            String message = e16.getMessage();
            if (message == null) {
                message = "";
            }
            aVar3.f(aVar5, 100000, message);
            return false;
        }
    }

    private final void j() {
        Runnable runnable = this.pendingTriggerPostRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    private final void k() {
        Job launch$default;
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        com.tencent.base.api.runtime.a<zl1.a> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        aVar.h().getMutableGlobalSharedState().b(true);
        Job job = this.currentTriggerPostJob;
        boolean z16 = false;
        if (job != null && !job.isCompleted()) {
            z16 = true;
        }
        if (z16) {
            com.tencent.base.api.runtime.a<zl1.a> aVar3 = this.editorContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            } else {
                aVar2 = aVar3;
            }
            QLog.d("FeedEditor.PublishFeedVMDelegate", 1, "[handleTriggerPublish]: currentJob is not completed, taskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(aVar2));
            return;
        }
        com.tencent.base.api.runtime.a<zl1.a> aVar4 = this.editorContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar4 = null;
        }
        LifecycleOwner d16 = aVar4.d();
        Intrinsics.checkNotNullExpressionValue(d16, "editorContext.lifecycleOwner");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), null, null, new PublishFeedVMDelegate$handleTriggerPublish$1(this, null), 3, null);
        this.currentTriggerPostJob = launch$default;
    }

    private final SimpleBaseEvent m(zl1.a editorParam, String taskId) {
        boolean z16;
        Set of5;
        FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent = new FeedEditorEvent.OnStartPublishFeedEvent(editorParam.getExtra().getInt("launch_request_id"), taskId, editorParam.getIsFeedBeingEditedPublished(), editorParam.getContact(), zl1.b.j(editorParam));
        Bundle bundle = editorParam.getExtra().getBundle("topic_element_append");
        if (bundle != null) {
            Long valueOf = Long.valueOf(bundle.getLong("topic_id"));
            if (valueOf.longValue() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                valueOf = null;
            }
            if (valueOf != null) {
                of5 = SetsKt__SetsJVMKt.setOf(Long.valueOf(valueOf.longValue()));
                onStartPublishFeedEvent.setTopicIds(of5);
            }
        }
        return onStartPublishFeedEvent;
    }

    private final void n() {
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        com.tencent.base.api.runtime.a<zl1.a> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        GuildPublishFeedTaskRebindInfoEvent guildPublishFeedTaskRebindInfoEvent = new GuildPublishFeedTaskRebindInfoEvent(aVar.h().m());
        com.tencent.base.api.runtime.a<zl1.a> aVar3 = this.editorContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar3 = null;
        }
        String h16 = aVar3.h().h();
        com.tencent.base.api.runtime.a<zl1.a> aVar4 = this.editorContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar4 = null;
        }
        guildPublishFeedTaskRebindInfoEvent.setContact(new GuildSimpleContact(h16, aVar4.h().a()));
        com.tencent.base.api.runtime.a<zl1.a> aVar5 = this.editorContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar5 = null;
        }
        zl1.a h17 = aVar5.h();
        Intrinsics.checkNotNullExpressionValue(h17, "editorContext.baseParam");
        guildPublishFeedTaskRebindInfoEvent.setBusinessType(zl1.b.e(h17));
        com.tencent.base.api.runtime.a<zl1.a> aVar6 = this.editorContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar6 = null;
        }
        zl1.a h18 = aVar6.h();
        Intrinsics.checkNotNullExpressionValue(h18, "editorContext.baseParam");
        if (zl1.b.j(h18)) {
            com.tencent.base.api.runtime.a<zl1.a> aVar7 = this.editorContext;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            } else {
                aVar2 = aVar7;
            }
            zl1.a h19 = aVar2.h();
            Intrinsics.checkNotNullExpressionValue(h19, "editorContext.baseParam");
            guildPublishFeedTaskRebindInfoEvent.setPersonalGuildToBeCreated(Boolean.valueOf(zl1.b.m(h19)));
        }
        bl.c().a(guildPublishFeedTaskRebindInfoEvent);
    }

    private final void o(String publishJsonFeed) {
        Map<String, LocalMediaInfo> emptyMap;
        boolean z16;
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        k kVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        zl1.a editorParam = aVar.h();
        String m3 = editorParam.m();
        com.tencent.base.api.runtime.a<zl1.a> aVar2 = this.editorContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar2 = null;
        }
        k k3 = aVar2.e().k(FeedEditorContentMsgIntent.FetchMediaUploadTasks.f221790d);
        if (k3 instanceof a.FetchMediasUploadTaskMsgResult) {
            kVar = k3;
        }
        a.FetchMediasUploadTaskMsgResult fetchMediasUploadTaskMsgResult = (a.FetchMediasUploadTaskMsgResult) kVar;
        if (fetchMediasUploadTaskMsgResult == null || (emptyMap = fetchMediasUploadTaskMsgResult.a()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        bl c16 = bl.c();
        Intrinsics.checkNotNullExpressionValue(editorParam, "editorParam");
        c16.a(m(editorParam, m3));
        bl c17 = bl.c();
        GuildTriggerPublishOperationEvent guildTriggerPublishOperationEvent = new GuildTriggerPublishOperationEvent();
        guildTriggerPublishOperationEvent.setMainTaskId(m3);
        guildTriggerPublishOperationEvent.setJson(publishJsonFeed);
        guildTriggerPublishOperationEvent.mediaInfoMap = emptyMap;
        guildTriggerPublishOperationEvent.setBusinessType(editorParam.getExtra().getInt("feed_card_page_source"));
        guildTriggerPublishOperationEvent.setPersonalGuildToBeCreated(zl1.b.m(editorParam));
        if (editorParam.getIsEdition() && editorParam.getIsFeedBeingEditedPublished()) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildTriggerPublishOperationEvent.setIsEdit(z16);
        guildTriggerPublishOperationEvent.setNewFeed(!editorParam.getIsEdition());
        guildTriggerPublishOperationEvent.showSuccessToast = editorParam.getExtra().getBoolean("show_success_toast_flag", zl1.b.o(editorParam));
        guildTriggerPublishOperationEvent.showFailToast = editorParam.getExtra().getBoolean("show_fail_toast_flag", true);
        c17.a(guildTriggerPublishOperationEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        final a.MakeJsonMsgResult makeJsonMsgResult;
        boolean z16;
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        com.tencent.base.api.runtime.a<zl1.a> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        zl1.a editorParam = aVar.h();
        km1.a aVar3 = km1.a.f412694a;
        com.tencent.base.api.runtime.a<zl1.a> aVar4 = this.editorContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar4 = null;
        }
        aVar3.b(aVar4);
        com.tencent.base.api.runtime.a<zl1.a> aVar5 = this.editorContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar5 = null;
        }
        k k3 = aVar5.e().k(FeedEditorContentMsgIntent.MakeJsonForPost.f221794d);
        if (k3 != null && (k3 instanceof a.MakeJsonMsgResult)) {
            makeJsonMsgResult = (a.MakeJsonMsgResult) k3;
        } else {
            makeJsonMsgResult = null;
        }
        if (makeJsonMsgResult != null) {
            if (makeJsonMsgResult.getFeedJson().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i("FeedEditor.PublishFeedVMDelegate", 1, "publish. feedJson.length: " + makeJsonMsgResult.getFeedJson().length());
                if (!i(makeJsonMsgResult)) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(editorParam, "editorParam");
                if (g(editorParam)) {
                    return;
                }
                try {
                    com.tencent.base.api.runtime.a<zl1.a> aVar6 = this.editorContext;
                    if (aVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                        aVar6 = null;
                    }
                    aVar6.e().h(FeedEditorContentMsgIntent.OnTriggerPublishEvent.f221796d);
                    this.pendingTriggerPostRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.publish.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            PublishFeedVMDelegate.q(PublishFeedVMDelegate.this, makeJsonMsgResult);
                        }
                    };
                    com.tencent.base.api.runtime.a<zl1.a> aVar7 = this.editorContext;
                    if (aVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                    } else {
                        aVar2 = aVar7;
                    }
                    aVar2.e().h(new FeedEditorRootMsgIntent.TriggerCloseEditorAnyway(1));
                    return;
                } catch (Exception e16) {
                    QLog.e("FeedEditor.PublishFeedVMDelegate", 1, "triggerPublish|" + e16);
                    return;
                }
            }
        }
        QLog.e("FeedEditor.PublishFeedVMDelegate", 1, "triggerPublish|GetFeedJsonResult error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(PublishFeedVMDelegate this$0, a.MakeJsonMsgResult makeJsonMsgResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(makeJsonMsgResult.getFeedJson());
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PublishFeedMsgIntent.TriggerPublish) {
            k();
        } else if (event instanceof PublishFeedMsgIntent.RebindMainTaskToCurrentGuildInfo) {
            n();
        } else if (event instanceof FeedEditorRootMsgIntent.OnFinishActivityMsgIntent) {
            j();
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public k I(@NotNull MsgIntent msgIntent) {
        return a.C5857a.d(this, msgIntent);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> J2() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(PublishFeedMsgIntent.TriggerPublish.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        String b17 = com.tencent.mvi.base.route.c.b(PublishFeedMsgIntent.RebindMainTaskToCurrentGuildInfo.class);
        Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
        String b18 = com.tencent.mvi.base.route.c.b(FeedEditorRootMsgIntent.OnFinishActivityMsgIntent.class);
        Intrinsics.checkNotNullExpressionValue(b18, "get(java)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b16, b17, b18});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @Nullable
    public List<String> f0() {
        return a.C5857a.b(this);
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.editorContext = context;
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageHandlerSupport;
        j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        vMMessengerProtocolSupport.d(e16);
        f<com.tencent.base.api.runtime.a<zl1.a>> a16 = c.INSTANCE.a(context);
        this.patch = a16;
        if (a16 != null) {
            a16.b(context, reuse);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageHandlerSupport;
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        j e16 = aVar.e();
        Intrinsics.checkNotNullExpressionValue(e16, "editorContext.messenger");
        vMMessengerProtocolSupport.e(e16);
        f<com.tencent.base.api.runtime.a<zl1.a>> fVar = this.patch;
        if (fVar != null) {
            fVar.onDestroy();
        }
    }
}
