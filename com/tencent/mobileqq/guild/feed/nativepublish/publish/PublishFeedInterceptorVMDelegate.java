package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.input.base.mvicompat.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import java.util.HashSet;
import java.util.List;
import jm1.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import yl1.n;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u00012\u00020\u0005:\u0001-B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JQ\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\nj\u0002`\u0013H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002JQ\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\nj\u0002`\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0016J\"\u0010\u001f\u001a\u00020\u00192\u0010\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R \u0010*\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/PublishFeedInterceptorVMDelegate;", "Lcom/tencent/input/base/mvicompat/f;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/input/base/mvicompat/ex/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$CheckPublishRestriction;", "event", "Ljm1/a$a;", "i", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "originFeedJsonString", "Lorg/json/JSONObject;", "feedJSONObject", "editorParam", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/CheckRestrictionInterceptor;", h.F, "feedJsonObject", "param", "f", "g", "", "k", "", "f0", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "j", "Lcom/tencent/mvi/base/route/MsgIntent;", "Lcom/tencent/mvi/base/route/k;", "I", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "d", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messageHandlerSupport", "e", "Lcom/tencent/base/api/runtime/a;", "editorContext", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PublishFeedInterceptorVMDelegate implements f<com.tencent.base.api.runtime.a<zl1.a>>, com.tencent.input.base.mvicompat.ex.a {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f222214f = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport messageHandlerSupport = new VMMessengerProtocolSupport(this);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.base.api.runtime.a<zl1.a> editorContext;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/PublishFeedInterceptorVMDelegate$a;", "", "", "BLANK_CONTENT_TYPE", "I", "CONTENT_TYPE_SIZE_TO_BREAK_LOOP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(JSONObject feedJsonObject, zl1.a param) {
        boolean z16;
        JSONObject optJSONObject = feedJsonObject.optJSONObject("atNums");
        if (optJSONObject != null && ax.g(param.h(), optJSONObject)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        feedJsonObject.remove("atNums");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function3<String, JSONObject, zl1.a, Boolean> g() {
        return new Function3<String, JSONObject, zl1.a, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.publish.PublishFeedInterceptorVMDelegate$checkEmptyContentRestriction$1
            /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
            @Override // kotlin.jvm.functions.Function3
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Boolean invoke(@NotNull String str, @NotNull JSONObject feedJSONObject, @NotNull zl1.a editorParam) {
                JSONArray optJSONArray;
                boolean z16;
                boolean isBlank;
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(feedJSONObject, "feedJSONObject");
                Intrinsics.checkNotNullParameter(editorParam, "editorParam");
                JSONArray optJSONArray2 = feedJSONObject.optJSONArray("videos");
                int length = optJSONArray2 != null ? optJSONArray2.length() : 0;
                JSONArray optJSONArray3 = feedJSONObject.optJSONArray("images");
                if (length + (optJSONArray3 != null ? optJSONArray3.length() : 0) > 0) {
                    return Boolean.FALSE;
                }
                HashSet hashSet = new HashSet();
                JSONObject optJSONObject = feedJSONObject.optJSONObject("contents");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("contents")) != null) {
                    int length2 = optJSONArray.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        int i16 = jSONObject.getInt("type");
                        if (!hashSet.contains(1) && i16 == 1) {
                            String string = jSONObject.getJSONObject("text_content").getString("text");
                            if (string != null) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(string);
                                if (!isBlank) {
                                    z16 = false;
                                    if (!z16) {
                                        hashSet.add(-99);
                                    } else {
                                        hashSet.add(Integer.valueOf(i16));
                                    }
                                }
                            }
                            z16 = true;
                            if (!z16) {
                            }
                        } else if (i16 != 0) {
                            hashSet.add(Integer.valueOf(i16));
                        }
                        if (hashSet.size() > 3) {
                            break;
                        }
                    }
                }
                hashSet.remove(8);
                hashSet.remove(9);
                hashSet.remove(-99);
                if (!hashSet.isEmpty()) {
                    return Boolean.FALSE;
                }
                n.A(0, "\u8bf7\u8f93\u5165\u5185\u5bb9");
                km1.a.f412694a.f(editorParam, 100006, "\u8bf7\u8f93\u5165\u5185\u5bb9");
                return Boolean.TRUE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function3<String, JSONObject, zl1.a, Boolean> h() {
        return new Function3<String, JSONObject, zl1.a, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.publish.PublishFeedInterceptorVMDelegate$checkGuildMiscRestriction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            @NotNull
            public final Boolean invoke(@NotNull String originFeedJsonString, @NotNull JSONObject feedJSONObject, @NotNull zl1.a editorParam) {
                boolean f16;
                Intrinsics.checkNotNullParameter(originFeedJsonString, "originFeedJsonString");
                Intrinsics.checkNotNullParameter(feedJSONObject, "feedJSONObject");
                Intrinsics.checkNotNullParameter(editorParam, "editorParam");
                if (!zl1.b.m(editorParam)) {
                    f16 = PublishFeedInterceptorVMDelegate.this.f(feedJSONObject, editorParam);
                    if (f16) {
                        km1.a.f412694a.f(editorParam, 100005, "contain prohibited words");
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }
                return Boolean.FALSE;
            }
        };
    }

    private final a.CheckPublishRestrictionResult i(PublishFeedMsgIntent.CheckPublishRestriction event) {
        boolean z16 = false;
        KFunction[] kFunctionArr = {new PublishFeedInterceptorVMDelegate$handleCheckPublishRestriction$intercepted$1(this), new PublishFeedInterceptorVMDelegate$handleCheckPublishRestriction$intercepted$2(this)};
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                break;
            }
            Function3 function3 = (Function3) ((Function0) kFunctionArr[i3]).invoke();
            String feedJsonString = event.getFeedJsonString();
            JSONObject jsonFeedKeyJsonObject = event.getJsonFeedKeyJsonObject();
            com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                aVar = null;
            }
            zl1.a h16 = aVar.h();
            Intrinsics.checkNotNullExpressionValue(h16, "editorContext.baseParam");
            if (((Boolean) function3.invoke(feedJsonString, jsonFeedKeyJsonObject, h16)).booleanValue()) {
                z16 = true;
                break;
            }
            i3++;
        }
        return new a.CheckPublishRestrictionResult(!z16);
    }

    private final void k() {
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.editorContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorContext");
            aVar = null;
        }
        zl1.a h16 = aVar.h();
        Intrinsics.checkNotNullExpressionValue(h16, "editorContext.baseParam");
        if (!zl1.b.j(h16)) {
            com.tencent.base.api.runtime.a<zl1.a> aVar2 = this.editorContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editorContext");
                aVar2 = null;
            }
            final String h17 = aVar2.h().h();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.publish.b
                @Override // java.lang.Runnable
                public final void run() {
                    PublishFeedInterceptorVMDelegate.l(h17);
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).preloadSpeakRule(guildId, null);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent msgIntent) {
        a.C5857a.c(this, msgIntent);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PublishFeedMsgIntent.CheckPublishRestriction) {
            return i((PublishFeedMsgIntent.CheckPublishRestriction) event);
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @Nullable
    public List<String> J2() {
        return a.C5857a.a(this);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> f0() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(PublishFeedMsgIntent.CheckPublishRestriction.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.editorContext = context;
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageHandlerSupport;
        j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        vMMessengerProtocolSupport.d(e16);
        k();
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
    }
}
