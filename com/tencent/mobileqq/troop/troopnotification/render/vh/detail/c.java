package com.tencent.mobileqq.troop.troopnotification.render.vh.detail;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationDetailTextView;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import com.tencent.mobileqq.troop.troopnotification.utils.e;
import com.tencent.mobileqq.troop.troopnotification.utils.g;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.notification.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0082\u00012\u00020\u0001:\u0002\u0083\u0001B\u001b\u0012\u0006\u0010\u007f\u001a\u00020\u0018\u0012\b\b\u0002\u0010\"\u001a\u00020 \u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016R\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u001a\u0010(\u001a\u00020#8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010,\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010+R\u001a\u00100\u001a\u00020\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\b.\u0010/R\u001a\u00106\u001a\u0002018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u00108\u001a\u0002018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b7\u00105R\u001a\u0010;\u001a\u00020\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b9\u0010-\u001a\u0004\b:\u0010/R\u001a\u0010@\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010B\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bA\u0010=\u001a\u0004\b$\u0010?R\u001a\u0010E\u001a\u0002018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bC\u00103\u001a\u0004\bD\u00105R\u001a\u0010J\u001a\u00020F8\u0016X\u0096D\u00a2\u0006\f\n\u0004\bG\u0010\u0003\u001a\u0004\bH\u0010IR\u001a\u0010N\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bK\u0010A\u001a\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020F8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bO\u0010\u0003R\u0014\u0010R\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010AR\u0014\u0010T\u001a\u00020F8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bS\u0010\u0003R\u0014\u0010V\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010AR\u0014\u0010X\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010AR\u0014\u0010Z\u001a\u00020F8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bY\u0010\u0003R\u0014\u0010\\\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010AR\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010-R\u0014\u0010d\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010=R\u0014\u0010f\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010-R\u0014\u0010h\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010_R\u0014\u0010j\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010=R\u0014\u0010l\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010=R\u0014\u0010n\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010=R\u0014\u0010p\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010=R\u0014\u0010r\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010-R\u0018\u0010t\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010=R\u0014\u0010v\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010=R\u0014\u0010x\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010)R\u0014\u0010|\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010=\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/c;", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/notification/f;", "msg", "y", "", "index", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", HippyTKDListViewAdapter.X, "w", "Landroid/widget/TextView;", "p", "v", "Lcom/tencent/mobileqq/data/troop/d;", "info", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopcatalog/a;", "bean", "D", "u", "Lcom/tencent/mobileqq/data/Card;", "B", "Landroid/view/ViewGroup;", h.F, "d", "i", "", "doubtTips", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "Lts2/c;", "Lts2/c;", "viewBinding", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "e", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "titleLayout", "Landroid/view/ViewGroup;", "j", "()Landroid/view/ViewGroup;", "messageLayout", "Landroid/widget/Button;", "E", "Landroid/widget/Button;", "l", "()Landroid/widget/Button;", "operationBtn", "g", "cancelBtn", "G", DomainData.DOMAIN_NAME, "reportLayout", "H", "Landroid/widget/TextView;", "f", "()Landroid/widget/TextView;", "blackListBtn", "I", "reportBtn", "J", "c", "againBtn", "", "K", ReportConstant.COSTREPORT_PREFIX, "()F", "titleTextSize", "L", "r", "()I", "titleTextColor", "M", "firstMessageLineTextSize", "N", "firstMessageLineTextColor", "P", "messageTextSize", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "messageTextColor", BdhLogUtil.LogTag.Tag_Req, "maxPrefixTextWidth", ExifInterface.LATITUDE_SOUTH, "extraMessageTextSize", "T", "extraMessageTextColor", "Landroid/view/View;", "U", "Landroid/view/View;", "robotIcon", "V", "mainArea", "W", "timeTag", "X", "extraMessageLayout", "Y", "infoTagLayout", "Z", "userGender", "a0", "troopCategory", "b0", "userAge", "c0", "userCity", "d0", "levelInfoLayout", "e0", "levelView", "f0", "alterTips", "g0", "hintTips", "Landroid/view/ViewStub;", "h0", "Landroid/view/ViewStub;", "doubtTipsVB", "i0", "doubtTipsView", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lts2/c;)V", "j0", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TroopNotificationRichTextView titleLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup messageLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Button operationBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Button cancelBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup reportLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView blackListBtn;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView reportBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Button againBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private final float titleTextSize;

    /* renamed from: L, reason: from kotlin metadata */
    private final int titleTextColor;

    /* renamed from: M, reason: from kotlin metadata */
    private final float firstMessageLineTextSize;

    /* renamed from: N, reason: from kotlin metadata */
    private final int firstMessageLineTextColor;

    /* renamed from: P, reason: from kotlin metadata */
    private final float messageTextSize;

    /* renamed from: Q, reason: from kotlin metadata */
    private final int messageTextColor;

    /* renamed from: R, reason: from kotlin metadata */
    private final int maxPrefixTextWidth;

    /* renamed from: S, reason: from kotlin metadata */
    private final float extraMessageTextSize;

    /* renamed from: T, reason: from kotlin metadata */
    private final int extraMessageTextColor;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final View robotIcon;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup mainArea;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final TextView timeTag;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup extraMessageLayout;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final View infoTagLayout;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final TextView userGender;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView troopCategory;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView userAge;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView userCity;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup levelInfoLayout;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView levelView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView alterTips;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopNotificationRichTextView hintTips;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewStub doubtTipsVB;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ts2.c viewBinding;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView doubtTipsView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQProAvatarView avatar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/c$a;", "", "", "GENDER_MAN", "I", "GENDER_WOMAN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.render.vh.detail.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ c(ViewGroup viewGroup, ts2.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, r0);
        ts2.c cVar2;
        if ((i3 & 2) != 0) {
            cVar2 = ts2.c.g(LayoutInflater.from(viewGroup.getContext()));
            Intrinsics.checkNotNullExpressionValue(cVar2, "inflate(LayoutInflater.from(parent.context))");
        } else {
            cVar2 = cVar;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, viewGroup, cVar, Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final void F() {
        e().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.render.vh.detail.b
            @Override // java.lang.Runnable
            public final void run() {
                c.G(c.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Rect rect = new Rect();
        this$0.e().getHitRect(rect);
        rect.right += this$0.mainArea.getWidth() - rect.left;
        this$0.mainArea.setTouchDelegate(new TouchDelegate(rect, this$0.e()));
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    public void A(@NotNull String doubtTips, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) doubtTips, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(doubtTips, "doubtTips");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.doubtTipsView == null) {
            this.doubtTipsView = (TextView) this.doubtTipsVB.inflate().findViewById(R.id.f103125zr);
        }
        TextView textView = this.doubtTipsView;
        if (textView != null) {
            g gVar = g.f300931a;
            Context context = o().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            textView.setText(gVar.a(context, doubtTips));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setVisibility(0);
            com.tencent.mobileqq.troop.troopnotification.report.a.f300918a.d(textView, msg2);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    public void B(@NotNull Card info) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.levelView == null) {
            ITroopSysMsgDependApiService iTroopSysMsgDependApiService = (ITroopSysMsgDependApiService) bg.l(ITroopSysMsgDependApiService.class);
            if (iTroopSysMsgDependApiService != null) {
                textView = iTroopSysMsgDependApiService.getAnimationTextInstance(o().getContext());
            } else {
                textView = null;
            }
            this.levelView = textView;
            if (textView != null) {
                textView.setTextAppearance(o().getContext(), R.style.f173783kk);
                textView.setGravity(17);
            }
            this.levelInfoLayout.addView(this.levelView);
        }
        TextView textView2 = this.levelView;
        if (textView2 != null) {
            this.levelInfoLayout.setVisibility(0);
            e.f300928a.e(textView2, info);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f4  */
    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C(@NotNull d info) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        boolean z26;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        this.troopCategory.setVisibility(8);
        if (info.i()) {
            String c16 = info.c();
            z16 = true;
            if (c16 != null && c16.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                str = info.c();
            } else {
                String f16 = info.f();
                if (f16 != null && f16.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    str = info.c();
                } else {
                    String d16 = info.d();
                    if (d16 != null && d16.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        str = info.d();
                    } else {
                        str = null;
                    }
                }
            }
            if (str != null) {
                this.userCity.setText("\u5728" + str);
                this.userCity.setVisibility(0);
                z26 = true;
            } else {
                this.userCity.setVisibility(8);
                z26 = false;
            }
            this.userGender.setVisibility(0);
            TextView textView = this.userGender;
            int g16 = info.g();
            if (g16 != 1) {
                if (g16 != 2) {
                    this.userGender.setVisibility(8);
                    string = "";
                    textView.setText(string);
                    if (info.b() <= 0) {
                        this.userAge.setVisibility(0);
                        this.userAge.setText(info.b() + "\u5c81");
                    } else {
                        this.userAge.setVisibility(8);
                        z16 = z26;
                    }
                } else {
                    string = o().getResources().getString(R.string.b5e);
                }
            } else {
                string = o().getResources().getString(R.string.c7_);
            }
            z26 = true;
            textView.setText(string);
            if (info.b() <= 0) {
            }
        } else {
            z16 = false;
        }
        if (z16) {
            this.infoTagLayout.setVisibility(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r0 == true) goto L17;
     */
    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D(@NotNull com.tencent.mobileqq.troop.troopcatalog.a bean) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bean);
            return;
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.userGender.setVisibility(8);
        this.userAge.setVisibility(8);
        this.userCity.setVisibility(8);
        String d16 = bean.d();
        if (d16 != null) {
            z16 = true;
            if (d16.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (z16) {
            this.troopCategory.setVisibility(0);
            this.troopCategory.setText(bean.d());
            this.infoTagLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public Button c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Button) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.againBtn;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @Nullable
    public TextView d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (TextView) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.alterTips;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public QQProAvatarView e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQProAvatarView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.avatar;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public TextView f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TextView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.blackListBtn;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public Button g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Button) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.cancelBtn;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @Nullable
    public ViewGroup h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.extraMessageLayout;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public TroopNotificationRichTextView i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        this.hintTips.setTextColor(this.messageTextColor);
        this.hintTips.setTextSize(this.messageTextSize);
        return this.hintTips;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public ViewGroup j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.messageLayout;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public Button l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Button) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.operationBtn;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public TextView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TextView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.reportBtn;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public ViewGroup n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.reportLayout;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @Nullable
    public TextView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (TextView) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.timeTag;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @NotNull
    public TroopNotificationRichTextView q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.titleLayout;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.titleTextColor;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    public float s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        return this.titleTextSize;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        TextView textView = this.doubtTipsView;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.levelInfoLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        this.infoTagLayout.setVisibility(8);
        this.userGender.setText("");
        this.userGender.setVisibility(8);
        this.troopCategory.setText("");
        this.troopCategory.setVisibility(8);
        this.userAge.setText("");
        this.userAge.setVisibility(8);
        this.userCity.setText("");
        this.userCity.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @Nullable
    public TroopNotificationRichTextView w(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 16, (Object) this, index);
        }
        Context context = o().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        TroopNotificationDetailTextView troopNotificationDetailTextView = new TroopNotificationDetailTextView(context, null, 2, null);
        troopNotificationDetailTextView.setMaxPrefixTextWidth(this.maxPrefixTextWidth);
        troopNotificationDetailTextView.setPrefixTextSize(this.extraMessageTextSize);
        troopNotificationDetailTextView.setPrefixTextColor(this.extraMessageTextColor);
        troopNotificationDetailTextView.setTextColor(this.extraMessageTextColor);
        troopNotificationDetailTextView.setTextSize(this.extraMessageTextSize);
        troopNotificationDetailTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, x.c(o().getContext(), 44.0f)));
        troopNotificationDetailTextView.setNeedGravityCenter(true);
        return troopNotificationDetailTextView;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    @Nullable
    public TroopNotificationRichTextView x(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 15, (Object) this, index);
        }
        Context context = o().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        TroopNotificationDetailTextView troopNotificationDetailTextView = new TroopNotificationDetailTextView(context, null, 2, null);
        troopNotificationDetailTextView.setMaxPrefixTextWidth(this.maxPrefixTextWidth);
        if (index == 0) {
            troopNotificationDetailTextView.setTextColor(this.firstMessageLineTextColor);
            troopNotificationDetailTextView.setTextSize(this.firstMessageLineTextSize);
            troopNotificationDetailTextView.setPrefixTextSize(this.firstMessageLineTextSize);
            troopNotificationDetailTextView.setPrefixTextColor(this.firstMessageLineTextColor);
        } else {
            troopNotificationDetailTextView.setTextColor(this.messageTextColor);
            troopNotificationDetailTextView.setTextSize(this.messageTextSize);
            troopNotificationDetailTextView.setPrefixTextSize(this.messageTextSize);
            troopNotificationDetailTextView.setPrefixTextColor(this.messageTextColor);
        }
        return troopNotificationDetailTextView;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a
    public void y(@NotNull f msg2) {
        String c16;
        ITroopRobotService iTroopRobotService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        com.tencent.qqnt.notification.b b16 = msg2.b();
        if (b16 == null || (c16 = b16.c()) == null || (iTroopRobotService = (ITroopRobotService) bg.l(ITroopRobotService.class)) == null) {
            return;
        }
        if (iTroopRobotService.isRobotUin(c16)) {
            this.robotIcon.setVisibility(0);
        } else {
            this.robotIcon.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull ViewGroup parent, @NotNull ts2.c viewBinding) {
        super(1, parent, viewBinding);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parent, (Object) viewBinding);
            return;
        }
        this.viewBinding = viewBinding;
        QQProAvatarView qQProAvatarView = viewBinding.f437342g;
        Intrinsics.checkNotNullExpressionValue(qQProAvatarView, "viewBinding.troopNotificationAvatar");
        this.avatar = qQProAvatarView;
        TroopNotificationRichTextView troopNotificationRichTextView = viewBinding.f437358w;
        Intrinsics.checkNotNullExpressionValue(troopNotificationRichTextView, "viewBinding.troopNotificationTitleLayout");
        this.titleLayout = troopNotificationRichTextView;
        LinearLayout linearLayout = viewBinding.f437351p;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.troopNotificationMessageLayout");
        this.messageLayout = linearLayout;
        QUIButton qUIButton = viewBinding.f437352q;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "viewBinding.troopNotificationOperateButton");
        this.operationBtn = qUIButton;
        QUIButton qUIButton2 = viewBinding.f437345j;
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "viewBinding.troopNotificationCancelButton");
        this.cancelBtn = qUIButton2;
        LinearLayout linearLayout2 = viewBinding.f437355t;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "viewBinding.troopNotificationReportLayout");
        this.reportLayout = linearLayout2;
        TextView textView = viewBinding.f437343h;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.troopNotificationBlacklistButton");
        this.blackListBtn = textView;
        TextView textView2 = viewBinding.f437354s;
        Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.troopNotificationReportButton");
        this.reportBtn = textView2;
        QUIButton qUIButton3 = viewBinding.f437339d;
        Intrinsics.checkNotNullExpressionValue(qUIButton3, "viewBinding.troopNotificationAgainButton");
        this.againBtn = qUIButton3;
        this.titleTextSize = 17.0f;
        this.titleTextColor = o().getContext().getResources().getColor(R.color.qui_common_text_primary);
        this.firstMessageLineTextSize = 17.0f;
        this.firstMessageLineTextColor = r();
        this.messageTextSize = 14.0f;
        this.messageTextColor = o().getContext().getResources().getColor(R.color.qui_common_text_secondary);
        this.maxPrefixTextWidth = x.c(o().getContext(), 73.0f);
        this.extraMessageTextSize = 16.0f;
        this.extraMessageTextColor = r();
        ImageView imageView = viewBinding.f437337b;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.robotIcon");
        this.robotIcon = imageView;
        RelativeLayout relativeLayout = viewBinding.f437349n;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "viewBinding.troopNotificationMainArea");
        this.mainArea = relativeLayout;
        TextView textView3 = viewBinding.f437356u;
        Intrinsics.checkNotNullExpressionValue(textView3, "viewBinding.troopNotificationTimeTag");
        this.timeTag = textView3;
        LinearLayout linearLayout3 = viewBinding.f437347l;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "viewBinding.troopNotificationExtraMessage");
        this.extraMessageLayout = linearLayout3;
        LinearLayout linearLayout4 = viewBinding.A;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "viewBinding.troopNotificationUserInfo");
        this.infoTagLayout = linearLayout4;
        TextView textView4 = viewBinding.f437361z;
        Intrinsics.checkNotNullExpressionValue(textView4, "viewBinding.troopNotificationUserGenderOrTroopTag");
        this.userGender = textView4;
        TextView textView5 = viewBinding.f437361z;
        Intrinsics.checkNotNullExpressionValue(textView5, "viewBinding.troopNotificationUserGenderOrTroopTag");
        this.troopCategory = textView5;
        TextView textView6 = viewBinding.f437359x;
        Intrinsics.checkNotNullExpressionValue(textView6, "viewBinding.troopNotificationUserAge");
        this.userAge = textView6;
        TextView textView7 = viewBinding.f437360y;
        Intrinsics.checkNotNullExpressionValue(textView7, "viewBinding.troopNotificationUserCity");
        this.userCity = textView7;
        LinearLayout linearLayout5 = viewBinding.f437353r;
        Intrinsics.checkNotNullExpressionValue(linearLayout5, "viewBinding.troopNotificationQqlevel");
        this.levelInfoLayout = linearLayout5;
        TextView textView8 = viewBinding.f437340e;
        Intrinsics.checkNotNullExpressionValue(textView8, "viewBinding.troopNotificationAlertTips");
        this.alterTips = textView8;
        TroopNotificationRichTextView troopNotificationRichTextView2 = viewBinding.f437348m;
        Intrinsics.checkNotNullExpressionValue(troopNotificationRichTextView2, "viewBinding.troopNotificationHintTips");
        this.hintTips = troopNotificationRichTextView2;
        ViewStub viewStub = viewBinding.f437346k;
        Intrinsics.checkNotNullExpressionValue(viewStub, "viewBinding.troopNotificationDoubtTipsVb");
        this.doubtTipsVB = viewStub;
        F();
    }
}
