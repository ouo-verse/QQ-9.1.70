package com.tencent.qqnt.qbasealbum.album.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0005\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0018R\u0018\u0010+\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001eR\u0018\u0010-\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u0018R\u0018\u0010/\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010$R\u0018\u00101\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010$R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/QAlbumModeRadioGroup;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "", "b", "", "mode", "a", "", "isFullMode", "d", "", "eid", "Landroid/view/View;", "clickView", "c", "view", NodeProps.ON_CLICK, "Z", "hideBottomTextView", "e", "Landroid/view/View;", "rootLayout", "f", "Landroid/widget/LinearLayout;", "mContainer", tl.h.F, "mFullModeLayout", "Landroid/widget/RadioButton;", "i", "Landroid/widget/RadioButton;", "mFullModeBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mFullModeTextLayout", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mFullModeTextOne", "D", "mFullModeTextTwo", "E", "mHalfModeLayout", UserInfo.SEX_FEMALE, "mHalfModeBtn", "G", "mHalfModeTextLayout", "H", "mHalfModeTextOne", "I", "mHalfModeTextTwo", "Landroid/graphics/drawable/Drawable;", "J", "Landroid/graphics/drawable/Drawable;", "mSelectDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyleAttr", "<init>", "(Landroid/content/Context;ZLandroid/util/AttributeSet;I)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QAlbumModeRadioGroup extends LinearLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mFullModeTextOne;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView mFullModeTextTwo;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mHalfModeLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RadioButton mHalfModeBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mHalfModeTextLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mHalfModeTextOne;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView mHalfModeTextTwo;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Drawable mSelectDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean hideBottomTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View rootLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mFullModeLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RadioButton mFullModeBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mFullModeTextLayout;

    public /* synthetic */ QAlbumModeRadioGroup(Context context, boolean z16, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z16, (i16 & 4) != 0 ? null : attributeSet, (i16 & 8) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    private final void a(int mode) {
        com.tencent.qqnt.qbasealbum.utils.a aVar = com.tencent.qqnt.qbasealbum.utils.a.f361642a;
        aVar.e(mode);
        aVar.g();
    }

    private final void b() {
        View inflate = View.inflate(getContext(), R.layout.fti, this.mContainer);
        this.mFullModeLayout = (LinearLayout) inflate.findViewById(R.id.vgk);
        this.mFullModeBtn = (RadioButton) inflate.findViewById(R.id.vgj);
        this.mFullModeTextLayout = (LinearLayout) inflate.findViewById(R.id.vgl);
        this.mFullModeTextOne = (TextView) inflate.findViewById(R.id.vgm);
        this.mFullModeTextTwo = (TextView) inflate.findViewById(R.id.vgn);
        this.mHalfModeLayout = (LinearLayout) inflate.findViewById(R.id.x5i);
        this.mHalfModeBtn = (RadioButton) inflate.findViewById(R.id.x5h);
        this.mHalfModeTextLayout = (LinearLayout) inflate.findViewById(R.id.x5j);
        this.mHalfModeTextOne = (TextView) inflate.findViewById(R.id.x5k);
        this.mHalfModeTextTwo = (TextView) inflate.findViewById(R.id.x5l);
        LinearLayout linearLayout = this.mFullModeLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        LinearLayout linearLayout2 = this.mHalfModeLayout;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(this);
        }
        RadioButton radioButton = this.mFullModeBtn;
        if (radioButton != null) {
            radioButton.setOnClickListener(this);
        }
        RadioButton radioButton2 = this.mHalfModeBtn;
        if (radioButton2 != null) {
            radioButton2.setOnClickListener(this);
        }
        boolean z16 = true;
        if (com.tencent.qqnt.qbasealbum.utils.a.f361642a.a() != 1) {
            z16 = false;
        }
        d(z16);
    }

    private final void c(String eid, View clickView) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(clickView, eid);
        VideoReport.reportEvent("dt_clck", clickView, hashMap);
    }

    private final void d(boolean isFullMode) {
        if (isFullMode) {
            RadioButton radioButton = this.mFullModeBtn;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            LinearLayout linearLayout = this.mFullModeTextLayout;
            if (linearLayout != null) {
                linearLayout.setBackground(this.mSelectDrawable);
            }
            TextView textView = this.mFullModeTextOne;
            if (textView != null) {
                textView.setTextColor(getContext().getColor(R.color.qui_common_brand_standard));
            }
            TextView textView2 = this.mFullModeTextTwo;
            if (textView2 != null) {
                textView2.setTextColor(getContext().getColor(R.color.qui_common_brand_standard));
            }
            RadioButton radioButton2 = this.mHalfModeBtn;
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            LinearLayout linearLayout2 = this.mHalfModeTextLayout;
            if (linearLayout2 != null) {
                linearLayout2.setBackground(null);
            }
            TextView textView3 = this.mHalfModeTextOne;
            if (textView3 != null) {
                textView3.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
            }
            TextView textView4 = this.mHalfModeTextTwo;
            if (textView4 != null) {
                textView4.setTextColor(getContext().getColor(R.color.qui_common_text_secondary));
                return;
            }
            return;
        }
        RadioButton radioButton3 = this.mFullModeBtn;
        if (radioButton3 != null) {
            radioButton3.setChecked(false);
        }
        LinearLayout linearLayout3 = this.mFullModeTextLayout;
        if (linearLayout3 != null) {
            linearLayout3.setBackground(null);
        }
        TextView textView5 = this.mFullModeTextOne;
        if (textView5 != null) {
            textView5.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        TextView textView6 = this.mFullModeTextTwo;
        if (textView6 != null) {
            textView6.setTextColor(getContext().getColor(R.color.qui_common_text_secondary));
        }
        RadioButton radioButton4 = this.mHalfModeBtn;
        if (radioButton4 != null) {
            radioButton4.setChecked(true);
        }
        LinearLayout linearLayout4 = this.mHalfModeTextLayout;
        if (linearLayout4 != null) {
            linearLayout4.setBackground(this.mSelectDrawable);
        }
        TextView textView7 = this.mHalfModeTextOne;
        if (textView7 != null) {
            textView7.setTextColor(getContext().getColor(R.color.qui_common_brand_standard));
        }
        TextView textView8 = this.mHalfModeTextTwo;
        if (textView8 != null) {
            textView8.setTextColor(getContext().getColor(R.color.qui_common_brand_standard));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Integer num;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            if (view != null) {
                num = Integer.valueOf(view.getId());
            } else {
                num = null;
            }
            boolean z17 = true;
            if ((num != null && num.intValue() == R.id.vgj) || (num != null && num.intValue() == R.id.vgk)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                d(true);
                a(1);
                LinearLayout linearLayout = this.mFullModeLayout;
                if (linearLayout != null) {
                    c("em_bas_send_full_screen_picture", linearLayout);
                }
            } else {
                if ((num == null || num.intValue() != R.id.x5h) && (num == null || num.intValue() != R.id.x5i)) {
                    z17 = false;
                }
                if (z17) {
                    d(false);
                    a(2);
                    LinearLayout linearLayout2 = this.mHalfModeLayout;
                    if (linearLayout2 != null) {
                        c("em_bas_half_screen_print", linearLayout2);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QAlbumModeRadioGroup(@NotNull Context context, boolean z16, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16), attributeSet, Integer.valueOf(i3));
            return;
        }
        this.hideBottomTextView = z16;
        View inflate = View.inflate(context, R.layout.fth, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026bum_mode_container, this)");
        this.rootLayout = inflate;
        View findViewById = inflate.findViewById(R.id.sl7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootLayout.findViewById(\u2026de_radio_group_container)");
        this.mContainer = (LinearLayout) findViewById;
        this.mSelectDrawable = context.getDrawable(R.drawable.k8u);
        b();
        if (z16) {
            ((TextView) this.rootLayout.findViewById(R.id.sl6)).setVisibility(8);
        }
    }
}
