package com.tencent.mobileqq.troop.teamup.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.publish.fragment.TroopTeamUpPublishFragment;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplateListItem;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplatesLayout;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTemplate;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\"\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u0015\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR'\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpTemplatesGalleryPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "template", "Lcom/tencent/mobileqq/widget/listitem/a;", "D9", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/troop/teamup/publish/vm/d;", "d", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/troop/teamup/publish/vm/d;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "e", "F9", "()Lcom/tencent/mobileqq/widget/listitem/x;", "customPublishConfig", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpTemplatesGalleryPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy customPublishConfig;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpTemplatesGalleryPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<com.tencent.mobileqq.troop.teamup.publish.vm.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.troop.teamup.publish.vm.d cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f299152e;

        public a(Part part) {
            this.f299152e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.teamup.publish.vm.d] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.teamup.publish.vm.d] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.troop.teamup.publish.vm.d getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            com.tencent.mobileqq.troop.teamup.publish.vm.d dVar = this.cached;
            Object partHost = this.f299152e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (dVar == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(com.tencent.mobileqq.troop.teamup.publish.vm.d.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return dVar;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public TroopTeamUpTemplatesGalleryPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.data = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(new TroopTeamUpTemplatesGalleryPart$customPublishConfig$2(this));
        this.customPublishConfig = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.a<?> D9(final TeamUpTemplate template) {
        TroopTeamUpTemplateListItem.a aVar = new TroopTeamUpTemplateListItem.a(template);
        aVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpTemplatesGalleryPart.E9(TroopTeamUpTemplatesGalleryPart.this, template, view);
            }
        });
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(TroopTeamUpTemplatesGalleryPart this$0, TeamUpTemplate template, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(template, "$template");
        TroopTeamUpPublishFragment.INSTANCE.a(this$0.G9().N1(), template, this$0.getActivity(), 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x<x.b.C8996b, x.c.g> F9() {
        return (x) this.customPublishConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.teamup.publish.vm.d G9() {
        return (com.tencent.mobileqq.troop.teamup.publish.vm.d) this.data.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopTeamUp.PublishTemplatesGalleryPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (Intrinsics.areEqual(TuplesKt.to(Integer.valueOf(requestCode & 65535), Integer.valueOf(resultCode)), TuplesKt.to(1, -1))) {
            if (data != null && data.getBooleanExtra("is_published", false)) {
                z16 = true;
            }
            if (z16 && (activity = getActivity()) != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        final QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, true, false, 4, null);
        MutableLiveData<List<TeamUpTemplate>> M1 = G9().M1();
        LifecycleOwner a16 = com.tencent.mobileqq.troop.troopsetting.part.i.a(this);
        Intrinsics.checkNotNull(a16);
        final Function1<List<? extends TeamUpTemplate>, Unit> function1 = new Function1<List<? extends TeamUpTemplate>, Unit>(this) { // from class: com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpTemplatesGalleryPart$onInitView$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TroopTeamUpTemplatesGalleryPart this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItemAdapter.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends TeamUpTemplate> list) {
                invoke2((List<TeamUpTemplate>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<TeamUpTemplate> list) {
                x F9;
                int collectionSizeOrDefault;
                com.tencent.mobileqq.widget.listitem.a D9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                QUIListItemAdapter qUIListItemAdapter2 = QUIListItemAdapter.this;
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                F9 = this.this$0.F9();
                spreadBuilder.add(new Group(F9));
                Intrinsics.checkNotNullExpressionValue(list, "list");
                List<TeamUpTemplate> list2 = list;
                TroopTeamUpTemplatesGalleryPart troopTeamUpTemplatesGalleryPart = this.this$0;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    D9 = troopTeamUpTemplatesGalleryPart.D9((TeamUpTemplate) it.next());
                    arrayList.add(new Group(D9));
                }
                Object[] array = arrayList.toArray(new Group[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                spreadBuilder.addSpread(array);
                qUIListItemAdapter2.t0((Group[]) spreadBuilder.toArray(new Group[spreadBuilder.size()]));
            }
        };
        M1.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpTemplatesGalleryPart.H9(Function1.this, obj);
            }
        });
        ((TroopTeamUpTemplatesLayout) rootView).A0().setAdapter(qUIListItemAdapter);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            G9().P1();
        }
    }
}
