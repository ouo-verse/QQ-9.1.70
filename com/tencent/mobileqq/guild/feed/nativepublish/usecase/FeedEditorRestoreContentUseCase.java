package com.tencent.mobileqq.guild.feed.nativepublish.usecase;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.e;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import fm1.i;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import om1.RestoreInfo;
import om1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u0001-B\u008f\u0001\u0012]\b\u0002\u0010/\u001aW\u0012Q\u0012O\u0012,\u0012*\u0012\u0004\u0012\u00020\u00050\u0004j\u0011`\u0006\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0007\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000b0(j\u0002`,\u0018\u00010'\u0012'\b\u0002\u00105\u001a!\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002010\"j\u0002`2\u00a2\u0006\u0004\b6\u00107J$\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0002J$\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0002J\"\u0010\u000f\u001a\u00020\u000b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u0010\u001a\u00020\u000b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0011\u001a\u00020\u000b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\u000b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006J$\u0010\u0016\u001a\u00020\u000b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014J4\u0010\u001b\u001a\u00020\u000b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017J[\u0010&\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u001b\b\u0002\u0010%\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b\u0018\u00010\"\u00a2\u0006\u0002\b$Ri\u0010/\u001aW\u0012Q\u0012O\u0012,\u0012*\u0012\u0004\u0012\u00020\u00050\u0004j\u0011`\u0006\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0007\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000b0(j\u0002`,\u0018\u00010'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R3\u00105\u001a!\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002010\"j\u0002`28\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/FeedEditorRestoreContentUseCase;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "k", "j", "contentJson", "", h.F, "Lom1/b;", "box", "e", "f", "l", "i", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorDraftModel;", "draft", "g", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "scopeProvider", "onRestoreContent", "o", "", "restoreToolType", "", "feedJson", "", "shouldFilterIllegalStateTopic", "Lkotlin/Function1;", "Lcom/tencent/mvi/base/route/j;", "Lkotlin/ExtensionFunctionType;", "howToShowKeyboard", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "restoreResult", "Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/RestoreExtensionFun;", "a", "[Lkotlin/jvm/functions/Function2;", "restoreExtensions", "toolType", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/RestoreToolSupplier;", "b", "Lkotlin/jvm/functions/Function1;", "restoreToolSupplier", "<init>", "([Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorRestoreContentUseCase {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f222305c = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function2<com.tencent.base.api.runtime.a<zl1.a>, b, Unit>[] restoreExtensions;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a> restoreToolSupplier;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.usecase.FeedEditorRestoreContentUseCase$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a> {
        AnonymousClass1(Object obj) {
            super(1, obj, e.class, "getRestoreTool", "getRestoreTool(I)Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/IRestoreTool;", 0);
        }

        @NotNull
        public final com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a invoke(int i3) {
            return ((e) this.receiver).a(i3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/FeedEditorRestoreContentUseCase$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public FeedEditorRestoreContentUseCase() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(com.tencent.base.api.runtime.a<zl1.a> context, b box) {
        Function2<com.tencent.base.api.runtime.a<zl1.a>, b, Unit>[] function2Arr = this.restoreExtensions;
        if (function2Arr != null) {
            for (Function2<com.tencent.base.api.runtime.a<zl1.a>, b, Unit> function2 : function2Arr) {
                function2.invoke(context, box);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(com.tencent.base.api.runtime.a<zl1.a> context, b box) {
        int coerceAtMost;
        j e16 = context.e();
        e16.h(new GuildFeedEditTextMsgIntent.SetEditText(box.getMEditable()));
        i(context);
        zl1.a h16 = context.h();
        List<i> b16 = box.b();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(h16.getMediaLockSize(), b16.size());
        h16.J(coerceAtMost);
        if (!b16.isEmpty()) {
            e16.h(new FeedEditorMediaMsgIntent.InitMediaList(b16, h16.getMediaLockSize()));
        }
        e(context, box);
    }

    private final void h(JSONObject contentJson, com.tencent.base.api.runtime.a<zl1.a> context) {
        context.h().z(true);
        com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a a16 = e.f222261a.a(2);
        RestoreInfo restoreInfo = new RestoreInfo(context);
        zl1.a h16 = context.h();
        Intrinsics.checkNotNullExpressionValue(h16, "context.baseParam");
        restoreInfo.d(zl1.b.j(h16));
        Unit unit = Unit.INSTANCE;
        b a17 = a16.a(contentJson, restoreInfo);
        context.e().h(new GuildFeedEditTextMsgIntent.SetEditText(a17.getMEditable()));
        context.e().h(new FeedEditorMediaMsgIntent.InitMediaList(a17.b(), context.h().getMediaLockSize()));
        e(context, a17);
        context.e().h(GuildFeedEditTextMsgIntent.ShowKeyboard.f221846d);
        zl1.a h17 = context.h();
        Intrinsics.checkNotNullExpressionValue(h17, "context.baseParam");
        zl1.a h18 = context.h();
        Intrinsics.checkNotNullExpressionValue(h18, "context.baseParam");
        zl1.b.q(h17, zl1.b.c(h18));
        context.e().h(PublishFeedMsgIntent.RebindMainTaskToCurrentGuildInfo.f222234d);
    }

    private final JSONObject j(JSONObject jsonObject, com.tencent.base.api.runtime.a<zl1.a> context) {
        return null;
    }

    private final JSONObject k(JSONObject jsonObject, com.tencent.base.api.runtime.a<zl1.a> context) {
        boolean z16;
        JSONObject jSONObject;
        try {
            String originJsonFeed = jsonObject.optString("originJsonFeed");
            String optString = jsonObject.optString("contentJsonFeed");
            zl1.a h16 = context.h();
            Intrinsics.checkNotNullExpressionValue(originJsonFeed, "originJsonFeed");
            if (originJsonFeed.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(originJsonFeed);
            }
            h16.D(jSONObject);
            return new JSONObject(optString);
        } catch (JSONException e16) {
            QLog.e("FeedEditor.RestoreUseCase", 1, "[parseInOldFormat]: exception: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(com.tencent.base.api.runtime.a<zl1.a> context) {
        zl1.a h16 = context.h();
        h16.J(0);
        h16.D(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 scopeProvider, int i3, String feedJson, com.tencent.base.api.runtime.a context, boolean z16, FeedEditorRestoreContentUseCase this$0, Function1 function1) {
        Intrinsics.checkNotNullParameter(scopeProvider, "$scopeProvider");
        Intrinsics.checkNotNullParameter(feedJson, "$feedJson");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default((CoroutineScope) scopeProvider.invoke(), GuildAIODispatchers.f112358a.c(), null, new FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1(i3, feedJson, context, z16, this$0, function1, null), 2, null);
    }

    public final void g(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, @NotNull GProGuildFeedDraft draft) {
        boolean z16;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(draft, "draft");
        String str = draft.expandJsonStr;
        Intrinsics.checkNotNullExpressionValue(str, "draft.expandJsonStr");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("FeedEditor.RestoreUseCase", 1, "[handleRestoreDraft]: " + context.h().m() + ", draft json is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(draft.expandJsonStr);
            JSONObject k3 = k(jSONObject, context);
            if (k3 == null) {
                k3 = j(jSONObject, context);
            }
            if (k3 == null) {
                QLog.e("FeedEditor.RestoreUseCase", 1, "[handleRestoreDraft]: " + context.h().m() + ", stFeedJsonObject is empty");
                return;
            }
            h(k3, context);
        } catch (Exception e16) {
            String m3 = context.h().m();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.RestoreUseCase", 1, "[handleRestoreDraft]: " + m3 + ", error happens: " + stackTraceToString);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.trimStart(r1, '\uff03', '#');
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
        String trimStart;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = context.h().getExtra().getBundle("topic_element_append");
        if (bundle != null && !bundle.isEmpty() && (r1 = bundle.getString("topic_name")) != null && trimStart != null) {
            if (trimStart.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                trimStart = null;
            }
            if (trimStart == null || !bundle.getBoolean("topic_auto_insert", true)) {
                return;
            }
            j e16 = context.e();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder('#' + trimStart);
            spannableStringBuilder.setSpan(new yn1.b(bundle.getLong("topic_id", 0L), 0, 2, null), 0, spannableStringBuilder.length(), 33);
            SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) " ");
            Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder(\n\u2026            }.append(\" \")");
            e16.h(new GuildFeedEditTextMsgIntent.InsertTextAtSelection(append, null, true, 2, null));
        }
    }

    public final void m(@NotNull final Function0<? extends CoroutineScope> scopeProvider, @NotNull final com.tencent.base.api.runtime.a<zl1.a> context, final int restoreToolType, @NotNull final String feedJson, final boolean shouldFilterIllegalStateTopic, @Nullable final Function1<? super j, Unit> howToShowKeyboard) {
        Intrinsics.checkNotNullParameter(scopeProvider, "scopeProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedJson, "feedJson");
        BuildersKt__Builders_commonKt.launch$default(scopeProvider.invoke(), ae.a().e(), null, new FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$1(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.usecase.a
            @Override // java.lang.Runnable
            public final void run() {
                FeedEditorRestoreContentUseCase.n(Function0.this, restoreToolType, feedJson, context, shouldFilterIllegalStateTopic, this, howToShowKeyboard);
            }
        }, null), 2, null);
    }

    public final void o(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, @NotNull Function0<? extends CoroutineScope> scopeProvider, @NotNull Function0<Unit> onRestoreContent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scopeProvider, "scopeProvider");
        Intrinsics.checkNotNullParameter(onRestoreContent, "onRestoreContent");
        String jsonFeed = context.h().getJsonFeed();
        if (jsonFeed.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            BuildersKt__Builders_commonKt.launch$default(scopeProvider.invoke(), ae.a().c(), null, new FeedEditorRestoreContentUseCase$restorePresetContent$1(jsonFeed, context, this, onRestoreContent, null), 2, null);
        } else {
            QLog.w("FeedEditor.RestoreUseCase", 1, "[restorePresetContent]: presetFeedJson is empty");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedEditorRestoreContentUseCase(@Nullable Function2<com.tencent.base.api.runtime.a<zl1.a>, b, Unit>[] function2Arr, @NotNull Function1<? super Integer, ? extends com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a> restoreToolSupplier) {
        Intrinsics.checkNotNullParameter(restoreToolSupplier, "restoreToolSupplier");
        this.restoreExtensions = function2Arr;
        this.restoreToolSupplier = restoreToolSupplier;
    }

    public /* synthetic */ FeedEditorRestoreContentUseCase(Function2[] function2Arr, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function2Arr, (i3 & 2) != 0 ? new AnonymousClass1(e.f222261a) : function1);
    }
}
