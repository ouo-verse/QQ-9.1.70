package com.tencent.robot.slash.businessapi;

import a74.CustomTitleInfo;
import b64.SlashRecentFunctionTitleData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import e74.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J,\u0010\u0019\u001a\u00020\u00182\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0015j\b\u0012\u0004\u0012\u00020\u0002`\u0016J,\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0015j\b\u0012\u0004\u0012\u00020\u0007`\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J,\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0015j\b\u0012\u0004\u0012\u00020\u0007`\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\n\u0010\u001f\u001a\u00020\u0004*\u00020\u001eJ,\u0010#\u001a\u00020\u00182\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0015j\b\u0012\u0004\u0012\u00020\u0007`\u0016J\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J+\u0010&\u001a\u0004\u0018\u00010\u0011*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000\u00a2\u0006\u0004\b&\u0010'\u00a8\u0006*"}, d2 = {"Lcom/tencent/robot/slash/businessapi/ConvertSearchTools;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatures;", "robotFeatures", "", "keyword", "", "Lb74/a;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", h.F, "c", "", QQBrowserActivityConstants.KEY_TITLE_STYLE, "La74/a;", "customTitleInfo", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$RefreshTitle;", "k", "j", "robotIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "robotFeaturesList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "g", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "i", "Lm64/a;", "recentFunctionList", "itemDataList", "a", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "b", DomainData.DOMAIN_NAME, "(Lb74/a;ILa74/a;)Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$RefreshTitle;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ConvertSearchTools {

    /* renamed from: a */
    @NotNull
    public static final ConvertSearchTools f368422a = new ConvertSearchTools();

    ConvertSearchTools() {
    }

    private final List<b74.a> c(CommonBotFeatures robotFeatures, String keyword) {
        List<b74.a> d16 = d(robotFeatures, keyword);
        if (!d16.isEmpty()) {
            CommonBotInfo commonBotInfo = robotFeatures.botInfo;
            Intrinsics.checkNotNullExpressionValue(commonBotInfo, "robotFeatures.botInfo");
            d16.add(0, new e64.b(commonBotInfo));
        }
        return d16;
    }

    private final List<b74.a> e(CommonBotFeatures robotFeatures, String keyword) {
        List<b74.a> d16 = d(robotFeatures, keyword);
        CommonBotInfo commonBotInfo = robotFeatures.botInfo;
        Intrinsics.checkNotNullExpressionValue(commonBotInfo, "robotFeatures.botInfo");
        if (h34.a.e(commonBotInfo)) {
            ConvertSearchTools convertSearchTools = f368422a;
            CommonBotInfo commonBotInfo2 = robotFeatures.botInfo;
            Intrinsics.checkNotNullExpressionValue(commonBotInfo2, "robotFeatures.botInfo");
            d16.add(0, convertSearchTools.h(commonBotInfo2));
        }
        if (!d16.isEmpty()) {
            CommonBotInfo commonBotInfo3 = robotFeatures.botInfo;
            Intrinsics.checkNotNullExpressionValue(commonBotInfo3, "robotFeatures.botInfo");
            d16.add(0, new e64.b(commonBotInfo3));
        }
        return d16;
    }

    private final b74.a h(CommonBotInfo commonBotInfo) {
        return new x54.b(commonBotInfo, new CommonBotFeatureInfo(1, "/\u641c\u7d22", "\u8f93\u5165\u5173\u952e\u8bcd\u53ef\u641c\u7d22\u76f8\u5173\u5185\u5bb9", 0, "", 0, "", commonBotInfo.mark, "", ""));
    }

    private final SlashTitleMsgIntent.RefreshTitle j(CommonBotInfo robotInfo, int r112, CustomTitleInfo customTitleInfo) {
        String str = robotInfo.name;
        Intrinsics.checkNotNullExpressionValue(str, "robotInfo.name");
        return new SlashTitleMsgIntent.RefreshTitle(str, robotInfo.uin, robotInfo.tinyid, r112, customTitleInfo);
    }

    private final SlashTitleMsgIntent.RefreshTitle k(int r102, CustomTitleInfo customTitleInfo) {
        return new SlashTitleMsgIntent.RefreshTitle("", 0L, 0L, r102, customTitleInfo);
    }

    static /* synthetic */ SlashTitleMsgIntent.RefreshTitle l(ConvertSearchTools convertSearchTools, int i3, CustomTitleInfo customTitleInfo, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            customTitleInfo = null;
        }
        return convertSearchTools.k(i3, customTitleInfo);
    }

    public static /* synthetic */ SlashTitleMsgIntent.RefreshTitle o(ConvertSearchTools convertSearchTools, b74.a aVar, int i3, CustomTitleInfo customTitleInfo, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        if ((i16 & 2) != 0) {
            customTitleInfo = null;
        }
        return convertSearchTools.n(aVar, i3, customTitleInfo);
    }

    public final void a(@NotNull List<m64.a> recentFunctionList, @NotNull ArrayList<b74.a> itemDataList) {
        List<m64.a> reversed;
        Intrinsics.checkNotNullParameter(recentFunctionList, "recentFunctionList");
        Intrinsics.checkNotNullParameter(itemDataList, "itemDataList");
        if (recentFunctionList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        reversed = CollectionsKt___CollectionsKt.reversed(recentFunctionList);
        boolean z16 = false;
        for (m64.a aVar : reversed) {
            for (b74.a aVar2 : itemDataList) {
                if (aVar2 instanceof x54.b) {
                    x54.b bVar = (x54.b) aVar2;
                    if (Intrinsics.areEqual(aVar.d(), String.valueOf(bVar.getRobotInfo().uin)) && Intrinsics.areEqual(aVar.b(), bVar.getCommandInfo().name) && aVar.c() == 1) {
                        arrayList.add(new z54.b(bVar.getRobotInfo(), bVar.getCommandInfo()));
                        z16 = true;
                        break;
                    }
                }
                if (aVar2 instanceof d64.b) {
                    d64.b bVar2 = (d64.b) aVar2;
                    if (Intrinsics.areEqual(aVar.d(), String.valueOf(bVar2.getRobotInfo().uin)) && Intrinsics.areEqual(aVar.b(), bVar2.getServiceInfo().name) && aVar.c() == 2) {
                        arrayList.add(new a64.b(bVar2.getRobotInfo(), bVar2.getServiceInfo()));
                        z16 = true;
                        break;
                        break;
                    }
                }
            }
        }
        if (z16) {
            arrayList.add(0, new SlashRecentFunctionTitleData(""));
        }
        itemDataList.addAll(0, arrayList);
    }

    @NotNull
    public final List<b.UIModelData> b(@NotNull List<? extends b74.a> itemDataList) {
        Sequence asSequence;
        Sequence filter;
        Sequence map;
        List<b.UIModelData> list;
        Intrinsics.checkNotNullParameter(itemDataList, "itemDataList");
        asSequence = CollectionsKt___CollectionsKt.asSequence(itemDataList);
        filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<b74.a, Boolean>() { // from class: com.tencent.robot.slash.businessapi.ConvertSearchTools$buildAvatarBarUIDataList$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull b74.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((it instanceof e64.b) || (it instanceof SlashRecentFunctionTitleData));
            }
        });
        map = SequencesKt___SequencesKt.map(filter, new Function1<b74.a, b.UIModelData>() { // from class: com.tencent.robot.slash.businessapi.ConvertSearchTools$buildAvatarBarUIDataList$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final b.UIModelData invoke(@NotNull b74.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof e64.b) {
                    e64.b bVar = (e64.b) it;
                    return new b.UIModelData(String.valueOf(bVar.getRobotInfo().uin), bVar.getRobotInfo().name, false);
                }
                return new b.UIModelData(null, null, true);
            }
        });
        list = SequencesKt___SequencesKt.toList(map);
        return list;
    }

    @NotNull
    public final List<b74.a> d(@NotNull CommonBotFeatures robotFeatures, @NotNull String keyword) {
        boolean z16;
        Intrinsics.checkNotNullParameter(robotFeatures, "robotFeatures");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        LinkedList linkedList = new LinkedList();
        ArrayList<CommonBotFeatureInfo> arrayList = robotFeatures.commandInfo;
        Intrinsics.checkNotNullExpressionValue(arrayList, "robotFeatures.commandInfo");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            CommonBotFeatureInfo commandInfo = (CommonBotFeatureInfo) it.next();
            if (keyword.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                ConvertSearchTools convertSearchTools = f368422a;
                Intrinsics.checkNotNullExpressionValue(commandInfo, "commandInfo");
                if (n64.c.d(keyword, convertSearchTools.i(commandInfo))) {
                }
            }
            CommonBotInfo commonBotInfo = robotFeatures.botInfo;
            Intrinsics.checkNotNullExpressionValue(commonBotInfo, "robotFeatures.botInfo");
            Intrinsics.checkNotNullExpressionValue(commandInfo, "commandInfo");
            linkedList.add(new x54.b(commonBotInfo, commandInfo));
        }
        ArrayList<CommonBotFeatureInfo> arrayList2 = robotFeatures.serviceInfo;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "robotFeatures.serviceInfo");
        for (CommonBotFeatureInfo serviceInfo : arrayList2) {
            if (keyword.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || n64.c.d(keyword, serviceInfo.name)) {
                CommonBotInfo commonBotInfo2 = robotFeatures.botInfo;
                Intrinsics.checkNotNullExpressionValue(commonBotInfo2, "robotFeatures.botInfo");
                Intrinsics.checkNotNullExpressionValue(serviceInfo, "serviceInfo");
                linkedList.add(new d64.b(commonBotInfo2, serviceInfo));
            }
        }
        return linkedList;
    }

    @NotNull
    public final ArrayList<b74.a> f(@NotNull List<CommonBotFeatures> robotFeaturesList, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(robotFeaturesList, "robotFeaturesList");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        ArrayList<b74.a> arrayList = new ArrayList<>();
        Iterator<T> it = robotFeaturesList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(f368422a.c((CommonBotFeatures) it.next(), keyword));
        }
        return arrayList;
    }

    @NotNull
    public final ArrayList<b74.a> g(@NotNull List<CommonBotFeatures> robotFeaturesList, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(robotFeaturesList, "robotFeaturesList");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        ArrayList<b74.a> arrayList = new ArrayList<>();
        Iterator<T> it = robotFeaturesList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(f368422a.e((CommonBotFeatures) it.next(), keyword));
        }
        return arrayList;
    }

    @NotNull
    public final String i(@NotNull CommonBotFeatureInfo commonBotFeatureInfo) {
        String replaceFirst$default;
        Intrinsics.checkNotNullParameter(commonBotFeatureInfo, "<this>");
        String name = commonBotFeatureInfo.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(name, "/", "", false, 4, (Object) null);
        return replaceFirst$default;
    }

    public final void m(@NotNull List<String> robotIdList, @NotNull ArrayList<CommonBotFeatures> robotFeaturesList) {
        List<String> reversed;
        Intrinsics.checkNotNullParameter(robotIdList, "robotIdList");
        Intrinsics.checkNotNullParameter(robotFeaturesList, "robotFeaturesList");
        if (robotFeaturesList.isEmpty() || robotIdList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        reversed = CollectionsKt___CollectionsKt.reversed(robotIdList);
        for (String str : reversed) {
            Iterator<CommonBotFeatures> it = robotFeaturesList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "robotFeaturesList.iterator()");
            while (it.hasNext()) {
                CommonBotFeatures next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                CommonBotFeatures commonBotFeatures = next;
                if (Intrinsics.areEqual(String.valueOf(commonBotFeatures.botInfo.uin), str)) {
                    arrayList.add(commonBotFeatures);
                    it.remove();
                }
            }
        }
        robotFeaturesList.addAll(0, arrayList);
    }

    @Nullable
    public final SlashTitleMsgIntent.RefreshTitle n(@NotNull b74.a aVar, int i3, @Nullable CustomTitleInfo customTitleInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar instanceof e64.b) {
            return j(((e64.b) aVar).getRobotInfo(), i3, customTitleInfo);
        }
        if (aVar instanceof x54.b) {
            return j(((x54.b) aVar).getRobotInfo(), i3, customTitleInfo);
        }
        if (aVar instanceof d64.b) {
            return j(((d64.b) aVar).getRobotInfo(), i3, customTitleInfo);
        }
        if (aVar instanceof z54.b) {
            z16 = true;
        } else {
            z16 = aVar instanceof a64.b;
        }
        if (z16) {
            return l(this, 1, null, 2, null);
        }
        if (aVar instanceof c64.b) {
            return l(this, 4, null, 2, null);
        }
        if (aVar instanceof f) {
            return l(this, 5, null, 2, null);
        }
        if (!(aVar instanceof com.tencent.robot.aio.bottombar.promptfunction.a)) {
            return null;
        }
        return k(6, customTitleInfo);
    }
}
