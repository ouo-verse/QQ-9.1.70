package com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos;

import android.view.View;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/composer/operationpos/b;", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/operationpos/BasePlusEntryOperationPosComposer;", "Landroid/view/View;", "l", "Landroid/view/View;", "()Landroid/view/View;", "normalView", "", "d", "()Ljava/lang/String;", "logTag", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends BasePlusEntryOperationPosComposer {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View normalView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        this.normalView = plusEntryLayout.findViewById(R.id.f502624x);
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos.BasePlusEntryOperationPosComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-PlusEntryOperationPosComposer";
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos.BasePlusEntryOperationPosComposer
    @Nullable
    /* renamed from: l, reason: from getter */
    public View getNormalView() {
        return this.normalView;
    }
}
