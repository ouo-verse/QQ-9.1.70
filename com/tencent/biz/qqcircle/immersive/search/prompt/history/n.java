package com.tencent.biz.qqcircle.immersive.search.prompt.history;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QFSSearchHistoryItemInfo;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/n;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/beans/QFSSearchHistoryItemInfo;", "info", "", "o", "", "position", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tvText", UserInfo.SEX_FEMALE, "tvLabel", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "ivDelete", "", "H", "Ljava/lang/String;", "searchText", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "I", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class n extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final TextView tvText;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final TextView tvLabel;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final ImageView ivDelete;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String searchText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.tvText = (TextView) itemView.findViewById(R.id.f53422cg);
        this.tvLabel = (TextView) itemView.findViewById(R.id.f53412cf);
        this.ivDelete = (ImageView) itemView.findViewById(R.id.f53392cd);
        this.searchText = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.manager.k.d().c(this$0.searchText);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o(QFSSearchHistoryItemInfo info) {
        String str;
        String str2;
        if (!info.needLabel) {
            TextView textView = this.tvLabel;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.tvLabel;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        boolean isDarkMode = QCircleSkinHelper.getInstance().isDarkMode();
        TextView textView3 = this.tvLabel;
        if (textView3 != null) {
            if (isDarkMode) {
                str2 = "#4CA9F8";
            } else {
                str2 = "#0099FF";
            }
            textView3.setTextColor(Color.parseColor(str2));
        }
        if (isDarkMode) {
            str = "#1AE6F5FF";
        } else {
            str = "#E6F5FF";
        }
        Drawable f16 = ad.f(Color.parseColor(str), 3, 17, 17);
        TextView textView4 = this.tvLabel;
        if (textView4 != null) {
            textView4.setBackground(f16);
        }
    }

    private final void p(QFSSearchHistoryItemInfo info, int position) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(position));
        String str = info.searchHistoryWord;
        Intrinsics.checkNotNullExpressionValue(str, "info.searchHistoryWord");
        hashMap.put("xsj_query_text", str);
        ImageView imageView = this.ivDelete;
        if (imageView != null) {
            ua0.i.k(imageView, "em_xsj_delete_button", hashMap, info.searchHistoryWord.hashCode());
        }
    }

    private final void q(QFSSearchHistoryItemInfo info, int position) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(position));
        String str = info.searchHistoryWord;
        Intrinsics.checkNotNullExpressionValue(str, "info.searchHistoryWord");
        hashMap.put("xsj_query_text", str);
        if (info.needLabel) {
            String qqStr = HardCodeUtil.qqStr(R.string.f195094do);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qfs_search_history_often)");
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HISTORY_ICON_NAME, qqStr);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HISTORY_ICON_TYPE, 10);
        }
        TextView textView = this.tvText;
        if (textView != null) {
            ua0.i.k(textView, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_HISTORY_WORD, hashMap, info.searchHistoryWord.hashCode());
        }
    }

    public final void m(@NotNull QFSSearchHistoryItemInfo info, int position) {
        Intrinsics.checkNotNullParameter(info, "info");
        String str = info.searchHistoryWord;
        Intrinsics.checkNotNullExpressionValue(str, "info.searchHistoryWord");
        this.searchText = str;
        TextView textView = this.tvText;
        if (textView != null) {
            textView.setText(info.searchHistoryWord);
        }
        o(info);
        q(info, position);
        p(info, position);
        ImageView imageView = this.ivDelete;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.n(n.this, view);
                }
            });
        }
    }
}
