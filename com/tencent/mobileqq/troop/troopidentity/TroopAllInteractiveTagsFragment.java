package com.tencent.mobileqq.troop.troopidentity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopidentity.data.ParcelIdentityInteractionTag;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopAllInteractiveTagsFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "uh", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "xh", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "useQUISecNavBar", "needImmersive", "Lcom/tencent/mobileqq/troop/troopidentity/TroopAllInteractiveTagsVM;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/troop/troopidentity/TroopAllInteractiveTagsVM;", "vm", "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c;", "D", "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c;", "adapter", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAllInteractiveTagsFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopidentity.view.alltags.c adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopAllInteractiveTagsFragment$a;", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "context", "Lcom/tencent/mobileqq/troop/troopidentity/data/a;", "params", "", "a", "", "INTENT_KEY_TAG_LIST", "Ljava/lang/String;", "RESULT_KEY_SELECTED_ID", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.TroopAllInteractiveTagsFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@NotNull QBaseFragment context, @NotNull com.tencent.mobileqq.troop.troopidentity.data.a params) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) params);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            if (u.a().b()) {
                return;
            }
            String d16 = params.d();
            String a16 = params.a();
            ArrayList<GroupIdentityInteractionTag> c16 = params.c();
            if (c16 != null) {
                num = Integer.valueOf(c16.size());
            } else {
                num = null;
            }
            QLog.i("TroopAllInteractiveTagsFragment", 1, "[openPage] troopUin:" + d16 + ", memberUin:" + a16 + ", tagSize:" + num);
            Intent intent = new Intent();
            intent.putExtra("troop_uin", params.d());
            intent.putExtra("uin", params.a());
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            ArrayList<GroupIdentityInteractionTag> c17 = params.c();
            if (c17 != null) {
                Iterator<T> it = c17.iterator();
                while (it.hasNext()) {
                    arrayList.add(ParcelIdentityInteractionTag.a((GroupIdentityInteractionTag) it.next()));
                }
            }
            intent.putParcelableArrayListExtra("key_identity_interaction_tags", arrayList);
            QPublicFragmentActivity.startForResult(context, intent, (Class<? extends QPublicBaseFragment>) TroopAllInteractiveTagsFragment.class, params.b());
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57660);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopAllInteractiveTagsFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopAllInteractiveTagsVM>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopAllInteractiveTagsFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAllInteractiveTagsFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TroopAllInteractiveTagsVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (TroopAllInteractiveTagsVM) TroopAllInteractiveTagsFragment.this.getViewModel(TroopAllInteractiveTagsVM.class) : (TroopAllInteractiveTagsVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void initView(View rootView) {
        setTitle("\u7fa4\u4e92\u52a8\u6807\u8bc6");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.quiSecNavBar.R(activity);
        }
        this.quiSecNavBar.findViewById(R.id.f81564ei).setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.xpd);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Context context = getContext();
        if (context == null) {
            context = getHostActivity();
        }
        Intrinsics.checkNotNullExpressionValue(context, "context?: hostActivity");
        com.tencent.mobileqq.troop.troopidentity.view.alltags.c cVar = new com.tencent.mobileqq.troop.troopidentity.view.alltags.c(context, th().S1(), th().P1(), new Function2<GroupIdentityInteractionTag, Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopAllInteractiveTagsFragment$initView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAllInteractiveTagsFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupIdentityInteractionTag groupIdentityInteractionTag, Boolean bool) {
                invoke(groupIdentityInteractionTag, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable GroupIdentityInteractionTag groupIdentityInteractionTag, boolean z16) {
                TroopAllInteractiveTagsVM th5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, groupIdentityInteractionTag, Boolean.valueOf(z16));
                    return;
                }
                if (groupIdentityInteractionTag == null) {
                    return;
                }
                QLog.i("TroopAllInteractiveTagsFragment", 1, "on InteractiveTag select status changed, icon:" + groupIdentityInteractionTag.name + ", isSelected:" + z16);
                th5 = TroopAllInteractiveTagsFragment.this.th();
                th5.X1(z16, groupIdentityInteractionTag);
            }
        });
        this.adapter = cVar;
        recyclerView.setAdapter(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopAllInteractiveTagsVM th() {
        Object value = this.vm.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-vm>(...)");
        return (TroopAllInteractiveTagsVM) value;
    }

    private final void uh() {
        LiveData<ArrayList<GroupIdentityInteractionTag>> R1 = th().R1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<ArrayList<GroupIdentityInteractionTag>, Unit> function1 = new Function1<ArrayList<GroupIdentityInteractionTag>, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopAllInteractiveTagsFragment$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAllInteractiveTagsFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<GroupIdentityInteractionTag> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<GroupIdentityInteractionTag> tags) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) tags);
                    return;
                }
                TroopAllInteractiveTagsFragment troopAllInteractiveTagsFragment = TroopAllInteractiveTagsFragment.this;
                Intrinsics.checkNotNullExpressionValue(tags, "tags");
                troopAllInteractiveTagsFragment.xh(tags);
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopAllInteractiveTagsFragment.vh(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> T1 = th().T1();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit> function12 = new Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopAllInteractiveTagsFragment$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAllInteractiveTagsFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                TroopAllInteractiveTagsVM th5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                    return;
                }
                if (cVar instanceof c.b) {
                    TroopAllInteractiveTagsFragment troopAllInteractiveTagsFragment = TroopAllInteractiveTagsFragment.this;
                    th5 = troopAllInteractiveTagsFragment.th();
                    ArrayList<GroupIdentityInteractionTag> value = th5.R1().getValue();
                    if (value == null) {
                        value = new ArrayList<>();
                    }
                    troopAllInteractiveTagsFragment.xh(value);
                }
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopAllInteractiveTagsFragment.wh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xh(List<GroupIdentityInteractionTag> tags) {
        List<GroupIdentityInteractionTag> list = tags;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((GroupIdentityInteractionTag) obj).isObtained) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (!((GroupIdentityInteractionTag) obj2).isObtained) {
                arrayList2.add(obj2);
            }
        }
        com.tencent.mobileqq.troop.troopidentity.view.alltags.c cVar = this.adapter;
        if (cVar != null) {
            cVar.n0(arrayList, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.fzc;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        ArrayList<GroupIdentityInteractionTag> value = th().R1().getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        for (GroupIdentityInteractionTag groupIdentityInteractionTag : value) {
            if (groupIdentityInteractionTag.isSet) {
                bundle.putString("selected_identity_interaction_id", groupIdentityInteractionTag.interactionTagId);
                intent.putExtra("selected_identity_interaction_id", groupIdentityInteractionTag.interactionTagId);
            }
        }
        FragmentKt.setFragmentResult(this, "selected_identity_interaction_id", bundle);
        getQBaseActivity().setResult(-1, intent);
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            th().P1().f(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TroopAllInteractiveTagsVM th5 = th();
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        th5.init(arguments);
        initView(view);
        uh();
        th().P1().f(true);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }
}
