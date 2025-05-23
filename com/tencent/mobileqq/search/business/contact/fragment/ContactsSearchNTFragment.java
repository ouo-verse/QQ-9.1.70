package com.tencent.mobileqq.search.business.contact.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcoroutine.api.coroutine.b;
import com.tencent.mobileqq.search.business.contact.j;
import com.tencent.mobileqq.search.business.contact.part.ContactsSearchPart;
import com.tencent.mobileqq.search.business.contact.part.ContactsSearchTitlePart;
import com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewModeParams;
import com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.search.searchdetail.r;
import com.tencent.mobileqq.search.view.d;
import com.tencent.mobileqq.search.view.f;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.avatar.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0014J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0014J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010 \u001a\u00020\u00032\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\u0012\u0010&\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001dH\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/fragment/ContactsSearchNTFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/search/view/f;", "", "qh", "", "", "vh", "", "multiSelect", "rh", "th", "uh", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onFragmentViewDestroyed", "bFilter", "z7", "filterGroupRobot", "e2", "lf", "", "selectedUinList", "joinedUinList", "B5", "Landroidx/fragment/app/Fragment;", "getFragment", "L5", "K9", "keyword", "startSearch", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "tb", "y8", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "D", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "viewModel", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "E", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "requestJob", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/search/business/contact/viewmodel/a;", "params", "<init>", "()V", "G", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ContactsSearchNTFragment extends QPublicBaseFragment implements f {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private ContactsSearchViewmodel viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b requestJob;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ContactsSearchViewModeParams params = new ContactsSearchViewModeParams(false, false, false, 0, 0, null, null, null, null, null, false, 0, false, InitSkin.DRAWABLE_COUNT, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018Jn\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/fragment/ContactsSearchNTFragment$a;", "", "", IProfileCardConst.KEY_FROM_TYPE, ForwardRecentActivity.KEY_SEARCH_SOURCE, "", "specifiedTroopUin", "", "hiddenUinSet", "Lcom/tencent/mobileqq/search/view/d;", "onActionListener", "combineType", "", VasWebReport.WEB_CORE_DATA_FLAGS, "", "currentIsMultiSelect", "isDefaultSingleMode", "Lcom/tencent/mobileqq/search/k;", "operationIoc", "Lcom/tencent/mobileqq/search/view/f;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.contact.fragment.ContactsSearchNTFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final f a(int fromType, int searchSource, @Nullable String specifiedTroopUin, @Nullable List<String> hiddenUinSet, @Nullable d onActionListener, int combineType, long filterType, boolean currentIsMultiSelect, boolean isDefaultSingleMode, @Nullable k operationIoc) {
            int checkRadix;
            if (r.n(fromType, searchSource)) {
                QLog.w("ContactsSearchNTFragment", 1, "can not use NT contacts filter");
                f yh5 = ContactSearchFragment.yh(fromType, searchSource, specifiedTroopUin, hiddenUinSet, onActionListener, combineType, filterType, true, isDefaultSingleMode, operationIoc);
                Intrinsics.checkNotNullExpressionValue(yh5, "newInstance(\n           \u2026tionIoc\n                )");
                return yh5;
            }
            if (QLog.isColorLevel()) {
                checkRadix = CharsKt__CharJVMKt.checkRadix(2);
                String num = Integer.toString(searchSource, checkRadix);
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                QLog.d("ContactsSearchNTFragment", 1, "fromType = [" + fromType + "], searchSource = [" + num + "], specifiedTroopUin = [" + specifiedTroopUin + "], hiddenUinSet = [" + hiddenUinSet + "], onActionListener = [" + onActionListener + "], combineType = [" + combineType + "], filterType = [" + filterType + "], currentIsMultiSelect = [" + currentIsMultiSelect + "] isDefaultSingleMode = [" + isDefaultSingleMode + "]");
            }
            ContactsSearchNTFragment contactsSearchNTFragment = new ContactsSearchNTFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, fromType);
            bundle.putInt("contactSearchSource", searchSource);
            bundle.putString("specifiedTroopUin", specifiedTroopUin);
            bundle.putInt("ContactCombineType", combineType);
            bundle.putBoolean("isMultiSelect", currentIsMultiSelect);
            bundle.putBoolean("contactSearchResultDefaultSingleMode", isDefaultSingleMode);
            if (hiddenUinSet != null) {
                Object[] array = hiddenUinSet.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                bundle.putStringArray("hiddenUinSet", (String[]) array);
            }
            if (onActionListener != null) {
                bundle.putLong("contactSearchOnActionListener", rn2.b.b().a(onActionListener));
            }
            if (operationIoc != null) {
                bundle.putLong("contactSearchOperationIoc", rn2.b.b().a(operationIoc));
            }
            if (filterType > 0) {
                bundle.putLong("contactSearchResultFilterType", filterType);
            }
            contactsSearchNTFragment.setArguments(bundle);
            return contactsSearchNTFragment;
        }

        Companion() {
        }
    }

    private final void qh() {
        Map<String, Object> mutableMapOf;
        View view = this.rootView;
        if (view != null) {
            com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("share_biz_src", "0"), TuplesKt.to("selector_type", vh(this.params.getFromType())));
            aVar.j(this, view, "pg_bas_selector_search_results", mutableMapOf, PageReportPolicy.REPORT_NONE);
        }
    }

    private final void rh(final boolean multiSelect) {
        this.params.w(multiSelect);
        if (this.viewModel != null) {
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.search.business.contact.fragment.a
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsSearchNTFragment.sh(ContactsSearchNTFragment.this, multiSelect);
                }
            });
        } else {
            QLog.w("ContactsSearchNTFragment", 1, "selectMode but fragment not created ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(ContactsSearchNTFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ContactsSearchViewmodel contactsSearchViewmodel = this$0.viewModel;
        if (contactsSearchViewmodel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            contactsSearchViewmodel = null;
        }
        contactsSearchViewmodel.p2(z16);
    }

    private final void th() {
        View view = this.rootView;
        if (view != null) {
            VideoReport.reportPgIn(view);
        }
    }

    private final void uh() {
        View view = this.rootView;
        if (view != null) {
            VideoReport.reportPgOut(view);
        }
    }

    private final String vh(int i3) {
        if (i3 != 6) {
            if (i3 != 7) {
                if (i3 != 8) {
                    return "0";
                }
                return "3";
            }
            return "1";
        }
        return "2";
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void B5(@Nullable List<String> selectedUinList, @Nullable List<String> joinedUinList) {
        this.params.j().clear();
        this.params.h().clear();
        if (selectedUinList != null && selectedUinList.size() > 0) {
            Iterator<String> it = selectedUinList.iterator();
            while (it.hasNext()) {
                this.params.j().add(it.next());
            }
        }
        if (joinedUinList != null && joinedUinList.size() > 0) {
            Iterator<String> it5 = joinedUinList.iterator();
            while (it5.hasNext()) {
                this.params.h().add(it5.next());
            }
        }
        ContactsSearchViewmodel contactsSearchViewmodel = this.viewModel;
        if (contactsSearchViewmodel != null) {
            if (contactsSearchViewmodel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                contactsSearchViewmodel = null;
            }
            contactsSearchViewmodel.l2();
        }
    }

    @Override // com.tencent.mobileqq.search.view.f
    public boolean K9() {
        return true;
    }

    @Override // com.tencent.mobileqq.search.view.f
    public boolean L5() {
        return this.params.getIsMultiSelect();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        ContactsSearchViewmodel contactsSearchViewmodel = this.viewModel;
        ContactsSearchViewmodel contactsSearchViewmodel2 = null;
        if (contactsSearchViewmodel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            contactsSearchViewmodel = null;
        }
        arrayList.add(new ContactsSearchPart(contactsSearchViewmodel));
        if (this.params.getIsDefaultSingleMode()) {
            ContactsSearchViewmodel contactsSearchViewmodel3 = this.viewModel;
            if (contactsSearchViewmodel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                contactsSearchViewmodel2 = contactsSearchViewmodel3;
            }
            arrayList.add(new ContactsSearchTitlePart(contactsSearchViewmodel2));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void e2(boolean filterGroupRobot) {
        this.params.q(filterGroupRobot);
        QLog.d("ContactsSearchNTFragment", 2, "setFilterGroupRobot " + filterGroupRobot + " ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.e4b;
    }

    @Override // com.tencent.mobileqq.search.view.f
    public boolean lf(boolean multiSelect) {
        if (this.params.getIsDefaultSingleMode()) {
            return false;
        }
        rh(multiSelect);
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        boolean z16;
        super.onCreate(savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(this).get(ContactsSearchViewmodel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026rchViewmodel::class.java)");
        this.viewModel = (ContactsSearchViewmodel) viewModel;
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i3 = arguments.getInt(IProfileCardConst.KEY_FROM_TYPE, -1);
            String[] stringArray = arguments.getStringArray("hiddenUinSet");
            boolean z17 = true;
            if (stringArray != null) {
                if (stringArray.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                }
            }
            if (!z17) {
                HashSet hashSet = new HashSet();
                Iterator it = ArrayIteratorKt.iterator(stringArray);
                while (it.hasNext()) {
                    hashSet.add((String) it.next());
                }
                this.params.u(hashSet);
            }
            int i16 = arguments.getInt("contactSearchSource", 0);
            ContactsSearchViewModeParams contactsSearchViewModeParams = this.params;
            contactsSearchViewModeParams.w(arguments.getBoolean("isMultiSelect", contactsSearchViewModeParams.getIsMultiSelect()));
            this.params.m(arguments.getInt("ContactCombineType", 0));
            this.params.s(arguments.getLong("contactSearchResultFilterType", -1L));
            this.params.p(arguments.getStringArrayList(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_FILTER_TROOP_UIN_LIST));
            this.params.o(arguments.getBoolean(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_FILTER_BLOCK_GROUP, false));
            ContactsSearchViewModeParams contactsSearchViewModeParams2 = this.params;
            String string = arguments.getString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN, "");
            Intrinsics.checkNotNullExpressionValue(string, "args.getString(ISelectMe\u2026TRA_CHOOSE_TROOP_UIN, \"\")");
            contactsSearchViewModeParams2.v(string);
            this.params.t(i3);
            this.params.n(arguments.getBoolean("contactSearchResultDefaultSingleMode", false));
            ContactsSearchViewmodel contactsSearchViewmodel = this.viewModel;
            if (contactsSearchViewmodel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                contactsSearchViewmodel = null;
            }
            contactsSearchViewmodel.e2(i3, i16, this.params);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.rootView = super.onCreateView(inflater, container, savedInstanceState);
        qh();
        View view = this.rootView;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        Job f16;
        super.onFragmentViewDestroyed();
        ContactsSearchViewmodel contactsSearchViewmodel = this.viewModel;
        if (contactsSearchViewmodel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            contactsSearchViewmodel = null;
        }
        contactsSearchViewmodel.destroy();
        b bVar = this.requestJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        g.d();
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void startSearch(@Nullable String keyword) {
        boolean z16;
        Boolean bool;
        long j3;
        Job f16;
        Job f17;
        QLog.d("ContactsSearchNTFragment", 1, "startSearch keyword = [" + keyword + "]");
        if (keyword != null && keyword.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("ContactsSearchNTFragment", 1, "startSearch empty keyword " + keyword);
            return;
        }
        if (this.viewModel == null) {
            QLog.e("ContactsSearchNTFragment", 1, "startSearch viewModel not isInitialized");
            return;
        }
        b bVar = this.requestJob;
        ContactsSearchViewmodel contactsSearchViewmodel = null;
        if (bVar != null && (f17 = bVar.f()) != null) {
            bool = Boolean.valueOf(f17.isActive());
        } else {
            bool = null;
        }
        b bVar2 = this.requestJob;
        if (bVar2 != null && (f16 = bVar2.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        j.c(keyword, true);
        ContactsSearchViewmodel contactsSearchViewmodel2 = this.viewModel;
        if (contactsSearchViewmodel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            contactsSearchViewmodel = contactsSearchViewmodel2;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            j3 = 100;
        } else {
            j3 = 0;
        }
        this.requestJob = contactsSearchViewmodel.g2(keyword, j3);
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void tb() {
        if (this.viewModel == null) {
            return;
        }
        th();
        ContactsSearchViewmodel contactsSearchViewmodel = this.viewModel;
        if (contactsSearchViewmodel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            contactsSearchViewmodel = null;
        }
        contactsSearchViewmodel.f2().postValue(Boolean.TRUE);
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void y8() {
        if (this.viewModel == null) {
            return;
        }
        uh();
        ContactsSearchViewmodel contactsSearchViewmodel = this.viewModel;
        if (contactsSearchViewmodel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            contactsSearchViewmodel = null;
        }
        contactsSearchViewmodel.f2().postValue(Boolean.FALSE);
        if (this.params.getIsDefaultSingleMode()) {
            rh(false);
        }
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void z7(boolean bFilter) {
        this.params.r(bFilter);
        QLog.d("ContactsSearchNTFragment", 2, "setFilterRobot " + bFilter + " ");
    }

    @Override // com.tencent.mobileqq.search.view.f
    @NotNull
    public Fragment getFragment() {
        return this;
    }
}
