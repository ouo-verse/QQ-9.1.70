package com.tencent.mobileqq.troop.troopnotification.render;

import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopnotification.render.parser.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.notification.e;
import com.tencent.qqnt.report.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bK\u0010LJ:\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002JB\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\bJ$\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0010J,\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00122\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00122\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0010J0\u0010#\u001a\u0004\u0018\u00010\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0010J\u001e\u0010'\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u001fR!\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R'\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010/R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b2\u0010+R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010)\u001a\u0004\b5\u0010+R'\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b7\u0010/R!\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0004098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010)\u001a\u0004\b;\u0010+R!\u0010?\u001a\b\u0012\u0004\u0012\u00020=0\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010)\u001a\u0004\b>\u0010+R'\u0010B\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020=0\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010)\u001a\u0004\bA\u0010/R'\u0010C\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020=0\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010)\u001a\u0004\b:\u0010/R'\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020D0\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010)\u001a\u0004\bF\u0010/R!\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010)\u001a\u0004\bE\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/TroopNotificationRender;", "", "", "key", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "parser", "Lpt2/a;", "invoker", "Lcom/tencent/qqnt/notification/f;", "msg", "Lcom/tencent/qqnt/notification/e;", "notificationModel", "Lcom/tencent/qqnt/report/n;", "report", "", "r", "", "parserMap", "", "postponeParser", "t", "wildcardStr", "f", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "y", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", HippyTKDListViewAdapter.X, "data", "w", "richTextJson", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/f;", "u", "textData", "allData", "v", "Landroid/view/View;", "view", "text", ReportConstant.COSTREPORT_PREFIX, "b", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/List;", "listModelParsers", "c", "l", "()Ljava/util/Map;", "listModelParserMap", "d", DomainData.DOMAIN_NAME, "listModelPostponeParsers", "e", "i", "detailModelParsers", h.F, "detailModelParserMap", "", "g", "j", "detailModelPostponeParsers", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/a;", "p", "specialTextParser", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "specialTextParserMap", "clickableTextParser", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/f;", "k", "o", "preParser", "", "()Ljava/util/Set;", "ignoreKey", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationRender {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopNotificationRender f300720a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy listModelParsers;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy listModelParserMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy listModelPostponeParsers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy detailModelParsers;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy detailModelParserMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy detailModelPostponeParsers;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy specialTextParser;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy specialTextParserMap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy clickableTextParser;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy preParser;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy ignoreKey;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59311);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f300720a = new TroopNotificationRender();
        lazy = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$listModelParsers$2.INSTANCE);
        listModelParsers = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$listModelParserMap$2.INSTANCE);
        listModelParserMap = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$listModelPostponeParsers$2.INSTANCE);
        listModelPostponeParsers = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$detailModelParsers$2.INSTANCE);
        detailModelParsers = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$detailModelParserMap$2.INSTANCE);
        detailModelParserMap = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$detailModelPostponeParsers$2.INSTANCE);
        detailModelPostponeParsers = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$specialTextParser$2.INSTANCE);
        specialTextParser = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$specialTextParserMap$2.INSTANCE);
        specialTextParserMap = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$clickableTextParser$2.INSTANCE);
        clickableTextParser = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$preParser$2.INSTANCE);
        preParser = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(TroopNotificationRender$ignoreKey$2.INSTANCE);
        ignoreKey = lazy11;
    }

    TroopNotificationRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String f(String wildcardStr) {
        String substring = wildcardStr.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    private final Map<Integer, com.tencent.mobileqq.troop.troopnotification.render.richtext.a> g() {
        return (Map) clickableTextParser.getValue();
    }

    private final Map<String, com.tencent.mobileqq.troop.troopnotification.render.parser.a> h() {
        return (Map) detailModelParserMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.troop.troopnotification.render.parser.a> i() {
        return (List) detailModelParsers.getValue();
    }

    private final List<com.tencent.mobileqq.troop.troopnotification.render.parser.a> j() {
        return (List) detailModelPostponeParsers.getValue();
    }

    private final Set<String> k() {
        return (Set) ignoreKey.getValue();
    }

    private final Map<String, com.tencent.mobileqq.troop.troopnotification.render.parser.a> l() {
        return (Map) listModelParserMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.troop.troopnotification.render.parser.a> m() {
        return (List) listModelParsers.getValue();
    }

    private final List<com.tencent.mobileqq.troop.troopnotification.render.parser.a> n() {
        return (List) listModelPostponeParsers.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, f> o() {
        return (Map) preParser.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.troop.troopnotification.render.richtext.a> p() {
        return (List) specialTextParser.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Integer, com.tencent.mobileqq.troop.troopnotification.render.richtext.a> q() {
        return (Map) specialTextParserMap.getValue();
    }

    private final void r(String key, com.tencent.mobileqq.troop.troopnotification.render.parser.a parser, pt2.a invoker, com.tencent.qqnt.notification.f msg2, e notificationModel, n report) {
        String str;
        if (parser != null) {
            try {
                Object obj = notificationModel.b().get(key);
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                Object w3 = w(str, notificationModel.a());
                if (w3 != null) {
                    if (!invoker.a(msg2, w3, notificationModel.a(), parser)) {
                        invoker.b(parser);
                        return;
                    }
                    return;
                }
                invoker.b(parser);
                return;
            } catch (Exception e16) {
                QLog.e("TroopNotificationRender", 1, "parseModel " + invoker.getTag() + MsgSummary.STR_COLON, e16);
                report.e(e16);
                return;
            }
        }
        QLog.e("TroopNotificationRender", 1, "parseModel: not find parser, tag=" + invoker.getTag() + " key=" + key + ", msg.seq=" + msg2.j().seq);
    }

    private final void t(pt2.a invoker, com.tencent.qqnt.notification.f msg2, e notificationModel, Map<String, ? extends com.tencent.mobileqq.troop.troopnotification.render.parser.a> parserMap, List<? extends com.tencent.mobileqq.troop.troopnotification.render.parser.a> postponeParser) {
        n nVar = new n("TroopNotificationRender-" + invoker.getTag(), 0, 1, 1, 2, null);
        for (Map.Entry<String, f> entry : f300720a.o().entrySet()) {
            f300720a.r(entry.getKey(), entry.getValue(), invoker, msg2, notificationModel, nVar);
        }
        for (String str : notificationModel.b().keySet()) {
            TroopNotificationRender troopNotificationRender = f300720a;
            if (!troopNotificationRender.k().contains(str)) {
                troopNotificationRender.r(str, parserMap.get(str), invoker, msg2, notificationModel, nVar);
            }
        }
        for (com.tencent.mobileqq.troop.troopnotification.render.parser.a aVar : postponeParser) {
            if (!invoker.a(msg2, null, notificationModel.a(), aVar)) {
                invoker.b(aVar);
            }
        }
        nVar.b();
    }

    public final void s(@NotNull View view, @NotNull com.tencent.qqnt.notification.f msg2, @NotNull com.tencent.mobileqq.troop.troopnotification.render.richtext.f text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, msg2, text);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(text, "text");
        com.tencent.mobileqq.troop.troopnotification.render.richtext.a aVar = g().get(Integer.valueOf(text.c()));
        if (aVar != null) {
            aVar.b(view, msg2, text);
        }
    }

    @NotNull
    public final List<com.tencent.mobileqq.troop.troopnotification.render.richtext.f> u(@NotNull List<?> richTextJson, @NotNull Map<String, ? extends Object> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) richTextJson, (Object) data);
        }
        Intrinsics.checkNotNullParameter(richTextJson, "richTextJson");
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList arrayList = new ArrayList();
        for (Object obj : richTextJson) {
            if (!(obj instanceof String)) {
                QLog.e("TroopNotificationRender", 1, "parseRichText: wildcardStr must be string");
            } else {
                TroopNotificationRender troopNotificationRender = f300720a;
                String str = (String) obj;
                Object w3 = troopNotificationRender.w(str, data);
                if (w3 instanceof Map) {
                    Intrinsics.checkNotNull(w3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    com.tencent.mobileqq.troop.troopnotification.render.richtext.f v3 = troopNotificationRender.v((Map) w3, data);
                    if (v3 != null) {
                        arrayList.add(v3);
                    }
                } else if (w3 instanceof String) {
                    arrayList.add(new com.tencent.mobileqq.troop.troopnotification.render.richtext.f(str, 0, ""));
                } else {
                    QLog.e("TroopNotificationRender", 1, "parseRichText: no find wildcardValue, wildcardStr=" + obj + ", wildcardValue=" + w3 + ", data=" + data);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final com.tencent.mobileqq.troop.troopnotification.render.richtext.f v(@NotNull Map<String, ? extends Object> textData, @NotNull Map<String, ? extends Object> allData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.troopnotification.render.richtext.f) iPatchRedirector.redirect((short) 6, (Object) this, (Object) textData, (Object) allData);
        }
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(allData, "allData");
        Object obj = textData.get("type");
        com.tencent.mobileqq.troop.troopnotification.render.richtext.a aVar = q().get(obj);
        if (aVar != null) {
            return aVar.a(textData, allData);
        }
        QLog.e("TroopNotificationRender", 1, "parseSpecialText: no find parser, type=" + obj + ", textData=" + textData);
        return null;
    }

    @Nullable
    public final Object w(@NotNull String wildcardStr, @NotNull Map<String, ? extends Object> data) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) wildcardStr, (Object) data);
        }
        Intrinsics.checkNotNullParameter(wildcardStr, "wildcardStr");
        Intrinsics.checkNotNullParameter(data, "data");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(wildcardStr, "$", false, 2, null);
        if (startsWith$default) {
            return data.get(f(wildcardStr));
        }
        return wildcardStr;
    }

    public final void x(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder, @NotNull com.tencent.qqnt.notification.f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        t(viewHolder, msg2, msg2.d(), h(), j());
    }

    public final void y(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder, @NotNull com.tencent.qqnt.notification.f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewHolder, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        t(viewHolder, msg2, msg2.i(), l(), n());
    }
}
