package com.tencent.qqnt.aio.assistedchat.aiservice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B%\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/aiservice/d;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/qqnt/aio/assistedchat/aiservice/AIServiceListItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "view", "", "position", "", "", "payloads", "", "N", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "L", "", BdhLogUtil.LogTag.Tag_Conn, "", "k", "Z", "M", "()Z", BdhLogUtil.LogTag.Tag_Req, "(Z)V", "isChecked", "l", "showIcon", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCheckedChangedListener", "Lcom/tencent/mobileqq/widget/listitem/g;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/widget/listitem/g;", "getOnBindViewListener", "()Lcom/tencent/mobileqq/widget/listitem/g;", ExifInterface.LATITUDE_SOUTH, "(Lcom/tencent/mobileqq/widget/listitem/g;)V", "onBindViewListener", "<init>", "(ZZLandroid/widget/CompoundButton$OnCheckedChangeListener;)V", "o", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d extends w<AIServiceListItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isChecked;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final boolean showIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final CompoundButton.OnCheckedChangeListener onCheckedChangedListener;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.g onBindViewListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/aiservice/d$a;", "", "", "SERVICE_URL", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.aiservice.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58226);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(boolean z16, boolean z17, @Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), onCheckedChangeListener);
            return;
        }
        this.isChecked = z16;
        this.showIcon = z17;
        this.onCheckedChangedListener = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(d this$0, CompoundButton buttonView, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        this$0.isChecked = z16;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this$0.onCheckedChangedListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(buttonView, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!u.a().b()) {
            QRoute.createNavigator(view.getContext(), RouterConstants.UI_ROUTE_BROWSER).withString("url", "https://rule.tencent.com/rule/abd15ee5-bbdf-402c-89d2-e10e9200cd1c").request();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "AI\u670d\u52a1";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void D(@NotNull AIServiceListItem view, @NotNull Group.c outMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) outMargin);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        outMargin.c(com.tencent.qqnt.aio.utils.l.b(16) + view.getContext().getResources().getDimensionPixelSize(R.dimen.dac) + com.tencent.qqnt.aio.utils.l.b(12));
    }

    public final boolean M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isChecked;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull AIServiceListItem view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        CompoundButton A0 = view.A0();
        A0.setOnCheckedChangeListener(null);
        A0.setChecked(this.isChecked);
        A0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                d.O(d.this, compoundButton, z16);
            }
        });
        view.z0().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.P(view2);
            }
        });
        com.tencent.mobileqq.widget.listitem.g gVar = this.onBindViewListener;
        if (gVar != null) {
            gVar.M(view.A0());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public AIServiceListItem H(@NotNull ViewGroup parent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AIServiceListItem) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AIServiceListItem aIServiceListItem = new AIServiceListItem(context, null, 0, 6, null);
        aIServiceListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(64.0f)));
        if (this.showIcon) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        aIServiceListItem.setIconVisibility(i3);
        return aIServiceListItem;
    }

    public final void R(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isChecked = z16;
        }
    }

    public final void S(@Nullable com.tencent.mobileqq.widget.listitem.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) gVar);
        } else {
            this.onBindViewListener = gVar;
        }
    }
}
