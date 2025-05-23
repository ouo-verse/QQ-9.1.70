package c44;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import c44.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.draw.title.DrawTitleUIState;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.widget.Switch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006:\u0001<B\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\u001b\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J \u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0019H\u0016J \u0010 \u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016R\u0014\u0010#\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0018\u00102\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u0018\u00104\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010)R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lc44/g;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "Lc44/a;", "Lcom/tencent/robot/draw/title/DrawTitleUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "Lcom/tencent/robot/draw/title/DrawTitleUIState$TitleBannerState;", "state", "", "i1", "m1", "Landroid/content/Context;", "context", "", "tipsContent", "Landroid/view/View;", "anchor", "p1", "Landroid/graphics/LinearGradient;", "h1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "l1", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", "e", "Z", "mNeedRegisterHeightProviderCallback", "f", "Landroid/view/View;", "mContainer", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mAvatarIv", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mNameTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mReviseIv", BdhLogUtil.LogTag.Tag_Conn, "mReviseTv", "D", "mQuestionIv", "Lcom/tencent/widget/Switch;", "E", "Lcom/tencent/widget/Switch;", "mSwitch", "<init>", "(Z)V", UserInfo.SEX_FEMALE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g extends SlashDialogVB<a, DrawTitleUIState, w64.e<u54.c>> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mReviseTv;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView mQuestionIv;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Switch mSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mNeedRegisterHeightProviderCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mAvatarIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mNameTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mReviseIv;

    public g() {
        this(false, 1, null);
    }

    private final LinearGradient h1() {
        int i3;
        TextView textView = this.mReviseTv;
        if (textView != null) {
            i3 = textView.getMeasuredWidth();
        } else {
            i3 = 0;
        }
        return new LinearGradient(0.0f, 0.0f, i3, 0.0f, Color.parseColor("#F096FF"), Color.parseColor("#428FFE"), Shader.TileMode.CLAMP);
    }

    private final void i1(final DrawTitleUIState.TitleBannerState state) {
        String url;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable("https://static-res.qq.com/static-res/ai_draw/aidrawicon.png", obtain);
        drawable.setColorFilter(new PorterDuffColorFilter(getMContext().getColor(R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_IN));
        ImageView imageView = this.mAvatarIv;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        TextView textView = this.mNameTv;
        if (textView != null) {
            textView.setText(getMContext().getString(R.string.f223426g7));
        }
        TextView textView2 = this.mNameTv;
        if (textView2 != null) {
            textView2.setTextColor(getMContext().getColor(R.color.qui_common_text_primary));
        }
        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
        obtain2.mLoadingDrawable = new ColorDrawable(0);
        obtain2.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable2 = URLDrawable.getDrawable("https://static-res.qq.com/static-res/ai_draw/revise_icon.png", obtain2);
        ImageView imageView2 = this.mReviseIv;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable2);
        }
        TextView textView3 = this.mReviseTv;
        if (textView3 != null) {
            textView3.setText(state.getTitle());
        }
        TextView textView4 = this.mReviseTv;
        if (textView4 != null) {
            textView4.post(new Runnable() { // from class: c44.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.j1(g.this);
                }
            });
        }
        if (TextUtils.isEmpty(state.getUrl())) {
            url = "https://static-res.qq.com/static-res/ai_draw/quesion_mark.png";
        } else {
            url = state.getUrl();
        }
        URLDrawable.URLDrawableOptions obtain3 = URLDrawable.URLDrawableOptions.obtain();
        obtain3.mLoadingDrawable = new ColorDrawable(0);
        obtain3.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable3 = URLDrawable.getDrawable(url, obtain3);
        ImageView imageView3 = this.mQuestionIv;
        if (imageView3 != null) {
            imageView3.setImageDrawable(drawable3);
        }
        ImageView imageView4 = this.mQuestionIv;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: c44.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.k1(g.this, state, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(g this$0) {
        TextPaint textPaint;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mReviseTv;
        if (textView != null) {
            textPaint = textView.getPaint();
        } else {
            textPaint = null;
        }
        if (textPaint != null) {
            textPaint.setShader(this$0.h1());
        }
        TextView textView2 = this$0.mReviseTv;
        if (textView2 != null) {
            textView2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(g this$0, DrawTitleUIState.TitleBannerState state, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        Context context = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        String tips = state.getTips();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.p1(context, tips, it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void m1() {
        final MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(getMContext().getApplicationContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(mContext.applicat\u2026t, QMMKVFile.FILE_COMMON)");
        boolean z16 = fromV2.getBoolean("robot_ai_draw_revise_switch", true);
        Switch r26 = this.mSwitch;
        if (r26 != null) {
            r26.setChecked(z16);
        }
        Switch r16 = this.mSwitch;
        if (r16 != null) {
            r16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c44.e
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                    g.n1(MMKVOptionEntityV2.this, this, compoundButton, z17);
                }
            });
        }
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setTrackResource(R.drawable.lil);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(MMKVOptionEntityV2 entity, g this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("DrawTitleVB", 2, "onCheckedChanged isChecked = " + z16);
        }
        entity.putBoolean("robot_ai_draw_revise_switch", z16);
        this$0.sendIntent(new a.OnSwitchChanged(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.b.f30276d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p1(Context context, String tipsContent, View anchor) {
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        int b16 = cVar.b(10);
        int b17 = cVar.b(8);
        final TextView textView = new TextView(context);
        textView.setText(tipsContent);
        textView.setTextSize(14.0f);
        textView.setTextColor(-16777216);
        textView.setPadding(b16, b17, b16, b17);
        textView.setMaxWidth(cVar.b(160));
        final com.tencent.qqnt.aio.widget.a aVar = new com.tencent.qqnt.aio.widget.a(context, textView);
        int b18 = cVar.b(-78);
        aVar.i(-1);
        aVar.f(anchor);
        aVar.g(b18, 0);
        aVar.j();
        textView.post(new Runnable() { // from class: c44.f
            @Override // java.lang.Runnable
            public final void run() {
                g.q1(textView, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(TextView textView, com.tencent.qqnt.aio.widget.a bubbleTip) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(bubbleTip, "$bubbleTip");
        bubbleTip.h(textView.getMeasuredWidth() - com.tencent.qqnt.base.utils.c.f353052a.b(81));
        bubbleTip.j();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, DrawTitleUIState, w64.e<u54.c>> createVM() {
        return new h(this.mNeedRegisterHeightProviderCallback);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull DrawTitleUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof DrawTitleUIState.TitleBannerState) {
            i1((DrawTitleUIState.TitleBannerState) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View inflate = LayoutInflater.from(createViewParams.a()).inflate(R.layout.f168856h24, createViewParams.b(), false);
        this.mContainer = inflate;
        if (inflate != null) {
            this.mAvatarIv = (ImageView) inflate.findViewById(R.id.f7661425);
            this.mNameTv = (TextView) inflate.findViewById(R.id.f7662426);
            this.mReviseIv = (ImageView) inflate.findViewById(R.id.f7664428);
            this.mReviseTv = (TextView) inflate.findViewById(R.id.f7665429);
            this.mQuestionIv = (ImageView) inflate.findViewById(R.id.f7663427);
            this.mSwitch = (Switch) inflate.findViewById(R.id.f766642_);
            inflate.setBackgroundColor(createViewParams.a().getColor(R.color.qui_common_bg_middle_light));
            inflate.setOnClickListener(new View.OnClickListener() { // from class: c44.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.o1(g.this, view);
                }
            });
            m1();
        }
        View view = this.mContainer;
        Intrinsics.checkNotNull(view);
        return view;
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return (int) y64.a.a(getMContext(), 44);
    }

    public /* synthetic */ g(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public g(boolean z16) {
        this.mNeedRegisterHeightProviderCallback = z16;
    }
}
