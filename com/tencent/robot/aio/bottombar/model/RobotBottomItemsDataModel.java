package com.tencent.robot.aio.bottombar.model;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.AIModelCallbackType;
import com.tencent.qqnt.kernel.nativeinterface.AIModelClickAction;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRsp;
import com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.InputBox;
import com.tencent.qqnt.kernel.nativeinterface.RobotSelectAIModelReq;
import com.tencent.qqnt.kernel.nativeinterface.SaveAIModelReq;
import com.tencent.qqnt.msg.f;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k81.RobotAIModelData;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0006J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\u0006\u0010\u0015\u001a\u00020\u00062\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000bJ\u000f\u0010!\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b!\u0010\u001eJ\u001e\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR(\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R&\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010%R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010.R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010.\u00a8\u00061"}, d2 = {"Lcom/tencent/robot/aio/bottombar/model/RobotBottomItemsDataModel;", "", "Lk81/a;", "data", "", "o", "", "j", "selectedModel", "d", "robotUid", "", "isChecked", "Lcom/tencent/robot/aio/bottombar/model/a;", "dataItem", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/InputBox;", "inputBox", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "modelID", "", "Lcom/tencent/robot/aio/bottombar/model/OptionType;", "optTypeFilterList", "i", "g", "isShowMoreInteract", ReportConstant.COSTREPORT_PREFIX, h.F, "()Ljava/lang/Boolean;", "hasModelList", "r", "f", "k", "", "a", "Ljava/util/Map;", "modelIDToItemsMap", "b", "Lk81/a;", "currentSelectedModel", "", "", "c", "selectedItemMap", "Ljava/lang/Boolean;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotBottomItemsDataModel {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final List<OptionType> f366897g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, ? extends List<RobotBottomBarItemModel>> modelIDToItemsMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RobotAIModelData currentSelectedModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, List<RobotBottomBarItemModel>> selectedItemMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isShowMoreInteract;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean hasModelList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/aio/bottombar/model/RobotBottomItemsDataModel$a;", "", "", "Lcom/tencent/robot/aio/bottombar/model/OptionType;", "MINI_AIO_OPTION_TYPE_FILTER", "Ljava/util/List;", "a", "()Ljava/util/List;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.bottombar.model.RobotBottomItemsDataModel$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<OptionType> a() {
            return RobotBottomItemsDataModel.f366897g;
        }

        Companion() {
        }
    }

    static {
        List<OptionType> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(OptionType.OPTION_CHECK);
        f366897g = listOf;
    }

    public RobotBottomItemsDataModel() {
        Map<String, ? extends List<RobotBottomBarItemModel>> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.modelIDToItemsMap = emptyMap;
        this.currentSelectedModel = new RobotAIModelData(0L, null, 0L, 0, null, null, null, null, null, null, false, null, 4095, null);
        this.selectedItemMap = new LinkedHashMap();
    }

    private final String d(RobotAIModelData selectedModel) {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(selectedModel.getCallBackData());
        List<RobotBottomBarItemModel> list = this.selectedItemMap.get(selectedModel.getModelID());
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jsonArray.add(((RobotBottomBarItemModel) it.next()).getCallBackData());
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("buttons", jsonArray);
        String json = new GsonBuilder().disableHtmlEscaping().create().toJson((JsonElement) jsonObject);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(jsonObject)");
        return json;
    }

    private final String j() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (currentUin == null) {
            return "";
        }
        return currentUin;
    }

    private final void l(String robotUid, boolean isChecked, RobotBottomBarItemModel dataItem) {
        int collectionSizeOrDefault;
        ac robotService;
        final SaveAIModelReq saveAIModelReq = new SaveAIModelReq();
        saveAIModelReq.modelId = this.currentSelectedModel.getModelID();
        saveAIModelReq.uid = robotUid;
        bg bgVar = bg.f302144a;
        Map<String, List<RobotBottomBarItemModel>> map = this.selectedItemMap;
        String modelID = this.currentSelectedModel.getModelID();
        List<RobotBottomBarItemModel> list = map.get(modelID);
        if (list == null) {
            list = new ArrayList<>();
            map.put(modelID, list);
        }
        List<RobotBottomBarItemModel> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((RobotBottomBarItemModel) it.next()).getItemID());
        }
        saveAIModelReq.buttonIds = bgVar.n(arrayList);
        if (dataItem != null && dataItem.getIsDefaultChecked() && !isChecked) {
            saveAIModelReq.unSelectedbtnIds.add(dataItem.getItemID());
        }
        IKernelService i3 = f.i();
        if (i3 != null && (robotService = i3.getRobotService()) != null) {
            robotService.saveSelectedAIModelOrOptIds(saveAIModelReq, new IOperateCallback() { // from class: com.tencent.robot.aio.bottombar.model.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    RobotBottomItemsDataModel.n(SaveAIModelReq.this, i16, str);
                }
            });
        }
    }

    static /* synthetic */ void m(RobotBottomItemsDataModel robotBottomItemsDataModel, String str, boolean z16, RobotBottomBarItemModel robotBottomBarItemModel, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            robotBottomBarItemModel = null;
        }
        robotBottomItemsDataModel.l(str, z16, robotBottomBarItemModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(SaveAIModelReq req, int i3, String str) {
        Intrinsics.checkNotNullParameter(req, "$req");
        QLog.d("RobotBottomItemsDataModel", 4, "[saveItemSelectState] req = " + req + "  result=" + i3 + ", errMsg=" + str);
    }

    private final void o(RobotAIModelData data) {
        final RobotSelectAIModelReq robotSelectAIModelReq = new RobotSelectAIModelReq();
        robotSelectAIModelReq.botAppId = data.getAppID();
        robotSelectAIModelReq.botUin = data.getRobotUin();
        robotSelectAIModelReq.callbackData = d(data);
        robotSelectAIModelReq.c2cUin = Long.parseLong(j());
        robotSelectAIModelReq.chatType = data.getChatType();
        robotSelectAIModelReq.botUid = data.getRobotUid();
        robotSelectAIModelReq.callBackType = AIModelCallbackType.SWITCH;
        robotSelectAIModelReq.action = AIModelClickAction.CHOOSE;
        ac O = AdelieUtils.f365929a.O();
        if (O != null) {
            O.selectAIModel(robotSelectAIModelReq, new ICommandCbCallback() { // from class: com.tencent.robot.aio.bottombar.model.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback
                public final void onResult(int i3, String str, CommandCbRsp commandCbRsp) {
                    RobotBottomItemsDataModel.p(RobotSelectAIModelReq.this, i3, str, commandCbRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(RobotSelectAIModelReq selectRequest, int i3, String str, CommandCbRsp commandCbRsp) {
        Intrinsics.checkNotNullParameter(selectRequest, "$selectRequest");
        QLog.i("RobotBottomItemsDataModel", 1, "call selectAIModel method  selectRequest = " + selectRequest + ", result = " + i3 + " and errMsg = " + str + " and rsp = " + commandCbRsp);
    }

    @NotNull
    public final String e() {
        return this.currentSelectedModel.getModelID();
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Boolean getHasModelList() {
        return this.hasModelList;
    }

    @NotNull
    public final RobotBottomBarItemModel g() {
        return new RobotBottomBarItemModel(1, 6, null, "https://static-res.qq.com/static-res/adelie/aio/qui_gallery.png", 0, "\u66f4\u591a\u4e92\u52a8", false, "", null, null, false, OptionType.OPTION_MORE, null, "opt_id=6", false, false, null, null, null, 513860, null);
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final Boolean getIsShowMoreInteract() {
        return this.isShowMoreInteract;
    }

    @NotNull
    public final List<RobotBottomBarItemModel> i(@NotNull String modelID, @NotNull List<? extends OptionType> optTypeFilterList) {
        Intrinsics.checkNotNullParameter(modelID, "modelID");
        Intrinsics.checkNotNullParameter(optTypeFilterList, "optTypeFilterList");
        ArrayList arrayList = new ArrayList();
        List<RobotBottomBarItemModel> list = this.modelIDToItemsMap.get(modelID);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        arrayList.addAll(list);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            RobotBottomBarItemModel robotBottomBarItemModel = (RobotBottomBarItemModel) obj;
            boolean z16 = true;
            if (!optTypeFilterList.isEmpty()) {
                z16 = optTypeFilterList.contains(robotBottomBarItemModel.getOptionType());
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final void k(@NotNull String robotUid, boolean isChecked, @NotNull final RobotBottomBarItemModel dataItem) {
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(dataItem, "dataItem");
        Map<String, List<RobotBottomBarItemModel>> map = this.selectedItemMap;
        String modelID = this.currentSelectedModel.getModelID();
        List<RobotBottomBarItemModel> list = map.get(modelID);
        if (list == null) {
            list = new ArrayList<>();
            map.put(modelID, list);
        }
        List<RobotBottomBarItemModel> list2 = list;
        if (!isChecked) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) list2, (Function1) new Function1<RobotBottomBarItemModel, Boolean>() { // from class: com.tencent.robot.aio.bottombar.model.RobotBottomItemsDataModel$onItemSelectedStatusChange$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull RobotBottomBarItemModel it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.getItemID(), RobotBottomBarItemModel.this.getItemID()));
                }
            });
        } else {
            list2.add(dataItem);
        }
        this.selectedItemMap.put(this.currentSelectedModel.getModelID(), list2);
        o(this.currentSelectedModel);
        l(robotUid, isChecked, dataItem);
    }

    public final void q(@NotNull RobotAIModelData data) {
        List<RobotBottomBarItemModel> mutableList;
        Intrinsics.checkNotNullParameter(data, "data");
        List<RobotBottomBarItemModel> list = this.modelIDToItemsMap.get(data.getModelID());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RobotBottomBarItemModel) obj).getIsChecked()) {
                arrayList.add(obj);
            }
        }
        Map<String, List<RobotBottomBarItemModel>> map = this.selectedItemMap;
        String modelID = data.getModelID();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        map.put(modelID, mutableList);
        if (!Intrinsics.areEqual(this.currentSelectedModel.getModelID(), data.getModelID())) {
            this.currentSelectedModel = data;
            o(data);
            m(this, data.getRobotUid(), false, null, 6, null);
        }
    }

    public final void r(boolean hasModelList) {
        this.hasModelList = Boolean.valueOf(hasModelList);
    }

    public final void s(boolean isShowMoreInteract) {
        this.isShowMoreInteract = Boolean.valueOf(isShowMoreInteract);
    }

    public final void t(@NotNull InputBox inputBox) {
        Intrinsics.checkNotNullParameter(inputBox, "inputBox");
        this.modelIDToItemsMap = RobotProfileExtKt.g(inputBox);
    }
}
