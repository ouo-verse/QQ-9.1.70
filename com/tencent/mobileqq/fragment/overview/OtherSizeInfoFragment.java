package com.tencent.mobileqq.fragment.overview;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/fragment/overview/OtherSizeInfoFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initView", "qh", "", "useQUISecNavBar", "needBlur", "needImmersive", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recyclerView", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class OtherSizeInfoFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUISettingsRecyclerView recyclerView;

    public OtherSizeInfoFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void initView() {
        NTScanSpaceManager S = NTScanSpaceManager.S();
        Pair<String, String> d16 = com.tencent.mobileqq.app.message.messageclean.q.d(S.V().k());
        String str = d16.first + " " + d16.second;
        Pair<String, String> d17 = com.tencent.mobileqq.app.message.messageclean.q.d(S.V().j() - S.V().k());
        String str2 = d17.first + " " + d17.second;
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.i4m);
        this.recyclerView = qUISettingsRecyclerView;
        if (qUISettingsRecyclerView != null) {
            QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
            String string = getString(R.string.f228836ut);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.storage_other_file_desc)");
            String string2 = getString(R.string.f228536u0);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.storage_app_size)");
            x.b.d dVar = new x.b.d(string2);
            x.c.g gVar = new x.c.g(str, false, false, 6, null);
            gVar.f(false);
            Unit unit = Unit.INSTANCE;
            String string3 = getString(R.string.f228826us);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.storage_other_file)");
            x.b.d dVar2 = new x.b.d(string3);
            x.c.g gVar2 = new x.c.g(str2, false, false, 6, null);
            gVar2.f(false);
            qUIListItemAdapter.t0(new Group("", string, new com.tencent.mobileqq.widget.listitem.x(dVar, gVar), new com.tencent.mobileqq.widget.listitem.x(dVar2, gVar2)));
            qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        }
    }

    private final void qh() {
        Context context;
        QUISettingsRecyclerView qUISettingsRecyclerView;
        QUISettingsRecyclerView qUISettingsRecyclerView2;
        if (!needBlur() || this.quiSecNavBar == null || (context = getContext()) == null || (qUISettingsRecyclerView = this.recyclerView) == null) {
            return;
        }
        final int b16 = com.tencent.biz.qui.quisecnavbar.e.b(context);
        qUISettingsRecyclerView.setPadding(0, b16, 0, 0);
        qUISettingsRecyclerView.setClipToPadding(false);
        final boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        QUISecNavBar quiSecNavBar = this.quiSecNavBar;
        Intrinsics.checkNotNullExpressionValue(quiSecNavBar, "quiSecNavBar");
        if (isSettingPageNavNeedBlur) {
            qUISettingsRecyclerView2 = qUISettingsRecyclerView;
        } else {
            qUISettingsRecyclerView2 = null;
        }
        QUISecNavBar.setBlur$default(quiSecNavBar, isSettingPageNavNeedBlur, qUISettingsRecyclerView2, 0, 4, null);
        if (!isSettingPageNavNeedAlpha) {
            return;
        }
        if (isSettingPageNavNeedBlur) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
        qUISettingsRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.mobileqq.fragment.overview.f
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                OtherSizeInfoFragment.rh(b16, isSettingPageNavNeedBlur, this, view, i3, i16, i17, i18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(int i3, boolean z16, OtherSizeInfoFragment this$0, View view, int i16, int i17, int i18, int i19) {
        float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i26 = i3 / 2;
        if (i17 <= 0) {
            f16 = 0.0f;
        } else if (i17 < i26) {
            f16 = (i17 * 1.0f) / i26;
        } else {
            f16 = 1.0f;
        }
        if (z16) {
            this$0.quiSecNavBar.setTitleBlurAlpha(f16);
        } else {
            this$0.quiSecNavBar.setTitleAlpha(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.layout.e_j;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle(getString(R.string.f23189733));
        initView();
        qh();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
