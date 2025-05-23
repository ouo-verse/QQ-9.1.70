package com.tencent.mobileqq.guild.contentshare.template;

import android.view.ViewGroup;
import com.tencent.mobileqq.guild.contentshare.d;
import com.tencent.mobileqq.guild.contentshare.g;
import com.tencent.mobileqq.guild.contentshare.h;
import com.tencent.mobileqq.guild.contentshare.template.header.SharePicHeadComponentLayout;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0002\t\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/HeaderComponent;", "Lcom/tencent/mobileqq/guild/contentshare/g;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Lcom/tencent/mobileqq/guild/contentshare/h;", "style", "", "a", "Lcom/tencent/mobileqq/guild/contentshare/template/HeaderComponent$LayoutType;", "Lcom/tencent/mobileqq/guild/contentshare/template/HeaderComponent$LayoutType;", "getLayoutType", "()Lcom/tencent/mobileqq/guild/contentshare/template/HeaderComponent$LayoutType;", "layoutType", "<init>", "(Lcom/tencent/mobileqq/guild/contentshare/template/HeaderComponent$LayoutType;)V", "b", "LayoutType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class HeaderComponent implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LayoutType layoutType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/HeaderComponent$LayoutType;", "", "(Ljava/lang/String;I)V", "Horizontal", "Vertical", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum LayoutType {
        Horizontal,
        Vertical
    }

    public HeaderComponent(@NotNull LayoutType layoutType) {
        Intrinsics.checkNotNullParameter(layoutType, "layoutType");
        this.layoutType = layoutType;
    }

    @Override // com.tencent.mobileqq.guild.contentshare.g
    public void a(@NotNull ViewGroup parent, @NotNull d shareData, @Nullable h style) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        QLog.i("SharePicHeaderComponent", 1, "setContent");
        SharePicHeadComponentLayout sharePicHeadComponentLayout = new SharePicHeadComponentLayout(parent.getContext());
        sharePicHeadComponentLayout.f(this.layoutType);
        sharePicHeadComponentLayout.e(shareData);
        parent.addView(sharePicHeadComponentLayout);
    }
}
