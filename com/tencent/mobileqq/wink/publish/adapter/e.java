package com.tencent.mobileqq.wink.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qzone.model.LabelInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u00126\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000b\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006RG\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n \u0016*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/adapter/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "index", "Lcooperation/qzone/model/LabelInfo;", "labelInfo", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "tagInfo", "E", "Lkotlin/jvm/functions/Function2;", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "onItemClick", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "tagText", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "tagIcon", "itemView", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function2<Integer, LabelInfo, Unit> onItemClick;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView tagText;

    /* renamed from: G, reason: from kotlin metadata */
    private final ImageView tagIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull View itemView, @NotNull Function2<? super Integer, ? super LabelInfo, Unit> onItemClick) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
        this.tagText = (TextView) itemView.findViewById(R.id.jb7);
        this.tagIcon = (ImageView) itemView.findViewById(R.id.f922257a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(LabelInfo labelInfo, e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(labelInfo, "$labelInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("publish_rec_tag_click_" + labelInfo.f390867id)) {
            this$0.onItemClick.invoke(Integer.valueOf(this$0.getLayoutPosition()), labelInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o(View view, int index, LabelInfo labelInfo) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_OUTSIDE_TOPIC_ITEM);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Integer valueOf = Integer.valueOf(index);
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_topic_index", valueOf);
        buildElementParams.put("xsj_topic_id", labelInfo.f390867id);
        buildElementParams.put("xsj_topic_name", labelInfo.name);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TOPIC_RECOMMEND_REASON, Integer.valueOf(labelInfo.type));
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementReuseIdentifier(view, labelInfo.name);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(@NotNull final LabelInfo labelInfo) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(labelInfo, "labelInfo");
        this.tagText.setText(labelInfo.name);
        String str = labelInfo.iconUrl;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    this.tagIcon.setVisibility(8);
                } else {
                    this.tagIcon.setVisibility(0);
                    Option obtain = Option.obtain();
                    obtain.setUrl(str);
                    obtain.setRequestWidth(ViewUtils.dpToPx(18.0f));
                    obtain.setRequestHeight(ViewUtils.dpToPx(18.0f));
                    obtain.setTargetView(this.tagIcon);
                    QCircleFeedPicLoader.g().loadImage(obtain);
                }
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.adapter.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        e.n(LabelInfo.this, this, view);
                    }
                });
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                o(itemView, getLayoutPosition() + 1, labelInfo);
            }
        }
        z16 = true;
        if (!z16) {
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.n(LabelInfo.this, this, view);
            }
        });
        View itemView2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        o(itemView2, getLayoutPosition() + 1, labelInfo);
    }
}
