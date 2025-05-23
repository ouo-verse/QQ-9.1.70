package com.tencent.mobileqq.selectfriend.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectfriend.model.FSLayoutData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0004J\b\u0010\u000f\u001a\u00020\u000eH\u0004J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0004J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0004R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010R\u001a\u0004\u0018\u00010K8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR,\u0010Z\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010S8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010i\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010h\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "", "K9", "initViewModel", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "J9", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "", "action", "L9", "", "I9", "x9", "actionId", "M9", "Ldq2/a;", "d", "Ldq2/a;", "B9", "()Ldq2/a;", "N9", "(Ldq2/a;)V", "mForwardFriendHomeViewModel", "Ldq2/d;", "e", "Ldq2/d;", "getMRecentChatListViewModel", "()Ldq2/d;", "Q9", "(Ldq2/d;)V", "mRecentChatListViewModel", "Ldq2/e;", "f", "Ldq2/e;", "getMRecentForwardGridViewModel", "()Ldq2/e;", "R9", "(Ldq2/e;)V", "mRecentForwardGridViewModel", "Ldq2/b;", tl.h.F, "Ldq2/b;", "E9", "()Ldq2/b;", "O9", "(Ldq2/b;)V", "mHomeTitleBarViewModel", "Ldq2/g;", "i", "Ldq2/g;", "H9", "()Ldq2/g;", "T9", "(Ldq2/g;)V", "mSelectedAndSearchViewModel", "Ldq2/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ldq2/f;", "G9", "()Ldq2/f;", "S9", "(Ldq2/f;)V", "mSearchResultViewModel", "Ldq2/c;", BdhLogUtil.LogTag.Tag_Conn, "Ldq2/c;", "F9", "()Ldq2/c;", "P9", "(Ldq2/c;)V", "mRecentChatHeadViewModel", "Lcom/tencent/mobileqq/app/QQAppInterface;", "D", "Lcom/tencent/mobileqq/app/QQAppInterface;", "z9", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "setMApp", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "mApp", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "E", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "C9", "()Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "setMFsForwardData", "(Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;)V", "mFsForwardData", "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "D9", "()Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "setMFsLayoutData", "(Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;)V", "mFsLayoutData", "G", "Landroid/os/Bundle;", "A9", "()Landroid/os/Bundle;", "setMExtraData", "(Landroid/os/Bundle;)V", "mExtraData", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class a extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    protected dq2.c mRecentChatHeadViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private QQAppInterface mApp;

    /* renamed from: E, reason: from kotlin metadata */
    private FSForwardData<Bundle> mFsForwardData;

    /* renamed from: F, reason: from kotlin metadata */
    private FSLayoutData mFsLayoutData;

    /* renamed from: G, reason: from kotlin metadata */
    private Bundle mExtraData = new Bundle();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected dq2.a mForwardFriendHomeViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected dq2.d mRecentChatListViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected dq2.e mRecentForwardGridViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected dq2.b mHomeTitleBarViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected dq2.g mSelectedAndSearchViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected dq2.f mSearchResultViewModel;

    private final void K9() {
        Bundle extras = getActivity().getIntent().getExtras();
        Object obj = extras != null ? extras.get("fs_forward_data_obj") : null;
        if (obj != null && (obj instanceof FSForwardData)) {
            this.mFsForwardData = (FSForwardData) obj;
        }
        Bundle extras2 = getActivity().getIntent().getExtras();
        Object obj2 = extras2 != null ? extras2.get("fs_forward_layout_obj") : null;
        if (obj2 != null && (obj2 instanceof FSLayoutData)) {
            this.mFsLayoutData = (FSLayoutData) obj2;
        }
        FSForwardData<Bundle> fSForwardData = this.mFsForwardData;
        this.mExtraData = fSForwardData != null ? fSForwardData.b() : null;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(dq2.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(\n          \u2026del::class.java\n        )");
        N9((dq2.a) viewModel);
        ViewModel viewModel2 = getViewModel(dq2.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(\n          \u2026del::class.java\n        )");
        Q9((dq2.d) viewModel2);
        ViewModel viewModel3 = getViewModel(dq2.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(\n          \u2026del::class.java\n        )");
        R9((dq2.e) viewModel3);
        ViewModel viewModel4 = getViewModel(dq2.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel4, "getViewModel(\n          \u2026del::class.java\n        )");
        O9((dq2.b) viewModel4);
        ViewModel viewModel5 = getViewModel(dq2.g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel5, "getViewModel(\n          \u2026del::class.java\n        )");
        T9((dq2.g) viewModel5);
        ViewModel viewModel6 = getViewModel(dq2.f.class);
        Intrinsics.checkNotNullExpressionValue(viewModel6, "getViewModel(\n          \u2026del::class.java\n        )");
        S9((dq2.f) viewModel6);
        ViewModel viewModel7 = getViewModel(dq2.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel7, "getViewModel(\n          \u2026del::class.java\n        )");
        P9((dq2.c) viewModel7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A9, reason: from getter */
    public final Bundle getMExtraData() {
        return this.mExtraData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final dq2.a B9() {
        dq2.a aVar = this.mForwardFriendHomeViewModel;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FSForwardData<Bundle> C9() {
        return this.mFsForwardData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D9, reason: from getter */
    public final FSLayoutData getMFsLayoutData() {
        return this.mFsLayoutData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final dq2.b E9() {
        dq2.b bVar = this.mHomeTitleBarViewModel;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHomeTitleBarViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final dq2.c F9() {
        dq2.c cVar = this.mRecentChatHeadViewModel;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRecentChatHeadViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final dq2.f G9() {
        dq2.f fVar = this.mSearchResultViewModel;
        if (fVar != null) {
            return fVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final dq2.g H9() {
        dq2.g gVar = this.mSelectedAndSearchViewModel;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedAndSearchViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int I9() {
        Bundle bundle = this.mExtraData;
        if (bundle != null) {
            Intrinsics.checkNotNull(bundle);
            if (bundle.getBoolean("isFromShare")) {
                return 2;
            }
        }
        Bundle bundle2 = this.mExtraData;
        if (bundle2 != null) {
            Intrinsics.checkNotNull(bundle2);
            if (bundle2.getBoolean("isWebCompShare")) {
                return 3;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L9(String action) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(action, "action");
        QQAppInterface qQAppInterface = this.mApp;
        String currentUin = qQAppInterface != null ? qQAppInterface.getCurrentUin() : null;
        dq2.a B9 = B9();
        if (!(B9 != null && B9.getMCurrentStatus() == 1)) {
            str = "1";
        } else {
            str = "2";
        }
        Bundle bundle = this.mExtraData;
        if (!(bundle != null && bundle.getBoolean("only_single_selection", false))) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        ReportController.n(qQAppInterface, "P_CliOper", "dc00898", currentUin, action, action, 0, 1, 0, str, str2, "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M9(String actionId) {
        Bundle bundle = this.mExtraData;
        if (bundle != null) {
            Intrinsics.checkNotNull(bundle);
            if (bundle.getBoolean("forward_source_from_shoot_quick", false)) {
                ReportController.o(this.mApp, "CliOper", "", "", actionId, actionId, 0, 0, "", "", "", "");
            }
        }
    }

    protected final void N9(dq2.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mForwardFriendHomeViewModel = aVar;
    }

    protected final void O9(dq2.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHomeTitleBarViewModel = bVar;
    }

    protected final void P9(dq2.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mRecentChatHeadViewModel = cVar;
    }

    protected final void Q9(dq2.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.mRecentChatListViewModel = dVar;
    }

    protected final void R9(dq2.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.mRecentForwardGridViewModel = eVar;
    }

    protected final void S9(dq2.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<set-?>");
        this.mSearchResultViewModel = fVar;
    }

    protected final void T9(dq2.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<set-?>");
        this.mSelectedAndSearchViewModel = gVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        J9(activity);
        K9();
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String x9() {
        Bundle bundle = this.mExtraData;
        String string = bundle != null ? bundle.getString(ForwardRecentActivity.KEY_FORWARD_BUSINESS_ID) : null;
        return TextUtils.isEmpty(string) ? "other" : string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: z9, reason: from getter */
    public final QQAppInterface getMApp() {
        return this.mApp;
    }

    private final void J9(Activity activity) {
        if (activity == null || !(activity instanceof AppActivity)) {
            return;
        }
        AppRuntime appRuntime = ((AppActivity) activity).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        this.mApp = (QQAppInterface) appRuntime;
    }
}
