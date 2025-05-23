package com.tencent.mobileqq.troop.selectmember.part;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsetting.part.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.at.widget.IndexBar;
import com.tencent.qqnt.aio.at.widget.IndexBarTipsLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/TroopSelectMemberIndexPart;", "Lcom/tencent/mobileqq/troop/selectmember/part/a;", "Lcom/tencent/qqnt/aio/at/widget/IndexBar$a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "onInitView", "", "letter", "", "action", "", com.tencent.luggage.wxa.c8.c.G, "p1", "", "touching", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/at/widget/IndexBar;", "f", "Lcom/tencent/qqnt/aio/at/widget/IndexBar;", "indexView", "Lcom/tencent/qqnt/aio/at/widget/IndexBarTipsLayout;", h.F, "Lcom/tencent/qqnt/aio/at/widget/IndexBarTipsLayout;", "indexBarTipsLayout", "i", "Ljava/lang/String;", "preIndex", "Lkotlin/Lazy;", "getIndexViewTopMargin", "()I", "indexViewTopMargin", BdhLogUtil.LogTag.Tag_Conn, "getIndexTipTopMargin", "indexTipTopMargin", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberIndexPart extends a implements IndexBar.a {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy indexTipTopMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IndexBar indexView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IndexBarTipsLayout indexBarTipsLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String preIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy indexViewTopMargin;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/TroopSelectMemberIndexPart$a;", "", "", "MIN_SHOW_INDEX_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberIndexPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54887);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberIndexPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberIndexPart$indexViewTopMargin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberIndexPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(TroopSelectMemberIndexPart.this.getContext().getResources().getDimensionPixelOffset(R.dimen.dgy)) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.indexViewTopMargin = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberIndexPart$indexTipTopMargin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberIndexPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(TroopSelectMemberIndexPart.this.getContext().getResources().getDimensionPixelOffset(R.dimen.dgx)) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.indexTipTopMargin = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void H9(View rootView) {
        if (!x9().k()) {
            return;
        }
        this.indexView = (IndexBar) rootView.findViewById(R.id.djh);
        this.indexBarTipsLayout = (IndexBarTipsLayout) rootView.findViewById(R.id.dji);
        IndexBar indexBar = this.indexView;
        if (indexBar != null) {
            indexBar.setOnIndexBarTouchListener(this);
        }
        LifecycleOwner a16 = i.a(this);
        if (a16 != null) {
            LiveData<String[]> e26 = z9().e2();
            final Function1<String[], Unit> function1 = new Function1<String[], Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberIndexPart$initIndexView$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberIndexPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
                    invoke2(strArr);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String[] strArr) {
                    IndexBar indexBar2;
                    IndexBarTipsLayout indexBarTipsLayout;
                    IndexBar indexBar3;
                    IndexBar indexBar4;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
                        return;
                    }
                    if (strArr.length > 1) {
                        indexBar3 = TroopSelectMemberIndexPart.this.indexView;
                        if (indexBar3 != null) {
                            indexBar3.setLetters(strArr);
                        }
                        indexBar4 = TroopSelectMemberIndexPart.this.indexView;
                        if (indexBar4 == null) {
                            return;
                        }
                        indexBar4.setVisibility(0);
                        return;
                    }
                    indexBar2 = TroopSelectMemberIndexPart.this.indexView;
                    if (indexBar2 != null) {
                        indexBar2.setVisibility(8);
                    }
                    indexBarTipsLayout = TroopSelectMemberIndexPart.this.indexBarTipsLayout;
                    if (indexBarTipsLayout == null) {
                        return;
                    }
                    indexBarTipsLayout.setVisibility(8);
                }
            };
            e26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberIndexPart.I9(Function1.this, obj);
                }
            });
            LiveData<Integer> d26 = z9().d2();
            final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberIndexPart$initIndexView$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberIndexPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    IndexBar indexBar2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    indexBar2 = TroopSelectMemberIndexPart.this.indexView;
                    if (indexBar2 != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        indexBar2.setChooseIndex(it.intValue());
                    }
                }
            };
            d26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberIndexPart.J9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.qqnt.aio.at.widget.IndexBar.a
    public void m(boolean touching) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, touching);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("TroopSelectMemberFrag.IndexPart", 4, "[onLetterTouching] touching:" + touching);
        }
        if (!touching) {
            this.preIndex = null;
        }
        IndexBarTipsLayout indexBarTipsLayout = this.indexBarTipsLayout;
        if (indexBarTipsLayout != null) {
            if (touching) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            indexBarTipsLayout.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            H9(rootView);
        }
    }

    @Override // com.tencent.qqnt.aio.at.widget.IndexBar.a
    public void p1(@Nullable String letter, int action, float pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, letter, Integer.valueOf(action), Float.valueOf(pos));
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("TroopSelectMemberFrag.IndexPart", 4, "[onLetterChanged] letter:" + letter + ". action:" + action + ", pos:" + pos);
        }
        IndexBarTipsLayout indexBarTipsLayout = this.indexBarTipsLayout;
        if (indexBarTipsLayout != null) {
            indexBarTipsLayout.setText(letter, pos);
        }
        if (!Intrinsics.areEqual(this.preIndex, letter)) {
            this.preIndex = letter;
            if (letter != null) {
                z9().v2(letter);
            }
        }
    }
}
