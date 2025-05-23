package com.tencent.state.library.focus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.data.LibraryLikeResult;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.timer.FormatUtils;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasFocusLikeService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareLibraryBubbleBinding;
import com.tencent.state.square.databinding.VasSquareLibrarySingleBubbleBinding;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010+\u001a\u00020\u0017H\u0002J\u001a\u0010,\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020 H\u0002J\u0012\u0010-\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J \u0010.\u001a\u00020\u00172\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020 H\u0002J\u0010\u00105\u001a\u00020 2\u0006\u00100\u001a\u00020 H\u0002J\b\u00106\u001a\u0004\u0018\u000103J\u001c\u00107\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000209082\u0006\u0010\u001c\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020 2\u0006\u00100\u001a\u00020 H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u00100\u001a\u00020 H\u0002J\b\u0010=\u001a\u00020\u0017H\u0002J*\u0010>\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"2\u0006\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u0001032\b\u0010A\u001a\u0004\u0018\u000103J\u0016\u0010B\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"2\u0006\u0010C\u001a\u00020DJ,\u0010E\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u0001032\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0006\u0010J\u001a\u00020\u0017J\u001a\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020M2\b\u0010!\u001a\u0004\u0018\u000103H\u0002J\b\u0010N\u001a\u00020\u0017H\u0002J$\u0010O\u001a\u00020\u00172\b\u0010P\u001a\u0004\u0018\u00010M2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020TH\u0002J\u0012\u0010U\u001a\u00020\u00172\b\u0010V\u001a\u0004\u0018\u00010:H\u0002J\u000e\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u001dJ \u0010Y\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u001c\u001a\u00020:2\u0006\u0010\\\u001a\u00020 H\u0002J\u0010\u0010]\u001a\u00020\u00172\b\b\u0002\u0010^\u001a\u000203J\u000e\u0010_\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRL\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000Ra\u0010\u001e\u001aI\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006a"}, d2 = {"Lcom/tencent/state/library/focus/view/LibraryFocusTimeBubble;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryBubbleBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareLibraryBubbleBinding;", "bubbleClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "viewId", "Lcom/tencent/state/template/data/User;", QCircleAlphaUserReporter.KEY_USER, "", "getBubbleClickListener", "()Lkotlin/jvm/functions/Function2;", "setBubbleClickListener", "(Lkotlin/jvm/functions/Function2;)V", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusBaseItem;", "likeClickListener", "Lkotlin/Function3;", "", "uin", "Lcom/tencent/state/template/data/SitDownInfo;", "userFocus", "roomId", "getLikeClickListener", "()Lkotlin/jvm/functions/Function3;", "setLikeClickListener", "(Lkotlin/jvm/functions/Function3;)V", "reporter", "Lcom/tencent/state/square/IReporter;", "bindElement", "clickLike", "clickUserInfo", "doLike", "getCommonFocusTime", "curTime", "getCurTime", "getFocusTimeText", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "getLeftFocusTime", "getMeFocusTimeText", "getReportMap", "", "", "Lcom/tencent/state/library/focus/data/FocusItem;", "getRightFocusTime", "getSingleFocusTime", "initClickListener", "likeFailure", "error", "message", "prompt", "likeSuccess", "result", "Lcom/tencent/state/library/data/LibraryLikeResult;", "onDecodeTaskCompleted", "remainingTasks", "type", "avatar", "Landroid/graphics/Bitmap;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "setAvatarFace", "view", "Landroid/widget/ImageView;", "setGroupBubble", "setLikeView", "iconView", "bgView", "Landroid/view/View;", "isLiked", "", "setSingleBubble", "data", "updateBubble", "bubble", "updateBubbleUI", "bubbleBinding", "Lcom/tencent/state/square/databinding/VasSquareLibrarySingleBubbleBinding;", "time", "updateFocusTimeUI", "title", "updateLikeView", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryFocusTimeBubble extends FrameLayout implements IDecodeTaskCompletionListener {
    private static final String TAG = "LibrarySimpleBubble";
    private IFaceDecoder avatarFaceDecoder;
    private final VasSquareLibraryBubbleBinding binding;
    private Function2<? super Integer, ? super User, Unit> bubbleClickListener;
    private FocusBaseItem item;
    private Function3<? super Long, ? super SitDownInfo, ? super Long, Unit> likeClickListener;
    private final IReporter reporter;

    public LibraryFocusTimeBubble(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void bindElement() {
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            LinearLayout linearLayout = this.binding.singleUserInfo;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.singleUserInfo");
            iReporter.setElementInfo(linearLayout, SquareReportConst.ElementId.ELEMENT_ID_LIBRARY_USER_ICON, new LinkedHashMap(), false, false);
        }
        IReporter iReporter2 = this.reporter;
        if (iReporter2 != null) {
            LinearLayout linearLayout2 = this.binding.leftBubble.userInfo;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.leftBubble.userInfo");
            iReporter2.setElementInfo(linearLayout2, SquareReportConst.ElementId.ELEMENT_ID_LIBRARY_USER_ICON, new LinkedHashMap(), false, false);
        }
        IReporter iReporter3 = this.reporter;
        if (iReporter3 != null) {
            LinearLayout linearLayout3 = this.binding.rightBubble.userInfo;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.rightBubble.userInfo");
            iReporter3.setElementInfo(linearLayout3, SquareReportConst.ElementId.ELEMENT_ID_LIBRARY_USER_ICON, new LinkedHashMap(), false, false);
        }
    }

    private final void doLike(long uin, final SitDownInfo userFocus, long roomId) {
        VasFocusLikeService.INSTANCE.doFriendLike(uin, roomId, new ResultCallback<LibraryLikeResult>() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$doLike$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message, String prompt) {
                LibraryFocusTimeBubble.this.likeFailure(userFocus, error, message, prompt);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(LibraryLikeResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                LibraryFocusTimeBubble.this.likeSuccess(userFocus, result);
            }
        });
    }

    private final long getCommonFocusTime(long curTime) {
        FocusItem rightItem;
        User user;
        SitDownInfo sitDown;
        FocusItem rightItem2;
        User user2;
        SitDownInfo sitDown2;
        FocusItem item;
        User user3;
        SitDownInfo sitDown3;
        FocusItem item2;
        User user4;
        SitDownInfo sitDown4;
        FocusBaseItem focusBaseItem = this.item;
        long sitDownStartTime = (focusBaseItem == null || (item2 = focusBaseItem.getItem()) == null || (user4 = item2.getUser()) == null || (sitDown4 = user4.getSitDown()) == null) ? curTime : sitDown4.getSitDownStartTime();
        FocusBaseItem focusBaseItem2 = this.item;
        long max = Math.max(sitDownStartTime, (focusBaseItem2 == null || (item = focusBaseItem2.getItem()) == null || (user3 = item.getUser()) == null || (sitDown3 = user3.getSitDown()) == null) ? curTime : sitDown3.getLastSwitchTableTime());
        FocusBaseItem focusBaseItem3 = this.item;
        long sitDownStartTime2 = (focusBaseItem3 == null || (rightItem2 = focusBaseItem3.getRightItem()) == null || (user2 = rightItem2.getUser()) == null || (sitDown2 = user2.getSitDown()) == null) ? curTime : sitDown2.getSitDownStartTime();
        FocusBaseItem focusBaseItem4 = this.item;
        return curTime - Math.max(max, Math.max(sitDownStartTime2, (focusBaseItem4 == null || (rightItem = focusBaseItem4.getRightItem()) == null || (user = rightItem.getUser()) == null || (sitDown = user.getSitDown()) == null) ? curTime : sitDown.getLastSwitchTableTime()));
    }

    private final long getCurTime() {
        return Square.INSTANCE.getConfig().getCommonUtils().getServerTime();
    }

    private final String getFocusTimeText(long second) {
        return String.valueOf(FormatUtils.INSTANCE.convertTime(second));
    }

    private final long getLeftFocusTime(long curTime) {
        FocusItem item;
        User user;
        SitDownInfo sitDown;
        FocusBaseItem focusBaseItem = this.item;
        return curTime - ((focusBaseItem == null || (item = focusBaseItem.getItem()) == null || (user = item.getUser()) == null || (sitDown = user.getSitDown()) == null) ? curTime : sitDown.getSitDownStartTime());
    }

    private final long getRightFocusTime(long curTime) {
        FocusItem rightItem;
        User user;
        SitDownInfo sitDown;
        FocusBaseItem focusBaseItem = this.item;
        return curTime - ((focusBaseItem == null || (rightItem = focusBaseItem.getRightItem()) == null || (user = rightItem.getUser()) == null || (sitDown = user.getSitDown()) == null) ? curTime : sitDown.getSitDownStartTime());
    }

    private final long getSingleFocusTime(long curTime) {
        FocusItem singleItem;
        User user;
        SitDownInfo sitDown;
        FocusBaseItem focusBaseItem = this.item;
        return curTime - ((focusBaseItem == null || (singleItem = focusBaseItem.getSingleItem()) == null || (user = singleItem.getUser()) == null || (sitDown = user.getSitDown()) == null) ? curTime : sitDown.getSitDownStartTime());
    }

    private final void setGroupBubble() {
        FocusItem item;
        FocusBaseItem focusBaseItem;
        FocusItem rightItem;
        FocusBaseItem focusBaseItem2 = this.item;
        if (focusBaseItem2 == null || (item = focusBaseItem2.getItem()) == null || (focusBaseItem = this.item) == null || (rightItem = focusBaseItem.getRightItem()) == null) {
            return;
        }
        long curTime = getCurTime();
        LinearLayout linearLayout = this.binding.singleBubble;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.singleBubble");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.binding.deskGroupBubble;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.deskGroupBubble");
        linearLayout2.setVisibility(0);
        TextView textView = this.binding.groupFocusTime;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.groupFocusTime");
        textView.setText(FormatUtils.INSTANCE.convertTime(getCommonFocusTime(curTime)));
        VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding = this.binding.leftBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareLibrarySingleBubbleBinding, "binding.leftBubble");
        updateBubbleUI(vasSquareLibrarySingleBubbleBinding, item, getLeftFocusTime(curTime));
        VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding2 = this.binding.rightBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareLibrarySingleBubbleBinding2, "binding.rightBubble");
        updateBubbleUI(vasSquareLibrarySingleBubbleBinding2, rightItem, getRightFocusTime(curTime));
        getLayoutParams().width = ViewExtensionsKt.dip(getContext(), a.CTRL_INDEX);
    }

    private final void setSingleBubble(final FocusItem data) {
        String str;
        SitDownInfo sitDown;
        SitDownInfo sitDown2;
        SitDownInfo sitDown3;
        CommonTagInfo tag;
        UserCommon info;
        SitDownInfo sitDown4;
        final long curTime = getCurTime();
        if (data != null) {
            User user = data.getUser();
            long sitDownStartTime = curTime - ((user == null || (sitDown4 = user.getSitDown()) == null) ? curTime : sitDown4.getSitDownStartTime());
            LinearLayout linearLayout = this.binding.deskGroupBubble;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.deskGroupBubble");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.binding.singleBubble;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.singleBubble");
            boolean z16 = false;
            linearLayout2.setVisibility(0);
            TextView textView = this.binding.singleUserName;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.singleUserName");
            User user2 = data.getUser();
            if (user2 == null || (info = user2.getInfo()) == null || (str = info.getNick()) == null) {
                str = "";
            }
            textView.setText(str);
            TextView textView2 = this.binding.singleTextContent;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.singleTextContent");
            User user3 = data.getUser();
            textView2.setText((user3 == null || (sitDown3 = user3.getSitDown()) == null || (tag = sitDown3.getTag()) == null) ? null : tag.getText());
            TextView textView3 = this.binding.singleLikeNum;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.singleLikeNum");
            FormatUtils formatUtils = FormatUtils.INSTANCE;
            User user4 = data.getUser();
            textView3.setText(formatUtils.convertLikeNum((user4 == null || (sitDown2 = user4.getSitDown()) == null) ? null : Long.valueOf(sitDown2.getLikeNum())));
            TextView textView4 = this.binding.singleFocusTime;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.singleFocusTime");
            textView4.setText(formatUtils.convertTime(sitDownStartTime));
            CircleBoarderImageView circleBoarderImageView = this.binding.singleUserIcon;
            Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.singleUserIcon");
            User user5 = data.getUser();
            setAvatarFace(circleBoarderImageView, user5 != null ? user5.getUin() : null);
            VasSquareLibraryBubbleBinding vasSquareLibraryBubbleBinding = this.binding;
            SquareImageView squareImageView = vasSquareLibraryBubbleBinding.singleLikeIcon;
            LinearLayout linearLayout3 = vasSquareLibraryBubbleBinding.singleLikeButton;
            User user6 = data.getUser();
            if (user6 != null && (sitDown = user6.getSitDown()) != null && sitDown.getHasLiked()) {
                z16 = true;
            }
            setLikeView(squareImageView, linearLayout3, z16);
            getLayoutParams().width = ViewExtensionsKt.dip(getContext(), 253);
            this.binding.singleUserInfo.post(new Runnable() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$setSingleBubble$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    IReporter iReporter;
                    Map<String, Object> reportMap;
                    iReporter = this.reporter;
                    if (iReporter != null) {
                        LinearLayout linearLayout4 = this.getBinding().singleUserInfo;
                        Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.singleUserInfo");
                        reportMap = this.getReportMap(FocusItem.this);
                        iReporter.reportEvent("imp", linearLayout4, reportMap);
                    }
                }
            });
        }
    }

    private final void updateBubbleUI(final VasSquareLibrarySingleBubbleBinding bubbleBinding, final FocusItem item, long time) {
        SitDownInfo sitDown;
        UserCommon info;
        User user = item.getUser();
        if (user == null || (sitDown = user.getSitDown()) == null) {
            return;
        }
        CircleBoarderImageView circleBoarderImageView = bubbleBinding.userIcon;
        Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "bubbleBinding.userIcon");
        User user2 = item.getUser();
        setAvatarFace(circleBoarderImageView, user2 != null ? user2.getUin() : null);
        TextView textView = bubbleBinding.userName;
        Intrinsics.checkNotNullExpressionValue(textView, "bubbleBinding.userName");
        User user3 = item.getUser();
        textView.setText((user3 == null || (info = user3.getInfo()) == null) ? null : info.getNick());
        TextView textView2 = bubbleBinding.tileContent;
        Intrinsics.checkNotNullExpressionValue(textView2, "bubbleBinding.tileContent");
        CommonTagInfo tag = sitDown.getTag();
        textView2.setText(tag != null ? tag.getText() : null);
        TextView textView3 = bubbleBinding.focusTime;
        Intrinsics.checkNotNullExpressionValue(textView3, "bubbleBinding.focusTime");
        FormatUtils formatUtils = FormatUtils.INSTANCE;
        textView3.setText(formatUtils.convertTime(time));
        TextView textView4 = bubbleBinding.likeNum;
        Intrinsics.checkNotNullExpressionValue(textView4, "bubbleBinding.likeNum");
        textView4.setText(formatUtils.convertLikeNum(Long.valueOf(sitDown.getLikeNum())));
        setLikeView(bubbleBinding.likeIcon, bubbleBinding.likeButton, sitDown.getHasLiked());
        bubbleBinding.userInfo.post(new Runnable() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$updateBubbleUI$1
            @Override // java.lang.Runnable
            public final void run() {
                IReporter iReporter;
                Map<String, Object> reportMap;
                iReporter = LibraryFocusTimeBubble.this.reporter;
                if (iReporter != null) {
                    LinearLayout linearLayout = bubbleBinding.userInfo;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "bubbleBinding.userInfo");
                    reportMap = LibraryFocusTimeBubble.this.getReportMap(item);
                    iReporter.reportEvent("imp", linearLayout, reportMap);
                }
            }
        });
    }

    public final VasSquareLibraryBubbleBinding getBinding() {
        return this.binding;
    }

    public final Function2<Integer, User, Unit> getBubbleClickListener() {
        return this.bubbleClickListener;
    }

    public final Function3<Long, SitDownInfo, Long, Unit> getLikeClickListener() {
        return this.likeClickListener;
    }

    public final String getMeFocusTimeText() {
        FocusItem rightItem;
        User user;
        String obj;
        String removePrefix;
        FocusItem item;
        User user2;
        String obj2;
        String removePrefix2;
        FocusBaseItem focusBaseItem;
        FocusBaseItem focusBaseItem2 = this.item;
        if (focusBaseItem2 != null && focusBaseItem2.isSingleUser() && (focusBaseItem = this.item) != null && FocusDataKt.hasMe(focusBaseItem)) {
            TextView textView = this.binding.singleFocusTime;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.singleFocusTime");
            CharSequence text = textView.getText();
            if (text != null) {
                return text.toString();
            }
            return null;
        }
        FocusBaseItem focusBaseItem3 = this.item;
        if (focusBaseItem3 != null && (item = focusBaseItem3.getItem()) != null && (user2 = item.getUser()) != null && user2.isMe()) {
            TextView textView2 = this.binding.leftBubble.focusTime;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.leftBubble.focusTime");
            CharSequence text2 = textView2.getText();
            if (text2 == null || (obj2 = text2.toString()) == null) {
                return null;
            }
            removePrefix2 = StringsKt__StringsKt.removePrefix(obj2, (CharSequence) "\u4e13\u6ce8");
            return removePrefix2;
        }
        FocusBaseItem focusBaseItem4 = this.item;
        if (focusBaseItem4 == null || (rightItem = focusBaseItem4.getRightItem()) == null || (user = rightItem.getUser()) == null || !user.isMe()) {
            return null;
        }
        TextView textView3 = this.binding.rightBubble.focusTime;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.rightBubble.focusTime");
        CharSequence text3 = textView3.getText();
        if (text3 == null || (obj = text3.toString()) == null) {
            return null;
        }
        removePrefix = StringsKt__StringsKt.removePrefix(obj, (CharSequence) "\u4e13\u6ce8");
        return removePrefix;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void likeFailure(SitDownInfo userFocus, int error, String message, String prompt) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(userFocus, "userFocus");
        if (prompt != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(prompt);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ICommonUtils.DefaultImpls.showToast$default(commonUtils, context, prompt, 0, 4, (Object) null);
                    return;
                }
                userFocus.setHasLiked(false);
                updateLikeView(userFocus);
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public final void likeSuccess(SitDownInfo userFocus, LibraryLikeResult result) {
        Intrinsics.checkNotNullParameter(userFocus, "userFocus");
        Intrinsics.checkNotNullParameter(result, "result");
        userFocus.setLikeNum(result.getLikeNum());
        userFocus.setHasLiked(true);
        updateLikeView(userFocus);
        Context context = getContext();
        if (context != null) {
            SquareBaseKt.getSquareCommon().showToast(context, getResources().getString(R.string.xgb), 2);
        }
    }

    public final void onDestroy() {
        this.avatarFaceDecoder.destroy();
    }

    public final void setBubbleClickListener(Function2<? super Integer, ? super User, Unit> function2) {
        this.bubbleClickListener = function2;
    }

    public final void setLikeClickListener(Function3<? super Long, ? super SitDownInfo, ? super Long, Unit> function3) {
        this.likeClickListener = function3;
    }

    public final void updateBubble(FocusBaseItem bubble) {
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        this.item = bubble;
        if (bubble.isSingleUser()) {
            FocusBaseItem focusBaseItem = this.item;
            setSingleBubble(focusBaseItem != null ? focusBaseItem.getSingleItem() : null);
        } else {
            setGroupBubble();
        }
    }

    public final void updateFocusTimeUI(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        long curTime = getCurTime();
        FocusBaseItem focusBaseItem = this.item;
        if (focusBaseItem != null && focusBaseItem.isSingleUser()) {
            TextView textView = this.binding.singleFocusTime;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.singleFocusTime");
            textView.setText(FormatUtils.INSTANCE.convertTime(getSingleFocusTime(curTime)));
            return;
        }
        TextView textView2 = this.binding.leftBubble.focusTime;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.leftBubble.focusTime");
        textView2.setText(title + getFocusTimeText(getLeftFocusTime(curTime)));
        TextView textView3 = this.binding.rightBubble.focusTime;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.rightBubble.focusTime");
        textView3.setText(title + getFocusTimeText(getRightFocusTime(curTime)));
        TextView textView4 = this.binding.groupFocusTime;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.groupFocusTime");
        textView4.setText(FormatUtils.INSTANCE.convertTime(getCommonFocusTime(curTime)));
    }

    public final void updateLikeView(SitDownInfo userFocus) {
        User user;
        String uin;
        FocusBaseItem focusBaseItem;
        LinearLayout linearLayout;
        TextView textView;
        SquareImageView squareImageView;
        Intrinsics.checkNotNullParameter(userFocus, "userFocus");
        Table table = userFocus.getTable();
        if (table == null || (user = table.getUser()) == null || (uin = user.getUin()) == null || (focusBaseItem = this.item) == null) {
            return;
        }
        if (focusBaseItem.isSingleUser()) {
            VasSquareLibraryBubbleBinding vasSquareLibraryBubbleBinding = this.binding;
            textView = vasSquareLibraryBubbleBinding.singleLikeNum;
            squareImageView = vasSquareLibraryBubbleBinding.singleLikeIcon;
            linearLayout = vasSquareLibraryBubbleBinding.singleLikeButton;
        } else {
            User user2 = focusBaseItem.getItem().getUser();
            if (Intrinsics.areEqual(user2 != null ? user2.getUin() : null, uin)) {
                VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding = this.binding.leftBubble;
                textView = vasSquareLibrarySingleBubbleBinding.likeNum;
                squareImageView = vasSquareLibrarySingleBubbleBinding.likeIcon;
                linearLayout = vasSquareLibrarySingleBubbleBinding.likeButton;
            } else {
                User user3 = focusBaseItem.getRightItem().getUser();
                if (Intrinsics.areEqual(user3 != null ? user3.getUin() : null, uin)) {
                    VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding2 = this.binding.rightBubble;
                    textView = vasSquareLibrarySingleBubbleBinding2.likeNum;
                    squareImageView = vasSquareLibrarySingleBubbleBinding2.likeIcon;
                    linearLayout = vasSquareLibrarySingleBubbleBinding2.likeButton;
                } else {
                    linearLayout = null;
                    textView = null;
                    squareImageView = null;
                }
            }
        }
        if (textView != null) {
            textView.setText(FormatUtils.INSTANCE.convertLikeNum(Long.valueOf(userFocus.getLikeNum())));
        }
        setLikeView(squareImageView, linearLayout, userFocus.getHasLiked());
    }

    public LibraryFocusTimeBubble(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getReportMap(FocusItem item) {
        String str;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[1];
        User user = item.getUser();
        if (user == null || (str = user.getUin()) == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("zplan_other_user_qq", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final void initClickListener() {
        setOnClickListener(null);
        this.binding.singleLikeView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$initClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FocusBaseItem focusBaseItem;
                FocusItem singleItem;
                focusBaseItem = LibraryFocusTimeBubble.this.item;
                if (focusBaseItem == null || (singleItem = focusBaseItem.getSingleItem()) == null) {
                    return;
                }
                LibraryFocusTimeBubble.this.clickLike(singleItem.getUser(), singleItem.getRoomId());
            }
        });
        this.binding.leftBubble.likeView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$initClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FocusBaseItem focusBaseItem;
                FocusItem item;
                focusBaseItem = LibraryFocusTimeBubble.this.item;
                if (focusBaseItem == null || (item = focusBaseItem.getItem()) == null) {
                    return;
                }
                LibraryFocusTimeBubble.this.clickLike(item.getUser(), item.getRoomId());
            }
        });
        this.binding.rightBubble.likeView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$initClickListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FocusBaseItem focusBaseItem;
                FocusItem rightItem;
                focusBaseItem = LibraryFocusTimeBubble.this.item;
                if (focusBaseItem == null || (rightItem = focusBaseItem.getRightItem()) == null) {
                    return;
                }
                LibraryFocusTimeBubble.this.clickLike(rightItem.getUser(), rightItem.getRoomId());
            }
        });
        this.binding.singleUserInfo.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$initClickListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FocusBaseItem focusBaseItem;
                FocusItem singleItem;
                IReporter iReporter;
                Map<String, Object> reportMap;
                focusBaseItem = LibraryFocusTimeBubble.this.item;
                if (focusBaseItem == null || (singleItem = focusBaseItem.getSingleItem()) == null) {
                    return;
                }
                LibraryFocusTimeBubble.this.clickUserInfo(singleItem.getUser());
                iReporter = LibraryFocusTimeBubble.this.reporter;
                if (iReporter != null) {
                    Intrinsics.checkNotNullExpressionValue(view, "view");
                    reportMap = LibraryFocusTimeBubble.this.getReportMap(singleItem);
                    iReporter.reportEvent("clck", view, reportMap);
                }
            }
        });
        this.binding.leftBubble.userInfo.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$initClickListener$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FocusBaseItem focusBaseItem;
                FocusItem item;
                IReporter iReporter;
                Map<String, Object> reportMap;
                focusBaseItem = LibraryFocusTimeBubble.this.item;
                if (focusBaseItem == null || (item = focusBaseItem.getItem()) == null) {
                    return;
                }
                LibraryFocusTimeBubble.this.clickUserInfo(item.getUser());
                iReporter = LibraryFocusTimeBubble.this.reporter;
                if (iReporter != null) {
                    Intrinsics.checkNotNullExpressionValue(view, "view");
                    reportMap = LibraryFocusTimeBubble.this.getReportMap(item);
                    iReporter.reportEvent("clck", view, reportMap);
                }
            }
        });
        this.binding.rightBubble.userInfo.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryFocusTimeBubble$initClickListener$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FocusBaseItem focusBaseItem;
                FocusItem rightItem;
                IReporter iReporter;
                Map<String, Object> reportMap;
                focusBaseItem = LibraryFocusTimeBubble.this.item;
                if (focusBaseItem == null || (rightItem = focusBaseItem.getRightItem()) == null) {
                    return;
                }
                LibraryFocusTimeBubble.this.clickUserInfo(rightItem.getUser());
                iReporter = LibraryFocusTimeBubble.this.reporter;
                if (iReporter != null) {
                    Intrinsics.checkNotNullExpressionValue(view, "view");
                    reportMap = LibraryFocusTimeBubble.this.getReportMap(rightItem);
                    iReporter.reportEvent("clck", view, reportMap);
                }
            }
        });
    }

    public /* synthetic */ LibraryFocusTimeBubble(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickLike(User user, long roomId) {
        if (user != null) {
            if (user.isMe()) {
                Function2<? super Integer, ? super User, Unit> function2 = this.bubbleClickListener;
                if (function2 != null) {
                    function2.invoke(5, user);
                    return;
                }
                return;
            }
            SitDownInfo sitDown = user.getSitDown();
            if (sitDown == null || sitDown.getHasLiked()) {
                return;
            }
            SitDownInfo sitDown2 = user.getSitDown();
            if (sitDown2 != null) {
                sitDown2.setHasLiked(true);
            }
            SitDownInfo sitDown3 = user.getSitDown();
            if (sitDown3 != null) {
                updateLikeView(sitDown3);
                long parseLong = Long.parseLong(user.getUin());
                Function3<? super Long, ? super SitDownInfo, ? super Long, Unit> function3 = this.likeClickListener;
                if (function3 == null) {
                    doLike(parseLong, sitDown3, roomId);
                } else if (function3 != null) {
                    function3.invoke(Long.valueOf(parseLong), sitDown3, Long.valueOf(roomId));
                }
            }
            Function2<? super Integer, ? super User, Unit> function22 = this.bubbleClickListener;
            if (function22 != null) {
                function22.invoke(5, user);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickUserInfo(User user) {
        Function2<? super Integer, ? super User, Unit> function2;
        if (user == null || (function2 = this.bubbleClickListener) == null) {
            return;
        }
        function2.invoke(4, user);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryFocusTimeBubble(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareLibraryBubbleBinding inflate = VasSquareLibraryBubbleBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryBubbleBi\u2026ater.from(context), this)");
        this.binding = inflate;
        Square square = Square.INSTANCE;
        this.avatarFaceDecoder = square.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.reporter = square.getConfig().getReporter();
        setVisibility(0);
        this.avatarFaceDecoder.setDecodeTaskCompletionListener(this);
        bindElement();
        initClickListener();
    }

    private final void setAvatarFace(ImageView view, String uin) {
        if (uin == null || uin.length() == 0) {
            return;
        }
        Bitmap bitmapFromCache$default = IFaceDecoder.DefaultImpls.getBitmapFromCache$default(this.avatarFaceDecoder, uin, false, 2, null);
        if (bitmapFromCache$default != null) {
            view.setImageBitmap(bitmapFromCache$default);
        } else {
            IFaceDecoder.DefaultImpls.requestDecodeFace$default(this.avatarFaceDecoder, uin, false, 2, null);
            view.setImageResource(R.drawable.i9d);
        }
    }

    @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
        FocusItem rightItem;
        User user;
        FocusItem item;
        User user2;
        FocusItem singleItem;
        User user3;
        if (uin == null || uin.length() == 0) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "onDecodeTaskCompleted uin is " + uin, null, 4, null);
            return;
        }
        FocusBaseItem focusBaseItem = this.item;
        String str = null;
        if (focusBaseItem != null && focusBaseItem.isSingleUser()) {
            FocusBaseItem focusBaseItem2 = this.item;
            if (focusBaseItem2 != null && (singleItem = focusBaseItem2.getSingleItem()) != null && (user3 = singleItem.getUser()) != null) {
                str = user3.getUin();
            }
            if (Intrinsics.areEqual(uin, str)) {
                this.binding.singleUserIcon.setImageBitmap(avatar);
                return;
            }
            return;
        }
        FocusBaseItem focusBaseItem3 = this.item;
        if (Intrinsics.areEqual(uin, (focusBaseItem3 == null || (item = focusBaseItem3.getItem()) == null || (user2 = item.getUser()) == null) ? null : user2.getUin())) {
            this.binding.leftBubble.userIcon.setImageBitmap(avatar);
            return;
        }
        FocusBaseItem focusBaseItem4 = this.item;
        if (focusBaseItem4 != null && (rightItem = focusBaseItem4.getRightItem()) != null && (user = rightItem.getUser()) != null) {
            str = user.getUin();
        }
        if (Intrinsics.areEqual(uin, str)) {
            this.binding.rightBubble.userIcon.setImageBitmap(avatar);
        }
    }

    public static /* synthetic */ void updateFocusTimeUI$default(LibraryFocusTimeBubble libraryFocusTimeBubble, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "\u4e13\u6ce8";
        }
        libraryFocusTimeBubble.updateFocusTimeUI(str);
    }

    private final void setLikeView(ImageView iconView, View bgView, boolean isLiked) {
        int i3 = isLiked ? R.drawable.i_s : R.drawable.i_u;
        int i16 = isLiked ? R.drawable.gtk : R.drawable.gtl;
        if (iconView != null) {
            iconView.setImageResource(i3);
        }
        if (bgView != null) {
            bgView.setBackgroundResource(i16);
        }
    }
}
