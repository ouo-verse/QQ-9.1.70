package com.tencent.mobileqq.aio.zhitu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.MainThread;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.aio.zhitu.InputRightIconUIState;
import com.tencent.mobileqq.aio.zhitu.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 72$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u00018B\u000f\u0012\u0006\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b6\u0010\"J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0018\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\"\u0010#\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010,R\u0016\u0010.\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/aio/zhitu/d;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "isGag", "", "j", "o", "Lcom/tencent/mobileqq/aio/zhitu/InputRightIconUIState$InputRightIconChangeVisibleState;", "state", "i", "f", "", "content", "g", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "binding", "p", "", "Ljava/lang/Class;", "getObserverStates", "k", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", h.F, "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "t", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mInputRoot", "Landroid/widget/ImageButton;", "Landroid/widget/ImageButton;", "mRightIcon", "mRightIconLayout", "Landroid/view/View;", "Landroid/view/View;", "mEditText", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Integer;", "mSavedVisibleState", "<init>", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Integer mSavedVisibleState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mInputRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageButton mRightIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mRightIconLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mEditText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/zhitu/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.zhitu.d$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
        }
    }

    private final void f(boolean state) {
        String qqStr;
        if (this.mRightIcon == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("InputRightIconVB", 2, "changeActivate: " + state);
        }
        ImageButton imageButton = this.mRightIcon;
        ImageButton imageButton2 = null;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightIcon");
            imageButton = null;
        }
        imageButton.setActivated(state);
        ImageButton imageButton3 = this.mRightIcon;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightIcon");
        } else {
            imageButton2 = imageButton3;
        }
        if (state) {
            qqStr = HardCodeUtil.qqStr(R.string.zo7);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.zo6);
        }
        imageButton2.setContentDescription(qqStr);
    }

    private final void g(boolean state, String content) {
        View view = null;
        if (state) {
            ViewGroup viewGroup = this.mRightIconLayout;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
                viewGroup = null;
            }
            if (viewGroup.getVisibility() == 8) {
                if (QLog.isColorLevel()) {
                    QLog.d("InputRightIconVB", 2, "showInputRightIcon");
                }
                ImageButton imageButton = this.mRightIcon;
                if (imageButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRightIcon");
                    imageButton = null;
                }
                imageButton.setContentDescription(HardCodeUtil.qqStr(R.string.zo6));
                ImageButton imageButton2 = this.mRightIcon;
                if (imageButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRightIcon");
                    imageButton2 = null;
                }
                Context context = this.mContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context = null;
                }
                imageButton2.setImageDrawable(context.getDrawable(R.drawable.f160145bd));
                ImageButton imageButton3 = this.mRightIcon;
                if (imageButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRightIcon");
                    imageButton3 = null;
                }
                imageButton3.setPadding(0, 0, 0, 0);
                ViewGroup viewGroup2 = this.mRightIconLayout;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
                    viewGroup2 = null;
                }
                viewGroup2.setVisibility(0);
                ViewGroup viewGroup3 = this.mRightIconLayout;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
                    viewGroup3 = null;
                }
                int width = viewGroup3.getWidth();
                if (width == 0) {
                    Context context2 = this.mContext;
                    if (context2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context2 = null;
                    }
                    width = BaseAIOUtils.f(37.0f, context2.getResources());
                }
                View view2 = this.mEditText;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    view2 = null;
                }
                if (view2.getPaddingRight() < width) {
                    View view3 = this.mEditText;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                        view3 = null;
                    }
                    View view4 = this.mEditText;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                        view4 = null;
                    }
                    int paddingLeft = view4.getPaddingLeft();
                    View view5 = this.mEditText;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                        view5 = null;
                    }
                    int paddingTop = view5.getPaddingTop();
                    View view6 = this.mEditText;
                    if (view6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    } else {
                        view = view6;
                    }
                    view3.setPadding(paddingLeft, paddingTop, width, view.getPaddingBottom());
                }
                HashMap hashMap = new HashMap();
                hashMap.put(EmotionReportDtImpl.TEXT_IN_TEXTBOX, content);
                com.tencent.mobileqq.aio.utils.b.q("em_aio_textbox_amazing_button", hashMap);
                return;
            }
            return;
        }
        if (!state) {
            ViewGroup viewGroup4 = this.mRightIconLayout;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
                viewGroup4 = null;
            }
            if (viewGroup4.getVisibility() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("InputRightIconVB", 2, "hideInputRightIcon");
                }
                ViewGroup viewGroup5 = this.mRightIconLayout;
                if (viewGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
                    viewGroup5 = null;
                }
                viewGroup5.setVisibility(8);
                com.tencent.mobileqq.aio.utils.b.f194119a.s("em_aio_textbox_amazing_button");
                View view7 = this.mEditText;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    view7 = null;
                }
                View view8 = this.mEditText;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    view8 = null;
                }
                int paddingLeft2 = view8.getPaddingLeft();
                View view9 = this.mEditText;
                if (view9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    view9 = null;
                }
                int paddingTop2 = view9.getPaddingTop();
                Context context3 = this.mContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context3 = null;
                }
                int f16 = BaseAIOUtils.f(11.0f, context3.getResources());
                View view10 = this.mEditText;
                if (view10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                } else {
                    view = view10;
                }
                view7.setPadding(paddingLeft2, paddingTop2, f16, view.getPaddingBottom());
            }
        }
    }

    private final void i(InputRightIconUIState.InputRightIconChangeVisibleState state) {
        if ((!state.b() && this.mRightIconLayout == null) || o()) {
            return;
        }
        l();
        g(state.b(), state.a());
    }

    private final void j(boolean isGag) {
        ViewGroup viewGroup = this.mRightIconLayout;
        ViewGroup viewGroup2 = null;
        Integer num = null;
        if (viewGroup == null) {
            if (isGag) {
                num = 8;
            }
            this.mSavedVisibleState = num;
            return;
        }
        if (isGag) {
            if (this.mSavedVisibleState == null) {
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
                    viewGroup = null;
                }
                this.mSavedVisibleState = Integer.valueOf(viewGroup.getVisibility());
            }
            ViewGroup viewGroup3 = this.mRightIconLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
            } else {
                viewGroup2 = viewGroup3;
            }
            viewGroup2.setVisibility(8);
            return;
        }
        if (this.mSavedVisibleState != null) {
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
                viewGroup = null;
            }
            Integer num2 = this.mSavedVisibleState;
            Intrinsics.checkNotNull(num2);
            viewGroup.setVisibility(num2.intValue());
            this.mSavedVisibleState = null;
        }
    }

    private final void l() {
        if (this.mRightIconLayout != null) {
            return;
        }
        Context context = this.mContext;
        ViewGroup viewGroup = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        LayoutInflater from = LayoutInflater.from(context);
        ViewGroup viewGroup2 = this.mInputRoot;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputRoot");
            viewGroup2 = null;
        }
        from.inflate(R.layout.dvd, viewGroup2, true);
        ViewGroup viewGroup3 = this.mInputRoot;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputRoot");
            viewGroup3 = null;
        }
        View findViewById = viewGroup3.findViewById(R.id.f164131kd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mInputRoot.findViewById(\u2026o_input_right_btn_layout)");
        ViewGroup viewGroup4 = (ViewGroup) findViewById;
        this.mRightIconLayout = viewGroup4;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
        } else {
            viewGroup = viewGroup4;
        }
        View findViewById2 = viewGroup.findViewById(R.id.f164130kc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRightIconLayout.findVie\u2026R.id.aio_input_right_btn)");
        this.mRightIcon = (ImageButton) findViewById2;
        m();
    }

    private final void m() {
        if (QLog.isColorLevel()) {
            QLog.d("InputRightIconVB", 2, "initView");
        }
        ViewGroup viewGroup = this.mRightIconLayout;
        ImageButton imageButton = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightIconLayout");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        ImageButton imageButton2 = this.mRightIcon;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightIcon");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.zhitu.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.n(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(d this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.s(new a.C7369a(it));
        EventCollector.getInstance().onViewClicked(it);
    }

    private final boolean o() {
        if (this.mSavedVisibleState != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            c.a.b(this);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) reuseParam);
        } else {
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
            this.mSavedVisibleState = null;
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar);
        }
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{InputRightIconUIState.InputRightIconChangeVisibleState.class, InputRightIconUIState.InputRightIconChangeActivateState.class, InputRightIconUIState.InputRightIconGagState.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof InputRightIconUIState.InputRightIconChangeVisibleState) {
            i((InputRightIconUIState.InputRightIconChangeVisibleState) state);
        } else if (state instanceof InputRightIconUIState.InputRightIconChangeActivateState) {
            f(((InputRightIconUIState.InputRightIconChangeActivateState) state).a());
        } else if (state instanceof InputRightIconUIState.InputRightIconGagState) {
            j(((InputRightIconUIState.InputRightIconGagState) state).a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            c.a.d(this);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.mContext = context;
        View findViewById = binding.getRoot().findViewById(R.id.input);
        Intrinsics.checkNotNullExpressionValue(findViewById, "binding.root.findViewById(R.id.input)");
        this.mEditText = findViewById;
        this.mInputRoot = binding.getRoot();
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void s(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }
}
