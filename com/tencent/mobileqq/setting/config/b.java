package com.tencent.mobileqq.setting.config;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u000b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BL\u0012\u0006\u00108\u001a\u000201\u0012\b\b\u0002\u00109\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012%\b\u0002\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018\u00a2\u0006\u0004\b:\u0010;J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R?\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00107\u001a\u0002012\u0006\u00102\u001a\u0002018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/setting/config/b;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/setting/config/SingleLineRedTouchView;", "view", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "", "J", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "L", "", "position", "", "", "payloads", "K", "", BdhLogUtil.LogTag.Tag_Conn, "k", "Ljava/lang/String;", "getRedTouchPath", "()Ljava/lang/String;", "redTouchPath", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "l", "Lkotlin/jvm/functions/Function1;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "M", "(Lkotlin/jvm/functions/Function1;)V", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/x;", "singleLineConfig", "", DomainData.DOMAIN_NAME, "Z", "getHasRedTouch", "()Z", "setHasRedTouch", "(Z)V", "hasRedTouch", "", "value", "getRightText", "()Ljava/lang/CharSequence;", "N", "(Ljava/lang/CharSequence;)V", "rightText", "leftText", "leftIcon", "<init>", "(Ljava/lang/CharSequence;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class b extends w<SingleLineRedTouchView> {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String redTouchPath;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> onClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x<x.b.d, x.c.g> singleLineConfig;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean hasRedTouch;

    public /* synthetic */ b(CharSequence charSequence, int i3, String str, Function1 function1, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : str, (i16 & 8) == 0 ? function1 : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), str, function1, Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.singleLineConfig.K().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void D(@NotNull SingleLineRedTouchView view, @NotNull Group.c outMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) outMargin);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        if (this.singleLineConfig.K() instanceof x.b.C8996b) {
            outMargin.c(outMargin.getLeft() + view.getResources().getDimensionPixelSize(R.dimen.dac) + Utils.n(12.0f, view.getResources()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull SingleLineRedTouchView view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        view.d(this.singleLineConfig.K(), this.singleLineConfig.O());
        view.e(this.redTouchPath, this.onClick);
        this.hasRedTouch = view.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public SingleLineRedTouchView H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SingleLineRedTouchView) iPatchRedirector.redirect((short) 11, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        SingleLineRedTouchView singleLineRedTouchView = new SingleLineRedTouchView(context, null, 0, 6, null);
        singleLineRedTouchView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return singleLineRedTouchView;
    }

    public final void M(@Nullable Function1<? super View, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function1);
        } else {
            this.onClick = function1;
        }
    }

    public final void N(@NotNull CharSequence value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) value);
        } else {
            Intrinsics.checkNotNullParameter(value, "value");
            this.singleLineConfig.O().h(value);
        }
    }

    public b(@NotNull CharSequence leftText, int i3, @Nullable String str, @Nullable Function1<? super View, Unit> function1) {
        x.b dVar;
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, leftText, Integer.valueOf(i3), str, function1);
            return;
        }
        this.redTouchPath = str;
        this.onClick = function1;
        if (i3 > 0) {
            dVar = new x.b.C8996b(leftText, i3);
        } else {
            dVar = new x.b.d(leftText);
        }
        this.singleLineConfig = new x<>(dVar, new x.c.g("", true, false));
    }
}
