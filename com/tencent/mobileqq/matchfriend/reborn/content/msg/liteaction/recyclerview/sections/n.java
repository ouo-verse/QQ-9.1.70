package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.DynamicLayout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J*\u0010\u0016\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0014R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/n;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "model", "", "t", "Landroid/text/SpannableString;", "summary", "w", "Landroid/graphics/drawable/Drawable;", "u", "v", HippyTKDListViewAdapter.X, "Landroid/view/View;", "mRootView", "onInitView", "inputData", "", "position", "", "", "payload", "y", "", "getViewStubLayoutId", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "summaryView", tl.h.F, "I", "summaryViewWidth", "i", "Landroid/text/SpannableString;", "summaryAndTimeMarginString", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class n extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView summaryView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int summaryViewWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private SpannableString summaryAndTimeMarginString = new SpannableString("");

    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void t(QQStrangerLiteActionModel model) {
        String str;
        Drawable u16;
        TextView textView;
        TextView textView2;
        boolean contains$default;
        int indexOf$default;
        Resources resources = this.mRootView.getResources();
        if (resources == null) {
            return;
        }
        int sceneId = model.getSceneId();
        if (sceneId == 6) {
            TextView textView3 = this.summaryView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                textView3 = null;
            }
            textView3.setText(new SpannableStringBuilder().append((CharSequence) this.summaryAndTimeMarginString).append((CharSequence) v()));
            Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.qui_like_outline_testing, null);
            if (drawable != null) {
                drawable.setBounds(0, 0, cx.k(16.0f), cx.k(16.0f));
            }
            TextView textView4 = this.summaryView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                textView4 = null;
            }
            textView4.setCompoundDrawables(drawable, null, null, null);
            return;
        }
        if (sceneId != 7 && sceneId != 8) {
            String summary = getData().getSummary();
            if (summary.length() > 0) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) summary, (CharSequence) "{emoji}", false, 2, (Object) null);
                if (contains$default) {
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) getData().getSummary(), "{emoji}", 0, false, 6, (Object) null);
                    str = summary.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    SpannableStringBuilder append = new SpannableStringBuilder().append((CharSequence) str);
                    SpannableString spannableString = new SpannableString(" ");
                    u16 = u(getData());
                    if (u16 != null) {
                        spannableString.setSpan(new ImageSpan(u16), 0, 1, 33);
                    }
                    append.append((CharSequence) spannableString).append((CharSequence) this.summaryAndTimeMarginString).append((CharSequence) v());
                    textView = this.summaryView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                        textView = null;
                    }
                    textView.setText(append);
                    textView2 = this.summaryView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                        textView2 = null;
                    }
                    textView2.setCompoundDrawables(null, null, null, null);
                    return;
                }
            }
            str = "\u7ed9\u4f60\u53d1\u9001\u4e86\u4e00\u4e2a";
            SpannableStringBuilder append2 = new SpannableStringBuilder().append((CharSequence) str);
            SpannableString spannableString2 = new SpannableString(" ");
            u16 = u(getData());
            if (u16 != null) {
            }
            append2.append((CharSequence) spannableString2).append((CharSequence) this.summaryAndTimeMarginString).append((CharSequence) v());
            textView = this.summaryView;
            if (textView == null) {
            }
            textView.setText(append2);
            textView2 = this.summaryView;
            if (textView2 == null) {
            }
            textView2.setCompoundDrawables(null, null, null, null);
            return;
        }
        SpannableString spannableString3 = new SpannableString(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(getData().getSummary(), 16));
        TextView textView5 = this.summaryView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
            textView5 = null;
        }
        textView5.setText(new SpannableStringBuilder().append((CharSequence) w(spannableString3)).append((CharSequence) this.summaryAndTimeMarginString).append((CharSequence) v()));
        TextView textView6 = this.summaryView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
            textView6 = null;
        }
        textView6.setCompoundDrawables(null, null, null, null);
    }

    private final Drawable u(QQStrangerLiteActionModel model) {
        Drawable drawable;
        try {
            drawable = QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.convertToLocal(model.getEmojiId()));
        } catch (IllegalArgumentException e16) {
            QLog.e("SummarySection", 2, "Drawable exception: " + e16);
            drawable = null;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101741", false);
        if (drawable == null && isSwitchOn) {
            drawable = QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.convertToLocal(49));
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, cx.k(20.0f), cx.k(20.0f));
        }
        return drawable;
    }

    private final SpannableString v() {
        SpannableString spannableString = new SpannableString(getData().getTime());
        spannableString.setSpan(new ForegroundColorSpan(this.mRootView.getResources().getColor(R.color.qui_common_text_secondary, null)), 0, getData().getTime().length(), 18);
        return spannableString;
    }

    private final SpannableString w(SpannableString summary) {
        boolean contains$default;
        boolean contains$default2;
        int indexOf$default;
        int indexOf$default2;
        String str;
        SpannableString spannableString = new SpannableString(summary);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) summary, (CharSequence) "#highlight{", false, 2, (Object) null);
        if (!contains$default) {
            return spannableString;
        }
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) summary, (CharSequence) "}", false, 2, (Object) null);
        if (!contains$default2) {
            return spannableString;
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) summary, "#highlight{", 0, false, 6, (Object) null);
        indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) summary, "}", 0, false, 6, (Object) null);
        if (indexOf$default != -1 && indexOf$default2 != -1 && indexOf$default2 > indexOf$default) {
            str = summary.subSequence(indexOf$default + 11, indexOf$default2).toString();
        } else {
            str = "";
        }
        if (!(str.length() > 0)) {
            return spannableString;
        }
        SpannableString spannableString2 = new SpannableString(summary.subSequence(0, indexOf$default).toString() + str + summary.subSequence(indexOf$default2 + 1, summary.length()).toString());
        spannableString2.setSpan(new ForegroundColorSpan(this.mRootView.getResources().getColor(R.color.qui_common_text_secondary, null)), indexOf$default, str.length() + indexOf$default, 17);
        return spannableString2;
    }

    private final void x() {
        SpannableString spannableString;
        TextView textView = this.summaryView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
            textView = null;
        }
        Resources resources = textView.getContext().getResources();
        this.summaryViewWidth = (resources.getDisplayMetrics().widthPixels - ((resources.getDimensionPixelSize(R.dimen.f104322) + resources.getDimensionPixelSize(R.dimen.f104221)) + resources.getDimensionPixelSize(R.dimen.f104120))) - ((resources.getDimensionPixelSize(R.dimen.f104625) + resources.getDimensionPixelSize(R.dimen.f104524)) + resources.getDimensionPixelSize(R.dimen.f104423));
        TextView textView3 = this.summaryView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
            textView3 = null;
        }
        QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(getData().getSummary(), 16);
        Intrinsics.checkNotNullExpressionValue(qQText, "api(IGuildEmotionCodecAp\u2026(data.summary, FONE_SIZE)");
        DynamicLayout f16 = o.f(textView3, qQText, this.summaryViewWidth);
        TextView textView4 = this.summaryView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
        } else {
            textView2 = textView4;
        }
        QQText qQText2 = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(getData().getSummary() + ((CharSequence) o.g(8.0f)) + getData().getTime(), 16);
        Intrinsics.checkNotNullExpressionValue(qQText2, "api(IGuildEmotionCodecAp\u2026ry.toString(), FONE_SIZE)");
        if (f16.getLineCount() < o.f(textView2, qQText2, this.summaryViewWidth).getLineCount()) {
            spannableString = new SpannableString(new SpannableStringBuilder().append((CharSequence) o.g(0.0f)).append((CharSequence) "\n"));
        } else {
            spannableString = new SpannableString(o.g(8.0f).toString());
        }
        this.summaryAndTimeMarginString = spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(QQStrangerLiteActionModel inputData, int position, List<Object> payload) {
        s(position);
        if (inputData == null) {
            return;
        }
        r(inputData);
        x();
        t(getData());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View mRootView) {
        if (mRootView != null) {
            this.mRootView = mRootView;
            View findViewById = mRootView.findViewById(R.id.oo_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.qqstranger_lite_summary)");
            this.summaryView = (TextView) findViewById;
        }
    }
}
