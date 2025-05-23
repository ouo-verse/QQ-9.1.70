package com.tencent.biz.qqcircle.helpers;

import android.graphics.Typeface;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.ay;
import com.tencent.biz.qqcircle.bizparts.ba;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/f;", "", "", "Lcom/tencent/biz/richframework/part/Part;", "partList", "Lcom/tencent/biz/qqcircle/richframework/part/a;", "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "", "needAnimPart", "", "a", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "b", "Lcom/tencent/biz/qqcircle/comment/widget/q;", "view", "c", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f84618a = new f();

    f() {
    }

    public final void a(@NotNull List<Part> partList, @Nullable com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> reportBean, boolean needAnimPart) {
        Intrinsics.checkNotNullParameter(partList, "partList");
        QFSCommentPanelPart qFSCommentPanelPart = new QFSCommentPanelPart();
        qFSCommentPanelPart.setReportBeanAgent(reportBean);
        partList.add(qFSCommentPanelPart);
        if (needAnimPart) {
            partList.add(new ba());
            partList.add(new ay());
        }
    }

    public final void b(@NotNull LinearLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        container.setGravity(8388611);
    }

    public final void c(@NotNull com.tencent.biz.qqcircle.comment.widget.q view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.a() == null) {
            return;
        }
        view.g(QFSQUIUtilsKt.e(view.a().getContext(), R.color.qui_common_text_secondary_selector_brand_standard));
        view.h(Typeface.create(Typeface.DEFAULT, 1));
    }
}
