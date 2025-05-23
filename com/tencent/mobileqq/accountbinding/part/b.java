package com.tencent.mobileqq.accountbinding.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ck;
import com.tencent.mobileqq.util.cy;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.bm;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u000f\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001e\u001a\u00020\u0005R\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/part/b;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "Landroid/widget/ImageView;", "imageView", "", PhotoCategorySummaryInfo.AVATAR_URL, "F9", "J9", "", "Lcom/tencent/mobileqq/login/account/a;", "accountList", "K9", "D9", "uin", "G9", "C9", "H9", "tValue", "I9", "onInitView", "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "B9", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "d", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "getWechatInfo", "()Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "selectAccountDialog", "<init>", "(Lcom/tencent/mobileqq/register/bean/WechatInfo;)V", "f", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WechatInfo wechatInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog selectAccountDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/part/b$a;", "", "", "AVATAR_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.accountbinding.part.b$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/accountbinding/part/b$b", "Lcom/tencent/mobileqq/widget/bm$c;", "", "account", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.accountbinding.part.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C7092b implements bm.c {
        static IPatchRedirector $redirector_;

        C7092b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.bm.c
        public void a(@NotNull Object account) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, account);
                return;
            }
            Intrinsics.checkNotNullParameter(account, "account");
            com.tencent.mobileqq.login.account.a aVar = (com.tencent.mobileqq.login.account.a) account;
            if (aVar.g()) {
                b.this.C9(aVar.f());
            } else {
                b.this.G9(aVar.f());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull WechatInfo wechatInfo) {
        Intrinsics.checkNotNullParameter(wechatInfo, "wechatInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wechatInfo);
        } else {
            this.wechatInfo = wechatInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9(String uin) {
        if (getPartHost() instanceof WechatLoginBindingFragment) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment");
            ((WechatLoginBindingFragment) partHost).rh(uin);
        }
    }

    private final void D9() {
        Dialog dialog;
        try {
            Dialog dialog2 = this.selectAccountDialog;
            boolean z16 = false;
            if (dialog2 != null && dialog2.isShowing()) {
                z16 = true;
            }
            if (z16 && (dialog = this.selectAccountDialog) != null) {
                dialog.dismiss();
            }
        } catch (Exception e16) {
            QLog.e("WechatLoginBoundPart", 1, "hideSelectAccountDialog ", e16);
        }
    }

    private final void E9(View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.f112526o6);
        ImageView wechatAvatarIv = (ImageView) rootView.findViewById(R.id.y_o);
        View findViewById = rootView.findViewById(R.id.yrj);
        findViewById.setContentDescription(this.wechatInfo.g() + " " + findViewById.getResources().getString(R.string.f200924tf));
        textView.setText(this.wechatInfo.g());
        Intrinsics.checkNotNullExpressionValue(wechatAvatarIv, "wechatAvatarIv");
        F9(wechatAvatarIv, this.wechatInfo.b());
        TextView textView2 = (TextView) rootView.findViewById(R.id.f110256i1);
        TextView textView3 = (TextView) rootView.findViewById(R.id.f110236hz);
        QQProAvatarView qqAvatarIv = (QQProAvatarView) rootView.findViewById(R.id.y7f);
        rootView.findViewById(R.id.f166108yq3).setContentDescription(this.wechatInfo.e() + " " + this.wechatInfo.f());
        textView2.setText(this.wechatInfo.e());
        textView3.setText(this.wechatInfo.f());
        if (this.wechatInfo.f() != null) {
            com.tencent.mobileqq.login.account.d dVar = com.tencent.mobileqq.login.account.d.f241848a;
            Intrinsics.checkNotNullExpressionValue(qqAvatarIv, "qqAvatarIv");
            dVar.h(qqAvatarIv, this.wechatInfo.f(), 200, this.wechatInfo.c());
        } else {
            com.tencent.mobileqq.login.account.d dVar2 = com.tencent.mobileqq.login.account.d.f241848a;
            Intrinsics.checkNotNullExpressionValue(qqAvatarIv, "qqAvatarIv");
            dVar2.k(qqAvatarIv, this.wechatInfo.c());
        }
    }

    private final void F9(ImageView imageView, String avatarUrl) {
        Resources resources;
        if (TextUtils.isEmpty(avatarUrl)) {
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            resources = activity.getResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            return;
        }
        Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.nf5, null);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(avatarUrl, obtain);
        int dpToPx = ViewUtils.dpToPx(87.0f);
        cy cyVar = cy.f306749a;
        drawable2.setTag(cyVar.c(dpToPx, dpToPx));
        drawable2.setDecodeHandler(cyVar.d());
        imageView.setImageDrawable(drawable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(String uin) {
        if (getPartHost() instanceof WechatLoginBindingFragment) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment");
            WechatLoginBindingFragment.uh((WechatLoginBindingFragment) partHost, uin, 0, 0, 0, 14, null);
        }
    }

    private final void H9() {
        if (getPartHost() instanceof WechatLoginBindingFragment) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment");
            ((WechatLoginBindingFragment) partHost).vh();
        }
    }

    private final void I9(String tValue) {
        ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", tValue, tValue, 0, 0, "", "1", o.c(), "");
    }

    private final void J9(View rootView) {
        List listOf;
        int collectionSizeOrDefault;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.f111726m0), Integer.valueOf(R.id.tcz), Integer.valueOf(R.id.tdo)});
        List list = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList<View> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(rootView.findViewById(((Number) it.next()).intValue()));
        }
        for (View view : arrayList) {
            if (view != null) {
                view.setOnClickListener(this);
            }
            AccessibilityUtil.d(view, Button.class.getName());
        }
    }

    private final void K9(List<com.tencent.mobileqq.login.account.a> accountList) {
        HashMap hashMap = new HashMap();
        String string = BaseApplication.getContext().getString(R.string.f200604sk);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ogin_select_bind_account)");
        hashMap.put("key_dialog_title", string);
        hashMap.put("key_unbind_account_list", accountList);
        String string2 = BaseApplication.getContext().getString(R.string.f200104r8);
        Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026login_bind_other_account)");
        hashMap.put("key_unbind_account_tip", string2);
        hashMap.put("key_unbind_account_tip_view_on_click_listener", new View.OnClickListener() { // from class: com.tencent.mobileqq.accountbinding.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.L9(b.this, view);
            }
        });
        hashMap.put("key_unbind_account_show_login_btn", Boolean.FALSE);
        bm c16 = ck.f306664a.c(getActivity(), hashMap, new C7092b(), null);
        this.selectAccountDialog = c16;
        if (c16 != null) {
            c16.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("WechatLoginBoundPart", 2, "selectAccountDialog bind other account click");
        this$0.G9(null);
        this$0.I9("0X800C44D");
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.login.account.a aVar : com.tencent.mobileqq.login.account.d.f241848a.f()) {
            if (!TextUtils.equals(this.wechatInfo.f(), aVar.f())) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.i("WechatLoginBoundPart", 1, "changeBindingAccount jumpLoginFragment");
            G9(null);
        } else {
            QLog.i("WechatLoginBoundPart", 1, "changeBindingAccount showSelectAccountDialog");
            K9(arrayList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f111726m0) {
                B9();
                I9("0X800C44D");
            } else if (num != null && num.intValue() == R.id.tcz) {
                C9(this.wechatInfo.f());
                I9("0X800C44E");
            } else if (num != null && num.intValue() == R.id.tdo) {
                H9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View containerView = rootView.findViewById(R.id.u6c);
        containerView.setVisibility(0);
        Intrinsics.checkNotNullExpressionValue(containerView, "containerView");
        E9(containerView);
        J9(containerView);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            D9();
        }
    }
}
