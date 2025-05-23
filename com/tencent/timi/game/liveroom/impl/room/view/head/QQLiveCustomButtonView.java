package com.tencent.timi.game.liveroom.impl.room.view.head;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0019\u0012\u0006\u0010U\u001a\u00020T\u0012\b\u0010W\u001a\u0004\u0018\u00010V\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015J\u0019\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0019\u0010\fR\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0018\u0010)\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001bR\u0018\u0010+\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001bR\u0018\u0010-\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001eR\u0018\u0010/\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001eR\u0018\u00101\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u001eR\u0018\u00103\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001eR\u0018\u00105\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010%R\u0018\u00107\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\u001eR\u0018\u00109\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\u001eR\u0018\u0010;\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\u001eR\u0018\u0010=\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u001eR\u0018\u0010?\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010%R:\u0010D\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010@j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u0001`A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00104R\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00104R$\u0010O\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010S\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010J\u001a\u0004\bQ\u0010L\"\u0004\bR\u0010N\u00a8\u0006\\"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "d", "", "p", ReportConstant.COSTREPORT_PREFIX, "r", "flag", "o", "(Ljava/lang/Integer;)V", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "i", "e", "g", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$a;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "setButtonInfos", "u", "Landroid/view/View;", "Landroid/view/View;", "containView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "singleModeGray", "f", "singleModeLight", tl.h.F, "singleModeIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "singleModeDesc", "singleModeInnerIcon", BdhLogUtil.LogTag.Tag_Conn, "leftContainer", "D", "rightContainer", "E", "leftGray", UserInfo.SEX_FEMALE, "leftLight", "G", "leftIcon", "H", "leftInnerIcon", "I", "leftContainDesc", "J", "rightGray", "K", "rightLight", "L", "rightIcon", "M", "rightInnerIcon", "N", "rightContainDesc", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "P", "Ljava/util/HashMap;", "uiFlagMap", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "currentUiMode", BdhLogUtil.LogTag.Tag_Req, "uiFlag", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$a;", "getFirstButtonInfo", "()Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$a;", "setFirstButtonInfo", "(Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$a;)V", "firstButtonInfo", "T", "getSecondButtonInfo", "setSecondButtonInfo", "secondButtonInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "U", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveCustomButtonView extends FrameLayout {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int V;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View leftContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View rightContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView leftGray;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView leftLight;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView leftIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ImageView leftInnerIcon;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView leftContainDesc;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ImageView rightGray;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView rightLight;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView rightIcon;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ImageView rightInnerIcon;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView rightContainDesc;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private HashMap<Integer, View> uiFlagMap;

    /* renamed from: Q, reason: from kotlin metadata */
    private int currentUiMode;

    /* renamed from: R, reason: from kotlin metadata */
    private int uiFlag;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private Companion.ButtonInfo firstButtonInfo;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Companion.ButtonInfo secondButtonInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View containView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView singleModeGray;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView singleModeLight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView singleModeIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView singleModeDesc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView singleModeInnerIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u001b\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0005R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0005R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0005R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0005R\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a;", "", "", "b", "DOUBLE_MODE", "I", "LEFT_SHOW_GRAY", "LEFT_SHOW_INNER_ICON", "LEFT_SHOW_LIGHT", "LEFT_SHOW_MAIN_ICON", "LEFT_SHOW_TEXT", "RIGHT_SHOW_GRAY", "RIGHT_SHOW_INNER_ICON", "RIGHT_SHOW_LIGHT", "RIGHT_SHOW_MAIN_ICON", "RIGHT_SHOW_TEXT", "SINGLE_MODE", "SINGLE_MODE_GRAY", "SINGLE_MODE_LIGHT", "SINGLE_MODE_SHOW_INNER_ICON", "SINGLE_MODE_SHOW_MAIN_ICON", "SINGLE_MODE_SHOW_TEXT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveCustomButtonView$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010&\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\t\u0010\u0019R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u000e\u0010\u001eR\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u0011\u0010\u001eR\u0019\u0010!\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u0014\u0010\u001eR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u0017\u0010\u001eR\u0019\u0010&\u001a\u0004\u0018\u00010#8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b\u001c\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "g", "()Z", "isGray", "b", tl.h.F, "isLight", "c", "i", "isShowIcon", "d", "j", "isShowInnerIcon", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "btnTxt", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "buttonBgGray", "buttonBgLight", "buttonIcon", "buttonInnerButton", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$b;", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$b;", "()Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$b;", "onClickListener", "<init>", "(ZZZZLjava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$b;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveCustomButtonView$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class ButtonInfo {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean isGray;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean isLight;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean isShowIcon;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean isShowInnerIcon;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final String btnTxt;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final Drawable buttonBgGray;

            /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final Drawable buttonBgLight;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final Drawable buttonIcon;

            /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final Drawable buttonInnerButton;

            /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final b onClickListener;

            public ButtonInfo(boolean z16, boolean z17, boolean z18, boolean z19, @Nullable String str, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, @Nullable b bVar) {
                this.isGray = z16;
                this.isLight = z17;
                this.isShowIcon = z18;
                this.isShowInnerIcon = z19;
                this.btnTxt = str;
                this.buttonBgGray = drawable;
                this.buttonBgLight = drawable2;
                this.buttonIcon = drawable3;
                this.buttonInnerButton = drawable4;
                this.onClickListener = bVar;
            }

            @Nullable
            /* renamed from: a, reason: from getter */
            public final String getBtnTxt() {
                return this.btnTxt;
            }

            @Nullable
            /* renamed from: b, reason: from getter */
            public final Drawable getButtonBgGray() {
                return this.buttonBgGray;
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final Drawable getButtonBgLight() {
                return this.buttonBgLight;
            }

            @Nullable
            /* renamed from: d, reason: from getter */
            public final Drawable getButtonIcon() {
                return this.buttonIcon;
            }

            @Nullable
            /* renamed from: e, reason: from getter */
            public final Drawable getButtonInnerButton() {
                return this.buttonInnerButton;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ButtonInfo)) {
                    return false;
                }
                ButtonInfo buttonInfo = (ButtonInfo) other;
                if (this.isGray == buttonInfo.isGray && this.isLight == buttonInfo.isLight && this.isShowIcon == buttonInfo.isShowIcon && this.isShowInnerIcon == buttonInfo.isShowInnerIcon && Intrinsics.areEqual(this.btnTxt, buttonInfo.btnTxt) && Intrinsics.areEqual(this.buttonBgGray, buttonInfo.buttonBgGray) && Intrinsics.areEqual(this.buttonBgLight, buttonInfo.buttonBgLight) && Intrinsics.areEqual(this.buttonIcon, buttonInfo.buttonIcon) && Intrinsics.areEqual(this.buttonInnerButton, buttonInfo.buttonInnerButton) && Intrinsics.areEqual(this.onClickListener, buttonInfo.onClickListener)) {
                    return true;
                }
                return false;
            }

            @Nullable
            /* renamed from: f, reason: from getter */
            public final b getOnClickListener() {
                return this.onClickListener;
            }

            /* renamed from: g, reason: from getter */
            public final boolean getIsGray() {
                return this.isGray;
            }

            /* renamed from: h, reason: from getter */
            public final boolean getIsLight() {
                return this.isLight;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v20 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
            public int hashCode() {
                int hashCode;
                int hashCode2;
                int hashCode3;
                int hashCode4;
                int hashCode5;
                boolean z16 = this.isGray;
                int i3 = 1;
                ?? r06 = z16;
                if (z16) {
                    r06 = 1;
                }
                int i16 = r06 * 31;
                ?? r26 = this.isLight;
                int i17 = r26;
                if (r26 != 0) {
                    i17 = 1;
                }
                int i18 = (i16 + i17) * 31;
                ?? r27 = this.isShowIcon;
                int i19 = r27;
                if (r27 != 0) {
                    i19 = 1;
                }
                int i26 = (i18 + i19) * 31;
                boolean z17 = this.isShowInnerIcon;
                if (!z17) {
                    i3 = z17 ? 1 : 0;
                }
                int i27 = (i26 + i3) * 31;
                String str = this.btnTxt;
                int i28 = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i29 = (i27 + hashCode) * 31;
                Drawable drawable = this.buttonBgGray;
                if (drawable == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = drawable.hashCode();
                }
                int i36 = (i29 + hashCode2) * 31;
                Drawable drawable2 = this.buttonBgLight;
                if (drawable2 == null) {
                    hashCode3 = 0;
                } else {
                    hashCode3 = drawable2.hashCode();
                }
                int i37 = (i36 + hashCode3) * 31;
                Drawable drawable3 = this.buttonIcon;
                if (drawable3 == null) {
                    hashCode4 = 0;
                } else {
                    hashCode4 = drawable3.hashCode();
                }
                int i38 = (i37 + hashCode4) * 31;
                Drawable drawable4 = this.buttonInnerButton;
                if (drawable4 == null) {
                    hashCode5 = 0;
                } else {
                    hashCode5 = drawable4.hashCode();
                }
                int i39 = (i38 + hashCode5) * 31;
                b bVar = this.onClickListener;
                if (bVar != null) {
                    i28 = bVar.hashCode();
                }
                return i39 + i28;
            }

            /* renamed from: i, reason: from getter */
            public final boolean getIsShowIcon() {
                return this.isShowIcon;
            }

            /* renamed from: j, reason: from getter */
            public final boolean getIsShowInnerIcon() {
                return this.isShowInnerIcon;
            }

            @NotNull
            public String toString() {
                return "ButtonInfo(isGray=" + this.isGray + ", isLight=" + this.isLight + ", isShowIcon=" + this.isShowIcon + ", isShowInnerIcon=" + this.isShowInnerIcon + ", btnTxt=" + this.btnTxt + ", buttonBgGray=" + this.buttonBgGray + ", buttonBgLight=" + this.buttonBgLight + ", buttonIcon=" + this.buttonIcon + ", buttonInnerButton=" + this.buttonInnerButton + ", onClickListener=" + this.onClickListener + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveCustomButtonView$a$b;", "", "Landroid/view/View;", "view", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveCustomButtonView$a$b */
        /* loaded from: classes26.dex */
        public interface b {
            void a(@NotNull View view);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            int i3 = 0;
            for (int i16 = 32768; i16 != 0; i16 >>= 1) {
                i3 += i16;
            }
            return i3;
        }

        Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        V = companion.b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveCustomButtonView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        q();
    }

    private final void d() {
        HashMap<Integer, View> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(2, this.singleModeGray), TuplesKt.to(4, this.singleModeLight), TuplesKt.to(8, this.singleModeIcon), TuplesKt.to(16, this.singleModeInnerIcon), TuplesKt.to(32, this.singleModeDesc), TuplesKt.to(64, this.leftGray), TuplesKt.to(128, this.leftLight), TuplesKt.to(256, this.leftIcon), TuplesKt.to(512, this.leftInnerIcon), TuplesKt.to(1024, this.leftContainDesc), TuplesKt.to(2048, this.rightGray), TuplesKt.to(4096, this.rightLight), TuplesKt.to(8192, this.rightIcon), TuplesKt.to(16384, this.rightInnerIcon), TuplesKt.to(32768, this.rightContainDesc));
        this.uiFlagMap = hashMapOf;
    }

    private final void e() {
        ImageView imageView;
        ImageView imageView2;
        String btnTxt;
        ImageView imageView3;
        ImageView imageView4;
        l();
        View view = this.leftContainer;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QQLiveCustomButtonView.f(QQLiveCustomButtonView.this, view2);
                }
            });
        }
        Companion.ButtonInfo buttonInfo = this.firstButtonInfo;
        if (buttonInfo != null) {
            Drawable buttonBgGray = buttonInfo.getButtonBgGray();
            if (buttonBgGray != null && (imageView4 = this.leftGray) != null) {
                imageView4.setBackground(buttonBgGray);
            }
            Drawable buttonBgLight = buttonInfo.getButtonBgLight();
            if (buttonBgLight != null && (imageView3 = this.leftLight) != null) {
                imageView3.setBackground(buttonBgLight);
            }
            Companion.ButtonInfo buttonInfo2 = this.firstButtonInfo;
            if (buttonInfo2 != null && (btnTxt = buttonInfo2.getBtnTxt()) != null) {
                StringsKt__StringsJVMKt.isBlank(btnTxt);
            }
            TextView textView = this.leftContainDesc;
            if (textView != null) {
                textView.setText(buttonInfo.getBtnTxt());
            }
            Drawable buttonIcon = buttonInfo.getButtonIcon();
            if (buttonIcon != null && (imageView2 = this.leftIcon) != null) {
                imageView2.setImageDrawable(buttonIcon);
            }
            Drawable buttonInnerButton = buttonInfo.getButtonInnerButton();
            if (buttonInnerButton != null && (imageView = this.leftInnerIcon) != null) {
                imageView.setImageDrawable(buttonInnerButton);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(QQLiveCustomButtonView this$0, View view) {
        Companion.b onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.ButtonInfo buttonInfo = this$0.firstButtonInfo;
        if (buttonInfo != null && (onClickListener = buttonInfo.getOnClickListener()) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            onClickListener.a(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g() {
        ImageView imageView;
        ImageView imageView2;
        String btnTxt;
        ImageView imageView3;
        ImageView imageView4;
        l();
        View view = this.rightContainer;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QQLiveCustomButtonView.h(QQLiveCustomButtonView.this, view2);
                }
            });
        }
        Companion.ButtonInfo buttonInfo = this.secondButtonInfo;
        if (buttonInfo != null) {
            Drawable buttonBgGray = buttonInfo.getButtonBgGray();
            if (buttonBgGray != null && (imageView4 = this.rightGray) != null) {
                imageView4.setBackground(buttonBgGray);
            }
            Drawable buttonBgLight = buttonInfo.getButtonBgLight();
            if (buttonBgLight != null && (imageView3 = this.rightLight) != null) {
                imageView3.setBackground(buttonBgLight);
            }
            Companion.ButtonInfo buttonInfo2 = this.firstButtonInfo;
            if (buttonInfo2 != null && (btnTxt = buttonInfo2.getBtnTxt()) != null) {
                StringsKt__StringsJVMKt.isBlank(btnTxt);
            }
            TextView textView = this.rightContainDesc;
            if (textView != null) {
                textView.setText(buttonInfo.getBtnTxt());
            }
            Drawable buttonIcon = buttonInfo.getButtonIcon();
            if (buttonIcon != null && (imageView2 = this.rightIcon) != null) {
                imageView2.setImageDrawable(buttonIcon);
            }
            Drawable buttonInnerButton = buttonInfo.getButtonInnerButton();
            if (buttonInnerButton != null && (imageView = this.rightInnerIcon) != null) {
                imageView.setImageDrawable(buttonInnerButton);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QQLiveCustomButtonView this$0, View view) {
        Companion.b onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.ButtonInfo buttonInfo = this$0.secondButtonInfo;
        if (buttonInfo != null && (onClickListener = buttonInfo.getOnClickListener()) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            onClickListener.a(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i() {
        ImageView imageView;
        ImageView imageView2;
        String btnTxt;
        ImageView imageView3;
        ImageView imageView4;
        l();
        View view = this.containView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQLiveCustomButtonView.j(QQLiveCustomButtonView.this, view2);
            }
        });
        Companion.ButtonInfo buttonInfo = this.firstButtonInfo;
        if (buttonInfo != null) {
            Drawable buttonBgGray = buttonInfo.getButtonBgGray();
            if (buttonBgGray != null && (imageView4 = this.singleModeGray) != null) {
                imageView4.setBackground(buttonBgGray);
            }
            Drawable buttonBgLight = buttonInfo.getButtonBgLight();
            if (buttonBgLight != null && (imageView3 = this.singleModeLight) != null) {
                imageView3.setBackground(buttonBgLight);
            }
            Companion.ButtonInfo buttonInfo2 = this.firstButtonInfo;
            if (buttonInfo2 != null && (btnTxt = buttonInfo2.getBtnTxt()) != null) {
                StringsKt__StringsJVMKt.isBlank(btnTxt);
            }
            TextView textView = this.singleModeDesc;
            if (textView != null) {
                textView.setText(buttonInfo.getBtnTxt());
            }
            Drawable buttonIcon = buttonInfo.getButtonIcon();
            if (buttonIcon != null && (imageView2 = this.singleModeIcon) != null) {
                imageView2.setImageDrawable(buttonIcon);
            }
            Drawable buttonInnerButton = buttonInfo.getButtonInnerButton();
            if (buttonInnerButton != null && (imageView = this.singleModeInnerIcon) != null) {
                imageView.setImageDrawable(buttonInnerButton);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(QQLiveCustomButtonView this$0, View view) {
        Companion.b onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.ButtonInfo buttonInfo = this$0.firstButtonInfo;
        if (buttonInfo != null && (onClickListener = buttonInfo.getOnClickListener()) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            onClickListener.a(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k() {
        int i3 = this.currentUiMode;
        if (i3 == 0) {
            i();
        } else if (i3 == 1) {
            e();
            g();
        }
    }

    private final void l() {
        Set<Integer> keySet;
        int i3;
        HashMap<Integer, View> hashMap = this.uiFlagMap;
        if (hashMap != null && (keySet = hashMap.keySet()) != null) {
            for (Integer flag : keySet) {
                HashMap<Integer, View> hashMap2 = this.uiFlagMap;
                Intrinsics.checkNotNull(hashMap2);
                View view = hashMap2.get(flag);
                if (view != null) {
                    Intrinsics.checkNotNullExpressionValue(flag, "flag");
                    if (m(flag.intValue())) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    view.setVisibility(i3);
                }
            }
        }
    }

    private final boolean m(int flag) {
        if ((this.uiFlag & flag) == flag) {
            return true;
        }
        return false;
    }

    private final void n() {
        boolean z16;
        int i3 = this.uiFlag;
        boolean z17 = false;
        if (i3 < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 > V) {
            z17 = true;
        }
        if (z17 | z16) {
            QLog.e("QQLivePenguinView", 1, "invalid flag:" + i3);
            return;
        }
        QLog.e("QQLivePenguinView", 1, "change ui flag:" + i3);
    }

    private final void o(Integer flag) {
        int i3;
        Companion.ButtonInfo buttonInfo;
        if (flag != null) {
            n();
            u(flag);
            return;
        }
        if (this.secondButtonInfo == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if ((i3 & 0) == 0 && (buttonInfo = this.firstButtonInfo) != null) {
            if (buttonInfo.getIsLight()) {
                i3 |= 4;
            }
            if (buttonInfo.getIsGray()) {
                i3 |= 2;
            }
            if (buttonInfo.getIsShowIcon()) {
                i3 |= 8;
            }
            if (buttonInfo.getIsShowInnerIcon()) {
                i3 |= 16;
            }
            if (!TextUtils.isEmpty(buttonInfo.getBtnTxt())) {
                i3 |= 32;
            }
        }
        if ((i3 & 1) == 1) {
            Companion.ButtonInfo buttonInfo2 = this.firstButtonInfo;
            if (buttonInfo2 != null) {
                if (buttonInfo2.getIsLight()) {
                    i3 |= 128;
                }
                if (buttonInfo2.getIsGray()) {
                    i3 |= 64;
                }
                if (buttonInfo2.getIsShowIcon()) {
                    i3 |= 256;
                }
                if (buttonInfo2.getIsShowInnerIcon()) {
                    i3 |= 512;
                }
                if (!TextUtils.isEmpty(buttonInfo2.getBtnTxt())) {
                    i3 |= 1024;
                }
            }
            Companion.ButtonInfo buttonInfo3 = this.secondButtonInfo;
            if (buttonInfo3 != null) {
                if (buttonInfo3.getIsLight()) {
                    i3 |= 4096;
                }
                if (buttonInfo3.getIsGray()) {
                    i3 |= 2048;
                }
                if (buttonInfo3.getIsShowIcon()) {
                    i3 |= 8192;
                }
                if (buttonInfo3.getIsShowInnerIcon()) {
                    i3 |= 16384;
                }
                if (!TextUtils.isEmpty(buttonInfo3.getBtnTxt())) {
                    i3 |= 32768;
                }
            }
        }
        this.uiFlag = i3;
    }

    private final int p() {
        if ((this.uiFlag & 1) == 1) {
            return 1;
        }
        return 0;
    }

    private final void q() {
        int p16 = p();
        this.currentUiMode = p16;
        if (p16 == 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.haq, (ViewGroup) this, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026mode_layout, this, false)");
            this.containView = inflate;
            s();
        } else if (p16 == 1) {
            View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.hap, (ViewGroup) this, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(context).inflate(R.\u2026mode_layout, this, false)");
            this.containView = inflate2;
            r();
        }
        d();
    }

    private final void r() {
        View view = this.containView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view = null;
        }
        addView(view);
        View view3 = this.containView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view3 = null;
        }
        this.leftContainer = view3.findViewById(R.id.ygo);
        View view4 = this.containView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view4 = null;
        }
        this.rightContainer = view4.findViewById(R.id.f74383w4);
        View view5 = this.containView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view5 = null;
        }
        this.leftGray = (ImageView) view5.findViewById(R.id.f638134j);
        View view6 = this.containView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view6 = null;
        }
        this.rightGray = (ImageView) view6.findViewById(R.id.f638734p);
        View view7 = this.containView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view7 = null;
        }
        this.leftLight = (ImageView) view7.findViewById(R.id.f638434m);
        View view8 = this.containView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view8 = null;
        }
        this.rightLight = (ImageView) view8.findViewById(R.id.f639034s);
        View view9 = this.containView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view9 = null;
        }
        this.leftIcon = (ImageView) view9.findViewById(R.id.f638234k);
        View view10 = this.containView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view10 = null;
        }
        this.rightIcon = (ImageView) view10.findViewById(R.id.f638834q);
        View view11 = this.containView;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view11 = null;
        }
        this.leftInnerIcon = (ImageView) view11.findViewById(R.id.f638334l);
        View view12 = this.containView;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view12 = null;
        }
        this.rightInnerIcon = (ImageView) view12.findViewById(R.id.f638934r);
        View view13 = this.containView;
        if (view13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view13 = null;
        }
        this.leftContainDesc = (TextView) view13.findViewById(R.id.f638034i);
        View view14 = this.containView;
        if (view14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
        } else {
            view2 = view14;
        }
        this.rightContainDesc = (TextView) view2.findViewById(R.id.f638634o);
    }

    private final void s() {
        View view = this.containView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view = null;
        }
        addView(view);
        View view3 = this.containView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view3 = null;
        }
        this.singleModeGray = (ImageView) view3.findViewById(R.id.f637734f);
        View view4 = this.containView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view4 = null;
        }
        this.singleModeLight = (ImageView) view4.findViewById(R.id.f638534n);
        View view5 = this.containView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view5 = null;
        }
        this.singleModeIcon = (ImageView) view5.findViewById(R.id.f637834g);
        View view6 = this.containView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            view6 = null;
        }
        this.singleModeDesc = (TextView) view6.findViewById(R.id.f637234a);
        View view7 = this.containView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
        } else {
            view2 = view7;
        }
        this.singleModeInnerIcon = (ImageView) view2.findViewById(R.id.f637934h);
    }

    private final void t() {
        if (p() != this.currentUiMode) {
            View view = this.containView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containView");
                view = null;
            }
            removeView(view);
            q();
        }
        k();
    }

    public static /* synthetic */ void v(QQLiveCustomButtonView qQLiveCustomButtonView, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        qQLiveCustomButtonView.u(num);
    }

    public final void setButtonInfos(@Nullable Companion.ButtonInfo first, @Nullable Companion.ButtonInfo second) {
        this.firstButtonInfo = first;
        this.secondButtonInfo = second;
        v(this, null, 1, null);
    }

    public final void setFirstButtonInfo(@Nullable Companion.ButtonInfo buttonInfo) {
        this.firstButtonInfo = buttonInfo;
    }

    public final void setSecondButtonInfo(@Nullable Companion.ButtonInfo buttonInfo) {
        this.secondButtonInfo = buttonInfo;
    }

    public final void u(@Nullable Integer flag) {
        o(flag);
        n();
        t();
    }
}
