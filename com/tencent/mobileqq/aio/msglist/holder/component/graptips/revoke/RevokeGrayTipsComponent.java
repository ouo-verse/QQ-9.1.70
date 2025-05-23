package com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.GrayTipsMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.b;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.RevokeGrayTipsUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.f;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.AutoBgImageView;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002ABB\u000f\u0012\u0006\u00100\u001a\u00020+\u00a2\u0006\u0004\b>\u0010?J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J0\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J&\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020!2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020#H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u000eH\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\tH\u0016R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/GrayTipsMsgItem;", "", "", "payloads", "", "Q1", "msgItem", "", "U1", "R1", "Lgv3/a;", "M1", "", "Landroid/text/style/ClickableSpan;", "clickableSpans", "K1", "", "nickBy", "textFirst", "nickOf", "textTail", "canEdit", "V1", "O1", "Landroid/view/View;", "e1", "", "importance", "l1", "c1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/i;", "L1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "currentElement", "D", "Lgv3/a;", "aioAbility", "Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent$a;", "E", "Lkotlin/Lazy;", "N1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent$a;", "binding", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RevokeGrayTipsComponent extends BaseContentComponent<GrayTipsMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private RevokeElement currentElement;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private gv3.a aioAbility;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent$a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "c", "()Landroid/view/ViewGroup;", "f", "(Landroid/view/ViewGroup;)V", "root", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "e", "(Landroid/widget/TextView;)V", "grayTipsTextTotal", "Lcom/tencent/mobileqq/qqui/widget/AutoBgImageView;", "Lcom/tencent/mobileqq/qqui/widget/AutoBgImageView;", "()Lcom/tencent/mobileqq/qqui/widget/AutoBgImageView;", "d", "(Lcom/tencent/mobileqq/qqui/widget/AutoBgImageView;)V", "grayTipsCloseIcon", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public ViewGroup root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public TextView grayTipsTextTotal;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public AutoBgImageView grayTipsCloseIcon;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final AutoBgImageView a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (AutoBgImageView) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            AutoBgImageView autoBgImageView = this.grayTipsCloseIcon;
            if (autoBgImageView != null) {
                return autoBgImageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsCloseIcon");
            return null;
        }

        @NotNull
        public final TextView b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            TextView textView = this.grayTipsTextTotal;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsTextTotal");
            return null;
        }

        @NotNull
        public final ViewGroup c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ViewGroup viewGroup = this.root;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }

        public final void d(@NotNull AutoBgImageView autoBgImageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) autoBgImageView);
            } else {
                Intrinsics.checkNotNullParameter(autoBgImageView, "<set-?>");
                this.grayTipsCloseIcon = autoBgImageView;
            }
        }

        public final void e(@NotNull TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) textView);
            } else {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.grayTipsTextTotal = textView;
            }
        }

        public final void f(@NotNull ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
            } else {
                Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
                this.root = viewGroup;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.RevokeGrayTipsComponent$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends ClickableSpan {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RevokeGrayTipsComponent.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            RevokeGrayTipsComponent revokeGrayTipsComponent = RevokeGrayTipsComponent.this;
            revokeGrayTipsComponent.sendIntent(new b.a(RevokeGrayTipsComponent.J1(revokeGrayTipsComponent)));
            RevokeGrayTipsComponent.this.C1();
            HashMap hashMap = new HashMap();
            RevokeGrayTipsComponent revokeGrayTipsComponent2 = RevokeGrayTipsComponent.this;
            hashMap.put("gray_click_area", 1);
            hashMap.put("small_gray_service_id", Long.valueOf(RevokeGrayTipsComponent.J1(revokeGrayTipsComponent2).m2()));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_small_gray", hashMap);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ds5.linkColor);
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent$d", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d extends ClickableSpan {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RevokeGrayTipsComponent.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            RevokeGrayTipsComponent revokeGrayTipsComponent = RevokeGrayTipsComponent.this;
            revokeGrayTipsComponent.sendIntent(new b.a(RevokeGrayTipsComponent.J1(revokeGrayTipsComponent)));
            RevokeGrayTipsComponent.this.C1();
            HashMap hashMap = new HashMap();
            RevokeGrayTipsComponent revokeGrayTipsComponent2 = RevokeGrayTipsComponent.this;
            hashMap.put("gray_click_area", 1);
            hashMap.put("small_gray_service_id", Long.valueOf(RevokeGrayTipsComponent.J1(revokeGrayTipsComponent2).m2()));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_small_gray", hashMap);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
            } else {
                Intrinsics.checkNotNullParameter(ds5, "ds");
                ds5.setUnderlineText(false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RevokeGrayTipsComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new RevokeGrayTipsComponent$binding$2(this));
        this.binding = lazy;
    }

    public static final /* synthetic */ GrayTipsMsgItem J1(RevokeGrayTipsComponent revokeGrayTipsComponent) {
        return revokeGrayTipsComponent.q1();
    }

    private final void K1(List<? extends ClickableSpan> clickableSpans) {
        gv3.a M1;
        if (clickableSpans == null || q1().l2()) {
            return;
        }
        for (ClickableSpan clickableSpan : clickableSpans) {
            if ((clickableSpan instanceof com.tencent.qqnt.graytips.span.a) && (M1 = M1()) != null) {
                ((com.tencent.qqnt.graytips.span.a) clickableSpan).c(M1);
            }
        }
        q1().z2(true);
    }

    private final gv3.a M1() {
        if (this.aioAbility == null) {
            f.a aVar = new f.a(null, 1, null);
            sendIntent(aVar);
            this.aioAbility = aVar.a();
        }
        return this.aioAbility;
    }

    private final a N1() {
        return (a) this.binding.getValue();
    }

    private final void O1(GrayTipsMsgItem msgItem) {
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack() && msgItem.n0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.c
                @Override // java.lang.Runnable
                public final void run() {
                    RevokeGrayTipsComponent.P1(RevokeGrayTipsComponent.this);
                }
            });
            msgItem.N1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(RevokeGrayTipsComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N1().b().performAccessibilityAction(64, null);
    }

    private final boolean Q1(List<Object> payloads) {
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.ACCESSIBILITY_FOCUS_PAYLOAD) != null) {
                    O1(q1());
                }
                if (map.get(AIOMsgItemPayloadType.GRAY_TIP_CONTENT_PAYLOAD) != null) {
                    return true;
                }
                if (map.get(AIOMsgItemPayloadType.NICK_PAYLOAD) != null) {
                    N1().b().setText(q1().r2());
                }
            }
        }
        return false;
    }

    private final void R1() {
        N1().b().setTextColor(getMContext().getColorStateList(R.color.qui_common_text_secondary));
        N1().b().setLinkTextColor(getMContext().getColorStateList(R.color.qui_common_text_link));
        N1().a().setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_close_filled_icon_secondary_01));
        N1().b().setText(q1().r2());
        N1().b().setMovementMethod(LinkMovementMethod.getInstance());
        N1().c().setImportantForAccessibility(2);
        int a16 = x.a(9.0f);
        AIOUtil.f194084a.e(N1().a(), a16, a16, a16, a16);
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack() && q1().o2() && q1().r2().length() >= 4) {
            N1().b().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RevokeGrayTipsComponent.S1(view);
                }
            });
            AccessibilityUtil.t(N1().b(), new AccessibilityUtil.i() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.b
                @Override // com.tencent.mobileqq.util.AccessibilityUtil.i
                public final void onClick(View view) {
                    RevokeGrayTipsComponent.T1(RevokeGrayTipsComponent.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        view.sendAccessibilityEvent(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(RevokeGrayTipsComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new b.a(this$0.q1()));
        this$0.C1();
        HashMap hashMap = new HashMap();
        hashMap.put("gray_click_area", 1);
        hashMap.put("small_gray_service_id", Long.valueOf(this$0.q1().m2()));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_small_gray", hashMap);
    }

    private final void U1(GrayTipsMsgItem msgItem) {
        if (msgItem.o2() && msgItem.r2().length() >= 4) {
            c cVar = new c();
            SpannableStringBuilder r26 = msgItem.r2();
            r26.setSpan(cVar, r26.length() - 4, r26.length(), 33);
        }
    }

    private final void V1(CharSequence nickBy, CharSequence textFirst, CharSequence nickOf, CharSequence textTail, boolean canEdit) {
        if (canEdit) {
            d dVar = new d();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s%s", Arrays.copyOf(new Object[]{textTail, getMContext().getString(R.string.f172082ph)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(dVar, format.length() - 4, format.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getMContext().getResources().getColor(R.color.qui_common_text_link)), format.length() - 4, format.length(), 33);
            textTail = spannableString;
        }
        new SpannableStringBuilder(nickBy).append(textFirst).append(nickOf).append(textTail);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public i createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (i) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.currentElement == null) {
            return new i();
        }
        return new i();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (Q1(payloads)) {
            U1(q1());
            K1(q1().j2());
            R1();
        }
        if (!q1().s2()) {
            q1().y2(true);
            HashMap hashMap = new HashMap();
            hashMap.put("small_gray_service_id", Long.valueOf(q1().m2()));
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_small_gray", hashMap);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return N1().c();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return N1().b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RevokeGrayTipsUIState.SetRevokeText) {
            RevokeGrayTipsUIState.SetRevokeText setRevokeText = (RevokeGrayTipsUIState.SetRevokeText) state;
            V1(setRevokeText.b(), setRevokeText.d(), setRevokeText.c(), setRevokeText.e(), setRevokeText.a());
        }
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, importance);
        } else {
            N1().b().setImportantForAccessibility(importance);
            N1().a().setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.aioAbility = null;
        GrayTipsMsgItem D1 = D1();
        if (D1 != null) {
            D1.y2(false);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 8, (Object) this);
    }
}
