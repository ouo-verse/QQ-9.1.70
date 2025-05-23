package com.tencent.mobileqq.search.searchdetail.content.template;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNoResultItem;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchEmptyPageExtraInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchNoResultCard;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import hp2.ai;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J(\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/y;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/p;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNoResultCard;", "Landroid/content/Context;", "context", "Landroid/text/SpannableString;", "a0", "ctx", "", "url", "", "Z", "Landroid/view/View;", "containerView", "y", "", "getViewStubLayoutId", "data", "", "position", "", "", "payload", "Y", "Lhp2/ai;", "D", "Lhp2/ai;", "binding", "<init>", "()V", "E", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class y extends BaseSearchTemplateSection<NetSearchTemplateNoResultItem> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ai binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/template/y$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f284258d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ y f284259e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f284260f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ SearchNoResultCard f284261h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f284262i;

        b(String str, y yVar, Context context, SearchNoResultCard searchNoResultCard, int i3) {
            this.f284258d = str;
            this.f284259e = yVar;
            this.f284260f = context;
            this.f284261h = searchNoResultCard;
            this.f284262i = i3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            boolean z16;
            Intrinsics.checkNotNullParameter(widget, "widget");
            String jumpLinkStr = this.f284258d;
            Intrinsics.checkNotNullExpressionValue(jumpLinkStr, "jumpLinkStr");
            if (jumpLinkStr.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                y yVar = this.f284259e;
                Context context = this.f284260f;
                String jumpLinkStr2 = this.f284258d;
                Intrinsics.checkNotNullExpressionValue(jumpLinkStr2, "jumpLinkStr");
                yVar.Z(context, jumpLinkStr2);
                return;
            }
            Activity activity = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            com.tencent.mobileqq.search.searchdetail.content.view.f fVar = new com.tencent.mobileqq.search.searchdetail.content.view.f(activity);
            SearchEmptyPageExtraInfo emptyPageInfo = this.f284261h.getEmptyPageInfo();
            Intrinsics.checkNotNullExpressionValue(emptyPageInfo, "getEmptyPageInfo()");
            fVar.S(emptyPageInfo);
            fVar.show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setColor(this.f284262i);
            ds5.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(Context ctx, String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
            if (!startsWith$default2) {
                ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(ctx, url);
                Logger.f235387a.d().i("TemplateNoResultCardSection", 1, "jumpPage url=" + url);
            }
        }
        ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).jumpTo(ctx, url, null);
        Logger.f235387a.d().i("TemplateNoResultCardSection", 1, "jumpPage url=" + url);
    }

    private final SpannableString a0(SearchNoResultCard searchNoResultCard, Context context) {
        int indexOf$default;
        SpannableString spannableString = new SpannableString(searchNoResultCard.content.getText());
        int color = context.getColor(R.color.qui_common_text_link);
        ArrayList<SearchText> highlightTextList = searchNoResultCard.richText.getHighlightTextList();
        Intrinsics.checkNotNullExpressionValue(highlightTextList, "richText.getHighlightTextList()");
        for (SearchText searchText : highlightTextList) {
            String str = searchText.text;
            String str2 = "highlight.text";
            Intrinsics.checkNotNullExpressionValue(str, "highlight.text");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableString, str, 0, true, 2, (Object) null);
            int i3 = indexOf$default;
            while (i3 >= 0) {
                int length = i3 + searchText.text.length();
                SearchJump jumpLink = searchText.getJumpLink();
                String jumpAndLink = jumpLink.getJumpAndLink();
                if (jumpAndLink == null) {
                    jumpAndLink = jumpLink.getJumpLink();
                }
                String str3 = str2;
                SearchText searchText2 = searchText;
                spannableString.setSpan(new b(jumpAndLink, this, context, searchNoResultCard, color), i3, length, 33);
                String str4 = searchText2.text;
                Intrinsics.checkNotNullExpressionValue(str4, str3);
                i3 = StringsKt__StringsKt.indexOf((CharSequence) spannableString, str4, length, true);
                str2 = str3;
                searchText = searchText2;
            }
        }
        return spannableString;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull NetSearchTemplateNoResultItem data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("TemplateNoResultCardSection", "doOnBindData position=" + position + " data=" + data.hashCode());
        }
        ai aiVar = this.binding;
        if (aiVar == null) {
            return;
        }
        SearchNoResultCard noResultCard = data.getNoResultCard();
        Context context = aiVar.f405589b.getContext();
        TextView textView = aiVar.f405590c;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(a0(noResultCard, context));
        aiVar.f405590c.setMovementMethod(LinkMovementMethod.getInstance());
        if (!noResultCard.getShowBackground()) {
            aiVar.f405589b.setBackground(new ColorDrawable(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        if (containerView != null) {
            this.binding = ai.e(containerView);
        }
    }
}
