package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFileData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendThirdShareLinkData;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPCommThirdShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichText;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/as;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedSection;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "textView", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class as extends ar<IGProContentRecommendFeed> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.w5s);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_discovery_v2_feed_text)");
            TextView textView = (TextView) findViewById;
            this.textView = textView;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView = null;
            }
            TextView textView3 = this.textView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView2 = textView3;
            }
            textView.setTextColor(textView2.getResources().getColorStateList(R.color.qui_common_text_primary));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e6  */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(@NotNull IGProContentRecommendFeed data, int position, @Nullable List<Object> payload) {
        boolean z16;
        CharSequence charSequence;
        boolean isBlank;
        boolean z17;
        String str;
        ArrayList<IGProMVPRichTextContent> contents;
        Object obj;
        IGProMVPURLContent urlContent;
        IGProMVPCommThirdShareInfo thirdShareInfo;
        boolean z18;
        boolean isBlank2;
        boolean z19;
        boolean isBlank3;
        boolean z26;
        boolean isBlank4;
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
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = q().b();
            textView.setLayoutParams(layoutParams);
            TextView textView3 = this.textView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView3 = null;
            }
            if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(data.getFeedType())) {
                charSequence = data.getTitle();
            } else if (data.getFeedType() == 1) {
                charSequence = fi1.b.f398763a.b(data);
            } else {
                charSequence = "";
            }
            textView3.setText(charSequence);
            if (q().f()) {
                TextView textView4 = this.textView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                    textView4 = null;
                }
                CharSequence text = textView4.getText();
                if (text != null) {
                    isBlank4 = StringsKt__StringsJVMKt.isBlank(text);
                    if (!isBlank4) {
                        z26 = false;
                        if (z26) {
                            TextView textView5 = this.textView;
                            if (textView5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("textView");
                                textView5 = null;
                            }
                            textView5.setText(data.getTitle());
                        }
                    }
                }
                z26 = true;
                if (z26) {
                }
            }
            if (this.mData instanceof RecommendFileData) {
                TextView textView6 = this.textView;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                    textView6 = null;
                }
                CharSequence text2 = textView6.getText();
                if (text2 != null) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(text2);
                    if (!isBlank3) {
                        z19 = false;
                        if (z19) {
                            TextView textView7 = this.textView;
                            if (textView7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("textView");
                                textView7 = null;
                            }
                            textView7.setText(data.getTitle());
                        }
                    }
                }
                z19 = true;
                if (z19) {
                }
            }
            if (this.mData instanceof RecommendThirdShareLinkData) {
                TextView textView8 = this.textView;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                    textView8 = null;
                }
                CharSequence text3 = textView8.getText();
                if (text3 != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(text3);
                    if (!isBlank2) {
                        z17 = false;
                        if (z17) {
                            TextView textView9 = this.textView;
                            if (textView9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("textView");
                                textView9 = null;
                            }
                            IGProMVPRichText richText = data.getRichText();
                            if (richText != null && (contents = richText.getContents()) != null) {
                                Iterator<T> it = contents.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        obj = it.next();
                                        IGProMVPRichTextContent iGProMVPRichTextContent = (IGProMVPRichTextContent) obj;
                                        if (iGProMVPRichTextContent.getType() == 3 && iGProMVPRichTextContent.getUrlContent().getType() == 6) {
                                            z18 = true;
                                        } else {
                                            z18 = false;
                                        }
                                        if (z18) {
                                            break;
                                        }
                                    } else {
                                        obj = null;
                                        break;
                                    }
                                }
                                IGProMVPRichTextContent iGProMVPRichTextContent2 = (IGProMVPRichTextContent) obj;
                                if (iGProMVPRichTextContent2 != null && (urlContent = iGProMVPRichTextContent2.getUrlContent()) != null && (thirdShareInfo = urlContent.getThirdShareInfo()) != null) {
                                    str = thirdShareInfo.getTitle();
                                    textView9.setText(str);
                                }
                            }
                            str = null;
                            textView9.setText(str);
                        }
                    }
                }
                z17 = true;
                if (z17) {
                }
            }
            TextView textView10 = this.textView;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView10 = null;
            }
            TextView textView11 = this.textView;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView11 = null;
            }
            CharSequence text4 = textView11.getText();
            Intrinsics.checkNotNullExpressionValue(text4, "textView.text");
            isBlank = StringsKt__StringsJVMKt.isBlank(text4);
            Boolean valueOf = Boolean.valueOf(!isBlank);
            textView10.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, textView10)) == null) {
                textView10.setVisibility(8);
            }
            if (data.getFeedContentType() == 1) {
                TextView textView12 = this.textView;
                if (textView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                    textView12 = null;
                }
                textView12.setMaxLines(7);
                if (Build.VERSION.SDK_INT > 28) {
                    TextView textView13 = this.textView;
                    if (textView13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("textView");
                    } else {
                        textView2 = textView13;
                    }
                    textView2.setLineHeight(QQGuildUIUtil.f(23.0f));
                    return;
                }
                return;
            }
            TextView textView14 = this.textView;
            if (textView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView14 = null;
            }
            textView14.setMaxLines(2);
            if (Build.VERSION.SDK_INT > 28) {
                TextView textView15 = this.textView;
                if (textView15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                } else {
                    textView2 = textView15;
                }
                textView2.setLineHeight(QQGuildUIUtil.f(21.0f));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
