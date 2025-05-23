package com.tencent.guild.aio.msglist.ark;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ark;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.guild.aio.help.GuildArkContainerHelper;
import com.tencent.guild.aio.msglist.ark.a;
import com.tencent.guild.aio.msglist.ark.g;
import com.tencent.guild.aio.msglist.ark.view.GuildArkAppView;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.api.ark.IGuildArkApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildArkStrokeApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQCustomArkDialogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b.\u0018\u0000 r2\u00020\u0001:\u0001sB\u000f\u0012\u0006\u0010@\u001a\u00020\u001a\u00a2\u0006\u0004\bq\u0010PJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J4\u0010\u0018\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001a\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J(\u0010!\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010#\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0014H\u0002J \u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0014H\u0002J&\u0010*\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u001c\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0,J2\u00105\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u00020\u001a2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203J\b\u00106\u001a\u00020\u001aH\u0016J\u0010\u00109\u001a\u00020\u001a2\u0006\u00108\u001a\u000207H\u0016J\b\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020\fH\u0016R\u0017\u0010@\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR$\u0010Q\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010=\u001a\u0004\bN\u0010?\"\u0004\bO\u0010PR$\u0010X\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u00100\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010=\u001a\u0004\bZ\u0010?\"\u0004\b[\u0010PR$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010m\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010=\u001a\u0004\bo\u0010?\"\u0004\bp\u0010P\u00a8\u0006t"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/GuildArkComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "o1", "", "v1", "Lcom/tencent/guild/aio/msglist/ark/ArkAppLoadLayout;", "appLoadLayout", "Ltp0/a;", "appContainer", "Lcom/tencent/guild/aio/msglist/ark/view/GuildArkAppView;", QQCustomArkDialogUtil.APP_VIEW, "", "preferredHeight", "", "scale", "z1", "arkName", "Landroid/view/View;", "arkViewLayout", "y1", "arkContainer", "Lcom/tencent/ark/data/ArkAppConfig;", "arkConfig", "appName", "A1", "qunShareArkType", "p1", "", "w1", "position", "", "", "payloads", "b1", "bindData", "Lkotlin/Function0;", "function", "x1", ark.APP_SPECIFIC_BIZSRC, "appInfoLayoutView", "Landroid/widget/ImageView;", "appInfoIconIv", "Landroid/widget/TextView;", "appInfoNameTv", "B1", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", tl.h.F, "I", "mArkWidth", "i", "mArkHeight", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "contentView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/data/msglist/a;", "currentMsgItem", "D", "getRootView", "setRootView", "(Landroid/view/View;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "E", "Lcom/tencent/guild/aio/msglist/ark/view/GuildArkAppView;", "u1", "()Lcom/tencent/guild/aio/msglist/ark/view/GuildArkAppView;", "setArkView", "(Lcom/tencent/guild/aio/msglist/ark/view/GuildArkAppView;)V", "arkView", UserInfo.SEX_FEMALE, "r1", "setAppInfoLayoutView", "G", "Landroid/widget/ImageView;", "q1", "()Landroid/widget/ImageView;", "setAppInfoIconIv", "(Landroid/widget/ImageView;)V", "H", "Landroid/widget/TextView;", ICustomDataEditor.STRING_PARAM_1, "()Landroid/widget/TextView;", "setAppInfoNameTv", "(Landroid/widget/TextView;)V", "Lcom/tencent/guild/aio/msglist/ark/ArkAppLoadLayout;", "getLoadLayout", "()Lcom/tencent/guild/aio/msglist/ark/ArkAppLoadLayout;", "setLoadLayout", "(Lcom/tencent/guild/aio/msglist/ark/ArkAppLoadLayout;)V", "loadLayout", "J", "getArkViewLayout", "setArkViewLayout", "<init>", "K", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArkComponent extends com.tencent.guild.aio.msglist.holder.component.a {
    private static final boolean L = ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).isOptimizeEnable();

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a currentMsgItem;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GuildArkAppView arkView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View appInfoLayoutView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView appInfoIconIv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView appInfoNameTv;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ArkAppLoadLayout loadLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View arkViewLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mArkWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mArkHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout contentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\f"}, d2 = {"com/tencent/guild/aio/msglist/ark/GuildArkComponent$b", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "state", "errorCode", "", "msg", "", "canRetry", "", "onLoadFailed", "onLoadState", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements ArkViewImplement.LoadCallback {
        final /* synthetic */ String C;
        final /* synthetic */ String D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f111193d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildArkComponent f111194e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ GuildArkContainerHelper f111195f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f111196h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f111197i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ MsgRecord f111198m;

        b(String str, GuildArkComponent guildArkComponent, GuildArkContainerHelper guildArkContainerHelper, long j3, float f16, MsgRecord msgRecord, String str2, String str3) {
            this.f111193d = str;
            this.f111194e = guildArkComponent;
            this.f111195f = guildArkContainerHelper;
            this.f111196h = j3;
            this.f111197i = f16;
            this.f111198m = msgRecord;
            this.C = str2;
            this.D = str3;
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        @TargetApi(14)
        public void onLoadFailed(int state, int errorCode, @NotNull String msg2, boolean canRetry) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            onLoadState(state);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        @TargetApi(14)
        public void onLoadState(int state) {
            tp0.a m3;
            if (QLog.isColorLevel()) {
                QLog.d("GuildArkComponent", 2, "onLoadFinish state = ", Integer.valueOf(state), " ,appName = ", this.f111193d);
            }
            if (state == 1) {
                View appInfoLayoutView = this.f111194e.getAppInfoLayoutView();
                if (appInfoLayoutView != null) {
                    GuildArkComponent guildArkComponent = this.f111194e;
                    String str = this.f111193d;
                    String str2 = this.D;
                    ImageView appInfoIconIv = guildArkComponent.getAppInfoIconIv();
                    Intrinsics.checkNotNull(appInfoIconIv);
                    TextView appInfoNameTv = guildArkComponent.getAppInfoNameTv();
                    Intrinsics.checkNotNull(appInfoNameTv);
                    guildArkComponent.B1(str, str2, appInfoLayoutView, appInfoIconIv, appInfoNameTv);
                }
                GuildArkContainerHelper guildArkContainerHelper = this.f111195f;
                if (guildArkContainerHelper != null && (m3 = guildArkContainerHelper.m(this.f111196h)) != null) {
                    Intrinsics.checkNotNullExpressionValue(m3.getContainerRect(), "container.containerRect");
                    float f16 = this.f111197i;
                    int i3 = (int) ((r1.right - r1.left) * f16);
                    int i16 = (int) (f16 * (r1.bottom - r1.top));
                    GuildArkAppView arkView = this.f111194e.getArkView();
                    Intrinsics.checkNotNull(arkView);
                    ViewGroup.LayoutParams layoutParams = arkView.getLayoutParams();
                    Intrinsics.checkNotNullExpressionValue(layoutParams, "arkView!!.layoutParams");
                    g d16 = g.INSTANCE.d();
                    if (d16 != null) {
                        String str3 = this.f111198m.guildId;
                        Intrinsics.checkNotNullExpressionValue(str3, "msgRecord.guildId");
                        String str4 = this.f111198m.channelId;
                        Intrinsics.checkNotNullExpressionValue(str4, "msgRecord.channelId");
                        d16.f(str3, str4, this.f111196h, this.f111198m.msgSeq, this.f111193d, this.C, layoutParams.height);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("GuildArkComponent", 2, "ArkFold.onLoadFinish arkContainer rect(" + i3 + "," + i16 + "), arkView layout rect(" + layoutParams.width + "," + layoutParams.height + "), init mArkWidth=" + this.f111194e.mArkWidth + ",mArkHeight=" + this.f111194e.mArkHeight + ",appName=" + this.f111193d);
                    }
                }
            }
        }
    }

    public GuildArkComponent(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.contentView = new LinearLayout(root.getContext());
    }

    private final void A1(tp0.a arkContainer, ArkAppConfig arkConfig, String appName, int preferredHeight) {
        Integer configWidth;
        StringBuilder sb5;
        int i3;
        g.Companion companion;
        int i16;
        int i17;
        int i18;
        int i19;
        int width;
        Integer num = arkConfig.autoSize;
        boolean z16 = false;
        Integer configHeight = 0;
        if (num != null && num != null && num.intValue() == 1) {
            z16 = true;
        }
        int maxWidth = ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).getMaxWidth();
        g.Companion companion2 = g.INSTANCE;
        int c16 = companion2.c();
        boolean e16 = companion2.e(arkConfig);
        StringBuilder sb6 = new StringBuilder("isSetSize=");
        sb6.append(e16);
        sb6.append(",param=[");
        Integer num2 = arkConfig.width;
        if (num2 == null) {
            configWidth = configHeight;
        } else {
            configWidth = num2;
        }
        Integer num3 = arkConfig.height;
        if (num3 != null) {
            configHeight = num3;
        }
        if (e16) {
            float b16 = com.tencent.guild.aio.msglist.ark.b.b();
            Intrinsics.checkNotNullExpressionValue(configWidth, "configWidth");
            int intValue = configWidth.intValue();
            Intrinsics.checkNotNullExpressionValue(configHeight, "configHeight");
            companion = companion2;
            Integer num4 = configWidth;
            sb5 = sb6;
            i3 = c16;
            g.b f16 = companion2.f(b16, intValue, configHeight.intValue(), maxWidth, c16);
            if (z16) {
                width = maxWidth;
            } else {
                width = f16.getWidth();
            }
            this.mArkWidth = width;
            int height = f16.getHeight();
            this.mArkHeight = height;
            arkContainer.setFixSize(this.mArkWidth, height);
            sb5.append("arkConfig.width=");
            sb5.append(num4.intValue());
            sb5.append(",arkConfig.height=");
            sb5.append(configHeight.intValue());
            sb5.append("][autoSize=");
            sb5.append(z16);
            sb5.append(",maxSize=");
            sb5.append(maxWidth);
            sb5.append("][size=");
            sb5.append(f16.getWidth());
            sb5.append(",");
            sb5.append(f16.getHeight());
            sb5.append("]");
            sb5.append("],app=");
            i16 = -1;
            sb5.append(appName);
        } else {
            Integer configWidth2 = configWidth;
            sb5 = sb6;
            i3 = c16;
            companion = companion2;
            i16 = -1;
            if (z16) {
                i17 = maxWidth;
            } else {
                i17 = -1;
            }
            this.mArkWidth = i17;
            this.mArkHeight = -1;
            if (z16) {
                i18 = maxWidth;
            } else {
                i18 = -1;
            }
            arkContainer.setFixSize(i18, -1);
            sb5.append("arkConfig.width=");
            Intrinsics.checkNotNullExpressionValue(configWidth2, "configWidth");
            sb5.append(configWidth2.intValue());
            sb5.append(",arkConfig.height=");
            Intrinsics.checkNotNullExpressionValue(configHeight, "configHeight");
            sb5.append(configHeight.intValue());
            sb5.append("][autoSize=");
            sb5.append(z16);
            sb5.append(",maxSize=");
            sb5.append(maxWidth);
            sb5.append("]");
            sb5.append(",app=");
            sb5.append(appName);
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildArkComponent", 2, sb5.toString());
        }
        g.Companion companion3 = companion;
        int b17 = g.Companion.b(companion3, 30.0f, 0.0f, 2, null);
        int b18 = g.Companion.b(companion3, 30.0f, 0.0f, 2, null);
        if (preferredHeight <= 0) {
            i19 = maxWidth;
        } else {
            i19 = preferredHeight;
        }
        arkContainer.setMinSize(b17, b18);
        arkContainer.setHintSize(i16, i19);
        arkContainer.i(maxWidth, preferredHeight);
        arkContainer.setMaxSize(((IGuildArkApi) QRoute.api(IGuildArkApi.class)).getMaxWidth(), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(View appInfoLayoutView, ImageView appInfoIconIv, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(appInfoLayoutView, "$appInfoLayoutView");
        Intrinsics.checkNotNullParameter(appInfoIconIv, "$appInfoIconIv");
        if (bitmap != null) {
            appInfoLayoutView.setVisibility(0);
            appInfoIconIv.setVisibility(0);
            appInfoIconIv.setImageBitmap(bitmap);
            return;
        }
        appInfoIconIv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(ViewGroup parent, MsgElement element, MsgRecord msgRecord, com.tencent.aio.data.msglist.a msgItem) {
        tp0.a aVar;
        int i3;
        com.tencent.qqnt.msg.data.a aVar2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        GuildArkAppView guildArkAppView;
        View view;
        ImageView imageView;
        TextView textView;
        ArkAppLoadLayout arkAppLoadLayout;
        View view2;
        float f16;
        Integer num;
        String str6;
        tp0.a aVar3;
        int i16;
        boolean z16;
        ArkElement arkElement = element.arkElement;
        if (arkElement != null && !TextUtils.isEmpty(arkElement.bytesData)) {
            com.tencent.aio.api.runtime.a f17 = f1();
            GuildArkContainerHelper b16 = GuildArkContainerHelper.INSTANCE.b(f17);
            long j3 = msgRecord.msgId;
            if (b16 != null) {
                aVar = b16.m(j3);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar2 = aVar.c();
                i3 = aVar.e();
            } else {
                i3 = -1;
                aVar2 = null;
            }
            String arkDataJson = element.arkElement.bytesData;
            if (aVar2 == null) {
                aVar2 = new com.tencent.qqnt.msg.data.a();
                Intrinsics.checkNotNullExpressionValue(arkDataJson, "arkDataJson");
                if (!aVar2.o(arkDataJson)) {
                    QLog.e("GuildArkComponent", 1, "element.arkElement.bytesData parse error = " + element.arkElement.bytesData);
                    return;
                }
            }
            String d16 = aVar2.d();
            if (d16 == null) {
                d16 = "";
            }
            String e16 = aVar2.e();
            if (e16 == null) {
                str = "";
            } else {
                str = e16;
            }
            String f18 = aVar2.f();
            if (f18 == null) {
                str2 = "";
            } else {
                str2 = f18;
            }
            String m3 = aVar2.m();
            if (m3 == null) {
                str3 = "";
            } else {
                str3 = m3;
            }
            String c16 = aVar2.c();
            if (c16 == null) {
                str4 = "";
            } else {
                str4 = c16;
            }
            String g16 = aVar2.g();
            if (g16 == null) {
                str5 = "";
            } else {
                str5 = g16;
            }
            if (i3 == -1) {
                a.Companion companion = a.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(arkDataJson, "arkDataJson");
                i3 = companion.a(d16, str, arkDataJson);
            }
            int i17 = i3;
            boolean w16 = w1(d16, str, i17);
            if (w16 && this.contentView.getChildCount() > 0) {
                GuildArkAppView guildArkAppView2 = this.arkView;
                if (guildArkAppView2 != null) {
                    guildArkAppView2.destroyBitmapBuffer();
                }
                GuildArkAppView guildArkAppView3 = this.arkView;
                if (guildArkAppView3 != null) {
                    guildArkAppView3.releaseViewContext();
                }
                GuildArkAppView guildArkAppView4 = this.arkView;
                if (guildArkAppView4 != null) {
                    guildArkAppView4.removeAllViews();
                }
                this.contentView.removeAllViews();
            }
            if (this.rootView == null || w16) {
                new h().i(parent.getContext(), this.contentView);
                LinearLayout linearLayout = this.contentView;
                this.rootView = linearLayout;
                if (linearLayout != null) {
                    guildArkAppView = (GuildArkAppView) linearLayout.findViewById(R.id.y_);
                } else {
                    guildArkAppView = null;
                }
                this.arkView = guildArkAppView;
                View view3 = this.rootView;
                if (view3 != null) {
                    view = view3.findViewById(R.id.f164456yf);
                } else {
                    view = null;
                }
                this.appInfoLayoutView = view;
                View view4 = this.rootView;
                if (view4 != null) {
                    imageView = (ImageView) view4.findViewById(R.id.f164455ye);
                } else {
                    imageView = null;
                }
                this.appInfoIconIv = imageView;
                View view5 = this.rootView;
                if (view5 != null) {
                    textView = (TextView) view5.findViewById(R.id.f164457yg);
                } else {
                    textView = null;
                }
                this.appInfoNameTv = textView;
                View view6 = this.rootView;
                if (view6 != null) {
                    arkAppLoadLayout = (ArkAppLoadLayout) view6.findViewById(R.id.eet);
                } else {
                    arkAppLoadLayout = null;
                }
                this.loadLayout = arkAppLoadLayout;
                View view7 = this.rootView;
                if (view7 != null) {
                    view2 = view7.findViewById(R.id.svh);
                } else {
                    view2 = null;
                }
                this.arkViewLayout = view2;
            }
            View view8 = this.appInfoLayoutView;
            if (view8 != null) {
                view8.setVisibility(8);
            }
            float f19 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().scaledDensity;
            if (QLog.isColorLevel()) {
                QLog.d("GuildArkComponent", 2, "arkDebugMeta  meta = " + str3 + ", msgId = " + j3);
            }
            if (aVar == null) {
                aVar = new tp0.a(f17, msgRecord);
                boolean z17 = L;
                aVar.setIndependentView(z17);
                aVar.setMemoryOptimized(z17);
                if (b16 != null) {
                    WeakReference<tp0.a> f26 = aVar.f();
                    Intrinsics.checkNotNullExpressionValue(f26, "arkAppContainer.weakReference");
                    b16.o(j3, f26);
                }
            }
            aVar.j(msgRecord);
            aVar.g(f17);
            aVar.h(aVar2);
            aVar.init(d16, str, str4, str3, str5, str2, f19);
            g d17 = g.INSTANCE.d();
            if (d17 != null) {
                String str7 = msgRecord.guildId;
                Intrinsics.checkNotNullExpressionValue(str7, "msgRecord.guildId");
                String str8 = msgRecord.channelId;
                Intrinsics.checkNotNullExpressionValue(str8, "msgRecord.channelId");
                f16 = f19;
                num = Integer.valueOf(d17.d(str7, str8, j3, d16, str));
            } else {
                f16 = f19;
                num = null;
            }
            if (num != null) {
                ArkAppLoadLayout arkAppLoadLayout2 = this.loadLayout;
                GuildArkAppView guildArkAppView5 = this.arkView;
                Intrinsics.checkNotNull(guildArkAppView5);
                str6 = d16;
                aVar3 = aVar;
                i16 = i17;
                z1(arkAppLoadLayout2, aVar, guildArkAppView5, num.intValue(), f16);
            } else {
                str6 = d16;
                aVar3 = aVar;
                i16 = i17;
            }
            String str9 = str;
            b bVar = new b(str6, this, b16, j3, f16, msgRecord, str, str2);
            GuildArkAppView guildArkAppView6 = this.arkView;
            if (guildArkAppView6 != null) {
                guildArkAppView6.setLoadCallback(bVar);
            }
            ArkAppConfig arkAppConfig = aVar3.b();
            if (num != null) {
                Intrinsics.checkNotNullExpressionValue(arkAppConfig, "arkAppConfig");
                A1(aVar3, arkAppConfig, str6, num.intValue());
            }
            y1(str6, this.arkViewLayout);
            GuildArkAppView guildArkAppView7 = this.arkView;
            if (guildArkAppView7 != null) {
                guildArkAppView7.setClipRadius(6.0f);
            }
            GuildArkAppView guildArkAppView8 = this.arkView;
            if (guildArkAppView8 != null) {
                z16 = true;
                guildArkAppView8.setBorderType(!arkAppConfig.isRectangleBorder() ? 1 : 0);
            } else {
                z16 = true;
            }
            GuildArkAppView guildArkAppView9 = this.arkView;
            if (guildArkAppView9 != null) {
                guildArkAppView9.setAlignLeft(msgItem.isSelf() ^ z16);
            }
            GuildArkAppView guildArkAppView10 = this.arkView;
            if (guildArkAppView10 != null) {
                guildArkAppView10.setMsgRecord(msgRecord);
            }
            GuildArkAppView guildArkAppView11 = this.arkView;
            if (guildArkAppView11 != null) {
                guildArkAppView11.setViewKey(p1(str6, str9, i16));
            }
            GuildArkAppView guildArkAppView12 = this.arkView;
            if (guildArkAppView12 != null) {
                guildArkAppView12.e(aVar3, this.loadLayout, false);
            }
            GuildArkAppView guildArkAppView13 = this.arkView;
            if (guildArkAppView13 != null) {
                guildArkAppView13.setDataReportPgId(v1());
                return;
            }
            return;
        }
        QLog.e("GuildArkComponent", 1, "element.arkElement data is null or empty");
    }

    private final String p1(String appName, String appView, int qunShareArkType) {
        return appName + "_" + appView + "_" + qunShareArkType;
    }

    private final String v1() {
        AIOParam g16;
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
        if (context == null || (g16 = context.g()) == null) {
            return null;
        }
        return g16.n();
    }

    private final boolean w1(String appName, String appView, int qunShareArkType) {
        String str;
        if (this.rootView == null || this.arkView == null) {
            return true;
        }
        String p16 = p1(appName, appView, qunShareArkType);
        GuildArkAppView guildArkAppView = this.arkView;
        if (guildArkAppView != null) {
            str = guildArkAppView.d();
        } else {
            str = null;
        }
        return !TextUtils.equals(p16, str);
    }

    private final void y1(String arkName, View arkViewLayout) {
        if (((IGuildArkStrokeApi) QRoute.api(IGuildArkStrokeApi.class)).isNeedStroke(arkName)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(((IGuildArkStrokeApi) QRoute.api(IGuildArkStrokeApi.class)).getRoundRadius());
            int strokeWidth = ((IGuildArkStrokeApi) QRoute.api(IGuildArkStrokeApi.class)).getStrokeWidth();
            gradientDrawable.setStroke(strokeWidth, Color.parseColor(((IGuildArkStrokeApi) QRoute.api(IGuildArkStrokeApi.class)).getStrokeColor()));
            gradientDrawable.mutate();
            if (arkViewLayout != null) {
                arkViewLayout.setBackgroundDrawable(gradientDrawable);
            }
            if (arkViewLayout != null) {
                arkViewLayout.setPadding(strokeWidth, strokeWidth, strokeWidth, strokeWidth);
            }
        }
    }

    private final void z1(ArkAppLoadLayout appLoadLayout, tp0.a appContainer, GuildArkAppView appView, int preferredHeight, float scale) {
        Rect rect;
        int i3;
        if (appLoadLayout != null) {
            ViewGroup.LayoutParams layoutParams = appLoadLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).getMaxWidth();
            if (preferredHeight > 0) {
                i3 = preferredHeight;
            } else {
                i3 = e.f111212e;
            }
            layoutParams2.height = i3;
            layoutParams2.setMargins(0, 0, 0, 0);
            appLoadLayout.setLayoutParams(layoutParams2);
        }
        if (preferredHeight <= 0) {
            return;
        }
        if (appContainer != null && scale > 0.0f) {
            appContainer.getContainerRect().bottom = (int) (preferredHeight / scale);
        }
        ArkViewImplement arkViewImplement = appView.mViewImpl;
        if (arkViewImplement != null && (rect = arkViewImplement.mRectView) != null) {
            rect.bottom = preferredHeight;
        }
        ViewGroup.LayoutParams layoutParams3 = appView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams3, "appView.layoutParams");
        layoutParams3.height = preferredHeight;
        appView.setLayoutParams(layoutParams3);
    }

    public final void B1(@Nullable String appName, @Nullable String bizSrc, @NotNull final View appInfoLayoutView, @NotNull final ImageView appInfoIconIv, @NotNull TextView appInfoNameTv) {
        Intrinsics.checkNotNullParameter(appInfoLayoutView, "appInfoLayoutView");
        Intrinsics.checkNotNullParameter(appInfoIconIv, "appInfoIconIv");
        Intrinsics.checkNotNullParameter(appInfoNameTv, "appInfoNameTv");
        ArkAppCacheMgr.getAppIcon(appName, bizSrc, new ArkAppCacheMgr.OnGetAppIcon() { // from class: com.tencent.guild.aio.msglist.ark.f
            @Override // com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon
            public final void callback(String str, Bitmap bitmap) {
                GuildArkComponent.C1(appInfoLayoutView, appInfoIconIv, str, bitmap);
            }
        });
        String applicationDesc = ArkAppCacheMgr.getApplicationDesc(appName);
        if (applicationDesc != null) {
            appInfoLayoutView.setVisibility(0);
            appInfoNameTv.setVisibility(0);
            appInfoNameTv.setText(applicationDesc);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        x1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.ark.GuildArkComponent$bind$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LinearLayout linearLayout;
                LinearLayout linearLayout2;
                Object last;
                LinearLayout linearLayout3 = (LinearLayout) GuildArkComponent.this.getRoot().findViewById(R.id.f164907u83);
                linearLayout3.setBackground(null);
                linearLayout3.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout = GuildArkComponent.this.contentView;
                linearLayout.setLayoutParams(layoutParams);
                com.tencent.aio.data.msglist.a aVar = msgItem;
                if (aVar instanceof GuildMsgItem) {
                    Intrinsics.checkNotNullExpressionValue(((GuildMsgItem) aVar).getMsgRecord().elements, "msgItem.msgRecord.elements");
                    if (!r0.isEmpty()) {
                        GuildArkComponent guildArkComponent = GuildArkComponent.this;
                        linearLayout2 = guildArkComponent.contentView;
                        ArrayList<MsgElement> arrayList = ((GuildMsgItem) msgItem).getMsgRecord().elements;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
                        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                        Intrinsics.checkNotNullExpressionValue(last, "msgItem.msgRecord.elements.last()");
                        guildArkComponent.o1(linearLayout2, (MsgElement) last, ((GuildMsgItem) msgItem).getMsgRecord(), msgItem);
                    }
                }
                GuildArkComponent.this.currentMsgItem = msgItem;
            }
        });
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.contentView;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildArkComponent";
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        this.currentMsgItem = null;
    }

    @Nullable
    /* renamed from: q1, reason: from getter */
    public final ImageView getAppInfoIconIv() {
        return this.appInfoIconIv;
    }

    @Nullable
    /* renamed from: r1, reason: from getter */
    public final View getAppInfoLayoutView() {
        return this.appInfoLayoutView;
    }

    @Nullable
    /* renamed from: s1, reason: from getter */
    public final TextView getAppInfoNameTv() {
        return this.appInfoNameTv;
    }

    @Nullable
    /* renamed from: u1, reason: from getter */
    public final GuildArkAppView getArkView() {
        return this.arkView;
    }

    public final void x1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
        tp0.a aVar;
        Intrinsics.checkNotNullParameter(bindData, "bindData");
        Intrinsics.checkNotNullParameter(function, "function");
        com.tencent.aio.data.msglist.a aVar2 = this.currentMsgItem;
        if (aVar2 == null) {
            function.invoke();
            return;
        }
        Intrinsics.checkNotNull(aVar2);
        long msgId = aVar2.getMsgId();
        GuildArkContainerHelper b16 = GuildArkContainerHelper.INSTANCE.b(f1());
        if (b16 != null) {
            aVar = b16.m(msgId);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            function.invoke();
            return;
        }
        com.tencent.aio.data.msglist.a aVar3 = this.currentMsgItem;
        Intrinsics.checkNotNull(aVar3);
        if (aVar3.isSameItem(bindData)) {
            com.tencent.aio.data.msglist.a aVar4 = this.currentMsgItem;
            Intrinsics.checkNotNull(aVar4);
            if (aVar4.isSameContent(bindData)) {
                QLog.d("GuildArkComponent", 1, "GuildArkComponent not bind msgId = " + msgId);
                return;
            }
        }
        function.invoke();
    }
}
