package com.tencent.robot.adelie.homepage.create.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.qqmc.RobotQQMC;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u0088\u00012\u00020\u0001:\u0004\u0089\u0001\u008a\u0001B.\b\u0007\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u000e\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J6\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0002J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u0002J \u0010&\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000eH\u0014J\b\u0010'\u001a\u00020\u0002H\u0014J\u0012\u0010)\u001a\u00020\u000e2\b\b\u0001\u0010(\u001a\u00020\u000eH\u0004J\u001c\u0010,\u001a\u00020+2\b\b\u0001\u0010*\u001a\u00020\u000e2\b\b\u0001\u0010(\u001a\u00020\u000eH\u0004J\b\u0010-\u001a\u00020\u0002H\u0014R$\u00104\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R$\u0010B\u001a\u0004\u0018\u00010;8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00109R\u0018\u0010O\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\"\u0010_\u001a\u00020\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010JR\u0016\u0010a\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010ZR\u0016\u0010c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR*\u0010n\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020\u000e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010-\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR*\u0010r\u001a\u00020\u001d2\u0006\u0010h\u001a\u00020\u001d8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010Z\u001a\u0004\bp\u0010\\\"\u0004\bq\u0010^R\u001b\u0010x\u001a\u00020s8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u001a\u0010}\u001a\u00020y8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bz\u0010{\u001a\u0004\bI\u0010|R%\u0010\u0080\u0001\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b~\u0010k\"\u0004\b\u007f\u0010m\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView;", "Landroid/widget/RelativeLayout;", "", "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", "", "elementId", "K", "", "", "B", "L", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView$b;", "listener", "o", "title", "hint", "count", "Lcom/tencent/robot/adelie/homepage/create/view/TextCategory;", "category", "Lkotlin/Function0;", "aiGenerate", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "", "enable", "setEditEnabled", "text", "setEditText", "D", "generating", "setAIGenerateState", "J", UserInfo.SEX_FEMALE, "E", "tokenResId", "v", "drawableResId", "Landroid/graphics/drawable/Drawable;", HippyTKDListViewAdapter.X, "I", "d", "Landroid/view/View;", "w", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "e", "editTextContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleTextView", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", tl.h.F, "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", "setEditTextView", "(Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;)V", "editTextView", "i", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView$b;", "Lmqq/util/WeakReference;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/util/WeakReference;", "weakSelf", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "initHintText", "maxCountTextView", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "aiLoadingView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "aiGenerateView", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "settingUndoContainer", "H", "Lkotlin/jvm/functions/Function0;", "aiGenerateListener", "Z", "t", "()Z", "setAiGenerating", "(Z)V", "aiGenerating", "stashContent", "setTextByCode", "Lcom/tencent/robot/adelie/homepage/create/view/TextCategory;", "textCategory", "Lcom/tencent/robot/qqmc/model/a;", "M", "Lcom/tencent/robot/qqmc/model/a;", "aiGenerateConfig", "value", "N", "getThemeId", "()I", "setThemeId", "(I)V", "themeId", "P", "getShowWordCount", "setShowWordCount", "showWordCount", "Landroid/graphics/drawable/GradientDrawable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "u", "()Landroid/graphics/drawable/GradientDrawable;", "bgDrawable", "Lh53/n;", BdhLogUtil.LogTag.Tag_Req, "Lh53/n;", "()Lh53/n;", "watcher", "getMaxWordCount", "setMaxWordCount", "maxWordCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class AdelieEditTextView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String initHintText;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView maxCountTextView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ScanningLightView aiLoadingView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView aiGenerateView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private LinearLayout settingUndoContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> aiGenerateListener;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean aiGenerating;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String stashContent;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean setTextByCode;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private TextCategory textCategory;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.robot.qqmc.model.a aiGenerateConfig;

    /* renamed from: N, reason: from kotlin metadata */
    private int themeId;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean showWordCount;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy bgDrawable;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final h53.n watcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View editTextContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterceptTouchEditText editTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AdelieEditTextView> weakSelf;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView$b;", "", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView;", "view", "Landroid/text/Editable;", "editable", "", "a", "", "hasFocus", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        void a(@Nullable AdelieEditTextView view, @Nullable Editable editable);

        void b(@Nullable AdelieEditTextView view, boolean hasFocus);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieEditTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Map<String, Object> B() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("retouching_category", Integer.valueOf(this.textCategory.getValue())));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AdelieEditTextView this$0, ImageView view, View view2) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        String y16 = this$0.y();
        if (y16 != null && y16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this$0.stashContent = y16;
            Function0<Unit> function0 = this$0.aiGenerateListener;
            if (function0 != null) {
                function0.invoke();
            }
            this$0.setAIGenerateState(true);
            VideoReport.reportEvent("clck", view, this$0.B());
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(AdelieEditTextView this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.stashContent.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this$0.setEditText(this$0.stashContent);
            this$0.stashContent = "";
            LinearLayout linearLayout = this$0.settingUndoContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            VideoReport.reportEvent("clck", view, this$0.B());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(View view, String elementId) {
        if (view != null) {
            view.setVisibility(0);
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, view, elementId, null, null, null, null, null, 124, null);
            VideoReport.reportEvent("imp", view, B());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        String str;
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null && interceptTouchEditText.getCharacterLimitCount() > 0) {
            if (interceptTouchEditText.getCurrentCount() > 0) {
                str = interceptTouchEditText.getCurrentCount() + "/" + interceptTouchEditText.getCharacterLimitCount() + "\u5b57";
            } else {
                str = interceptTouchEditText.getCharacterLimitCount() + "\u5b57";
            }
            TextView textView = this.maxCountTextView;
            if (textView != null) {
                textView.setText(str);
            }
            if (interceptTouchEditText.getCurrentCount() >= interceptTouchEditText.getCharacterLimitCount()) {
                TextView textView2 = this.maxCountTextView;
                if (textView2 != null) {
                    textView2.setTextColor(v(R.color.qui_common_feedback_error));
                    return;
                }
                return;
            }
            TextView textView3 = this.maxCountTextView;
            if (textView3 != null) {
                textView3.setTextColor(v(R.color.qui_common_text_secondary));
            }
        }
    }

    private final void r() {
        Drawable drawable;
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.setVisibility(4);
        }
        ImageView imageView = this.aiGenerateView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        LinearLayout linearLayout = this.settingUndoContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        ScanningLightView scanningLightView = this.aiLoadingView;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(0);
        }
        TextView textView = this.maxCountTextView;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ScanningLightView scanningLightView2 = this.aiLoadingView;
        if (scanningLightView2 != null && (drawable = scanningLightView2.getDrawable()) != null) {
            Intrinsics.checkNotNullExpressionValue(drawable, "it.drawable ?: return@let");
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int width = getWidth();
            int height = getHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0 && width > 0 && height > 0) {
                float f16 = width / intrinsicWidth;
                Matrix matrix = new Matrix();
                matrix.setScale(f16, 1.0f);
                scanningLightView2.setImageMatrix(matrix);
            }
        }
    }

    private final void s() {
        boolean z16;
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        boolean z17 = false;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.setVisibility(0);
        }
        ScanningLightView scanningLightView = this.aiLoadingView;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(4);
        }
        if (y().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            K(this.aiGenerateView, "em_bas_touch_up");
        }
        TextView textView = this.maxCountTextView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (this.stashContent.length() > 0) {
            z17 = true;
        }
        if (z17) {
            K(this.settingUndoContainer, "em_bas_undo_button");
        }
    }

    private final GradientDrawable u() {
        return (GradientDrawable) this.bgDrawable.getValue();
    }

    protected int A() {
        return R.layout.dry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: C, reason: from getter */
    public final h53.n getWatcher() {
        return this.watcher;
    }

    public final void D() {
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.r();
        }
    }

    protected void E() {
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.setInputViewWatcher(this.watcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(@NotNull String title, @NotNull String hint, int count) {
        View view;
        TextView textView;
        InterceptTouchEditText interceptTouchEditText;
        TextView textView2;
        ScanningLightView scanningLightView;
        final ImageView imageView;
        View view2;
        View view3;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.initHintText = hint;
        View view4 = this.contentView;
        LinearLayout linearLayout = null;
        if (view4 != null) {
            view = view4.findViewById(R.id.uqs);
        } else {
            view = null;
        }
        this.editTextContainer = view;
        if (view != null) {
            view.setBackground(u());
        }
        View view5 = this.contentView;
        if (view5 != null) {
            textView = (TextView) view5.findViewById(R.id.uqt);
        } else {
            textView = null;
        }
        this.titleTextView = textView;
        View view6 = this.contentView;
        if (view6 != null) {
            interceptTouchEditText = (InterceptTouchEditText) view6.findViewById(R.id.btb);
        } else {
            interceptTouchEditText = null;
        }
        this.editTextView = interceptTouchEditText;
        TextView textView3 = this.titleTextView;
        if (textView3 != null) {
            textView3.setText(title);
        }
        InterceptTouchEditText interceptTouchEditText2 = this.editTextView;
        if (interceptTouchEditText2 != null) {
            interceptTouchEditText2.setHint(hint);
        }
        E();
        setMaxWordCount(count);
        View view7 = this.contentView;
        if (view7 != null) {
            textView2 = (TextView) view7.findViewById(R.id.zi8);
        } else {
            textView2 = null;
        }
        this.maxCountTextView = textView2;
        View view8 = this.contentView;
        if (view8 != null) {
            scanningLightView = (ScanningLightView) view8.findViewById(R.id.sfy);
        } else {
            scanningLightView = null;
        }
        this.aiLoadingView = scanningLightView;
        if (this.aiGenerateConfig.c() && (view3 = this.contentView) != null) {
            imageView = (ImageView) view3.findViewById(R.id.sfw);
        } else {
            imageView = null;
        }
        this.aiGenerateView = imageView;
        if (imageView != null) {
            K(imageView, "em_bas_touch_up");
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view9) {
                    AdelieEditTextView.G(AdelieEditTextView.this, imageView, view9);
                }
            });
        }
        if (this.aiGenerateConfig.c() && (view2 = this.contentView) != null) {
            linearLayout = (LinearLayout) view2.findViewById(R.id.f83934kw);
        }
        this.settingUndoContainer = linearLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view9) {
                    AdelieEditTextView.H(AdelieEditTextView.this, view9);
                }
            });
        }
    }

    protected void I() {
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.setTextColor(v(R.color.qui_common_text_primary));
            interceptTouchEditText.setHintTextColor(v(R.color.qui_common_text_tertiary));
            if (Build.VERSION.SDK_INT >= 29) {
                interceptTouchEditText.setTextCursorDrawable(x(R.drawable.qui_input_cursor, R.color.qui_common_brand_standard));
            }
            if (interceptTouchEditText.getCurrentCount() >= interceptTouchEditText.getCharacterLimitCount()) {
                TextView textView = this.maxCountTextView;
                if (textView != null) {
                    textView.setTextColor(v(R.color.qui_common_feedback_error));
                    return;
                }
                return;
            }
            TextView textView2 = this.maxCountTextView;
            if (textView2 != null) {
                textView2.setTextColor(v(R.color.qui_common_text_secondary));
            }
        }
    }

    public final void J() {
        this.stashContent = "";
    }

    public final void o(@Nullable b listener) {
        this.listener = listener;
    }

    @Nullable
    public final View p(@NotNull String title, @NotNull String hint, int count, @NotNull TextCategory category, @NotNull Function0<Unit> aiGenerate) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(aiGenerate, "aiGenerate");
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        this.contentView = LayoutInflater.from(getContext()).inflate(A(), this);
        F(title, hint, count);
        this.weakSelf = new WeakReference<>(this);
        this.aiGenerateListener = aiGenerate;
        FontSettingManager.resetViewSize2Normal(getContext(), this.contentView);
        this.textCategory = category;
        return this.contentView;
    }

    public final void q() {
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.r();
        }
        this.listener = null;
    }

    public final void setAIGenerateState(boolean generating) {
        if (this.aiGenerating != generating) {
            if (generating) {
                r();
            } else {
                s();
            }
            this.aiGenerating = generating;
        }
    }

    public void setEditEnabled(boolean enable) {
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.clearFocus();
        }
        InterceptTouchEditText interceptTouchEditText2 = this.editTextView;
        if (interceptTouchEditText2 != null) {
            interceptTouchEditText2.setEnabled(enable);
        }
        ImageView imageView = this.aiGenerateView;
        if (imageView != null) {
            imageView.setEnabled(enable);
        }
        LinearLayout linearLayout = this.settingUndoContainer;
        if (linearLayout != null) {
            linearLayout.setEnabled(enable);
        }
    }

    public final void setEditText(@NotNull String text) {
        InterceptTouchEditText interceptTouchEditText;
        Intrinsics.checkNotNullParameter(text, "text");
        boolean z16 = true;
        this.setTextByCode = true;
        InterceptTouchEditText interceptTouchEditText2 = this.editTextView;
        if (interceptTouchEditText2 != null) {
            interceptTouchEditText2.setText(Editable.Factory.getInstance().newEditable(text));
        }
        InterceptTouchEditText interceptTouchEditText3 = this.editTextView;
        if (interceptTouchEditText3 != null) {
            interceptTouchEditText3.setHint("");
        }
        InterceptTouchEditText interceptTouchEditText4 = this.editTextView;
        if (interceptTouchEditText4 != null) {
            interceptTouchEditText4.setEnabled(true);
        }
        InterceptTouchEditText interceptTouchEditText5 = this.editTextView;
        if (interceptTouchEditText5 != null) {
            interceptTouchEditText5.setFocusable(true);
        }
        if (text.length() != 0) {
            z16 = false;
        }
        if (z16 && (interceptTouchEditText = this.editTextView) != null) {
            interceptTouchEditText.setHint(this.initHintText);
        }
    }

    public final void setMaxWordCount(int i3) {
        int i16 = 8;
        if (i3 > 0) {
            TextView textView = this.maxCountTextView;
            if (textView != null) {
                if (this.showWordCount) {
                    i16 = 0;
                }
                textView.setVisibility(i16);
            }
            InterceptTouchEditText interceptTouchEditText = this.editTextView;
            if (interceptTouchEditText != null) {
                interceptTouchEditText.setLimitCount(i3);
            }
            L();
            return;
        }
        TextView textView2 = this.maxCountTextView;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    public final void setShowWordCount(boolean z16) {
        int i3;
        this.showWordCount = z16;
        TextView textView = this.maxCountTextView;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public final void setThemeId(int i3) {
        if (this.themeId != i3) {
            this.themeId = i3;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t, reason: from getter */
    public final boolean getAiGenerating() {
        return this.aiGenerating;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int v(@ColorRes int tokenResId) {
        return ie0.a.f().g(getContext(), tokenResId, this.themeId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: w, reason: from getter */
    public final View getContentView() {
        return this.contentView;
    }

    @NotNull
    protected final Drawable x(@DrawableRes int drawableResId, @ColorRes int tokenResId) {
        Drawable o16 = ie0.a.f().o(getContext(), drawableResId, tokenResId, this.themeId);
        Intrinsics.checkNotNullExpressionValue(o16, "getInstances().getQuiTok\u2026sId, tokenResId, themeId)");
        return o16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.trim(r0);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String y() {
        CharSequence trim;
        String obj;
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText == null || (r0 = interceptTouchEditText.getText()) == null || trim == null || (obj = trim.toString()) == null) {
            return "";
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: z, reason: from getter */
    public final InterceptTouchEditText getEditTextView() {
        return this.editTextView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieEditTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieEditTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieEditTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.initHintText = "";
        this.stashContent = "";
        this.textCategory = TextCategory.DEFAULT;
        this.aiGenerateConfig = RobotQQMC.INSTANCE.getAiGenerateConfig();
        this.themeId = 1000;
        this.showWordCount = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView$bgDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(CommonExKt.l(AdelieEditTextView.this.v(R.color.qui_common_fill_light_primary), 0.5f));
                gradientDrawable.setCornerRadius(c24.a.a(4));
                return gradientDrawable;
            }
        });
        this.bgDrawable = lazy;
        this.watcher = new c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/robot/adelie/homepage/create/view/AdelieEditTextView$c", "Lh53/n;", "", "p0", "", "p1", "p2", "p3", "", "beforeTextChanged", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "hasFocus", "f8", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements h53.n {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h53.k
        public void afterTextChanged(@Nullable Editable p06) {
            boolean z16;
            AdelieEditTextView adelieEditTextView;
            b bVar = AdelieEditTextView.this.listener;
            if (bVar != null) {
                WeakReference weakReference = AdelieEditTextView.this.weakSelf;
                if (weakReference != null) {
                    adelieEditTextView = (AdelieEditTextView) weakReference.get();
                } else {
                    adelieEditTextView = null;
                }
                bVar.a(adelieEditTextView, p06);
            }
            AdelieEditTextView.this.L();
            if (String.valueOf(p06).length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                InterceptTouchEditText editTextView = AdelieEditTextView.this.getEditTextView();
                if (editTextView != null) {
                    editTextView.setHint(AdelieEditTextView.this.initHintText);
                }
                ImageView imageView = AdelieEditTextView.this.aiGenerateView;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
            } else {
                AdelieEditTextView adelieEditTextView2 = AdelieEditTextView.this;
                adelieEditTextView2.K(adelieEditTextView2.aiGenerateView, "em_bas_touch_up");
            }
            if (!AdelieEditTextView.this.setTextByCode) {
                AdelieEditTextView.this.stashContent = "";
                LinearLayout linearLayout = AdelieEditTextView.this.settingUndoContainer;
                if (linearLayout != null) {
                    linearLayout.setVisibility(4);
                }
            }
            AdelieEditTextView.this.setTextByCode = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h53.k
        public void f8(boolean hasFocus) {
            AdelieEditTextView adelieEditTextView;
            b bVar = AdelieEditTextView.this.listener;
            if (bVar != null) {
                WeakReference weakReference = AdelieEditTextView.this.weakSelf;
                if (weakReference != null) {
                    adelieEditTextView = (AdelieEditTextView) weakReference.get();
                } else {
                    adelieEditTextView = null;
                }
                bVar.b(adelieEditTextView, hasFocus);
            }
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence p06, int p16, int p26, int p36) {
        }

        @Override // h53.k
        public void onTextChanged(@Nullable CharSequence p06, int p16, int p26, int p36) {
        }
    }
}
