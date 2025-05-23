package com.qzone.reborn.message.section;

import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/message/section/q;", "Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "", "position", "", "", "payload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, tl.h.F, "Landroid/view/View;", "contentRootLayout", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q extends QZOldStylePassiveMsgBaseSection {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View contentRootLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n7c);
        this.contentRootLayout = findViewById;
        if (findViewById != null) {
            findViewById.setBackgroundColor(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_fill_light_primary, null));
        }
        View view = this.contentRootLayout;
        if (view != null) {
            view.setOnClickListener(getSpaceClickListener());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(BusinessFeedData data, int position, List<Object> payload) {
    }
}
