package com.tencent.mobileqq.filemanager.fileviewer.onlineprint;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.v;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/f;", "Lcom/tencent/mobileqq/widget/listitem/v;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "view", "", "position", "", "", "payloads", "", UserInfo.SEX_FEMALE, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f extends v {
    public f() {
        super(R.layout.e7f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    public void F(@NotNull View view, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.NoneRound;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        view.setBackground(qUIListItemBackgroundType.getBackground(context, 1000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.v, com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public View H(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View H = super.H(parent);
        ViewGroup viewGroup = (ViewGroup) H.findViewById(R.id.title_container);
        Context context = H.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QUITagView qUITagView = new QUITagView(context, null, 2, null);
        qUITagView.setConfig(new QUITagViewConfig(QUITagType.COLOR_BLUE, QUITagSize.SMALL, null, "\u8be5\u670d\u52a1\u7531\u7b2c\u4e09\u65b9\u63d0\u4f9b"));
        viewGroup.addView(qUITagView);
        return H;
    }
}
