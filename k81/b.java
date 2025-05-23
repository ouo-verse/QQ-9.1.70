package k81;

import com.tencent.qqnt.kernel.nativeinterface.ModelConfig;
import com.tencent.qqnt.kernel.nativeinterface.ModelDisableStyle;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\tR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lk81/b;", "", "", "chatType", "Lk81/c;", "modelProfileInfo", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ModelConfig;", Constants.Configs.CONFIGS, "", "selectModelId", "", h.F, "", "g", "e", "f", "Lk81/a;", "d", "a", "modelId", "i", "c", "b", "", "Ljava/util/List;", "allModelData", "Ljava/lang/String;", "curSelectModelId", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<RobotAIModelData> allModelData = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curSelectModelId = "";

    @Nullable
    public final RobotAIModelData a() {
        Object obj;
        Iterator<T> it = this.allModelData.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((RobotAIModelData) obj).getModelID(), this.curSelectModelId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (RobotAIModelData) obj;
    }

    @NotNull
    public final String b() {
        Object obj;
        Iterator<T> it = this.allModelData.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((RobotAIModelData) obj).getModelID(), this.curSelectModelId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        RobotAIModelData robotAIModelData = (RobotAIModelData) obj;
        if (robotAIModelData == null || robotAIModelData.getDisableStyle() == ModelDisableStyle.KMDSDISABLED) {
            return "";
        }
        return robotAIModelData.getCallBackData();
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCurSelectModelId() {
        return this.curSelectModelId;
    }

    @NotNull
    public final List<RobotAIModelData> d() {
        boolean z16;
        List<RobotAIModelData> list = this.allModelData;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            RobotAIModelData robotAIModelData = (RobotAIModelData) obj;
            if (robotAIModelData.getDisableStyle() != ModelDisableStyle.KMDSENABLE && robotAIModelData.getDisableStyle() != ModelDisableStyle.KMDSDISABLED) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean e() {
        Object obj;
        boolean z16;
        Iterator<T> it = this.allModelData.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((RobotAIModelData) obj).getDisableStyle() != ModelDisableStyle.KMDSDISABLED) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        Object obj;
        boolean z16;
        Iterator<T> it = this.allModelData.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((RobotAIModelData) obj).getDisableStyle() != ModelDisableStyle.KMDSHIDE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        return this.allModelData.isEmpty();
    }

    public final void h(int chatType, @NotNull RobotModelProfileInfo modelProfileInfo, @NotNull List<ModelConfig> configs, @NotNull String selectModelId) {
        int collectionSizeOrDefault;
        int i3;
        int max;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(modelProfileInfo, "modelProfileInfo");
        Intrinsics.checkNotNullParameter(configs, "configs");
        Intrinsics.checkNotNullParameter(selectModelId, "selectModelId");
        this.allModelData.clear();
        this.curSelectModelId = selectModelId;
        List<ModelConfig> list = configs;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ModelConfig modelConfig = (ModelConfig) it.next();
            long appID = modelProfileInfo.getAppID();
            String robotUid = modelProfileInfo.getRobotUid();
            long robotUin = modelProfileInfo.getRobotUin();
            String modelIcon = modelConfig.modelIcon;
            String modelId = modelConfig.modelId;
            String title = modelConfig.title;
            String aioTitle = modelConfig.aioTitle;
            String desc = modelConfig.desc;
            Iterator it5 = it;
            String callbackData = modelConfig.callbackData;
            ModelDisableStyle disableStyle = modelConfig.disableStyle;
            Intrinsics.checkNotNullExpressionValue(modelIcon, "modelIcon");
            Intrinsics.checkNotNullExpressionValue(modelId, "modelId");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(aioTitle, "aioTitle");
            Intrinsics.checkNotNullExpressionValue(desc, "desc");
            Intrinsics.checkNotNullExpressionValue(callbackData, "callbackData");
            Intrinsics.checkNotNullExpressionValue(disableStyle, "disableStyle");
            arrayList.add(Boolean.valueOf(this.allModelData.add(new RobotAIModelData(appID, robotUid, robotUin, chatType, modelIcon, modelId, title, aioTitle, desc, callbackData, false, disableStyle))));
            it = it5;
        }
        Iterator<RobotAIModelData> it6 = this.allModelData.iterator();
        int i16 = 0;
        while (true) {
            i3 = -1;
            if (it6.hasNext()) {
                if (Intrinsics.areEqual(it6.next().getModelID(), selectModelId)) {
                    break;
                } else {
                    i16++;
                }
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 == -1) {
            Iterator<RobotAIModelData> it7 = this.allModelData.iterator();
            int i17 = 0;
            while (true) {
                if (!it7.hasNext()) {
                    break;
                }
                if (it7.next().getDisableStyle() == ModelDisableStyle.KMDSENABLE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    i3 = i17;
                    break;
                }
                i17++;
            }
            max = Math.max(0, i3);
        } else if (this.allModelData.get(i16).getDisableStyle() == ModelDisableStyle.KMDSENABLE) {
            max = Math.min(i16, this.allModelData.size() - 1);
        } else {
            Iterator<RobotAIModelData> it8 = this.allModelData.iterator();
            int i18 = 0;
            while (true) {
                if (!it8.hasNext()) {
                    break;
                }
                if (it8.next().getDisableStyle() == ModelDisableStyle.KMDSENABLE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i3 = i18;
                    break;
                }
                i18++;
            }
            max = Math.max(0, i3);
        }
        if (max >= 0 && max < this.allModelData.size()) {
            this.curSelectModelId = this.allModelData.get(max).getModelID();
            this.allModelData.get(max).k(true);
        }
    }

    public final void i(@NotNull String modelId) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        this.curSelectModelId = modelId;
        List<RobotAIModelData> list = this.allModelData;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (RobotAIModelData robotAIModelData : list) {
            robotAIModelData.k(false);
            if (Intrinsics.areEqual(modelId, robotAIModelData.getModelID())) {
                robotAIModelData.k(true);
            }
            arrayList.add(Unit.INSTANCE);
        }
    }
}
