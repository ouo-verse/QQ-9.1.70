package com.tencent.state.square.like;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.bubblesetting.SquareBubbleColor;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareLikeButtonColor;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.LikeNum;
import com.tencent.state.square.data.StickerItem;
import com.tencent.state.square.data.StickerType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.utils.ColorFormatUtils;
import com.tencent.state.view.SquareImageView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aJ\b\u0010%\u001a\u00020#H\u0002J\u0006\u0010&\u001a\u00020\u001aJ\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0002J\u0019\u0010+\u001a\u0004\u0018\u00010\u001a2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002\u00a2\u0006\u0002\u0010.J\b\u0010/\u001a\u00020#H\u0002J\u0012\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010-H\u0016J\b\u00102\u001a\u00020#H\u0014J\"\u00103\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001a2\b\b\u0002\u00104\u001a\u00020\n2\b\b\u0002\u00105\u001a\u00020\nJ\u000e\u00106\u001a\u00020#2\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020#R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0001`\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u00a8\u0006;"}, d2 = {"Lcom/tencent/state/square/like/OperateLikePanel;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "uin", "", "operateLikeEnabled", "", c.B, "Lcom/tencent/state/square/data/Stickers;", "callback", "Lcom/tencent/state/square/like/IStickersChangedListener;", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/String;ZLcom/tencent/state/square/data/Stickers;Lcom/tencent/state/square/like/IStickersChangedListener;)V", "animationPopWindow", "Lcom/tencent/state/square/like/LikeAnimationPagView;", "getCallback", "()Lcom/tencent/state/square/like/IStickersChangedListener;", "controller", "Lcom/tencent/state/square/like/OperateLikeController;", "currentResult", "Lcom/tencent/state/square/like/CheckLikedResult;", "iconMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getOperateLikeEnabled", "()Z", "getStickers", "()Lcom/tencent/state/square/data/Stickers;", "getUin", "()Ljava/lang/String;", "cancelLikeType", "", "likeType", "dismissCurAnimationPopWindow", "getCurrentSelectedType", "getGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "likeColor", "Lcom/tencent/state/square/bubblesetting/SquareLikeButtonColor;", "getLikeType", "view", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Integer;", "initClickListener", NodeProps.ON_CLICK, "v", NodeProps.ON_DETACHED_FROM_WINDOW, "setSelectLikeType", QZoneJsConstants.METHOD_PLAY, "phoneShake", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", VasPerfReportUtils.WHILE_UPDATE_ITEM, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class OperateLikePanel extends LinearLayout implements View.OnClickListener {
    private static final int MAX_COUNT = 99;
    private static final String MAX_COUNT_TEXT = "99+";
    private static final String TAG = "OperateLikePanel";
    private LikeAnimationPagView animationPopWindow;
    private final IStickersChangedListener callback;
    private final OperateLikeController controller;
    private CheckLikedResult currentResult;
    private HashMap<Integer, LinearLayout> iconMap;
    private final boolean operateLikeEnabled;
    private final Stickers stickers;
    private final String uin;

    public /* synthetic */ OperateLikePanel(Context context, AttributeSet attributeSet, String str, boolean z16, Stickers stickers, IStickersChangedListener iStickersChangedListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, str, (i3 & 8) != 0 ? true : z16, stickers, iStickersChangedListener);
    }

    private final void dismissCurAnimationPopWindow() {
        try {
            LikeAnimationPagView likeAnimationPagView = this.animationPopWindow;
            if (likeAnimationPagView != null && likeAnimationPagView.isShowing()) {
                likeAnimationPagView.dismiss();
            }
            this.animationPopWindow = null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "dimiss animationPopWindow err.", th5);
        }
    }

    private final GradientDrawable getGradientDrawable(SquareLikeButtonColor likeColor) {
        ColorFormatUtils colorFormatUtils = ColorFormatUtils.INSTANCE;
        Integer parse = colorFormatUtils.parse(likeColor.getBgmColor());
        if (parse != null) {
            int intValue = parse.intValue();
            Integer parse2 = colorFormatUtils.parse(likeColor.getBorderColor());
            if (parse2 != null) {
                int intValue2 = parse2.intValue();
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setStroke(ViewExtensionsKt.dip(getContext(), 0.5f), intValue2);
                gradientDrawable.setColor(intValue);
                gradientDrawable.setCornerRadius(ViewExtensionsKt.dip(getContext(), 12));
                return gradientDrawable;
            }
        }
        return null;
    }

    private final void initClickListener() {
        Iterator<Map.Entry<Integer, LinearLayout>> it = this.iconMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setOnClickListener(this);
        }
    }

    public final IStickersChangedListener getCallback() {
        return this.callback;
    }

    public final int getCurrentSelectedType() {
        for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
            if (entry.getValue().isSelected()) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    public final boolean getOperateLikeEnabled() {
        return this.operateLikeEnabled;
    }

    public final Stickers getStickers() {
        return this.stickers;
    }

    public final String getUin() {
        return this.uin;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissCurAnimationPopWindow();
    }

    public final void updateBubbleSkin(SquareBubbleInfo bubbleInfo) {
        SquareLikeButtonColor selectColor;
        SquareLikeButtonColor unselectColor;
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        SquareBubbleColor color = bubbleInfo.getColor();
        if (color == null || (selectColor = color.getSelectColor()) == null || (unselectColor = bubbleInfo.getColor().getUnselectColor()) == null) {
            return;
        }
        for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            int[] iArr = {R.attr.state_selected};
            stateListDrawable.addState(new int[]{-16842913}, getGradientDrawable(unselectColor));
            stateListDrawable.addState(iArr, getGradientDrawable(selectColor));
            entry.getValue().setBackground(stateListDrawable);
        }
    }

    public final void updateView() {
        List<LikeNum> likeNums;
        List<StickerItem> items;
        Object obj;
        Stickers stickers = this.stickers;
        if (stickers != null && (items = stickers.getItems()) != null) {
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                StickerItem stickerItem = (StickerItem) obj;
                if (stickerItem.getType() == StickerType.Like && stickerItem.isMe()) {
                    break;
                }
            }
            StickerItem stickerItem2 = (StickerItem) obj;
            if (stickerItem2 != null) {
                setSelectLikeType$default(this, stickerItem2.getLikeType(), false, false, 6, null);
            }
        }
        Stickers stickers2 = this.stickers;
        if (stickers2 == null || (likeNums = stickers2.getLikeNums()) == null) {
            return;
        }
        for (LikeNum likeNum : likeNums) {
            LinearLayout linearLayout = this.iconMap.get(Integer.valueOf(likeNum.getLikeType()));
            TextView textView = linearLayout != null ? (TextView) linearLayout.findViewWithTag("text") : null;
            if (textView != null) {
                if (likeNum.getNum() == 0) {
                    textView.setText("");
                } else if (likeNum.getNum() <= 99) {
                    textView.setText(String.valueOf(likeNum.getNum()));
                } else {
                    textView.setText(MAX_COUNT_TEXT);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OperateLikePanel(Context context, AttributeSet attributeSet, String uin, boolean z16, Stickers stickers, IStickersChangedListener iStickersChangedListener) {
        super(context, attributeSet);
        Long longOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.operateLikeEnabled = z16;
        this.stickers = stickers;
        this.callback = iStickersChangedListener;
        this.iconMap = new HashMap<>();
        this.controller = new OperateLikeController(this);
        LayoutInflater.from(context).inflate(com.tencent.mobileqq.R.layout.d6j, (ViewGroup) this, true);
        HashMap<Integer, LinearLayout> hashMap = this.iconMap;
        hashMap.put(1, findViewById(com.tencent.mobileqq.R.id.pz6));
        hashMap.put(2, findViewById(com.tencent.mobileqq.R.id.px9));
        hashMap.put(3, findViewById(com.tencent.mobileqq.R.id.qmm));
        hashMap.put(4, findViewById(com.tencent.mobileqq.R.id.ptc));
        for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
            ((SquareImageView) entry.getValue().findViewWithTag("img")).setImageResource(LikeData.INSTANCE.getIconFromType(entry.getKey().intValue()));
        }
        initClickListener();
        OperateLikeController operateLikeController = this.controller;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.uin);
        operateLikeController.initData(longOrNull != null ? longOrNull.longValue() : -1L);
        updateView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Map<String, Object> mutableMapOf;
        if (v3 != null) {
            if (!this.operateLikeEnabled) {
                ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ICommonUtils.DefaultImpls.showToast$default(commonUtils, context, "\u6210\u4e3a\u597d\u53cb\u540e\u624d\u80fd\u70b9\u8d5e\u54e6", 0, 4, (Object) null);
                return;
            }
            Integer likeType = getLikeType(v3);
            if (likeType != null) {
                int intValue = likeType.intValue();
                boolean isSelected = v3.isSelected();
                this.controller.onItemClick(v3, intValue);
                IReporter reporter = Square.INSTANCE.getConfig().getReporter();
                Pair[] pairArr = new Pair[5];
                pairArr[0] = TuplesKt.to("zplan_action_type", "click");
                pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_CUSTOMER_LIKE_TYPE, Integer.valueOf(intValue));
                pairArr[2] = TuplesKt.to("zplan_button_display_type", Integer.valueOf(!isSelected ? 1 : 0));
                pairArr[3] = TuplesKt.to("zplan_other_user_qq", this.uin);
                CheckLikedResult checkLikedResult = this.currentResult;
                pairArr[4] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_LIKE_NUM, Integer.valueOf(checkLikedResult != null ? checkLikedResult.getLocalLikedCount() : 0));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_CUSTOMER_LIKE_ICON, mutableMapOf);
            }
        }
    }

    private final Integer getLikeType(View view) {
        if (view != null) {
            for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
                if (Intrinsics.areEqual(entry.getValue(), view)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public final void cancelLikeType(int likeType) {
        if (likeType == -1) {
            return;
        }
        for (Map.Entry<Integer, LinearLayout> entry : this.iconMap.entrySet()) {
            if (entry.getKey().intValue() == likeType && entry.getValue().isSelected()) {
                entry.getValue().setSelected(false);
            }
        }
    }

    public final void setSelectLikeType(int likeType, boolean playAnimation, boolean phoneShake) {
        if (likeType == -1) {
            return;
        }
        Iterator<Map.Entry<Integer, LinearLayout>> it = this.iconMap.entrySet().iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, LinearLayout> next = it.next();
            LinearLayout value = next.getValue();
            if (likeType != next.getKey().intValue()) {
                z16 = false;
            }
            value.setSelected(z16);
        }
        if (playAnimation) {
            dismissCurAnimationPopWindow();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            LikeAnimationPagView likeAnimationPagView = new LikeAnimationPagView(context, likeType, false, 4, null);
            likeAnimationPagView.setWidth(-1);
            likeAnimationPagView.setHeight(-2);
            Unit unit = Unit.INSTANCE;
            this.animationPopWindow = likeAnimationPagView;
            likeAnimationPagView.showAsDropDown(this);
        }
        if (phoneShake) {
            Square.INSTANCE.getConfig().getCommonUtils().phoneVibrate(1, 100L);
        }
    }

    public static /* synthetic */ void setSelectLikeType$default(OperateLikePanel operateLikePanel, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            z17 = false;
        }
        operateLikePanel.setSelectLikeType(i3, z16, z17);
    }
}
