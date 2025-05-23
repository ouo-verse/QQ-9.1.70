package com.tencent.mobileqq.wink.preview.viewmodel;

import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource;
import com.tencent.mobileqq.wink.preview.datasource.WinkLabelShareDataSource;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "Lcom/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource;", "S1", "", "Z1", "Landroidx/fragment/app/Fragment;", "host", "", "i2", "", "", "labelList", SemanticAttributes.DbSystemValues.H2, "L", "Ljava/lang/String;", "g2", "()Ljava/lang/String;", PhotoCategorySummaryInfo.AVATAR_URL, "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends WinkBasePreviewShareViewModel {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final String avatarUrl;

    public a() {
        String str;
        Pair<String, Long> u16 = WinkEditorResourceManager.a1().u1();
        if (u16 != null) {
            str = (String) u16.first;
        } else {
            str = null;
        }
        this.avatarUrl = str == null ? "" : str;
    }

    @Override // com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel
    @NotNull
    public WinkBasePreviewShareDataSource S1() {
        return WinkLabelShareDataSource.f325386c;
    }

    @Override // com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel
    public boolean Z1() {
        return true;
    }

    @NotNull
    /* renamed from: g2, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final void h2(@NotNull List<String> labelList) {
        Intrinsics.checkNotNullParameter(labelList, "labelList");
        WinkBasePreviewShareDataSource S1 = S1();
        Intrinsics.checkNotNull(S1, "null cannot be cast to non-null type com.tencent.mobileqq.wink.preview.datasource.WinkLabelShareDataSource");
        ((WinkLabelShareDataSource) S1).s(labelList);
    }

    public final void i2(@NotNull Fragment host) {
        Intrinsics.checkNotNullParameter(host, "host");
        WinkBasePreviewShareDataSource S1 = S1();
        Intrinsics.checkNotNull(S1, "null cannot be cast to non-null type com.tencent.mobileqq.wink.preview.datasource.WinkLabelShareDataSource");
        ((WinkLabelShareDataSource) S1).t(host);
    }
}
