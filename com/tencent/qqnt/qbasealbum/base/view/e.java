package com.tencent.qqnt.qbasealbum.base.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.qqnt.qbasealbum.utils.MediaTypeHelper;
import com.tencent.qqnt.qbasealbum.utils.f;
import com.tencent.qqnt.qbasealbum.view.DownLoadingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0011\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ^\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u00102!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/view/e;", "Lcom/tencent/qqnt/qbasealbum/base/model/b;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localMedia", "", "P", "info", "U", "W", "T", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "O", "", "layoutPosition", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "onItemClick", "onItemSelect", "l", "progress", "H", "J", "I", BdhLogUtil.LogTag.Tag_Req, "N", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "", "Ljava/lang/String;", "gifPath", "itemView", "<init>", "(Landroid/view/View;)V", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class e extends com.tencent.qqnt.qbasealbum.base.model.b {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private SelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private String gifPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/view/e$a;", "", "", "ITEM_DOWNLOAD_ICON_WIDTH", "I", "ITEM_DOWNLOAD_PROGRESS_RADIUS", "SELECT_NUM_THRESHOLD", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.base.view.e$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(LocalMediaInfo localMedia, int i3, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(localMedia, "$localMedia");
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
        if (b16 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            b16.onItemClickEvent(it, localMedia, i3);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(LocalMediaInfo localMedia, Function1 onItemSelect, View it) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(localMedia, "$localMedia");
        Intrinsics.checkNotNullParameter(onItemSelect, "$onItemSelect");
        boolean z17 = false;
        if (localMedia.getSelectStatus() != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
        if (b16 != null && b16.checkMediaSelect(localMedia, z16, false)) {
            z17 = true;
        }
        if (z17) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            onItemSelect.invoke(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void P(LocalMediaInfo localMedia) {
        Q(localMedia);
        U(localMedia);
        W(localMedia);
        T(localMedia);
        I(localMedia);
        R(localMedia);
    }

    private final void Q(LocalMediaInfo info) {
        DownLoadingView r16 = r();
        if (r16 != null) {
            r16.setBgCorner(3.0f);
        }
        DownLoadingView r17 = r();
        if (r17 != null) {
            r17.setMinimumHeight(6);
        }
        DownLoadingView r18 = r();
        if (r18 != null) {
            r18.setMinimumWidth(6);
        }
        DownLoadingView r19 = r();
        if (r19 != null) {
            r19.setProgressSizeAndMode(16.0f, 6.0f, false);
        }
        DownLoadingView r26 = r();
        if (r26 != null) {
            r26.setBgColor(0);
        }
        DownLoadingView r27 = r();
        if (r27 != null) {
            r27.setProgressColor(-1);
        }
        DownLoadingView r28 = r();
        if (r28 != null) {
            r28.b(false);
        }
        ImageView m3 = m();
        if (m3 != null) {
            m3.setVisibility(8);
        }
        DownLoadingView r29 = r();
        if (r29 != null) {
            r29.setVisibility(8);
        }
    }

    private final void T(LocalMediaInfo info) {
        String str;
        Context context;
        if (MediaTypeHelper.f361628a.b(info)) {
            TextView p16 = p();
            if (p16 != null) {
                p16.setVisibility(0);
            }
            TextView p17 = p();
            if (p17 != null) {
                TextView p18 = p();
                if (p18 != null && (context = p18.getContext()) != null) {
                    str = context.getString(R.string.f1772033b);
                } else {
                    str = null;
                }
                p17.setText(str);
                return;
            }
            return;
        }
        TextView p19 = p();
        if (p19 != null) {
            p19.setVisibility(4);
        }
    }

    private final void U(LocalMediaInfo info) {
        boolean equals$default;
        J(info);
        if (MediaTypeHelper.f361628a.b(info)) {
            String str = this.gifPath;
            if (str != null) {
                equals$default = StringsKt__StringsJVMKt.equals$default(str, info.getPath(), false, 2, null);
                if (equals$default) {
                    return;
                }
            }
            this.gifPath = info.getPath();
        }
        ImageView q16 = q();
        if (q16 != null) {
            com.tencent.qqnt.qbasealbum.ktx.d.g(q16, info);
        }
    }

    private final void W(LocalMediaInfo info) {
        if (info.getMMediaType() == 0) {
            TextView v3 = v();
            if (v3 != null) {
                v3.setVisibility(4);
                return;
            }
            return;
        }
        TextView v16 = v();
        if (v16 != null) {
            v16.setVisibility(0);
        }
        TextView v17 = v();
        if (v17 != null) {
            v17.setText(f.f361654a.b(com.tencent.qqnt.qbasealbum.ktx.b.f(info)));
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.b
    public void H(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, progress);
            return;
        }
        DownLoadingView r16 = r();
        if (r16 != null) {
            r16.setProgress(progress);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.b
    public void I(@NotNull LocalMediaInfo info) {
        QUICheckBox s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getSelectStatus() == 1) {
            QUICheckBox s17 = s();
            if (s17 != null) {
                s17.setChecked(true);
            }
            int e16 = com.tencent.qqnt.qbasealbum.ktx.b.e(info);
            SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
            Intrinsics.checkNotNull(selectedMediaViewModel);
            int Q1 = e16 + selectedMediaViewModel.Q1() + 1;
            if (Q1 > 99) {
                QUICheckBox s18 = s();
                if (s18 != null) {
                    s18.setTextSize(2, 12.0f);
                }
            } else {
                QUICheckBox s19 = s();
                if (s19 != null) {
                    s19.setTextSize(2, 14.0f);
                }
            }
            QUICheckBox s26 = s();
            if (s26 != null) {
                s26.setText(String.valueOf(Q1));
            }
            View u16 = u();
            if (u16 != null) {
                u16.setVisibility(0);
            }
        } else {
            QUICheckBox s27 = s();
            if (s27 != null) {
                s27.setChecked(false);
            }
            QUICheckBox s28 = s();
            if (s28 != null) {
                s28.setText("");
            }
            View u17 = u();
            if (u17 != null) {
                u17.setVisibility(4);
            }
        }
        QUICheckBox s29 = s();
        if (s29 != null) {
            s29.setContentDescription(com.tencent.qqnt.qbasealbum.query.b.c(com.tencent.qqnt.qbasealbum.query.b.f361494a, info, null, 2, null));
        }
        if (AppSetting.f99565y && (s16 = s()) != null) {
            s16.sendAccessibilityEvent(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    @Override // com.tencent.qqnt.qbasealbum.base.model.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void J(@NotNull LocalMediaInfo info) {
        boolean z16;
        float f16;
        ImageView q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (com.tencent.qqnt.qbasealbum.ktx.b.h(info) == 0) {
            SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
            Intrinsics.checkNotNull(selectedMediaViewModel);
            if (selectedMediaViewModel.W1()) {
                z16 = false;
                float f17 = 1.0f;
                if (!z16) {
                    f16 = 0.3f;
                } else {
                    f16 = 1.0f;
                }
                if (info.getSelectStatus() != 1) {
                    f17 = f16;
                }
                q16 = q();
                if (q16 == null) {
                    q16.setAlpha(f17);
                    return;
                }
                return;
            }
        }
        z16 = true;
        float f172 = 1.0f;
        if (!z16) {
        }
        if (info.getSelectStatus() != 1) {
        }
        q16 = q();
        if (q16 == null) {
        }
    }

    public final void O(@NotNull SelectedMediaViewModel selectedMediaViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) selectedMediaViewModel);
        } else {
            Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
            this.selectedMediaViewModel = selectedMediaViewModel;
        }
    }

    public void R(@NotNull LocalMediaInfo info) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        ImageView o16 = o();
        if (o16 != null) {
            if (com.tencent.qqnt.qbasealbum.ktx.b.j(info)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            o16.setVisibility(i3);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.b
    public void l(@NotNull final LocalMediaInfo localMedia, final int layoutPosition, @NotNull Function1<? super View, Unit> onItemClick, @NotNull final Function1<? super View, Unit> onItemSelect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, localMedia, Integer.valueOf(layoutPosition), onItemClick, onItemSelect);
            return;
        }
        Intrinsics.checkNotNullParameter(localMedia, "localMedia");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onItemSelect, "onItemSelect");
        P(localMedia);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.base.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.M(LocalMediaInfo.this, layoutPosition, view);
            }
        });
        FrameLayout t16 = t();
        if (t16 != null) {
            t16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.base.view.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.N(LocalMediaInfo.this, onItemSelect, view);
                }
            });
        }
        this.itemView.setContentDescription(com.tencent.qqnt.qbasealbum.query.b.c(com.tencent.qqnt.qbasealbum.query.b.f361494a, localMedia, null, 2, null));
    }
}
