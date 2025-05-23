package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.d;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.UrlTextProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import om1.RestoreInfo;
import om1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u0013\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R]\u0010\u0012\u001aK\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\fj\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R]\u0010\u001b\u001aK\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\fj\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011R]\u0010\u001d\u001aK\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\fj\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 Rc\u0010'\u001aQ\u0012M\u0012K\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\fj\u0002`\u00100$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/v2/TextContentRestorer2;", "Lpm1/b;", "Lom1/a;", "restoreInfo", "Landroid/widget/EditText;", "c", "Lorg/json/JSONObject;", "jsonObject", "Lom1/b;", "restoreResult", "", "a", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "content", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/RestorerEmployee;", "Lkotlin/jvm/functions/Function3;", "employeeForText", "com/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/v2/TextContentRestorer2$a", "b", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/v2/TextContentRestorer2$a;", "employeeForAt", "com/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/v2/TextContentRestorer2$b", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/v2/TextContentRestorer2$b;", "employeeForQuoteChannel", "d", "employeeForEmoji", "e", "employeeForTopic", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/d$a;", "f", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/d$a;", "employeeForGroupTag", "g", "employeeForUrl", "Landroid/util/SparseArray;", h.F, "Landroid/util/SparseArray;", "employees", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TextContentRestorer2 implements pm1.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<JSONObject, om1.b, RestoreInfo, Unit> employeeForText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a employeeForAt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b employeeForQuoteChannel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<JSONObject, om1.b, RestoreInfo, Unit> employeeForEmoji;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<JSONObject, om1.b, RestoreInfo, Unit> employeeForTopic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d.a employeeForGroupTag;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d.a employeeForUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<Function3<JSONObject, om1.b, RestoreInfo, Unit>> employees;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002K\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ!\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/v2/TextContentRestorer2$a", "Lkotlin/Function3;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "content", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/RestorerEmployee;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements Function3<JSONObject, om1.b, RestoreInfo, Unit> {
        a() {
        }

        public void a(@NotNull JSONObject content, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
            EditText c16;
            SpannableString q16;
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
            Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
            if (restoreInfo.getIsFilterGuildRelativeSpan() || (c16 = TextContentRestorer2.this.c(restoreInfo)) == null) {
                return;
            }
            JSONObject jSONObject = content.getJSONObject("at_content");
            int i3 = jSONObject.getInt("type");
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            QLog.w("FeedEditor.RestoreTool", 1, "restore at content with unknown type: " + i3);
                            q16 = null;
                        } else {
                            String string = jSONObject.getJSONObject(QCircleAlphaUserReporter.KEY_USER).getString("nick");
                            q16 = com.tencent.guild.aio.input.at.utils.b.q(restoreInfo.a().c().requireContext(), "0", string, string, c16, 0, false, false, 64, null);
                        }
                    } else {
                        String string2 = jSONObject.getJSONObject(QCircleAlphaUserReporter.KEY_USER).getString("nick");
                        q16 = com.tencent.guild.aio.input.at.utils.b.q(restoreInfo.a().c().requireContext(), "0", string2, string2, c16, 0, false, false, 1, null);
                    }
                } else {
                    String string3 = jSONObject.getJSONObject("role_group_id").getString("name");
                    q16 = com.tencent.guild.aio.input.at.utils.b.q(restoreInfo.a().c().requireContext(), "0", string3, string3, c16, 0, false, false, 8, null);
                }
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject(QCircleAlphaUserReporter.KEY_USER);
                String string4 = jSONObject2.getString("nick");
                q16 = com.tencent.guild.aio.input.at.utils.b.q(restoreInfo.a().c().requireContext(), jSONObject2.getString("id"), string4, string4, c16, 0, false, false, 2, null);
            }
            if (q16 != null) {
                restoreResult.getMEditable().append((CharSequence) q16);
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, om1.b bVar, RestoreInfo restoreInfo) {
            a(jSONObject, bVar, restoreInfo);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002K\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\fH\u0002J!\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/v2/TextContentRestorer2$b", "Lkotlin/Function3;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "content", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/RestorerEmployee;", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Function3<JSONObject, om1.b, RestoreInfo, Unit> {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
        
            if (r0 == false) goto L6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String a(String name) {
            boolean startsWith$default;
            boolean startsWith$default2;
            if (name.length() > 1) {
                startsWith$default2 = StringsKt__StringsKt.startsWith$default((CharSequence) name, '#', false, 2, (Object) null);
            }
            startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) name, '*', false, 2, (Object) null);
            if (!startsWith$default) {
                return name;
            }
            String substring = name.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }

        public void b(@NotNull JSONObject content, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
            EditText c16;
            int i3;
            boolean z16;
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
            Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
            if (restoreInfo.getIsFilterGuildRelativeSpan() || (c16 = TextContentRestorer2.this.c(restoreInfo)) == null) {
                return;
            }
            boolean z17 = false;
            c16.measure(View.MeasureSpec.makeMeasureSpec(ScreenUtil.SCREEN_WIDTH, 1073741824), 0);
            JSONObject jSONObject = content.getJSONObject("channel_content").getJSONObject("channelInfo");
            String channelName = jSONObject.getString("name");
            if (jSONObject.getBoolean("is_square")) {
                i3 = 512;
            } else {
                i3 = 16;
            }
            int i16 = i3;
            JSONObject jSONObject2 = jSONObject.getJSONObject("sign");
            int i17 = jSONObject2.getInt("channel_type");
            String valueOf = String.valueOf(jSONObject2.getLong("channel_id"));
            if (valueOf.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
                if (channelName.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    restoreResult.getMEditable().append((CharSequence) com.tencent.guild.aio.input.at.utils.d.w(restoreInfo.a().c().requireContext(), valueOf, a(channelName), i17, c16, 0, false, false, i16, null));
                    return;
                }
            }
            QLog.e("FeedEditor.RestoreTool", 1, "restore channelInfo failed, mainTaskId=" + restoreInfo.a().h().m());
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, om1.b bVar, RestoreInfo restoreInfo) {
            b(jSONObject, bVar, restoreInfo);
            return Unit.INSTANCE;
        }
    }

    public TextContentRestorer2() {
        TextContentRestorer2$employeeForText$1 textContentRestorer2$employeeForText$1 = new Function3<JSONObject, om1.b, RestoreInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2.TextContentRestorer2$employeeForText$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, b bVar, RestoreInfo restoreInfo) {
                invoke2(jSONObject, bVar, restoreInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull JSONObject content, @NotNull b restoreResult, @NotNull RestoreInfo restoreInfo) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
                Intrinsics.checkNotNullParameter(restoreInfo, "<anonymous parameter 2>");
                restoreResult.getMEditable().append((CharSequence) content.getJSONObject("text_content").getString("text"));
            }
        };
        this.employeeForText = textContentRestorer2$employeeForText$1;
        a aVar = new a();
        this.employeeForAt = aVar;
        b bVar = new b();
        this.employeeForQuoteChannel = bVar;
        TextContentRestorer2$employeeForEmoji$1 textContentRestorer2$employeeForEmoji$1 = new Function3<JSONObject, om1.b, RestoreInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2.TextContentRestorer2$employeeForEmoji$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, b bVar2, RestoreInfo restoreInfo) {
                invoke2(jSONObject, bVar2, restoreInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull JSONObject content, @NotNull b restoreResult, @NotNull RestoreInfo restoreInfo) {
                Integer intOrNull;
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
                Intrinsics.checkNotNullParameter(restoreInfo, "<anonymous parameter 2>");
                JSONObject jSONObject = content.getJSONObject("emoji_content");
                c.e eVar = c.e.f220909a;
                String string = jSONObject.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "emojiContent.getString(TYPE)");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(string);
                if (intOrNull != null && intOrNull.intValue() == 1) {
                    restoreResult.getMEditable().append((CharSequence) com.tencent.qqnt.emotion.text.c.c(((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(jSONObject.getString("id"), intOrNull.intValue())));
                } else {
                    if (intOrNull != null && intOrNull.intValue() == 2) {
                        return;
                    }
                    QLog.w("FeedEditor.RestoreTool", 1, "employeeForEmoji|handling unknown emojiType=" + intOrNull);
                }
            }
        };
        this.employeeForEmoji = textContentRestorer2$employeeForEmoji$1;
        TextContentRestorer2$employeeForTopic$1 textContentRestorer2$employeeForTopic$1 = new Function3<JSONObject, om1.b, RestoreInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2.TextContentRestorer2$employeeForTopic$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, b bVar2, RestoreInfo restoreInfo) {
                invoke2(jSONObject, bVar2, restoreInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull JSONObject content, @NotNull b restoreResult, @NotNull RestoreInfo restoreInfo) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
                Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
                JSONObject jSONObject = content.getJSONObject("topic_content");
                c.f fVar = c.f.f220910a;
                long j3 = jSONObject.getLong("topic_id");
                String topicName = jSONObject.getString("topic_name");
                int optInt = jSONObject.optInt("show_status", 0);
                Intrinsics.checkNotNullExpressionValue(topicName, "topicName");
                if (topicName.length() > 0) {
                    if (restoreInfo.getIsFilterIllegalStateTopic() && optInt != 1 && optInt != 0) {
                        if (restoreInfo.getIsFilterIllegalStateTopic() && optInt == 2) {
                            restoreResult.getMEditable().append((CharSequence) topicName);
                            return;
                        }
                        QLog.i("FeedEditor.RestoreTool", 1, "topicId=" + j3 + ", showStatus=" + optInt + " is filtered");
                        return;
                    }
                    Editable mEditable = restoreResult.getMEditable();
                    SpannableString spannableString = new SpannableString(topicName);
                    spannableString.setSpan(new yn1.b(j3, 0, 2, null), 0, spannableString.length(), 33);
                    mEditable.append((CharSequence) spannableString);
                    return;
                }
                QLog.i("FeedEditor.RestoreTool", 1, "process|topicName is empty!");
            }
        };
        this.employeeForTopic = textContentRestorer2$employeeForTopic$1;
        d.a aVar2 = new d.a(new com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.c());
        this.employeeForGroupTag = aVar2;
        UrlTextProcessor urlTextProcessor = new UrlTextProcessor();
        urlTextProcessor.b(new TextContentRestorer2$employeeForUrl$1$1(this));
        d.a aVar3 = new d.a(urlTextProcessor);
        this.employeeForUrl = aVar3;
        SparseArray<Function3<JSONObject, om1.b, RestoreInfo, Unit>> sparseArray = new SparseArray<>(9);
        sparseArray.append(1, textContentRestorer2$employeeForText$1);
        sparseArray.append(2, aVar);
        sparseArray.append(5, bVar);
        sparseArray.append(4, textContentRestorer2$employeeForEmoji$1);
        sparseArray.append(8, textContentRestorer2$employeeForTopic$1);
        sparseArray.append(9, aVar2);
        sparseArray.append(3, aVar3);
        sparseArray.append(0, new Function3<JSONObject, om1.b, RestoreInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2.TextContentRestorer2$employees$1$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, b bVar2, RestoreInfo restoreInfo) {
                invoke2(jSONObject, bVar2, restoreInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull JSONObject jSONObject, @NotNull b bVar2, @NotNull RestoreInfo restoreInfo) {
                Intrinsics.checkNotNullParameter(jSONObject, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(bVar2, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(restoreInfo, "<anonymous parameter 2>");
                QLog.e("FeedEditor.RestoreTool", 1, "restore unknown content type");
            }
        });
        this.employees = sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText c(RestoreInfo restoreInfo) {
        Activity f16 = restoreInfo.a().f();
        if (f16 != null) {
            return (EditText) f16.findViewById(R.id.wcw);
        }
        return null;
    }

    @Override // pm1.b
    public void a(@NotNull JSONObject jsonObject, @NotNull om1.b restoreResult, @Nullable RestoreInfo restoreInfo) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        if (restoreInfo == null) {
            return;
        }
        JSONObject optJSONObject = jsonObject.optJSONObject("contents");
        if (optJSONObject != null) {
            jSONArray = optJSONObject.optJSONArray("contents");
        } else {
            jSONArray = null;
        }
        if (jSONArray == null) {
            QLog.w("FeedEditor.RestoreTool", 1, "[restoreTextContent]: content is empty, taskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(restoreInfo.a()));
            return;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject richTextContent = jSONArray.getJSONObject(i3);
            int i16 = richTextContent.getInt("type");
            Function3<JSONObject, om1.b, RestoreInfo, Unit> function3 = this.employees.get(i16);
            if (function3 != null) {
                Intrinsics.checkNotNullExpressionValue(richTextContent, "richTextContent");
                function3.invoke(richTextContent, restoreResult, restoreInfo);
            } else {
                QLog.e("FeedEditor.RestoreTool", 1, "restore unknown content type: " + i16);
            }
        }
    }
}
