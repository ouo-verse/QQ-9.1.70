package com.tencent.mobileqq.search.searchdetail.content.template;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.search.searchdetail.util.SearchPicLoader;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/TemplateHotTopicSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/f;", "", "g0", "j0", "", "position", "i0", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", CacheTable.TABLE_NAME, "itemPosition", "textType", "", "topicName", "k0", "c0", "Landroid/view/View;", "containerView", "y", "", "getViewStubLayoutId", "data", "", "", "payload", "e0", "Lhp2/o;", "D", "Lhp2/o;", "getBinding", "()Lhp2/o;", "setBinding", "(Lhp2/o;)V", "binding", "<init>", "()V", "E", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TemplateHotTopicSection extends BaseSearchTemplateSection<com.tencent.mobileqq.search.searchdetail.content.template.model.f> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private hp2.o binding;

    private final void c0() {
        TextView textView;
        hp2.o oVar = this.binding;
        if (oVar != null && (textView = oVar.f405706e) != null) {
            textView.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.w
                @Override // java.lang.Runnable
                public final void run() {
                    TemplateHotTopicSection.d0(TemplateHotTopicSection.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d0(TemplateHotTopicSection this$0) {
        TextView textView;
        boolean z16;
        int a16;
        hp2.o oVar;
        TextView textView2;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hp2.o oVar2 = this$0.binding;
        if (oVar2 != null && (textView = oVar2.f405706e) != null) {
            String title = ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this$0.mData).getHotTopic().title;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            boolean z18 = false;
            int i3 = 1;
            if (title.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Layout layout = textView.getLayout();
                if (layout != null && layout.getLineCount() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    a16 = ViewUtils.f352270a.a(12.5f);
                    ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = a16;
                    layoutParams2.goneTopMargin = a16;
                    textView.setLayoutParams(layoutParams2);
                    if (title.length() > 0) {
                        z18 = true;
                    }
                    if (!z18) {
                        i3 = 2;
                    }
                    oVar = this$0.binding;
                    if (oVar == null) {
                        textView2 = oVar.f405706e;
                    } else {
                        textView2 = null;
                    }
                    if (textView2 == null) {
                        textView2.setMaxLines(i3);
                        return;
                    }
                    return;
                }
            }
            a16 = ViewUtils.f352270a.a(10.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = a16;
            layoutParams2.goneTopMargin = a16;
            textView.setLayoutParams(layoutParams2);
            if (title.length() > 0) {
            }
            if (!z18) {
            }
            oVar = this$0.binding;
            if (oVar == null) {
            }
            if (textView2 == null) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0() {
        ImageView imageView;
        ImageView imageView2;
        boolean z16;
        int i3;
        String iconUri = ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getHotTopic().avatar.iconLink;
        hp2.o oVar = this.binding;
        if (oVar != null) {
            imageView = oVar.f405704c;
        } else {
            imageView = null;
        }
        boolean z17 = true;
        if (imageView != null) {
            Intrinsics.checkNotNullExpressionValue(iconUri, "iconUri");
            if (iconUri.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        Intrinsics.checkNotNullExpressionValue(iconUri, "iconUri");
        if (iconUri.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            Option url = Option.obtain().setUrl(iconUri);
            hp2.o oVar2 = this.binding;
            if (oVar2 != null) {
                imageView2 = oVar2.f405704c;
            } else {
                imageView2 = null;
            }
            Option option = url.setTargetView(imageView2);
            SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            searchPicLoader.e(option, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i0(final int position) {
        String str;
        TextView textView;
        final SearchReportInfo searchReportInfo;
        hp2.o oVar;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        boolean z16;
        String title = ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getHotTopic().title;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
            str = "";
        }
        ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getContentRichText().f(str);
        hp2.o oVar2 = this.binding;
        TextView textView5 = null;
        if (oVar2 != null) {
            textView = oVar2.f405707f;
        } else {
            textView = null;
        }
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(title, "title");
            int i3 = 0;
            if (title.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
        hp2.o oVar3 = this.binding;
        if (oVar3 != null) {
            textView5 = oVar3.f405707f;
        }
        if (textView5 != null) {
            textView5.setText(title);
        }
        hp2.o oVar4 = this.binding;
        if (oVar4 != null && (textView4 = oVar4.f405706e) != null) {
            com.tencent.mobileqq.search.searchdetail.multimedia.q contentRichText = ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getContentRichText();
            Context context = textView4.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            rn2.j.f431768a.s(textView4, contentRichText.g(context, new Function1<SearchText, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateHotTopicSection$initContent$1$txt$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SearchText searchText) {
                    invoke2(searchText);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SearchText searchText) {
                    Intrinsics.checkNotNullParameter(searchText, "searchText");
                    SearchJump searchJump = searchText.jumpLink;
                    SearchReportInfo report = searchText.reportInfo;
                    String str2 = searchText.text;
                    g.a.a(TemplateHotTopicSection.this, searchJump, null, 2, null);
                    TemplateHotTopicSection templateHotTopicSection = TemplateHotTopicSection.this;
                    Intrinsics.checkNotNullExpressionValue(report, "report");
                    templateHotTopicSection.k0(report, position, 1, str2);
                }
            }));
        }
        hp2.o oVar5 = this.binding;
        if (oVar5 != null && (textView3 = oVar5.f405706e) != null) {
            rn2.j.u(rn2.j.f431768a, textView3, "TemplateHotTopicSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateHotTopicSection$initContent$2
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
                    Object obj;
                    Object obj2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    TemplateHotTopicSection templateHotTopicSection = TemplateHotTopicSection.this;
                    obj = ((Section) templateHotTopicSection).mData;
                    SearchJump jumpLink = ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) obj).getJumpLink();
                    obj2 = ((Section) TemplateHotTopicSection.this).mData;
                    templateHotTopicSection.d(jumpLink, ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) obj2).q());
                }
            }, 2, null);
        }
        c0();
        com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getReportInfoWrapper();
        if (reportInfoWrapper != null && (searchReportInfo = reportInfoWrapper.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String()) != null && (oVar = this.binding) != null && (textView2 = oVar.f405706e) != null) {
            V(textView2, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateHotTopicSection$initContent$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final JSONObject invoke() {
                    JSONObject O;
                    JSONObject Q;
                    TemplateHotTopicSection templateHotTopicSection = TemplateHotTopicSection.this;
                    SearchReportInfo searchReportInfo2 = searchReportInfo;
                    O = templateHotTopicSection.O(position);
                    JSONObject A = TemplateHotTopicSection.this.A();
                    if (A == null) {
                        A = new JSONObject();
                    }
                    A.put("text_type", 0);
                    Unit unit = Unit.INSTANCE;
                    Q = templateHotTopicSection.Q(searchReportInfo2, O, A);
                    return Q;
                }
            }, String.valueOf(searchReportInfo.hashCode()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j0() {
        ImageView imageView;
        View view;
        ImageView imageView2;
        ImageView imageView3;
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i16;
        boolean z16;
        boolean z17;
        boolean z18;
        int i17;
        String thumbnailUri = ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getHotTopic().feedImg.iconLink;
        hp2.o oVar = this.binding;
        if (oVar != null) {
            imageView = oVar.f405705d;
        } else {
            imageView = null;
        }
        int i18 = 8;
        boolean z19 = true;
        if (imageView != null) {
            Intrinsics.checkNotNullExpressionValue(thumbnailUri, "thumbnailUri");
            if (thumbnailUri.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            imageView.setVisibility(i17);
        }
        hp2.o oVar2 = this.binding;
        if (oVar2 != null) {
            view = oVar2.f405703b;
        } else {
            view = null;
        }
        if (view != null) {
            if (((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getHotTopic().isMulImg) {
                Intrinsics.checkNotNullExpressionValue(thumbnailUri, "thumbnailUri");
                if (thumbnailUri.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16) {
                        i18 = 0;
                    }
                    view.setVisibility(i18);
                }
            }
            z16 = false;
            if (z16) {
            }
            view.setVisibility(i18);
        }
        hp2.o oVar3 = this.binding;
        if (oVar3 != null) {
            imageView2 = oVar3.f405705d;
        } else {
            imageView2 = null;
        }
        if (imageView2 != null) {
            if (((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getHotTopic().isMulImg) {
                i3 = ViewUtils.f352270a.a(3.0f);
            } else {
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
                int i19 = -2;
                if (layoutParams2 != null) {
                    i16 = layoutParams2.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
                if (layoutParams3 != null) {
                    i19 = layoutParams3.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i19);
            }
            if (i3 != marginLayoutParams.rightMargin) {
                marginLayoutParams.rightMargin = i3;
                imageView2.setLayoutParams(marginLayoutParams);
            }
        }
        Intrinsics.checkNotNullExpressionValue(thumbnailUri, "thumbnailUri");
        if (thumbnailUri.length() <= 0) {
            z19 = false;
        }
        if (z19) {
            Option url = Option.obtain().setUrl(thumbnailUri);
            hp2.o oVar4 = this.binding;
            if (oVar4 != null) {
                imageView3 = oVar4.f405705d;
            } else {
                imageView3 = null;
            }
            Option option = url.setTargetView(imageView3);
            SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            searchPicLoader.e(option, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void k0(SearchReportInfo reportInfo, int itemPosition, int textType, String topicName) {
        boolean z16;
        TextView textView;
        String str = reportInfo.eid;
        Intrinsics.checkNotNullExpressionValue(str, "reportInfo.eid");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            JSONObject T = T(itemPosition);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("doc_position", String.valueOf(((com.tencent.mobileqq.search.searchdetail.content.template.model.f) this.mData).getDocPosition()));
            jSONObject.put("text_type", textType);
            if (topicName != null) {
                jSONObject.put("topic_name", topicName);
            }
            Unit unit = Unit.INSTANCE;
            JSONObject Q = Q(reportInfo, T, jSONObject);
            Iterator keys = Q.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "reportJson.keys()");
            while (keys.hasNext()) {
                String k3 = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(k3, "k");
                Object obj = Q.get(k3);
                Intrinsics.checkNotNullExpressionValue(obj, "reportJson.get(k)");
                linkedHashMap.put(k3, obj);
            }
            String str2 = reportInfo.eid;
            Intrinsics.checkNotNullExpressionValue(str2, "reportInfo.eid");
            linkedHashMap.put("eid", str2);
            hp2.o oVar = this.binding;
            if (oVar != null) {
                textView = oVar.f405706e;
            } else {
                textView = null;
            }
            VideoReport.reportEvent("clck", textView, linkedHashMap);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull com.tencent.mobileqq.search.searchdetail.content.template.model.f data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        g0();
        i0(position);
        j0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        View grayPlaceHolder;
        ImageView ivThumbnail;
        ImageView ivAvatar;
        if (containerView != null) {
            hp2.o e16 = hp2.o.e(containerView);
            this.binding = e16;
            if (e16 != null && (ivAvatar = e16.f405704c) != null) {
                Intrinsics.checkNotNullExpressionValue(ivAvatar, "ivAvatar");
                com.tencent.mobileqq.widget.listitem.ab.d(ivAvatar, ViewUtils.f352270a.a(10.0f));
            }
            hp2.o oVar = this.binding;
            if (oVar != null && (ivThumbnail = oVar.f405705d) != null) {
                Intrinsics.checkNotNullExpressionValue(ivThumbnail, "ivThumbnail");
                com.tencent.mobileqq.widget.listitem.ab.d(ivThumbnail, ViewUtils.f352270a.a(2.0f));
            }
            hp2.o oVar2 = this.binding;
            if (oVar2 != null && (grayPlaceHolder = oVar2.f405703b) != null) {
                Intrinsics.checkNotNullExpressionValue(grayPlaceHolder, "grayPlaceHolder");
                com.tencent.mobileqq.widget.listitem.ab.d(grayPlaceHolder, ViewUtils.f352270a.a(2.0f));
            }
        }
    }
}
