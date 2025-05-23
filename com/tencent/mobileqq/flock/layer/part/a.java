package com.tencent.mobileqq.flock.layer.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.libra.IPicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R&\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00070\b0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR(\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\r0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR(\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\r0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/flock/layer/part/a;", "Lcom/tencent/mobileqq/flock/base/e;", "Lcom/tencent/richframework/gallery/delegate/outer/IDelegateAndSectionProvider;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegate;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getExtDelegates", "()Ljava/util/List;", "extDelegates", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "getExtPicSections", "extPicSections", "getExtVideoSections", "extVideoSections", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends com.tencent.mobileqq.flock.base.e implements IDelegateAndSectionProvider {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> getExtDelegates() {
        List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtPicSections() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mobileqq.flock.layer.section.a.class);
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtVideoSections() {
        List<Class<? extends Section<RFWLayerItemMediaInfo>>> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        IPicLoader b16 = com.tencent.mobileqq.flock.picloader.a.a().b();
        Intrinsics.checkNotNullExpressionValue(b16, "g().innerPicLoader");
        RFWLayerIOCUtil.registerPicLoader(rootView, b16);
        RFWLayerIOCUtil.registerSectionProvider(rootView, this);
    }
}
