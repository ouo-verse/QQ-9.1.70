package bd;

import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.qzone.reborn.base.l;
import com.qzone.util.ar;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.widget.RoundCorneredLinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import fo.c;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import xc.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J*\u0010\u001a\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lbd/b;", "Lcom/qzone/reborn/base/l;", "Lq5/a;", "Landroid/view/View$OnClickListener;", "", "D", "", HippyTKDListViewAdapter.X, "v", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "G", "B", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", UserInfo.SEX_FEMALE, "view", NodeProps.ON_CLICK, "Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "e", "Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "itemView", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "inputArea", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "inputIconView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "inputContentView", "Lxc/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lxc/g;", "quickInputIoc", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends l<q5.a> implements View.OnClickListener {
    private static final float D = ar.e(4.0f);
    private static final int E = ar.e(2.0f);
    private static final int F = ar.e(8.0f);
    private static final int G = ar.e(7.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredLinearLayout itemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout inputArea;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView inputIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView inputContentView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private g quickInputIoc;

    private final int A() {
        if (this.quickInputIoc == null) {
            RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
            RoundCorneredLinearLayout roundCorneredLinearLayout = this.itemView;
            if (roundCorneredLinearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemView");
                roundCorneredLinearLayout = null;
            }
            this.quickInputIoc = (g) g16.getIocInterface(g.class, roundCorneredLinearLayout, null);
        }
        g gVar = this.quickInputIoc;
        if (gVar != null) {
            return gVar.getPageType();
        }
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B() {
        if (this.quickInputIoc == null) {
            RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
            RoundCorneredLinearLayout roundCorneredLinearLayout = this.itemView;
            if (roundCorneredLinearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemView");
                roundCorneredLinearLayout = null;
            }
            this.quickInputIoc = (g) g16.getIocInterface(g.class, roundCorneredLinearLayout, null);
        }
        g gVar = this.quickInputIoc;
        if (gVar != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            gVar.u7((q5.a) mData, this.mPosition);
        }
    }

    private final boolean C() {
        return A() == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean D() {
        return ((q5.a) this.mData).f428352a == QZoneCommentQuickInputHelper.f44832g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        int i3;
        HashMap hashMap = new HashMap();
        String str = ((q5.a) this.mData).f428353b;
        Intrinsics.checkNotNullExpressionValue(str, "mData.text");
        hashMap.put("comment_text", str);
        T t16 = this.mData;
        if (((q5.a) t16).f428352a == QZoneCommentQuickInputHelper.f44832g) {
            i3 = 1;
        } else {
            i3 = ((q5.a) t16).f428352a == QZoneCommentQuickInputHelper.f44833h ? 2 : 0;
        }
        hashMap.put("text_type", Integer.valueOf(i3));
        fo.b i16 = new fo.b().l(hashMap).i(((q5.a) this.mData).f428353b);
        RoundCorneredLinearLayout roundCorneredLinearLayout = this.itemView;
        if (roundCorneredLinearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            roundCorneredLinearLayout = null;
        }
        c.o(roundCorneredLinearLayout, "em_qz_shortcut_copy", i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        String str;
        TextView textView = this.inputContentView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            textView = null;
        }
        textView.setText(((q5.a) this.mData).f428353b);
        TextView textView3 = this.inputContentView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            textView3 = null;
        }
        textView3.setPadding(0, 0, 0, 0);
        LinearLayout linearLayout = this.inputArea;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputArea");
            linearLayout = null;
        }
        int i3 = F;
        linearLayout.setPadding(i3, 0, i3, 0);
        try {
            if (QQTheme.isNowThemeIsNight()) {
                str = ((q5.a) this.mData).f428357f;
            } else {
                str = ((q5.a) this.mData).f428356e;
            }
            TextView textView4 = this.inputContentView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
                textView4 = null;
            }
            textView4.setTextColor(Color.parseColor(str));
        } catch (Exception unused) {
            QLog.e("QZoneCommentQuickInputContentSection", 2, "[bindInputAdvContentView] parse text color fail");
            TextView textView5 = this.inputContentView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
                textView5 = null;
            }
            TextView textView6 = this.inputContentView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            } else {
                textView2 = textView6;
            }
            textView5.setTextColor(textView2.getContext().getColor(R.color.qui_common_text_primary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        int i3;
        TextView textView = this.inputContentView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            textView = null;
        }
        textView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        TextView textView3 = this.inputContentView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            textView3 = null;
        }
        textView3.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(((q5.a) this.mData).f428353b), 3, 16));
        TextView textView4 = this.inputContentView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            textView4 = null;
        }
        TextView textView5 = this.inputContentView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            textView5 = null;
        }
        textView4.setTextColor(textView5.getContext().getColor(R.color.qui_common_text_primary));
        String str = ((q5.a) this.mData).f428353b;
        if (str == null) {
            str = "";
        }
        boolean z16 = QzoneEmotionUtils.getEmoCount(str) > 0;
        TextView textView6 = this.inputContentView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            textView6 = null;
        }
        textView6.setPadding(0, 0, 0, z16 ? E : 0);
        LinearLayout linearLayout = this.inputArea;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputArea");
            linearLayout = null;
        }
        if (z16) {
            i3 = G;
        } else {
            i3 = F;
        }
        linearLayout.setPadding(i3, 0, F, 0);
        if (AppSetting.f99565y) {
            TextView textView7 = this.inputContentView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputContentView");
            } else {
                textView2 = textView7;
            }
            AccessibilityUtil.p(textView2, QzoneEmotionUtils.emoCode2Text(((q5.a) this.mData).f428353b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        ImageView imageView = null;
        if (!TextUtils.isEmpty(((q5.a) this.mData).f428354c) && D()) {
            ImageView imageView2 = this.inputIconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputIconView");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            Option obtain = Option.obtain();
            obtain.setUrl(((q5.a) this.mData).f428354c);
            ImageView imageView3 = this.inputIconView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputIconView");
                imageView3 = null;
            }
            obtain.setTargetView(imageView3);
            ImageView imageView4 = this.inputIconView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputIconView");
                imageView4 = null;
            }
            if (imageView4.getLayoutParams() != null) {
                ImageView imageView5 = this.inputIconView;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputIconView");
                    imageView5 = null;
                }
                obtain.setRequestWidth(imageView5.getLayoutParams().width);
                ImageView imageView6 = this.inputIconView;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputIconView");
                } else {
                    imageView = imageView6;
                }
                obtain.setRequestHeight(imageView.getLayoutParams().height);
            }
            com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new IPicLoadStateListener() { // from class: bd.a
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    b.y(loadState, option);
                }
            });
            return;
        }
        QLog.i("QZoneCommentQuickInputContentSection", 2, "[bindInputIconView] pic url:" + ((q5.a) this.mData).f428354c);
        ImageView imageView7 = this.inputIconView;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputIconView");
        } else {
            imageView = imageView7;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        String str;
        LinearLayout linearLayout = null;
        if (C()) {
            LinearLayout linearLayout2 = this.inputArea;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputArea");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setBackgroundResource(R.drawable.f15283z);
            return;
        }
        if (!D()) {
            LinearLayout linearLayout3 = this.inputArea;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputArea");
                linearLayout3 = null;
            }
            LinearLayout linearLayout4 = this.inputArea;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputArea");
            } else {
                linearLayout = linearLayout4;
            }
            linearLayout3.setBackgroundColor(linearLayout.getContext().getColor(R.color.qui_common_fill_standard_primary));
            return;
        }
        try {
            if (QQTheme.isNowThemeIsNight()) {
                str = ((q5.a) this.mData).f428359h;
            } else {
                str = ((q5.a) this.mData).f428358g;
            }
            LinearLayout linearLayout5 = this.inputArea;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputArea");
                linearLayout5 = null;
            }
            linearLayout5.setBackgroundColor(Color.parseColor(str));
        } catch (Exception unused) {
            QLog.e("QZoneCommentQuickInputContentSection", 2, "[bindInputItemBg] parse bg color fail");
            LinearLayout linearLayout6 = this.inputArea;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputArea");
                linearLayout6 = null;
            }
            LinearLayout linearLayout7 = this.inputArea;
            if (linearLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputArea");
            } else {
                linearLayout = linearLayout7;
            }
            linearLayout6.setBackgroundColor(linearLayout.getContext().getColor(R.color.qui_common_fill_standard_primary));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(q5.a data, int position, List<Object> payload) {
        x();
        z();
        if (D()) {
            v();
        } else {
            w();
        }
        G();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f162820mt1) {
            B();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f162820mt1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026nt_quick_input_container)");
        this.itemView = (RoundCorneredLinearLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f162819mt0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026comment_quick_input_area)");
        this.inputArea = (LinearLayout) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f162821mt2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026comment_quick_input_icon)");
        this.inputIconView = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f162823mt4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026comment_quick_input_text)");
        this.inputContentView = (TextView) findViewById4;
        RoundCorneredLinearLayout roundCorneredLinearLayout = this.itemView;
        RoundCorneredLinearLayout roundCorneredLinearLayout2 = null;
        if (roundCorneredLinearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            roundCorneredLinearLayout = null;
        }
        roundCorneredLinearLayout.setRadius(D);
        RoundCorneredLinearLayout roundCorneredLinearLayout3 = this.itemView;
        if (roundCorneredLinearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
        } else {
            roundCorneredLinearLayout2 = roundCorneredLinearLayout3;
        }
        roundCorneredLinearLayout2.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nm6};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(LoadState loadState, Option option) {
        if (loadState != null && !loadState.isFinishError() && option != null) {
            Animatable animatable = option.getAnimatable();
            if (animatable != null) {
                animatable.start();
                return;
            }
            return;
        }
        QLog.e("QZoneCommentQuickInputContentSection", 2, "[bindInputIconView] fail:" + loadState);
    }
}
