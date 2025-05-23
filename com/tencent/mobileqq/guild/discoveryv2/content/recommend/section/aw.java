package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.graphics.drawable.Drawable;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/aw;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "t", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mPic", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aw extends ar<com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mPic;

    private final void s() {
        ImageView imageView = this.mPic;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView = null;
        }
        Drawable drawable = imageView.getContext().getDrawable(R.drawable.guild_discovery_v2_third_link_default_bg);
        ImageView imageView3 = this.mPic;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setImageDrawable(drawable);
    }

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
            ImageView imageView = (ImageView) findViewById;
            this.mPic = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPic");
                imageView = null;
            }
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
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
        String mediaCoverURL = data.getMediaCoverURL();
        isBlank = StringsKt__StringsJVMKt.isBlank(mediaCoverURL);
        if (true ^ isBlank) {
            str = mediaCoverURL;
        } else {
            str = null;
        }
        if (str == null) {
            s();
            return;
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
        ImageView imageView2 = this.mPic;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView = null;
        } else {
            imageView = imageView2;
        }
        dVar.b(imageView, str, q().b(), q().h(), true);
    }
}
