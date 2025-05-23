package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactMoreViewModel;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactMoreFragment$initObserver$2 extends Lambda implements Function1<AddContactMoreViewModel.b, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AddContactMoreFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddContactMoreFragment$initObserver$2(AddContactMoreFragment addContactMoreFragment) {
        super(1);
        this.this$0 = addContactMoreFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) addContactMoreFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AddContactMoreFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Oh();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AddContactMoreViewModel.b bVar) {
        invoke2(bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AddContactMoreViewModel.b it) {
        i iVar;
        ContactRefreshHeader contactRefreshHeader;
        ContactRefreshHeader contactRefreshHeader2;
        i iVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        iVar = this.this$0.stateDelegate;
        View view = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
            iVar = null;
        }
        iVar.c();
        if (!this.this$0.Nh().a2()) {
            TextView textView = this.this$0.footView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footView");
                textView = null;
            }
            textView.setText(HardCodeUtil.qqStr(R.string.sws));
            TextView textView2 = this.this$0.footView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footView");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            TextView textView3 = this.this$0.footView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footView");
                textView3 = null;
            }
            textView3.setText(HardCodeUtil.qqStr(R.string.swr));
            TextView textView4 = this.this$0.footView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footView");
                textView4 = null;
            }
            textView4.setVisibility(4);
        }
        if (it instanceof AddContactMoreViewModel.b.a) {
            AddContactMoreViewModel.b.a aVar = (AddContactMoreViewModel.b.a) it;
            if (!aVar.d()) {
                iVar2 = this.this$0.stateDelegate;
                if (iVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
                    iVar2 = null;
                }
                iVar2.h();
                CommonRefreshLayout commonRefreshLayout = this.this$0.refreshLayout;
                if (commonRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                } else {
                    view = commonRefreshLayout;
                }
                view.setVisibility(8);
                return;
            }
            CommonRefreshLayout commonRefreshLayout2 = this.this$0.refreshLayout;
            if (commonRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                view = commonRefreshLayout2;
            }
            view.setVisibility(0);
            this.this$0.Xh();
            AddContactMoreFragment addContactMoreFragment = this.this$0;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            addContactMoreFragment.Wh(aVar);
            return;
        }
        if (it instanceof AddContactMoreViewModel.b.c) {
            if (((AddContactMoreViewModel.b.c) it).a()) {
                this.this$0.Nh().h2();
                contactRefreshHeader = this.this$0.headerView;
                if (contactRefreshHeader == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    contactRefreshHeader = null;
                }
                contactRefreshHeader.l(0);
                contactRefreshHeader2 = this.this$0.headerView;
                if (contactRefreshHeader2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                } else {
                    view = contactRefreshHeader2;
                }
                final AddContactMoreFragment addContactMoreFragment2 = this.this$0;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        AddContactMoreFragment$initObserver$2.b(AddContactMoreFragment.this);
                    }
                }, 800L);
                this.this$0.Xh();
                return;
            }
            this.this$0.Oh();
            this.this$0.Vh(1, R.string.hqe);
            return;
        }
        if (!(it instanceof AddContactMoreViewModel.b.C7148b) || ((AddContactMoreViewModel.b.C7148b) it).a()) {
            return;
        }
        this.this$0.Vh(1, R.string.f197384jv);
    }
}
