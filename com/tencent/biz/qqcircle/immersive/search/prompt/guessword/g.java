package com.tencent.biz.qqcircle.immersive.search.prompt.guessword;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$PromptGuessInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua0.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcirclesearch/CircleSearchExhibition$PromptGuessInfo;", "info", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "index", "p", "l", "position", DomainData.DOMAIN_NAME, "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "textView", "G", "labelView", "<init>", "(Landroid/view/View;)V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g extends RecyclerView.ViewHolder {
    private static final int I = ViewUtils.dpToPx(120.0f);
    private static final int J = ViewUtils.dpToPx(142.0f);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final TextView textView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final TextView labelView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.itemView = itemView;
        this.textView = (TextView) this.itemView.findViewById(R.id.f53332c8);
        this.labelView = (TextView) this.itemView.findViewById(R.id.f53322c7);
    }

    private final void m(CircleSearchExhibition$PromptGuessInfo info) {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        if (info.reason.get() != 1) {
            TextView textView = this.labelView;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        String labelText = info.icon.text.get();
        String labelTextColorStr = info.icon.text_color.get();
        String labelBgColorStr = info.icon.background_color.get();
        Intrinsics.checkNotNullExpressionValue(labelText, "labelText");
        isBlank = StringsKt__StringsJVMKt.isBlank(labelText);
        if (!isBlank) {
            Intrinsics.checkNotNullExpressionValue(labelTextColorStr, "labelTextColorStr");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(labelTextColorStr);
            if (!isBlank2) {
                Intrinsics.checkNotNullExpressionValue(labelBgColorStr, "labelBgColorStr");
                isBlank3 = StringsKt__StringsJVMKt.isBlank(labelBgColorStr);
                if (!isBlank3) {
                    try {
                        TextView textView2 = this.labelView;
                        if (textView2 != null) {
                            textView2.setTextColor(Color.parseColor(labelTextColorStr));
                        }
                        Drawable f16 = ad.f(Color.parseColor(labelBgColorStr), 3, 17, 17);
                        TextView textView3 = this.labelView;
                        if (textView3 != null) {
                            textView3.setBackground(f16);
                        }
                        TextView textView4 = this.labelView;
                        if (textView4 != null) {
                            textView4.setText(labelText);
                        }
                        TextView textView5 = this.labelView;
                        if (textView5 != null) {
                            textView5.setVisibility(0);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e("QFSSearchPromptGuessWordViewHolder", 1, "[bindLabelView] ", e16);
                        return;
                    }
                }
            }
        }
        QLog.w("QFSSearchPromptGuessWordViewHolder", 1, "[bindLabelView] invalid params, " + labelText + ", " + labelTextColorStr + ", " + labelBgColorStr);
    }

    private final void o(CircleSearchExhibition$PromptGuessInfo info) {
        boolean z16;
        Typeface typeface;
        TextView textView;
        int d16;
        TextView textView2 = this.textView;
        if (textView2 != null) {
            textView2.setText(info.name.get());
        }
        if (info.reason.get() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.a.a() && (textView = this.textView) != null) {
            if (z16) {
                d16 = this.itemView.getContext().getColor(R.color.f157867cl0);
            } else {
                d16 = QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_primary);
            }
            textView.setTextColor(d16);
        }
        TextView textView3 = this.textView;
        if (textView3 != null) {
            textView3.setTypeface(typeface);
        }
    }

    private final void p(CircleSearchExhibition$PromptGuessInfo info, int index) {
        HashMap hashMap = new HashMap();
        String str = info.name.get();
        Intrinsics.checkNotNullExpressionValue(str, "info.name.get()");
        hashMap.put("xsj_query_text", str);
        hashMap.put("xsj_item_index", Integer.valueOf(index));
        String str2 = info.transfer_info.get();
        Intrinsics.checkNotNullExpressionValue(str2, "info.transfer_info.get()");
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SEARCH_GUESS_TRANSFER_INFO, str2);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GUESS_QUERY_REASON, Integer.valueOf(info.reason.get()));
        i.k(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_GUESS_WORD, hashMap, info.hashCode());
        i.h(this.itemView, "dt_imp", null);
    }

    public final void l(@NotNull CircleSearchExhibition$PromptGuessInfo info, int index) {
        Intrinsics.checkNotNullParameter(info, "info");
        o(info);
        m(info);
        p(info, index);
    }

    public final void n(int position) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView;
        TextView textView2 = this.textView;
        if (textView2 != null) {
            textView2.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_4);
        }
        TextView textView3 = this.labelView;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        TextView textView4 = this.textView;
        if (textView4 != null) {
            layoutParams = textView4.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (position != 2 && position != 3) {
            if (layoutParams != null) {
                layoutParams.width = J;
            }
        } else if (layoutParams != null) {
            layoutParams.width = I;
        }
        if (layoutParams != null && (textView = this.textView) != null) {
            textView.setLayoutParams(layoutParams);
        }
    }
}
