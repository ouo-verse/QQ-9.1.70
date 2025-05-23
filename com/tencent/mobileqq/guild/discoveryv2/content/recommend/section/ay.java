package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendThirdVideoData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdPlatform;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdVideoInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ay;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendThirdVideoData;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mCover", "f", "Landroid/view/View;", "mContainer", tl.h.F, "mPlatform", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mPlatformName", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "mPlatformIcon", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ay extends ar<RecommendThirdVideoData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mCover;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mPlatform;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mPlatformName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundImageView mPlatformIcon;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w5u};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.w57);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_\u2026ed_third_video_container)");
            this.mContainer = findViewById;
            View findViewById2 = containerView.findViewById(R.id.w58);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_\u2026y_feed_third_video_cover)");
            this.mCover = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.w5_);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_\u2026_third_video_platform_ll)");
            this.mPlatform = findViewById3;
            View findViewById4 = containerView.findViewById(R.id.w59);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_\u2026_third_video_platform_iv)");
            this.mPlatformIcon = (RoundImageView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.w5a);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.guild_\u2026_third_video_platform_tv)");
            this.mPlatformName = (TextView) findViewById5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075 A[EDGE_INSN: B:27:0x0075->B:28:0x0075 BREAK  A[LOOP:0: B:13:0x0042->B:66:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[LOOP:0: B:13:0x0042->B:66:?, LOOP_END, SYNTHETIC] */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(@NotNull RecommendThirdVideoData data, int position, @Nullable List<Object> payload) {
        boolean z16;
        Object obj;
        boolean isBlank;
        String str;
        ImageView imageView;
        IGProMVPURLContent urlContent;
        RoundImageView roundImageView;
        boolean z17;
        String str2;
        IGProMVPThirdVideoInfo thirdVideoInfo;
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
        View view = this.mContainer;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        view.setVisibility(8);
        ArrayList<IGProMVPRichTextContent> contents = data.getRichText().getContents();
        Intrinsics.checkNotNullExpressionValue(contents, "data.richText.contents");
        Iterator<T> it = contents.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                IGProMVPRichTextContent iGProMVPRichTextContent = (IGProMVPRichTextContent) obj;
                if (iGProMVPRichTextContent.getType() == 3) {
                    IGProMVPURLContent urlContent2 = iGProMVPRichTextContent.getUrlContent();
                    if (urlContent2 != null && (thirdVideoInfo = urlContent2.getThirdVideoInfo()) != null) {
                        str2 = thirdVideoInfo.getCover();
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        z17 = true;
                        if (!z17) {
                            break;
                        }
                    }
                }
                z17 = false;
                if (!z17) {
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProMVPRichTextContent iGProMVPRichTextContent2 = (IGProMVPRichTextContent) obj;
        String mediaCoverURL = data.getMediaCoverURL();
        isBlank = StringsKt__StringsJVMKt.isBlank(mediaCoverURL);
        if (!isBlank) {
            str = mediaCoverURL;
        } else {
            str = null;
        }
        if (str != null) {
            View view2 = this.mContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view2 = null;
            }
            view2.setVisibility(0);
            com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
            ImageView imageView2 = this.mCover;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCover");
                imageView = null;
            } else {
                imageView = imageView2;
            }
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, str, q().b(), q().h(), false, 16, null);
            if (iGProMVPRichTextContent2 != null && (urlContent = iGProMVPRichTextContent2.getUrlContent()) != null) {
                View view3 = this.mPlatform;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlatform");
                    view3 = null;
                }
                view3.setVisibility(8);
                IGProMVPThirdPlatform thirdPlatform = urlContent.getThirdPlatform();
                if (thirdPlatform != null) {
                    Intrinsics.checkNotNullExpressionValue(thirdPlatform, "thirdPlatform");
                    View view4 = this.mPlatform;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlatform");
                        view4 = null;
                    }
                    view4.setVisibility(0);
                    RoundImageView roundImageView2 = this.mPlatformIcon;
                    if (roundImageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlatformIcon");
                        roundImageView = null;
                    } else {
                        roundImageView = roundImageView2;
                    }
                    com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, roundImageView, thirdPlatform.getIcon(), 0, 0, false, 28, null);
                    TextView textView2 = this.mPlatformName;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlatformName");
                    } else {
                        textView = textView2;
                    }
                    textView.setText(thirdPlatform.getName());
                }
            }
        }
    }
}
