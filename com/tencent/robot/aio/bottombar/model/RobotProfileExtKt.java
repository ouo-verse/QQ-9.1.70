package com.tencent.robot.aio.bottombar.model;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.InputBox;
import com.tencent.qqnt.kernel.nativeinterface.ModelConfig;
import com.tencent.qqnt.kernel.nativeinterface.OptButton;
import com.tencent.qqnt.kernel.nativeinterface.OptID;
import com.tencent.qqnt.kernel.nativeinterface.OptType;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.aio.bottombar.model.OptionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k81.RobotModelProfileInfo;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0006\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\b*\u00020\u0006\u001a\f\u0010\u000b\u001a\u00020\b*\u00020\u0006H\u0002\u001a\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006\u001a\n\u0010\u0011\u001a\u00020\u0010*\u00020\u000f\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0012\u001a\n\u0010\u0014\u001a\u00020\u0002*\u00020\u0000\"\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/InputBox;", "", "", "", "Lcom/tencent/robot/aio/bottombar/model/a;", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/OptButton;", "a", "", "c", "e", "d", "button", "", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "Lk81/c;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", h.F, "b", "Lcom/tencent/qqnt/kernel/nativeinterface/OptType;", "Ljava/util/List;", "getSubItemOptTypeFilter", "()Ljava/util/List;", "SubItemOptTypeFilter", "Lcom/tencent/qqnt/kernel/nativeinterface/OptID;", "getValidItemOptID", "ValidItemOptID", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileExtKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<OptType> f366903a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<OptID> f366904b;

    static {
        List<OptType> listOf;
        List<OptID> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new OptType[]{OptType.KINVALID, OptType.KHALFVIEW, OptType.KURL, OptType.KSENDMSG});
        f366903a = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new OptID[]{OptID.KSTORY, OptID.KAIDRAW, OptID.KAIWRITE, OptID.KAISEARCH, OptID.KSIMPLEFUNCTION});
        f366904b = listOf2;
    }

    @NotNull
    public static final RobotBottomBarItemModel a(@NotNull OptButton optButton) {
        List emptyList;
        List list;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(optButton, "<this>");
        ArrayList<OptButton> subButtons = optButton.getSubButtons();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Intrinsics.checkNotNullExpressionValue(subButtons, "subButtons");
        boolean z16 = true;
        if (!subButtons.isEmpty()) {
            ArrayList<OptButton> arrayList = new ArrayList();
            for (Object obj : subButtons) {
                OptButton it = (OptButton) obj;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (e(it)) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (OptButton it5 : arrayList) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList2.add(a(it5));
            }
            list = arrayList2;
        } else {
            list = emptyList;
        }
        String buttonId = optButton.getButtonId();
        String name = optButton.getName();
        String icon = optButton.getIcon();
        String schema = optButton.getSchema();
        OptionType.Companion companion = OptionType.INSTANCE;
        OptType type = optButton.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType()");
        OptionType a16 = companion.a(type);
        int ordinal = optButton.getOptID().ordinal();
        boolean isSelected = optButton.getIsSelected();
        if (optButton.getDefaultCheck() <= 0) {
            z16 = false;
        }
        String callbackData = optButton.getCallbackData();
        String optDesc = optButton.getOptDesc();
        String promptTemplate = optButton.getPromptTemplate();
        String inputPlaceholder = optButton.getInputPlaceholder();
        Intrinsics.checkNotNullExpressionValue(buttonId, "getButtonId()");
        Intrinsics.checkNotNullExpressionValue(icon, "getIcon()");
        Intrinsics.checkNotNullExpressionValue(name, "getName()");
        Intrinsics.checkNotNullExpressionValue(schema, "getSchema()");
        Intrinsics.checkNotNullExpressionValue(callbackData, "getCallbackData()");
        Intrinsics.checkNotNullExpressionValue(optDesc, "getOptDesc()");
        Intrinsics.checkNotNullExpressionValue(promptTemplate, "getPromptTemplate()");
        Intrinsics.checkNotNullExpressionValue(inputPlaceholder, "getInputPlaceholder()");
        return new RobotBottomBarItemModel(0, ordinal, buttonId, icon, 0, name, false, null, schema, null, false, a16, list, callbackData, z16, isSelected, optDesc, promptTemplate, inputPlaceholder, 1744, null);
    }

    @NotNull
    public static final String b(@NotNull InputBox inputBox) {
        String joinToString$default;
        boolean z16;
        Intrinsics.checkNotNullParameter(inputBox, "<this>");
        ArrayList<ModelConfig> modelList = inputBox.modelList;
        Intrinsics.checkNotNullExpressionValue(modelList, "modelList");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(modelList, ", ", null, null, 0, null, new Function1<ModelConfig, CharSequence>() { // from class: com.tencent.robot.aio.bottombar.model.RobotProfileExtKt$getModelInfoForPrint$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(ModelConfig modelConfig) {
                String str = modelConfig.modelId;
                Intrinsics.checkNotNullExpressionValue(str, "it.modelId");
                return str;
            }
        }, 30, null);
        if (joinToString$default.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "No models available";
        }
        return joinToString$default;
    }

    public static final boolean c(@NotNull OptButton optButton) {
        Intrinsics.checkNotNullParameter(optButton, "<this>");
        if ((optButton.getType() == OptType.KINVALID || optButton.getType() == OptType.KHALFVIEW) && !d(optButton)) {
            f(optButton);
            return false;
        }
        return true;
    }

    private static final boolean d(OptButton optButton) {
        return f366904b.contains(optButton.getOptID());
    }

    public static final boolean e(@NotNull OptButton optButton) {
        Intrinsics.checkNotNullParameter(optButton, "<this>");
        if (!f366903a.contains(optButton.getType())) {
            f(optButton);
            return false;
        }
        return c(optButton);
    }

    public static final void f(@NotNull OptButton button) {
        Intrinsics.checkNotNullParameter(button, "button");
        QLog.i("RobotProfileExt", 1, "[parseRobotAIModelItems] the  item is not valid! button = " + button);
    }

    @NotNull
    public static final Map<String, List<RobotBottomBarItemModel>> g(@NotNull InputBox inputBox) {
        int collectionSizeOrDefault;
        List<String> list;
        List mutableList;
        boolean z16;
        Intrinsics.checkNotNullParameter(inputBox, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        QLog.i("RobotProfileExt", 1, "[parseRobotAIModelItems] aioButtons = " + inputBox.aioButtons);
        if (inputBox.aioButtons.isEmpty()) {
            QLog.i("RobotProfileExt", 1, "[parseRobotAIModelItems] aioButtons is null!");
            return linkedHashMap;
        }
        ArrayList<ModelConfig> modelList = inputBox.modelList;
        Intrinsics.checkNotNullExpressionValue(modelList, "modelList");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(modelList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = modelList.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelConfig) it.next()).getModelId());
        }
        ArrayList<OptButton> aioButtons = inputBox.aioButtons;
        Intrinsics.checkNotNullExpressionValue(aioButtons, "aioButtons");
        for (OptButton optButton : aioButtons) {
            Intrinsics.checkNotNullExpressionValue(optButton, "optButton");
            if (c(optButton)) {
                if (optButton.getType() == OptType.KSUBBUTTON) {
                    ArrayList<OptButton> arrayList2 = optButton.subButtons;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "optButton.subButtons");
                    if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                        for (OptButton it5 : arrayList2) {
                            Intrinsics.checkNotNullExpressionValue(it5, "it");
                            if (e(it5)) {
                                z16 = false;
                                break;
                            }
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                }
                ArrayList<String> filterModelIds = optButton.getFilterModelIds();
                RobotBottomBarItemModel a16 = a(optButton);
                if (arrayList.isEmpty() && filterModelIds.isEmpty()) {
                    list = CollectionsKt__CollectionsJVMKt.listOf("default_model_id");
                } else {
                    Intrinsics.checkNotNullExpressionValue(filterModelIds, "filterModelIds");
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : filterModelIds) {
                        if (arrayList.contains((String) obj)) {
                            arrayList3.add(obj);
                        }
                    }
                    list = arrayList3;
                }
                for (String str : list) {
                    Object obj2 = linkedHashMap.get(str);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(str, obj2);
                    }
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) obj2);
                    mutableList.add(a16);
                    linkedHashMap.put(str, mutableList);
                }
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final RobotModelProfileInfo h(@NotNull GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        RobotBaseInfo robotBaseInfo = groupRobotProfile.robotData;
        if (robotBaseInfo != null) {
            long j3 = robotBaseInfo.appid;
            String str = robotBaseInfo.name;
            Intrinsics.checkNotNullExpressionValue(str, "it.name");
            long j16 = robotBaseInfo.robotUin;
            String str2 = robotBaseInfo.robotUid;
            Intrinsics.checkNotNullExpressionValue(str2, "it.robotUid");
            InputBox inputBox = groupRobotProfile.inputBox;
            Intrinsics.checkNotNullExpressionValue(inputBox, "inputBox");
            return new RobotModelProfileInfo(j3, str, j16, str2, inputBox);
        }
        return new RobotModelProfileInfo(0L, null, 0L, null, null, 31, null);
    }

    @NotNull
    public static final RobotModelProfileInfo i(@NotNull RobotCoreInfo robotCoreInfo) {
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        long j3 = robotCoreInfo.appid;
        String name = robotCoreInfo.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        long j16 = robotCoreInfo.robotUin;
        String uid = robotCoreInfo.uid;
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        InputBox inputBox = robotCoreInfo.inputBox;
        Intrinsics.checkNotNullExpressionValue(inputBox, "inputBox");
        return new RobotModelProfileInfo(j3, name, j16, uid, inputBox);
    }
}
