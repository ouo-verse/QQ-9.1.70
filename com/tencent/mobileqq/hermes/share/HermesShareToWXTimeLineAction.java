package com.tencent.mobileqq.hermes.share;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.hermes.share.HermesShareActionManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/HermesShareToWXTimeLineAction;", "Lcom/tencent/mobileqq/hermes/share/HermesAbsShareAction;", "", "filePath", "Lcom/tencent/mobileqq/hermes/share/k;", "shareContext", "", "l", "", "f", "", "", "e", "Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager$ShareLine;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "getMWXShareListener", "()Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "setMWXShareListener", "(Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;)V", "mWXShareListener", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class HermesShareToWXTimeLineAction extends HermesAbsShareAction {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WXShareHelper.a mWXShareListener;

    public HermesShareToWXTimeLineAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String filePath, k shareContext) {
        if (this.mWXShareListener == null) {
            this.mWXShareListener = new WXShareHelper.a() { // from class: com.tencent.mobileqq.hermes.share.m
                @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                public final void onWXShareResp(BaseResp baseResp) {
                    HermesShareToWXTimeLineAction.m(baseResp);
                }
            };
            WXShareHelper.b0().A(this.mWXShareListener);
        }
        WXShareHelper.b0().u0(filePath, shareContext.f(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(BaseResp baseResp) {
        if (baseResp.errCode != 0) {
            QQToastUtil.showQQToast(1, R.string.f158811qm);
        }
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    public void b(@NotNull k shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) shareContext, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(c(), null, null, new HermesShareToWXTimeLineAction$doAction$1(this, shareContext, null), 3, null);
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    @NotNull
    public HermesShareActionManager.ShareLine d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HermesShareActionManager.ShareLine) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return HermesShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    @NotNull
    public List<Integer> e() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(10);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (WXShareHelper.b0().e0() && WXShareHelper.b0().f0()) {
            return true;
        }
        return false;
    }
}
