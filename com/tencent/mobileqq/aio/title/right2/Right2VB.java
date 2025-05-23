package com.tencent.mobileqq.aio.title.right2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.title.ag;
import com.tencent.mobileqq.aio.title.right2.Right2UIState;
import com.tencent.mobileqq.aio.title.right2.a;
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170'\u00a2\u0006\u0004\b)\u0010*J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0019H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u001b\u0010#\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/title/right2/Right2VB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/right2/a;", "Lcom/tencent/mobileqq/aio/title/right2/Right2UIState;", "", "width", "height", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "j1", "", "isSelectMode", "f1", "Lcom/tencent/mobileqq/aio/title/ag;", "data", "k1", "visiable", "", "type", "i1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Lcom/tencent/mobileqq/aio/widget/RedDotImageView;", "h1", "Lcom/tencent/aio/base/mvvm/b;", "d1", "bindViewAndData", "state", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lkotlin/Lazy;", "e1", "()Lcom/tencent/mobileqq/aio/widget/RedDotImageView;", "right2Iv", "e", "Ljava/lang/String;", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "Lkotlin/Function0;", "get", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class Right2VB extends com.tencent.aio.base.mvvm.a<a, Right2UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy right2Iv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String busiType;

    public Right2VB(@NotNull final Function0<? extends RedDotImageView> get) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(get, "get");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<RedDotImageView>(get) { // from class: com.tencent.mobileqq.aio.title.right2.Right2VB$right2Iv$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function0<RedDotImageView> $get;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                    this.$get = get;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) get);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final RedDotImageView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.$get.invoke() : (RedDotImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.right2Iv = lazy;
            this.busiType = "";
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) get);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(Right2VB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.C7365a.f194025d);
        HashMap hashMap = new HashMap();
        hashMap.put("aio_right_business_type", com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_top_feature_entry_right", ""));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_top_feature_entry_right", hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final RedDotImageView e1() {
        return (RedDotImageView) this.right2Iv.getValue();
    }

    private final void f1(boolean isSelectMode) {
        Integer num;
        if (isSelectMode) {
            i1(false, this.busiType);
            e1().setTag(Integer.valueOf(e1().getVisibility()));
            e1().setVisibility(8);
            return;
        }
        Object tag = e1().getTag();
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            i1(Intrinsics.areEqual(e1().getTag(), (Object) 0), this.busiType);
            e1().setVisibility(intValue);
        }
    }

    private final void i1(boolean visiable, String type) {
        if (visiable) {
            HashMap hashMap = new HashMap();
            hashMap.put("aio_right_business_type", type);
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_top_feature_entry_right", hashMap);
        } else if (e1().getVisibility() == 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("aio_right_business_type", type);
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_top_feature_entry_right", hashMap2);
        }
    }

    private final void j1(int width, int height, ImageView.ScaleType scaleType) {
        RedDotImageView e16 = e1();
        e16.setScaleType(scaleType);
        ViewGroup.LayoutParams layoutParams = e16.getLayoutParams();
        if (layoutParams != null) {
            Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
            layoutParams.width = width;
            layoutParams.height = height;
        }
        e16.requestLayout();
    }

    private final void k1(ag data) {
        boolean z16;
        int i3 = 0;
        if (data.e() && !data.f() && data.c() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        String d16 = data.d();
        this.busiType = d16;
        i1(z16, d16);
        RedDotImageView e16 = e1();
        if (!z16) {
            i3 = 8;
        }
        e16.setVisibility(i3);
        int a16 = data.a();
        if (a16 != 1) {
            if (a16 != 2) {
                if (a16 == 3) {
                    e1().setContentDescription(HardCodeUtil.qqStr(R.string.f170302yu3));
                }
            } else {
                e1().setContentDescription(HardCodeUtil.qqStr(R.string.f170299yu0));
            }
        } else {
            e1().setContentDescription(HardCodeUtil.qqStr(R.string.ytz));
        }
        if (data.c() != null) {
            e1().setImageDrawable(data.c());
        }
        e1().setShowRedDot(data.b());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.bindViewAndData();
        e1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.right2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Right2VB.c1(Right2VB.this, view);
            }
        });
        j1(-2, -2, ImageView.ScaleType.CENTER);
        sendIntent(a.b.f194026d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, Right2UIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull Right2UIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof Right2UIState.UpdateDataUIState) {
            k1(((Right2UIState.UpdateDataUIState) state).a());
            return;
        }
        if (state instanceof Right2UIState.UpdateRight2IvScaleType) {
            Right2UIState.UpdateRight2IvScaleType updateRight2IvScaleType = (Right2UIState.UpdateRight2IvScaleType) state;
            j1(updateRight2IvScaleType.c(), updateRight2IvScaleType.a(), updateRight2IvScaleType.b());
        } else if (state instanceof Right2UIState.MultiSelectModeChangeState) {
            f1(((Right2UIState.MultiSelectModeChangeState) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public RedDotImageView onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RedDotImageView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return e1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        i1(false, this.busiType);
        this.busiType = "";
    }
}
