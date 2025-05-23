package com.tencent.mobileqq.troop.troopnotification.render.vh.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.notification.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts2.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 d2\u00020\u0001:\u0001eB!\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010a\u001a\u00020`\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\bb\u0010cJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010&\u001a\u00020!8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010,\u001a\u00020'8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u00102\u001a\u00020-8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00108\u001a\u0002038\u0016X\u0096D\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u0010=\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u0002038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b>\u00105R\u0014\u0010A\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010#R\u0016\u0010M\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010/R\u0016\u0010O\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010/R\u0016\u0010Q\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010#R\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010/R\u0016\u0010Y\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010/R\u0016\u0010[\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010HR\u0018\u0010]\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010/\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/b;", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "", "index", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "y", "Lcom/tencent/qqnt/notification/f;", "msg", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/data/troop/d;", "info", BdhLogUtil.LogTag.Tag_Conn, "", "doubtTips", "B", "w", "Lts2/d;", "K", "Lts2/d;", "viewBinding", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "L", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "l", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "M", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "t", "()Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "titleLayout", "Landroid/view/ViewGroup;", "N", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/view/ViewGroup;", "messageLayout", "Landroid/widget/Button;", "P", "Landroid/widget/Button;", "r", "()Landroid/widget/Button;", "operationBtn", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "hintBtn", "", BdhLogUtil.LogTag.Tag_Req, UserInfo.SEX_FEMALE, "v", "()F", "titleTextSize", ExifInterface.LATITUDE_SOUTH, "I", "u", "()I", "titleTextColor", "T", "messageTextSize", "U", "messageTextColor", "Landroid/view/View;", "V", "Landroid/view/View;", "robotIcon", "Landroid/view/ViewStub;", "W", "Landroid/view/ViewStub;", "tagLayoutVB", "X", "tagLayout", "Y", "qidianTag", "Z", "levelTag", "a0", "genderInfoTag", "Landroid/widget/ImageView;", "b0", "Landroid/widget/ImageView;", "genderIcon", "c0", "genderAge", "d0", "locationTag", "e0", "doubtTipsVB", "f0", "doubtTipsView", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "vm", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;Lts2/d;)V", "g0", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final d viewBinding;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final QQProAvatarView avatar;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final TroopNotificationRichTextView titleLayout;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup messageLayout;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Button operationBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final TextView hintBtn;

    /* renamed from: R, reason: from kotlin metadata */
    private final float titleTextSize;

    /* renamed from: S, reason: from kotlin metadata */
    private final int titleTextColor;

    /* renamed from: T, reason: from kotlin metadata */
    private final float messageTextSize;

    /* renamed from: U, reason: from kotlin metadata */
    private final int messageTextColor;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final View robotIcon;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private ViewStub tagLayoutVB;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private ViewGroup tagLayout;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView qidianTag;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView levelTag;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup genderInfoTag;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ImageView genderIcon;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private TextView genderAge;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private TextView locationTag;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewStub doubtTipsVB;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView doubtTipsView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/b$a;", "", "", "GENDER_MAN", "I", "GENDER_WOMAN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.render.vh.list.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ b(Context context, TroopNotificationListVM troopNotificationListVM, d dVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, troopNotificationListVM, r0);
        d dVar2;
        if ((i3 & 4) != 0) {
            dVar2 = d.g(LayoutInflater.from(context));
            Intrinsics.checkNotNullExpressionValue(dVar2, "inflate(LayoutInflater.from(context))");
        } else {
            dVar2 = dVar;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, troopNotificationListVM, dVar, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    public void B(@NotNull String doubtTips) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) doubtTips);
            return;
        }
        Intrinsics.checkNotNullParameter(doubtTips, "doubtTips");
        if (this.doubtTipsView == null) {
            View inflate = this.doubtTipsVB.inflate();
            if (inflate != null) {
                textView = (TextView) inflate.findViewById(R.id.f103125zr);
            } else {
                textView = null;
            }
            this.doubtTipsView = textView;
        }
        TextView textView2 = this.doubtTipsView;
        if (textView2 != null) {
            textView2.setText(doubtTips);
            textView2.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    public void C(@NotNull com.tencent.mobileqq.data.troop.d info) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.tagLayout == null) {
            ViewGroup viewGroup = (ViewGroup) this.tagLayoutVB.inflate().findViewById(R.id.f103035zi);
            this.tagLayout = viewGroup;
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(R.id.f10330609);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.troop_notification_qidian_tip)");
                this.qidianTag = (TextView) findViewById;
                View findViewById2 = viewGroup.findViewById(R.id.f10322601);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.troop_notification_level)");
                this.levelTag = (TextView) findViewById2;
                View findViewById3 = viewGroup.findViewById(R.id.f103185zx);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.troop_notification_gender_info)");
                this.genderInfoTag = (ViewGroup) findViewById3;
                View findViewById4 = viewGroup.findViewById(R.id.f103175zw);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.troop_notification_gender_icon)");
                this.genderIcon = (ImageView) findViewById4;
                View findViewById5 = viewGroup.findViewById(R.id.f103165zv);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.troop_notification_gender_age)");
                this.genderAge = (TextView) findViewById5;
                View findViewById6 = viewGroup.findViewById(R.id.f10323602);
                Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.troop_notification_location)");
                this.locationTag = (TextView) findViewById6;
            }
        }
        ViewGroup viewGroup2 = this.tagLayout;
        int i16 = 8;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        boolean z26 = true;
        TextView textView = null;
        if (info.i()) {
            if (info.k()) {
                TextView textView2 = this.qidianTag;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qidianTag");
                    textView2 = null;
                }
                textView2.setVisibility(0);
                z16 = true;
            } else {
                TextView textView3 = this.qidianTag;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qidianTag");
                    textView3 = null;
                }
                textView3.setVisibility(8);
                z16 = false;
            }
            String c16 = info.c();
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
                TextView textView4 = this.locationTag;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationTag");
                    textView4 = null;
                }
                textView4.setText("\u5728" + str);
                TextView textView5 = this.locationTag;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationTag");
                    textView5 = null;
                }
                textView5.setVisibility(0);
                z16 = true;
            } else {
                TextView textView6 = this.locationTag;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationTag");
                    textView6 = null;
                }
                textView6.setVisibility(8);
            }
            if (info.g() != 1 && info.g() != 2) {
                ViewGroup viewGroup3 = this.genderInfoTag;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("genderInfoTag");
                    viewGroup3 = null;
                }
                viewGroup3.setVisibility(8);
            } else {
                ViewGroup viewGroup4 = this.genderInfoTag;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("genderInfoTag");
                    viewGroup4 = null;
                }
                viewGroup4.setVisibility(0);
                if (info.b() > 0) {
                    TextView textView7 = this.genderAge;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genderAge");
                        textView7 = null;
                    }
                    textView7.setText(String.valueOf(info.b()));
                } else {
                    TextView textView8 = this.genderAge;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genderAge");
                        textView8 = null;
                    }
                    textView8.setText("");
                }
                ImageView imageView = this.genderIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("genderIcon");
                    imageView = null;
                }
                if (info.g() == 1) {
                    i3 = R.drawable.qui_male_brand;
                } else {
                    i3 = R.drawable.qui_female_pink;
                }
                imageView.setImageResource(i3);
                z16 = true;
            }
        } else {
            TextView textView9 = this.qidianTag;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qidianTag");
                textView9 = null;
            }
            textView9.setVisibility(8);
            TextView textView10 = this.locationTag;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationTag");
                textView10 = null;
            }
            textView10.setVisibility(8);
            ViewGroup viewGroup5 = this.genderInfoTag;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("genderInfoTag");
                viewGroup5 = null;
            }
            viewGroup5.setVisibility(8);
            z16 = false;
        }
        if (info.j()) {
            TextView textView11 = this.levelTag;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelTag");
                textView11 = null;
            }
            textView11.setVisibility(0);
            TextView textView12 = this.levelTag;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelTag");
            } else {
                textView = textView12;
            }
            textView.setText("LV" + info.e());
        } else {
            TextView textView13 = this.levelTag;
            if (textView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelTag");
            } else {
                textView = textView13;
            }
            textView.setVisibility(8);
            z26 = z16;
        }
        ViewGroup viewGroup6 = this.tagLayout;
        if (viewGroup6 != null) {
            if (z26) {
                i16 = 0;
            }
            viewGroup6.setVisibility(i16);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    @NotNull
    public QQProAvatarView l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQProAvatarView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.avatar;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    @NotNull
    public TextView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TextView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.hintBtn;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    @NotNull
    public ViewGroup q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.messageLayout;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    @NotNull
    public Button r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Button) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.operationBtn;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    @NotNull
    public TroopNotificationRichTextView t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.titleLayout;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.titleTextColor;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    public float v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.titleTextSize;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        TextView textView = this.doubtTipsView;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.tagLayout;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    @Nullable
    public TroopNotificationRichTextView y(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TroopNotificationRichTextView) iPatchRedirector.redirect((short) 10, (Object) this, index);
        }
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        TroopNotificationRichTextView troopNotificationRichTextView = new TroopNotificationRichTextView(context, null, 2, null);
        troopNotificationRichTextView.setTextColor(this.messageTextColor);
        troopNotificationRichTextView.setTextSize(this.messageTextSize);
        return troopNotificationRichTextView;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.vh.list.a
    public void z(@NotNull f msg2) {
        String c16;
        ITroopRobotService iTroopRobotService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) msg2);
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
    public b(@NotNull Context context, @NotNull TroopNotificationListVM vm5, @NotNull d viewBinding) {
        super(1, vm5, context, viewBinding);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, vm5, viewBinding);
            return;
        }
        this.viewBinding = viewBinding;
        QQProAvatarView qQProAvatarView = viewBinding.f437366e;
        Intrinsics.checkNotNullExpressionValue(qQProAvatarView, "viewBinding.troopNotificationAvatar");
        this.avatar = qQProAvatarView;
        TroopNotificationRichTextView troopNotificationRichTextView = viewBinding.f437372k;
        Intrinsics.checkNotNullExpressionValue(troopNotificationRichTextView, "viewBinding.troopNotificationTitleLayout");
        this.titleLayout = troopNotificationRichTextView;
        LinearLayout linearLayout = viewBinding.f437370i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.troopNotificationMessageLayout");
        this.messageLayout = linearLayout;
        QUIButton qUIButton = viewBinding.f437371j;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "viewBinding.troopNotificationOperateButton");
        this.operationBtn = qUIButton;
        TextView textView = viewBinding.f437369h;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.troopNotificationHintButton");
        this.hintBtn = textView;
        this.titleTextSize = 17.0f;
        this.titleTextColor = context.getResources().getColor(R.color.qui_common_text_primary);
        this.messageTextSize = 14.0f;
        this.messageTextColor = context.getResources().getColor(R.color.qui_common_text_secondary);
        ImageView imageView = viewBinding.f437363b;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.robotIcon");
        this.robotIcon = imageView;
        ViewStub viewStub = viewBinding.f437365d;
        Intrinsics.checkNotNullExpressionValue(viewStub, "viewBinding.troopNotificationApplicantInfoVb");
        this.tagLayoutVB = viewStub;
        ViewStub viewStub2 = viewBinding.f437368g;
        Intrinsics.checkNotNullExpressionValue(viewStub2, "viewBinding.troopNotificationDoubtTipsVb");
        this.doubtTipsVB = viewStub2;
    }
}
