package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections;

import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/a;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "p", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "r", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;)V", "data", "", "e", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", ReportConstant.COSTREPORT_PREFIX, "(I)V", "position", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class a extends Section<QQStrangerLiteActionModel> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQStrangerLiteActionModel data = new QQStrangerLiteActionModel(null, false, null, 0, null, null, null, null, 0, 0, 0, null, false, false, null, 32767, null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p, reason: from getter */
    public final QQStrangerLiteActionModel getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(QQStrangerLiteActionModel qQStrangerLiteActionModel) {
        Intrinsics.checkNotNullParameter(qQStrangerLiteActionModel, "<set-?>");
        this.data = qQStrangerLiteActionModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(int i3) {
        this.position = i3;
    }
}
