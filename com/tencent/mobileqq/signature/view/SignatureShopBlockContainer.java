package com.tencent.mobileqq.signature.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.signature.SignatureShopControl;
import com.tencent.mobileqq.signature.adapter.SignatureShopItemBlockAdapter;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SignatureShopBlockContainer extends BlockContainer {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private SignatureShopItemBlockAdapter f288485d;

    public SignatureShopBlockContainer(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public SignatureShopItemBlockAdapter a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SignatureShopItemBlockAdapter) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f288485d;
    }

    public void b(Fragment fragment, SignatureShopItemBlockAdapter.a aVar, SignatureShopControl signatureShopControl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, fragment, aVar, signatureShopControl);
            return;
        }
        setParentFragment(fragment);
        setLayoutManagerType(2, 3);
        setPadding(ViewUtils.dip2px(12.0f), 0, ViewUtils.dip2px(12.0f), 0);
        SignatureShopItemBlockAdapter signatureShopItemBlockAdapter = new SignatureShopItemBlockAdapter(null, signatureShopControl);
        this.f288485d = signatureShopItemBlockAdapter;
        signatureShopItemBlockAdapter.s0(aVar);
        registerBlock(this.f288485d);
        setEnableRefresh(false);
        setEnableLoadMore(true);
        NestScrollRecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnChildAttachStateChangeListener(this.f288485d);
        }
        start();
    }

    public void setAvatarPendantItems(b03.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, i3);
        } else {
            this.f288485d.r0(aVar, i3);
        }
    }

    public SignatureShopBlockContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SignatureShopBlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
