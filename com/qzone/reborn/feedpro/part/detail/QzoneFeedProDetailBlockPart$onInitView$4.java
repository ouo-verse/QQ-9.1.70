package com.qzone.reborn.feedpro.part.detail;

import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
/* synthetic */ class QzoneFeedProDetailBlockPart$onInitView$4 extends FunctionReferenceImpl implements Function1<UIStateData<wd.b>, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<wd.b> uIStateData) {
        invoke2(uIStateData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QzoneFeedProDetailBlockPart$onInitView$4(Object obj) {
        super(1, obj, QzoneFeedProDetailBlockPart.class, "handleDetailCommentAdRsp", "handleDetailCommentAdRsp(Lcom/tencent/richframework/data/base/UIStateData;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UIStateData<wd.b> uIStateData) {
        ((QzoneFeedProDetailBlockPart) this.receiver).T9(uIStateData);
    }
}
