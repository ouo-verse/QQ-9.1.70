package com.tencent.qqnt.aio.menu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi;
import com.tencent.qqnt.aio.menu.ui.QQCustomMenuNoIconLayout;
import com.tencent.qqnt.aio.widget.BubblePopupWindow;
import com.tencent.qqnt.kernel.nativeinterface.EmojiZPlan;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0005a,(?DB!\u0012\u0006\u00108\u001a\u00020\u000f\u0012\u0006\u0010=\u001a\u000209\u0012\b\u0010C\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b_\u0010`J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002J\u001b\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\bH\u0002J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J*\u0010\u001e\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u000e\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u000fJ\"\u0010(\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J2\u0010,\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020\u0018H\u0016J\u0010\u0010.\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\u0018JL\u00104\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00182\u0006\u00103\u001a\u0002022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0004R\u0017\u00108\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b,\u00105\u001a\u0004\b6\u00107R\u0017\u0010=\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b(\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010C\u001a\u0004\u0018\u00010>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00105R\u0016\u0010G\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u00105R\u0016\u0010H\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00105R\u0016\u0010I\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00105R\u0014\u0010J\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b.\u00105R\u0016\u0010L\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00105R\u0016\u0010M\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00105R\u0014\u0010O\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010TR\u0016\u0010W\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u00105R\u0016\u0010Z\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010YR\u0016\u0010\u000b\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\\R\u0016\u0010^\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010]\u00a8\u0006b"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuWrapper;", "Lcom/tencent/qqnt/aio/menu/m;", "Landroid/view/View;", "archer", "", "k", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "", "p", "Lcom/tencent/qqnt/aio/menu/strategy/j;", "mMenuBubbleStrategy", "Lkotlin/Function0;", "onAnimationEnd", "j", "", "hashCode", DomainData.DOMAIN_NAME, "(Ljava/lang/Integer;)V", "g", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "anchorView", "f", "", "v", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/PointF;", "downPoint", ReportConstant.COSTREPORT_PREFIX, "bottom", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "top", "r", "Lcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;", ParseCommon.CONTAINER, "b", "Lcom/tencent/qqnt/aio/menu/al;", "selectLocation", "showSelectMenu", "a", "needAnimation", tl.h.F, "l", "menuLayout", "touchOutsideToDismiss", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$ArrowType;", "arrowType", "t", "I", "getMenuType", "()I", "menuType", "Lcom/tencent/qqnt/aio/menu/w;", "Lcom/tencent/qqnt/aio/menu/w;", "getOnMenuActionListener", "()Lcom/tencent/qqnt/aio/menu/w;", "onMenuActionListener", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow$c;", "c", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow$c;", "getDismissListener", "()Lcom/tencent/qqnt/aio/widget/BubblePopupWindow$c;", "dismissListener", "d", "offsetLocationY", "e", "heightToolbar", "paddingInputBar", "selectMenuBottomPadding", "CURSOR_DIA", "i", "mLastLocationX", "mLastLocationY", "Landroid/graphics/PointF;", "mDownPoint", "Ljava/lang/Integer;", "mContainerTop", "mContainerBottom", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;", "mPopupWindow", "o", "mMsgType", "", "Ljava/lang/String;", "mMsgToUin", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$b;", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$b;", "Z", "isExitAnimation", "<init>", "(ILcom/tencent/qqnt/aio/menu/w;Lcom/tencent/qqnt/aio/widget/BubblePopupWindow$c;)V", "ArrowType", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MenuWrapper implements m {
    static IPatchRedirector $redirector_;

    /* renamed from: s */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: t */
    private static final int f351234t;

    /* renamed from: a, reason: from kotlin metadata */
    private final int menuType;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private final w onMenuActionListener;

    /* renamed from: c, reason: from kotlin metadata */
    @Nullable
    private final BubblePopupWindow.c dismissListener;

    /* renamed from: d, reason: from kotlin metadata */
    private int offsetLocationY;

    /* renamed from: e, reason: from kotlin metadata */
    private int heightToolbar;

    /* renamed from: f, reason: from kotlin metadata */
    private int paddingInputBar;

    /* renamed from: g, reason: from kotlin metadata */
    private int selectMenuBottomPadding;

    /* renamed from: h */
    private final int CURSOR_DIA;

    /* renamed from: i, reason: from kotlin metadata */
    private int mLastLocationX;

    /* renamed from: j, reason: from kotlin metadata */
    private int mLastLocationY;

    /* renamed from: k, reason: from kotlin metadata */
    @NotNull
    private final PointF mDownPoint;

    /* renamed from: l, reason: from kotlin metadata */
    @Nullable
    private Integer mContainerTop;

    /* renamed from: m */
    @Nullable
    private Integer mContainerBottom;

    /* renamed from: n */
    @Nullable
    private BubblePopupWindow mPopupWindow;

    /* renamed from: o, reason: from kotlin metadata */
    private int mMsgType;

    /* renamed from: p, reason: from kotlin metadata */
    @NotNull
    private String mMsgToUin;

    /* renamed from: q */
    @NotNull
    private b mMenuBubbleStrategy;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean isExitAnimation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuWrapper$ArrowType;", "", "(Ljava/lang/String;I)V", "UP", "BOTTOM", "IGNORE", "aio_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class ArrowType extends Enum<ArrowType> {
        private static final /* synthetic */ ArrowType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ArrowType BOTTOM;
        public static final ArrowType IGNORE;
        public static final ArrowType UP;

        private static final /* synthetic */ ArrowType[] $values() {
            return new ArrowType[]{UP, BOTTOM, IGNORE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47477);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            UP = new ArrowType("UP", 0);
            BOTTOM = new ArrowType("BOTTOM", 1);
            IGNORE = new ArrowType("IGNORE", 2);
            $VALUES = $values();
        }

        ArrowType(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ArrowType valueOf(String str) {
            return (ArrowType) Enum.valueOf(ArrowType.class, str);
        }

        public static ArrowType[] values() {
            return (ArrowType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J<\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001`\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuWrapper$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "c", "", "msgToUin", QQBrowserActivity.KEY_MSG_TYPE, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "PADDING_BOTTOM_INCREMENT", "I", "d", "()I", "ARROW_DOWN", "ARROW_IGNORE", "ARROW_UP", "LEFT_AREA", "RIGHT_AREA", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.MenuWrapper$a */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        private final int b(MsgRecord msgRecord) {
            ArrayList<MsgElement> arrayList;
            if (msgRecord != null) {
                arrayList = msgRecord.elements;
            } else {
                arrayList = null;
            }
            int i3 = 0;
            if (arrayList == null || msgRecord.elements.size() != 1) {
                return 0;
            }
            Iterator<MsgElement> it = msgRecord.elements.iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                PicElement picElement = next.picElement;
                if (picElement != null) {
                    Intrinsics.checkNotNullExpressionValue(picElement, "element.picElement");
                    i3 = e(picElement);
                }
                FaceElement faceElement = next.faceElement;
                if (faceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(faceElement, "element.faceElement");
                    i3 = c(faceElement);
                }
                if (next.marketFaceElement != null) {
                    i3 = 10;
                }
                if (next.faceBubbleElement != null) {
                    i3 = 11;
                }
            }
            return i3;
        }

        private final int c(FaceElement faceElement) {
            if (faceElement.faceType == 3) {
                return 8;
            }
            return 0;
        }

        private final int e(PicElement picElement) {
            EmojiZPlan emojiZPlan = picElement.emojiZplan;
            if (emojiZPlan != null && emojiZPlan.actionId != 0) {
                return 9;
            }
            int i3 = picElement.picSubType;
            if (i3 == 1) {
                return 1;
            }
            if (i3 == 2) {
                return 2;
            }
            if (i3 == 3) {
                return 3;
            }
            if (i3 != 7) {
                if (i3 != 11) {
                    if (i3 == 13) {
                        return 7;
                    }
                    if (i3 != 14) {
                        return 0;
                    }
                    return 4;
                }
                return 6;
            }
            return 5;
        }

        @NotNull
        public final HashMap<String, Object> a(@Nullable MsgRecord msgRecord, @NotNull String msgToUin, int r75) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HashMap) iPatchRedirector.redirect((short) 3, this, msgRecord, msgToUin, Integer.valueOf(r75));
            }
            Intrinsics.checkNotNullParameter(msgToUin, "msgToUin");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("touin", msgToUin);
            hashMap.put("longpress_message_type", Integer.valueOf(r75));
            hashMap.put("emoji_type", Integer.valueOf(b(msgRecord)));
            return hashMap;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return MenuWrapper.f351234t;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J0\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J:\u0010\u0016\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH&Jy\u0010%\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\fH&\u00a2\u0006\u0004\b%\u0010&\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuWrapper$b;", "", "Landroid/view/View;", "anchorView", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$c;", "initInfo", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$d;", "d", "Lcom/tencent/qqnt/aio/menu/al;", "selectLocation", "", "selectMenuBottomPadding", "a", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;", "popup", HippyTKDListViewAdapter.X, "y", "offsetWidth", "displayWidth", "", "c", "Landroid/content/Context;", "ctx", "Lcom/tencent/qqnt/aio/menu/w;", "onMenuActionListener", "", "ignoreTouchLocation", "containerBottom", "source", "showSelectMenu", "Lcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;", "creator", "", "msgUin", QQBrowserActivity.KEY_MSG_TYPE, "b", "(Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;Landroid/content/Context;Landroid/view/View;Lcom/tencent/qqnt/aio/menu/ui/c;Lcom/tencent/qqnt/aio/menu/w;ZLjava/lang/Integer;Landroid/view/View;ZLcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;Ljava/lang/String;I)Landroid/view/View;", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes23.dex */
        public static final class a {
            @NotNull
            public static String a(@NotNull b bVar, int i3) {
                if (i3 == R.id.z4d) {
                    return "16";
                }
                if (i3 == R.id.z4c) {
                    return "17";
                }
                if (i3 == R.id.z4f) {
                    return "18";
                }
                if (i3 == R.id.z4e) {
                    return "19";
                }
                if (i3 == R.id.f166240z42) {
                    return "20";
                }
                if (i3 == R.id.z4r) {
                    return "22";
                }
                if (i3 == R.id.z48) {
                    return "23";
                }
                if (i3 == R.id.z3h) {
                    return "24";
                }
                if (i3 == R.id.z4g) {
                    return "25";
                }
                if (i3 == R.id.z3m) {
                    return "26";
                }
                return "";
            }
        }

        @NotNull
        d a(@NotNull View anchorView, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull c initInfo, @NotNull al selectLocation, int selectMenuBottomPadding);

        @NotNull
        View b(@Nullable BubblePopupWindow popup, @NotNull Context ctx, @NotNull View anchorView, @Nullable com.tencent.qqnt.aio.menu.ui.c menu, @NotNull w onMenuActionListener, boolean ignoreTouchLocation, @Nullable Integer containerBottom, @Nullable View source, boolean showSelectMenu, @Nullable QQCustomMenuNoIconLayout creator, @NotNull String msgUin, int r122);

        void c(@Nullable BubblePopupWindow popup, @NotNull View anchorView, int r36, int y16, int offsetWidth, int displayWidth);

        @NotNull
        d d(@NotNull View anchorView, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull c initInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018R\u0019\u0010!\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b\u0010\u0010 R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b\n\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuWrapper$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Point;", "a", "Landroid/graphics/Point;", tl.h.F, "()Landroid/graphics/Point;", "point", "Lkotlin/Pair;", "b", "Lkotlin/Pair;", "e", "()Lkotlin/Pair;", "lastLocation", "c", "I", "d", "()I", "heightToolbar", "f", "offset", "g", "paddingInputBar", "cursorDIA", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "containerTop", "containerBottom", "<init>", "(Landroid/graphics/Point;Lkotlin/Pair;ILkotlin/Pair;IILjava/lang/Integer;Ljava/lang/Integer;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: from kotlin metadata */
        @Nullable
        private final Point point;

        /* renamed from: b, reason: from kotlin metadata */
        @NotNull
        private final Pair<Integer, Integer> lastLocation;

        /* renamed from: c, reason: from kotlin metadata */
        private final int heightToolbar;

        /* renamed from: d, reason: from kotlin metadata */
        @NotNull
        private final Pair<Integer, Integer> offset;

        /* renamed from: e, reason: from kotlin metadata */
        private final int paddingInputBar;

        /* renamed from: f, reason: from kotlin metadata */
        private final int cursorDIA;

        /* renamed from: g, reason: from kotlin metadata */
        @Nullable
        private final Integer containerTop;

        /* renamed from: h */
        @Nullable
        private final Integer containerBottom;

        public c(@Nullable Point point, @NotNull Pair<Integer, Integer> lastLocation, int i3, @NotNull Pair<Integer, Integer> offset, int i16, int i17, @Nullable Integer num, @Nullable Integer num2) {
            Intrinsics.checkNotNullParameter(lastLocation, "lastLocation");
            Intrinsics.checkNotNullParameter(offset, "offset");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, point, lastLocation, Integer.valueOf(i3), offset, Integer.valueOf(i16), Integer.valueOf(i17), num, num2);
                return;
            }
            this.point = point;
            this.lastLocation = lastLocation;
            this.heightToolbar = i3;
            this.offset = offset;
            this.paddingInputBar = i16;
            this.cursorDIA = i17;
            this.containerTop = num;
            this.containerBottom = num2;
        }

        @Nullable
        public final Integer a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Integer) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.containerBottom;
        }

        @Nullable
        public final Integer b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Integer) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.containerTop;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.cursorDIA;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.heightToolbar;
        }

        @NotNull
        public final Pair<Integer, Integer> e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Pair) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.lastLocation;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.point, cVar.point) && Intrinsics.areEqual(this.lastLocation, cVar.lastLocation) && this.heightToolbar == cVar.heightToolbar && Intrinsics.areEqual(this.offset, cVar.offset) && this.paddingInputBar == cVar.paddingInputBar && this.cursorDIA == cVar.cursorDIA && Intrinsics.areEqual(this.containerTop, cVar.containerTop) && Intrinsics.areEqual(this.containerBottom, cVar.containerBottom)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final Pair<Integer, Integer> f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Pair) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.offset;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.paddingInputBar;
        }

        @Nullable
        public final Point h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Point) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.point;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
            }
            Point point = this.point;
            int i3 = 0;
            if (point == null) {
                hashCode = 0;
            } else {
                hashCode = point.hashCode();
            }
            int hashCode3 = ((((((((((hashCode * 31) + this.lastLocation.hashCode()) * 31) + this.heightToolbar) * 31) + this.offset.hashCode()) * 31) + this.paddingInputBar) * 31) + this.cursorDIA) * 31;
            Integer num = this.containerTop;
            if (num == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num.hashCode();
            }
            int i16 = (hashCode3 + hashCode2) * 31;
            Integer num2 = this.containerBottom;
            if (num2 != null) {
                i3 = num2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (String) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return "MenuBubbleInitInfo(point=" + this.point + ", lastLocation=" + this.lastLocation + ", heightToolbar=" + this.heightToolbar + ", offset=" + this.offset + ", paddingInputBar=" + this.paddingInputBar + ", cursorDIA=" + this.cursorDIA + ", containerTop=" + this.containerTop + ", containerBottom=" + this.containerBottom + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuWrapper$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", HippyTKDListViewAdapter.X, "c", "y", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$ArrowType;", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$ArrowType;", "()Lcom/tencent/qqnt/aio/menu/MenuWrapper$ArrowType;", "arrowType", "<init>", "(IILcom/tencent/qqnt/aio/menu/MenuWrapper$ArrowType;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: from kotlin metadata */
        private final int com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String;

        /* renamed from: b, reason: from kotlin metadata */
        private final int y;

        /* renamed from: c, reason: from kotlin metadata */
        @NotNull
        private final ArrowType arrowType;

        public d(int i3, int i16, @NotNull ArrowType arrowType) {
            Intrinsics.checkNotNullParameter(arrowType, "arrowType");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), arrowType);
                return;
            }
            this.com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String = i3;
            this.y = i16;
            this.arrowType = arrowType;
        }

        @NotNull
        public final ArrowType a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ArrowType) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.arrowType;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.y;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            if (this.com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String == dVar.com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String && this.y == dVar.y && this.arrowType == dVar.arrowType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String * 31) + this.y) * 31) + this.arrowType.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "MenuBubbleLocationInfo(x=" + this.com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.X java.lang.String + ", y=" + this.y + ", arrowType=" + this.arrowType + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47501);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
            f351234t = com.tencent.qqnt.aio.utils.l.b(300);
        }
    }

    public MenuWrapper(int i3, @NotNull w onMenuActionListener, @Nullable BubblePopupWindow.c cVar) {
        Intrinsics.checkNotNullParameter(onMenuActionListener, "onMenuActionListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), onMenuActionListener, cVar);
            return;
        }
        this.menuType = i3;
        this.onMenuActionListener = onMenuActionListener;
        this.dismissListener = cVar;
        this.mDownPoint = new PointF();
        this.mMsgToUin = "";
        this.mMenuBubbleStrategy = new com.tencent.qqnt.aio.menu.strategy.c();
    }

    private final void f(com.tencent.qqnt.aio.menu.ui.c menu, AIOMsgItem msgItem, View anchorView) {
        b bVar;
        if (v(menu, msgItem, anchorView)) {
            bVar = this.mMenuBubbleStrategy;
            if (!(bVar instanceof com.tencent.qqnt.aio.menu.strategy.j)) {
                bVar = new com.tencent.qqnt.aio.menu.strategy.j();
            }
        } else {
            bVar = this.mMenuBubbleStrategy;
            if (!(bVar instanceof com.tencent.qqnt.aio.menu.strategy.c)) {
                bVar = new com.tencent.qqnt.aio.menu.strategy.c();
            }
        }
        this.mMenuBubbleStrategy = bVar;
    }

    private final void g() {
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            bubblePopupWindow.w();
        }
        this.mPopupWindow = new BubblePopupWindow(-2, -2);
    }

    public static /* synthetic */ void i(MenuWrapper menuWrapper, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        menuWrapper.h(z16);
    }

    private final void j(com.tencent.qqnt.aio.menu.strategy.j mMenuBubbleStrategy, Function0<Unit> onAnimationEnd) {
        this.isExitAnimation = true;
        mMenuBubbleStrategy.B(onAnimationEnd);
    }

    private final int[] k(View archer) {
        QBaseActivity qBaseActivity;
        int[] iArr = {0, ViewUtils.getScreenWidthByContext(BaseApplication.context)};
        if (archer != null && archer.getRootView() != null) {
            Context context = archer.getContext();
            if (context instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) context;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity == null) {
                return iArr;
            }
            FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.ve_);
            if (findFragmentById == null) {
                findFragmentById = supportFragmentManager.findFragmentById(R.id.ve8);
            }
            Fragment findFragmentById2 = supportFragmentManager.findFragmentById(R.id.vea);
            if (findFragmentById != null && findFragmentById.isVisible() && findFragmentById.getView() != null && findFragmentById2 != null && findFragmentById2.isVisible() && findFragmentById2.getView() != null && archer.getRootView().getWidth() != findFragmentById.requireView().getWidth()) {
                iArr[0] = findFragmentById2.requireView().getWidth();
                iArr[1] = findFragmentById.requireView().getWidth();
            } else {
                com.tencent.mobileqq.aio.utils.e eVar = com.tencent.mobileqq.aio.utils.e.f194142a;
                int[] c16 = eVar.c();
                if (c16 != null) {
                    iArr[0] = c16[0];
                    iArr[1] = eVar.d();
                } else {
                    Context context2 = archer.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                    Window window = ((QBaseActivity) context2).getWindow();
                    if (window != null) {
                        iArr[1] = window.getDecorView().getWidth();
                    }
                }
            }
        }
        return iArr;
    }

    private final void m(Activity activity, View view, int i3, int i16) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                int[] k3 = k(view);
                this.mMenuBubbleStrategy.c(this.mPopupWindow, view, i3, i16, k3[0], k3[1]);
                return;
            }
            return;
        }
        Context context = view.getContext();
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            int[] k16 = k(view);
            this.mMenuBubbleStrategy.c(this.mPopupWindow, view, i3, i16, k16[0], k16[1]);
        }
    }

    public final void n(Integer num) {
        int i3;
        this.isExitAnimation = false;
        if (num != null) {
            BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
            if (bubblePopupWindow != null) {
                i3 = bubblePopupWindow.hashCode();
            } else {
                i3 = 0;
            }
            if (num.intValue() != i3) {
                return;
            }
        }
        BubblePopupWindow bubblePopupWindow2 = this.mPopupWindow;
        if (bubblePopupWindow2 != null) {
            bubblePopupWindow2.w();
        }
        this.mPopupWindow = null;
        this.mMsgType = 0;
    }

    static /* synthetic */ void o(MenuWrapper menuWrapper, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        menuWrapper.n(num);
    }

    private final void p(com.tencent.qqnt.aio.menu.ui.c menu) {
        if (menu.d() <= 0) {
            return;
        }
        MsgRecord msgRecord = menu.b(0).d().getMsgRecord();
        this.mMsgType = msgRecord.msgType;
        String valueOf = String.valueOf(msgRecord.senderUin);
        this.mMsgToUin = valueOf;
        com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_long_menu", INSTANCE.a(msgRecord, valueOf, this.mMsgType));
        ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(MobileQQ.sMobileQQ.peekAppRuntime(), "", String.valueOf(msgRecord.peerUin), "0X800C5F0", "0X800C5F0", msgRecord.chatType, 0, "", "", "", "");
    }

    public static final void u(com.tencent.qqnt.aio.menu.ui.c cVar, MenuWrapper this$0) {
        MsgRecord msgRecord;
        com.tencent.qqnt.aio.menu.ui.d b16;
        AIOMsgItem d16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion companion = INSTANCE;
        if (cVar != null && (b16 = cVar.b(0)) != null && (d16 = b16.d()) != null) {
            msgRecord = d16.getMsgRecord();
        } else {
            msgRecord = null;
        }
        com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_long_menu", companion.a(msgRecord, this$0.mMsgToUin, this$0.mMsgType));
        BubblePopupWindow.c cVar2 = this$0.dismissListener;
        if (cVar2 != null) {
            cVar2.onDismiss();
        }
    }

    private final boolean v(com.tencent.qqnt.aio.menu.ui.c menu, AIOMsgItem msgItem, View anchorView) {
        Integer num;
        AIOMsgItem d16;
        MsgRecord msgRecord;
        com.tencent.qqnt.aio.menu.ui.d b16 = menu.b(0);
        if (b16 != null && (d16 = b16.d()) != null && (msgRecord = d16.getMsgRecord()) != null) {
            num = Integer.valueOf(msgRecord.chatType);
        } else {
            num = null;
        }
        if (!MenuUtils.f351230a.l() || num == null || num.intValue() != 2 || !((IAIOEmoReplyMenuApi) QRoute.api(IAIOEmoReplyMenuApi.class)).hasEmoReplyMenu(anchorView.getContext(), msgItem)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.menu.m
    public void a(@NotNull al selectLocation, @NotNull View archer, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @Nullable QQCustomMenuNoIconLayout r27, boolean showSelectMenu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, selectLocation, archer, menu, r27, Boolean.valueOf(showSelectMenu));
            return;
        }
        Intrinsics.checkNotNullParameter(selectLocation, "selectLocation");
        Intrinsics.checkNotNullParameter(archer, "archer");
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (menu.d() <= 0) {
            QLog.i("MenuWrapper", 2, "[showSelectMenu] menu is empty");
            return;
        }
        AIOMsgItem msgItem = menu.b(0).d();
        this.mMsgType = menu.b(0).d().getMsgRecord().msgType;
        this.mMsgToUin = String.valueOf(menu.b(0).d().getMsgRecord().senderUin);
        g();
        Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
        f(menu, msgItem, archer);
        View m3 = MenuUtils.f351230a.m(archer);
        b bVar = this.mMenuBubbleStrategy;
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        Context context = archer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "archer.context");
        View b16 = bVar.b(bubblePopupWindow, context, archer, menu, this.onMenuActionListener, true, this.mContainerBottom, m3, showSelectMenu, null, this.mMsgToUin, this.mMsgType);
        b bVar2 = this.mMenuBubbleStrategy;
        PointF pointF = this.mDownPoint;
        d a16 = bVar2.a(archer, menu, new c(new Point((int) pointF.x, (int) pointF.y), new Pair(Integer.valueOf(this.mLastLocationX), Integer.valueOf(this.mLastLocationY)), this.heightToolbar, new Pair(0, Integer.valueOf(this.offsetLocationY)), this.paddingInputBar, this.CURSOR_DIA, this.mContainerTop, this.mContainerBottom), selectLocation, this.selectMenuBottomPadding);
        t(archer, a16.b(), a16.c(), menu, b16, com.tencent.qqnt.util.b.f362976b.enableTalkBack(), a16.a(), null);
        p(menu);
    }

    @Override // com.tencent.qqnt.aio.menu.m
    public void b(@NotNull View v3, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @Nullable QQCustomMenuNoIconLayout r26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, v3, menu, r26);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (menu.d() <= 0) {
            QLog.i("MenuWrapper", 2, "[showNormalMenu] menu is empty");
            return;
        }
        AIOMsgItem msgItem = menu.b(0).d();
        this.mMsgType = menu.b(0).d().getMsgRecord().msgType;
        this.mMsgToUin = String.valueOf(menu.b(0).d().getMsgRecord().senderUin);
        g();
        Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
        f(menu, msgItem, v3);
        View m3 = MenuUtils.f351230a.m(v3);
        b bVar = this.mMenuBubbleStrategy;
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        View b16 = bVar.b(bubblePopupWindow, context, v3, menu, this.onMenuActionListener, true, this.mContainerBottom, m3, false, null, this.mMsgToUin, this.mMsgType);
        b bVar2 = this.mMenuBubbleStrategy;
        PointF pointF = this.mDownPoint;
        d d16 = bVar2.d(v3, menu, new c(new Point((int) pointF.x, (int) pointF.y), new Pair(Integer.valueOf(this.mLastLocationX), Integer.valueOf(this.mLastLocationY)), this.heightToolbar, new Pair(0, Integer.valueOf(this.offsetLocationY)), this.paddingInputBar, this.CURSOR_DIA, this.mContainerTop, this.mContainerBottom));
        t(v3, d16.b(), d16.c(), menu, b16, com.tencent.qqnt.util.b.f362976b.enableTalkBack(), d16.a(), null);
        p(menu);
    }

    public final void h(boolean z16) {
        boolean z17;
        com.tencent.qqnt.aio.menu.strategy.j jVar;
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        if (bubblePopupWindow != null) {
            int i3 = 0;
            if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (!z16) {
                    o(this, null, 1, null);
                    return;
                }
                if (this.isExitAnimation) {
                    return;
                }
                b bVar = this.mMenuBubbleStrategy;
                if (bVar instanceof com.tencent.qqnt.aio.menu.strategy.j) {
                    jVar = (com.tencent.qqnt.aio.menu.strategy.j) bVar;
                } else {
                    jVar = null;
                }
                if (jVar != null) {
                    BubblePopupWindow bubblePopupWindow2 = this.mPopupWindow;
                    if (bubblePopupWindow2 != null) {
                        i3 = bubblePopupWindow2.hashCode();
                    }
                    j(jVar, new Function0<Unit>(i3) { // from class: com.tencent.qqnt.aio.menu.MenuWrapper$dismiss$1$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int $popupWindowHashCode;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$popupWindowHashCode = i3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MenuWrapper.this, i3);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                MenuWrapper.this.n(Integer.valueOf(this.$popupWindowHashCode));
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    o(this, null, 1, null);
                }
            }
        }
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        if (bubblePopupWindow != null) {
            Intrinsics.checkNotNull(bubblePopupWindow);
            if (bubblePopupWindow.isShowing()) {
                return true;
            }
        }
        return false;
    }

    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mContainerBottom = Integer.valueOf(i3);
        }
    }

    public final void r(int top) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, top);
        } else {
            this.mContainerTop = Integer.valueOf(top);
        }
    }

    public final void s(@NotNull PointF downPoint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) downPoint);
        } else {
            Intrinsics.checkNotNullParameter(downPoint, "downPoint");
            this.mDownPoint.set(downPoint);
        }
    }

    protected final void t(@NotNull View archer, int r85, int y16, @Nullable final com.tencent.qqnt.aio.menu.ui.c menu, @NotNull View menuLayout, boolean touchOutsideToDismiss, @NotNull ArrowType arrowType, @Nullable Activity r142) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, archer, Integer.valueOf(r85), Integer.valueOf(y16), menu, menuLayout, Boolean.valueOf(touchOutsideToDismiss), arrowType, r142);
            return;
        }
        Intrinsics.checkNotNullParameter(archer, "archer");
        Intrinsics.checkNotNullParameter(menuLayout, "menuLayout");
        Intrinsics.checkNotNullParameter(arrowType, "arrowType");
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.H(menuLayout);
            bubblePopupWindow.G(new ColorDrawable(0));
            bubblePopupWindow.N(touchOutsideToDismiss);
            if (touchOutsideToDismiss) {
                bubblePopupWindow.I(true);
            }
            bubblePopupWindow.P(1);
            bubblePopupWindow.K(2);
            if (arrowType == ArrowType.UP) {
                z16 = true;
            }
            bubblePopupWindow.L(z16);
            bubblePopupWindow.M(new BubblePopupWindow.c() { // from class: com.tencent.qqnt.aio.menu.s
                @Override // com.tencent.qqnt.aio.widget.BubblePopupWindow.c
                public final void onDismiss() {
                    MenuWrapper.u(com.tencent.qqnt.aio.menu.ui.c.this, this);
                }
            });
        }
        m(r142, archer, r85, y16);
        this.mLastLocationX = r85;
        this.mLastLocationY = y16;
    }
}
