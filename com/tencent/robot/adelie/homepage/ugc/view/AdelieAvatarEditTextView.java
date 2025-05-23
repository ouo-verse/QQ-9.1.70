package com.tencent.robot.adelie.homepage.ugc.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.constant.AdelieConstant;
import com.tencent.robot.adelie.homepage.create.view.InterceptTouchEditText;
import com.tencent.robot.adelie.homepage.ugc.AdelieAvatarUgcTemplateFragment;
import com.tencent.util.QQToastUtil;
import java.util.List;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateRequest;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 n2\u00020\u0001:\u0001oB'\b\u0007\u0012\u0006\u0010h\u001a\u00020g\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010i\u0012\b\b\u0002\u0010k\u001a\u00020\u000e\u00a2\u0006\u0004\bl\u0010mJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0012\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0004J2\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000eJ&\u0010\"\u001a\u00020\u00062\u001e\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001f0 0\u001fJ\u0006\u0010#\u001a\u00020\u0002J,\u0010'\u001a\u00020\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010%J\u0006\u0010(\u001a\u00020\u0002J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0002R\u0018\u0010-\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00100R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010?R\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010FR\u0016\u0010Z\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010OR\u0018\u0010\\\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u00100R\u001e\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R$\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010e\u00a8\u0006p"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarEditTextView;", "Landroid/widget/RelativeLayout;", "", "tag", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", BdhLogUtil.LogTag.Tag_Conn, "", "errCode", "y", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "", "tokenResId", "r", "title", "hint", "count", "Lcom/tencent/robot/adelie/homepage/ugc/view/y;", "onTextChange", "Landroid/content/Intent;", "intent", "Landroid/view/View;", "o", "t", "Landroid/widget/ImageView;", "button", "targetState", DomainData.DOMAIN_NAME, "", "Lkotlin/Pair;", "tagInput", "w", ReportConstant.COSTREPORT_PREFIX, DownloadInfo.spKey_Config, "", "map", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "text", "B", "d", "Landroid/view/View;", "contentView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleTextView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", tl.h.F, "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", "editTextView", "i", "maxCountTextView", "Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter;", "Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter;", "tagAdapter", "Landroid/widget/ImageView;", "magicBtn", "Lmqq/util/WeakReference;", "D", "Lmqq/util/WeakReference;", "weakSelf", "E", "Ljava/lang/String;", "initHintText", UserInfo.SEX_FEMALE, "Z", "isTagClick", "G", "Lcom/tencent/robot/adelie/homepage/ugc/view/y;", "textChangeListener", "H", "I", "themeId", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "aiLoadingView", "J", "Landroid/content/Intent;", "inputIntent", "K", "stashContent", "L", "magicBtnState", "M", "findUgcIdea", "N", "Ljava/util/List;", "emptyConfigSingle", "P", "Ljava/util/Map;", "referMap", "Lh53/n;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lh53/n;", "textWatcher", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Req, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarEditTextView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView magicBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WeakReference<AdelieAvatarEditTextView> weakSelf;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String initHintText;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isTagClick;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private y textChangeListener;

    /* renamed from: H, reason: from kotlin metadata */
    private int themeId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ScanningLightView aiLoadingView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Intent inputIntent;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String stashContent;

    /* renamed from: L, reason: from kotlin metadata */
    private int magicBtnState;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView findUgcIdea;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private List<String> emptyConfigSingle;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Map<String, String> referMap;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final h53.n textWatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterceptTouchEditText editTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView maxCountTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieAvatarTagAdapter tagAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieAvatarEditTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
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
                    textView2.setTextColor(r(R.color.qui_common_feedback_error));
                    return;
                }
                return;
            }
            TextView textView3 = this.maxCountTextView;
            if (textView3 != null) {
                textView3.setTextColor(r(R.color.qui_common_text_tertiary));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(String tag) {
        boolean z16;
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText == null) {
            return false;
        }
        String valueOf = String.valueOf(interceptTouchEditText.getText());
        if (valueOf.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            tag = valueOf + "," + tag;
        }
        if (interceptTouchEditText.n(tag) > interceptTouchEditText.getCharacterLimitCount()) {
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView$addTagToEditText$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQToast.makeText(AdelieAvatarEditTextView.this.getContext(), 0, "\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", 0).show();
                }
            });
            return false;
        }
        this.isTagClick = true;
        interceptTouchEditText.setText(tag, TextView.BufferType.NORMAL);
        interceptTouchEditText.setSelection(tag.length());
        return true;
    }

    private final void p() {
        Editable editable;
        Drawable drawable;
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            editable = interceptTouchEditText.getText();
        } else {
            editable = null;
        }
        this.stashContent = String.valueOf(editable);
        InterceptTouchEditText interceptTouchEditText2 = this.editTextView;
        if (interceptTouchEditText2 != null) {
            interceptTouchEditText2.setVisibility(4);
        }
        ScanningLightView scanningLightView = this.aiLoadingView;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(0);
        }
        TextView textView = this.maxCountTextView;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ImageView imageView = this.magicBtn;
        if (imageView != null) {
            imageView.setVisibility(4);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.setVisibility(0);
        }
        ScanningLightView scanningLightView = this.aiLoadingView;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(4);
        }
        TextView textView = this.maxCountTextView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ImageView imageView = this.magicBtn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.String] */
    public static final void u(AdelieAvatarEditTextView this$0, View view) {
        boolean z16;
        List<String> list;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = "";
        objectRef.element = "";
        String str2 = null;
        GenerateRequestExtra generateRequestExtra = new GenerateRequestExtra(null, null, 3, null);
        if (this$0.editTextView != null) {
            generateRequestExtra.c(this$0.stashContent);
            Intent intent = this$0.inputIntent;
            if (intent != null) {
                str2 = intent.getStringExtra("character.description");
            }
            if (str2 != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "inputIntent?.getStringEx\u2026RACTER_DESCRIPTION) ?: \"\"");
                str = str2;
            }
            generateRequestExtra.d(str);
            boolean z17 = false;
            if (generateRequestExtra.getCharDesc().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (generateRequestExtra.getCharDesign().length() == 0) {
                    z17 = true;
                }
                if (z17 && (list = this$0.emptyConfigSingle) != null) {
                    generateRequestExtra.c(list.get(Random.INSTANCE.nextInt(list.size())));
                }
            }
            Map<String, String> map = this$0.referMap;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    StringsKt__StringsJVMKt.replace$default(generateRequestExtra.getCharDesc(), entry.getKey(), entry.getValue(), false, 4, (Object) null);
                }
            }
            objectRef.element = generateRequestExtra.getCharDesc() + "#" + generateRequestExtra.getCharDesign();
        }
        String json = new Gson().toJson(generateRequestExtra);
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i("AdelieAvatarEditTextView", 1, "ai generate extra: " + json);
        ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest = new ShadowAIGCGenerate$GenerateRequest();
        shadowAIGCGenerate$GenerateRequest.busi_id.set("ugc_bot");
        shadowAIGCGenerate$GenerateRequest.func_id.set("generate_desc");
        shadowAIGCGenerate$GenerateRequest.extra.set(json);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "AdelieAvatarEditTextView_uploadOriginAndGetUrl", null, null, null, new AdelieAvatarEditTextView$initView$3$1(this$0, shadowAIGCGenerate$GenerateRequest, view, objectRef, currentTimeMillis, null), 14, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AdelieAvatarEditTextView this$0, View view) {
        Editable editable;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            Intent intent = new Intent();
            InterceptTouchEditText interceptTouchEditText = this$0.editTextView;
            if (interceptTouchEditText != null) {
                editable = interceptTouchEditText.getText();
            } else {
                editable = null;
            }
            int i3 = 0;
            if (editable != null && editable.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            intent.putExtra("hasEditPrompt", !z16);
            Intent intent2 = this$0.inputIntent;
            if (intent2 != null) {
                i3 = intent2.getIntExtra("character.gender", 0);
            }
            intent.putExtra("character.gender", i3);
            AdelieAvatarUgcTemplateFragment.Companion companion = AdelieAvatarUgcTemplateFragment.INSTANCE;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.c(context, intent, 134);
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x() {
        RelativeLayout relativeLayout;
        if (!je0.a.a(BaseApplication.getContext()) && getContext() != null) {
            View view = this.contentView;
            if (view != null) {
                relativeLayout = (RelativeLayout) view.findViewById(R.id.f95915g_);
            } else {
                relativeLayout = null;
            }
            if (relativeLayout != null) {
                Drawable k3 = ie0.a.f().k(getContext(), R.color.qui_common_fill_light_primary, c24.a.a(4), 1001);
                k3.setAlpha(128);
                relativeLayout.setBackground(k3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(long errCode) {
        String str;
        AdelieConstant adelieConstant = AdelieConstant.f365917a;
        if (adelieConstant.a().containsKey(Long.valueOf(errCode))) {
            str = adelieConstant.a().get(Long.valueOf(errCode));
        } else {
            str = "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
        }
        QQToastUtil.showQQToastInUiThread(0, str);
    }

    public final void A(@Nullable List<String> config, @Nullable Map<String, String> map) {
        this.emptyConfigSingle = config;
        this.referMap = map;
    }

    public final void B(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.setText(text, TextView.BufferType.NORMAL);
            interceptTouchEditText.setSelection(text.length());
            this.magicBtnState = 1;
        }
    }

    public final void n(@NotNull ImageView button, int targetState) {
        Intrinsics.checkNotNullParameter(button, "button");
        int i3 = this.magicBtnState;
        if (targetState == i3) {
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, button, "em_bas_intelligent_filling", null, null, null, null, null, 124, null);
                VideoReport.reportEvent("imp", button, null);
                this.magicBtnState = 0;
                return;
            }
            return;
        }
        com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, button, "em_bas_touch_up", null, null, null, null, null, 124, null);
        VideoReport.reportEvent("imp", button, null);
        this.magicBtnState = 1;
    }

    @Nullable
    public final View o(@NotNull String title, @NotNull String hint, int count, @NotNull y onTextChange, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(onTextChange, "onTextChange");
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        this.contentView = LayoutInflater.from(getContext()).inflate(R.layout.dta, this);
        this.weakSelf = new WeakReference<>(this);
        t(title, hint, count);
        this.textChangeListener = onTextChange;
        this.inputIntent = intent;
        return this.contentView;
    }

    protected final int r(@ColorRes int tokenResId) {
        return ie0.a.f().g(getContext(), tokenResId, this.themeId);
    }

    @NotNull
    public final String s() {
        Editable text;
        String obj;
        InterceptTouchEditText interceptTouchEditText = this.editTextView;
        if (interceptTouchEditText == null || (text = interceptTouchEditText.getText()) == null || (obj = text.toString()) == null) {
            return "";
        }
        return obj;
    }

    public final void t(@NotNull String title, @NotNull String hint, int count) {
        RecyclerView recyclerView;
        InterceptTouchEditText interceptTouchEditText;
        TextView textView;
        ImageView imageView;
        TextView textView2;
        ScanningLightView scanningLightView;
        String str;
        Object obj;
        TextView textView3;
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hint, "hint");
        View view = this.contentView;
        if (view != null) {
            recyclerView = (RecyclerView) view.findViewById(R.id.f923357l);
        } else {
            recyclerView = null;
        }
        this.recyclerView = recyclerView;
        View view2 = this.contentView;
        if (view2 != null) {
            interceptTouchEditText = (InterceptTouchEditText) view2.findViewById(R.id.btb);
        } else {
            interceptTouchEditText = null;
        }
        this.editTextView = interceptTouchEditText;
        View view3 = this.contentView;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.f113836rp);
        } else {
            textView = null;
        }
        this.findUgcIdea = textView;
        View view4 = this.contentView;
        if (view4 != null) {
            imageView = (ImageView) view4.findViewById(R.id.yvz);
        } else {
            imageView = null;
        }
        this.magicBtn = imageView;
        View view5 = this.contentView;
        if (view5 != null) {
            textView2 = (TextView) view5.findViewById(R.id.zi8);
        } else {
            textView2 = null;
        }
        this.maxCountTextView = textView2;
        View view6 = this.contentView;
        if (view6 != null) {
            scanningLightView = (ScanningLightView) view6.findViewById(R.id.sfy);
        } else {
            scanningLightView = null;
        }
        this.aiLoadingView = scanningLightView;
        TextView textView4 = this.findUgcIdea;
        if (textView4 != null) {
            str = "imp";
            obj = "dt_pgid";
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, textView4, "em_bas_find_inspiration", null, null, null, null, null, 124, null);
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(obj, "pg_smart_image_creation"));
            VideoReport.reportEvent(str, textView4, mapOf2);
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    AdelieAvatarEditTextView.v(AdelieAvatarEditTextView.this, view7);
                }
            });
        } else {
            str = "imp";
            obj = "dt_pgid";
        }
        ImageView imageView2 = this.magicBtn;
        if (imageView2 != null) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, imageView2, "em_bas_intelligent_filling", null, null, null, null, null, 124, null);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(obj, "pg_smart_image_creation"));
            VideoReport.reportEvent(str, imageView2, mapOf);
        }
        ImageView imageView3 = this.magicBtn;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    AdelieAvatarEditTextView.u(AdelieAvatarEditTextView.this, view7);
                }
            });
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.Z(0);
        flexboxLayoutManager.Y(2);
        flexboxLayoutManager.b0(0);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(flexboxLayoutManager);
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setNestedScrollingEnabled(false);
        }
        InterceptTouchEditText interceptTouchEditText2 = this.editTextView;
        if (interceptTouchEditText2 != null) {
            interceptTouchEditText2.setInputViewWatcher(this.textWatcher);
        }
        View view7 = this.contentView;
        if (view7 != null) {
            textView3 = (TextView) view7.findViewById(R.id.uqt);
        } else {
            textView3 = null;
        }
        this.titleTextView = textView3;
        if (textView3 != null) {
            textView3.setText(title);
        }
        this.initHintText = hint;
        InterceptTouchEditText interceptTouchEditText3 = this.editTextView;
        if (interceptTouchEditText3 != null) {
            interceptTouchEditText3.setHint(hint);
        }
        InterceptTouchEditText interceptTouchEditText4 = this.editTextView;
        if (interceptTouchEditText4 != null) {
            interceptTouchEditText4.setLimitCount(count);
        }
        x();
    }

    public final void w(@NotNull List<? extends Pair<String, ? extends List<String>>> tagInput) {
        Intrinsics.checkNotNullParameter(tagInput, "tagInput");
        AdelieAvatarTagAdapter adelieAvatarTagAdapter = new AdelieAvatarTagAdapter(tagInput, new Function1<String, Boolean>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView$refreshTag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull String outString) {
                boolean m3;
                Intrinsics.checkNotNullParameter(outString, "outString");
                m3 = AdelieAvatarEditTextView.this.m(outString);
                return Boolean.valueOf(m3);
            }
        });
        this.tagAdapter = adelieAvatarTagAdapter;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(adelieAvatarTagAdapter);
        }
    }

    @NotNull
    public final String z() {
        String s06;
        AdelieAvatarTagAdapter adelieAvatarTagAdapter = this.tagAdapter;
        if (adelieAvatarTagAdapter == null || (s06 = adelieAvatarTagAdapter.s0()) == null) {
            return "";
        }
        return s06;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieAvatarEditTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieAvatarEditTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieAvatarEditTextView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.initHintText = "";
        this.themeId = 1000;
        this.stashContent = "";
        this.textWatcher = new h53.n() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView$textWatcher$1
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
            
                r0 = r5.f366563d.textChangeListener;
             */
            @Override // h53.k
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void afterTextChanged(@Nullable Editable s16) {
                boolean z16;
                ImageView imageView;
                AdelieAvatarTagAdapter adelieAvatarTagAdapter;
                AdelieAvatarTagAdapter adelieAvatarTagAdapter2;
                y yVar;
                InterceptTouchEditText interceptTouchEditText;
                ImageView imageView2;
                AdelieAvatarTagAdapter adelieAvatarTagAdapter3;
                String str;
                AdelieAvatarEditTextView.this.isTagClick = false;
                AdelieAvatarEditTextView.this.C();
                String valueOf = String.valueOf(s16);
                if (valueOf.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    interceptTouchEditText = AdelieAvatarEditTextView.this.editTextView;
                    if (interceptTouchEditText != null) {
                        str = AdelieAvatarEditTextView.this.initHintText;
                        interceptTouchEditText.setHint(str);
                    }
                    imageView2 = AdelieAvatarEditTextView.this.magicBtn;
                    if (imageView2 != null) {
                        AdelieAvatarEditTextView adelieAvatarEditTextView = AdelieAvatarEditTextView.this;
                        imageView2.setImageResource(R.drawable.mhx);
                        adelieAvatarEditTextView.n(imageView2, 0);
                    }
                    adelieAvatarTagAdapter3 = AdelieAvatarEditTextView.this.tagAdapter;
                    if (adelieAvatarTagAdapter3 != null) {
                        adelieAvatarTagAdapter3.m0();
                    }
                } else {
                    imageView = AdelieAvatarEditTextView.this.magicBtn;
                    if (imageView != null) {
                        AdelieAvatarEditTextView adelieAvatarEditTextView2 = AdelieAvatarEditTextView.this;
                        imageView.setImageResource(R.drawable.mhy);
                        adelieAvatarEditTextView2.n(imageView, 1);
                    }
                    adelieAvatarTagAdapter = AdelieAvatarEditTextView.this.tagAdapter;
                    if (adelieAvatarTagAdapter != null) {
                        adelieAvatarTagAdapter.q0(valueOf);
                    }
                }
                adelieAvatarTagAdapter2 = AdelieAvatarEditTextView.this.tagAdapter;
                if (adelieAvatarTagAdapter2 != null) {
                    adelieAvatarTagAdapter2.notifyDataSetChanged();
                }
                if (s16 != null && yVar != null) {
                    yVar.a(s16);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r1 = r0.f366563d.editTextView;
             */
            @Override // h53.k
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void f8(boolean hasFocus) {
                InterceptTouchEditText interceptTouchEditText;
                if (!hasFocus && interceptTouchEditText != null) {
                    interceptTouchEditText.r();
                }
            }

            @Override // h53.k
            public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
                InterceptTouchEditText interceptTouchEditText;
                interceptTouchEditText = AdelieAvatarEditTextView.this.editTextView;
                if (interceptTouchEditText != null) {
                    final Context context2 = context;
                    if (interceptTouchEditText.getCurrentCount() > interceptTouchEditText.getCharacterLimitCount()) {
                        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView$textWatcher$1$onTextChanged$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                QQToast.makeText(context2, 0, "\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", 0).show();
                            }
                        });
                    }
                }
            }

            @Override // h53.k
            public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            }
        };
    }
}
