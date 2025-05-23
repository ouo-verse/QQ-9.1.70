package com.tencent.mobileqq.search.business.contact.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b1\u00102J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/ContactsSearchPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/search/business/contact/part/m;", "", ViewStickEventHelper.IS_SHOW, "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "firstUIType", "", "H9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "C7", "v", "b", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "d", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "getViewmodel", "()Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "viewmodel", "Lhp2/b;", "e", "Lhp2/b;", "binding", "Lcom/tencent/mobileqq/search/business/contact/part/b;", "f", "Lcom/tencent/mobileqq/search/business/contact/part/b;", "adapter", "Lcom/tencent/mobileqq/search/view/d;", tl.h.F, "Lcom/tencent/mobileqq/search/view/d;", "onActionListener", "i", "Z", "isScrolling", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "emptyView", "Lcom/tencent/mobileqq/search/k;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/k;", "selectOperationIoc", "<init>", "(Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;)V", "D", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ContactsSearchPart extends Part implements m {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.k selectOperationIoc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ContactsSearchViewmodel viewmodel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private hp2.b binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.business.contact.part.b adapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.view.d onActionListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isScrolling;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View emptyView;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/search/business/contact/part/ContactsSearchPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                ContactsSearchPart.this.isScrolling = false;
            } else if (newState == 1 && !ContactsSearchPart.this.isScrolling) {
                InputMethodUtil.hide(recyclerView);
                ContactsSearchPart.this.isScrolling = true;
            }
        }
    }

    public ContactsSearchPart(@NotNull ContactsSearchViewmodel viewmodel) {
        Intrinsics.checkNotNullParameter(viewmodel, "viewmodel");
        this.viewmodel = viewmodel;
        this.adapter = new com.tencent.mobileqq.search.business.contact.part.b(new d(), new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(boolean isShow, UIType firstUIType) {
        View view;
        if (isShow) {
            View view2 = this.emptyView;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(firstUIType, UIType.d.f282919a) && (view = this.emptyView) != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.search.business.contact.part.m
    public void C7() {
        QLog.d("ContactsBuddySearchPart", 1, "onClickContactsCollapse");
        this.viewmodel.W1();
    }

    @Override // com.tencent.mobileqq.search.business.contact.part.m
    public void b(@NotNull View v3) {
        UIType.b bVar;
        com.tencent.mobileqq.search.k kVar;
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!Intrinsics.areEqual(this.viewmodel.a2().getValue(), Boolean.TRUE)) {
            com.tencent.mobileqq.search.view.d dVar = this.onActionListener;
            if (dVar != null) {
                dVar.onAction(v3);
            }
            if (com.tencent.mobileqq.search.business.contact.i.e(this.viewmodel) && (kVar = this.selectOperationIoc) != null) {
                kVar.a(false);
                return;
            }
            return;
        }
        Object tag = v3.getTag(R.id.f1194676x);
        com.tencent.mobileqq.search.model.k kVar2 = null;
        if (tag instanceof UIType.b) {
            bVar = (UIType.b) tag;
        } else {
            bVar = null;
        }
        Object tag2 = v3.getTag(R.id.kxb);
        if (tag2 instanceof com.tencent.mobileqq.search.model.k) {
            kVar2 = (com.tencent.mobileqq.search.model.k) tag2;
        }
        if (bVar != null && kVar2 != null) {
            if (bVar.getCheckStatus().isChecked()) {
                String l3 = kVar2.l();
                int M = kVar2.M();
                com.tencent.mobileqq.search.view.d dVar2 = this.onActionListener;
                if (dVar2 != null) {
                    dVar2.selectedItemClick(l3, M, true);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.search.view.d dVar3 = this.onActionListener;
            if (dVar3 != null) {
                dVar3.onAction(v3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.NO_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.adapter});
        if (rootView != null) {
            hp2.b e16 = hp2.b.e(rootView);
            this.binding = e16;
            Intrinsics.checkNotNull(e16);
            e16.f405630c.setLayoutManager(new SafeLinearLayoutManager(getContext(), 1, false));
            e16.f405630c.setAdapter(rFWConcatAdapter);
            e16.f405630c.setItemAnimator(null);
            e16.f405630c.addOnScrollListener(new b());
            RFWIocAbilityProvider.g().registerIoc(e16.f405630c, this, m.class);
            QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setBackgroundColorType(0).setImageType(9).setTitle("\u65e0\u641c\u7d22\u7ed3\u679c").build();
            if (build != null) {
                build.setId(R.id.bww);
            }
            e16.f405629b.addView(build, -2, -2);
            LinearLayout linearLayout = e16.f405629b;
            this.emptyView = linearLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        Bundle arguments;
        com.tencent.mobileqq.search.view.d dVar;
        LifecycleOwner hostLifecycleOwner;
        super.onPartCreate(activity, savedInstanceState);
        IPartHost partHost = getPartHost();
        if (partHost != null && (hostLifecycleOwner = partHost.getHostLifecycleOwner()) != null) {
            LiveData<Pair<List<UIType>, Boolean>> b26 = this.viewmodel.b2();
            final ContactsSearchPart$onPartCreate$1$1 contactsSearchPart$onPartCreate$1$1 = new ContactsSearchPart$onPartCreate$1$1(this);
            b26.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.business.contact.part.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContactsSearchPart.F9(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> a26 = this.viewmodel.a2();
            final ContactsSearchPart$onPartCreate$1$2 contactsSearchPart$onPartCreate$1$2 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.part.ContactsSearchPart$onPartCreate$1$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }
            };
            a26.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.business.contact.part.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContactsSearchPart.G9(Function1.this, obj);
                }
            });
        }
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (arguments = hostFragment.getArguments()) != null) {
            long j3 = arguments.getLong("contactSearchOnActionListener", -1L);
            com.tencent.mobileqq.search.k kVar = null;
            if (j3 != -1) {
                Object c16 = rn2.b.b().c(j3);
                if (c16 instanceof com.tencent.mobileqq.search.view.d) {
                    dVar = (com.tencent.mobileqq.search.view.d) c16;
                } else {
                    dVar = null;
                }
                this.onActionListener = dVar;
                if (dVar == null) {
                    QLog.e("ContactsBuddySearchPart", 1, "onActionListener is null!! may re created");
                }
            }
            long j16 = arguments.getLong("contactSearchOperationIoc", -1L);
            if (j16 > 0) {
                Object c17 = rn2.b.b().c(j16);
                if (c17 instanceof com.tencent.mobileqq.search.k) {
                    kVar = (com.tencent.mobileqq.search.k) c17;
                }
                this.selectOperationIoc = kVar;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        RecyclerView recyclerView;
        super.onPartDestroy(activity);
        hp2.b bVar = this.binding;
        if (bVar != null) {
            RFWIocAbilityProvider.g().unregisterSingleIoc(bVar.f405630c, m.class);
        }
        hp2.b bVar2 = this.binding;
        if (bVar2 != null && (recyclerView = bVar2.f405630c) != null) {
            recyclerView.clearOnScrollListeners();
        }
    }
}
