package com.tencent.mobileqq.guild.feed.nativepublish.usecase;

import android.text.Editable;
import cm1.a;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.a;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.r;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.i;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.k;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nm1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import tm1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u00013By\u0012p\b\u0002\u0010!\u001aj\u0012f\u0012d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012,\u0012*\u0012\u0004\u0012\u00020\u00180\u0017j\u0011`\u0019\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0012j\u0002`\u001e0\u0011\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R|\u0010!\u001aj\u0012f\u0012d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012,\u0012*\u0012\u0004\u0012\u00020\u00180\u0017j\u0011`\u0019\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0012j\u0002`\u001e0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\u00020\u00068\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%RX\u00100\u001a8\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)0'j\u0002`*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/FeedEditorContentVMDelegate;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/a;", "Lcom/tencent/mvi/base/route/k;", "o", DomainData.DOMAIN_NAME, "p", "", "r", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/r$a;", "mediaResult", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i$b;", "k", "Lorg/json/JSONArray;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "I", "", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "toolType", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "Lnm1/b;", "translateInfo", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/JsonGeneratorExtensionFun;", h.F, "[Lkotlin/jvm/functions/Function3;", "translateToJsonExtensions", "i", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "logTag", "Lkotlin/Function2;", "interceptPolicy", "Ltm1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/TranslateToolSupplier;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "setTranslateToolSupplier", "(Lkotlin/jvm/functions/Function2;)V", "translateToolSupplier", "<init>", "([Lkotlin/jvm/functions/Function3;)V", "IncompleteWorkException", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorContentVMDelegate extends com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<Integer, com.tencent.base.api.runtime.a<zl1.a>, b, Unit>[] translateToJsonExtensions;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function2<? super Integer, ? super i.b, ? extends tm1.a> translateToolSupplier;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/FeedEditorContentVMDelegate$IncompleteWorkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class IncompleteWorkException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncompleteWorkException(@NotNull String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorContentVMDelegate(@NotNull Function3<Integer, com.tencent.base.api.runtime.a<zl1.a>, b, Unit>[] translateToJsonExtensions) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(translateToJsonExtensions, "translateToJsonExtensions");
        this.translateToJsonExtensions = translateToJsonExtensions;
        this.logTag = "FeedEditor.JsonGenerator";
        this.translateToolSupplier = new Function2<Integer, i.b, tm1.a>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.usecase.FeedEditorContentVMDelegate$translateToolSupplier$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ tm1.a invoke(Integer num, i.b bVar) {
                return invoke(num.intValue(), bVar);
            }

            @NotNull
            public final tm1.a invoke(int i3, @Nullable i.b bVar) {
                if (bVar == null) {
                    return e.f436596a.b(i3);
                }
                return e.f436596a.a(i3, new i(null, bVar, 1, null), new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e[0]);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i.b k(r.GetMediaListResult mediaResult) {
        if (mediaResult.getIsRemoveGameCenterShareMedia()) {
            return new k();
        }
        return null;
    }

    private final com.tencent.mvi.base.route.k n() {
        a.b bVar;
        r.GetMediaListResult getMediaListResult;
        a.MakeJsonMsgResult makeJsonMsgResult = null;
        try {
            com.tencent.mvi.base.route.k k3 = c().e().k(GuildFeedEditTextMsgIntent.GetEditableText.f221829d);
            Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgResult.GetEditableTextResult");
            bVar = (a.b) k3;
            com.tencent.mvi.base.route.k k16 = c().e().k(FeedEditorMediaMsgIntent.GetMediaList.f222118d);
            if (k16 instanceof r.GetMediaListResult) {
                getMediaListResult = (r.GetMediaListResult) k16;
            } else {
                getMediaListResult = null;
            }
        } catch (IncompleteWorkException e16) {
            QLog.e(getLogTag(), 1, "[handleMakeJsonForDraft]: incomplete exception, " + e16.getMessage());
        }
        if (getMediaListResult != null) {
            b bVar2 = new b(c(), bVar.getEditable(), getMediaListResult.a(), getMediaListResult.getUnmodifiableMediaCount());
            for (Function3 function3 : this.translateToJsonExtensions) {
                function3.invoke(3, c(), bVar2);
            }
            String jSONObject = m().invoke(3, k(getMediaListResult)).a(bVar2).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "translateToolSupplier(TR\u2026              .toString()");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, c().h().m());
            jSONObject2.put("sceneType", c().h().getSceneType());
            jSONObject2.put("originJsonFeed", c().h().getJsonFeed());
            jSONObject2.put("contentJsonFeed", jSONObject);
            String jSONObject3 = jSONObject2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "it.toString()");
            makeJsonMsgResult = new a.MakeJsonMsgResult(jSONObject3, jSONObject2);
            if (makeJsonMsgResult == null) {
                return new com.tencent.input.base.utils.a();
            }
            return makeJsonMsgResult;
        }
        throw new IncompleteWorkException("GetMediaList Failed, mainTaskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(c()));
    }

    private final com.tencent.mvi.base.route.k o() {
        a.MakeJsonMsgResult makeJsonMsgResult;
        try {
            String r16 = r();
            JSONArray q16 = q();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("taskIds", q16);
            jSONObject.put("jsonFeed", r16);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.toString()");
            makeJsonMsgResult = new a.MakeJsonMsgResult(jSONObject2, jSONObject);
        } catch (IncompleteWorkException e16) {
            QLog.e(getLogTag(), 1, "[handleMakeJsonForPost]: incomplete exception, " + e16.getMessage());
            makeJsonMsgResult = null;
        }
        if (makeJsonMsgResult == null) {
            return new com.tencent.input.base.utils.a();
        }
        return makeJsonMsgResult;
    }

    private final com.tencent.mvi.base.route.k p() {
        List emptyList;
        a.MakeJsonMsgResult makeJsonMsgResult = null;
        try {
            com.tencent.mvi.base.route.k k3 = c().e().k(GuildFeedEditTextMsgIntent.GetEditableText.f221829d);
            Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgResult.GetEditableTextResult");
            com.tencent.base.api.runtime.a<zl1.a> c16 = c();
            Editable editable = ((a.b) k3).getEditable();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            b bVar = new b(c16, editable, emptyList, 0);
            for (Function3 function3 : this.translateToJsonExtensions) {
                function3.invoke(1, c(), bVar);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jsonFeed", m().invoke(1, null).a(bVar).toString());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.toString()");
            makeJsonMsgResult = new a.MakeJsonMsgResult(jSONObject2, jSONObject);
        } catch (IncompleteWorkException e16) {
            QLog.e(getLogTag(), 1, "[handleMakeJsonForSwitchToH5]: incomplete exception, " + e16.getMessage());
        }
        if (makeJsonMsgResult == null) {
            return new com.tencent.input.base.utils.a();
        }
        return makeJsonMsgResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONArray q() {
        r.GetMediaListResult getMediaListResult;
        List<fm1.i> emptyList;
        com.tencent.mvi.base.route.k k3 = c().e().k(FeedEditorMediaMsgIntent.GetMediaList.f222118d);
        if (k3 instanceof r.GetMediaListResult) {
            getMediaListResult = (r.GetMediaListResult) k3;
        } else {
            getMediaListResult = null;
        }
        if (getMediaListResult == null || (emptyList = getMediaListResult.a()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<fm1.i> it = emptyList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String r() {
        a.b bVar;
        List emptyList;
        com.tencent.mvi.base.route.k k3 = c().e().k(GuildFeedEditTextMsgIntent.GetEditableText.f221829d);
        r.GetMediaListResult getMediaListResult = null;
        if (k3 instanceof a.b) {
            bVar = (a.b) k3;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            com.tencent.mvi.base.route.k k16 = c().e().k(FeedEditorMediaMsgIntent.GetMediaList.f222118d);
            if (k16 instanceof r.GetMediaListResult) {
                getMediaListResult = (r.GetMediaListResult) k16;
            }
            if (getMediaListResult == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                getMediaListResult = new r.GetMediaListResult(emptyList, 0, false, 4, null);
            }
            b bVar2 = new b(c(), bVar.getEditable(), getMediaListResult.a(), getMediaListResult.getUnmodifiableMediaCount());
            for (Function3<Integer, com.tencent.base.api.runtime.a<zl1.a>, b, Unit> function3 : this.translateToJsonExtensions) {
                function3.invoke(1, c(), bVar2);
            }
            String jSONObject = this.translateToolSupplier.invoke(1, k(getMediaListResult)).a(bVar2).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "translateToolSupplier(TR\u2026)\n            .toString()");
            return jSONObject;
        }
        throw new IncompleteWorkException("please check the receiver of GetEditableTextResult");
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    @NotNull
    public com.tencent.mvi.base.route.k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, FeedEditorContentMsgIntent.MakeJsonForPost.f221794d)) {
            return o();
        }
        if (Intrinsics.areEqual(event, FeedEditorContentMsgIntent.MakeJsonForDraft.f221793d)) {
            return n();
        }
        if (Intrinsics.areEqual(event, FeedEditorContentMsgIntent.MakeJsonForSwitchToH5.f221795d)) {
            return p();
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.MakeJsonForPost");
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.MakeJsonForDraft");
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.MakeJsonForSwitchToH5");
        return hashSet;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    protected String getLogTag() {
        return this.logTag;
    }

    @NotNull
    public final Function2<Integer, i.b, tm1.a> m() {
        return this.translateToolSupplier;
    }

    public /* synthetic */ FeedEditorContentVMDelegate(Function3[] function3Arr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Function3[0] : function3Arr);
    }
}
