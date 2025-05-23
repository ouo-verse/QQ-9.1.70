package com.tencent.mobileqq.troop.troopnotification.render.richtext;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.troopnotification.render.TroopNotificationRender;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 O2\u00020\u0001:\u0001PB\u001d\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u00a2\u0006\u0004\bM\u0010NJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u001c\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0014J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010$R\"\u0010+\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00109\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010=\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u0016\u0010?\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00104R\"\u0010C\u001a\u0002038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u00104\u001a\u0004\bA\u00106\"\u0004\bB\u00108R\u0016\u0010D\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00104R\"\u0010H\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u00104\u001a\u0004\bF\u00106\"\u0004\bG\u00108\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "Landroid/widget/LinearLayout;", "", "text", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/f;", "richText", "f", tl.h.F, "l", "Landroid/view/View;", "i", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "k", "", "p", "", "o", "Lcom/tencent/qqnt/notification/f;", "msg", "", "data", "t", "e", "widthMeasureSpec", "heightMeasureSpec", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onMeasure", "d", "Lcom/tencent/qqnt/notification/f;", "", "Ljava/util/List;", "", "Ljava/util/Map;", "dataMap", "I", "getTextColor", "()I", "setTextColor", "(I)V", "textColor", "", UserInfo.SEX_FEMALE, ReportConstant.COSTREPORT_PREFIX, "()F", "setTextSize", "(F)V", "textSize", "", "Z", "getMemberTextClickable", "()Z", "setMemberTextClickable", "(Z)V", "memberTextClickable", BdhLogUtil.LogTag.Tag_Conn, "getGroupTextClickable", "setGroupTextClickable", "groupTextClickable", "D", "hadReMeasure", "E", "getSingleLine", "setSingleLine", "singleLine", "singleData", "G", "r", "setNeedGravityCenter", "needGravityCenter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class TroopNotificationRichTextView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean groupTextClickable;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hadReMeasure;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean singleLine;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean singleData;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needGravityCenter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.notification.f msg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> data;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, f> dataMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int textColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float textSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean memberTextClickable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView$a;", "", "", "ELLIPSIS", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopNotificationRichTextView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) context);
    }

    private final TextView f(final f richText) {
        SpannableString colorNickTxt = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(richText.b(), 16);
        Intrinsics.checkNotNullExpressionValue(colorNickTxt, "colorNickTxt");
        TextView m3 = m(colorNickTxt);
        if (m3 != null) {
            m3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.richtext.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopNotificationRichTextView.g(TroopNotificationRichTextView.this, richText, view);
                }
            });
            return m3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TroopNotificationRichTextView this$0, f richText, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(richText, "$richText");
        com.tencent.qqnt.notification.f fVar = this$0.msg;
        if (fVar != null) {
            TroopNotificationRender troopNotificationRender = TroopNotificationRender.f300720a;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            troopNotificationRender.s(view, fVar, richText);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final TextView h(f richText) {
        if (this.groupTextClickable) {
            TextView f16 = f(richText);
            if (f16 != null) {
                f16.setMaxLines(1);
                f16.setEllipsize(TextUtils.TruncateAt.END);
                this.singleLine = true;
                return f16;
            }
            return null;
        }
        return m(richText.b());
    }

    private final View i(f richText) {
        TextView textView = null;
        boolean z16 = true;
        if (richText.a() instanceof f) {
            final Object a16 = richText.a();
            f fVar = (f) a16;
            View e16 = e(fVar);
            if (e16 != null) {
                if (fVar.c() == 1 || fVar.c() == 2) {
                    if (e16 instanceof TextView) {
                        textView = (TextView) e16;
                    }
                    if (textView != null) {
                        textView.setMaxLines(1);
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        this.singleLine = true;
                    }
                }
                e16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.richtext.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopNotificationRichTextView.j(TroopNotificationRichTextView.this, a16, view);
                    }
                });
                textView = e16;
            }
        } else {
            if (richText.b().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                textView = f(richText);
            }
        }
        if (textView instanceof TextView) {
            textView.setTextColor(getResources().getColor(R.color.qui_common_text_link));
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TroopNotificationRichTextView this$0, Object obj, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.notification.f fVar = this$0.msg;
        if (fVar != null) {
            TroopNotificationRender troopNotificationRender = TroopNotificationRender.f300720a;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            troopNotificationRender.s(view, fVar, (f) obj);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final ImageView k(f richText) {
        String str;
        boolean z16;
        Object a16 = richText.a();
        if (a16 instanceof String) {
            str = (String) a16;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            int identifier = getContext().getResources().getIdentifier(str, "drawable", getContext().getPackageName());
            if (identifier > 0) {
                ImageView imageView = new ImageView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p(), p());
                layoutParams.gravity = 16;
                layoutParams.rightMargin = x.c(getContext(), 2.0f);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(identifier);
                addView(imageView);
                return imageView;
            }
            QLog.e("TroopNotificationRichTextView", 1, "addIcon: no find token res id ");
        }
        return null;
    }

    private final TextView l(final f richText) {
        final TextView m3;
        if (this.memberTextClickable) {
            m3 = f(richText);
            if (m3 != null) {
                m3.setMaxLines(1);
                m3.setEllipsize(TextUtils.TruncateAt.END);
                this.singleLine = true;
            } else {
                m3 = null;
            }
        } else {
            m3 = m(richText.b());
        }
        if (m3 == null) {
            return null;
        }
        m3.setText("");
        TroopNotificationMemberTextParser.f300796a.c(m3, richText, new Function0<Unit>(m3, richText) { // from class: com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView$addMemberText$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextView $it;
            final /* synthetic */ f $richText;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$it = m3;
                this.$richText = richText;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopNotificationRichTextView.this, m3, richText);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                TroopNotificationRichTextView.this.hadReMeasure = false;
                map = TroopNotificationRichTextView.this.dataMap;
                map.put(Integer.valueOf(this.$it.hashCode()), new f(this.$it.getText().toString(), this.$richText.c(), this.$richText.a()));
                TroopNotificationRichTextView.this.requestLayout();
            }
        });
        return m3;
    }

    private final TextView m(CharSequence text) {
        boolean z16;
        if (text.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (this.needGravityCenter) {
                layoutParams.gravity = 16;
            }
            textView.setLayoutParams(layoutParams);
            if (!this.singleData) {
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
            textView.setTextSize(this.textSize);
            textView.setTextColor(this.textColor);
            textView.setText(text);
            addView(textView);
            return textView;
        }
        return null;
    }

    private final QQProAvatarView n(f richText) {
        com.tencent.qqnt.notification.b bVar;
        Object a16 = richText.a();
        AttributeSet attributeSet = null;
        byte b16 = 0;
        if (a16 instanceof com.tencent.qqnt.notification.b) {
            bVar = (com.tencent.qqnt.notification.b) a16;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QQProAvatarView qQProAvatarView = new QQProAvatarView(context, attributeSet, 2, (DefaultConstructorMarker) (b16 == true ? 1 : 0));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p(), p());
        layoutParams.gravity = 16;
        layoutParams.rightMargin = x.c(getContext(), 2.0f);
        qQProAvatarView.setLayoutParams(layoutParams);
        qQProAvatarView.x(bVar.d(), bVar.c(), null);
        addView(qQProAvatarView);
        return qQProAvatarView;
    }

    private final int p() {
        return x.c(getContext(), this.textSize + 6);
    }

    @Nullable
    protected View e(@NotNull f richText) {
        View m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this, (Object) richText);
        }
        Intrinsics.checkNotNullParameter(richText, "richText");
        switch (richText.c()) {
            case 0:
            case 3:
                m3 = m(richText.b());
                break;
            case 1:
                m3 = l(richText);
                break;
            case 2:
                m3 = h(richText);
                break;
            case 4:
                m3 = n(richText);
                break;
            case 5:
                m3 = i(richText);
                break;
            case 6:
                m3 = k(richText);
                break;
            default:
                m3 = null;
                break;
        }
        if (m3 == null) {
            return null;
        }
        this.dataMap.put(Integer.valueOf(m3.hashCode()), richText);
        return m3;
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.msg = null;
        this.data.clear();
        removeAllViews();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[SYNTHETIC] */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.singleLine) {
            return;
        }
        int measuredWidth2 = getMeasuredWidth();
        int q16 = q(widthMeasureSpec, heightMeasureSpec);
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationRichTextView", 2, "onMeasure:" + hashCode() + " width=" + measuredWidth2 + ", maxWidth=" + q16 + ", children.count=" + getChildCount());
        }
        if (measuredWidth2 >= q16 && !this.hadReMeasure) {
            this.hadReMeasure = true;
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            for (View view : ViewGroupKt.getChildren(this)) {
                f fVar = this.dataMap.get(Integer.valueOf(view.hashCode()));
                if ((view instanceof TextView) && fVar != null) {
                    measuredWidth = (int) ((TextView) view).getPaint().measureText(fVar.b());
                    if (fVar.c() == 1 || fVar.c() == 2 || fVar.c() == 5) {
                        arrayList.add(view);
                        i3 += measuredWidth;
                        if (!QLog.isColorLevel()) {
                            QLog.d("TroopNotificationRichTextView", 2, "onMeasure:" + hashCode() + " child.tag=" + fVar + ", width=" + view.getMeasuredWidth() + ", needWidth=" + measuredWidth);
                        }
                    }
                } else {
                    measuredWidth = view.getMeasuredWidth();
                }
                i16 += measuredWidth;
                i3 += measuredWidth;
                if (!QLog.isColorLevel()) {
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationRichTextView", 2, "onMeasure:" + hashCode() + " allNeedWidth=" + i3 + ", normalTextNeedWidth=" + i16);
            }
            if (i3 > q16) {
                if (i16 > q16) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((TextView) it.next()).setText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    }
                } else {
                    int size = (q16 - i16) / arrayList.size();
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        ((TextView) it5.next()).getLayoutParams().width = size;
                    }
                }
            }
            requestLayout();
        }
    }

    protected int q(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec))).intValue();
        }
        return View.MeasureSpec.getSize(widthMeasureSpec);
    }

    public final boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.needGravityCenter;
    }

    public final float s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.textSize;
    }

    public final void setGroupTextClickable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.groupTextClickable = z16;
        }
    }

    public final void setMemberTextClickable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.memberTextClickable = z16;
        }
    }

    public final void setNeedGravityCenter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.needGravityCenter = z16;
        }
    }

    public final void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.textColor = i3;
        }
    }

    public final void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.textSize = f16;
        }
    }

    public final void t(@NotNull com.tencent.qqnt.notification.f msg2, @NotNull List<f> data) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) msg2, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z17 = false;
        this.hadReMeasure = false;
        this.msg = msg2;
        this.data.clear();
        removeAllViews();
        this.data.addAll(data);
        this.dataMap.clear();
        if (data.size() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.singleData = z16;
        if (data.size() > 1) {
            z17 = true;
        }
        this.singleLine = z17;
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            e((f) it.next());
        }
    }

    public /* synthetic */ TroopNotificationRichTextView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopNotificationRichTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        setOrientation(0);
        this.data = new ArrayList();
        this.dataMap = new LinkedHashMap();
    }
}
