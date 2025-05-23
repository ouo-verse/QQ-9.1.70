package com.tencent.qqnt.pluspanel.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.util.TokenResUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u001f\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0014\u0010\u0019\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/pluspanel/adapter/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/pluspanel/adapter/f;", "holder", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "", "l0", "k0", "i0", "", "position", "j0", "color", "", "coefficient", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "n0", "getItemCount", "", "appDataList", "p0", "", "isAobotAIO", "q0", "Landroid/view/View$OnClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnClickListener;", "mItemOnclickListener", "Landroid/view/View$OnLongClickListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnLongClickListener;", "mItemOnLongClickListener", "", "D", "Ljava/lang/String;", "elementId", "E", "Z", "isRobotAIO", UserInfo.SEX_FEMALE, "Ljava/util/List;", "Landroid/content/Context;", "G", "Landroid/content/Context;", "context", "<init>", "(Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Ljava/lang/String;)V", "H", "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d extends RecyclerView.Adapter<f> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View.OnLongClickListener mItemOnLongClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String elementId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isRobotAIO;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.qqnt.pluspanel.data.a> appDataList;

    /* renamed from: G, reason: from kotlin metadata */
    private Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener mItemOnclickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/pluspanel/adapter/d$a;", "", "", "COLUMN_NUM", "I", "COMMON_ICON_HEIGHT", "COMMON_ICON_TEXT_MARGIN", "COMMON_TEXT_HEIGHT", "COMMON_TOP_MARGIN", "RADIO_BTN_HEIGHT_DP", "ROW_NUM", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.adapter.d$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull View.OnClickListener mItemOnclickListener, @NotNull View.OnLongClickListener mItemOnLongClickListener, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(mItemOnclickListener, "mItemOnclickListener");
        Intrinsics.checkNotNullParameter(mItemOnLongClickListener, "mItemOnLongClickListener");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mItemOnclickListener, mItemOnLongClickListener, elementId);
            return;
        }
        this.mItemOnclickListener = mItemOnclickListener;
        this.mItemOnLongClickListener = mItemOnLongClickListener;
        this.elementId = elementId;
        this.appDataList = new ArrayList();
    }

    private final void i0(f holder, com.tencent.qqnt.pluspanel.data.a data) {
        holder.l().setVisibility(0);
        holder.l().setBackgroundDrawable(data.e());
        if (data.e() instanceof URLDrawable) {
            Drawable e16 = data.e();
            Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.image.URLDrawable");
            URLDrawable uRLDrawable = (URLDrawable) e16;
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
        }
    }

    private final void j0(f holder, int position) {
        int dpToPx;
        int dpToPx2;
        float f16;
        if (TokenResUtils.aioPlusIconNewStyle() && !this.isRobotAIO && !QQTheme.isNowSimpleUI()) {
            if (TokenResUtils.fixAioScaleSwitchOn()) {
                f16 = 0.0f;
            } else {
                f16 = 8.0f;
            }
            dpToPx2 = ViewUtils.dpToPx(f16);
            dpToPx = ViewUtils.dpToPx(0.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(6.0f);
            dpToPx2 = ViewUtils.dpToPx(6.0f);
        }
        holder.o().setPadding(0, dpToPx, 0, dpToPx2);
    }

    private final void k0(f holder) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
            if (!QQTheme.isNowSimpleUI() && !this.isRobotAIO) {
                ViewGroup.LayoutParams layoutParams5 = holder.itemView.getLayoutParams();
                if (layoutParams5 != null) {
                    layoutParams5.width = -2;
                }
                int dpToPx = ViewUtils.dpToPx(50.0f);
                ViewGroup.LayoutParams layoutParams6 = holder.l().getLayoutParams();
                if (layoutParams6 != null) {
                    layoutParams6.width = dpToPx;
                }
                ViewGroup.LayoutParams layoutParams7 = holder.l().getLayoutParams();
                if (layoutParams7 != null) {
                    layoutParams7.height = dpToPx;
                }
                View p16 = holder.p();
                if (p16 != null) {
                    layoutParams3 = p16.getLayoutParams();
                } else {
                    layoutParams3 = null;
                }
                if (layoutParams3 != null) {
                    layoutParams3.width = dpToPx;
                }
                View p17 = holder.p();
                if (p17 != null) {
                    layoutParams4 = p17.getLayoutParams();
                } else {
                    layoutParams4 = null;
                }
                if (layoutParams4 != null) {
                    layoutParams4.height = dpToPx;
                }
                ViewGroup.LayoutParams layoutParams8 = holder.l().getLayoutParams();
                if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams8;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = ViewUtils.dpToPx(7.0f);
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams9 = holder.itemView.getLayoutParams();
            if (layoutParams9 != null) {
                layoutParams9.width = ViewUtils.dpToPx(45.0f);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams10 = holder.itemView.getLayoutParams();
        if (layoutParams10 != null) {
            layoutParams10.width = -2;
        }
        int dpToPx2 = ViewUtils.dpToPx(56.0f);
        ViewGroup.LayoutParams layoutParams11 = holder.l().getLayoutParams();
        if (layoutParams11 != null) {
            layoutParams11.width = dpToPx2;
        }
        ViewGroup.LayoutParams layoutParams12 = holder.l().getLayoutParams();
        if (layoutParams12 != null) {
            layoutParams12.height = dpToPx2;
        }
        View p18 = holder.p();
        if (p18 != null) {
            layoutParams = p18.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.width = dpToPx2;
        }
        View p19 = holder.p();
        if (p19 != null) {
            layoutParams2 = p19.getLayoutParams();
        } else {
            layoutParams2 = null;
        }
        if (layoutParams2 != null) {
            layoutParams2.height = dpToPx2;
        }
        ViewGroup.LayoutParams layoutParams13 = holder.l().getLayoutParams();
        if (layoutParams13 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams13;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = ViewUtils.dpToPx(8.0f);
        }
    }

    private final void l0(f holder, com.tencent.qqnt.pluspanel.data.a data) {
        holder.itemView.setContentDescription(data.h());
        holder.itemView.setOnClickListener(this.mItemOnclickListener);
        holder.itemView.setOnLongClickListener(this.mItemOnLongClickListener);
        holder.itemView.setEnabled(true);
        holder.itemView.setTag(data);
        HashMap hashMap = new HashMap();
        String h16 = data.h();
        if (h16 == null) {
            h16 = "";
        }
        hashMap.put("app_name", h16);
        hashMap.put("rank", String.valueOf(data.f()));
        hashMap.put("appid", String.valueOf(data.c()));
        com.tencent.mobileqq.aio.utils.b.q(this.elementId, hashMap);
    }

    private final int m0(int color, float coefficient) {
        return (color & 255) | (((color >> 16) & 255) << 16) | (((color >> 8) & 255) << 8) | (((int) (((color >> 24) & 255) * coefficient)) << 24);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull f holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= this.appDataList.size()) {
            holder.itemView.setVisibility(8);
            return;
        }
        holder.itemView.setVisibility(0);
        com.tencent.qqnt.pluspanel.data.a aVar = this.appDataList.get(position);
        k0(holder);
        j0(holder, position);
        i0(holder, aVar);
        holder.q(aVar);
        if (!this.isRobotAIO && !QQTheme.isNowSimpleUI()) {
            com.tencent.qqnt.pluspanel.utils.d.f360701a.a(holder.itemView);
        } else {
            com.tencent.qqnt.pluspanel.utils.d dVar = com.tencent.qqnt.pluspanel.utils.d.f360701a;
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            dVar.c(view);
            dVar.b(holder.m(), this.isRobotAIO, holder.l(), holder.p());
        }
        holder.m().setText(aVar.h());
        TextView m3 = holder.m();
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        m3.setTextColor(m0(context.getColor(R.color.qui_common_text_primary), 0.6f));
        l0(holder, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.context = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        View itemView = LayoutInflater.from(context).inflate(R.layout.fqc, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new f(itemView);
    }

    public final void p0(@NotNull List<com.tencent.qqnt.pluspanel.data.a> appDataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appDataList);
        } else {
            Intrinsics.checkNotNullParameter(appDataList, "appDataList");
            this.appDataList = appDataList;
        }
    }

    public final void q0(boolean isAobotAIO) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isAobotAIO);
        } else {
            this.isRobotAIO = isAobotAIO;
        }
    }
}
