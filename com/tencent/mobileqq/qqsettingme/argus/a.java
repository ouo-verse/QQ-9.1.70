package com.tencent.mobileqq.qqsettingme.argus;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.api.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQSettingMeRelativeLayout;
import com.tencent.richframework.QQArgusNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqsettingme/argus/a;", "Lcom/tencent/richframework/QQArgusNode;", "Lcom/tencent/mobileqq/widget/QQSettingMeRelativeLayout;", "Lcom/tencent/cache/api/d;", "getPageArgus", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, ParseCommon.CONTAINER, "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/widget/QQSettingMeRelativeLayout;)V", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends QQArgusNode<QQSettingMeRelativeLayout> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View rootView, @NotNull QQSettingMeRelativeLayout container) {
        super(rootView, container);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(container, "container");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rootView, (Object) container);
        }
    }

    @Override // com.tencent.richframework.QQArgusNode
    @NotNull
    public d getPageArgus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new d(Business.Setting, PageHierarchy.MainPage, null, 4, null);
    }
}
