package com.tencent.mobileqq.aio.robot.titlebar;

import com.tencent.mobileqq.aio.robot.titlebar.RobotTopBarUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.InputBox;
import com.tencent.qqnt.kernel.nativeinterface.ModelConfig;
import java.util.ArrayList;
import java.util.Iterator;
import k81.RobotModelProfileInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0004J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0004J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0004R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/m;", "Lcom/tencent/qqnt/aio/baseVM/a;", "", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState;", "", "selectModelId", "Lk81/c;", "modelProfileInfo", "", "o", "robotModelProfileInfo", DomainData.DOMAIN_NAME, "", "showEar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isSelectMode", "l", "e", "Ljava/lang/String;", "<init>", "()V", "f", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class m extends com.tencent.qqnt.aio.baseVM.a<Object, RobotTopBarUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String selectModelId = "";

    private final void o(String selectModelId, RobotModelProfileInfo modelProfileInfo) {
        updateUI(new RobotTopBarUIState.UpdateModelButton(selectModelId, modelProfileInfo));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(boolean isSelectMode) {
        updateUI(new RobotTopBarUIState.MultiSelectModelEvent(isSelectMode));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(boolean showEar) {
        updateUI(new RobotTopBarUIState.UpdateEarIconEvent(showEar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(@Nullable RobotModelProfileInfo robotModelProfileInfo) {
        InputBox inputBox;
        ArrayList<ModelConfig> arrayList;
        Object obj;
        String str = null;
        if (robotModelProfileInfo != null && (inputBox = robotModelProfileInfo.getInputBox()) != null && (arrayList = inputBox.modelList) != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((ModelConfig) obj).isSelected) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ModelConfig modelConfig = (ModelConfig) obj;
            if (modelConfig != null) {
                str = modelConfig.modelId;
            }
        }
        if (str == null) {
            str = "";
        }
        this.selectModelId = str;
        QLog.e("RobotAIModelButtonVB", 1, "updateModelFromCache selectModelId = " + str);
        if (robotModelProfileInfo != null) {
            o(this.selectModelId, robotModelProfileInfo);
        }
    }
}
