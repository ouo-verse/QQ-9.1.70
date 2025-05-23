package com.tencent.sqshow.zootopia.nativeui.view.color;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b94.d;
import ba4.ColorData;
import ba4.b;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerPanelView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.ColorTextButton;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.GradientColorView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.GradientPickerView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.HuePickerView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.MultiHuePickerView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.RectColorPickerView;
import com.tencent.sqshow.zootopia.utils.i;
import da4.a;
import java.util.List;
import k94.ColorPanelData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qu4.l;
import qu4.p;
import tl.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001XB)\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010'\u001a\u00020!\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\u0011\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\t\u001a\u00020\bJ\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u001d\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u0010>\u001a\u0004\u0018\u0001078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR$\u0010L\u001a\u0004\u0018\u00010F8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\b)\u0010I\"\u0004\bJ\u0010KR$\u0010S\u001a\u0004\u0018\u00010M8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\b-\u0010P\"\u0004\bQ\u0010R\u00a8\u0006Y"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/ColorPickerPanelView;", "Landroid/widget/RelativeLayout;", "", "o", "f", "v", "Lqu4/d;", "colorSlotInfo", "", "isUpdateColor", "u", "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lk94/b;", "colorPanelData", "w", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lba4/c;", "colorData", "", "position", "k", "slotColorInfo", "l", "d", "I", "colorIndex", "e", "Lk94/b;", "mColorPanelData", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "g", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", WadlProxyConsts.CHANNEL, "Landroidx/recyclerview/widget/RecyclerView;", h.F, "Landroidx/recyclerview/widget/RecyclerView;", "colorPickerRecycler", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/GradientPickerView;", "i", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/GradientPickerView;", "gradientPickerView", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/ColorTextButton;", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/ColorTextButton;", "colorTextButton", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/HuePickerView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/HuePickerView;", "huePickerView", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/RectColorPickerView;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/RectColorPickerView;", "j", "()Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/RectColorPickerView;", "setRectPickerView", "(Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/RectColorPickerView;)V", "rectPickerView", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/MultiHuePickerView;", "E", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/MultiHuePickerView;", "multiHuePickerView", UserInfo.SEX_FEMALE, "Lqu4/d;", "colorInfo", "Lba4/b;", "G", "Lba4/b;", "()Lba4/b;", "setColorPickerAdapter", "(Lba4/b;)V", "colorPickerAdapter", "Landroid/view/View;", "H", "Landroid/view/View;", "()Landroid/view/View;", "setColorPickerLine", "(Landroid/view/View;)V", "colorPickerLine", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ILk94/b;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ColorPickerPanelView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private HuePickerView huePickerView;

    /* renamed from: D, reason: from kotlin metadata */
    private RectColorPickerView rectPickerView;

    /* renamed from: E, reason: from kotlin metadata */
    private MultiHuePickerView multiHuePickerView;

    /* renamed from: F, reason: from kotlin metadata */
    private qu4.d colorInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private ba4.b colorPickerAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private View colorPickerLine;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int colorIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ColorPanelData mColorPanelData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private j channel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView colorPickerRecycler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GradientPickerView gradientPickerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ColorTextButton colorTextButton;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/color/ColorPickerPanelView$b", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/GradientColorView$b;", "", "fraction", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements GradientColorView.b {
        b() {
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.view.color.picker.GradientColorView.b
        public void a(float fraction) {
            qu4.c b16 = da4.b.f393480a.b(ColorPickerPanelView.this.colorIndex, ColorPickerPanelView.this.mColorPanelData, ColorPickerPanelView.this.gradientPickerView, ColorPickerPanelView.this.multiHuePickerView, ColorPickerPanelView.this.getRectPickerView());
            b94.d avatarDressController = ColorPickerPanelView.this.getChannel().getAvatarDressController();
            if (avatarDressController != null) {
                d.a.f(avatarDressController, b16, false, null, 4, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/color/ColorPickerPanelView$c", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/HuePickerView$b;", "", "hue", "", "update", "isUpAction", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements HuePickerView.b {
        c() {
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.view.color.picker.HuePickerView.b
        public void a(float hue, boolean update, boolean isUpAction) {
            RectColorPickerView rectPickerView = ColorPickerPanelView.this.getRectPickerView();
            if (rectPickerView != null) {
                rectPickerView.setHue(hue, update, isUpAction);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/color/ColorPickerPanelView$d", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/MultiHuePickerView$b;", "", "fraction", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements MultiHuePickerView.b {
        d() {
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.view.color.picker.MultiHuePickerView.b
        public void a(float fraction) {
            QLog.i("ColorPickerPanelView", 4, "multiHuePickerView :: onColorChange , fraction == " + fraction);
            qu4.c b16 = da4.b.f393480a.b(ColorPickerPanelView.this.colorIndex, ColorPickerPanelView.this.mColorPanelData, ColorPickerPanelView.this.gradientPickerView, ColorPickerPanelView.this.multiHuePickerView, ColorPickerPanelView.this.getRectPickerView());
            b94.d avatarDressController = ColorPickerPanelView.this.getChannel().getAvatarDressController();
            if (avatarDressController != null) {
                d.a.f(avatarDressController, b16, false, null, 4, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/color/ColorPickerPanelView$e", "Lba4/b$b;", "Lba4/c;", "colorData", "Landroid/view/View;", "view", "", "position", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements b.InterfaceC0116b {
        e() {
        }

        @Override // ba4.b.InterfaceC0116b
        public void a(ColorData colorData, View view, int position) {
            Intrinsics.checkNotNullParameter(colorData, "colorData");
            Intrinsics.checkNotNullParameter(view, "view");
            ColorPickerPanelView.this.k(colorData, position);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/color/ColorPickerPanelView$f", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends RecyclerView.ItemDecoration {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildLayoutPosition(view) != 0) {
                outRect.left = i.b(11);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPickerPanelView(Context context, int i3, ColorPanelData mColorPanelData, j channel) {
        super(context);
        Intrinsics.checkNotNullParameter(mColorPanelData, "mColorPanelData");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.colorIndex = i3;
        this.mColorPanelData = mColorPanelData;
        this.channel = channel;
        View.inflate(context, R.layout.day, this);
        o();
        f();
        v();
    }

    private final void n(qu4.d colorSlotInfo) {
        p pVar;
        ColorTextButton colorTextButton = this.colorTextButton;
        if (colorTextButton != null) {
            colorTextButton.setChannel(this.channel);
        }
        int i3 = this.colorIndex;
        if (i3 != 2 && i3 != 3) {
            ColorTextButton colorTextButton2 = this.colorTextButton;
            if (colorTextButton2 != null) {
                colorTextButton2.setVisibility(0);
            }
            if (colorSlotInfo != null && colorSlotInfo.f429584b == this.colorIndex) {
                int i16 = this.colorIndex;
                if (i16 == 0) {
                    ColorTextButton colorTextButton3 = this.colorTextButton;
                    if (colorTextButton3 != null) {
                        p pVar2 = colorSlotInfo.f429585c;
                        colorTextButton3.setColor(pVar2 != null ? pVar2.f429637b : 0);
                        return;
                    }
                    return;
                }
                if (i16 == 1) {
                    ColorTextButton colorTextButton4 = this.colorTextButton;
                    if (colorTextButton4 != null) {
                        l lVar = colorSlotInfo.f429586d;
                        if (lVar != null && (pVar = lVar.f429615b) != null) {
                            r2 = pVar.f429637b;
                        }
                        colorTextButton4.setColor(r2);
                        return;
                    }
                    return;
                }
                if (i16 != 2) {
                    return;
                }
                ArgbEvaluator argbEvaluator = new ArgbEvaluator();
                l lVar2 = colorSlotInfo.f429586d;
                float f16 = lVar2 != null ? lVar2.f429619f : 0.0f;
                Object obj = lVar2 != null ? lVar2.f429615b : null;
                if (obj == null) {
                    obj = 0;
                }
                l lVar3 = colorSlotInfo.f429586d;
                Object obj2 = lVar3 != null ? lVar3.f429616c : null;
                if (obj2 == null) {
                    obj2 = 0;
                }
                Object evaluate = argbEvaluator.evaluate(f16, obj, obj2);
                Intrinsics.checkNotNull(evaluate, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) evaluate).intValue();
                ColorTextButton colorTextButton5 = this.colorTextButton;
                if (colorTextButton5 != null) {
                    colorTextButton5.setColor(intValue);
                    return;
                }
                return;
            }
            return;
        }
        ColorTextButton colorTextButton6 = this.colorTextButton;
        if (colorTextButton6 == null) {
            return;
        }
        colorTextButton6.setVisibility(8);
    }

    private final void o() {
        this.colorInfo = da4.b.f393480a.e(this.mColorPanelData.getColorInfo(), this.mColorPanelData.getSlotId());
        QLog.i("ColorPickerPanelView", 1, "colorType == " + this.colorIndex);
    }

    private final void p(qu4.d colorSlotInfo) {
        float f16;
        if (this.colorIndex == 1) {
            GradientPickerView gradientPickerView = this.gradientPickerView;
            if (gradientPickerView != null) {
                gradientPickerView.setVisibility(0);
            }
            int[] iArr = new int[2];
            if (colorSlotInfo != null && colorSlotInfo.f429584b == 1) {
                l lVar = colorSlotInfo.f429586d;
                f16 = lVar != null ? lVar.f429619f : 0.0f;
                p pVar = lVar.f429615b;
                iArr[0] = pVar != null ? pVar.f429637b : 0;
                p pVar2 = lVar.f429616c;
                iArr[1] = pVar2 != null ? pVar2.f429637b : 0;
            } else {
                iArr[0] = -16777216;
                iArr[1] = -1;
                f16 = 0.5f;
            }
            GradientPickerView gradientPickerView2 = this.gradientPickerView;
            if (gradientPickerView2 != null) {
                gradientPickerView2.setColors(iArr, f16);
            }
            GradientPickerView gradientPickerView3 = this.gradientPickerView;
            if (gradientPickerView3 != null) {
                gradientPickerView3.setOnFractionChangedListener(new b());
            }
        }
    }

    private final void q(qu4.d colorSlotInfo) {
        p pVar;
        int i3;
        l lVar;
        p pVar2;
        int i16 = this.colorIndex;
        if (i16 == 0) {
            if (colorSlotInfo != null && (pVar = colorSlotInfo.f429585c) != null) {
                i3 = pVar.f429637b;
            }
            i3 = 0;
        } else {
            if (i16 != 1) {
                return;
            }
            if (colorSlotInfo != null && (lVar = colorSlotInfo.f429586d) != null && (pVar2 = lVar.f429615b) != null) {
                i3 = pVar2.f429637b;
            }
            i3 = 0;
        }
        HuePickerView huePickerView = this.huePickerView;
        if (huePickerView != null) {
            huePickerView.setVisibility(0);
        }
        HuePickerView huePickerView2 = this.huePickerView;
        if (huePickerView2 != null) {
            huePickerView2.setCurrentColor(i3);
        }
        HuePickerView huePickerView3 = this.huePickerView;
        if (huePickerView3 != null) {
            huePickerView3.setOnHueChangedListener(new c());
        }
    }

    private final void r(qu4.d colorSlotInfo) {
        MultiHuePickerView multiHuePickerView;
        if (this.colorIndex == 2) {
            MultiHuePickerView multiHuePickerView2 = this.multiHuePickerView;
            boolean z16 = false;
            if (multiHuePickerView2 != null) {
                multiHuePickerView2.setVisibility(0);
            }
            int length = this.mColorPanelData.getColorConfig().f440222e.length;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                a aVar = a.f393479a;
                p pVar = this.mColorPanelData.getColorConfig().f440222e[i3].f429615b;
                iArr[i3] = aVar.b(pVar != null ? pVar.f429637b : 0);
            }
            MultiHuePickerView multiHuePickerView3 = this.multiHuePickerView;
            if (multiHuePickerView3 != null) {
                multiHuePickerView3.setColors(iArr);
            }
            if (colorSlotInfo != null && colorSlotInfo.f429584b == 2) {
                z16 = true;
            }
            if (z16 && (multiHuePickerView = this.multiHuePickerView) != null) {
                l lVar = colorSlotInfo.f429586d;
                multiHuePickerView.setCurrentFraction(lVar != null ? lVar.f429619f : 0.0f);
            }
            MultiHuePickerView multiHuePickerView4 = this.multiHuePickerView;
            if (multiHuePickerView4 != null) {
                multiHuePickerView4.setOnColorChangedListener(new d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ColorPickerPanelView this$0, int i3, boolean z16) {
        GradientPickerView gradientPickerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ColorPickerPanelView", 4, "rectPickerView :: color changed == " + i3 + " , isUpAction == " + z16);
        if (this$0.colorIndex == 1 && (gradientPickerView = this$0.gradientPickerView) != null) {
            gradientPickerView.setColor(i3);
        }
        ColorTextButton colorTextButton = this$0.colorTextButton;
        if (colorTextButton != null) {
            colorTextButton.setColor(i3);
        }
        da4.b bVar = da4.b.f393480a;
        qu4.c b16 = bVar.b(this$0.colorIndex, this$0.mColorPanelData, this$0.gradientPickerView, this$0.multiHuePickerView, this$0.rectPickerView);
        b94.d avatarDressController = this$0.channel.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.f(avatarDressController, b16, z16, null, 4, null);
        }
        qu4.d e16 = bVar.e(b16, this$0.mColorPanelData.getSlotId());
        if (e16 != null) {
            this$0.l(e16);
        }
    }

    private final void u(qu4.d colorSlotInfo, boolean isUpdateColor) {
        List<ColorData> a16 = da4.b.f393480a.a(this.mColorPanelData, colorSlotInfo, this.colorIndex);
        ba4.b bVar = this.colorPickerAdapter;
        if (bVar != null) {
            if (isUpdateColor) {
                if (bVar != null) {
                    bVar.o0(a16);
                    return;
                }
                return;
            } else {
                if (bVar != null) {
                    bVar.p0(a16);
                    return;
                }
                return;
            }
        }
        ba4.b bVar2 = new ba4.b(a16);
        this.colorPickerAdapter = bVar2;
        bVar2.r0(new e());
        RecyclerView recyclerView = this.colorPickerRecycler;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.colorPickerAdapter);
        }
        RecyclerView recyclerView2 = this.colorPickerRecycler;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView3 = this.colorPickerRecycler;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new f());
        }
    }

    private final void v() {
        x(this, this.colorInfo, null, false, 6, null);
    }

    /* renamed from: g, reason: from getter */
    public final j getChannel() {
        return this.channel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final ba4.b getColorPickerAdapter() {
        return this.colorPickerAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i, reason: from getter */
    public final View getColorPickerLine() {
        return this.colorPickerLine;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j, reason: from getter */
    public final RectColorPickerView getRectPickerView() {
        return this.rectPickerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(ColorData colorData, int position) {
        MultiHuePickerView multiHuePickerView;
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        Intrinsics.checkNotNullParameter(colorData, "colorData");
        int i3 = 0;
        if (colorData.getColorIndex() == 1) {
            int[] iArr = new int[2];
            l gradientColor = colorData.getGradientColor();
            iArr[0] = (gradientColor == null || (pVar4 = gradientColor.f429615b) == null) ? 0 : pVar4.f429637b;
            l gradientColor2 = colorData.getGradientColor();
            iArr[1] = (gradientColor2 == null || (pVar3 = gradientColor2.f429616c) == null) ? 0 : pVar3.f429637b;
            GradientPickerView gradientPickerView = this.gradientPickerView;
            if (gradientPickerView != null) {
                l gradientColor3 = colorData.getGradientColor();
                gradientPickerView.setColors(iArr, gradientColor3 != null ? gradientColor3.f429619f : 0.0f);
            }
        } else if (colorData.getColorIndex() == 2 && (multiHuePickerView = this.multiHuePickerView) != null) {
            l gradientColor4 = colorData.getGradientColor();
            multiHuePickerView.setCurrentFraction(gradientColor4 != null ? gradientColor4.f429619f : 0.0f);
        }
        if (colorData.getColorIndex() == 1) {
            GradientPickerView gradientPickerView2 = this.gradientPickerView;
            if (gradientPickerView2 != null && gradientPickerView2.getSelectedThumb() == 0) {
                l gradientColor5 = colorData.getGradientColor();
                if (gradientColor5 != null && (pVar2 = gradientColor5.f429615b) != null) {
                    i3 = pVar2.f429637b;
                }
            } else {
                l gradientColor6 = colorData.getGradientColor();
                if (gradientColor6 != null && (pVar = gradientColor6.f429616c) != null) {
                    i3 = pVar.f429637b;
                }
            }
        } else {
            p singleColor = colorData.getSingleColor();
            if (singleColor != null) {
                i3 = singleColor.f429637b;
            }
        }
        if (colorData.getColorIndex() == 0 || colorData.getColorIndex() == 1) {
            ColorTextButton colorTextButton = this.colorTextButton;
            if (colorTextButton != null) {
                colorTextButton.setColor(i3);
            }
            HuePickerView huePickerView = this.huePickerView;
            if (huePickerView != null) {
                huePickerView.setCurrentColor(i3);
            }
            RectColorPickerView rectColorPickerView = this.rectPickerView;
            if (rectColorPickerView != null) {
                rectColorPickerView.setColor(i3);
            }
        }
        qu4.c c16 = da4.b.f393480a.c(colorData, this.colorIndex, this.mColorPanelData);
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.f(avatarDressController, c16, true, null, 4, null);
        }
    }

    public void s(qu4.d colorSlotInfo) {
        p pVar;
        int i3;
        l lVar;
        p pVar2;
        int i16 = this.colorIndex;
        if (i16 == 0) {
            if (colorSlotInfo != null && (pVar = colorSlotInfo.f429585c) != null) {
                i3 = pVar.f429637b;
            }
            i3 = 0;
        } else {
            if (i16 != 1) {
                return;
            }
            if (colorSlotInfo != null && (lVar = colorSlotInfo.f429586d) != null && (pVar2 = lVar.f429615b) != null) {
                i3 = pVar2.f429637b;
            }
            i3 = 0;
        }
        if (i16 == 1) {
            RectColorPickerView rectColorPickerView = this.rectPickerView;
            ViewGroup.LayoutParams layoutParams = rectColorPickerView != null ? rectColorPickerView.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.height = i.b(145);
            }
        }
        RectColorPickerView rectColorPickerView2 = this.rectPickerView;
        if (rectColorPickerView2 != null) {
            rectColorPickerView2.setVisibility(0);
        }
        RectColorPickerView rectColorPickerView3 = this.rectPickerView;
        if (rectColorPickerView3 != null) {
            rectColorPickerView3.setColor(i3);
        }
        RectColorPickerView rectColorPickerView4 = this.rectPickerView;
        if (rectColorPickerView4 != null) {
            rectColorPickerView4.setOnColorChangedListener(new RectColorPickerView.c() { // from class: aa4.a
                @Override // com.tencent.sqshow.zootopia.nativeui.view.color.picker.RectColorPickerView.c
                public final void a(int i17, boolean z16) {
                    ColorPickerPanelView.t(ColorPickerPanelView.this, i17, z16);
                }
            });
        }
    }

    public final void setChannel(j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.channel = jVar;
    }

    public final void w(qu4.d colorSlotInfo, ColorPanelData colorPanelData, boolean isUpdateColor) {
        if (colorPanelData != null) {
            this.mColorPanelData = colorPanelData;
        }
        u(colorSlotInfo, isUpdateColor);
        p(colorSlotInfo);
        n(colorSlotInfo);
        q(colorSlotInfo);
        s(colorSlotInfo);
        r(colorSlotInfo);
        m();
    }

    private final void f() {
        this.colorPickerRecycler = (RecyclerView) findViewById(R.id.f163338pl2);
        this.colorTextButton = (ColorTextButton) findViewById(R.id.f163339pl3);
        this.huePickerView = (HuePickerView) findViewById(R.id.pky);
        this.rectPickerView = (RectColorPickerView) findViewById(R.id.f163337pl1);
        this.gradientPickerView = (GradientPickerView) findViewById(R.id.pkx);
        this.multiHuePickerView = (MultiHuePickerView) findViewById(R.id.f163336pl0);
        this.colorPickerLine = findViewById(R.id.pkz);
    }

    public static /* synthetic */ void x(ColorPickerPanelView colorPickerPanelView, qu4.d dVar, ColorPanelData colorPanelData, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                colorPanelData = null;
            }
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            colorPickerPanelView.w(dVar, colorPanelData, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshView");
    }

    public void m() {
    }

    public void l(qu4.d slotColorInfo) {
    }
}
