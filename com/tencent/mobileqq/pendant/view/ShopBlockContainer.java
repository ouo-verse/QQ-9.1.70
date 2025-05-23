package com.tencent.mobileqq.pendant.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import b03.a;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ShopBlockContainer extends BlockContainer {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AvatarShopItemBlockAdapter f257569d;

    public ShopBlockContainer(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public AvatarShopItemBlockAdapter a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AvatarShopItemBlockAdapter) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f257569d;
    }

    public void b(Fragment fragment, AvatarShopItemBlockAdapter.b bVar, PendantAvatarShopLayout pendantAvatarShopLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, fragment, bVar, pendantAvatarShopLayout);
            return;
        }
        setParentFragment(fragment);
        setLayoutManagerType(2, 3);
        setPadding(ViewUtils.dip2px(12.0f), 0, ViewUtils.dip2px(12.0f), 0);
        AvatarShopItemBlockAdapter avatarShopItemBlockAdapter = new AvatarShopItemBlockAdapter(null, pendantAvatarShopLayout);
        this.f257569d = avatarShopItemBlockAdapter;
        avatarShopItemBlockAdapter.M0(bVar);
        registerBlock(this.f257569d);
        setEnableRefresh(false);
        setEnableLoadMore(true);
        NestScrollRecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnChildAttachStateChangeListener(this.f257569d);
        }
        start();
    }

    public void setAvatarPendantItems(a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, i3);
        } else {
            this.f257569d.L0(aVar, i3);
        }
    }

    public ShopBlockContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ShopBlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
