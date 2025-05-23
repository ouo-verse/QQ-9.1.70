package com.tencent.robot.discover.adapter.section;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/discover/adapter/section/q;", "Lcom/tencent/robot/discover/adapter/section/RobotContentSection;", "Lk34/a;", "data", "", "position", "", "", "payload", "", BdhLogUtil.LogTag.Tag_Conn, "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class q extends RobotContentSection {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.discover.adapter.section.RobotContentSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C */
    public void onBindData(@NotNull k34.a data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.onBindData(data, position, payload);
        if (data instanceof k34.f) {
            k34.f fVar = (k34.f) data;
            String keyWord = fVar.getKeyWord();
            TextView x16 = x();
            n34.e eVar = n34.e.f418127a;
            String str = fVar.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo.robotName;
            Context context = x().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mTitleText.context");
            x16.setText(eVar.c(str, keyWord, context));
        }
    }
}
