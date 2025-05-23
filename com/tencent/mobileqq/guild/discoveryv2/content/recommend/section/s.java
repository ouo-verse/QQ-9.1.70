package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTencentDocsContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/s;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedSection;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mPic", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class s extends ar<IGProContentRecommendFeed> {

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
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053 A[SYNTHETIC] */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(@NotNull IGProContentRecommendFeed data, int position, @Nullable List<Object> payload) {
        Collection emptyList;
        ImageView imageView;
        String str;
        boolean z16;
        boolean isBlank;
        IGProMVPTencentDocsContent tencentDocsContent;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("RecommendFileSection", 1, "RecommendFileSection data.feedContentType: " + data.getFeedContentType());
        if (data.getRichText().getContents() == null) {
            return;
        }
        ImageView imageView2 = this.mPic;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        ArrayList<IGProMVPRichTextContent> contents = data.getRichText().getContents();
        if (contents == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            for (Object obj : contents) {
                IGProMVPURLContent urlContent = ((IGProMVPRichTextContent) obj).getUrlContent();
                if (urlContent != null && (tencentDocsContent = urlContent.getTencentDocsContent()) != null) {
                    str = tencentDocsContent.getUrl();
                } else {
                    str = null;
                }
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z16 = false;
                        if (!(!z16)) {
                            emptyList.add(obj);
                        }
                    }
                }
                z16 = true;
                if (!(!z16)) {
                }
            }
        }
        Iterator it = emptyList.iterator();
        while (it.hasNext()) {
            IGProMVPURLContent urlContent2 = ((IGProMVPRichTextContent) it.next()).getUrlContent();
            Intrinsics.checkNotNull(urlContent2);
            IGProMVPTencentDocsContent tencentDocsContent2 = urlContent2.getTencentDocsContent();
            Intrinsics.checkNotNull(tencentDocsContent2);
            String url = tencentDocsContent2.getUrl();
            Intrinsics.checkNotNull(url);
            QLog.d("RecommendFileSection", 1, "url: " + url);
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
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, url, q().b(), 222, false, 16, null);
        }
    }
}
