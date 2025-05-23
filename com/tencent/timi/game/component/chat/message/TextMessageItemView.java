package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import nr2.ba;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$GiftMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import trpc.yes.common.YoloRoomOuterClass$YokoGameRoomSendNoticeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCommunityConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0002@AB'\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010<\u001a\u00020\u0016\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0002J3\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cJ\u0017\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0014\u00a2\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\fH\u0014J\u0016\u0010'\u001a\u00020\u00042\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010)\u001a\u00020\u0004H\u0014R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006B"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/TextMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Lcom/tencent/timi/game/tim/api/message/a;", "msgId", "", "b0", "msg", "Z", "", "content", "Y", "X", "", "isHost", "W", "V", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "it", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", ExifInterface.LATITUDE_SOUTH, "giftName", "", "giftNum", BdhLogUtil.LogTag.Tag_Req, "(Ltrpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/String;Ljava/lang/Integer;Z)V", "T", "a0", "", "roomId", "setRoomId", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "p", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Ltrpc/yes/common/MessageOuterClass$AtUser;", "data", "c0", "I", NodeProps.ON_DETACHED_FROM_WINDOW, "", "f0", "Ljava/util/Map;", "atUserInfoMap", "Landroid/text/SpannableStringBuilder;", "g0", "Landroid/text/SpannableStringBuilder;", "spannable", "h0", "J", "Lnr2/ba;", "i0", "Lnr2/ba;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "j0", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TextMessageItemView extends BaseMessageView {

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k0, reason: collision with root package name */
    private static final Bitmap f376585k0;

    /* renamed from: l0, reason: collision with root package name */
    @NotNull
    private static final xn4.a f376586l0;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, CommonOuterClass$QQUserId> atUserInfoMap;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SpannableStringBuilder spannable;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ba binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001c\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/TextMessageItemView$a;", "", "", "b", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "arrowBitmap", "Landroid/graphics/Bitmap;", "Lxn4/a;", "arrowSpan", "Lxn4/a;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.component.chat.message.TextMessageItemView$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b() {
            ((sm4.a) mm4.b.b(sm4.a.class)).m1(null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ<\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/TextMessageItemView$b;", "Landroid/text/style/LineHeightSpan;", "", "text", "", "start", "end", "spanstartv", NodeProps.LINE_HEIGHT, "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "chooseHeight", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements LineHeightSpan {
        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(@Nullable CharSequence text, int start, int end, int spanstartv, int lineHeight, @Nullable Paint.FontMetricsInt fm5) {
            int roundToInt;
            if (fm5 == null) {
                return;
            }
            if (start == 0) {
                fm5.descent += fh4.b.b(5);
                return;
            }
            int i3 = fm5.descent - fm5.ascent;
            if (i3 < 0) {
                return;
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(fm5.descent * (fh4.b.d(14) / i3));
            fm5.descent = roundToInt;
            fm5.ascent = roundToInt - fh4.b.b(14);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/TextMessageItemView$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376591a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f376592b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Integer f376593c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextMessageItemView f376594d;

        c(CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, Integer num, TextMessageItemView textMessageItemView) {
            this.f376591a = commonOuterClass$QQUserId;
            this.f376592b = str;
            this.f376593c = num;
            this.f376594d = textMessageItemView;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo userInfo) {
            String str;
            if (userInfo != null) {
                str = userInfo.i(this.f376591a);
            } else {
                str = null;
            }
            if (str != null) {
                String str2 = this.f376592b;
                Integer num = this.f376593c;
                this.f376594d.binding.f420974b.setText(Html.fromHtml(str + "\u9001\u7ed9\u4f60<font color=\"#F5A300\">" + str2 + HippyTKDListViewAdapter.X + num + "</font>\uff0c\u6709\u6548\u5bf9\u5c40\u7ed3\u675f\u540e\uff0c\u793c\u7269\u624d\u4f1a\u5230\u8d26\u54e6"));
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.e("TxtMsgView ", "getUserInfoFromDBOrNet errCode == " + errorCode + ",errMsg == " + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/TextMessageItemView$d", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376595a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f376596b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Integer f376597c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextMessageItemView f376598d;

        d(CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, Integer num, TextMessageItemView textMessageItemView) {
            this.f376595a = commonOuterClass$QQUserId;
            this.f376596b = str;
            this.f376597c = num;
            this.f376598d = textMessageItemView;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo userInfo) {
            String str;
            if (userInfo != null) {
                str = userInfo.i(this.f376595a);
            } else {
                str = null;
            }
            if (str != null) {
                String str2 = this.f376596b;
                Integer num = this.f376597c;
                this.f376598d.binding.f420974b.setText(Html.fromHtml("\u4f60\u9001\u7ed9" + str + "<font color=\"#F5A300\">" + str2 + HippyTKDListViewAdapter.X + num + "</font>\uff0c\u6e38\u620f\u5f00\u59cb\u524d\u9000\u51fa\u7ec4\u961f\uff0c\u6216\u5bf9\u5c40\u8d28\u91cf\u5dee\uff0c\u53ef\u5168\u989d\u8fd4\u8fd8"));
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.e("TxtMsgView ", "getUserInfoFromDBOrNet errCode == " + errorCode + ",errMsg == " + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/TextMessageItemView$e", "Lrh2/c;", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftInfo", "", "e", "", "errCode", "", "errMsg", "onFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements rh2.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomInfo f376599d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextMessageItemView f376600e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376601f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f376602h;

        e(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, TextMessageItemView textMessageItemView, CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16) {
            this.f376599d = yoloRoomOuterClass$YoloRoomInfo;
            this.f376600e = textMessageItemView;
            this.f376601f = commonOuterClass$QQUserId;
            this.f376602h = z16;
        }

        @Override // rh2.c
        public void e(@Nullable com.tencent.mobileqq.qqgift.data.service.d giftInfo) {
            String str;
            if (giftInfo != null) {
                str = giftInfo.f264876e;
            } else {
                str = null;
            }
            int i3 = this.f376599d.game_data_info.common_game_data_info.gift_config.gift_num.get();
            if (i3 > 0) {
                this.f376600e.R(this.f376601f, str, Integer.valueOf(i3), this.f376602h);
            } else {
                com.tencent.timi.game.utils.l.e("TxtMsgView ", "getGiftDetail errMsg == giftNum is 0, please make sure this is gift team");
            }
        }

        @Override // qh2.d
        public void onFailed(int errCode, @Nullable String errMsg) {
            com.tencent.timi.game.utils.l.e("TxtMsgView ", "getGiftDetail errCode == " + errCode + ",errMsg == " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/component/chat/message/TextMessageItemView$f", "Lcom/tencent/timi/game/component/chat/at/a;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "atUserId", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements com.tencent.timi.game.component.chat.at.a {
        f() {
        }

        @Override // com.tencent.timi.game.component.chat.at.a
        public void a(@Nullable CommonOuterClass$QQUserId atUserId) {
            Long l3;
            PBUInt64Field pBUInt64Field;
            PBInt32Field pBInt32Field;
            PBUInt64Field pBUInt64Field2;
            if (atUserId != null && (pBUInt64Field2 = atUserId.uid) != null) {
                l3 = Long.valueOf(pBUInt64Field2.get());
            } else {
                l3 = null;
            }
            if (com.tencent.timi.game.utils.o.f("team_msg_click_" + l3, 300L)) {
                return;
            }
            TextMessageItemView.this.binding.f420974b.performClick();
            if (atUserId != null) {
                TextMessageItemView textMessageItemView = TextMessageItemView.this;
                QBaseActivity activity = vf4.a.b();
                if (activity != null) {
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    YoloRoomOuterClass$YoloRoomInfo roomInfo = textMessageItemView.getRoomInfo();
                    boolean z16 = false;
                    if (roomInfo != null && (pBInt32Field = roomInfo.room_type) != null && pBInt32Field.get() == 5) {
                        z16 = true;
                    }
                    if (z16) {
                        PBUInt64Field pBUInt64Field3 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5).room_id;
                        th4.k kVar = th4.k.f436355a;
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        kVar.e(activity, atUserId, pBUInt64Field3.get());
                        return;
                    }
                    YoloRoomOuterClass$YoloRoomInfo z17 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
                    if (z17 != null && (pBUInt64Field = z17.room_id) != null) {
                        long j3 = pBUInt64Field.get();
                        boolean a26 = ((sm4.a) mm4.b.b(sm4.a.class)).a2(j3);
                        com.tencent.timi.game.team.impl.team.c cVar = com.tencent.timi.game.team.impl.team.c.f379747a;
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        cVar.h(activity, atUserId, a26, j3);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/component/chat/message/TextMessageItemView$g", "Lcom/tencent/timi/game/ui/a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g extends com.tencent.timi.game.ui.a {
        g() {
        }

        @Override // com.tencent.timi.game.ui.a, android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
            if (z16 != null) {
                ((ag4.i) mm4.b.b(ag4.i.class)).Q2(z16.room_data_info.game_id.get());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/component/chat/message/TextMessageItemView$h", "Lcom/tencent/timi/game/ui/a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h extends com.tencent.timi.game.ui.a {
        h() {
        }

        @Override // com.tencent.timi.game.ui.a, android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (!com.tencent.timi.game.utils.o.f("handleShareClick", ((fm4.g) mm4.b.b(fm4.g.class)).S2().a() * 1000)) {
                ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
                ConcurrentHashMap<String, String> d16 = com.tencent.timi.game.team.impl.main.f.d(TextMessageItemView.this.roomId);
                Intrinsics.checkNotNullExpressionValue(d16, "getCommonRoomInfoReportParam(roomId)");
                bVar.reportEvent("clck", widget, d16);
                TextMessageItemView.INSTANCE.b();
                return;
            }
            com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
        }
    }

    static {
        Bitmap arrowBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.oaa), fh4.b.b(12), fh4.b.b(12), false);
        f376585k0 = arrowBitmap;
        Intrinsics.checkNotNullExpressionValue(arrowBitmap, "arrowBitmap");
        f376586l0 = new xn4.a(arrowBitmap, fh4.b.b(1), fh4.b.b(1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMessageItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(CommonOuterClass$QQUserId qqUserId, String giftName, Integer giftNum, boolean isHost) {
        MessageOuterClass$MsgContent a16;
        MessageOuterClass$GiftMsg messageOuterClass$GiftMsg;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId2;
        if (isHost) {
            com.tencent.timi.game.tim.api.message.a msg2 = getMsg();
            if (msg2 != null && (a16 = msg2.a()) != null && (messageOuterClass$GiftMsg = a16.gift_msg) != null && (commonOuterClass$QQUserId = messageOuterClass$GiftMsg.recv_user_id) != null && (commonOuterClass$QQUserId2 = commonOuterClass$QQUserId.get()) != null) {
                ((bo4.d) mm4.b.b(bo4.d.class)).I3(commonOuterClass$QQUserId2, new c(commonOuterClass$QQUserId2, giftName, giftNum, this));
                return;
            }
            return;
        }
        ((bo4.d) mm4.b.b(bo4.d.class)).I3(qqUserId, new d(qqUserId, giftName, giftNum, this));
    }

    private final void S(YoloRoomOuterClass$YoloRoomInfo it, CommonOuterClass$QQUserId qqUserId, boolean isHost) {
        oh2.b a16;
        um4.k kVar = um4.k.f439239a;
        kVar.c();
        nh2.c d16 = kVar.d();
        if (d16 != null && (a16 = d16.a()) != null) {
            a16.K(it.game_data_info.common_game_data_info.gift_config.gift_id.get(), new e(it, this, qqUserId, isHost));
        }
    }

    private final void T(com.tencent.timi.game.tim.api.message.a msg2) {
        int a16;
        c0(msg2.a().at_user_msg.user_list.get());
        String text = com.tencent.mobileqq.qqlive.widget.util.c.a(msg2.a().at_user_msg.text.get());
        this.spannable.clear();
        this.spannable.clearSpans();
        this.spannable.append((CharSequence) text);
        SpecialMsgUtil specialMsgUtil = SpecialMsgUtil.f376345a;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Map<String, CommonOuterClass$QQUserId> map = this.atUserInfoMap;
        SpannableStringBuilder spannableStringBuilder = this.spannable;
        MessageLayout.a iImConfig = getIImConfig();
        if (iImConfig != null) {
            a16 = iImConfig.e(msg2);
        } else if (msg2.b()) {
            a16 = yn4.c.a(R.color.f158017al3);
        } else {
            a16 = yn4.c.a(R.color.f157985cu1);
        }
        specialMsgUtil.f(0, text, map, spannableStringBuilder, a16, false, new f());
        this.binding.f420974b.setText(new QQText(this.spannable, 3, 20));
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        TextView textView = this.binding.f420974b;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        String valueOf = String.valueOf(msg2.id());
        ConcurrentHashMap<String, String> L = YoloRoomUtil.L(getRoomInfo());
        Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportParam(roomInfo)");
        bVar.c(textView, false, valueOf, "em_yes_chat_at_msg", L);
        this.binding.f420974b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextMessageItemView.U(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.timi.game.utils.l.i("TextMessageView", "em_yes_chat_at_msg click");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V(com.tencent.timi.game.tim.api.message.a msg2) {
        int parseColor;
        String str = msg2.a().text_msg.text.get();
        TextView textView = this.binding.f420974b;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new g(), str.length() - 4, str.length(), 33);
        MessageLayout.a iImConfig = getIImConfig();
        if (iImConfig != null) {
            parseColor = iImConfig.a();
        } else {
            parseColor = Color.parseColor("#F5A300");
        }
        spannableString.setSpan(new ForegroundColorSpan(parseColor), str.length() - 4, str.length() - 1, 33);
        MessageLayout.a iImConfig2 = getIImConfig();
        if (iImConfig2 != null) {
            f376586l0.a(iImConfig2.a());
        }
        spannableString.setSpan(f376586l0, str.length() - 1, str.length(), 33);
        textView.setText(spannableString);
    }

    private final void W(boolean isHost) {
        YoloRoomOuterClass$YoloRoomInfo roomInfo = getRoomInfo();
        if (roomInfo != null) {
            CommonOuterClass$QQUserId qqUserId = roomInfo.owner_user_id;
            Intrinsics.checkNotNullExpressionValue(qqUserId, "qqUserId");
            S(roomInfo, qqUserId, isHost);
        }
    }

    private final void X(com.tencent.timi.game.tim.api.message.a msg2) {
        int parseColor;
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        TextView textView = this.binding.f420974b;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        String valueOf = String.valueOf(msg2.id());
        ConcurrentHashMap<String, String> d16 = com.tencent.timi.game.team.impl.main.f.d(this.roomId);
        Intrinsics.checkNotNullExpressionValue(d16, "getCommonRoomInfoReportParam(roomId)");
        bVar.a(textView, false, valueOf, "em_yes_chat_send_smoba_cpdd", d16);
        if (((sm4.a) mm4.b.b(sm4.a.class)).y3()) {
            this.binding.f420974b.setText("\u5df2\u7ecf\u6210\u529f\u521b\u5efa\u8f66\u961f\uff0c\u5feb\u53bb\u9080\u8bf7\u89c2\u4f17\u52a0\u5165\u5427");
        } else {
            TextView textView2 = this.binding.f420974b;
            SpannableString spannableString = new SpannableString("\u4f60\u5df2\u7ecf\u6210\u529f\u521b\u5efa\u8f66\u961f\uff0c\u5feb\u53bb\u9080\u8bf7\u597d\u53cb\u52a0\u5165\u5427 \u53d1\u9001\u5230\u5927\u5385 ");
            spannableString.setSpan(new h(), 20, 26, 33);
            MessageLayout.a iImConfig = getIImConfig();
            if (iImConfig != null) {
                parseColor = iImConfig.a();
            } else {
                parseColor = Color.parseColor("#F5A300");
            }
            spannableString.setSpan(new ForegroundColorSpan(parseColor), 20, 25, 33);
            MessageLayout.a iImConfig2 = getIImConfig();
            if (iImConfig2 != null) {
                f376586l0.a(iImConfig2.a());
            }
            spannableString.setSpan(f376586l0, 25, 26, 33);
            textView2.setText(spannableString);
        }
        this.binding.f420974b.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void Y(String content) {
        String a16 = com.tencent.mobileqq.qqlive.widget.util.c.a("\u3010\u623f\u95f4\u516c\u544a\u3011\n" + content);
        TextView textView = this.binding.f420974b;
        QQText qQText = new QQText(a16, 3, 20);
        qQText.setSpan(new b(), 0, qQText.length(), 33);
        textView.setText(qQText);
    }

    private final void Z(com.tencent.timi.game.tim.api.message.a msg2) {
        this.binding.f420974b.setText(new QQText(com.tencent.mobileqq.qqlive.widget.util.c.a(msg2.a().text_msg.text.get()), 3, 20));
    }

    private final void a0(com.tencent.timi.game.tim.api.message.a msg2) {
        this.binding.f420974b.setText(msg2.g());
        if (eh4.a.e()) {
            int i3 = msg2.a().yolo_room_action_msg.yolo_room_action.action_type.get();
            this.binding.f420974b.setText("\u8c03\u8bd5\u5c55\u793a\uff1a\u4e0d\u652f\u6301\u6d88\u606f\u7c7b\u578btype[" + msg2.type() + "], actionType[" + i3 + "]");
        }
        com.tencent.timi.game.utils.l.b("TextMessageViewDebug", "not support type " + msg2.type());
    }

    private final void b0(com.tencent.timi.game.tim.api.message.a msgId) {
        if (msgId != null) {
            com.tencent.timi.game.component.chat.at.b.INSTANCE.a().c(String.valueOf(msgId.j()), msgId.id());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    public void I(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        long j3;
        YoloRoomOuterClass$YoloRoomCommunityConf yoloRoomOuterClass$YoloRoomCommunityConf;
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
        PBStringField pBStringField;
        PBUInt64Field pBUInt64Field;
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction;
        YoloRoomOuterClass$YokoGameRoomSendNoticeAction yoloRoomOuterClass$YokoGameRoomSendNoticeAction;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.I(msg2);
        MessageLayout.a iImConfig = getIImConfig();
        if (iImConfig != null) {
            this.binding.f420974b.setTextColor(iImConfig.f(msg2));
        }
        int type = msg2.type();
        if (type == 49) {
            int a16 = zf4.a.a(msg2);
            if (a16 != -1) {
                String str = "";
                String str2 = null;
                if (a16 != 101) {
                    if (a16 == 153) {
                        MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg = msg2.a().yolo_room_action_msg;
                        if (messageOuterClass$YoloRoomActionMsg != null && (yoloRoomOuterClass$YoloRoomAction = messageOuterClass$YoloRoomActionMsg.yolo_room_action) != null && (yoloRoomOuterClass$YokoGameRoomSendNoticeAction = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_send_notice_action) != null && (pBStringField2 = yoloRoomOuterClass$YokoGameRoomSendNoticeAction.notice) != null) {
                            str2 = pBStringField2.get();
                        }
                        if (str2 != null) {
                            str = str2;
                        }
                        Y(str);
                    }
                } else {
                    fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
                    YoloRoomOuterClass$YoloRoomInfo roomInfo = getRoomInfo();
                    if (roomInfo != null && (pBUInt64Field = roomInfo.room_id) != null) {
                        j3 = pBUInt64Field.get();
                    } else {
                        j3 = 0;
                    }
                    YoloRoomOuterClass$YoloRoomConf Y = gVar.K0(j3).Y();
                    if (Y != null && (yoloRoomOuterClass$YoloRoomCommunityConf = Y.yolo_room_community_conf) != null && (wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf = yoloRoomOuterClass$YoloRoomCommunityConf.wuji_yolo_room_community_conf) != null && (pBStringField = wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.notice) != null) {
                        str2 = pBStringField.get();
                    }
                    if (str2 != null) {
                        str = str2;
                    }
                    Y(str);
                }
            } else {
                a0(msg2);
            }
        } else if (type == 1) {
            Z(msg2);
        } else if (type == pn4.e.d()) {
            X(msg2);
        } else if (type == 70) {
            T(msg2);
        } else if (type == pn4.e.b()) {
            W(false);
        } else if (type == pn4.e.c()) {
            W(true);
        } else if (type == pn4.e.a()) {
            V(msg2);
        } else {
            a0(msg2);
        }
        this.binding.f420974b.setOnTouchListener(getPositionOnTouchListener());
        this.binding.f420974b.setOnLongClickListener(getOnLongClickListner());
    }

    public final void c0(@Nullable List<MessageOuterClass$AtUser> data) {
        this.atUserInfoMap.clear();
        if (data != null) {
            for (MessageOuterClass$AtUser messageOuterClass$AtUser : data) {
                CommonOuterClass$QQUserId atUserId = messageOuterClass$AtUser.user_id.get();
                String atUserName = messageOuterClass$AtUser.nick_name.get();
                if (!TextUtils.isEmpty(atUserName)) {
                    Map<String, CommonOuterClass$QQUserId> map = this.atUserInfoMap;
                    Intrinsics.checkNotNullExpressionValue(atUserName, "atUserName");
                    Intrinsics.checkNotNullExpressionValue(atUserId, "atUserId");
                    map.put(atUserName, atUserId);
                }
            }
        }
        com.tencent.timi.game.utils.l.i("TxtMsgView ", "atUserInfoMap =" + this.atUserInfoMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.tencent.timi.game.tim.api.message.a msg2 = getMsg();
        if (msg2 != null && msg2.i()) {
            b0(msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    @Nullable
    public LongClickOperOption[] p() {
        ArrayList arrayList = new ArrayList();
        com.tencent.timi.game.tim.api.message.a msg2 = getMsg();
        if (msg2 != null) {
            if (msg2.type() == 1 || msg2.type() == 70) {
                arrayList.add(LongClickOperOption.COPY);
                if (!msg2.b()) {
                    arrayList.add(LongClickOperOption.REPORT);
                }
            }
            arrayList.add(LongClickOperOption.DELETE);
        }
        Object[] array = arrayList.toArray(new LongClickOperOption[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (LongClickOperOption[]) array;
    }

    public final void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    protected boolean z() {
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TextMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.atUserInfoMap = new LinkedHashMap();
        this.spannable = new SpannableStringBuilder();
        ba g16 = ba.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        g16.f420974b.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        g16.f420974b.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
