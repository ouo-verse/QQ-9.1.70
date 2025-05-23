package com.tencent.biz.qqcircle.immersive.search.prompt.tag;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$PromptTagInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.widgets.CornerURLImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua0.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/tag/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "tagName", "", "p", "r", ReportConstant.COSTREPORT_PREFIX, "Lcirclesearch/CircleSearchExhibition$PromptTagInfo;", "tagInfo", "", "position", "o", "", "corners", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/widgets/CornerURLImageView;", "E", "Lcom/tencent/biz/qqcircle/widgets/CornerURLImageView;", "ivBg", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "tvTitle", "G", "tvDesc", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "I", "[F", "bgCornerRadiusArray", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private CornerURLImageView ivBg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView tvTitle;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView tvDesc;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayout container;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private float[] bgCornerRadiusArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.ivBg = (CornerURLImageView) itemView.findViewById(R.id.f53442ci);
        this.tvTitle = (TextView) itemView.findViewById(R.id.f53482cm);
        this.tvDesc = (TextView) itemView.findViewById(R.id.f53462ck);
        this.container = (LinearLayout) itemView.findViewById(R.id.f53452cj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(CircleSearchExhibition$PromptTagInfo tagInfo, d this$0, View view) {
        boolean isBlank;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tagInfo, "$tagInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String url = tagInfo.jump_url.get();
        Intrinsics.checkNotNullExpressionValue(url, "url");
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            String str = tagInfo.tag_name.get();
            Intrinsics.checkNotNullExpressionValue(str, "tagInfo.tag_name.get()");
            this$0.p(str);
        } else {
            QCircleSchemeLauncher.f(this$0.itemView.getContext(), url);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o(CircleSearchExhibition$PromptTagInfo tagInfo, int position) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(position));
        String str = tagInfo.tag_name.get();
        Intrinsics.checkNotNullExpressionValue(str, "tagInfo.tag_name.get()");
        hashMap.put("xsj_topic_name", str);
        i.k(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_EXPLORE_TOPIC_ENTRY, hashMap, tagInfo.hashCode());
    }

    private final void p(String tagName) {
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagName.set(tagName);
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        qCirclePolymerizationBean.setPolymerizationType(7);
        com.tencent.biz.qqcircle.launcher.c.j0(this.itemView.getContext(), qCirclePolymerizationBean);
    }

    private final void r() {
        if (this.bgCornerRadiusArray == null) {
            CornerURLImageView cornerURLImageView = this.ivBg;
            if (cornerURLImageView != null) {
                cornerURLImageView.setNeedRadius(false);
                return;
            }
            return;
        }
        CornerURLImageView cornerURLImageView2 = this.ivBg;
        if (cornerURLImageView2 != null) {
            cornerURLImageView2.setNeedRadius(true);
        }
        CornerURLImageView cornerURLImageView3 = this.ivBg;
        if (cornerURLImageView3 != null) {
            cornerURLImageView3.setRadius(this.bgCornerRadiusArray);
        }
    }

    private final void s() {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{this.itemView.getContext().getResources().getColor(R.color.cjx), this.itemView.getContext().getResources().getColor(R.color.cjt)});
            gradientDrawable.setCornerRadii(this.bgCornerRadiusArray);
            gradientDrawable.setGradientType(0);
            LinearLayout linearLayout = this.container;
            if (linearLayout != null) {
                linearLayout.setBackground(gradientDrawable);
            }
        } catch (Exception e16) {
            QLog.e("QFSSearchPromptTagViewHolder", 1, "[setupContainerCorner] ", e16);
        }
    }

    public final void m(@NotNull final CircleSearchExhibition$PromptTagInfo tagInfo, int position) {
        Intrinsics.checkNotNullParameter(tagInfo, "tagInfo");
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setText(tagInfo.tag_name.get());
        }
        TextView textView2 = this.tvDesc;
        if (textView2 != null) {
            textView2.setText(tagInfo.tag_dec.get());
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(tagInfo.tag_mid_back_img.get()).setTargetView(this.ivBg));
        r();
        s();
        o(tagInfo, position);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.tag.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.n(CircleSearchExhibition$PromptTagInfo.this, this, view);
            }
        });
    }

    public final void q(@Nullable float[] corners) {
        this.bgCornerRadiusArray = corners;
    }
}
