package com.tencent.qqnt.aio.anonymous;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.AIONickState$UpdateAnonymousTagColor;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.LazyNickBlock;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.aio.utils.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/anonymous/AIOTroopAnonymousNickBlock;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "info", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "i", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "g", "", "r", "Landroid/widget/TextView;", "H", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/TextView;", "anonymousTagView", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "I", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOTroopAnonymousNickBlock extends LazyNickBlock {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy anonymousTagView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/anonymous/AIOTroopAnonymousNickBlock$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.anonymous.AIOTroopAnonymousNickBlock$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58108);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOTroopAnonymousNickBlock(@NotNull final Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(context) { // from class: com.tencent.qqnt.aio.anonymous.AIOTroopAnonymousNickBlock$anonymousTagView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TextView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TextView textView = new TextView(this.$context);
                    textView.setTextSize(0, this.$context.getResources().getDimension(R.dimen.f158235c01));
                    int dpToPx = ViewUtils.dpToPx(4.0f);
                    textView.setPadding(dpToPx, 0, dpToPx, 0);
                    textView.setIncludeFontPadding(false);
                    return textView;
                }
            });
            this.anonymousTagView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rootView);
        }
    }

    private final void A(GroupAnonymousInfo info) {
        if (u() && info != null) {
            if (info.isAnonymousChat) {
                z().setTextColor(-16777216);
            } else {
                z().setTextColor(-1);
            }
        }
    }

    private final TextView z() {
        return (TextView) this.anonymousTagView.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void g(@NotNull MviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIONickState$UpdateAnonymousTagColor) {
            A(((AIONickState$UpdateAnonymousTagColor) state).a());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void i(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem, (Object) payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (d.s(msgItem)) {
            AnonymousExtInfo anonymousExtInfo = msgItem.getMsgRecord().anonymousExtInfo;
            if (anonymousExtInfo != null) {
                String peerId = msgItem.v().peerUid;
                try {
                    int parseColor = Color.parseColor(anonymousExtInfo.rankColor);
                    TextView z16 = z();
                    GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{parseColor, parseColor});
                    gradientDrawable.setCornerRadius(ViewUtils.dpToPx(3.0f));
                    z16.setBackground(gradientDrawable);
                    z16.setText("\u533f\u540d");
                    j jVar = j.f194163a;
                    Intrinsics.checkNotNullExpressionValue(peerId, "peerId");
                    if (jVar.a(peerId)) {
                        z16.setTextColor(-16777216);
                    } else {
                        z16.setTextColor(-1);
                    }
                    LazyNickBlock.x(this, z16, null, 2, null);
                    return;
                } catch (Exception e16) {
                    m();
                    QLog.i("AIOTroopAnonymousNickBlock", 1, "parseColor exception " + e16);
                    return;
                }
            }
            return;
        }
        m();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }
}
