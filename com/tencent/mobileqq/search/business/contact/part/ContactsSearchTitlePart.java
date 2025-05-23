package com.tencent.mobileqq.search.business.contact.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/ContactsSearchTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "isMultiSelect", "", "E9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "d", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "getViewmodel", "()Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "viewmodel", "e", "Landroid/view/View;", "contentView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "multiSelectView", "Lcom/tencent/mobileqq/search/k;", tl.h.F, "Lcom/tencent/mobileqq/search/k;", "selectOperationIoc", "<init>", "(Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;)V", "i", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ContactsSearchTitlePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ContactsSearchViewmodel viewmodel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView multiSelectView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.k selectOperationIoc;

    public ContactsSearchTitlePart(@NotNull ContactsSearchViewmodel viewmodel) {
        Intrinsics.checkNotNullParameter(viewmodel, "viewmodel");
        this.viewmodel = viewmodel;
    }

    private final void E9(boolean isMultiSelect) {
        TextView textView = this.multiSelectView;
        if (textView == null) {
            return;
        }
        if (isMultiSelect) {
            com.tencent.mobileqq.search.report.a.i(com.tencent.mobileqq.search.report.a.f283716a, textView, "em_bas_end_multiple", null, false, null, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_NONE, 0.0d, 284, null);
        } else {
            com.tencent.mobileqq.search.report.a.i(com.tencent.mobileqq.search.report.a.f283716a, textView, "em_bas_multiple", null, false, null, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_NONE, 0.0d, 284, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(ContactsSearchTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.multiSelectView;
        if (textView != null) {
            boolean areEqual = Intrinsics.areEqual(this$0.viewmodel.a2().getValue(), Boolean.TRUE);
            com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
            com.tencent.mobileqq.search.report.a.f(aVar, "clck", textView, null, 4, null);
            this$0.E9(!areEqual);
            this$0.viewmodel.p2(!areEqual);
            if (areEqual) {
                com.tencent.mobileqq.search.k kVar = this$0.selectOperationIoc;
                if (kVar != null) {
                    kVar.a(false);
                }
            } else {
                com.tencent.mobileqq.search.k kVar2 = this$0.selectOperationIoc;
                if (kVar2 != null) {
                    kVar2.b(true);
                }
                com.tencent.mobileqq.search.report.a.f(aVar, "imp", textView, null, 4, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        List list;
        boolean z16;
        TextView textView;
        View view;
        View view2;
        Object firstOrNull;
        if (Intrinsics.areEqual(action, "action_send_uin_list")) {
            if (args instanceof List) {
                list = (List) args;
            } else {
                list = null;
            }
            if (list == null) {
                return;
            }
            boolean z17 = true;
            int i3 = 0;
            if (!list.isEmpty()) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                if (!Intrinsics.areEqual(firstOrNull, UIType.d.f282919a)) {
                    z16 = true;
                    textView = this.multiSelectView;
                    if (textView != null && z16) {
                        view2 = this.contentView;
                        if (view2 != null || view2.getVisibility() != 8) {
                            z17 = false;
                        }
                        if (z17) {
                            com.tencent.mobileqq.search.report.a.f(com.tencent.mobileqq.search.report.a.f283716a, "imp", textView, null, 4, null);
                        }
                    }
                    view = this.contentView;
                    if (view == null) {
                        if (!z16) {
                            i3 = 8;
                        }
                        view.setVisibility(i3);
                        return;
                    }
                    return;
                }
            }
            z16 = false;
            textView = this.multiSelectView;
            if (textView != null) {
                view2 = this.contentView;
                if (view2 != null) {
                }
                z17 = false;
                if (z17) {
                }
            }
            view = this.contentView;
            if (view == null) {
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        super.onInitView(rootView);
        TextView textView = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f81234dm);
        } else {
            view = null;
        }
        this.contentView = view;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.business.contact.part.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ContactsSearchTitlePart.F9(view2);
                }
            });
        }
        if (this.multiSelectView == null) {
            if (rootView != null) {
                textView = (TextView) rootView.findViewById(R.id.zij);
            }
            this.multiSelectView = textView;
            if (textView != null) {
                com.tencent.mobileqq.search.util.l.b(textView, com.tencent.mobileqq.search.util.l.d(15));
            }
        }
        TextView textView2 = this.multiSelectView;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.business.contact.part.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ContactsSearchTitlePart.G9(ContactsSearchTitlePart.this, view2);
                }
            });
        }
        E9(false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        Bundle arguments;
        com.tencent.mobileqq.search.k kVar;
        LifecycleOwner lifecycleOwner;
        super.onPartCreate(activity, savedInstanceState);
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null) {
            MutableLiveData<Boolean> a26 = this.viewmodel.a2();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.part.ContactsSearchTitlePart$onPartCreate$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean isMultiSelect) {
                    TextView textView;
                    String string;
                    textView = ContactsSearchTitlePart.this.multiSelectView;
                    if (textView != null) {
                        ContactsSearchTitlePart contactsSearchTitlePart = ContactsSearchTitlePart.this;
                        Intrinsics.checkNotNullExpressionValue(isMultiSelect, "isMultiSelect");
                        if (isMultiSelect.booleanValue()) {
                            string = contactsSearchTitlePart.getContext().getString(R.string.f224706jn);
                        } else {
                            string = contactsSearchTitlePart.getContext().getString(R.string.cee);
                        }
                        textView.setText(string);
                    }
                }
            };
            a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.business.contact.part.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContactsSearchTitlePart.H9(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> f26 = this.viewmodel.f2();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.part.ContactsSearchTitlePart$onPartCreate$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean isShowing) {
                    TextView textView;
                    View view;
                    textView = ContactsSearchTitlePart.this.multiSelectView;
                    if (textView != null) {
                        ContactsSearchTitlePart contactsSearchTitlePart = ContactsSearchTitlePart.this;
                        Intrinsics.checkNotNullExpressionValue(isShowing, "isShowing");
                        if (isShowing.booleanValue()) {
                            view = contactsSearchTitlePart.contentView;
                            boolean z16 = false;
                            if (view != null && view.getVisibility() == 0) {
                                z16 = true;
                            }
                            if (z16) {
                                com.tencent.mobileqq.search.report.a.f(com.tencent.mobileqq.search.report.a.f283716a, "imp", textView, null, 4, null);
                            }
                        }
                    }
                }
            };
            f26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.business.contact.part.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ContactsSearchTitlePart.I9(Function1.this, obj);
                }
            });
        }
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (arguments = hostFragment.getArguments()) != null) {
            long j3 = arguments.getLong("contactSearchOperationIoc", -1L);
            if (j3 > 0) {
                Object c16 = rn2.b.b().c(j3);
                if (c16 instanceof com.tencent.mobileqq.search.k) {
                    kVar = (com.tencent.mobileqq.search.k) c16;
                } else {
                    kVar = null;
                }
                this.selectOperationIoc = kVar;
            }
        }
    }
}
