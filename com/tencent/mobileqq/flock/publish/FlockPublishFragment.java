package com.tencent.mobileqq.flock.publish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.base.FlockBaseFragment;
import com.tencent.mobileqq.flock.ktx.i;
import com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishContentPart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishImageGalleryPart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishKeyboardPart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishLbsPart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishNavigatePart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishPrivacyPart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishRepeatPart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishTimePart;
import com.tencent.mobileqq.flock.publish.part.FlockPublishTopicPart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010`\u0011H\u0016R\u001b\u0010\u0017\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/FlockPublishFragment;", "Lcom/tencent/mobileqq/flock/base/FlockBaseFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getPageId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ph", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "sh", "()Ljava/lang/String;", "agreementLink", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishFragment extends FlockBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy agreementLink;

    public FlockPublishFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(FlockPublishFragment$agreementLink$2.INSTANCE);
            this.agreementLink = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String sh() {
        return (String) this.agreementLink.getValue();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        final FlockPublishContentPart flockPublishContentPart = new FlockPublishContentPart();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new FlockPublishNavigatePart(), flockPublishContentPart, new FlockPublishKeyboardPart(new Function0<EditText>() { // from class: com.tencent.mobileqq.flock.publish.FlockPublishFragment$assembleParts$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishContentPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final EditText invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? FlockPublishContentPart.this.C9() : (EditText) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        }), new FlockPublishImageGalleryPart(), new FlockPublishTimePart(), new FlockPublishActionPart(), new FlockPublishTopicPart(), new FlockPublishRepeatPart(), new FlockPublishLbsPart(), new FlockPublishPrivacyPart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e8u;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public String getPageId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "pg_bas_partner_publishing";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        IQQWinkLauncher iQQWinkLauncher = (IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        iQQWinkLauncher.preloadQQWink(context);
        if (QQTheme.isVasTheme()) {
            view.findViewById(R.id.if5).setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        }
        View findViewById = view.findViewById(R.id.vbk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<View>(\u2026.flock_publish_desc_link)");
        i.d(findViewById, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.flock.publish.FlockPublishFragment$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                String sh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
                Context context2 = it.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "it.context");
                sh5 = FlockPublishFragment.this.sh();
                aVar.m(context2, sh5);
            }
        }, 1, null);
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public HashMap<String, Object> ph() {
        int i3;
        HashMap<String, Object> hashMapOf;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            i3 = intent.getIntExtra("key_flock_from", 0);
        } else {
            i3 = 0;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("call_up_publishing_source", String.valueOf(i3)));
        return hashMapOf;
    }
}
