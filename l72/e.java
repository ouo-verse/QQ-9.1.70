package l72;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.aio.input.QQStrangerInputBarUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import l72.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\b\u0006*\u00010\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b4\u0010\u001cJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00140\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\"\u0010\u001d\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010(R\u0016\u0010+\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00065"}, d2 = {"Ll72/e;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "showAssistedChat", "", h.F, "k", "t", "Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState$UpdateIconState;", "state", ReportConstant.COSTREPORT_PREFIX, "binding", DomainData.DOMAIN_NAME, "a", "", "Ljava/lang/Class;", "getObserverStates", "j", "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "i", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "r", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "rightLayout", "Landroid/widget/ImageButton;", "Landroid/widget/ImageButton;", "emoticonBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "assistedChatBtn", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/CharSequence;", "inputHint", "l72/e$a", "D", "Ll72/e$a;", "widgetCreator", "<init>", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: C, reason: from kotlin metadata */
    private CharSequence inputHint;

    /* renamed from: D, reason: from kotlin metadata */
    private final a widgetCreator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout rightLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageButton emoticonBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageButton assistedChatBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000b"}, d2 = {"l72/e$a", "", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/ImageButton;", "b", "a", "", "d", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a {
        a() {
        }

        public final ImageButton a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ImageButton imageButton = new ImageButton(context);
            imageButton.setId(R.id.okd);
            int d16 = d();
            imageButton.setLayoutParams(new LinearLayout.LayoutParams(d16, d16));
            imageButton.setBackgroundResource(R.drawable.j5j);
            imageButton.setContentDescription(context.getString(R.string.f197474k4));
            return imageButton;
        }

        public final ImageButton b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ImageButton imageButton = new ImageButton(context);
            imageButton.setId(R.id.oke);
            int d16 = d();
            imageButton.setLayoutParams(new LinearLayout.LayoutParams(d16, d16));
            imageButton.setBackgroundResource(R.drawable.j6a);
            imageButton.setContentDescription(context.getString(R.string.f171479f73));
            return imageButton;
        }

        public final LinearLayout c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setId(R.id.okf);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.rightToRight = 0;
            layoutParams.bottomToBottom = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ViewUtils.dpToPx(16.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (linearLayout.getResources().getDimensionPixelSize(R.dimen.cjj) - d()) / 2;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(0);
            linearLayout.setShowDividers(2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            gradientDrawable.setSize(ViewUtils.dpToPx(12.0f), 1);
            linearLayout.setDividerDrawable(gradientDrawable);
            return linearLayout;
        }

        public final int d() {
            Context context = e.this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            return context.getResources().getDimensionPixelSize(R.dimen.act);
        }
    }

    public e(com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.widgetCreator = new a();
    }

    private final void h(boolean showAssistedChat) {
        if (this.rightLayout == null) {
            k();
        }
        t();
        ImageButton imageButton = this.assistedChatBtn;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatBtn");
            imageButton = null;
        }
        imageButton.setVisibility(showAssistedChat ? 0 : 8);
    }

    private final void k() {
        a aVar = this.widgetCreator;
        Context context = this.context;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        this.rightLayout = aVar.c(context);
        a aVar3 = this.widgetCreator;
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        ImageButton b16 = aVar3.b(context2);
        this.emoticonBtn = b16;
        if (b16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonBtn");
            b16 = null;
        }
        b16.setOnClickListener(new View.OnClickListener() { // from class: l72.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.l(e.this, view);
            }
        });
        a aVar4 = this.widgetCreator;
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context3 = null;
        }
        ImageButton a16 = aVar4.a(context3);
        this.assistedChatBtn = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatBtn");
            a16 = null;
        }
        a16.setOnClickListener(new View.OnClickListener() { // from class: l72.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.m(e.this, view);
            }
        });
        LinearLayout linearLayout = this.rightLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
            linearLayout = null;
        }
        ImageButton imageButton = this.emoticonBtn;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonBtn");
            imageButton = null;
        }
        linearLayout.addView(imageButton);
        LinearLayout linearLayout2 = this.rightLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
            linearLayout2 = null;
        }
        ImageButton imageButton2 = this.assistedChatBtn;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatBtn");
            imageButton2 = null;
        }
        linearLayout2.addView(imageButton2);
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar5 = this.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar5 = null;
        }
        ConstraintLayout root = aVar5.getRoot();
        LinearLayout linearLayout3 = this.rightLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
            linearLayout3 = null;
        }
        root.addView(linearLayout3);
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar6 = this.binding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar6 = null;
        }
        ViewGroup.LayoutParams layoutParams = aVar6.a().getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.rightToLeft = R.id.okf;
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar7 = this.binding;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar2 = aVar7;
            }
            aVar2.a().setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p(new b.OnEmoticonClick(view.isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(e this$0, View view) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("operation_entry", com.tencent.mobileqq.aio.utils.b.f194119a.f(1014)));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_input_box_shortcut_bar", mapOf);
        this$0.p(new b.OnAssistedChatClick(view.isSelected()));
    }

    private final void s(QQStrangerInputBarUIState.UpdateIconState state) {
        ImageButton imageButton = this.emoticonBtn;
        ImageButton imageButton2 = null;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonBtn");
            imageButton = null;
        }
        imageButton.setSelected(state.getEmoticonSelected());
        ImageButton imageButton3 = this.assistedChatBtn;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatBtn");
        } else {
            imageButton2 = imageButton3;
        }
        imageButton2.setSelected(state.getAssistedChatSelected());
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
    
        if ((r0.length() > 0) == true) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void t() {
        boolean z16;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.binding;
        LinearLayout linearLayout = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        Editable text = aVar.a().getText();
        boolean z17 = true;
        if (text != null) {
            if (text.length() > 0) {
                z16 = true;
                if (!z16) {
                    CharSequence charSequence = this.inputHint;
                    if (charSequence != null && charSequence.length() != 0) {
                        z17 = false;
                    }
                    if (z17) {
                        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.binding;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            aVar2 = null;
                        }
                        this.inputHint = aVar2.a().getHint();
                    }
                    com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.binding;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        aVar3 = null;
                    }
                    aVar3.a().setHint("");
                    com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.binding;
                    if (aVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        aVar4 = null;
                    }
                    aVar4.d().setVisibility(0);
                    LinearLayout linearLayout2 = this.rightLayout;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
                        linearLayout2 = null;
                    }
                    ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
                    ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 != null) {
                        layoutParams2.rightToLeft = R.id.send_btn;
                        layoutParams2.rightToRight = -1;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = ViewUtils.dpToPx(12.0f);
                        LinearLayout linearLayout3 = this.rightLayout;
                        if (linearLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
                        } else {
                            linearLayout = linearLayout3;
                        }
                        linearLayout.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                CharSequence charSequence2 = this.inputHint;
                if (charSequence2 != null) {
                }
                z17 = false;
                if (z17) {
                    com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar5 = this.binding;
                    if (aVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        aVar5 = null;
                    }
                    aVar5.a().setHint(this.inputHint);
                }
                com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar6 = this.binding;
                if (aVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    aVar6 = null;
                }
                aVar6.d().setVisibility(8);
                LinearLayout linearLayout4 = this.rightLayout;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
                    linearLayout4 = null;
                }
                ViewGroup.LayoutParams layoutParams3 = linearLayout4.getLayoutParams();
                ConstraintLayout.LayoutParams layoutParams4 = layoutParams3 instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams3 : null;
                if (layoutParams4 != null) {
                    layoutParams4.rightToLeft = -1;
                    layoutParams4.rightToRight = 0;
                    ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = ViewUtils.dpToPx(16.0f);
                    LinearLayout linearLayout5 = this.rightLayout;
                    if (linearLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
                    } else {
                        linearLayout = linearLayout5;
                    }
                    linearLayout.setLayoutParams(layoutParams4);
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
        p(b.a.f413909d);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(com.tencent.mvi.api.help.b bVar) {
        c.a.e(this, bVar);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void accept(InputUIState inputUIState) {
        c.a.a(this, inputUIState);
    }

    @Override // com.tencent.mvi.api.ability.c
    public Bundle generateVBState(com.tencent.mvi.api.ability.d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: i, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleUIState(InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof QQStrangerInputBarUIState.DisplayInputBar) {
            h(((QQStrangerInputBarUIState.DisplayInputBar) state).getShowAssistedChat());
        } else if (state instanceof QQStrangerInputBarUIState.UpdateSendBtnState) {
            t();
        } else if (state instanceof QQStrangerInputBarUIState.UpdateIconState) {
            s((QQStrangerInputBarUIState.UpdateIconState) state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.context = context;
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void p(at.a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void L0(com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }

    @Override // com.tencent.input.base.mvicompat.c
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{QQStrangerInputBarUIState.UpdateSendBtnState.class, QQStrangerInputBarUIState.DisplayInputBar.class, QQStrangerInputBarUIState.UpdateIconState.class});
        return listOf;
    }
}
