package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ai;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mPic", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ai extends ar<com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mPic;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w5x};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.w5l);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_discovery_v2_feed_image)");
            this.mPic = (ImageView) findViewById;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k data, int position, @Nullable List<Object> payload) {
        boolean z16;
        boolean isBlank;
        String str;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(data, "data");
        List<Object> list = payload;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        ImageView imageView2 = this.mPic;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        String mediaCoverURL = data.getMediaCoverURL();
        isBlank = StringsKt__StringsJVMKt.isBlank(mediaCoverURL);
        if (!isBlank) {
            str = mediaCoverURL;
        } else {
            str = null;
        }
        if (str != null) {
            ImageView imageView3 = this.mPic;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPic");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
            com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
            ImageView imageView4 = this.mPic;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPic");
                imageView = null;
            } else {
                imageView = imageView4;
            }
            dVar.b(imageView, str, q().b(), q().h(), true);
        }
    }
}
