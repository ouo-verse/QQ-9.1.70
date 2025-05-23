package com.tencent.qqnt.aio.menu.emoreply.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.al;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmojiConstants;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel;
import com.tencent.qqnt.aio.emoreply.AIOEmoReplySelectMsgEvent;
import com.tencent.qqnt.aio.emoreply.j;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.aio.menu.emoreply.ui.AIOEmoReplyMoreAdapter;
import com.tencent.qqnt.aio.menu.emoreply.ui.AIOEmoReplyMorePanel;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u00035:>B\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002JF\u0010&\u001a\u00020\u00042\"\u0010#\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!`\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J<\u0010+\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\t\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\bH\u0002J>\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0.2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u00100\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0.*\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002JL\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\nH\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010IR\u0016\u0010L\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010NR\u0016\u0010Q\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010PR\u0016\u0010R\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010PR\u0016\u0010U\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010T\u00a8\u0006X"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMorePanel;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel;", "Landroid/content/Context;", "context", "", "t", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel$Source;", "source", "Landroid/view/View;", "anchorView", "", "isSelfMsg", "g", "f", "e", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", TtmlNode.ATTR_TTS_ORIGIN, "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/menu/emoreply/ui/VerticalAlign;", "k", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/HorizontalAlign;", h.F, "", "chatType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "params", "Lcom/tencent/qqnt/aio/emoreply/j;", "callBack", "r", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyPopupWindow;", "popupWindow", HippyNestedScrollComponent.PRIORITY_PARENT, NodeProps.PADDING_BOTTOM, ReportConstant.COSTREPORT_PREFIX, "p", "maxBottom", "Lkotlin/Pair;", "i", "j", "targetView", "v", "u", "from", "a", "dismiss", "isShowing", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyPopupWindow;", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AnimateExpandableFrameLayout;", "b", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AnimateExpandableFrameLayout;", "contentView", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "emoReplyRecyclerView", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "d", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "blurView", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMorePanel$c;", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMorePanel$c;", "onEmoReplyMoreClickListener", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter;", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter;", "adapter", "Z", "isBottom", "Lcom/tencent/qqnt/aio/menu/emoreply/c;", "Lcom/tencent/qqnt/aio/menu/emoreply/c;", "emoReplyFilter", "I", "panelWidth", "panelHeight", "", UserInfo.SEX_FEMALE, "scale", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOEmoReplyMorePanel implements IAIOEmoReplyMorePanel {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static final int f351346m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final Pair<Integer, Integer> f351347n;

    /* renamed from: o, reason: collision with root package name */
    private static final int f351348o;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOEmoReplyPopupWindow popupWindow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AnimateExpandableFrameLayout contentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private RecyclerView emoReplyRecyclerView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQBlurViewWrapper blurView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c onEmoReplyMoreClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOEmoReplyMoreAdapter adapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isBottom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.aio.menu.emoreply.c emoReplyFilter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int panelWidth;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int panelHeight;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float scale;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMorePanel$a;", "", "Landroid/content/Context;", "context", "", "b", "a", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "recentList", "c", "AnchorMargin", "I", "", "CLICK_POS", "Ljava/lang/String;", "Lkotlin/Pair;", "DefaultOffset", "Lkotlin/Pair;", "OPEN_SOURCE", "PanelHeight", "TAG", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.emoreply.ui.AIOEmoReplyMorePanel$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).intValue();
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return (int) (AIOEmoReplyMorePanel.f351348o * MenuUtils.f351230a.k(context));
        }

        public final int b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).intValue();
            }
            Intrinsics.checkNotNullParameter(context, "context");
            float k3 = MenuUtils.f351230a.k(context);
            AIOEmoReplyMoreAdapter.Companion companion = AIOEmoReplyMoreAdapter.INSTANCE;
            return (((int) (companion.d() * k3)) * EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI) + ((int) (companion.b() * k3)) + ((int) (companion.a() * k3));
        }

        @NotNull
        public final List<EmotionPanelData> c(@NotNull List<? extends EmotionPanelData> recentList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) recentList);
            }
            Intrinsics.checkNotNullParameter(recentList, "recentList");
            return recentList.subList(0, Math.min(EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI * 3, recentList.size()));
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMorePanel$b;", "Lcom/tencent/qqnt/aio/emoreply/j;", "", "emoticonType", EmojiManagerServiceConstant.PARAMS_EMOTICON_EID, "", "a", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyPopupWindow;", "c", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyPopupWindow;", "popupWindow", "d", "Lcom/tencent/qqnt/aio/emoreply/j;", "callBack", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyPopupWindow;Lcom/tencent/qqnt/aio/emoreply/j;)V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final AIOEmoReplyPopupWindow popupWindow;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final j callBack;

        public b(@NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable AIOEmoReplyPopupWindow aIOEmoReplyPopupWindow, @Nullable j jVar) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, msgRecord, aIOEmoReplyPopupWindow, jVar);
                return;
            }
            this.context = context;
            this.msgRecord = msgRecord;
            this.popupWindow = aIOEmoReplyPopupWindow;
            this.callBack = jVar;
        }

        @Override // com.tencent.qqnt.aio.emoreply.j
        public void a(int emoticonType, int emoticonId) {
            FragmentActivity fragmentActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(emoticonType), Integer.valueOf(emoticonId));
                return;
            }
            j jVar = this.callBack;
            if (jVar != null) {
                jVar.a(emoticonType, emoticonId);
                AIOEmoReplyPopupWindow aIOEmoReplyPopupWindow = this.popupWindow;
                if (aIOEmoReplyPopupWindow != null) {
                    aIOEmoReplyPopupWindow.d();
                    return;
                }
                return;
            }
            Context context = this.context;
            Unit unit = null;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, new AIOEmoReplySelectMsgEvent(emoticonId, emoticonType, this.msgRecord, new com.tencent.qqnt.aio.emoreply.h(new SystemAndEmojiEmotionInfo(emoticonType, emoticonId, ""), new int[]{0, 0}, new int[]{0, 0}, false, null, false, null, 0, 240, null)));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.e("AIOEmoReplyMorePanel", 1, "context to FragmentActivity failed: " + this.context);
            }
            AIOEmoReplyPopupWindow aIOEmoReplyPopupWindow2 = this.popupWindow;
            if (aIOEmoReplyPopupWindow2 != null) {
                aIOEmoReplyPopupWindow2.d();
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRB\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMorePanel$c;", "Lcom/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMoreAdapter$c;", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "emoticonInfo", "", "c", "info", "", "b", "a", "Lcom/tencent/qqnt/aio/emoreply/j;", "Lcom/tencent/qqnt/aio/emoreply/j;", "getSendCallback", "()Lcom/tencent/qqnt/aio/emoreply/j;", "e", "(Lcom/tencent/qqnt/aio/emoreply/j;)V", "sendCallback", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getFrom", "()Ljava/util/HashMap;", "d", "(Ljava/util/HashMap;)V", "from", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements AIOEmoReplyMoreAdapter.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private j sendCallback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private HashMap<String, Object> from;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final String b(SystemAndEmojiEmoticonInfo info) {
            String str = info.title;
            if (Intrinsics.areEqual(str, SystemAndEmojiEmoticonInfo.TITLE_SYSTEM)) {
                return "2";
            }
            if (Intrinsics.areEqual(str, SystemAndEmojiEmoticonInfo.TITLE_OFTEN)) {
                return "1";
            }
            if (!Intrinsics.areEqual(str, SystemAndEmojiEmoticonInfo.TITLE_EMOJI)) {
                return "2";
            }
            return "3";
        }

        private final void c(SystemAndEmojiEmoticonInfo emoticonInfo) {
            HashMap hashMap;
            String b16 = b(emoticonInfo);
            int convertToLocal = ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToLocal(emoticonInfo.code, emoticonInfo.emotionType);
            HashMap<String, Object> hashMap2 = this.from;
            if (hashMap2 != null) {
                hashMap = new HashMap(hashMap2);
            } else {
                hashMap = new HashMap();
            }
            hashMap.put("click_pos", b16);
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, String.valueOf(convertToLocal));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_emoticon_response_panel", hashMap);
            QLog.d("AIOEmoReplyMorePanel", 1, "send info.type=" + emoticonInfo.getEmoticonType() + ", info.code=" + emoticonInfo.code + ", serverId=" + convertToLocal);
        }

        @Override // com.tencent.qqnt.aio.menu.emoreply.ui.AIOEmoReplyMoreAdapter.c
        public void a(@NotNull SystemAndEmojiEmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticonInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(emoticonInfo, "emoticonInfo");
            com.tencent.qqnt.aio.emoReply.c cVar = com.tencent.qqnt.aio.emoReply.c.f349875a;
            int i3 = emoticonInfo.emotionType;
            int i16 = emoticonInfo.code;
            String str = emoticonInfo.title;
            Intrinsics.checkNotNullExpressionValue(str, "emoticonInfo.title");
            cVar.k(new SystemAndEmojiEmotionInfo(i3, i16, str));
            c(emoticonInfo);
            j jVar = this.sendCallback;
            if (jVar != null) {
                jVar.a(emoticonInfo.emotionType, emoticonInfo.code);
            }
        }

        public final void d(@Nullable HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) hashMap);
            } else {
                this.from = hashMap;
            }
        }

        public final void e(@Nullable j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar);
            } else {
                this.sendCallback = jVar;
            }
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351366a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33633);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[IAIOEmoReplyMorePanel.Source.values().length];
            try {
                iArr[IAIOEmoReplyMorePanel.Source.EMO_REPLY_ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IAIOEmoReplyMorePanel.Source.EMO_REPLY_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f351366a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J*\u0010\r\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMorePanel$e", "Lcom/tencent/qqnt/aio/menu/emoreply/c;", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "d", "", "Lcom/tencent/mobileqq/emoticonview/IFavoriteEmoticonInfo;", "c", "", "titleStart", "", "columnNum", "b", "data", "a", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class e implements com.tencent.qqnt.aio.menu.emoreply.c {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final boolean b(List<EmotionPanelData> list, EmotionPanelData emotionPanelData, boolean z16, int i3) {
            boolean z17;
            int size;
            if (!(emotionPanelData instanceof SystemAndEmojiEmoticonInfo)) {
                return false;
            }
            if (((SystemAndEmojiEmoticonInfo) emotionPanelData).emotionType == 3) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 && z16 && (size = list.size() % i3) > 0) {
                int i16 = i3 - size;
                for (int i17 = 0; i17 < i16; i17++) {
                    list.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, "", false));
                }
            }
            return z17;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:8:0x0015->B:20:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final boolean c(List<? extends EmotionPanelData> list, IFavoriteEmoticonInfo iFavoriteEmoticonInfo) {
            boolean z16;
            List<? extends EmotionPanelData> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            for (Parcelable parcelable : list2) {
                if (parcelable instanceof IFavoriteEmoticonInfo) {
                    IFavoriteEmoticonInfo iFavoriteEmoticonInfo2 = (IFavoriteEmoticonInfo) parcelable;
                    if (!TextUtils.isEmpty(iFavoriteEmoticonInfo2.getEid())) {
                        z16 = TextUtils.equals(iFavoriteEmoticonInfo.getEid(), iFavoriteEmoticonInfo2.getEid());
                    } else if (iFavoriteEmoticonInfo2.getType() == iFavoriteEmoticonInfo.getType()) {
                        z16 = true;
                    }
                    if (!z16) {
                        return true;
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:0: B:8:0x0015->B:22:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final boolean d(List<? extends EmotionPanelData> list, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
            boolean z16;
            List<? extends EmotionPanelData> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            for (EmotionPanelData emotionPanelData : list2) {
                if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo2 = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                    if (systemAndEmojiEmoticonInfo.emotionType == systemAndEmojiEmoticonInfo2.emotionType && systemAndEmojiEmoticonInfo.code == systemAndEmojiEmoticonInfo2.code) {
                        z16 = true;
                        if (!z16) {
                            return true;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqnt.aio.menu.emoreply.c
        @NotNull
        public List<EmotionPanelData> a(@NotNull List<? extends EmotionPanelData> data, int columnNum) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, columnNum);
            }
            Intrinsics.checkNotNullParameter(data, "data");
            List<? extends EmotionPanelData> emoReplyFilterData = ((IAIOEmoReplyApi) QRoute.api(IAIOEmoReplyApi.class)).getEmoReplyFilterData();
            if (emoReplyFilterData.isEmpty()) {
                return data;
            }
            List<EmotionPanelData> arrayList = new ArrayList<>();
            boolean z16 = false;
            for (EmotionPanelData emotionPanelData : data) {
                if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                    if (d(emoReplyFilterData, systemAndEmojiEmoticonInfo)) {
                        QLog.d("AIOEmoReplyMorePanel", 1, "filterEmotionData. type:" + systemAndEmojiEmoticonInfo.emotionType + ", id: " + systemAndEmojiEmoticonInfo.code);
                    }
                }
                if (!(emotionPanelData instanceof IFavoriteEmoticonInfo) || !c(emoReplyFilterData, (IFavoriteEmoticonInfo) emotionPanelData)) {
                    z16 = b(arrayList, emotionPanelData, z16, columnNum);
                    arrayList.add(emotionPanelData);
                }
            }
            QLog.d("AIOEmoReplyMorePanel", 1, "after filterEmotionData. filteredData size:" + arrayList.size() + ", origin data size: " + data.size());
            return arrayList;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/menu/emoreply/ui/AIOEmoReplyMorePanel$f", "Lcom/tencent/qqnt/aio/menu/emoreply/d;", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "emoReplyList", "", "d", "a", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class f implements com.tencent.qqnt.aio.menu.emoreply.d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f351368b;

        f(float f16) {
            this.f351368b = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AIOEmoReplyMorePanel.this, Float.valueOf(f16));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(f this$0, List emoReplyList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(emoReplyList, "$emoReplyList");
            this$0.d(emoReplyList);
        }

        private final void d(List<? extends EmotionPanelData> emoReplyList) {
            AIOEmoReplyMorePanel.this.adapter.w0(this.f351368b);
            AIOEmoReplyMorePanel.this.adapter.u0(emoReplyList);
        }

        @Override // com.tencent.qqnt.aio.menu.emoreply.d
        public void a(@NotNull final List<? extends EmotionPanelData> emoReplyList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoReplyList);
                return;
            }
            Intrinsics.checkNotNullParameter(emoReplyList, "emoReplyList");
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                d(emoReplyList);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.menu.emoreply.ui.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOEmoReplyMorePanel.f.c(AIOEmoReplyMorePanel.f.this, emoReplyList);
                    }
                });
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33684);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        int b16 = l.b(4);
        f351346m = b16;
        f351347n = new Pair<>(0, Integer.valueOf(b16));
        f351348o = l.b(313);
    }

    public AIOEmoReplyMorePanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.adapter = new AIOEmoReplyMoreAdapter(EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI);
        this.emoReplyFilter = new e();
        this.scale = 1.0f;
    }

    private final void e(View anchorView, boolean isSelfMsg) {
        float left;
        View view;
        float f16 = 0.0f;
        AnimateExpandableFrameLayout animateExpandableFrameLayout = null;
        if (isSelfMsg) {
            Object parent = anchorView.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
            if (view != null) {
                left = this.panelWidth - ((view.getWidth() - anchorView.getLeft()) - (anchorView.getWidth() / 2.0f));
            } else {
                left = 0.0f;
            }
        } else {
            left = anchorView.getLeft() + (anchorView.getWidth() / 2.0f);
        }
        if (!this.isBottom) {
            f16 = this.panelHeight;
        }
        AnimateExpandableFrameLayout animateExpandableFrameLayout2 = this.contentView;
        if (animateExpandableFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            animateExpandableFrameLayout = animateExpandableFrameLayout2;
        }
        animateExpandableFrameLayout.e(left, f16);
    }

    private final void f() {
        AnimateExpandableFrameLayout animateExpandableFrameLayout = this.contentView;
        if (animateExpandableFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            animateExpandableFrameLayout = null;
        }
        animateExpandableFrameLayout.g();
    }

    private final void g(IAIOEmoReplyMorePanel.Source source, View anchorView, boolean isSelfMsg) {
        int i3 = d.f351366a[source.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                f();
            }
        } else {
            e(anchorView, isSelfMsg);
        }
        AIOEmoReplyPopupWindow aIOEmoReplyPopupWindow = this.popupWindow;
        if (aIOEmoReplyPopupWindow != null) {
            aIOEmoReplyPopupWindow.q();
        }
    }

    private final HorizontalAlign h(boolean isSelfMsg) {
        if (isSelfMsg) {
            return HorizontalAlign.RIGHT;
        }
        return HorizontalAlign.LEFT;
    }

    private final Pair<Integer, Integer> i(IAIOEmoReplyMorePanel.Source source, View parent, View anchorView, int maxBottom, boolean isSelfMsg) {
        Pair<Integer, Integer> v3;
        int i3 = d.f351366a[source.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (parent == null || (v3 = v(anchorView, parent, isSelfMsg)) == null) {
                    return f351347n;
                }
                return v3;
            }
            throw new NoWhenBranchMatchedException();
        }
        int[] iArr = new int[2];
        anchorView.getLocationInWindow(iArr);
        int height = iArr[1] + anchorView.getHeight();
        int i16 = f351346m;
        if (height + i16 + this.panelHeight > maxBottom) {
            this.isBottom = false;
            return TuplesKt.to(Integer.valueOf(j(anchorView, isSelfMsg)), Integer.valueOf(((-anchorView.getHeight()) - i16) - this.panelHeight));
        }
        this.isBottom = true;
        return TuplesKt.to(Integer.valueOf(j(anchorView, isSelfMsg)), Integer.valueOf(i16));
    }

    private final int j(View anchorView, boolean isSelfMsg) {
        View view;
        Object parent = anchorView.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view == null) {
            return 0;
        }
        if (isSelfMsg) {
            return (view.getWidth() - anchorView.getLeft()) - anchorView.getWidth();
        }
        return -anchorView.getLeft();
    }

    private final VerticalAlign k(IAIOEmoReplyMorePanel.Source source) {
        int i3 = d.f351366a[source.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return VerticalAlign.TOP;
            }
            throw new NoWhenBranchMatchedException();
        }
        return VerticalAlign.BOTTOM;
    }

    private final SystemAndEmojiEmoticonInfo l(EmotionPanelData origin) {
        if (origin instanceof SystemAndEmojiEmotionInfo) {
            SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo = (SystemAndEmojiEmotionInfo) origin;
            return new SystemAndEmojiEmoticonInfo(7, systemAndEmojiEmotionInfo.c(), systemAndEmojiEmotionInfo.getCode(), systemAndEmojiEmotionInfo.getTitle(), false);
        }
        return null;
    }

    private final View m(Context context) {
        boolean z16;
        QQBlurViewWrapper qQBlurViewWrapper = new QQBlurViewWrapper(context, null, 0, 6, null);
        this.blurView = qQBlurViewWrapper;
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a aVar = new f.a(z16, 64.0f, null, -1, new ColorDrawable(context.getColor(R.color.cdl)), Integer.valueOf(R.drawable.jwh));
        aVar.o(true);
        qQBlurViewWrapper.a(aVar);
        qQBlurViewWrapper.setDebugTag("AIOEmoReplyMore");
        qQBlurViewWrapper.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return qQBlurViewWrapper;
    }

    private final View n(Context context, MsgRecord msgRecord) {
        AnimateExpandableFrameLayout animateExpandableFrameLayout = new AnimateExpandableFrameLayout(context);
        this.contentView = animateExpandableFrameLayout;
        ab.d(animateExpandableFrameLayout, l.b(24));
        animateExpandableFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.panelWidth, this.panelHeight));
        if (!u(msgRecord)) {
            animateExpandableFrameLayout.setBackgroundResource(R.drawable.jwi);
        } else {
            animateExpandableFrameLayout.setBackgroundResource(R.color.ajr);
            animateExpandableFrameLayout.addView(m(context));
        }
        RecyclerView recyclerView = new RecyclerView(context);
        this.emoReplyRecyclerView = recyclerView;
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        animateExpandableFrameLayout.addView(recyclerView);
        return animateExpandableFrameLayout;
    }

    private final void o(Context context, MsgRecord msgRecord) {
        AIOEmoReplyPopupWindow aIOEmoReplyPopupWindow = new AIOEmoReplyPopupWindow(context, this.panelWidth, this.panelHeight);
        aIOEmoReplyPopupWindow.k(n(context, msgRecord));
        this.popupWindow = aIOEmoReplyPopupWindow;
    }

    private final int p(View anchorView) {
        Rect rect = new Rect();
        anchorView.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    private final void q(Context context, int chatType) {
        List<SystemAndEmojiEmotionInfo> e16 = com.tencent.qqnt.aio.emoReply.c.f349875a.e(Integer.valueOf(chatType));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = e16.iterator();
        while (it.hasNext()) {
            SystemAndEmojiEmoticonInfo l3 = l((SystemAndEmojiEmotionInfo) it.next());
            if (l3 != null) {
                arrayList.add(l3);
            }
        }
        QLog.d("AIOEmoReplyMorePanel", 1, "convertedList size: " + arrayList.size());
        com.tencent.qqnt.aio.menu.emoreply.b.f351341a.b(EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI, new SystemAndEmojiEmoticonInfo.EmoticonParams(1, true, true), INSTANCE.c(arrayList), this.emoReplyFilter, new f(MenuUtils.f351230a.k(context)));
    }

    private final void r(HashMap<String, Object> params, Context context, MsgRecord msgRecord, j callBack) {
        c cVar = this.onEmoReplyMoreClickListener;
        if (cVar == null) {
            cVar = new c();
            this.onEmoReplyMoreClickListener = cVar;
            this.adapter.v0(cVar);
        }
        cVar.d(params);
        cVar.e(new b(context, msgRecord, this.popupWindow, callBack));
    }

    private final void s(AIOEmoReplyPopupWindow popupWindow, View anchorView, View parent, IAIOEmoReplyMorePanel.Source source, boolean isSelfMsg, int paddingBottom) {
        QQBlurViewWrapper qQBlurViewWrapper;
        if (popupWindow != null) {
            popupWindow.j(anchorView);
            int p16 = p(anchorView);
            Pair<Integer, Integer> i3 = i(source, parent, anchorView, p16, isSelfMsg);
            int intValue = i3.component1().intValue();
            int intValue2 = i3.component2().intValue();
            popupWindow.n(intValue);
            popupWindow.o(intValue2);
            popupWindow.p(k(source));
            popupWindow.l(h(isSelfMsg));
            popupWindow.i(paddingBottom);
            popupWindow.m(p16);
        }
        View m3 = MenuUtils.f351230a.m(anchorView);
        if (m3 != null && (qQBlurViewWrapper = this.blurView) != null) {
            qQBlurViewWrapper.setBlurSource(m3, null, null);
        }
    }

    private final void t(Context context) {
        this.scale = MenuUtils.f351230a.k(context);
        Companion companion = INSTANCE;
        this.panelWidth = companion.b(context);
        this.panelHeight = companion.a(context);
    }

    private final boolean u(MsgRecord msgRecord) {
        return MenuUtils.f351230a.c(msgRecord);
    }

    private final Pair<Integer, Integer> v(View view, View view2, boolean z16) {
        int i3;
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        if (z16) {
            i3 = (iArr[0] + view2.getWidth()) - (iArr2[0] + view.getWidth());
        } else {
            i3 = iArr[0] - iArr2[0];
        }
        AIOEmoReplyMoreAdapter.Companion companion = AIOEmoReplyMoreAdapter.INSTANCE;
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf((iArr[1] - iArr2[1]) - (((int) (companion.e() * this.scale)) + ((int) (companion.f() * this.scale)))));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel
    public void a(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull View anchorView, @Nullable View parent, @NotNull String from, @NotNull IAIOEmoReplyMorePanel.Source source, int paddingBottom, @Nullable j callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, msgRecord, anchorView, parent, from, source, Integer.valueOf(paddingBottom), callBack);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.d("AIOEmoReplyMorePanel", 1, "showEmoReplyMorePanel");
        int i3 = msgRecord.chatType;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("interact_tag_open_source", from);
        hashMap.put("touin", Long.valueOf(msgRecord.senderUin));
        com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_emoticon_response_panel", hashMap);
        t(context);
        if (this.popupWindow == null) {
            o(context, msgRecord);
            Unit unit = Unit.INSTANCE;
        }
        boolean g16 = al.g(msgRecord);
        r(hashMap, context, msgRecord, callBack);
        q(context, i3);
        s(this.popupWindow, anchorView, parent, source, g16, paddingBottom);
        g(source, anchorView, g16);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!isShowing()) {
            return;
        }
        AnimateExpandableFrameLayout animateExpandableFrameLayout = this.contentView;
        if (animateExpandableFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            animateExpandableFrameLayout = null;
        }
        animateExpandableFrameLayout.d(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.menu.emoreply.ui.AIOEmoReplyMorePanel$dismiss$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOEmoReplyMorePanel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AIOEmoReplyPopupWindow aIOEmoReplyPopupWindow;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                aIOEmoReplyPopupWindow = AIOEmoReplyMorePanel.this.popupWindow;
                if (aIOEmoReplyPopupWindow != null) {
                    aIOEmoReplyPopupWindow.d();
                }
            }
        });
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel
    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        AIOEmoReplyPopupWindow aIOEmoReplyPopupWindow = this.popupWindow;
        if (aIOEmoReplyPopupWindow != null) {
            return aIOEmoReplyPopupWindow.h();
        }
        return false;
    }
}
