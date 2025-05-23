package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.gamemsgbox.i;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameReportApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J&\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/i;", "Lcom/tencent/qqnt/chats/inject/title/a;", "", "dp", "Landroid/content/Context;", "context", "f", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lgd1/a;", "info", "", "g", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/i$b;", "holder", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "k", tl.h.F, "a", "e", "<init>", "()V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i extends com.tencent.qqnt.chats.inject.title.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/i$a;", "", "", "DP_TAG_GROWTH_ICON_HEIGHT", "I", "DP_TAG_GROWTH_ICON_WIDTH", "DP_TAG_LEVEL_ICON_HEIGHT", "DP_TAG_LEVEL_ICON_WIDTH", "DP_TAG_MEDAL_ICON_HEIGHT", "DP_TAG_MEDAL_ICON_WIDTH", "DP_TAG_NICKNAME_MAX_VIEW_SIZE", "DP_TAG_ROOT_HEIGHT", "DP_TAG_ROOT_PADDING", "DP_TAG_VIEW_MARGING", "DP_TAG_VIEW_PADDING", "SP_TAG_GAME_SIZE", "SP_TAG_NICKNAME_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.i$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u001a\u0010\u0010R$\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001f\"\u0004\b \u0010!R$\u0010$\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u0013\u0010\u001f\"\u0004\b#\u0010!R$\u0010&\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b%\u0010!R$\u0010)\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\f\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/i$b;", "", "Landroid/widget/RelativeLayout;", "a", "Landroid/widget/RelativeLayout;", "g", "()Landroid/widget/RelativeLayout;", "o", "(Landroid/widget/RelativeLayout;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "f", "()Landroid/widget/TextView;", DomainData.DOMAIN_NAME, "(Landroid/widget/TextView;)V", "nickTextView", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "()Landroid/widget/LinearLayout;", "i", "(Landroid/widget/LinearLayout;)V", "gameRoot", "d", "j", "gameTextView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "l", "(Landroid/widget/ImageView;)V", "levelImage", "k", "growthImageView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "medalImageView", tl.h.F, "p", "timeTextView", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RelativeLayout rootView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextView nickTextView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private LinearLayout gameRoot;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextView gameTextView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ImageView levelImage;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ImageView growthImageView;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ImageView medalImageView;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextView timeTextView;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final LinearLayout a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (LinearLayout) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.gameRoot;
        }

        @Nullable
        public final TextView b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (TextView) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.gameTextView;
        }

        @Nullable
        public final ImageView c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (ImageView) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.growthImageView;
        }

        @Nullable
        public final ImageView d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (ImageView) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.levelImage;
        }

        @Nullable
        public final ImageView e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (ImageView) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.medalImageView;
        }

        @Nullable
        public final TextView f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.nickTextView;
        }

        @Nullable
        public final RelativeLayout g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.rootView;
        }

        @Nullable
        public final TextView h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (TextView) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.timeTextView;
        }

        public final void i(@Nullable LinearLayout linearLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) linearLayout);
            } else {
                this.gameRoot = linearLayout;
            }
        }

        public final void j(@Nullable TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
            } else {
                this.gameTextView = textView;
            }
        }

        public final void k(@Nullable ImageView imageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) imageView);
            } else {
                this.growthImageView = imageView;
            }
        }

        public final void l(@Nullable ImageView imageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) imageView);
            } else {
                this.levelImage = imageView;
            }
        }

        public final void m(@Nullable ImageView imageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) imageView);
            } else {
                this.medalImageView = imageView;
            }
        }

        public final void n(@Nullable TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) textView);
            } else {
                this.nickTextView = textView;
            }
        }

        public final void o(@Nullable RelativeLayout relativeLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) relativeLayout);
            } else {
                this.rootView = relativeLayout;
            }
        }

        public final void p(@Nullable TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) textView);
            } else {
                this.timeTextView = textView;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52700);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int f(int dp5, Context context) {
        return (int) TypedValue.applyDimension(1, dp5, context.getResources().getDisplayMetrics());
    }

    private final String g(com.tencent.qqnt.chats.core.adapter.itemdata.g item, gd1.a info) {
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isWangZheContact(item) && ((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isGamePartnerContact(item)) {
            String string = BaseApplication.getContext().getString(R.string.f1365404f);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            MobileQQ.g\u2026z_game_partner)\n        }");
            return string;
        }
        String str = info.f401947k;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String h(com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        TempChatGameSession gameSession;
        ArrayList<RecentContactExtAttr> p16 = info.p();
        if (p16 != null) {
            Iterator<RecentContactExtAttr> it = p16.iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next != null && (gameSession = next.gameSession) != null) {
                    Intrinsics.checkNotNullExpressionValue(gameSession, "gameSession");
                    String str = gameSession.peerOpenId;
                    Intrinsics.checkNotNullExpressionValue(str, "this.peerOpenId");
                    return str;
                }
            }
            return "";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(gd1.a info, SingleLineTextView view, i this$0, com.tencent.qqnt.chats.core.adapter.itemdata.g item, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        QLog.i("GameBoxChatTitleProcessor", 1, "[createView] growth clicked.");
        if (TextUtils.isEmpty(info.f401955s)) {
            QLog.e("GameBoxChatTitleProcessor", 1, "[createView] growth clicked. growthRankUrlJump is empty,return.");
        } else {
            view.getContext().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(info.f401955s)));
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(info.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92044", "989386", this$0.h(item), "", "20", "");
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(gd1.a info, SingleLineTextView view, i this$0, com.tencent.qqnt.chats.core.adapter.itemdata.g item, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        QLog.i("GameBoxChatTitleProcessor", 1, "[createView] medal clicked.");
        if (TextUtils.isEmpty(info.f401957u)) {
            QLog.e("GameBoxChatTitleProcessor", 1, "[createView] medal clicked. medalUrlJump is empty,return.");
        } else {
            view.getContext().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(info.f401957u)));
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(info.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92044", "989387", this$0.h(item), "", "20", "");
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    private final void k(final b holder, gd1.a info, final SingleLineTextView view, com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        TextView f16 = holder.f();
        if (f16 != null) {
            f16.setText(info.f401941e);
        }
        TextView b16 = holder.b();
        if (b16 != null) {
            b16.setText(g(item, info));
        }
        if (!TextUtils.isEmpty(info.f401943g)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = new ColorDrawable(0);
            obtain.mLoadingDrawable = new ColorDrawable(0);
            URLDrawable drawable = URLDrawable.getDrawable(info.f401943g, obtain);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            int f17 = f(16, context);
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            drawable.setBounds(0, 0, f17, f(16, context2));
            ImageView d16 = holder.d();
            if (d16 != null) {
                d16.setImageDrawable(drawable);
            }
        }
        if (!TextUtils.isEmpty(info.f401954r)) {
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            obtain2.mFailedDrawable = new ColorDrawable(0);
            obtain2.mLoadingDrawable = new ColorDrawable(0);
            URLDrawable drawable2 = URLDrawable.getDrawable(info.f401954r, obtain2);
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            int f18 = f(68, context3);
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "view.context");
            drawable2.setBounds(0, 0, f18, f(25, context4));
            ImageView c16 = holder.c();
            if (c16 != null) {
                c16.setImageDrawable(drawable2);
            }
        }
        if (!TextUtils.isEmpty(info.f401956t)) {
            URLDrawable.URLDrawableOptions obtain3 = URLDrawable.URLDrawableOptions.obtain();
            obtain3.mFailedDrawable = new ColorDrawable(0);
            obtain3.mLoadingDrawable = new ColorDrawable(0);
            URLDrawable drawable3 = URLDrawable.getDrawable(info.f401956t, obtain3);
            Context context5 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "view.context");
            int f19 = f(25, context5);
            Context context6 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "view.context");
            drawable3.setBounds(0, 0, f19, f(25, context6));
            ImageView e16 = holder.e();
            if (e16 != null) {
                e16.setImageDrawable(drawable3);
            }
        }
        TextView h16 = holder.h();
        if (h16 != null) {
            h16.setText(item.u());
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.h
            @Override // java.lang.Runnable
            public final void run() {
                i.l(i.b.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(b holder, i this$0, SingleLineTextView view) {
        int i3;
        int i16;
        int i17;
        int i18;
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        RelativeLayout g16 = holder.g();
        if (g16 != null) {
            i3 = g16.getMeasuredWidth();
        } else {
            i3 = 0;
        }
        TextView f16 = holder.f();
        if (f16 != null) {
            i16 = f16.getMeasuredWidth();
        } else {
            i16 = 0;
        }
        LinearLayout a16 = holder.a();
        if (a16 != null) {
            i17 = a16.getMeasuredWidth();
        } else {
            i17 = 0;
        }
        TextView h16 = holder.h();
        if (h16 != null) {
            i18 = h16.getMeasuredWidth();
        } else {
            i18 = 0;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int f17 = this$0.f(68, context);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        int f18 = this$0.f(25, context2);
        if (QLog.isColorLevel()) {
            QLog.d("GameBoxChatTitleProcessor", 1, "[createView] rootWidth: " + i3 + ", nickViewWidth: " + i16 + ", gameRootWidth: " + i17 + ", timeWidth: " + i18 + ", growthWidth: " + f17 + ", medalWidth: " + f18);
        }
        int i19 = ((i3 - i18) - i16) - i17;
        if (f18 + f17 < i19) {
            ImageView c16 = holder.c();
            if (c16 != null) {
                c16.setVisibility(0);
            }
            ImageView e16 = holder.e();
            if (e16 != null) {
                e16.setVisibility(0);
                return;
            }
            return;
        }
        if (f17 < i19) {
            ImageView c17 = holder.c();
            if (c17 != null) {
                c17.setVisibility(0);
            }
            ImageView e17 = holder.e();
            if (e17 != null) {
                e17.setVisibility(8);
                return;
            }
            return;
        }
        ImageView c18 = holder.c();
        if (c18 != null) {
            c18.setVisibility(8);
        }
        ImageView e18 = holder.e();
        if (e18 != null) {
            e18.setVisibility(8);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(@NotNull final com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull final SingleLineTextView view) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() != 105) {
            return;
        }
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerBox(item)) {
            ((IGameReportApi) QRoute.api(IGameReportApi.class)).reportApplyPartnerBoxExpo(item);
            return;
        }
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerContact(item)) {
            ((IGameReportApi) QRoute.api(IGameReportApi.class)).reportApplyPartnerMsgExpo(item);
        }
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isGamePartnerContact(item)) {
            ((IGameReportApi) QRoute.api(IGameReportApi.class)).reportGamePartnerMsgExpo(item);
        }
        String str2 = "";
        view.setExtendText("", 2);
        TempChatGameSession gameSessionFromPeerUid = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUid(item.k());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) runtimeService;
        b bVar = null;
        if (gameSessionFromPeerUid != null) {
            str = gameSessionFromPeerUid.peerRoleId;
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        final gd1.a singleGameDetailV2 = iGameMsgManagerService.getSingleGameDetailV2(str2);
        if (singleGameDetailV2 == null) {
            return;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        view.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        layoutParams.height = f(25, context);
        Object tag = viewGroup.getTag();
        if (tag instanceof b) {
            bVar = (b) tag;
        }
        if (bVar == null) {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            bVar = e(context2, item, singleGameDetailV2, view);
            viewGroup.setTag(bVar);
            viewGroup.addView(bVar.g(), layoutParams);
        }
        ImageView c16 = bVar.c();
        if (c16 != null) {
            c16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i.i(gd1.a.this, view, this, item, view2);
                }
            });
        }
        ImageView e16 = bVar.e();
        if (e16 != null) {
            e16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i.j(gd1.a.this, view, this, item, view2);
                }
            });
        }
        k(bVar, singleGameDetailV2, view, item);
    }

    @NotNull
    public final b e(@NotNull Context context, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull gd1.a info, @NotNull SingleLineTextView view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        int id5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, this, context, item, info, view);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(view, "view");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, f(25, context)));
        relativeLayout.setGravity(16);
        relativeLayout.setPadding(f(2, context), f(2, context), f(2, context), f(2, context));
        TextView textView = new TextView(context);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        textView.setText(info.f401941e);
        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_primary));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setId(View.generateViewId());
        textView.setGravity(16);
        textView.setMaxWidth(f(150, context));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(1, textView.getId());
        layoutParams2.leftMargin = f(3, context);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        int f16 = f(3, context);
        int color = context.getResources().getColor(R.color.qui_common_bg_bottom_standard);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f16);
        gradientDrawable.setColor(color);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setId(View.generateViewId());
        int f17 = f(3, context);
        linearLayout.setPadding(f17, f17, f17, f17);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView2.setText(g(item, info));
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(context.getResources().getColor(R.color.qui_common_text_secondary));
        linearLayout.addView(textView2);
        if (!TextUtils.isEmpty(info.f401943g)) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(f(16, context), f(16, context)));
            imageView.setPadding(f17, 0, 0, 0);
            linearLayout.addView(imageView);
        } else {
            imageView = null;
        }
        if (!TextUtils.isEmpty(info.f401954r)) {
            imageView2 = new ImageView(context);
            imageView2.setLayoutParams(new RelativeLayout.LayoutParams(f(68, context), f(25, context)));
            ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams3).addRule(1, linearLayout.getId());
            imageView2.setId(View.generateViewId());
        } else {
            imageView2 = null;
        }
        if (!TextUtils.isEmpty(info.f401956t)) {
            imageView3 = new ImageView(context);
            imageView3.setLayoutParams(new RelativeLayout.LayoutParams(f(25, context), f(25, context)));
            ViewGroup.LayoutParams layoutParams4 = imageView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
            if (imageView2 != null) {
                id5 = imageView2.getId();
            } else {
                id5 = linearLayout.getId();
            }
            layoutParams5.addRule(1, id5);
            imageView3.setId(View.generateViewId());
        } else {
            imageView3 = null;
        }
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams6 = textView3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams6, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams6;
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        textView3.setText(item.u());
        textView3.setGravity(16);
        textView3.setTextSize(2, 12.0f);
        textView3.setTextColor(context.getResources().getColor(R.color.qui_common_text_secondary));
        relativeLayout.addView(textView);
        relativeLayout.addView(linearLayout);
        if (imageView2 != null) {
            relativeLayout.addView(imageView2);
        }
        if (imageView3 != null) {
            relativeLayout.addView(imageView3);
        }
        relativeLayout.addView(textView3);
        b bVar = new b();
        bVar.o(relativeLayout);
        bVar.n(textView);
        bVar.i(linearLayout);
        bVar.j(textView2);
        bVar.l(imageView);
        bVar.k(imageView2);
        bVar.m(imageView3);
        bVar.p(textView3);
        ImageView c16 = bVar.c();
        if (c16 != null) {
            c16.setVisibility(8);
        }
        ImageView e16 = bVar.e();
        if (e16 != null) {
            e16.setVisibility(8);
        }
        return bVar;
    }
}
