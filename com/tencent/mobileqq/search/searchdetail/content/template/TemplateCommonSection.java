package com.tencent.mobileqq.search.searchdetail.content.template;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.model.SearchBarLabel;
import com.tencent.mobileqq.search.searchdetail.content.model.TagText;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchVerticalDetailTemplateItem;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchLabelLayout;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchShowHighlightTextView;
import com.tencent.mobileqq.search.searchdetail.util.QSearchDetailAvatarUtil;
import com.tencent.mobileqq.search.searchdetail.util.SearchPicLoader;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010!R\u0018\u0010.\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/TemplateCommonSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/t;", "", "c0", "", "position", "g0", "i0", "e0", "index", "a0", "Landroid/view/View;", "containerView", "y", "", "getViewStubLayoutId", "data", "", "", "payload", "b0", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "ivAvatar", "E", "ivLittleIcon", UserInfo.SEX_FEMALE, "Landroid/view/View;", "topDivider", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "tvRightButton", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchShowHighlightTextView;", "H", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchShowHighlightTextView;", "titleArea", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchLabelLayout;", "I", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchLabelLayout;", "labelArea", "J", "tvDesc", "K", "bottomArea", "Landroidx/constraintlayout/widget/Barrier;", "L", "Landroidx/constraintlayout/widget/Barrier;", "barrierContentBottom", "M", "barrierContentBottomExpectBarArea", "Landroid/widget/LinearLayout;", "N", "Landroid/widget/LinearLayout;", "barArea", "<init>", "()V", "P", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TemplateCommonSection extends BaseSearchTemplateSection<NetSearchVerticalDetailTemplateItem> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView ivAvatar;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView ivLittleIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View topDivider;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView tvRightButton;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QSearchShowHighlightTextView titleArea;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QSearchLabelLayout labelArea;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView tvDesc;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QSearchLabelLayout bottomArea;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Barrier barrierContentBottom;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Barrier barrierContentBottomExpectBarArea;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private LinearLayout barArea;

    private final void a0(int index) {
        LinearLayout linearLayout = this.barArea;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (index > 0) {
                layoutParams.topMargin = ViewUtils.f352270a.a(8.0f);
            }
            TextView textView = new TextView(linearLayout2.getContext());
            textView.setId(R.id.text1);
            textView.setTextSize(1, 9.0f);
            ViewUtils viewUtils = ViewUtils.f352270a;
            textView.setPadding(viewUtils.a(3.5f), viewUtils.a(0.5f), viewUtils.a(3.5f), viewUtils.a(0.5f));
            textView.setTextColor(linearLayout2.getContext().getColor(R.color.qui_common_text_white));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = viewUtils.a(4.0f);
            linearLayout2.addView(textView, layoutParams2);
            TextView textView2 = new TextView(linearLayout2.getContext());
            textView2.setId(R.id.content);
            textView2.setTextColor(linearLayout2.getContext().getColor(R.color.qui_common_text_primary));
            textView2.setTextSize(1, 12.0f);
            textView2.setMaxLines(1);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setPadding(0, viewUtils.a(1.5f), 0, viewUtils.a(1.5f));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 16;
            layoutParams3.weight = 1.0f;
            linearLayout2.addView(textView2, layoutParams3);
            linearLayout.addView(linearLayout2, layoutParams);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c0() {
        boolean z16;
        boolean z17;
        ImageView imageView;
        String littleIcon;
        ImageView imageView2;
        boolean z18;
        boolean z19;
        ViewUtils viewUtils;
        float f16;
        int i3;
        boolean z26;
        String avatar = ((NetSearchVerticalDetailTemplateItem) this.mData).getAvatar();
        final String uin = ((NetSearchVerticalDetailTemplateItem) this.mData).getUin();
        int avatarType = ((NetSearchVerticalDetailTemplateItem) this.mData).getAvatarType();
        final int uinType = ((NetSearchVerticalDetailTemplateItem) this.mData).getUinType();
        boolean z27 = true;
        if (avatar.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (uin.length() > 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (!z26) {
                z17 = false;
                imageView = this.ivAvatar;
                int i16 = 8;
                if (imageView != null) {
                    if (z17) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    imageView.setVisibility(i3);
                }
                if (z17) {
                    ImageView imageView3 = this.ivAvatar;
                    if (imageView3 != null) {
                        if (avatarType == 2) {
                            viewUtils = ViewUtils.f352270a;
                            f16 = 4.0f;
                        } else {
                            viewUtils = ViewUtils.f352270a;
                            f16 = 26.0f;
                        }
                        com.tencent.mobileqq.widget.listitem.ab.d(imageView3, viewUtils.a(f16));
                    }
                    if (avatar.length() > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        Option option = Option.obtain().setUrl(avatar).setTargetView(this.ivAvatar);
                        SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
                        Intrinsics.checkNotNullExpressionValue(option, "option");
                        searchPicLoader.e(option, null);
                    } else {
                        ImageView imageView4 = this.ivAvatar;
                        if (imageView4 != null) {
                            imageView4.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.g
                                @Override // java.lang.Runnable
                                public final void run() {
                                    TemplateCommonSection.d0(uinType, uin, this);
                                }
                            });
                        }
                    }
                }
                littleIcon = ((NetSearchVerticalDetailTemplateItem) this.mData).getVerticalDetail().littleIcon.iconLink;
                imageView2 = this.ivLittleIcon;
                if (imageView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(littleIcon, "littleIcon");
                    if (littleIcon.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        i16 = 0;
                    }
                    imageView2.setVisibility(i16);
                }
                Intrinsics.checkNotNullExpressionValue(littleIcon, "littleIcon");
                if (littleIcon.length() <= 0) {
                    z27 = false;
                }
                if (!z27) {
                    Option option2 = Option.obtain().setUrl(littleIcon).setTargetView(this.ivLittleIcon);
                    SearchPicLoader searchPicLoader2 = SearchPicLoader.f284726a;
                    Intrinsics.checkNotNullExpressionValue(option2, "option");
                    searchPicLoader2.e(option2, null);
                    return;
                }
                return;
            }
        }
        z17 = true;
        imageView = this.ivAvatar;
        int i162 = 8;
        if (imageView != null) {
        }
        if (z17) {
        }
        littleIcon = ((NetSearchVerticalDetailTemplateItem) this.mData).getVerticalDetail().littleIcon.iconLink;
        imageView2 = this.ivLittleIcon;
        if (imageView2 != null) {
        }
        Intrinsics.checkNotNullExpressionValue(littleIcon, "littleIcon");
        if (littleIcon.length() <= 0) {
        }
        if (!z27) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(int i3, String uin, TemplateCommonSection this$0) {
        boolean z16;
        Drawable d16;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            d16 = QSearchDetailAvatarUtil.f284719a.f(uin);
        } else {
            d16 = QSearchDetailAvatarUtil.f284719a.d(uin);
        }
        ImageView imageView = this$0.ivAvatar;
        if (imageView != null) {
            imageView.setImageDrawable(d16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e0(final int position) {
        String str;
        int i3;
        int i16;
        String str2;
        int i17;
        boolean z16;
        boolean z17;
        boolean z18;
        int color;
        LinearLayout linearLayout = this.barArea;
        if (linearLayout != null) {
            int size = ((NetSearchVerticalDetailTemplateItem) this.mData).B().size();
            Iterator<T> it = ((NetSearchVerticalDetailTemplateItem) this.mData).B().iterator();
            int i18 = 0;
            int i19 = 0;
            while (true) {
                int i26 = 8;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i27 = i19 + 1;
                if (i19 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                final SearchBarLabel searchBarLabel = (SearchBarLabel) next;
                if (i19 > linearLayout.getChildCount() - 1) {
                    a0(i19);
                }
                View childView = linearLayout.getChildAt(i19);
                if (childView.getVisibility() == 8) {
                    childView.setVisibility(i18);
                }
                TextView tagTextView = (TextView) childView.findViewById(R.id.text1);
                Intrinsics.checkNotNullExpressionValue(tagTextView, "tagTextView");
                TagText tagText = searchBarLabel.getTagText();
                String str3 = null;
                if (tagText != null) {
                    str = tagText.getText();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    i3 = i18;
                } else {
                    i3 = 1;
                }
                if ((i3 ^ 1) != 0) {
                    i16 = i18;
                } else {
                    i16 = 8;
                }
                tagTextView.setVisibility(i16);
                TagText tagText2 = searchBarLabel.getTagText();
                if (tagText2 != null) {
                    str2 = tagText2.getText();
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    i17 = i18;
                } else {
                    i17 = 1;
                }
                if (i17 == 0) {
                    TagText tagText3 = searchBarLabel.getTagText();
                    if (tagText3 != null) {
                        str3 = tagText3.getText();
                    }
                    tagTextView.setText(str3);
                    rn2.j jVar = rn2.j.f431768a;
                    ViewUtils viewUtils = ViewUtils.f352270a;
                    float a16 = viewUtils.a(2.5f);
                    float a17 = viewUtils.a(2.5f);
                    float a18 = viewUtils.a(2.5f);
                    float a19 = viewUtils.a(2.5f);
                    TagText tagText4 = searchBarLabel.getTagText();
                    if (tagText4 != null) {
                        color = tagText4.getBgColor();
                    } else {
                        color = linearLayout.getContext().getColor(R.color.qui_common_feedback_success);
                    }
                    tagTextView.setBackground(jVar.g(a16, a17, a18, a19, color));
                }
                TextView contentTextView = (TextView) childView.findViewById(R.id.content);
                Intrinsics.checkNotNullExpressionValue(contentTextView, "contentTextView");
                if (searchBarLabel.getText().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i26 = 0;
                }
                contentTextView.setVisibility(i26);
                if (searchBarLabel.getText().length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    contentTextView.setText(searchBarLabel.getText());
                }
                if (searchBarLabel.getClickJump() != null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                childView.setClickable(z18);
                if (QSearchDetailUtilKt.i(searchBarLabel.getClickJump())) {
                    rn2.j jVar2 = rn2.j.f431768a;
                    Intrinsics.checkNotNullExpressionValue(childView, "childView");
                    rn2.j.u(jVar2, childView, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initBarArea$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View v3) {
                            Intrinsics.checkNotNullParameter(v3, "v");
                            BaseSearchTemplateSection.w(TemplateCommonSection.this, searchBarLabel.getClickJump(), new com.tencent.mobileqq.search.searchdetail.content.model.g(searchBarLabel.getReportInfo()), null, 4, null);
                        }
                    }, 3, null);
                } else {
                    rn2.j jVar3 = rn2.j.f431768a;
                    Intrinsics.checkNotNullExpressionValue(childView, "childView");
                    rn2.j.u(jVar3, childView, "QQSearch.NetDetail.TemplateCommonSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initBarArea$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it5) {
                            Object obj;
                            Object obj2;
                            Intrinsics.checkNotNullParameter(it5, "it");
                            TemplateCommonSection templateCommonSection = TemplateCommonSection.this;
                            obj = ((Section) templateCommonSection).mData;
                            SearchJump jumpLink = ((NetSearchVerticalDetailTemplateItem) obj).getJumpLink();
                            obj2 = ((Section) TemplateCommonSection.this).mData;
                            templateCommonSection.d(jumpLink, ((NetSearchVerticalDetailTemplateItem) obj2).q());
                        }
                    }, 2, null);
                }
                final SearchReportInfo reportInfo = searchBarLabel.getReportInfo();
                if (reportInfo != null) {
                    V(childView, reportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initBarArea$1$1$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final JSONObject invoke() {
                            TemplateCommonSection templateCommonSection = TemplateCommonSection.this;
                            return BaseSearchTemplateSection.S(templateCommonSection, reportInfo, templateCommonSection.T(position), null, 2, null);
                        }
                    }, String.valueOf(reportInfo.hashCode()));
                }
                i19 = i27;
                i18 = 0;
            }
            if (linearLayout.getChildCount() > size) {
                int childCount = linearLayout.getChildCount();
                while (size < childCount) {
                    linearLayout.getChildAt(size).setVisibility(8);
                    size++;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0(final int position) {
        String str;
        Object obj;
        int i3;
        String str2;
        TextView textView;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
            str = "";
        }
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc2 = getDtReportIoc();
        if (dtReportIoc2 != null) {
            obj = Long.valueOf(dtReportIoc2.getTabMask());
        } else {
            obj = 1;
        }
        final com.tencent.mobileqq.search.searchdetail.content.template.model.k buttonInfo = ((NetSearchVerticalDetailTemplateItem) this.mData).getButtonInfo();
        if (buttonInfo != null) {
            if (buttonInfo.getButtonType() != 2 && buttonInfo.getButtonType() != 3) {
                TextView textView2 = this.tvRightButton;
                if (textView2 != null) {
                    rn2.j.u(rn2.j.f431768a, textView2, "QQSearch.NetDetail.TemplateCommonSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initRightButton$1$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            TemplateCommonSection.this.u(buttonInfo);
                        }
                    }, 2, null);
                }
            } else {
                int buttonType = buttonInfo.getButtonType();
                if (buttonType != 2) {
                    if (buttonType == 3) {
                        if (buttonInfo.getJoinGuildStatus() != 0) {
                            TextView textView3 = this.tvRightButton;
                            if (textView3 != null) {
                                rn2.j.u(rn2.j.f431768a, textView3, "QQSearch.NetDetail.TemplateCommonSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initRightButton$1$3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                        invoke2(view);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull View it) {
                                        Object obj2;
                                        Object obj3;
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        TemplateCommonSection templateCommonSection = TemplateCommonSection.this;
                                        obj2 = ((Section) templateCommonSection).mData;
                                        SearchJump jumpLink = ((NetSearchVerticalDetailTemplateItem) obj2).getJumpLink();
                                        obj3 = ((Section) TemplateCommonSection.this).mData;
                                        templateCommonSection.d(jumpLink, ((NetSearchVerticalDetailTemplateItem) obj3).q());
                                    }
                                }, 2, null);
                            }
                        } else {
                            boolean areEqual = Intrinsics.areEqual(obj, (Object) 3L);
                            boolean b16 = NetSearchVerticalDetailTemplateItem.INSTANCE.b(str);
                            if (areEqual) {
                                if (b16) {
                                    str2 = "qq_network_search_channel_sub_tab_searchid";
                                } else {
                                    str2 = "qq_network_search_channel_sub_tab_keyword";
                                }
                            } else if (b16) {
                                str2 = "qq_network_search_channel_all_tab_searchid";
                            } else {
                                str2 = "qq_network_search_channel_all_tab_keyword";
                            }
                            buttonInfo.e().put("subSource", str2);
                            TextView textView4 = this.tvRightButton;
                            if (textView4 != null) {
                                rn2.j.u(rn2.j.f431768a, textView4, "QQSearch.NetDetail.TemplateCommonSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initRightButton$1$4
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                        invoke2(view);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull View it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        TemplateCommonSection.this.u(buttonInfo);
                                    }
                                }, 2, null);
                            }
                        }
                    }
                } else if (buttonInfo.getJoinGroupStatus() != 1) {
                    TextView textView5 = this.tvRightButton;
                    if (textView5 != null) {
                        rn2.j.u(rn2.j.f431768a, textView5, "QQSearch.NetDetail.TemplateCommonSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initRightButton$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull View it) {
                                Object obj2;
                                Object obj3;
                                Intrinsics.checkNotNullParameter(it, "it");
                                TemplateCommonSection templateCommonSection = TemplateCommonSection.this;
                                obj2 = ((Section) templateCommonSection).mData;
                                SearchJump jumpLink = ((NetSearchVerticalDetailTemplateItem) obj2).getJumpLink();
                                obj3 = ((Section) TemplateCommonSection.this).mData;
                                templateCommonSection.d(jumpLink, ((NetSearchVerticalDetailTemplateItem) obj3).q());
                            }
                        }, 2, null);
                    }
                } else {
                    boolean isGroupCodeSearch = ((NetSearchVerticalDetailTemplateItem) this.mData).getIsGroupCodeSearch();
                    boolean areEqual2 = Intrinsics.areEqual(obj, (Object) 6L);
                    if (isGroupCodeSearch) {
                        if (areEqual2) {
                            i3 = 1020;
                        } else {
                            i3 = 1019;
                        }
                    } else if (areEqual2) {
                        i3 = 1022;
                    } else {
                        i3 = 1021;
                    }
                    buttonInfo.e().put("subSourceId", String.valueOf(i3));
                    TextView textView6 = this.tvRightButton;
                    if (textView6 != null) {
                        rn2.j.u(rn2.j.f431768a, textView6, "QQSearch.NetDetail.TemplateCommonSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initRightButton$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull View it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                TemplateCommonSection.this.u(buttonInfo);
                            }
                        }, 2, null);
                    }
                }
            }
            TextView textView7 = this.tvRightButton;
            if (textView7 != null) {
                textView7.setText(buttonInfo.getText());
            }
            f.a(buttonInfo.getStatus(), this.tvRightButton);
            final SearchReportInfo reportInfo = buttonInfo.getReportInfo();
            if (reportInfo != null && (textView = this.tvRightButton) != null) {
                V(textView, reportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateCommonSection$initRightButton$1$6$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JSONObject invoke() {
                        TemplateCommonSection templateCommonSection = TemplateCommonSection.this;
                        return BaseSearchTemplateSection.S(templateCommonSection, reportInfo, templateCommonSection.T(position), null, 2, null);
                    }
                }, String.valueOf(reportInfo.hashCode()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i0() {
        if (!((NetSearchVerticalDetailTemplateItem) this.mData).G().isEmpty()) {
            View containerView = getContainerView();
            if (containerView != null) {
                LinearLayout linearLayout = new LinearLayout(containerView.getContext());
                int i3 = 0;
                linearLayout.setOrientation(0);
                for (Object obj : ((NetSearchVerticalDetailTemplateItem) this.mData).G()) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    String str = (String) obj;
                    ImageView imageView = new ImageView(containerView.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewUtils viewUtils = ViewUtils.f352270a;
                    int a16 = viewUtils.a(14.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a16, a16);
                    if (i3 > 0) {
                        layoutParams.setMarginStart(viewUtils.a(2.0f));
                    }
                    linearLayout.addView(imageView, layoutParams);
                    rn2.j.f431768a.n(imageView, str, a16);
                    i3 = i16;
                }
                QSearchShowHighlightTextView qSearchShowHighlightTextView = this.titleArea;
                if (qSearchShowHighlightTextView != null) {
                    QSearchShowHighlightTextView.b(qSearchShowHighlightTextView, linearLayout, null, 2, null);
                    return;
                }
                return;
            }
            return;
        }
        QSearchShowHighlightTextView qSearchShowHighlightTextView2 = this.titleArea;
        if (qSearchShowHighlightTextView2 != null) {
            qSearchShowHighlightTextView2.h();
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull NetSearchVerticalDetailTemplateItem data, int position, @Nullable List<Object> payload) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        int i16;
        TextView textView;
        boolean z19;
        int i17;
        int i18;
        QSearchShowHighlightTextView qSearchShowHighlightTextView;
        int i19;
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
            str = "";
        }
        View view = this.topDivider;
        int i26 = 8;
        if (view != null) {
            if (data.getLayoutInfo().showDivider) {
                i19 = 0;
            } else {
                i19 = 8;
            }
            view.setVisibility(i19);
        }
        c0();
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (qSearchShowHighlightTextView = this.titleArea) != null) {
            qSearchShowHighlightTextView.setHighlightText(str);
        }
        QSearchShowHighlightTextView qSearchShowHighlightTextView2 = this.titleArea;
        if (qSearchShowHighlightTextView2 != null) {
            String str2 = data.getVerticalDetail().title.text;
            Intrinsics.checkNotNullExpressionValue(str2, "data.verticalDetail.title.text");
            qSearchShowHighlightTextView2.setText(str2);
        }
        i0();
        QSearchLabelLayout qSearchLabelLayout = this.labelArea;
        if (qSearchLabelLayout != null) {
            if (!data.H().isEmpty()) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            qSearchLabelLayout.setVisibility(i18);
        }
        JSONObject T = T(position);
        if (!data.H().isEmpty()) {
            QSearchLabelLayout qSearchLabelLayout2 = this.labelArea;
            if (qSearchLabelLayout2 != null) {
                qSearchLabelLayout2.setParentReportInfo(T);
            }
            QSearchLabelLayout qSearchLabelLayout3 = this.labelArea;
            if (qSearchLabelLayout3 != null) {
                qSearchLabelLayout3.d(data.H(), this);
            }
        }
        TextView textView2 = this.tvDesc;
        if (textView2 != null) {
            String str3 = data.getVerticalDetail().subTitle.text;
            Intrinsics.checkNotNullExpressionValue(str3, "data.verticalDetail.subTitle.text");
            if (str3.length() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            textView2.setVisibility(i17);
        }
        String str4 = data.getVerticalDetail().subTitle.text;
        Intrinsics.checkNotNullExpressionValue(str4, "data.verticalDetail.subTitle.text");
        if (str4.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && (textView = this.tvDesc) != null) {
            textView.setText(data.getShowDesc());
        }
        QSearchLabelLayout qSearchLabelLayout4 = this.bottomArea;
        if (qSearchLabelLayout4 != null) {
            if (!data.C().isEmpty()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            qSearchLabelLayout4.setVisibility(i16);
        }
        if (!data.C().isEmpty()) {
            QSearchLabelLayout qSearchLabelLayout5 = this.bottomArea;
            if (qSearchLabelLayout5 != null) {
                qSearchLabelLayout5.setParentReportInfo(T);
            }
            QSearchLabelLayout qSearchLabelLayout6 = this.bottomArea;
            if (qSearchLabelLayout6 != null) {
                qSearchLabelLayout6.d(data.C(), this);
            }
        }
        TextView textView3 = this.tvRightButton;
        if (textView3 != null) {
            if (data.getButtonInfo() != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView3.setVisibility(i3);
        }
        g0(position);
        LinearLayout linearLayout = this.barArea;
        if (linearLayout != null) {
            if (!data.B().isEmpty()) {
                i26 = 0;
            }
            linearLayout.setVisibility(i26);
        }
        if (!data.B().isEmpty()) {
            e0(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b9, code lost:
    
        if (r5 != true) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(@Nullable View containerView) {
        boolean z16;
        Barrier barrier;
        Barrier barrier2;
        int[] referencedIds;
        boolean z17;
        Barrier barrier3;
        int[] referencedIds2;
        boolean z18;
        if (containerView != null) {
            this.ivAvatar = (ImageView) containerView.findViewById(R.id.f165909du3);
            this.ivLittleIcon = (ImageView) containerView.findViewById(R.id.y5c);
            this.topDivider = containerView.findViewById(R.id.jta);
            this.tvRightButton = (TextView) containerView.findViewById(R.id.f110776jf);
            this.titleArea = (QSearchShowHighlightTextView) containerView.findViewById(R.id.jo7);
            this.labelArea = (QSearchLabelLayout) containerView.findViewById(R.id.ycc);
            this.tvDesc = (TextView) containerView.findViewById(R.id.f167042k73);
            this.bottomArea = (QSearchLabelLayout) containerView.findViewById(R.id.laf);
            this.barrierContentBottom = (Barrier) containerView.findViewById(R.id.t4r);
            this.barArea = (LinearLayout) containerView.findViewById(R.id.t4d);
            this.barrierContentBottomExpectBarArea = (Barrier) containerView.findViewById(R.id.t4s);
            Barrier barrier4 = this.barrierContentBottom;
            boolean z19 = true;
            if (barrier4 != null && (referencedIds2 = barrier4.getReferencedIds()) != null) {
                Intrinsics.checkNotNullExpressionValue(referencedIds2, "referencedIds");
                if (referencedIds2.length == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z16 = true;
                    if (z16 && (barrier3 = this.barrierContentBottom) != null) {
                        barrier3.setReferencedIds(new int[]{R.id.jo7, R.id.ycc, R.id.f167042k73, R.id.laf, R.id.f165909du3, R.id.t4d});
                    }
                    barrier = this.barrierContentBottomExpectBarArea;
                    if (barrier != null && (referencedIds = barrier.getReferencedIds()) != null) {
                        Intrinsics.checkNotNullExpressionValue(referencedIds, "referencedIds");
                        if (referencedIds.length != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                    }
                    z19 = false;
                    if (!z19 && (barrier2 = this.barrierContentBottomExpectBarArea) != null) {
                        barrier2.setReferencedIds(new int[]{R.id.jo7, R.id.ycc, R.id.f167042k73, R.id.laf, R.id.f165909du3});
                        return;
                    }
                }
            }
            z16 = false;
            if (z16) {
                barrier3.setReferencedIds(new int[]{R.id.jo7, R.id.ycc, R.id.f167042k73, R.id.laf, R.id.f165909du3, R.id.t4d});
            }
            barrier = this.barrierContentBottomExpectBarArea;
            if (barrier != null) {
                Intrinsics.checkNotNullExpressionValue(referencedIds, "referencedIds");
                if (referencedIds.length != 0) {
                }
            }
            z19 = false;
            if (!z19) {
            }
        }
    }
}
